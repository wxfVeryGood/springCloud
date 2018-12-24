package com.tdh.urlInterceptor.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tdh.urlInterceptor.annotation.Log;
import com.tdh.urlInterceptor.model.UrlInterceptorConfig;
import com.tdh.urlInterceptor.service.RedisService;
import com.tdh.urlInterceptor.service.UrlInterceptorConfigService;
import com.tdh.urlInterceptor.service.UrlService;

@Service
public class UrlServiceImpl implements UrlService {
    public static final String URL_INTERCEPTOR_KEY = "url.interceptor.key.";
    @Reference
    private UrlInterceptorConfigService urlInterceptorConfigService;

    @Reference
    private RedisService redisService;
    @Override
    public UrlInterceptorConfig getMatchConfig(HttpServletRequest request) {
        List<UrlInterceptorConfig> urlInterceptorConfig = urlInterceptorConfigService.getUrlInterceptorConfig();
        if (CollectionUtils.isEmpty(urlInterceptorConfig)) return null;
        // ant 风格匹配
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        for (UrlInterceptorConfig config : urlInterceptorConfig) {
            String url = config.getUrl();
            boolean isMatch = antPathMatcher.match(url, request.getRequestURI());
            if (isMatch) {
                return config;
            }
        }
        return null;
    }
    @Log
    @Override
    public boolean isLimit(String ip, UrlInterceptorConfig config, HttpServletRequest request) {
        long timeFrequency = getTimeFrequency(config);
        Long result = this.redisService.isLimit(URL_INTERCEPTOR_KEY + ip, timeFrequency, config.getMaxTimes());

        // 当等于 0 时， 表示该url进行限制访问
        return result == 0;
    }

    /**
     *  根据配置文件 获取拦截的时间
     * @param config
     * @return
     */
    public static long getTimeFrequency(UrlInterceptorConfig config) {
        String timeUnit = config.getTimeUnit();
        Integer timeFrequency = config.getTimeFrequency();
        if (StringUtils.isEmpty(timeUnit)) {
            return timeFrequency;
        }
        if (timeUnit.equalsIgnoreCase(TimeUnit.SECONDS.name())) {
            return timeFrequency;
        }
        if (timeUnit.equalsIgnoreCase(TimeUnit.HOURS.name())) {
            return timeFrequency * 60 * 60;
        }
        if (timeUnit.equalsIgnoreCase(TimeUnit.MINUTES.name())) {
            return timeFrequency * 60;
        }
        if (timeUnit.equalsIgnoreCase(TimeUnit.MILLISECONDS.name())) {
            return timeFrequency / 1000;
        }
        return timeFrequency;
    }

}

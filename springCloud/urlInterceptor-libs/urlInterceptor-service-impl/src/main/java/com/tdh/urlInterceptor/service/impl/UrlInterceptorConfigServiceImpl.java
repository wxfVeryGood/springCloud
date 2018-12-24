package com.tdh.urlInterceptor.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.tdh.urlInterceptor.dao.UrlInterceptorConfigDao;
import com.tdh.urlInterceptor.model.UrlInterceptorConfig;
import com.tdh.urlInterceptor.service.RedisService;
import com.tdh.urlInterceptor.service.UrlInterceptorConfigService;

//@Service
@org.springframework.stereotype.Service
public class UrlInterceptorConfigServiceImpl implements UrlInterceptorConfigService {

    private static final Logger logger = LoggerFactory.getLogger(UrlInterceptorConfigServiceImpl.class);

    private static final String CONFIG_KEY = "url.interceptor.config.key";
    private static final Long EXPIRE_TIME = 3600L;
    @Autowired
    private UrlInterceptorConfigDao urlInterceptorConfigDao;
    @Autowired
    private RedisService redisService;

    @Override
    public List<UrlInterceptorConfig> getUrlInterceptorConfig() {
        List<UrlInterceptorConfig> result = redisService.getRange(CONFIG_KEY, 0, -1);
        if (CollectionUtils.isEmpty(result)) {
            List<UrlInterceptorConfig> configs = this.urlInterceptorConfigDao.findAll();
            boolean flag = this.redisService.addList(CONFIG_KEY, configs, EXPIRE_TIME);
            if (!flag) {
                logger.error("Cache addition failed.");
            }
            return configs;
        }
        return result;
    }

    /**
     * 插入配置中的时间单位参考${@link java.util.concurrent.TimeUnit}
     * @param config
     * @return
     */
    @Override
    public int addUrlInterceptorConfig(UrlInterceptorConfig config) {
        return urlInterceptorConfigDao.insert(config);
    }

    @Override
    public int updateUrlInterceptorConfig(UrlInterceptorConfig config) {
        return urlInterceptorConfigDao.updateByPrimaryKeySelective(config);
    }

}

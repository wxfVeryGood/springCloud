package com.tdh.urlInterceptor.service;

import javax.servlet.http.HttpServletRequest;

import com.tdh.urlInterceptor.model.UrlInterceptorConfig;

public interface UrlService {
    /**
     *  根据请求， 获取匹配的拦截器配置
     * @param request
     * @return
     */
    UrlInterceptorConfig getMatchConfig(HttpServletRequest request);

    /**
     *  是否限制访问
     * @param config
     * @return
     */
    boolean isLimit(String ip, UrlInterceptorConfig config, HttpServletRequest request);
}

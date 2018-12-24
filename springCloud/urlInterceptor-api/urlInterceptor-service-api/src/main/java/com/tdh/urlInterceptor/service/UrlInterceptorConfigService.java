package com.tdh.urlInterceptor.service;

import java.util.List;

import com.tdh.urlInterceptor.model.UrlInterceptorConfig;

/**
 *  url配置服务接口
 *
 */
public interface UrlInterceptorConfigService {
    // 获取 url 拦截器配置
    List<UrlInterceptorConfig> getUrlInterceptorConfig();

    int addUrlInterceptorConfig(UrlInterceptorConfig config);

    int updateUrlInterceptorConfig(UrlInterceptorConfig config);

    //int deleteUrlInterceptorConfigById (Long id);
}

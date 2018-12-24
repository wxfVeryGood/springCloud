package com.tdh.urlInterceptor.service;

import java.util.List;

import com.tdh.urlInterceptor.model.UrlRequestLog;

/**
 * 拦截器日志服务
 */
public interface UrlInterceptorLogService {

    List<UrlRequestLog> getLogs();
    
    int addLog(UrlRequestLog log);
    
    int updateLog(UrlRequestLog log);

    UrlRequestLog getLatestLog(String requestURI);

    /**
     * 根据 IP url 修改 isValid 字段为失效状态
     * @param ip
     * @param requestURI
     * @return
     */
    int updateIsValid(String ip, String requestURI);
}

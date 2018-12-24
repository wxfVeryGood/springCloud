package com.tdh.urlInterceptor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tdh.urlInterceptor.dao.UrlReqeustLogDao;
import com.tdh.urlInterceptor.model.UrlRequestLog;
import com.tdh.urlInterceptor.service.UrlInterceptorLogService;
//@Service
@org.springframework.stereotype.Service
public class UrlInterceptorLogServiceImpl implements UrlInterceptorLogService {

    @Autowired
    private UrlReqeustLogDao urlReqeustLogDao;

    @Override
    public List<UrlRequestLog> getLogs() {
        UrlRequestLog log = new UrlRequestLog();
        return urlReqeustLogDao.selectByCondition(log);
    }

    @Override
    public int addLog(UrlRequestLog log) {
        return urlReqeustLogDao.insert(log);
    }

    @Override
    public int updateLog(UrlRequestLog log) {
        return urlReqeustLogDao.updateByPrimaryKeySelective(log);
    }

    @Override
    public UrlRequestLog getLatestLog(String uri) {
        return urlReqeustLogDao.getLatestLog(uri);
    }

    @Override
    public int updateIsValid(String ip, String requestURI) {
        return urlReqeustLogDao.updateIsValid(ip, requestURI);
    }
}

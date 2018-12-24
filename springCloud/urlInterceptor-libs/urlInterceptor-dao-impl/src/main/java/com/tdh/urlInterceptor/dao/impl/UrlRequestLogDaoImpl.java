package com.tdh.urlInterceptor.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tdh.urlInterceptor.dao.UrlReqeustLogDao;
import com.tdh.urlInterceptor.mapper.UrlRequestLogMapper;
import com.tdh.urlInterceptor.model.UrlRequestLog;

@Repository
@Transactional
public class UrlRequestLogDaoImpl implements UrlReqeustLogDao {
    @Autowired
    private UrlRequestLogMapper urlRequestLogMapper;
    @Override
    public int insert(UrlRequestLog urlInterceptorConfig) {
        return urlRequestLogMapper.insert(urlInterceptorConfig);
    }

    @Override
    public int insertSelective(UrlRequestLog record) {
        return urlRequestLogMapper.insertSelective(record);
    }

    @Override
    public UrlRequestLog selectByPrimaryKey(long uid) {
        return urlRequestLogMapper.selectByPrimaryKey(uid);
    }

    @Override
    public List<UrlRequestLog> selectByCondition(UrlRequestLog record) {
        return urlRequestLogMapper.selectByCondition(record);
    }

    @Override
    public int updateByPrimaryKeySelective(UrlRequestLog record) {
        return urlRequestLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UrlRequestLog record) {
        return urlRequestLogMapper.updateByPrimaryKey(record);
    }

    @Override
    public UrlRequestLog getLatestLog(String uri) {
        return urlRequestLogMapper.getLatestLog(uri);
    }

    @Override
    public int updateIsValid(String ip, String requestURI) {
        return urlRequestLogMapper.updateIsValid(ip,requestURI);
    }
}

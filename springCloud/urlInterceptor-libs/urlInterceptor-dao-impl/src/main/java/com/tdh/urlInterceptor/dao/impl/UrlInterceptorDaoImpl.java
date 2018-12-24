package com.tdh.urlInterceptor.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tdh.urlInterceptor.dao.UrlInterceptorConfigDao;
import com.tdh.urlInterceptor.mapper.UrlInterceptorConfigMapper;
import com.tdh.urlInterceptor.model.UrlInterceptorConfig;

@Repository
@Transactional
public class UrlInterceptorDaoImpl implements UrlInterceptorConfigDao {

    @Autowired
    private UrlInterceptorConfigMapper configMapper;

    /**
     *
     * @param urlInterceptorConfig
     * @return
     */
    @Override
    public int insert(UrlInterceptorConfig urlInterceptorConfig) {
        return configMapper.insert(urlInterceptorConfig);
    }

    @Override
    public int insertSelective(UrlInterceptorConfig record) {
        return configMapper.insertSelective(record);
    }

    @Override
    public UrlInterceptorConfig selectByPrimaryKey(long uid) {
        return configMapper.selectByPrimaryKey(uid);
    }

    @Override
    public List<UrlInterceptorConfig> selectByCondition(UrlInterceptorConfig record) {
        return configMapper.selectByCondition(record);
    }

    @Override
    public int updateByPrimaryKeySelective(UrlInterceptorConfig record) {
        return configMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<UrlInterceptorConfig> findAll() {
        return configMapper.findAll();
    }

    @Override
    public int updateByPrimaryKey(UrlInterceptorConfig record) {

        return configMapper.updateByPrimaryKey(record);
    }
}

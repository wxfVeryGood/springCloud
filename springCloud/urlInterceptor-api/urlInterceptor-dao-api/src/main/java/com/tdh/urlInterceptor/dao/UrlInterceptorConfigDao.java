package com.tdh.urlInterceptor.dao;


import java.util.List;

import com.tdh.urlInterceptor.model.UrlInterceptorConfig;

/**
 *  url 拦截器配置 mybatis 接口
 */
public interface UrlInterceptorConfigDao {
    /**
     * 插入拦截器配置文件
     * @param urlInterceptorConfig
     * @return
     */
    int insert(UrlInterceptorConfig urlInterceptorConfig);

    int insertSelective(UrlInterceptorConfig record);

    List<UrlInterceptorConfig> findAll();

    UrlInterceptorConfig selectByPrimaryKey(long uid);

    List<UrlInterceptorConfig> selectByCondition(UrlInterceptorConfig record);

    int updateByPrimaryKeySelective(UrlInterceptorConfig record);

    int updateByPrimaryKey(UrlInterceptorConfig record);
}

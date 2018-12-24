package com.tdh.urlInterceptor.model;

import java.io.Serializable;
import java.util.Date;

/**
 *  Url 拦截配置
 */
public class UrlInterceptorConfig implements Serializable {
    /**  
	 * @Fields serialVersionUID : (版本号) 
	 */  
	private static final long serialVersionUID = -7087097839342590840L;
	private Long id;
    private String url;
    private Integer maxTimes;      // 最大访问次数
    private String name;
    private Integer timeFrequency; // 时间频率，拦截的时间段
    private String timeUnit;       // 时间单位
    private Date createdTime;
    private Date updatedTime;
    private String createdBy;
    private String updatedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getMaxTimes() {
        return maxTimes;
    }

    public void setMaxTimes(Integer maxTimes) {
        this.maxTimes = maxTimes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimeFrequency() {
        return timeFrequency;
    }

    public void setTimeFrequency(Integer timeFrequency) {
        this.timeFrequency = timeFrequency;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}

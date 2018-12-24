package com.tdh.urlInterceptor.model;

import java.io.Serializable;
import java.util.Date;

/**
 *  url 拦截器的日志对象
 */
public class UrlRequestLog implements Serializable {

    /**  
	 * @Fields serialVersionUID : (版本号)
	 */  
	private static final long serialVersionUID = -955951593469765615L;
	private Long id;
    private Long urlInterceptorConfigId;
    private String url;
    private String requestIp;               // 请求IP
    private Integer requestTimes;           // 请求次数
    private Date startTime;                 // 开始时间
    private Date endTime;
    private Integer isValid;                // 是否有效， 1 有效 0 无效
    private Date createdTime;
    private String createdBy;
    private Date updatedTime;
    private String updatedBy;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUrlInterceptorConfigId() {
        return urlInterceptorConfigId;
    }

    public void setUrlInterceptorConfigId(Long urlInterceptorConfigId) {
        this.urlInterceptorConfigId = urlInterceptorConfigId;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public Integer getRequestTimes() {
        return requestTimes;
    }

    public void setRequestTimes(Integer requestTimes) {
        this.requestTimes = requestTimes;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}

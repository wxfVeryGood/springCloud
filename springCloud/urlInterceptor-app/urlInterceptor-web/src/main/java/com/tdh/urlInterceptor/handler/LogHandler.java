package com.tdh.urlInterceptor.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tdh.urlInterceptor.model.UrlInterceptorConfig;
import com.tdh.urlInterceptor.model.UrlRequestLog;
import com.tdh.urlInterceptor.service.RedisService;
import com.tdh.urlInterceptor.service.UrlInterceptorLogService;
import com.tdh.urlInterceptor.service.impl.UrlServiceImpl;

/**
 * 记录拦截器日志AOP
 */
@Aspect
@Component
public class LogHandler {

    @Reference
    private UrlInterceptorLogService urlInterceptorLogService;
    @Reference
    private RedisService redisService;

    @Pointcut("@annotation(com.tdh.urlInterceptor.annotation.Log)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object obj = proceedingJoinPoint.proceed();
        Object[] args = proceedingJoinPoint.getArgs();
        if (args.length == 3) {
            String ip = String.valueOf(args[0]);
            HttpServletRequest request = (HttpServletRequest) args[2];
            UrlInterceptorConfig config = (UrlInterceptorConfig) args[1];
            Object times = this.redisService.get(UrlServiceImpl.URL_INTERCEPTOR_KEY + ip);
            // 记录日志
            UrlRequestLog latestLog = this.urlInterceptorLogService.getLatestLog(request.getRequestURI());
            // 如果是第则添加一条日志记录
            if (latestLog == null) {
                addNewLog(ip, request, config, times);
            } else if (latestLog.getEndTime().after(new Date())) {
                // 如果当前时间再时间段中就修改
                if (Integer.valueOf(times.toString()) > config.getMaxTimes()) {
                    // 大于允许的请求次数，就不记录日志，直接返回
                    return obj;
                }
                latestLog.setRequestTimes(Integer.valueOf(times.toString()));
                latestLog.setUpdatedTime(new Date());
                latestLog.setUpdatedBy(config.getCreatedBy());
                urlInterceptorLogService.updateLog(latestLog);
            } else {
                urlInterceptorLogService.updateIsValid(ip, request.getRequestURI());
                addNewLog(ip, request, config, times);
            }

        }
        return obj;
    }

    private void addNewLog(String ip, HttpServletRequest request, UrlInterceptorConfig config, Object times) {
        Date startDate = new Date();
        UrlRequestLog logger = new UrlRequestLog();
        logger.setCreatedBy(config.getCreatedBy());
        logger.setCreatedTime(startDate);
        logger.setIsValid(1);
        logger.setRequestIp(ip);
        logger.setUrlInterceptorConfigId(config.getId());
        logger.setStartTime(startDate);
        logger.setUrl(request.getRequestURI());
        logger.setRequestTimes(Integer.valueOf(times.toString()));
        long timeFrequency = UrlServiceImpl.getTimeFrequency(config);
        logger.setEndTime(new Date(startDate.getTime() + timeFrequency * 1000));
        urlInterceptorLogService.addLog(logger);
    }
}

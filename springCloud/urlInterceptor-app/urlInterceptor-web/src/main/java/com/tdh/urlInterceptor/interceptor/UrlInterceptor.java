package com.tdh.urlInterceptor.interceptor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tdh.urlInterceptor.model.UrlInterceptorConfig;
import com.tdh.urlInterceptor.service.UrlService;

/**
 * url 拦截器
 */

public class UrlInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(UrlInterceptor.class);
    private static final String ERROR_MESSAGE = "{\"code\": 403, \"msg\":\"The server is busy, please try again later.\"}";
    @Autowired
    private UrlService urlService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("The url interceptor is working.");
        }
        String ipAddress = getIpAddress(request);
        UrlInterceptorConfig matchConfig = urlService.getMatchConfig(request);
        if (matchConfig == null) {
            return true;
        }
        boolean isLimit = urlService.isLimit(ipAddress, matchConfig, request);
        if (isLimit) {
            logger.warn("ip: " + ipAddress + ", More than the access frequency! The url address of the visit is: " + request.getRequestURI());
            response.setStatus(HttpStatus.FORBIDDEN.value());
            ServletOutputStream out = response.getOutputStream();
            out.write(ERROR_MESSAGE.getBytes(StandardCharsets.UTF_8));
            out.flush();
            out.close();
            return false;
        }

        return true;
    }


    private static String getIpAddress(HttpServletRequest request) throws IOException {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

        String ip = request.getHeader("X-Forwarded-For");
        if (logger.isInfoEnabled()) {
            logger.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
                }
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}

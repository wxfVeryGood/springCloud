package com.tdh.urlInterceptor.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

/**
 * 
 * @ClassName: Application
 * @Description: ()
 * @author wxf
 * @date 2018年11月26日 下午2:41:53
 *
 */
@EnableDiscoveryClient // 开启发现服务功能
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = { "com.tdh.urlInterceptor.*" })
public class Application {
	static Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("urlInterceptor consumer started successfully");
	}
	
//	@Bean
//	public HystrixMetricsStreamServlet hystrixMetricsStreamServlet() {
//		return new HystrixMetricsStreamServlet();
//	}
//
//	@Bean
//	public ServletRegistrationBean registration(HystrixMetricsStreamServlet servlet) {
//		ServletRegistrationBean registrationBean = new ServletRegistrationBean();
//		registrationBean.setServlet(servlet);
//		registrationBean.setEnabled(true);// 是否启用该registrationBean
//		registrationBean.addUrlMappings("/hystrix.stream");
//		return registrationBean;
//	}

	@LoadBalanced // 使用负载均衡机制
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

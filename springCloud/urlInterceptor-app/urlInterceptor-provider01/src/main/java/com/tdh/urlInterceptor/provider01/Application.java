package com.tdh.urlInterceptor.provider01;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @ClassName: Application
 * @Description: (springcloud provider服务启动类)
 * @author wxf
 * @date 2018年11月26日 上午11:22:42
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@MapperScan("com.tdh.urlInterceptor.mapper")
@ComponentScan(basePackages = { "com.tdh.urlInterceptor.*" })
@EnableMongoRepositories(basePackages = {"com.tdh.urlInterceptor.mongodb.repository"})
@EnableTransactionManagement
public class Application {
	static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("urlInterceptor provider started successfully");
	}
}

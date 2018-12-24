/**
 * 
 */
package com.tdh.urlInterceptor;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @ClassName: Application
 * @Description: (应用服务启动类)
 * @author wxf
 * @date 2018年11月16日 下午1:00:36
 *
 */
@SpringBootApplication
@MapperScan("com.tdh.urlInterceptor.mapper")
@ComponentScan(basePackages = { "com.tdh.urlInterceptor.*" })
@EnableMongoRepositories(basePackages = {"com.tdh.urlInterceptor.mongodb.repository"})
@EnableTransactionManagement
public class Application {
	static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(false).run(args);
		logger.info("urlInterceptor server started successfully");
		synchronized (Application.class) {
			try {
				Application.class.wait();
			} catch (InterruptedException e) {
				logger.error("fail to started urlInterceptor server", e);
			}
		}
	}
}

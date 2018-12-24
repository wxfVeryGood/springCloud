/**
 * 
 */
package com.tdh.urlInterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @ClassName: Application  
 * @Description: (应用服务启动类)  
 * @author wxf
 * @date 2018年11月16日 下午1:00:36  
 *
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = { "com.tdh.urlInterceptor.*" })
public class Application {
	static Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
		logger.info("urlInterceptor web started successfully");
	}
}

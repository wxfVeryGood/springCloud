package com.tdh.urlInterceptor.autoConfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;

/**
 * 
 * @ClassName: DubboAutoConfiguration  
 * @Description: (dubbo初始化配置中心)  
 * @author wxf
 * @date 2018年11月22日 下午4:11:22  
 *
 */
@Configuration
@EnableConfigurationProperties(DubboProperties.class)
@ConditionalOnClass({ AnnotationBean.class, ApplicationConfig.class, ProtocolConfig.class, RegistryConfig.class })
public class DubboAutoConfiguration {

	@Autowired
	private DubboProperties prop;

	/**
	 * 
	 * @Title: annotationBean  
	 * @Description: (创建dubbo注解解析器实例)  
	 * @param packageName
	 * @return AnnotationBean 返回类型 
	 * @throws
	 */
	@Bean
	@ConditionalOnMissingBean(AnnotationBean.class)
	public static AnnotationBean annotationBean(@Value("${dubbo.packageName}") String packageName) {

		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage(packageName);
		return annotationBean;

	}

	/**
	 * 
	 * @Title: applicationConfig  
	 * @Description: (创建dubbo应用配置解析器实例)  
	 * @return ApplicationConfig 返回类型 
	 * @throws
	 */
	@Bean
	@ConditionalOnMissingBean(ApplicationConfig.class)
	public ApplicationConfig applicationConfig() {

		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(prop.getApplication().getName());
		return applicationConfig;

	}

	/**
	 * 
	 * @Title: protocolConfig  
	 * @Description: (创建dubbo连接协议配置解析器实例)  
	 * @return ProtocolConfig 返回类型 
	 * @throws
	 */
	@Bean
	@ConditionalOnMissingBean(ProtocolConfig.class)
	public ProtocolConfig protocolConfig() {

		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName(prop.getProtocol().getName());
		protocolConfig.setPort(prop.getProtocol().getPort());
		return protocolConfig;

	}

	/**
	 * 
	 * @Title: registryConfig  
	 * @Description: (创建dubbo注册配置解析器实例)  
	 * @return RegistryConfig 返回类型 
	 * @throws
	 */
	@Bean
	@ConditionalOnMissingBean(RegistryConfig.class)
	public RegistryConfig registryConfig() {

		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress(prop.getRegistry().getAddress());
		return registryConfig;

	}

}

package com.tdh.urlInterceptor.autoConfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

/**
 * 
 * @ClassName: DubboProperties  
 * @Description: (dubbo初始化配置信息)  
 * @author wxf
 * @date 2018年11月22日 下午4:11:53  
 *
 */
@ConfigurationProperties(prefix = DubboProperties.DUBBO_PREFIX)
public class DubboProperties {

	public static final String DUBBO_PREFIX = "dubbo";

	private String scan;

	private ApplicationConfig application;

	private ProtocolConfig protocol;

	private RegistryConfig registry;

	public String getScan() {

		return scan;

	}

	public void setScan(String scan) {

		this.scan = scan;

	}

	public ApplicationConfig getApplication() {

		return application;

	}

	public void setApplication(ApplicationConfig application) {

		this.application = application;

	}

	public ProtocolConfig getProtocol() {

		return protocol;

	}

	public void setProtocol(ProtocolConfig protocol) {

		this.protocol = protocol;

	}

	public RegistryConfig getRegistry() {

		return registry;

	}

	public void setRegistry(RegistryConfig registry) {

		this.registry = registry;

	}

}

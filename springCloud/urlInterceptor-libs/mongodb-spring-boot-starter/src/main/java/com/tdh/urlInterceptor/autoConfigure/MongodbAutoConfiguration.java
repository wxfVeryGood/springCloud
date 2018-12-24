package com.tdh.urlInterceptor.autoConfigure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

/**
 * 
 * @ClassName: MongodbConfig
 * @Description: (mongodb初始化配置中心)
 * @author wxf
 * @date 2018年11月22日 下午3:32:20
 *
 */
@Configuration
@EnableConfigurationProperties(MongodbSettingsProperties.class)
@ConditionalOnClass({ MongoDbFactory.class, MongoTemplate.class })
public class MongodbAutoConfiguration {

	@Autowired
	private MongodbSettingsProperties properties;

	/**
	 * 
	 * @Title: mongoDbFactory 
	 * @Description: (创建mongodb数据库工厂实例) 
	 * @return MongoDbFactory 返回类型 
	 * @throws
	 */
	@Bean
	@ConditionalOnMissingBean(MongoDbFactory.class)
	public MongoDbFactory mongoDbFactory() {
		MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
		if (properties.getReplicaSet() != null) {
			builder.requiredReplicaSetName(properties.getReplicaSet());
		}
		builder.connectionsPerHost(properties.getConnectionsPerHost());
		builder.connectTimeout(properties.getConnectTimeout());
		builder.maxWaitTime(properties.getMaxWaitTime());
		builder.maxConnectionIdleTime(properties.getMaxConnectionIdleTime());
		builder.threadsAllowedToBlockForConnectionMultiplier(
				properties.getThreadsAllowedToBlockForConnectionMultiplier());
		builder.socketTimeout(properties.getSocketTimeout());
		builder.minConnectionsPerHost(properties.getMinConnectionsPerHost());
		MongoClientOptions mongoClientOptions = builder.build();
		List<ServerAddress> serverAddresses = new ArrayList<>();
		for (String address : properties.getAddress()) {
			String[] hostAndPort = address.split(":");
			String host = hostAndPort[0];
			Integer port = Integer.parseInt(hostAndPort[1]);
			ServerAddress serverAddress = new ServerAddress(host, port);
			serverAddresses.add(serverAddress);
		}
		List<MongoCredential> mongoCredentials = new ArrayList<MongoCredential>();
		MongoCredential mongoCredential = MongoCredential.createScramSha1Credential(properties.getUsername(),
				properties.getAuthenticationDatabase() != null ? properties.getAuthenticationDatabase()
						: properties.getDatabase(),
				properties.getPassword().toCharArray());
		mongoCredentials.add(mongoCredential);
		MongoClient mongoClient = new MongoClient(serverAddresses, mongoCredentials, mongoClientOptions);
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, properties.getDatabase());
		return mongoDbFactory;
	}
	
	/**
	 * 
	 * @Title: mongoTemplate  
	 * @Description: (创建MongoTemplate模板实例)  
	 * @param mongoDbFactory
	 * @return MongoTemplate 返回类型 
	 * @throws
	 */
	@Bean
	@Autowired
	@ConditionalOnMissingBean(MongoDbFactory.class)
	public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
		return mongoTemplate;
	}

}

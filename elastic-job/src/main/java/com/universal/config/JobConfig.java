package com.universal.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.universal.auxiliaty.ElasticJobListener;
import com.zaxxer.hikari.HikariDataSource;

/**
 * elastic-job相关的配置使用java配置实现，代替官方文档的xml配置
 * 
 * @author wurui
 *
 */
@Configuration
public class JobConfig {
	@Value("${regCenter.serverList}")
	private String serverList;
	@Value("${regCenter.namespace}")
	private String namespace;
	@Resource
	private HikariDataSource dataSource;

	@Bean
	public ZookeeperConfiguration zkConfig() {
		return new ZookeeperConfiguration(serverList, namespace);
	}

	@Bean(initMethod = "init")
	public ZookeeperRegistryCenter regCenter(ZookeeperConfiguration config) {
		return new ZookeeperRegistryCenter(config);
	}

	/**
	 * 将作业运行的痕迹进行持久化到DB
	 *
	 * @return
	 */
	@Bean
	public JobEventConfiguration jobEventConfiguration() {
		return new JobEventRdbConfiguration(dataSource);
	}

	@Bean
	public ElasticJobListener elasticJobListener() {
		return new ElasticJobListener(100, 100);
	}
	// public LiteJobConfiguration
	// liteJobConfiguration(@Value("${stockJob.cron}") final String cron,
	// @Value("${stockJob.shardingTotalCount}") final int shardingTotalCount) {
	// // 定义作业核心配置
	// JobCoreConfiguration simpleCoreConfig =
	// JobCoreConfiguration.newBuilder("demo", cron, shardingTotalCount)
	// .build();
	// // 定义SIMPLE类型配置
	// SimpleJobConfiguration simpleJobConfig = new
	// SimpleJobConfiguration(simpleCoreConfig,
	// SimpleJobDemo.class.getCanonicalName());
	// // 定义Lite作业根配置
	// LiteJobConfiguration simpleJobRootConfig =
	// LiteJobConfiguration.newBuilder(simpleJobConfig).build();
	//
	// return simpleJobRootConfig;
	// }
}

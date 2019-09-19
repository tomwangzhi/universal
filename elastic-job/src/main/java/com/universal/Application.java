package com.universal;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.universal.service.ElasticJobService;

/**
 * 
 * @author wurui
 *
 */
@SpringCloudApplication
public class Application implements CommandLineRunner {

	@Resource
	private ElasticJobService elasticJobService;

	public static void main(String[] args) {
		// new JobScheduler(createRegistryCenter(),
		// createJobConfiguration()).init();
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		elasticJobService.scanAddJob();
	}

	// private static CoordinatorRegistryCenter createRegistryCenter() {
	// CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(
	// new ZookeeperConfiguration("127.0.0.1:2181", "elastic-job-demo"));
	// regCenter.init();
	// return regCenter;
	// }
	//
	// private static LiteJobConfiguration createJobConfiguration() {
	// // 定义作业核心配置
	// JobCoreConfiguration simpleCoreConfig =
	// JobCoreConfiguration.newBuilder("demo", "0/15 * * * * ?", 2).build();
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

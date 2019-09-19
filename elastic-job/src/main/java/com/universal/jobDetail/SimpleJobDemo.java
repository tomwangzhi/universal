package com.universal.jobDetail;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
/**
 * 先实现一个自己的任务类，需要实现elastic-job提供的SimpleJob接口，
 * 实现它的execute(ShardingContext shardingContext)方法
 * 
 * @author wurui
 *
 */
public class SimpleJobDemo implements SimpleJob {

	@Override
	public void execute(ShardingContext shardingContext) {
		System.out.println(
				String.format("------Thread ID: %s, 任务总片数: %s, " + "当前分片项: %s.当前参数: %s," + "当前任务名称: %s.当前任务参数: %s",
						Thread.currentThread().getId(), shardingContext.getShardingTotalCount(),
						shardingContext.getShardingItem(), shardingContext.getShardingParameter(),
						shardingContext.getJobName(), shardingContext.getJobParameter()));

	}

}

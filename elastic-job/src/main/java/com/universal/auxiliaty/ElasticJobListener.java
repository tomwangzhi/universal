package com.universal.auxiliaty;

import javax.annotation.Resource;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.AbstractDistributeOnceElasticJobListener;
import com.universal.db.dao.TaskRepository;
import com.universal.db.entity.JobTask;

/**
 * 实现一个分布式的任务监听器，如果任务有分片，分布式监听器会在总的任务开始前执行一次，结束时执行一次。
 * 监听器在之前的ElasticJobConfig已经注册到了Spring容器之中。
 * 
 * @author wurui
 *
 */
public class ElasticJobListener extends AbstractDistributeOnceElasticJobListener {
	@Resource
	private TaskRepository taskRepository;

	public ElasticJobListener(long startedTimeoutMilliseconds, long completedTimeoutMilliseconds) {
		super(startedTimeoutMilliseconds, completedTimeoutMilliseconds);
	}

	@Override
	public void doBeforeJobExecutedAtLastStarted(ShardingContexts shardingContexts) {
	}

	@Override
	public void doAfterJobExecutedAtLastCompleted(ShardingContexts shardingContexts) {
		// 任务执行完成后更新状态为已执行
		JobTask jobTask = taskRepository.finOne(Long.valueOf(shardingContexts.getJobParameter()));
		jobTask.setStatus(1);
		taskRepository.update(jobTask.getStatus(), jobTask.getId());
	}
}

package com.universal.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.universal.auxiliaty.ElasticJobHandler;
import com.universal.db.dao.TaskRepository;
import com.universal.db.entity.JobTask;
import com.universal.utils.CronUtils;

@Service
public class ElasticJobService {
	@Resource
	private ElasticJobHandler jobHandler;
	@Resource
	private TaskRepository taskRepository;

	/**
	 * 扫描db，并添加任务
	 */
	public void scanAddJob() {
		List<JobTask> jobTasks = taskRepository.findAll(0);
		jobTasks.forEach(jobTask -> {
			Long current = System.currentTimeMillis();
			String jobName = "job" + jobTask.getSend_time();
			String cron;
			// 说明消费未发送，但是已经过了消息的发送时间，调整时间继续执行任务
			if (jobTask.getSend_time() < current) {
				// 设置为一分钟之后执行，把Date转换为cron表达式
				cron = CronUtils.getCron(new Date(current + 60000));
			} else {
				cron = CronUtils.getCron(new Date(jobTask.getSend_time()));
			}
			jobHandler.addJob(jobName, cron, 1, String.valueOf(jobTask.getId()));
		});
	}
}

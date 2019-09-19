package com.universal.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.universal.db.entity.JobTask;

@Mapper
public interface TaskRepository {
	@Select("SELECT * FROM `sys_task` WHERE `sys_task`.`status` = #{status}")
	public List<JobTask> findAll(@Param("status") int status);

	@Select("SELECT * FROM `sys_task` WHERE `sys_task`.`id` = #{id}")
	public JobTask finOne(@Param("id") Long id);

	@Update("UPDATE `sys_task` SET `status` = #{status} WHERE `id` = #{id}")
	public int update(@Param("status") int status, @Param("id") int id);

	@Insert("INSERT	INTO `sys_task` (`content`, `send_time`, `status`) VALUES (#{content}, #{send_time}, #{status})")
	public int insert(@Param("content") String content, @Param("send_time") long send_time,
			@Param("status") int status);
}

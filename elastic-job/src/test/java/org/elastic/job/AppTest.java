package org.elastic.job;

import javax.annotation.Resource;

import com.universal.db.dao.TaskRepository;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	@Resource
	TaskRepository taskRepository;
	
	@org.junit.Test
    public void add() {
        //生成几个任务，第一任务在三分钟之后
        Long unixTime = System.currentTimeMillis() + 60000;
        taskRepository.insert("test-msg-1", unixTime, 0);
        unixTime += 60000;
        taskRepository.insert("test-msg-2", unixTime, 0);
        unixTime += 60000;
        taskRepository.insert("test-msg-3", unixTime, 0);
        unixTime += 60000;
        taskRepository.insert("test-msg-4", unixTime, 0);
    }
}

/*
Navicat MySQL Data Transfer

Source Server         : 47.97.170.155
Source Server Version : 100128
Source Host           : 47.97.170.155:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 100128
File Encoding         : 65001

Date: 2018-12-05 10:37:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for job_execution_log
-- ----------------------------
DROP TABLE IF EXISTS `job_execution_log`;
CREATE TABLE `job_execution_log` (
  `id` varchar(40) NOT NULL,
  `job_name` varchar(100) NOT NULL,
  `task_id` varchar(255) NOT NULL,
  `hostname` varchar(255) NOT NULL,
  `ip` varchar(50) NOT NULL,
  `sharding_item` int(11) NOT NULL,
  `execution_source` varchar(20) NOT NULL,
  `failure_cause` varchar(4000) DEFAULT NULL,
  `is_success` int(11) NOT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `complete_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_execution_log
-- ----------------------------
INSERT INTO `job_execution_log` VALUES ('6f93561b-0f46-4eb0-8e79-52a5d146c928', 'job1543817096339', 'job1543817096339@-@0@-@READY@-@192.168.109.101@-@3540', 'PC-20180711VCEG', '192.168.109.101', '0', 'NORMAL_TRIGGER', null, '1', '2018-12-03 14:13:41', '2018-12-03 14:13:41');
INSERT INTO `job_execution_log` VALUES ('ac90cc9d-158f-4cc0-945e-a52e9c92be2d', 'job1543817216339', 'job1543817216339@-@0@-@READY@-@192.168.109.101@-@3540', 'PC-20180711VCEG', '192.168.109.101', '0', 'NORMAL_TRIGGER', null, '1', '2018-12-03 14:13:42', '2018-12-03 14:13:42');
INSERT INTO `job_execution_log` VALUES ('b6505d37-66c2-4af3-a246-f2a0b1c27a81', 'job1543817276339', 'job1543817276339@-@0@-@READY@-@192.168.109.101@-@3540', 'PC-20180711VCEG', '192.168.109.101', '0', 'NORMAL_TRIGGER', null, '1', '2018-12-03 14:13:42', '2018-12-03 14:13:42');
INSERT INTO `job_execution_log` VALUES ('c454c224-f8fe-4101-b486-4497199f0ed2', 'job1543817156339', 'job1543817156339@-@0@-@READY@-@192.168.109.101@-@3540', 'PC-20180711VCEG', '192.168.109.101', '0', 'NORMAL_TRIGGER', null, '1', '2018-12-03 14:13:42', '2018-12-03 14:13:42');

-- ----------------------------
-- Table structure for job_status_trace_log
-- ----------------------------
DROP TABLE IF EXISTS `job_status_trace_log`;
CREATE TABLE `job_status_trace_log` (
  `id` varchar(40) NOT NULL,
  `job_name` varchar(100) NOT NULL,
  `original_task_id` varchar(255) NOT NULL,
  `task_id` varchar(255) NOT NULL,
  `slave_id` varchar(50) NOT NULL,
  `source` varchar(50) NOT NULL,
  `execution_type` varchar(20) NOT NULL,
  `sharding_item` varchar(100) NOT NULL,
  `state` varchar(20) NOT NULL,
  `message` varchar(4000) DEFAULT NULL,
  `creation_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TASK_ID_STATE_INDEX` (`task_id`,`state`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_status_trace_log
-- ----------------------------
INSERT INTO `job_status_trace_log` VALUES ('1cd34d74-9c8f-4600-897d-9d37fb9f9efe', 'job1543817096339', '', 'job1543817096339@-@0@-@READY@-@192.168.109.101@-@3540', '192.168.109.101', 'LITE_EXECUTOR', 'READY', '[0]', 'TASK_FINISHED', '', '2018-12-03 14:13:41');
INSERT INTO `job_status_trace_log` VALUES ('275d9033-0a91-480c-a633-a3f3c6d33db8', 'job1543817276339', '', 'job1543817276339@-@0@-@READY@-@192.168.109.101@-@3540', '192.168.109.101', 'LITE_EXECUTOR', 'READY', '[0]', 'TASK_STAGING', 'Job \'job1543817276339\' execute begin.', '2018-12-03 14:13:42');
INSERT INTO `job_status_trace_log` VALUES ('2a7243a7-4f7d-4b93-888f-f358a18b6222', 'job1543817096339', '', 'job1543817096339@-@0@-@READY@-@192.168.109.101@-@3540', '192.168.109.101', 'LITE_EXECUTOR', 'READY', '[0]', 'TASK_RUNNING', '', '2018-12-03 14:13:41');
INSERT INTO `job_status_trace_log` VALUES ('2ec5314f-ad5f-4965-9a9e-bb4e818f36a6', 'job1543817216339', '', 'job1543817216339@-@0@-@READY@-@192.168.109.101@-@3540', '192.168.109.101', 'LITE_EXECUTOR', 'READY', '[0]', 'TASK_RUNNING', '', '2018-12-03 14:13:42');
INSERT INTO `job_status_trace_log` VALUES ('54a2e247-8b22-4530-b969-b885932ce03f', 'job1543817156339', '', 'job1543817156339@-@0@-@READY@-@192.168.109.101@-@3540', '192.168.109.101', 'LITE_EXECUTOR', 'READY', '[0]', 'TASK_RUNNING', '', '2018-12-03 14:13:42');
INSERT INTO `job_status_trace_log` VALUES ('62b056cb-eadf-4adf-8dd0-74f0fe8c75d1', 'job1543817156339', '', 'job1543817156339@-@0@-@READY@-@192.168.109.101@-@3540', '192.168.109.101', 'LITE_EXECUTOR', 'READY', '[0]', 'TASK_STAGING', 'Job \'job1543817156339\' execute begin.', '2018-12-03 14:13:42');
INSERT INTO `job_status_trace_log` VALUES ('7aa53fcc-d368-4374-9a66-40375bde9e0d', 'job1543817216339', '', 'job1543817216339@-@0@-@READY@-@192.168.109.101@-@3540', '192.168.109.101', 'LITE_EXECUTOR', 'READY', '[0]', 'TASK_FINISHED', '', '2018-12-03 14:13:42');
INSERT INTO `job_status_trace_log` VALUES ('d50e162c-eba7-4955-b5ba-bd490e6d116a', 'job1543817276339', '', 'job1543817276339@-@0@-@READY@-@192.168.109.101@-@3540', '192.168.109.101', 'LITE_EXECUTOR', 'READY', '[0]', 'TASK_FINISHED', '', '2018-12-03 14:13:42');
INSERT INTO `job_status_trace_log` VALUES ('d5ae0325-1ef2-40df-888f-824b0b52d3ed', 'job1543817276339', '', 'job1543817276339@-@0@-@READY@-@192.168.109.101@-@3540', '192.168.109.101', 'LITE_EXECUTOR', 'READY', '[0]', 'TASK_RUNNING', '', '2018-12-03 14:13:42');
INSERT INTO `job_status_trace_log` VALUES ('ed7a34de-5379-4d24-8a3c-4bc58dc4d4f7', 'job1543817096339', '', 'job1543817096339@-@0@-@READY@-@192.168.109.101@-@3540', '192.168.109.101', 'LITE_EXECUTOR', 'READY', '[0]', 'TASK_STAGING', 'Job \'job1543817096339\' execute begin.', '2018-12-03 14:13:41');
INSERT INTO `job_status_trace_log` VALUES ('f532f3a9-4938-45be-92d1-2f18e731b945', 'job1543817216339', '', 'job1543817216339@-@0@-@READY@-@192.168.109.101@-@3540', '192.168.109.101', 'LITE_EXECUTOR', 'READY', '[0]', 'TASK_STAGING', 'Job \'job1543817216339\' execute begin.', '2018-12-03 14:13:42');
INSERT INTO `job_status_trace_log` VALUES ('f8df9e41-9434-4002-9ee0-b8b37a0e7ba5', 'job1543817156339', '', 'job1543817156339@-@0@-@READY@-@192.168.109.101@-@3540', '192.168.109.101', 'LITE_EXECUTOR', 'READY', '[0]', 'TASK_FINISHED', '', '2018-12-03 14:13:42');

-- ----------------------------
-- Table structure for sys_task
-- ----------------------------
DROP TABLE IF EXISTS `sys_task`;
CREATE TABLE `sys_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `send_time` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_task
-- ----------------------------
INSERT INTO `sys_task` VALUES ('1', 'test-msg-1', '1543817096339', '1');
INSERT INTO `sys_task` VALUES ('2', 'test-msg-2', '1543817156339', '1');
INSERT INTO `sys_task` VALUES ('3', 'test-msg-3', '1543817216339', '1');
INSERT INTO `sys_task` VALUES ('4', 'test-msg-4', '1543817276339', '1');

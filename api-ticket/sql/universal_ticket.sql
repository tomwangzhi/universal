/*
Navicat MySQL Data Transfer

Source Server         : 192.168.11.207
Source Server Version : 80013
Source Host           : 192.168.11.207:3308
Source Database       : universal_ticket

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-27 13:48:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lcn_test
-- ----------------------------
DROP TABLE IF EXISTS `lcn_test`;
CREATE TABLE `lcn_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL DEFAULT '100' COMMENT '所剩票数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of lcn_test
-- ----------------------------
INSERT INTO `lcn_test` VALUES ('1', '98');

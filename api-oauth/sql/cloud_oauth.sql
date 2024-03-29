/*
Navicat MySQL Data Transfer

Source Server         : 192.168.11.207
Source Server Version : 80013
Source Host           : 192.168.11.207:3308
Source Database       : cloud_oauth

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-21 20:22:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL COMMENT '密码',
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL COMMENT '支持的授权方式',
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL COMMENT 'access_token有效期（单位秒）',
  `refresh_token_validity` int(11) DEFAULT NULL COMMENT 'refresh_token有效期（单位秒）',
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='oauth2的client表';

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('system', null, '$2a$10$e9OY2y6MGpv6fK/8NFxSzODEKPSYgK2b9DOJ3NAgCgNs7uENCzFzC', 'app', 'authorization_code,password,refresh_token', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(128) NOT NULL COMMENT '临时code',
  `authentication` blob,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='授权码模式code表';

-- ----------------------------
-- Records of oauth_code
-- ----------------------------

/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80003
Source Host           : localhost:3306
Source Database       : freeter

Target Server Type    : MYSQL
Target Server Version : 80003
File Encoding         : 65001

Date: 2019-05-16 13:22:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `alias_name` varchar(50) DEFAULT NULL,
  `is_delete` int(1) DEFAULT '0',
  `sex` varchar(32) DEFAULT NULL COMMENT 'man:男 woman:女',
  `version` int(11) DEFAULT '0' COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Jone', '20', 'test1@baomidou.com', 'liqi_01', '0', 'man', '0');
INSERT INTO `user` VALUES ('2', 'Jack', '20', 'test2@baomidou.com', 'liqi_02', '0', 'man', '0');
INSERT INTO `user` VALUES ('3', 'Tom', '20', 'test3@baomidou.com', 'liqi_03', '0', 'man', '0');
INSERT INTO `user` VALUES ('4', 'Sandy', '20', 'test4@baomidou.com', 'liqi_04', '0', 'woman', '0');
INSERT INTO `user` VALUES ('5', 'billie', '20', 'test5@baomidou.com', 'liqi_05', '0', 'woman', '0');

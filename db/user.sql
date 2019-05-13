/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80003
Source Host           : localhost:3306
Source Database       : freeter

Target Server Type    : MYSQL
Target Server Version : 80003
File Encoding         : 65001

Date: 2019-05-13 11:41:33
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Jone', '18', 'test1@baomidou.com', 'liqi_01');
INSERT INTO `user` VALUES ('2', 'Jack', '20', 'test2@baomidou.com', 'liqi_02');
INSERT INTO `user` VALUES ('3', 'Tom', '28', 'test3@baomidou.com', 'liqi_03');
INSERT INTO `user` VALUES ('4', 'Sandy', '21', 'test4@baomidou.com', 'liqi_04');
INSERT INTO `user` VALUES ('5', 'Billie', '24', 'test5@baomidou.com', 'liqi_05');

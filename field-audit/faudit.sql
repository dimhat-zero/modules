/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : faudit

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-09-22 18:28:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for faudit
-- ----------------------------
DROP TABLE IF EXISTS `faudit`;
CREATE TABLE `faudit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `answer_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for faudit_service_qn
-- ----------------------------
DROP TABLE IF EXISTS `faudit_service_qn`;
CREATE TABLE `faudit_service_qn` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `qn_id` bigint(20) NOT NULL,
  `service_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `qn_id` (`qn_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fa_answer
-- ----------------------------
DROP TABLE IF EXISTS `fa_answer`;
CREATE TABLE `fa_answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext NOT NULL,
  `gmt_create` datetime NOT NULL,
  `qn_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `qn_id` (`qn_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fa_option
-- ----------------------------
DROP TABLE IF EXISTS `fa_option`;
CREATE TABLE `fa_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `question_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `fa_option_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `fa_question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fa_question
-- ----------------------------
DROP TABLE IF EXISTS `fa_question`;
CREATE TABLE `fa_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `type` smallint(6) NOT NULL,
  `qn_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `qn_id` (`qn_id`),
  CONSTRAINT `fa_question_ibfk_1` FOREIGN KEY (`qn_id`) REFERENCES `fa_questionaire` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fa_questionaire
-- ----------------------------
DROP TABLE IF EXISTS `fa_questionaire`;
CREATE TABLE `fa_questionaire` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `org_id` bigint(20) NOT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `gmt_modify` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : faudit

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-09-22 00:21:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for faudit
-- ----------------------------
DROP TABLE IF EXISTS `faudit`;
CREATE TABLE `faudit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `answer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for faudit_answer
-- ----------------------------
DROP TABLE IF EXISTS `faudit_answer`;
CREATE TABLE `faudit_answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `qn_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `qn_id` (`qn_id`),
  CONSTRAINT `faudit_answer_ibfk_1` FOREIGN KEY (`qn_id`) REFERENCES `faudit_questionaire` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for faudit_option
-- ----------------------------
DROP TABLE IF EXISTS `faudit_option`;
CREATE TABLE `faudit_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `question_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `faudit_option_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `faudit_question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for faudit_qn_question
-- ----------------------------
DROP TABLE IF EXISTS `faudit_qn_question`;
CREATE TABLE `faudit_qn_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `qn_id` bigint(20) NOT NULL,
  `question_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `qn_id` (`qn_id`),
  KEY `question_id` (`question_id`),
  CONSTRAINT `faudit_qn_question_ibfk_1` FOREIGN KEY (`qn_id`) REFERENCES `faudit_questionaire` (`id`),
  CONSTRAINT `faudit_qn_question_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `faudit_question` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for faudit_question
-- ----------------------------
DROP TABLE IF EXISTS `faudit_question`;
CREATE TABLE `faudit_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `type` smallint(6) NOT NULL,
  `org_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for faudit_questionaire
-- ----------------------------
DROP TABLE IF EXISTS `faudit_questionaire`;
CREATE TABLE `faudit_questionaire` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gmt_create` datetime NOT NULL,
  `org_id` bigint(20) NOT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

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
  KEY `qn_id` (`qn_id`),
  CONSTRAINT `faudit_service_qn_ibfk_1` FOREIGN KEY (`qn_id`) REFERENCES `faudit_questionaire` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
Navicat MySQL Data Transfer

Source Server         : 172.39.8.241
Source Server Version : 50723
Source Host           : 172.39.8.241:3306
Source Database       : study_self

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2020-02-21 17:32:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for english_article
-- ----------------------------
DROP TABLE IF EXISTS `english_article`;
CREATE TABLE `english_article` (
  `id` varchar(64) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text,
  `mean` text,
  `remark` varchar(255) DEFAULT NULL,
  `type_id` varchar(64) NOT NULL,
  `level` varchar(64) NOT NULL,
  `vg` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of english_article
-- ----------------------------
INSERT INTO `english_article` VALUES ('123', '12', '12', '21', '21', '23', '1', '1');

-- ----------------------------
-- Table structure for english_dict
-- ----------------------------
DROP TABLE IF EXISTS `english_dict`;
CREATE TABLE `english_dict` (
  `id` varchar(64) NOT NULL,
  `type` varchar(50) NOT NULL,
  `sign` varchar(50) NOT NULL,
  `mean` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of english_dict
-- ----------------------------

-- ----------------------------
-- Table structure for english_phrase
-- ----------------------------
DROP TABLE IF EXISTS `english_phrase`;
CREATE TABLE `english_phrase` (
  `id` varchar(64) NOT NULL,
  `phrase` varchar(255) NOT NULL,
  `mean` varchar(255) NOT NULL,
  `article_id` varchar(64) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of english_phrase
-- ----------------------------

-- ----------------------------
-- Table structure for english_sentence
-- ----------------------------
DROP TABLE IF EXISTS `english_sentence`;
CREATE TABLE `english_sentence` (
  `id` varchar(64) NOT NULL,
  `sentence` varchar(255) NOT NULL,
  `mean` varchar(255) NOT NULL,
  `article_id` varchar(64) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of english_sentence
-- ----------------------------

-- ----------------------------
-- Table structure for english_word
-- ----------------------------
DROP TABLE IF EXISTS `english_word`;
CREATE TABLE `english_word` (
  `id` varchar(64) NOT NULL,
  `word` varchar(50) NOT NULL,
  `mean` varchar(4096) DEFAULT NULL,
  `article_id` varchar(64) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of english_word
-- ----------------------------

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : 192.168.1.10:3306
Source Database       : study_self

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2020-02-23 22:55:21
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
  `type_id` varchar(64) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `level` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of english_article
-- ----------------------------
INSERT INTO `english_article` VALUES ('05707436-158b-3380-bea4-2a9353d15625', 'ertwe', 'rte', null, null, null, '2020-02-23 05:17:43', null);
INSERT INTO `english_article` VALUES ('202cb962-ac59-375b-964b-07152d234b70', '123', 'xxiaohe2', 'content s ', null, null, '2020-02-23 08:00:34', null);
INSERT INTO `english_article` VALUES ('fbc831a3-0441-3fdc-adcb-d6584e64d3c0', 'beautiful girl', 'dgsd sdfsdfgd sfgdg', '大哥大哥电饭锅电饭锅', null, null, '2020-02-22 10:47:17', null);

-- ----------------------------
-- Table structure for english_dict
-- ----------------------------
DROP TABLE IF EXISTS `english_dict`;
CREATE TABLE `english_dict` (
  `id` varchar(64) NOT NULL,
  `type` varchar(50) NOT NULL,
  `sign` varchar(50) NOT NULL,
  `mean` varchar(255) DEFAULT NULL,
  `create_date` datetime NOT NULL,
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
  `create_date` datetime NOT NULL,
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
  `create_date` datetime NOT NULL,
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
  `article_id` varchar(4096) NOT NULL,
  `create_date` datetime NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of english_word
-- ----------------------------
INSERT INTO `english_word` VALUES ('00e680ce-c61b-3400-9d83-0e007ee74226', 'literally', '[{\"wordType\":\"adv\",\"mean\":\" 照字面地;逐字地;不夸张地;正确地;简直\"}]', 'fbc831a3-0441-3fdc-adcb-d6584e64d3c0,05707436-158b-3380-bea4-2a9353d15625', '2020-02-22 10:45:22', null);
INSERT INTO `english_word` VALUES ('018b6a49-98ca-3ef2-a31b-319a6421d5f2', 'engage', '[{\"wordType\":\"vt\",\"mean\":\" 吸引,占用;使参加;雇佣;使订婚;预定\"},{\"wordType\":\"vi\",\"mean\":\" 从事;参与;答应,保证;交战;啮合\"}]', 'fbc831a3-0441-3fdc-adcb-d6584e64d3c0,,05707436-158b-3380-bea4-2a9353d15625', '2020-02-22 10:45:22', null);
INSERT INTO `english_word` VALUES ('028dce7f-598c-380b-a369-7045a8316ce2', 'proof', '[{\"wordType\":\"n\",\"mean\":\" 证明;证据;校样;考验;验证;试验\"},{\"wordType\":\"adj\",\"mean\":\" 防…的;不能透入的;证明用的;耐…的\"},{\"wordType\":\"vt\",\"mean\":\" 试验;校对;使不被穿透\"}]', 'fbc831a3-0441-3fdc-adcb-d6584e64d3c0,,,05707436-158b-3380-bea4-2a9353d15625', '2020-02-23 05:28:52', null);
INSERT INTO `english_word` VALUES ('0358848c-0b5d-3b9b-bcd0-66ec637dcf51', 'petroleum', '[{\"wordType\":\"n\",\"mean\":\" 石油\"}]', 'fbc831a3-0441-3fdc-adcb-d6584e64d3c005707436-158b-3380-bea4-2a9353d15625, , ,   ,05707436-158b-3380-bea4-2a9353d15625', '2020-02-23 05:28:52', null);
INSERT INTO `english_word` VALUES ('03672bee-7f58-3d26-936f-083acaa24855', 'operate', '[{\"wordType\":\"vi\",\"mean\":\" 运转;动手术;起作用\"},{\"wordType\":\"vt\",\"mean\":\" 操作;经营;引起;对…开刀;行动\"}]', ' , , ,fbc831a3-0441-3fdc-adcb-d6584e64d3c0, ', '2020-02-22 10:45:22', null);
INSERT INTO `english_word` VALUES ('057a00eb-e4c3-3f8e-b2be-9349834dc619', 'trader', '[{\"wordType\":\"n\",\"mean\":\" 交易者;商人;商船\"}]', 'dd4b21e9-ef71-3129-9183-a46b913ae6f2', '2020-02-22 10:45:22', null);
INSERT INTO `english_word` VALUES ('05b9f17c-9f63-34c6-9b16-633862da1214', 'delicate', '[{\"wordType\":\"adj\",\"mean\":\" 微妙的;精美的,雅致的;柔和的;易碎的;纤弱的\"}]', 'dd4b21e9-ef71-3129-9183-a46b913ae6f2', '2020-02-23 05:28:52', null);
INSERT INTO `english_word` VALUES ('0ff66555-f702-3c5d-a372-fbf8628939b1', 'freight', '[{\"wordType\":\"n\",\"mean\":\" 货运;运费;船货\"},{\"wordType\":\"v\",\"mean\":\" 运送;装货;使充满\"}]', 'dd4b21e9-ef71-3129-9183-a46b913ae6f2', '2020-02-22 10:45:22', null);
INSERT INTO `english_word` VALUES ('107f3400-ca80-3bfe-8d2a-127622908d53', 'consult', '[{\"wordType\":\"vt\",\"mean\":\" 查阅;商量;向…请教\"},{\"wordType\":\"vi\",\"mean\":\" 请教;商议;当顾问\"}]', 'dd4b21e9-ef71-3129-9183-a46b913ae6f2', '2020-02-22 10:45:22', null);

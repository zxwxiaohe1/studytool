/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : 192.168.1.10:3306
Source Database       : study_self

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2020-03-02 23:27:28
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
INSERT INTO `english_article` VALUES ('15f6f8dc-0365-39d7-be15-b39338f6e5db', 'twelve', null, null, null, null, '2020-02-28 08:43:41', null);
INSERT INTO `english_article` VALUES ('24d27c16-9c2c-381e-b09a-065116f2aa5c', 'eight', null, null, null, null, '2020-02-28 08:42:27', null);
INSERT INTO `english_article` VALUES ('279e962e-a623-3a2a-ba86-739622772e1f', 'fourteen', null, null, null, null, '2020-02-28 08:53:21', null);
INSERT INTO `english_article` VALUES ('2e457d2f-9f38-3f41-9f5a-34092cba8438', 'seventeen', null, null, null, null, '2020-02-28 08:57:13', null);
INSERT INTO `english_article` VALUES ('30056e1c-ab7a-31d2-96fc-8edd970d14f5', 'five', null, null, null, null, '2020-02-28 08:56:03', null);
INSERT INTO `english_article` VALUES ('35d6d334-67aa-39a2-a3dc-cb4b6b027878', 'three', null, null, null, null, '2020-02-28 08:41:32', null);
INSERT INTO `english_article` VALUES ('422ecc08-4f24-38de-bc62-0ecebf2a6448', 'thirteen', null, null, null, null, '2020-02-28 08:52:31', null);
INSERT INTO `english_article` VALUES ('8b04d5e3-775d-398e-b845-5efc5ca404d5', 'first', null, null, null, null, '2020-02-28 08:41:07', null);
INSERT INTO `english_article` VALUES ('8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', 'four', null, null, null, null, '2020-02-28 08:41:41', null);
INSERT INTO `english_article` VALUES ('92a2132e-0190-36e5-82f1-3376ddc660d5', 'fifteen', null, null, null, null, '2020-02-28 08:54:37', null);
INSERT INTO `english_article` VALUES ('9c8454dd-f7aa-3011-a496-bac348d7550d', 'eleven', null, null, null, null, '2020-02-28 08:43:12', null);
INSERT INTO `english_article` VALUES ('a9f0e61a-137d-36aa-9db5-3465e0801612', 'second', null, null, null, null, '2020-02-28 08:41:22', null);
INSERT INTO `english_article` VALUES ('b1b9a972-ccd8-3962-a473-909b97007eb4', 'ten', null, null, null, null, '2020-02-28 08:42:53', null);
INSERT INTO `english_article` VALUES ('bb3aec0f-dcdb-3297-8890-f805c585d432', 'seven', null, null, null, null, '2020-02-28 08:42:17', null);
INSERT INTO `english_article` VALUES ('bd2c775d-9eaf-3f71-9a52-b55ade9989a4', 'sixteen', null, null, null, null, '2020-02-28 08:55:18', null);
INSERT INTO `english_article` VALUES ('c785e1ed-2950-33e3-ab1e-2ca01f299a54', 'nine', null, null, null, null, '2020-02-28 08:42:41', null);
INSERT INTO `english_article` VALUES ('f52b5e44-9a23-33c0-b1a0-c3a1109360bf', 'six', null, null, null, null, '2020-02-28 08:41:49', null);

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
INSERT INTO `english_word` VALUES ('00236eac-dee8-3819-a9bf-9b3bc7da13c6', 'infer', '[{\"wordType\":\"vt\",\"mean\":\" 推断;推论\"},{\"wordType\":\"vi\",\"mean\":\" 推断;作出推论\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('00988761-23c5-34d7-9b20-5c3b727b8af1', 'technique', '[{\"wordType\":\"n\",\"mean\":\" 技巧,技术;手法\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('00e680ce-c61b-3400-9d83-0e007ee74226', 'literally', '[{\"wordType\":\"adv\",\"mean\":\" 照字面地;逐字地;不夸张地;正确地;简直\"}]', '2e457d2f-9f38-3f41-9f5a-34092cba8438', '2020-02-22 10:45:22', null);
INSERT INTO `english_word` VALUES ('018b6a49-98ca-3ef2-a31b-319a6421d5f2', 'engage', '[{\"wordType\":\"vt\",\"mean\":\" 吸引,占用;使参加;雇佣;使订婚;预定\"},{\"wordType\":\"vi\",\"mean\":\" 从事;参与;答应,保证;交战;啮合\"}]', '2e457d2f-9f38-3f41-9f5a-34092cba8438', '2020-02-22 10:45:22', null);
INSERT INTO `english_word` VALUES ('02592d82-bba0-3de3-a4f7-2496b393d16f', 'fed', '[{\"wordType\":\"v\",\"mean\":\" 喂养;以……为食;给（植物）施肥;增进,助长;（非正式）（feed 的过去式和过去分词）\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('028dce7f-598c-380b-a369-7045a8316ce2', 'proof', '[{\"wordType\":\"n\",\"mean\":\" 证明;证据;校样;考验;验证;试验\"},{\"wordType\":\"adj\",\"mean\":\" 防…的;不能透入的;证明用的;耐…的\"},{\"wordType\":\"vt\",\"mean\":\" 试验;校对;使不被穿透\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-23 05:28:52', null);
INSERT INTO `english_word` VALUES ('0358848c-0b5d-3b9b-bcd0-66ec637dcf51', 'petroleum', '[{\"wordType\":\"n\",\"mean\":\" 石油\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-23 05:28:52', null);
INSERT INTO `english_word` VALUES ('03672bee-7f58-3d26-936f-083acaa24855', 'operate', '[{\"wordType\":\"vi\",\"mean\":\" 运转;动手术;起作用\"},{\"wordType\":\"vt\",\"mean\":\" 操作;经营;引起;对…开刀;行动\"}]', '2e457d2f-9f38-3f41-9f5a-34092cba8438', '2020-02-22 10:45:22', null);
INSERT INTO `english_word` VALUES ('057a00eb-e4c3-3f8e-b2be-9349834dc619', 'trader', '[{\"wordType\":\"n\",\"mean\":\" 交易者;商人;商船\"}]', '2e457d2f-9f38-3f41-9f5a-34092cba8438', '2020-02-22 10:45:22', null);
INSERT INTO `english_word` VALUES ('05b9f17c-9f63-34c6-9b16-633862da1214', 'delicate', '[{\"wordType\":\"adj\",\"mean\":\" 微妙的;精美的,雅致的;柔和的;易碎的;纤弱的\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-23 05:28:52', null);
INSERT INTO `english_word` VALUES ('075a3e36-a0a5-3dcb-8568-c05788e8a713', 'medium', '[{\"wordType\":\"adj\",\"mean\":\" 中间的,中等的;半生熟的;（投球）中速的\"},{\"wordType\":\"n\",\"mean\":\" 方法;媒体;媒介;中间物;溶剂;灵媒;中庸\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('078eb6dc-4e96-32d5-a922-f246b4088cf6', 'consensus', '[{\"wordType\":\"n\",\"mean\":\" 一致;舆论;合意\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('08b4b82c-5e48-397a-b0d7-d36163161106', 'mineral', '[{\"wordType\":\"n\",\"mean\":\" 矿物;矿泉水;无机物;苏打水\"},{\"wordType\":\"adj\",\"mean\":\" 矿物的;矿质的\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('0bf5c9f4-edbe-355d-8301-ad9eecfac8af', 'countless', '[{\"wordType\":\"adj\",\"mean\":\" 无数的;数不尽的\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('0c5c43c7-900a-38a9-98c8-72f937ae33ad', 'authorize', '[{\"wordType\":\"vt\",\"mean\":\" 批准,认可;授权给;委托代替\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('0ff66555-f702-3c5d-a372-fbf8628939b1', 'freight', '[{\"wordType\":\"n\",\"mean\":\" 货运;运费;船货\"},{\"wordType\":\"v\",\"mean\":\" 运送;装货;使充满\"}]', '2e457d2f-9f38-3f41-9f5a-34092cba8438', '2020-02-22 10:45:22', null);
INSERT INTO `english_word` VALUES ('107f3400-ca80-3bfe-8d2a-127622908d53', 'consult', '[{\"wordType\":\"vt\",\"mean\":\" 查阅;商量;向…请教\"},{\"wordType\":\"vi\",\"mean\":\" 请教;商议;当顾问\"}]', '2e457d2f-9f38-3f41-9f5a-34092cba8438', '2020-02-22 10:45:22', null);
INSERT INTO `english_word` VALUES ('10ce8342-c80b-31b7-952a-e62d63bd48c1', 'fairly', '[{\"wordType\":\"adv\",\"mean\":\" 相当地;公平地;简直\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('1145f263-256c-3237-96d2-b8eade2f6689', 'board', '[{\"wordType\":\"n\",\"mean\":\" 董事会;木板;甲板;膳食\"},{\"wordType\":\"vt\",\"mean\":\" 上;用板盖上\"},{\"wordType\":\"vi\",\"mean\":\" 寄宿\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('126ac534-c041-3515-bde0-81d21f0b6d84', 'relies', '[{\"wordType\":\"\",\"mean\":\" 信任\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('13ad9c97-9f10-3b05-baf1-1372615e4672', 'immigration', '[{\"wordType\":\"n\",\"mean\":\" 外来移民;移居\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('1424ca49-c88f-3234-baf1-f2fe7a569169', 'stadium', '[{\"wordType\":\"n\",\"mean\":\" 体育场;露天大型运动场\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('14447bfb-b2f9-38b9-97ad-32f96e7af40d', 'extraordinary', '[{\"wordType\":\"adj\",\"mean\":\" 非凡的;特别的;离奇的;特派的\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('146a3622-42fa-3dbf-bb23-db489b9cf7be', 'bury', '[{\"wordType\":\"adj\",\"mean\":\" 埋葬的;埋藏的\"},{\"wordType\":\"v\",\"mean\":\" 埋葬\"}]', '8b04d5e3-775d-398e-b845-5efc5ca404d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('1506aeeb-8c3a-399b-9e3c-87db03156428', 'midnight', '[{\"wordType\":\"n\",\"mean\":\" 午夜,半夜12点钟\"},{\"wordType\":\"adj\",\"mean\":\" 半夜的;漆黑的\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('151aa009-4f11-3845-9fb2-08721955f152', 'century', '[{\"wordType\":\"n\",\"mean\":\" 世纪,百年\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('16518154-fcc1-3cb9-8715-478443414867', 'electronic', '[{\"wordType\":\"adj\",\"mean\":\" 电子的\"},{\"wordType\":\"n\",\"mean\":\" 电子电路;电子器件\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('17cb48b1-29d8-38c4-9812-78d02c5e07c2', 'comer', '[{\"wordType\":\"n\",\"mean\":\" 来者,来的人;有成功希望的人\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('1869119e-100e-3fd6-8b1d-fad777a61049', 'postulate', '[{\"wordType\":\"vt\",\"mean\":\" 假定;要求;视…为理所当然\"},{\"wordType\":\"n\",\"mean\":\" 基本条件;假定\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('195811dc-bf08-3e24-a9cb-1a69e4209962', 'contrary', '[{\"wordType\":\"adj\",\"mean\":\" 相反的;对立的\"},{\"wordType\":\"adv\",\"mean\":\" 相反地\"},{\"wordType\":\"n\",\"mean\":\" 相反;反面\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('1977c9da-a1d6-3de5-9a46-51abdb160c09', 'fit', '[{\"wordType\":\"vt\",\"mean\":\" 安装;使……适应;使……合身;与……相符\"},{\"wordType\":\"vi\",\"mean\":\" 符合,配合;适合;合身\"},{\"wordType\":\"adj\",\"mean\":\" 健康的;合适的;恰当的;准备好的\"},{\"wordType\":\"n\",\"mean\":\" 合身;发作;痉挛\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('1993ee5c-be82-307a-89d8-b7320a2ab0b6', 'mention', '[{\"wordType\":\"vt\",\"mean\":\" 提到,谈到;提及,论及;说起\"},{\"wordType\":\"n\",\"mean\":\" 提及,说起\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('1c160466-e2f9-361f-9498-dbbbfdfad0e2', 'ought', '[{\"wordType\":\"v\",\"mean\":\" 应该,应当;大概,应该\"},{\"wordType\":\"n\",\"mean\":\" 责任,义务\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('1d1d5778-7630-31eb-b2bd-c5db696077a6', 'agency', '[{\"wordType\":\"n\",\"mean\":\" 代理,中介;代理处,经销处;作用\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('1e305752-7650-336a-bc8c-fa0131920cda', 'transition', '[{\"wordType\":\"n\",\"mean\":\" 过渡;转变;转换;变调\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('1f4101bb-6db9-3c55-8888-d28ffcd88431', 'complaint', '[{\"wordType\":\"n\",\"mean\":\" 抱怨;诉苦;疾病;委屈\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('1f4a9685-e37e-3f94-8d07-a9f6b43dc83c', 'street', '[{\"wordType\":\"n\",\"mean\":\" 街道\"},{\"wordType\":\"adj\",\"mean\":\" 街道的\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('2067d966-684a-3ac6-af99-feb1da26dc25', 'specific', '[{\"wordType\":\"adj\",\"mean\":\" 特殊的,特定的;明确的;详细的;[药] 具有特效的\"},{\"wordType\":\"n\",\"mean\":\" 特性;细节;特效药\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('208c6aa1-5739-3b85-9bcd-4c3df2b08f2d', 'morale', '[{\"wordType\":\"n\",\"mean\":\" 士气,斗志\"}]', 'a9f0e61a-137d-36aa-9db5-3465e0801612', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('2179c270-33bf-30b9-bb89-bb0afd5b4dd3', 'african', '[{\"wordType\":\"adj\",\"mean\":\" 非洲的,非洲人的\"},{\"wordType\":\"n\",\"mean\":\" 非洲人\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('22811dd9-4d65-337e-b865-35740b98dec8', 'wood', '[{\"wordType\":\"n\",\"mean\":\" 木材;木制品;树林\"},{\"wordType\":\"vi\",\"mean\":\" 收集木材\"},{\"wordType\":\"vt\",\"mean\":\" 植林于;给…添加木柴\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('236f3d25-a9af-3de3-b289-6260f0ce5f1f', 'cultivate', '[{\"wordType\":\"vt\",\"mean\":\" 培养;陶冶;耕作 \"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('23b79ae0-fc0f-37a3-a695-98dd23c694cc', 'individual', '[{\"wordType\":\"adj\",\"mean\":\" 个人的;个别的;独特的\"},{\"wordType\":\"n\",\"mean\":\" 个人,个体\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('23cbeacd-ea45-3e9c-ad98-07d6cbe2f4d6', 'mentor', '[{\"wordType\":\"n\",\"mean\":\" 指导者,良师益友\"},{\"wordType\":\"vt\",\"mean\":\" 指导\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('2486923a-98e7-3fd0-b403-81d01acd1782', 'presentation', '[{\"wordType\":\"n\",\"mean\":\" 展示;描述,陈述;介绍;赠送\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('27391079-9eac-3ace-806a-ba83c9d54906', 'alien', '[{\"wordType\":\"adj\",\"mean\":\" 外国的;相异的,性质不同的;不相容的\"},{\"wordType\":\"n\",\"mean\":\" 外国人,外侨;外星人\"},{\"wordType\":\"vt\",\"mean\":\" 让渡,转让\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('28df85f4-9721-3ee9-9b87-c9eae6680a5c', 'settled', '[{\"wordType\":\"adj\",\"mean\":\" 稳定的;固定的\"},{\"wordType\":\"v\",\"mean\":\" 解决;定居\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('2a9bdb3d-28d0-332d-960f-b8a27ae1f473', 'rapid', '[{\"wordType\":\"adj\",\"mean\":\" 迅速的,急促的;飞快的;险峻的\"},{\"wordType\":\"n\",\"mean\":\" 急流;高速交通工具,高速交通网\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('2e2f5b37-ef2f-310d-af61-665798ec0a5d', 'plow', '[{\"wordType\":\"vi\",\"mean\":\" [农机] 犁;耕地;破浪前进;开路\"},{\"wordType\":\"vt\",\"mean\":\" [农机] 犁;耕;开路\"},{\"wordType\":\"n\",\"mean\":\" [农机] 犁;似犁的工具;北斗七星\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('32343e35-c685-38f5-88cb-66b3e25f1d6e', 'arctic', '[{\"wordType\":\"adj\",\"mean\":\" 北极的;极寒的\"},{\"wordType\":\"n\",\"mean\":\" 北极圈;御寒防水套鞋\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('336e8afd-a70b-3ff7-a42f-bfd312cb633f', 'seal', '[{\"wordType\":\"n\",\"mean\":\" 密封;印章;海豹;封条;标志\"},{\"wordType\":\"vt\",\"mean\":\" 密封;盖章\"},{\"wordType\":\"vi\",\"mean\":\" 猎海豹\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('34c7d363-f684-3308-b306-c0c437bc1b7d', 'scientifically', '[{\"wordType\":\"adj\",\"mean\":\" 科学的,系统的\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('372b694c-b17f-3241-9432-3296628c9ba0', 'participate', '[{\"wordType\":\"vi\",\"mean\":\" 参与,参加;分享\"},{\"wordType\":\"vt\",\"mean\":\" 分享;分担\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('37fc7ede-e25a-3774-b4ea-ebe7f7b09785', 'flat', '[{\"wordType\":\"adj\",\"mean\":\" 平的;单调的;不景气的;干脆的;平坦的;扁平的;浅的\"},{\"wordType\":\"adv\",\"mean\":\" 平直地;断然地;水平地;直接地,完全地\"},{\"wordType\":\"n\",\"mean\":\" 平地;公寓;平面\"},{\"wordType\":\"vt\",\"mean\":\" 使变平;[音乐]使（音调）下降,尤指降半音\"},{\"wordType\":\"vi\",\"mean\":\" 逐渐变平;[音乐]以降调唱（或奏）\"}]', '35d6d334-67aa-39a2-a3dc-cb4b6b027878', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('38b964d2-1807-3a47-984d-373699ed1c7b', 'involve', '[{\"wordType\":\"vt\",\"mean\":\" 包含;牵涉;使陷于;潜心于\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('394639f9-6b4b-3e6e-bf3d-662457648fff', 'unemployment', '[{\"wordType\":\"n\",\"mean\":\" 失业;失业率;失业人数\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('3a86a7b9-351d-30b2-85ae-d66baa175107', 'morality', '[{\"wordType\":\"n\",\"mean\":\" 道德;品行,美德\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('3b7770f7-743e-3f01-b0fd-807f304a21d0', 'adjust', '[{\"wordType\":\"vt\",\"mean\":\" 调整,使…适合;校准\"},{\"wordType\":\"vi\",\"mean\":\" 调整,校准;适应\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('3d2fe685-5a56-3e8a-93a1-672481c64592', 'implication', '[{\"wordType\":\"n\",\"mean\":\" 含义;暗示;牵连,卷入;可能的结果,影响\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('3d4e992d-8d8a-3d84-8724-aa26ed7f4176', 'director', '[{\"wordType\":\"n\",\"mean\":\" 主任,主管;导演;人事助理\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('3e08488f-9bcc-3dd5-8192-b3db89f6612c', 'paranormal', '[{\"wordType\":\"adj\",\"mean\":\" 超常的;超过正常范围的\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('3f1b0333-a44f-35f6-91d3-429887eba4a8', 'season', '[{\"wordType\":\"n\",\"mean\":\" 时期;季节;赛季\"},{\"wordType\":\"vt\",\"mean\":\" 给…调味;使适应\"},{\"wordType\":\"vi\",\"mean\":\" 变得成熟;变干燥\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('3fcdb73d-36d5-3f2c-822d-0f68e6b6e182', 'form', '[{\"wordType\":\"n\",\"mean\":\" 形式,形状;形态,外形;方式;表格\"},{\"wordType\":\"vt\",\"mean\":\" 构成,组成;排列,组织;产生,塑造\"},{\"wordType\":\"vi\",\"mean\":\" 形成,构成;排列\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('40bc2c33-26dc-30c9-aa95-f303f2165aa0', 'fur', '[{\"wordType\":\"n\",\"mean\":\" 皮,皮子;毛皮;软毛\"},{\"wordType\":\"n\",\"mean\":\" 水垢\"},{\"wordType\":\"vt\",\"mean\":\" 用毛皮覆盖\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('40bdb060-1848-3838-8520-ab7419d2accf', 'greece', '[{\"wordType\":\"n\",\"mean\":\" 希腊\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('431387eb-7262-31cf-879b-125eb8a67c60', 'proxy', '[{\"wordType\":\"n\",\"mean\":\" 代理人;委托书;代用品\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('432c5afd-b3d9-3473-bde4-39a8c7b5577f', 'ancient', '[{\"wordType\":\"adj\",\"mean\":\" 古代的;古老的,过时的;年老的\"},{\"wordType\":\"n\",\"mean\":\" 古代人;老人\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('43730ab7-a59c-364b-8266-1edf1c346d10', 'ancestor', '[{\"wordType\":\"n\",\"mean\":\" 始祖,祖先;被继承人\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('4596647e-a31b-3ace-ac01-1c1b99b2388d', 'perception', '[{\"wordType\":\"n\",\"mean\":\" 认识能力;知觉,感觉;洞察力;看法;获取\"}]', '8cbad96a-ced4-3b38-b8dd-9f07f6ef5772', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('467c2c71-7cbc-3674-a3fa-61a6d47fe7fa', 'futuristic', '[{\"wordType\":\"adj\",\"mean\":\" 未来派的;未来主义的\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('46ebfdc1-5199-36f4-b6cd-1081b525d98f', 'iceberg', '[{\"wordType\":\"n\",\"mean\":\" [地理] 冰山;显露部分\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('4776c350-4c43-3386-9813-0796a1fce1cc', 'charter', '[{\"wordType\":\"n\",\"mean\":\" 宪章;执照;特许状\"},{\"wordType\":\"v\",\"mean\":\" 包租;发给特许执照\"},{\"wordType\":\"adj\",\"mean\":\" 包租的\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('478b5d64-bfbd-33dc-92a2-3229e1e974e0', 'plausible', '[{\"wordType\":\"adj\",\"mean\":\" 看似可信的;花言巧语的,巧言令色的;貌似真实的,貌似有理的\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('47982c18-f486-3b2e-9f96-bfe9f73f12bf', 'rush', '[{\"wordType\":\"n\",\"mean\":\" 冲进;匆促;急流;灯心草\"},{\"wordType\":\"adj\",\"mean\":\" 急需的\"},{\"wordType\":\"vt\",\"mean\":\" 使冲;突袭;匆忙地做;飞跃\"},{\"wordType\":\"vi\",\"mean\":\" 冲;奔;闯;赶紧;涌现\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('48438b67-b2ac-3e5d-89df-6f3723fd4ccd', 'criminal', '[{\"wordType\":\"adj\",\"mean\":\" 犯罪的;刑事的;罪过的,错误的;不道德的;令人震惊的\"},{\"wordType\":\"n\",\"mean\":\" 罪犯\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('48920c07-1f6a-3c97-ae37-39be64630697', 'parallel', '[{\"wordType\":\"n\",\"mean\":\" 平行线;对比\"},{\"wordType\":\"vt\",\"mean\":\" 使…与…平行\"},{\"wordType\":\"adj\",\"mean\":\" 平行的;类似的,相同的\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('4b9098a2-c421-31af-b6e7-383493b0a59f', 'facilitated', '[{\"wordType\":\"v\",\"mean\":\" 促进;帮助（facilitate的过去分词）;使有利发展\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('4c9858e0-82ca-35bd-a14a-9efc0f2f8cec', 'reach', '[{\"wordType\":\"vi\",\"mean\":\" 达到;延伸;伸出手;传开\"},{\"wordType\":\"vt\",\"mean\":\" 达到;影响;抵达;伸出\"},{\"wordType\":\"n\",\"mean\":\" 范围;延伸;河段;横风行驶\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('4cb1d9d9-f604-3f82-8315-ff9a493e6e83', 'overtake', '[{\"wordType\":\"vt\",\"mean\":\" 赶上;压倒;突然来袭\"},{\"wordType\":\"vi\",\"mean\":\" 超车\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('4d066bbb-0e40-3be5-8f30-00755a45aa6e', 'purpose', '[{\"wordType\":\"n\",\"mean\":\" 目的;用途;意志\"},{\"wordType\":\"vt\",\"mean\":\" 决心;企图;打算\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('4e85eddf-8868-32ca-bcb8-93ddd3f07051', 'passenger', '[{\"wordType\":\"n\",\"mean\":\" 旅客;乘客;过路人;碍手碍脚的人\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('506e0cf7-4315-3aa6-86ce-5ade3ec093a6', 'inhabit', '[{\"wordType\":\"vt\",\"mean\":\" 栖息;居住于;占据\"},{\"wordType\":\"vi\",\"mean\":\" （古）居住;栖息\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('5271e118-dc81-3db5-83b7-856bb6ea0445', 'coal', '[{\"wordType\":\"n\",\"mean\":\" 煤;煤块;木炭\"},{\"wordType\":\"v\",\"mean\":\" 供煤;采煤,提炼煤;把……烧成炭;加煤\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('52f4ceba-c942-3226-be9c-b34ff40dad53', 'layoff', '[{\"wordType\":\"n\",\"mean\":\" 活动停止期间;临时解雇;操作停止;失业期\"}]', 'f52b5e44-9a23-33c0-b1a0-c3a1109360bf', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('533eee4d-0549-3d10-a546-ba62955a212e', 'airwave', '[{\"wordType\":\"n\",\"mean\":\" 电视,广播的频道;电波\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('54cf0d15-829b-30bb-b867-d66bda710c97', 'giant', '[{\"wordType\":\"n\",\"mean\":\" 巨人;伟人;巨大的动物;巨型植物;大公司\"},{\"wordType\":\"adj\",\"mean\":\" 巨大的;巨人般的;伟大的\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('54f7b01b-04b1-30ae-b471-4e0b6b8a0045', 'efficient', '[{\"wordType\":\"adj\",\"mean\":\" 有效率的;有能力的;生效的\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('550237b8-fbcd-3374-9bb1-127d0fc7f6bf', 'solution', '[{\"wordType\":\"n\",\"mean\":\" 解决方案;溶液;溶解;解答\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('554d7f8f-e5d6-3490-8d28-9209bdd739ac', 'opinion', '[{\"wordType\":\"n\",\"mean\":\" 意见;主张\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('5641b112-1c44-3492-9fde-6b274d164e60', 'fiction', '[{\"wordType\":\"n\",\"mean\":\" 小说;虚构,编造;谎言\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('564afb42-7cb3-371f-aaf0-285572efecf8', 'govern', '[{\"wordType\":\"vt\",\"mean\":\" 管理;支配;统治;控制\"},{\"wordType\":\"vi\",\"mean\":\" 居支配地位;进行统治\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('5741a8f2-1681-3af6-99bb-c27a4e73b8e0', 'melt', '[{\"wordType\":\"vi\",\"mean\":\" 熔化,溶解;渐混\"},{\"wordType\":\"vt\",\"mean\":\" 使融化;使熔化;使软化;使感动\"},{\"wordType\":\"n\",\"mean\":\" 熔化;熔化物\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('578d1523-391f-3a90-a426-27f2da06b641', 'electronically', '[{\"wordType\":\"adv\",\"mean\":\" 电子地\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('59417166-c47f-3e6b-b0d1-a6701bf4efdd', 'motor', '[{\"wordType\":\"n\",\"mean\":\" 发动机,马达;汽车\"},{\"wordType\":\"adj\",\"mean\":\" 汽车的;机动的\"},{\"wordType\":\"vi\",\"mean\":\" 乘汽车\"},{\"wordType\":\"vt\",\"mean\":\" 以汽车载运\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('59a9f877-55ec-323b-8db7-3207fc8362df', 'predict', '[{\"wordType\":\"v\",\"mean\":\" 预言,预知,预卜;做预报;断言\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('5a76e813-d6a0-3405-88b9-1acc11557bd2', 'vehicle', '[{\"wordType\":\"n\",\"mean\":\" [车辆] 车辆;工具;交通工具;运载工具;传播媒介;媒介物\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('5b9d04a4-1596-36ff-93f5-606c0816cb69', 'speculation', '[{\"wordType\":\"n\",\"mean\":\" 投机;推测;思索;投机买卖\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('5ccf641f-0738-3c20-bc4e-05f24b2c860a', 'peninsula', '[{\"wordType\":\"n\",\"mean\":\" 半岛\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('5da21a3e-cff2-3145-a8fc-0997c69f72bc', 'plate', '[{\"wordType\":\"n\",\"mean\":\" 碟;金属板;金属牌;感光底片\"},{\"wordType\":\"vt\",\"mean\":\" 电镀;给…装甲\"}]', 'bb3aec0f-dcdb-3297-8890-f805c585d432', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('5e765093-9bb8-30e3-8094-87390de60f13', 'suspension', '[{\"wordType\":\"n\",\"mean\":\" 悬浮;暂停;停职\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('5f099425-f5cf-3f06-9747-d0a5c4e50764', 'efficiency', '[{\"wordType\":\"n\",\"mean\":\" 效率;效能;功效\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('5fa9db2e-335e-369a-8eeb-9fe7974d61f4', 'mar', '[{\"wordType\":\"vt\",\"mean\":\" 破坏,损毁;损伤;糟蹋;玷污;损坏……外表\"},{\"wordType\":\"n\",\"mean\":\" 污点,瑕疵\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('6068e6ec-34bc-3950-82f5-6600e93b73d9', 'interpersonal', '[{\"wordType\":\"adj\",\"mean\":\" 人际的;人与人之间的\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('610d8f7b-72ab-3bd3-a167-d4dc0df90153', 'athlete', '[{\"wordType\":\"n\",\"mean\":\" 运动员,体育家;身强力壮的人\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('6220a030-be5f-3a8c-8760-d3e9b4d5d9ee', 'lesson', '[{\"wordType\":\"n\",\"mean\":\" 教训;课\"},{\"wordType\":\"vt\",\"mean\":\" 教训;上课\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('63ce5df4-a6b9-3d04-9b47-c7d6b67e7c4b', 'visa', '[{\"wordType\":\"n\",\"mean\":\" 签证\"},{\"wordType\":\"vt\",\"mean\":\" 签发签证\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('66f7dd3d-00b6-3af3-92d3-7af04c1ec2f7', 'voyage', '[{\"wordType\":\"n\",\"mean\":\" 航行;航程;旅行记\"},{\"wordType\":\"vi\",\"mean\":\" 航行;航海\"},{\"wordType\":\"vt\",\"mean\":\" 飞过;渡过\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('6767f5cd-a48e-3dfa-9bb9-f7bfbad56ebb', 'settlement', '[{\"wordType\":\"n\",\"mean\":\" 解决,处理;[会计] 结算;沉降;殖民\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('67729290-49d1-3e5e-9110-69fbdd554840', 'reshape', '[{\"wordType\":\"vt\",\"mean\":\" 改造;再成形\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('6825f454-af66-307a-bf5e-c2f1886e53df', 'outperform', '[{\"wordType\":\"vt\",\"mean\":\" 胜过;做得比……好\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('695bf60e-03f8-3a36-a99a-f46519e8e584', 'transmission', '[{\"wordType\":\"n\",\"mean\":\" 传动装置,[机] 变速器;传递;传送;播送\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('699ad831-7146-3be1-b37b-39314c73a113', 'politicain', '[{\"wordType\":\"n\",\"mean\":\" 政治家,政客\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('69fb8e8b-1120-3853-82bf-91ba1abd3ed4', 'inform', '[{\"wordType\":\"vt\",\"mean\":\" 通知;告诉;报告\"},{\"wordType\":\"vi\",\"mean\":\" 告发;告密\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('6b341881-ce7c-3bfb-8fbb-be7171f27cdc', 'pure', '[{\"wordType\":\"adj\",\"mean\":\" 纯的;纯粹的;纯洁的;清白的;纯理论的\"}]', '24d27c16-9c2c-381e-b09a-065116f2aa5c', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('6f482608-df6a-30d2-9944-dd2c171a5626', 'intend', '[{\"wordType\":\"vt\",\"mean\":\" 打算;想要;意指\"},{\"wordType\":\"vi\",\"mean\":\" 有打算\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('6f93d016-70cd-3033-affc-62047021c9c6', 'ethnicity', '[{\"wordType\":\"n\",\"mean\":\" 种族划分\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('7123a699-d77d-3647-9a1d-8ece2c4f1c16', 'instance', '[{\"wordType\":\"n\",\"mean\":\" 实例;情况;建议\"},{\"wordType\":\"vt\",\"mean\":\" 举\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('72133c45-368d-3b04-ac1e-108d83d15e52', 'determine', '[{\"wordType\":\"v\",\"mean\":\" （使）下决心,（使）做出决定\"},{\"wordType\":\"vt\",\"mean\":\" 决定,确定;判定,判决;限定\"},{\"wordType\":\"vi\",\"mean\":\" 确定;决定;判决,终止;[主用于法律]了结,终止,结束\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('72858d1a-f3c5-3029-95dc-0bf1a77b6d9e', 'frozen', '[{\"wordType\":\"adj\",\"mean\":\" 冻结的;冷酷的\"},{\"wordType\":\"v\",\"mean\":\" 结冰\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('737ad500-5108-3aa0-91d1-27a53b3ac0da', 'productivity', '[{\"wordType\":\"n\",\"mean\":\" 生产力;生产率;生产能力\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('73a6fcb0-1653-3503-954c-ecf09b787015', 'strange', '[{\"wordType\":\"adj\",\"mean\":\" 奇怪的;陌生的;外行的\"},{\"wordType\":\"adv\",\"mean\":\" 奇怪地;陌生地,冷淡地\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('73d5342e-ba07-3f63-aac3-246f319bf77f', 'section', '[{\"wordType\":\"n\",\"mean\":\" 截面;部分;部门;地区;章节\"},{\"wordType\":\"vi\",\"mean\":\" 被切割成片;被分成部分\"},{\"wordType\":\"vt\",\"mean\":\" 把…分段;将…切片;对…进行划分\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('748369c9-31c8-36a2-9edd-c032d3ff3d0c', 'firm', '[{\"wordType\":\"n\",\"mean\":\" 商行;商号;公司\"},{\"wordType\":\"adj\",\"mean\":\" 坚定的;牢固的;严格的;结实的;坚决的;牢牢控制的;坚挺的\"},{\"wordType\":\"adv\",\"mean\":\" 坚信;坚持;稳固地\"},{\"wordType\":\"v\",\"mean\":\" 使坚定;使牢固\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('74d08617-d74a-3f19-bd56-b9d2616415e0', 'explanation', '[{\"wordType\":\"n\",\"mean\":\" 说明,解释;辩解\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('74fd6e3f-a7c8-3af2-bab0-e2fce4b4ddea', 'icy', '[{\"wordType\":\"adj\",\"mean\":\" 冰冷的;结满冰的;冷淡的\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('759d0863-111d-3967-b466-9c0c36153c76', 'pervasive', '[{\"wordType\":\"adj\",\"mean\":\" 普遍的;到处渗透的;流行的\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('75abd646-aa79-32eb-b38f-b51b49178384', 'further', '[{\"wordType\":\"adv\",\"mean\":\" 更远地;远非;进一步地;而且;处于更高阶段\"},{\"wordType\":\"adj\",\"mean\":\" 更多的,附加的;更远的;进一步的,深一层的\"},{\"wordType\":\"v\",\"mean\":\" 促进,增进,助长\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('772b7691-7b47-3888-b8f3-c947de6d917a', 'marriage', '[{\"wordType\":\"n\",\"mean\":\" 结婚;婚姻生活;密切结合,合并\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('776ea3bf-11df-3829-827f-7afb43c37174', 'integration', '[{\"wordType\":\"n\",\"mean\":\" 集成;综合\"}]', 'c785e1ed-2950-33e3-ab1e-2ca01f299a54', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('78056ebb-02cf-3c14-bb7e-ce14904812dc', 'bonus', '[{\"wordType\":\"n\",\"mean\":\" 奖金;红利;额外津贴\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('79a5ffd5-84dd-34b7-9fbe-8bbc33f3503b', 'photoconductive', '[{\"wordType\":\"adj\",\"mean\":\" 光电导的;光敏的\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('7a1c07ff-60f9-307f-be8d-a34ecbf4edc2', 'fantasy', '[{\"wordType\":\"n\",\"mean\":\" 幻想;白日梦;幻觉\"},{\"wordType\":\"adj\",\"mean\":\" 虚幻的\"},{\"wordType\":\"vt\",\"mean\":\" 空想;想像\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('7c5bd03b-4517-3fa3-af00-aa91090dc0aa', 'literature', '[{\"wordType\":\"n\",\"mean\":\" 文学;文献;文艺;著作\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('7caa701b-2bd5-3182-b80c-72b9bdf88e2d', 'direct', '[{\"wordType\":\"adj\",\"mean\":\" 直接的;直系的;亲身的;恰好的\"},{\"wordType\":\"vt\",\"mean\":\" 管理;指挥;导演;指向\"},{\"wordType\":\"vi\",\"mean\":\" 指导;指挥\"},{\"wordType\":\"adv\",\"mean\":\" 直接地;正好;按直系关系\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('7cc26095-7727-32a3-a99c-e612807f4f3c', 'ease', '[{\"wordType\":\"n\",\"mean\":\" 容易;舒适;安逸\"},{\"wordType\":\"v\",\"mean\":\" 减轻,缓解;小心缓缓地移动\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('7d9a0d11-cb36-312a-a881-7aff945390de', 'universe', '[{\"wordType\":\"n\",\"mean\":\" 宇宙;世界;领域\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('7ddf8080-3ddb-30e6-b1c6-633a1f4d1943', 'actually', '[{\"wordType\":\"adv\",\"mean\":\" 实际上;事实上\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('7e94d23f-ce22-3fd6-86c5-7839d5272edf', 'sufficiently', '[{\"wordType\":\"adv\",\"mean\":\" 充分地;足够地\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('7f80095a-ea4d-36af-9121-f1fbe916066d', 'genre', '[{\"wordType\":\"n\",\"mean\":\" 类型;种类;体裁;样式;流派;风俗画\"},{\"wordType\":\"adj\",\"mean\":\" 风俗画的;以日常情景为主题的\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('80dbf87f-21ba-3c68-8482-e0b37bff584d', 'chief', '[{\"wordType\":\"n\",\"mean\":\" 首领;酋长;主要部分\"},{\"wordType\":\"adj\",\"mean\":\" 首席的;主要的;主任的\"},{\"wordType\":\"adv\",\"mean\":\" 主要地;首要地\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('813f8ce5-80f2-3655-8ce9-e5093468b1ab', 'village', '[{\"wordType\":\"n\",\"mean\":\" 村庄;村民;（动物的）群落\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('831996ce-bc6c-3bf7-a87e-922c3437be69', 'passive', '[{\"wordType\":\"adj\",\"mean\":\" 被动的,消极的;被动语态的\"},{\"wordType\":\"n\",\"mean\":\" 被动语态\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('8451fc65-3eaa-3696-a4a6-d9b46a238424', 'least', '[{\"wordType\":\"adj\",\"mean\":\" 最小的;最少的（little的最高级）\"},{\"wordType\":\"adv\",\"mean\":\" 最小;最少\"},{\"wordType\":\"n\",\"mean\":\" 最小;最少\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('85592332-5fa2-3283-9da6-da090d10fdf2', 'cable', '[{\"wordType\":\"n\",\"mean\":\" 缆绳;电缆;海底电报\"},{\"wordType\":\"vt\",\"mean\":\" 打电报\"},{\"wordType\":\"vi\",\"mean\":\" 打海底电报\"}]', 'b1b9a972-ccd8-3962-a473-909b97007eb4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('85dbdb21-fe50-3c4d-ba1e-81bca0aa396d', 'purchase', '[{\"wordType\":\"v\",\"mean\":\" 购买;获得,赢得;升起,举起\"},{\"wordType\":\"n\",\"mean\":\" 购买;购买的东西;支点;财产置得\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('88627d1f-e4d5-3f9e-8b34-1f0dbf0370b5', 'talent', '[{\"wordType\":\"n\",\"mean\":\" 才能;天才;天资\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('893b56e3-cfe1-33fb-b70a-120b83bac20c', 'bear', '[{\"wordType\":\"v\",\"mean\":\" 忍受,承受;不适于某事;承担责任;经得起\"},{\"wordType\":\"n\",\"mean\":\" 熊;泰迪熊;（股票）卖空者;（非正式）没教养的人\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('8aaab337-4041-3527-83d6-f2be39c6ed2c', 'opportunity', '[{\"wordType\":\"n\",\"mean\":\" 时机,机会\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('8b373710-bcf8-36ed-991f-281e50ed58ab', 'brain', '[{\"wordType\":\"n\",\"mean\":\" 头脑,智力;脑袋\"},{\"wordType\":\"vt\",\"mean\":\" 猛击…的头部\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('8c73a98a-3009-3590-8337-f535531dfca6', 'shape', '[{\"wordType\":\"n\",\"mean\":\" 形状;模型;身材;具体化\"},{\"wordType\":\"vt\",\"mean\":\" 形成;塑造,使成形;使符合\"},{\"wordType\":\"vi\",\"mean\":\" 形成;成形;成长\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('8cb55412-7837-3400-a338-c10a299289fb', 'profit', '[{\"wordType\":\"n\",\"mean\":\" 利润;利益\"},{\"wordType\":\"vi\",\"mean\":\" 获利;有益\"},{\"wordType\":\"vt\",\"mean\":\" 有益于\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('8e73292e-b50d-32a4-9821-91e01ed9e1b5', 'sophistication', '[{\"wordType\":\"n\",\"mean\":\" 复杂;诡辩;老于世故;有教养\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('90888020-9a64-3a53-9ae8-dc5fdb7e0a91', 'stock', '[{\"wordType\":\"n\",\"mean\":\" 股份,股票;库存;血统;树干;家畜\"},{\"wordType\":\"adj\",\"mean\":\" 存货的,常备的;平凡的\"},{\"wordType\":\"vt\",\"mean\":\" 进货;备有;装把手于…\"},{\"wordType\":\"vi\",\"mean\":\" 囤积;办货;出新芽\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('9090cf2e-fa28-334b-94a8-53251679809f', 'impulse', '[{\"wordType\":\"n\",\"mean\":\" 冲动;[电子] 脉冲;刺激;神经冲动;推动力\"},{\"wordType\":\"vt\",\"mean\":\" 推动\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('91c366db-3df8-321e-ab76-be5c250f1a40', 'tube', '[{\"wordType\":\"n\",\"mean\":\" 管;电子管;隧道;电视机\"},{\"wordType\":\"vt\",\"mean\":\" 使成管状;把…装管;用管输送\"},{\"wordType\":\"vi\",\"mean\":\" 乘地铁;不及格\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('93ab957b-29bb-3256-8f18-50110f29120d', 'obvious', '[{\"wordType\":\"adj\",\"mean\":\" 明显的;显著的;平淡无奇的\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('94e7e210-5434-35d2-9c1e-e610e7b4af1d', 'estimate', '[{\"wordType\":\"n\",\"mean\":\" 估计,估价;判断,看法\"},{\"wordType\":\"v\",\"mean\":\" 估计,估量;判断,评价\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('95236b97-3449-3a44-b87b-73f7eb756b4c', 'inevitably', '[{\"wordType\":\"adv\",\"mean\":\" 不可避免地;必然地\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('95ad4cd2-2ff6-328b-b718-396dc8a36dc2', 'symbolize', '[{\"wordType\":\"vt\",\"mean\":\" 象征;用符号表现\"},{\"wordType\":\"vi\",\"mean\":\" 采用象征;使用符号;作为…的象征\"}]', '9c8454dd-f7aa-3011-a496-bac348d7550d', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('960db2ed-8220-3a97-86b9-7775a4269378', 'region', '[{\"wordType\":\"n\",\"mean\":\" 地区;范围;部位\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('96d4976b-516a-36ac-99d1-48f3b744eee1', 'victim', '[{\"wordType\":\"n\",\"mean\":\" 受害人,牺牲品,牺牲者;受骗者,上当的人;祭品,牺牲;无助者,被动者\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('96f5c06f-ee4b-32dd-a90d-1f41687a31e2', 'tough', '[{\"wordType\":\"adj\",\"mean\":\" 艰苦的,困难的;坚强的,不屈不挠的\"},{\"wordType\":\"n\",\"mean\":\" 恶棍\"},{\"wordType\":\"vt\",\"mean\":\" 坚持;忍受,忍耐\"},{\"wordType\":\"adv\",\"mean\":\" 强硬地,顽强地\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('972c97bd-c47d-3c8d-af0e-74c55da0bbfd', 'explore', '[{\"wordType\":\"vt\",\"mean\":\" 探索;探测;探险\"},{\"wordType\":\"vi\",\"mean\":\" 探索;探测;探险\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('97e10870-c1c1-330f-8651-9c9006903c9b', 'federal', '[{\"wordType\":\"adj\",\"mean\":\" 联邦的;同盟的;联邦政府的; 联邦制的\"},{\"wordType\":\"adv\",\"mean\":\" 联邦政府地\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('993a0f1e-b3c7-3e7f-a053-4a6f61ac82e7', 'depart', '[{\"wordType\":\"vi\",\"mean\":\" 离开;出发,起程;违反;去世\"},{\"wordType\":\"adj\",\"mean\":\" 逝世的\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('99d9a11f-a5a7-3da9-94b8-fcb737a0cb2c', 'reality', '[{\"wordType\":\"n\",\"mean\":\" 现实;实际;真实\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('9ad80839-9723-37b8-99d8-9c8682f058c7', 'western', '[{\"wordType\":\"adj\",\"mean\":\" 西方的,西部的;有西方特征的\"},{\"wordType\":\"n\",\"mean\":\" 西方人;西部片,西部小说\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('9b6d0bb3-102b-37fa-a57b-c4a39149518e', 'publish', '[{\"wordType\":\"vt\",\"mean\":\" 出版;发表;公布\"},{\"wordType\":\"vi\",\"mean\":\" 出版;发行;刊印\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('9c46408a-3bc6-35c6-8505-c57a11d6c4ee', 'route', '[{\"wordType\":\"n\",\"mean\":\" 路线,航线;道路,公路\"},{\"wordType\":\"v\",\"mean\":\" 按特定路线发送,为……规定路线\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('9d053763-a907-37ee-b893-99cee7c55e77', 'lumber', '[{\"wordType\":\"v\",\"mean\":\" 笨重地行动,缓慢地移动\"},{\"wordType\":\"n\",\"mean\":\" 木材; 废旧家具,废物\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('9ea0a36b-3a20-301f-afe8-34eb519a595c', 'plant', '[{\"wordType\":\"n\",\"mean\":\" 工厂,车间;植物;设备;庄稼\"},{\"wordType\":\"vt\",\"mean\":\" 种植;培养;栽培;安置\"},{\"wordType\":\"vi\",\"mean\":\" 种植\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('a04fe4e3-90a7-37d5-9458-3f85d24e164d', 'alternative', '[{\"wordType\":\"adj\",\"mean\":\" 供选择的;选择性的;交替的\"},{\"wordType\":\"n\",\"mean\":\" 二中择一;供替代的选择\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('a06b8c4f-8e98-386d-a9fd-f3d7bbf46ba1', 'considerable', '[{\"wordType\":\"adj\",\"mean\":\" 相当大的;重要的,值得考虑的\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('a3aae4f9-f4b8-3b85-aa07-3234e7edc2ac', 'caught', '[{\"wordType\":\"v\",\"mean\":\" 捕捉\"}]', '15f6f8dc-0365-39d7-be15-b39338f6e5db', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('a552c747-84b3-3821-b7bc-a6c8adde0efb', 'fill', '[{\"wordType\":\"vt\",\"mean\":\" 装满,使充满;满足;堵塞;任职\"},{\"wordType\":\"vi\",\"mean\":\" 被充满,膨胀\"},{\"wordType\":\"n\",\"mean\":\" 满足;填满的量;装填物\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('a7887cc8-09cf-3d4d-b17f-c5dafd03e4e7', 'smooth', '[{\"wordType\":\"adj\",\"mean\":\" 顺利的;光滑的;平稳的\"},{\"wordType\":\"vt\",\"mean\":\" 使光滑;消除（障碍等）;使优雅;缓和\"},{\"wordType\":\"n\",\"mean\":\" 平滑部分;一块平地\"},{\"wordType\":\"vi\",\"mean\":\" 变平静;变平滑\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('a9bfaef5-6239-3c30-abed-90577ebc00c1', 'spectator', '[{\"wordType\":\"n\",\"mean\":\" 观众;旁观者\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('ab334fee-b31c-3512-8cb7-3fa12571c2f6', 'captain', '[{\"wordType\":\"n\",\"mean\":\" 队长,首领;船长;上尉;海军上校\"},{\"wordType\":\"vt\",\"mean\":\" 指挥;率领\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('ad82e95a-9c74-32cf-b3cf-e59a30ea4060', 'camp', '[{\"wordType\":\"n\",\"mean\":\" 露营;营地;度假营;拘留营;兵营;阵营\"},{\"wordType\":\"v\",\"mean\":\" 露营;扎营;（牲畜）集中休息;扎围栏\"},{\"wordType\":\"adj\",\"mean\":\" 女性化的;夸张的\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('ae254d63-f238-3cc1-83c1-1594873793e0', 'force', '[{\"wordType\":\"n\",\"mean\":\" 力量;武力;军队;魄力\"},{\"wordType\":\"vt\",\"mean\":\" 促使,推动;强迫;强加\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('af60b8f5-5775-32a2-a59c-1ab297cf8826', 'undocumented', '[{\"wordType\":\"adj\",\"mean\":\" 无事实证明的;无正式文件的\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('b0b701ff-f3d0-3c5b-915f-9293cb4ede4d', 'permanent', '[{\"wordType\":\"adj\",\"mean\":\" 永久的,永恒的;不变的\"},{\"wordType\":\"n\",\"mean\":\" 烫发\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('b0dfb804-1ba0-33cf-98a9-dc5523725f59', 'philosophical', '[{\"wordType\":\"adj\",\"mean\":\" 哲学的;冷静的\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('b289d132-bc14-3db7-a9a0-ef741509c067', 'incent', '[{\"wordType\":\"v\",\"mean\":\" 激励,鼓励\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('b35d4a4d-47b5-3fd3-85d7-47e7c87fa0d1', 'identify', '[{\"wordType\":\"vt\",\"mean\":\" 确定;鉴定;识别,辨认出;使参与\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('b46b517b-77d3-3717-af23-adef739a8f39', 'ownership', '[{\"wordType\":\"n\",\"mean\":\" 所有权;物主身份\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('b569cc45-0324-3aa2-8a8c-1ee36a99d6aa', 'classify', '[{\"wordType\":\"vt\",\"mean\":\" 分类;分等\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('b605ea60-9b9d-3cf2-95cf-d5a7803dcd37', 'broadcast', '[{\"wordType\":\"v\",\"mean\":\" 播送;参加节目;传播;播撒（种子）\"},{\"wordType\":\"n\",\"mean\":\" 节目;播送;撒播;广播播放时段\"},{\"wordType\":\"adj\",\"mean\":\" 广播节目的;撒播的;无线电广播的\"},{\"wordType\":\"adv\",\"mean\":\" 撒播地\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('b72f3bd3-91ba-331a-b570-8bfd8cd8a68f', 'dynamic', '[{\"wordType\":\"adj\",\"mean\":\" 动态的;动力的;动力学的;有活力的\"},{\"wordType\":\"n\",\"mean\":\" 动态;动力\"}]', '422ecc08-4f24-38de-bc62-0ecebf2a6448', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('b891b62a-b9be-3813-b9c9-7aec94a62fff', 'wire', '[{\"wordType\":\"n\",\"mean\":\" 电线;金属丝;电报\"},{\"wordType\":\"vt\",\"mean\":\" 拍电报;给…装电线\"},{\"wordType\":\"vi\",\"mean\":\" 打电报\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('b8abf54f-2b10-32cc-8b8f-f1a1a620398a', 'fictional', '[{\"wordType\":\"adj\",\"mean\":\" 虚构的;小说的\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('b9567721-6e43-3d96-ac4f-ba1240a3c1f8', 'voice', '[{\"wordType\":\"n\",\"mean\":\" 声音;嗓音;发言权;愿望\"},{\"wordType\":\"vt\",\"mean\":\" 表达;吐露\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('b9d73862-0685-3407-b55f-cf4814c04048', 'concession', '[{\"wordType\":\"n\",\"mean\":\" 让步;特许（权）;承认;退位\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('be2bb77e-0e1f-327d-8b4c-2b2c254e1468', 'drain', '[{\"wordType\":\"v\",\"mean\":\" 排水;流干;喝光;（感情）变淡;使精疲力竭\"},{\"wordType\":\"n\",\"mean\":\" 排水沟;下水道;负担;消耗\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('c2ab3820-6dce-333f-95d6-6048ad744f03', 'disbelief', '[{\"wordType\":\"n\",\"mean\":\" 怀疑,不信\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('c32add6b-67bd-3c26-850f-1716849bfae9', 'vital', '[{\"wordType\":\"adj\",\"mean\":\" 至关重要的;生死攸关的;有活力的\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('c4ef352f-74e5-32ef-9e7b-c98e6f4e493d', 'category', '[{\"wordType\":\"n\",\"mean\":\" 种类,分类;[数] 范畴\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('c88c137e-5879-308c-9c0b-a3c1e5458d70', 'undertone', '[{\"wordType\":\"n\",\"mean\":\" 低音;浅色;小声;潜在的含意\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('c8b8d7a4-23ed-3022-b134-ae1f896f8926', 'reconstitute', '[{\"wordType\":\"v\",\"mean\":\" 重新设立,改组\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('cadc8c8d-b424-3973-b582-cb3e2298ef87', 'sort', '[{\"wordType\":\"n\",\"mean\":\" 种类;方式;品质\"},{\"wordType\":\"vi\",\"mean\":\" 分类;协调;交往\"},{\"wordType\":\"vt\",\"mean\":\" 将…分类;将…排序;挑选出某物\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('cc5afe53-cb90-39e4-b680-4f2213725cd2', 'versatility', '[{\"wordType\":\"n\",\"mean\":\" 多功能性;多才多艺;用途广泛\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('ce998251-2b3a-31f5-87e7-c8e57a053551', 'plentiful', '[{\"wordType\":\"adj\",\"mean\":\" 丰富的;许多的;丰饶的;众多的\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('cec8b5c8-b9a6-3fbd-92b6-171a4de65b0d', 'recurrent', '[{\"wordType\":\"adj\",\"mean\":\" 复发的;周期性的,经常发生的\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('cf5c0a6a-33f6-353b-b10b-e6c527fe5c93', 'era', '[{\"wordType\":\"n\",\"mean\":\" 时代;年代;纪元\"}]', '279e962e-a623-3a2a-ba86-739622772e1f', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('cf6c9df6-8ded-36fc-ac9d-509d76ae22cc', 'soil', '[{\"wordType\":\"n\",\"mean\":\" 土地;土壤;国家;粪便;务农;温床\"},{\"wordType\":\"vt\",\"mean\":\" 弄脏;污辱\"},{\"wordType\":\"vi\",\"mean\":\" 变脏\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('cfaa89ec-89b7-3460-9665-cdc0069a56e1', 'establish', '[{\"wordType\":\"v\",\"mean\":\" 建立,创立;确立;获得接受;查实,证实\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('d0b24510-aa89-3aeb-a94b-d61bb3fd99b5', 'hectare', '[{\"wordType\":\"n\",\"mean\":\" 公顷\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('d3440b69-126d-3c18-afdd-c713b18b0002', 'innovation', '[{\"wordType\":\"n\",\"mean\":\" 创新,革新;新方法\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('d41d8cd9-8f00-3204-a980-0998ecf8427e', '', '[]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('d53f18f2-7b06-3a5a-a88f-472a0c2e2745', 'proper', '[{\"wordType\":\"adj\",\"mean\":\" 适当的;本身的;特有的;正派的\"},{\"wordType\":\"adv\",\"mean\":\" 完全地\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('d552cecb-af1a-3a64-866b-42e5d25d282a', 'labor', '[{\"wordType\":\"n\",\"mean\":\" 劳动;工作;劳工;分娩\"},{\"wordType\":\"vi\",\"mean\":\" 劳动;努力;苦干\"},{\"wordType\":\"vt\",\"mean\":\" 详细分析;使厌烦\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('d6614b55-766e-3759-8b66-c763af368a86', 'potential', '[{\"wordType\":\"adj\",\"mean\":\" 潜在的,可能的;势的\"},{\"wordType\":\"n\",\"mean\":\" 潜能,可能性;电势\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('d90ccffa-0127-3a7a-b795-fb6d1274e75f', 'mass', '[{\"wordType\":\"n\",\"mean\":\" 块,团;群众,民众;大量,众多;质量\"},{\"wordType\":\"adj\",\"mean\":\" 群众的,民众的;大规模的,集中的\"},{\"wordType\":\"vi\",\"mean\":\" 聚集起来,聚集\"},{\"wordType\":\"vt\",\"mean\":\" 使集合\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('d94a1402-cc48-39a2-86b7-1734e2e5b573', 'specialist', '[{\"wordType\":\"n\",\"mean\":\" 专家;专门医师\"},{\"wordType\":\"adj\",\"mean\":\" 专家的;专业的\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('da9c3748-877e-3cc0-a3de-a8073b33986d', 'consequence', '[{\"wordType\":\"n\",\"mean\":\" 结果;重要性;推论\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('db007a5b-cc6c-369c-90fe-542fa1606827', 'encourage', '[{\"wordType\":\"vt\",\"mean\":\" 鼓励,怂恿;激励;支持\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('dc29bc33-3492-3ea3-910f-0aefca005886', 'compel', '[{\"wordType\":\"vt\",\"mean\":\" 强迫,迫使;强使发生\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('dcbaf49b-a66b-346f-8ca4-f829e4a67d88', 'purveyor', '[{\"wordType\":\"n\",\"mean\":\" 承办商;伙食承办商;供应粮食者\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('dd6d2dcc-679d-32b9-830a-9787bab45b33', 'camera', '[{\"wordType\":\"n\",\"mean\":\" 照相机;摄影机\"}]', '92a2132e-0190-36e5-82f1-3376ddc660d5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('df1f0574-34a0-3af5-8f64-83994acf83b0', 'political', '[{\"wordType\":\"adj\",\"mean\":\" 政治的;党派的\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('e1c0a600-7e8f-35c9-ad4b-9f2d0df0551c', 'mining', '[{\"wordType\":\"n\",\"mean\":\" 矿业;采矿\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('e52e7ce4-ac24-3886-bd05-eaad577560db', 'administration', '[{\"wordType\":\"n\",\"mean\":\" 管理;行政;实施;行政机构\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('e7d715a9-b79d-363a-a527-955341bbe9b1', 'principal', '[{\"wordType\":\"adj\",\"mean\":\" 主要的;资本的\"},{\"wordType\":\"n\",\"mean\":\" 首长;校长;资本;当事人\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('e7e94d9e-f1ed-3f2c-ac55-e9966b551295', 'copper', '[{\"wordType\":\"n\",\"mean\":\" 铜;铜币;警察\"},{\"wordType\":\"adj\",\"mean\":\" 铜制的\"},{\"wordType\":\"vt\",\"mean\":\" 镀铜\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('e95b0ee0-ac5e-3c15-90e8-3a480cad2e5b', 'inhabitant', '[{\"wordType\":\"n\",\"mean\":\" 居民;居住者\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('e9dc924f-238f-36cc-a946-5942875fe8f0', 'full', '[{\"wordType\":\"adj\",\"mean\":\" 完全的,完整的;满的,充满的;丰富的;完美的;丰满的;详尽的\"},{\"wordType\":\"adv\",\"mean\":\" 十分,非常;完全地;整整\"},{\"wordType\":\"vt\",\"mean\":\" 把衣服缝得宽大\"},{\"wordType\":\"n\",\"mean\":\" 全部;完整\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('ea2cb693-fb30-3a0f-848f-c3dd24d5860c', 'rationally', '[{\"wordType\":\"adv\",\"mean\":\" 理性地;讲道理地\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('ed122e9d-a85a-33cb-b4a2-046e39cb0275', 'interpret', '[{\"wordType\":\"vt\",\"mean\":\" 说明;口译\"},{\"wordType\":\"vi\",\"mean\":\" 解释;翻译\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('ef09aed4-9ae4-3075-83c9-42401e477845', 'revolution', '[{\"wordType\":\"n\",\"mean\":\" 革命;旋转;运行;循环\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('ef183764-6263-37a5-ae08-2846ae8e9250', 'amnesty', '[{\"wordType\":\"n\",\"mean\":\" 大赦,特赦\"},{\"wordType\":\"vt\",\"mean\":\" 对…实行大赦\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('f068fc98-5d0a-339e-9a12-6d78a28cc4c9', 'stronger', '[{\"wordType\":\"adj\",\"mean\":\" 更强壮的\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('f0891d92-f22e-39e2-a7c8-3f8c8ecc0895', 'pulp', '[{\"wordType\":\"n\",\"mean\":\" 纸浆;果肉;黏浆状物质\"},{\"wordType\":\"vt\",\"mean\":\" 使…化成纸浆;除去…的果肉\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('f0d674f1-e0ed-3292-a67f-149c5983db02', 'literal', '[{\"wordType\":\"adj\",\"mean\":\" 文字的;逐字的;无夸张的\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('f1425da4-0a9f-3d21-ab70-2a1c7feae026', 'major', '[{\"wordType\":\"adj\",\"mean\":\" 主要的;重要的;主修的;较多的\"},{\"wordType\":\"n\",\"mean\":\" [人类] 成年人;主修科目;陆军少校\"},{\"wordType\":\"vi\",\"mean\":\" 主修\"}]', 'bd2c775d-9eaf-3f71-9a52-b55ade9989a4', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('f379cfd7-a55b-3215-b7a8-389d1817a102', 'forest', '[{\"wordType\":\"n\",\"mean\":\" 森林,林区;（森林似的）一丛;皇家林地,御猎场\"},{\"wordType\":\"v\",\"mean\":\" 植林于;被森林覆盖\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('f3d64714-d1f6-37f7-9558-d4252e84ab58', 'classic', '[{\"wordType\":\"adj\",\"mean\":\" 经典的;古典的,传统的;最优秀的\"},{\"wordType\":\"n\",\"mean\":\" 名著;经典著作;大艺术家\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('f4208705-9b37-3e7f-8d9f-0d3a475801a8', 'vision', '[{\"wordType\":\"n\",\"mean\":\" 视力;美景;眼力;幻象;想象力\"},{\"wordType\":\"vt\",\"mean\":\" 想象;显现;梦见\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('f4479ba2-94e4-3605-a18b-3f7950f5c7c5', 'permanently', '[{\"wordType\":\"adv\",\"mean\":\" 永久地,长期不变地\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('f4af8b57-8957-3c00-8ce9-105b25609bd6', 'policy', '[{\"wordType\":\"n\",\"mean\":\" 政策,方针;保险单\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('f8b0b924-ebd7-346d-bfa8-5a856e4682c8', 'graph', '[{\"wordType\":\"n\",\"mean\":\" 图表;曲线图\"},{\"wordType\":\"vt\",\"mean\":\" 用曲线图表示\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('f9b11ed0-3ce2-3394-bd0e-5b19ae2d3873', 'reward', '[{\"wordType\":\"n\",\"mean\":\" 报酬;报答;酬谢\"},{\"wordType\":\"vt\",\"mean\":\"  奖励;奖赏\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('fa5caf54-a500-3ad2-8618-8a8769cb9947', 'polar', '[{\"wordType\":\"adj\",\"mean\":\" 极地的;两极的;正好相反的\"},{\"wordType\":\"n\",\"mean\":\" 极面;极线\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('fb5c7f9b-b4b3-3ce2-b3bf-f4662f1ab27b', 'science', '[{\"wordType\":\"n\",\"mean\":\" 科学;技术;学科;理科\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('fb81c91e-b92d-3cb6-8aeb-64c3f37ef2c4', 'degree', '[{\"wordType\":\"n\",\"mean\":\" 程度,等级;度;学位;阶层\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('fc46e26a-9078-3074-8758-b76166150f62', 'translate', '[{\"wordType\":\"vt\",\"mean\":\" 翻译;转化;解释;转变为;调动\"},{\"wordType\":\"vi\",\"mean\":\" 翻译\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-25 07:55:07', null);
INSERT INTO `english_word` VALUES ('ff2508c7-9c66-31a3-8a7f-dc99c67b10ab', 'deposit', '[{\"wordType\":\"n\",\"mean\":\" 存款;押金;订金;保证金;沉淀物\"},{\"wordType\":\"vt\",\"mean\":\" 使沉积;存放\"},{\"wordType\":\"vi\",\"mean\":\" 沉淀\"}]', '30056e1c-ab7a-31d2-96fc-8edd970d14f5', '2020-02-25 07:55:07', null);

-- ----------------------------
-- Table structure for english_word_prictice
-- ----------------------------
DROP TABLE IF EXISTS `english_word_prictice`;
CREATE TABLE `english_word_prictice` (
  `word_id` varchar(64) NOT NULL,
  `error_time` int(11) NOT NULL DEFAULT '0' COMMENT '错误次数',
  `difficulty_level` varchar(10) NOT NULL DEFAULT '0' COMMENT '单词记忆困难等级（0:正常，1:困难,2:特难）',
  PRIMARY KEY (`word_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of english_word_prictice
-- ----------------------------
INSERT INTO `english_word_prictice` VALUES ('00236eac-dee8-3819-a9bf-9b3bc7da13c6', '5', '1');
INSERT INTO `english_word_prictice` VALUES ('1145f263-256c-3237-96d2-b8eade2f6689', '1', '0');
INSERT INTO `english_word_prictice` VALUES ('14447bfb-b2f9-38b9-97ad-32f96e7af40d', '5', '1');
INSERT INTO `english_word_prictice` VALUES ('1993ee5c-be82-307a-89d8-b7320a2ab0b6', '3', '0');
INSERT INTO `english_word_prictice` VALUES ('208c6aa1-5739-3b85-9bcd-4c3df2b08f2d', '15', '2');
INSERT INTO `english_word_prictice` VALUES ('73d5342e-ba07-3f63-aac3-246f319bf77f', '8', '1');
INSERT INTO `english_word_prictice` VALUES ('9c46408a-3bc6-35c6-8505-c57a11d6c4ee', '3', '0');
INSERT INTO `english_word_prictice` VALUES ('d3440b69-126d-3c18-afdd-c713b18b0002', '5', '1');
INSERT INTO `english_word_prictice` VALUES ('dd6d2dcc-679d-32b9-830a-9787bab45b33', '8', '0');

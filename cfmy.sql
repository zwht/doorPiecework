/*
 Navicat Premium Data Transfer

 Source Server         : cfmy
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : cfmy

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 02/02/2018 11:02:43 AM
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `code`
-- ----------------------------
DROP TABLE IF EXISTS `code`;
CREATE TABLE `code` (
  `id` varchar(45) NOT NULL,
  `value` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `color`
-- ----------------------------
DROP TABLE IF EXISTS `color`;
CREATE TABLE `color` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `corporation_id` varchar(45) DEFAULT NULL,
  `img` varchar(400) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `corporation`
-- ----------------------------
DROP TABLE IF EXISTS `corporation`;
CREATE TABLE `corporation` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `state` int(1) NOT NULL,
  `boss` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `door`
-- ----------------------------
DROP TABLE IF EXISTS `door`;
CREATE TABLE `door` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `img` varchar(245) NOT NULL,
  `corporation_id` varchar(45) NOT NULL,
  `gx_ids` varchar(600) NOT NULL,
  `create_time` datetime NOT NULL,
  `state` int(4) NOT NULL,
  `gx_values` varchar(600) NOT NULL,
  `number` varchar(50) NOT NULL,
  `colors` varchar(250) DEFAULT NULL,
  `line` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `errCode`
-- ----------------------------
DROP TABLE IF EXISTS `errCode`;
CREATE TABLE `errCode` (
  `id` varchar(45) NOT NULL,
  `value` int(4) NOT NULL,
  `label` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `gx`
-- ----------------------------
DROP TABLE IF EXISTS `gx`;
CREATE TABLE `gx` (
  `id` varchar(45) NOT NULL,
  `type` int(4) NOT NULL,
  `price` int(4) NOT NULL,
  `corporation_id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `state` int(4) NOT NULL,
  `serial` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `line`
-- ----------------------------
DROP TABLE IF EXISTS `line`;
CREATE TABLE `line` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `corporation_id` varchar(45) DEFAULT NULL,
  `img` varchar(400) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `process`
-- ----------------------------
DROP TABLE IF EXISTS `process`;
CREATE TABLE `process` (
  `id` varchar(45) NOT NULL,
  `gx_id` varchar(45) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  `corporation_id` varchar(45) DEFAULT NULL,
  `price` int(4) DEFAULT NULL,
  `type` int(4) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `product_id` varchar(45) DEFAULT NULL,
  `ticket_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` varchar(45) CHARACTER SET latin1 NOT NULL,
  `name` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `door_id` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `process_ids` varchar(450) CHARACTER SET latin1 DEFAULT NULL,
  `img` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `mark` varchar(450) CHARACTER SET latin1 DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `corporation_id` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `cover_width` int(11) DEFAULT NULL,
  `cover_height` int(11) DEFAULT NULL,
  `cover_depth` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `lb_width` int(11) DEFAULT NULL,
  `lb_height` int(11) DEFAULT NULL,
  `db_width` int(11) DEFAULT NULL,
  `db_height` int(11) DEFAULT NULL,
  `color_id` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `line_id` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `line_sum` int(11) DEFAULT NULL,
  `productcol` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `module_id` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `lb_sum` int(11) DEFAULT NULL,
  `db_sum` int(11) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  `line_length` int(11) DEFAULT NULL,
  `ticket_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `ticket`
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket` (
  `id` varchar(45) CHARACTER SET latin1 NOT NULL,
  `name` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `dealers_id` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `brand_id` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `odd` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `address` varchar(450) CHARACTER SET latin1 DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `over_time` datetime DEFAULT NULL,
  `product_ids` varchar(450) CHARACTER SET latin1 DEFAULT NULL,
  `corporation_id` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  `number` varchar(45) DEFAULT NULL,
  `pay` float(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `corporation_id` varchar(45) NOT NULL,
  `state` int(1) DEFAULT NULL,
  `phone` varchar(20) NOT NULL,
  `login_name` varchar(20) NOT NULL,
  `type` varchar(10) NOT NULL,
  `roles` varchar(40) NOT NULL,
  `token` varchar(450) DEFAULT NULL,
  `token_time` datetime DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

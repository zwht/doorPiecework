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

 Date: 02/02/2018 11:18:38 AM
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
--  Records of `color`
-- ----------------------------
BEGIN;
INSERT INTO `color` VALUES ('1516790403629', '??', '1509885871184', 'http://ozq3tirki.bkt.clouddn.com/Fkk42fAG8m8smdJrcoM4P8_pSwfm', 'ggf'), ('1517305544600', '???', '1509885871184', 'http://ozq3tirki.bkt.clouddn.com/Fm5-qUgzNffrLN6oPXlHgu3qvgKt', '#c00');
COMMIT;

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
--  Records of `corporation`
-- ----------------------------
BEGIN;
INSERT INTO `corporation` VALUES ('1509885871184', '????erersdsdds', null, '0', null, null), ('1516853188865', 'sdf', 'ee', '1', null, null);
COMMIT;

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
--  Records of `door`
-- ----------------------------
BEGIN;
INSERT INTO `door` VALUES ('1516950198184', '??? _??sddsdssdffsffddf', 'http://ozq3tirki.bkt.clouddn.com/FkugQQ-ySDCyVO2YKCg1OaeeaXfg', '1509885871184', '1515568229765,1515568294692,1515568306490,1515568321123,1515568337743,1515568350142,1515568360154,1515568368535,1515568376630,1515568385260,1515568393850,1515568401028,1515568408065,1515568418392,1515568428501,1515568441272,1515568455633,1515568463485,1515568472353', '2018-01-26 15:03:18', '0', '1515568229765,1515568294692,1515568306490,1515568321123,1515568337743,1515568350142,1515568360154,1515568368535,1515568376630,1515568385260,1515568393850,1515568401028,1515568408065,1515568418392,1515568428501,1515568441272,1515568455633,1515568463485,1515568472353', 'HM_001', 'err', null), ('1516950264960', '????_dhd', 'http://ozq3tirki.bkt.clouddn.com/FusWpSH8vkOeK0EYtAFxfKMEBrp8', '1509885871184', '1515568229765,1515568294692,1515568306490,1515568321123,1515568337743,1515568350142,1515568360154,1515568368535,1515568376630,1515568385260,1515568393850,1515568401028,1515568408065,1515568418392,1515568428501,1515568441272,1515568455633,1515568463485,1515568472353', '2018-01-26 15:04:25', '0', '1515568229765,1515568294692,1515568306490,1515568321123,1515568337743,1515568350142,1515568360154,1515568368535,1515568376630,1515568385260,1515568393850,1515568401028,1515568408065,1515568418392,1515568428501,1515568441272,1515568455633,1515568463485,1515568472353', 'HT_002', 'err', null);
COMMIT;

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
--  Records of `gx`
-- ----------------------------
BEGIN;
INSERT INTO `gx` VALUES ('1515568229765', '1', '12', '1509885871184', '??', '0', '1'), ('1515568294692', '2', '11', '1509885871184', '??', '0', '2'), ('1515568306490', '12', '22', '1509885871184', '??', '0', '3'), ('1515568321123', '33', '12', '1509885871184', '???', '0', '4'), ('1515568337743', '33', '12', '1509885871184', '??', '0', '5'), ('1515568350142', '3', '2', '1509885871184', '??', '0', '6'), ('1515568360154', '3', '2', '1509885871184', '??', '0', '7'), ('1515568368535', '3', '2', '1509885871184', '??', '0', '8'), ('1515568376630', '3', '23', '1509885871184', '??', '0', '9'), ('1515568385260', '3', '23', '1509885871184', '??', '0', '10'), ('1515568393850', '3', '23', '1509885871184', '????', '0', '11'), ('1515568401028', '3', '23', '1509885871184', '??', '0', '12'), ('1515568408065', '3', '2', '1509885871184', '??', '0', '13'), ('1515568418392', '3', '2', '1509885871184', '??', '0', '14'), ('1515568428501', '3', '23', '1509885871184', '??', '0', '15'), ('1515568441272', '3', '23', '1509885871184', '??', '0', '16'), ('1515568455633', '3', '23', '1509885871184', '??', '0', '17'), ('1515568463485', '4', '23', '1509885871184', '??', '0', '18'), ('1515568472353', '3', '23', '1509885871184', '??', '0', '19');
COMMIT;

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
--  Records of `line`
-- ----------------------------
BEGIN;
INSERT INTO `line` VALUES ('1516338101368', '????', '1509885871184', 'http://ozq3tirki.bkt.clouddn.com/Fjk7A9r1Ucpp2Cfh8oqBtMKhZthI', '323'), ('1517305642143', '???', '1509885871184', 'http://ozq3tirki.bkt.clouddn.com/FtTnwAohR1ioyUNaf9F4wfXDvahB', null);
COMMIT;

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
--  Records of `process`
-- ----------------------------
BEGIN;
INSERT INTO `process` VALUES ('1517393997656', '1515568229765', '1515570349126', '1509885871184', '12', null, null, null, null, null, '1517209585538'), ('1517393997657', '1515568294692', '1515570392717', '1509885871184', '11', null, null, null, null, null, '1517209585538'), ('1517393997658', '1515568306490', '1515570409321', '1509885871184', '22', null, null, null, null, null, '1517209585538'), ('1517393997659', '1515568321123', '1515570427216', '1509885871184', '12', null, null, null, null, null, '1517209585538'), ('1517393997660', '1515568337743', '1515570441526', '1509885871184', '12', null, null, null, null, null, '1517209585538'), ('1517393997661', '1515568350142', null, '1509885871184', '2', null, null, null, null, null, '1517209585538'), ('1517393997662', '1515568360154', null, '1509885871184', '2', null, null, null, null, null, '1517209585538'), ('1517393997663', '1515568368535', null, '1509885871184', '2', null, null, null, null, null, '1517209585538'), ('1517393997664', '1515568376630', null, '1509885871184', '23', null, null, null, null, null, '1517209585538'), ('1517393997665', '1515568385260', null, '1509885871184', '23', null, null, null, null, null, '1517209585538'), ('1517393997666', '1515568393850', null, '1509885871184', '23', null, null, null, null, null, '1517209585538'), ('1517393997667', '1515568401028', null, '1509885871184', '23', null, null, null, null, null, '1517209585538'), ('1517393997668', '1515568408065', null, '1509885871184', '2', null, null, null, null, null, '1517209585538'), ('1517393997669', '1515568418392', null, '1509885871184', '2', null, null, null, null, null, '1517209585538'), ('1517393997670', '1515568428501', null, '1509885871184', '23', null, null, null, null, null, '1517209585538'), ('1517393997671', '1515568441272', null, '1509885871184', '23', null, null, null, null, null, '1517209585538'), ('1517393997672', '1515568455633', null, '1509885871184', '23', null, null, null, null, null, '1517209585538'), ('1517393997673', '1515568463485', null, '1509885871184', '23', null, null, null, null, null, '1517209585538'), ('1517393997674', '1515568472353', null, '1509885871184', '23', null, null, null, null, null, '1517209585538'), ('1517394158615', '1515568229765', '1515570349126', '1509885871184', '12', null, null, null, null, null, '1517393647847'), ('1517394158616', '1515568294692', '1515570392717', '1509885871184', '11', null, null, null, null, null, '1517393647847'), ('1517394158617', '1515568306490', '1515570409321', '1509885871184', '22', null, null, null, null, null, '1517393647847'), ('1517394158618', '1515568321123', '1515570427216', '1509885871184', '12', null, null, null, null, null, '1517393647847'), ('1517394158619', '1515568337743', '1515570441526', '1509885871184', '12', null, null, null, null, null, '1517393647847'), ('1517394158620', '1515568350142', null, '1509885871184', '2', null, null, null, null, null, '1517393647847'), ('1517394158621', '1515568360154', null, '1509885871184', '2', null, null, null, null, null, '1517393647847'), ('1517394158622', '1515568368535', null, '1509885871184', '2', null, null, null, null, null, '1517393647847'), ('1517394158623', '1515568376630', null, '1509885871184', '23', null, null, null, null, null, '1517393647847'), ('1517394158624', '1515568385260', null, '1509885871184', '23', null, null, null, null, null, '1517393647847'), ('1517394158625', '1515568393850', null, '1509885871184', '23', null, null, null, null, null, '1517393647847'), ('1517394158626', '1515568401028', null, '1509885871184', '23', null, null, null, null, null, '1517393647847'), ('1517394158627', '1515568408065', null, '1509885871184', '2', null, null, null, null, null, '1517393647847'), ('1517394158628', '1515568418392', null, '1509885871184', '2', null, null, null, null, null, '1517393647847'), ('1517394158629', '1515568428501', null, '1509885871184', '23', null, null, null, null, null, '1517393647847'), ('1517394158630', '1515568441272', null, '1509885871184', '23', null, null, null, null, null, '1517393647847'), ('1517394158631', '1515568455633', null, '1509885871184', '23', null, null, null, null, null, '1517393647847'), ('1517394158632', '1515568463485', null, '1509885871184', '23', null, null, null, null, null, '1517393647847'), ('1517394158633', '1515568472353', null, '1509885871184', '23', null, null, null, null, null, '1517393647847'), ('1517394221021', '1515568229765', '1515570349126', '1509885871184', '24', null, null, null, null, null, '1517394220856'), ('1517394221022', '1515568294692', '1515570392717', '1509885871184', '22', null, null, null, null, null, '1517394220856'), ('1517394221023', '1515568306490', '1515570409321', '1509885871184', '44', null, null, null, null, null, '1517394220856'), ('1517394221024', '1515568321123', '1515570427216', '1509885871184', '29', null, null, null, null, null, '1517394220856'), ('1517394221025', '1515568337743', '1515570441526', '1509885871184', '24', null, null, null, null, null, '1517394220856'), ('1517394221026', '1515568350142', null, '1509885871184', '4', null, null, null, null, null, '1517394220856'), ('1517394221027', '1515568360154', null, '1509885871184', '4', null, null, null, null, null, '1517394220856'), ('1517394221028', '1515568368535', null, '1509885871184', '4', null, null, null, null, null, '1517394220856'), ('1517394221029', '1515568376630', null, '1509885871184', '46', null, null, null, null, null, '1517394220856'), ('1517394221030', '1515568385260', null, '1509885871184', '46', null, null, null, null, null, '1517394220856'), ('1517394221031', '1515568393850', null, '1509885871184', '46', null, null, null, null, null, '1517394220856'), ('1517394221032', '1515568401028', null, '1509885871184', '46', null, null, null, null, null, '1517394220856'), ('1517394221033', '1515568408065', null, '1509885871184', '4', null, null, null, null, null, '1517394220856'), ('1517394221034', '1515568418392', null, '1509885871184', '4', null, null, null, null, null, '1517394220856'), ('1517394221035', '1515568428501', null, '1509885871184', '46', null, null, null, null, null, '1517394220856'), ('1517394221036', '1515568441272', null, '1509885871184', '46', null, null, null, null, null, '1517394220856'), ('1517394221037', '1515568455633', null, '1509885871184', '46', null, null, null, null, null, '1517394220856'), ('1517394221038', '1515568463485', null, '1509885871184', '46', null, null, null, null, null, '1517394220856'), ('1517394221039', '1515568472353', null, '1509885871184', '46', null, null, null, null, null, '1517394220856');
COMMIT;

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
--  Records of `product`
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES ('1517283205738', null, '1516950264960', null, null, 'sddsdd', null, null, '1509885871184', '1002', '1802', '720', '1002', '1820', '1002', '1820', '1002', '1820', '1516790403629', '1516338101368', '12', null, null, null, null, '22', '12', '4', '22020', '1517209585538'), ('1517393648192', null, '1516950264960', null, null, 'asadsas', null, null, '1509885871184', '100', '180', '70', '100', '180', '100', '180', '100', '180', '1516790403629', '1517305642143', '1', null, null, null, null, '2', '1', '1', '2200', '1517393647847'), ('1517394221063', null, '1516950198184', null, null, null, null, null, '1509885871184', '100', '180', '70', '100', '180', '100', '180', '100', '180', '1516790403629', '1516338101368', '1', null, null, null, null, '2', '1', '1', '2200', '1517394220856');
COMMIT;

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
--  Records of `ticket`
-- ----------------------------
BEGIN;
INSERT INTO `ticket` VALUES ('1517209585538', 'csdd', '1515571650195', '1', null, 'fdfd', '2018-02-02 00:00:00', '2018-02-09 00:00:00', null, null, null, '1509885871184', '0', '0', null), ('1517393647847', 'assa', '1515571650195', '1', null, 'assa', '2018-02-01 00:00:00', '2018-02-23 00:00:00', null, null, null, '1509885871184', '0', '0', null), ('1517394220856', 'ssd', '1515571650195', '1', null, 'ds', '2018-02-09 00:00:00', '2018-02-09 00:00:00', null, null, null, '1509885871184', '0', '0', null);
COMMIT;

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

-- ----------------------------
--  Records of `users`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('121', 'zw', '4QrcOUm6Wau+VuBX8g+IPg==', '1509885871184', '1', '11', '11', '1', '1', '1', '2017-11-14 15:49:53', null), ('1515570349126', '??_??', '4QrcOUm6Wau+VuBX8g+IPg==', '1509885871184', '1', '12355', '123', '??', '2', null, null, null), ('1515570392717', '???_??', 'vepxQYVd9C2tLomUyQa8/g==', '1509885871184', '1', '??', '??', '??', '2', null, null, null), ('1515570409321', '??_??', 'S0PawNy+XMyEceVaVvqRDA==', '1509885871184', '1', '??', '??', '??', '2', null, null, null), ('1515570427216', '??_???', 'r0pQFXj6BDGXHuh53F2gYw==', '1509885871184', '1', '???', '???', '???', '2', null, null, null), ('1515570441526', '??_??', 'qTEWKfOAHZ8arKODbdtpyA==', '1509885871184', '1', '??', '??', '??', '2', null, null, null), ('1515571650195', '???1', '4QrcOUm6Wau+VuBX8g+IPg==', '1509885871184', '1', '12', '323', '??', '3', null, null, null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

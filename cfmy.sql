-- MySQL dump 10.13  Distrib 5.7.18, for macos10.12 (x86_64)
--
-- Host: localhost    Database: cfmy
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `code`
--

DROP TABLE IF EXISTS `code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code` (
  `id` varchar(45) NOT NULL,
  `value` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code`
--

LOCK TABLES `code` WRITE;
/*!40000 ALTER TABLE `code` DISABLE KEYS */;
/*!40000 ALTER TABLE `code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `color` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `corporation_id` varchar(45) DEFAULT NULL,
  `img` varchar(400) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES ('1516790403629','白色','1509885871184','http://ozq3tirki.bkt.clouddn.com/Fkk42fAG8m8smdJrcoM4P8_pSwfm','ggf'),('1517305544600','大红色','1509885871184','http://ozq3tirki.bkt.clouddn.com/Fm5-qUgzNffrLN6oPXlHgu3qvgKt','#c00');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corporation`
--

DROP TABLE IF EXISTS `corporation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corporation` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `state` int(1) NOT NULL,
  `boss` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `img` varchar(240) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation`
--

LOCK TABLES `corporation` WRITE;
/*!40000 ALTER TABLE `corporation` DISABLE KEYS */;
INSERT INTO `corporation` VALUES ('1509885871184','重庆川峰erersdsdds','重庆',0,NULL,NULL,'http://ozq3tirki.bkt.clouddn.com/Ful5IWUDjRgh0NEIA7s87IDEacbZ');
/*!40000 ALTER TABLE `corporation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `door`
--

DROP TABLE IF EXISTS `door`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `door`
--

LOCK TABLES `door` WRITE;
/*!40000 ALTER TABLE `door` DISABLE KEYS */;
INSERT INTO `door` VALUES ('1516950198184','红木门 _活动sddsdssdffsffddf','http://ozq3tirki.bkt.clouddn.com/FkugQQ-ySDCyVO2YKCg1OaeeaXfg','1509885871184','1515568229765,1515568294692,1515568306490,1515568321123,1515568337743,1515568350142,1515568360154,1515568368535,1515568376630,1515568385260,1515568393850,1515568401028,1515568408065,1515568418392,1515568428501,1515568441272,1515568455633,1515568463485,1515568472353','2018-01-26 15:03:18',0,'1515568229765,1515568294692,1515568306490,1515568321123,1515568337743,1515568350142,1515568360154,1515568368535,1515568376630,1515568385260,1515568393850,1515568401028,1515568408065,1515568418392,1515568428501,1515568441272,1515568455633,1515568463485,1515568472353','HM_001','err',NULL),('1516950264960','黑桃木门_dhd','http://ozq3tirki.bkt.clouddn.com/FusWpSH8vkOeK0EYtAFxfKMEBrp8','1509885871184','1515568229765,1515568294692,1515568306490,1515568321123,1515568337743,1515568350142,1515568360154,1515568368535,1515568376630,1515568385260,1515568393850,1515568401028,1515568408065,1515568418392,1515568428501,1515568441272,1515568455633,1515568463485,1515568472353','2018-01-26 15:04:25',0,'1515568229765,1515568294692,1515568306490,1515568321123,1515568337743,1515568350142,1515568360154,1515568368535,1515568376630,1515568385260,1515568393850,1515568401028,1515568408065,1515568418392,1515568428501,1515568441272,1515568455633,1515568463485,1515568472353','HT_002','err',NULL);
/*!40000 ALTER TABLE `door` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `errCode`
--

DROP TABLE IF EXISTS `errCode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `errCode` (
  `id` varchar(45) NOT NULL,
  `value` int(4) NOT NULL,
  `label` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `errCode`
--

LOCK TABLES `errCode` WRITE;
/*!40000 ALTER TABLE `errCode` DISABLE KEYS */;
/*!40000 ALTER TABLE `errCode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gx`
--

DROP TABLE IF EXISTS `gx`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gx`
--

LOCK TABLES `gx` WRITE;
/*!40000 ALTER TABLE `gx` DISABLE KEYS */;
INSERT INTO `gx` VALUES ('1515568229765',1,12,'1509885871184','下料',0,1),('1515568294692',2,11,'1509885871184','单套',0,2),('1515568306490',12,22,'1509885871184','雕刻',0,3),('1515568321123',33,12,'1509885871184','抓架子',0,4),('1515568337743',33,12,'1509885871184','压机',0,5),('1515568350142',3,2,'1509885871184','精裁',0,6),('1515568360154',3,2,'1509885871184','打台',0,7),('1515568368535',3,2,'1509885871184','封边',0,8),('1515568376630',3,23,'1509885871184','大沙',0,9),('1515568385260',3,23,'1509885871184','异型',0,10),('1515568393850',3,23,'1509885871184','打眼订凳',0,11),('1515568401028',3,23,'1509885871184','分货',0,12),('1515568408065',3,2,'1509885871184','刮沙',0,13),('1515568418392',3,2,'1509885871184','贴纸',0,14),('1515568428501',3,23,'1509885871184','贴皮',0,15),('1515568441272',3,23,'1509885871184','底漆',0,16),('1515568455633',3,23,'1509885871184','油磨',0,17),('1515568463485',4,23,'1509885871184','面漆',0,18),('1515568472353',3,23,'1509885871184','包装',0,19);
/*!40000 ALTER TABLE `gx` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `line`
--

DROP TABLE IF EXISTS `line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `line` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `corporation_id` varchar(45) DEFAULT NULL,
  `img` varchar(400) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `line`
--

LOCK TABLES `line` WRITE;
/*!40000 ALTER TABLE `line` DISABLE KEYS */;
INSERT INTO `line` VALUES ('1516338101368','花纹线条','1509885871184','http://ozq3tirki.bkt.clouddn.com/Fjk7A9r1Ucpp2Cfh8oqBtMKhZthI','323'),('1517305642143','大条线','1509885871184','http://ozq3tirki.bkt.clouddn.com/FtTnwAohR1ioyUNaf9F4wfXDvahB',NULL);
/*!40000 ALTER TABLE `line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `process`
--

DROP TABLE IF EXISTS `process`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `process`
--

LOCK TABLES `process` WRITE;
/*!40000 ALTER TABLE `process` DISABLE KEYS */;
/*!40000 ALTER TABLE `process` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `sum_door` float DEFAULT NULL,
  `sum_taoban` float DEFAULT NULL,
  `sum_line` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `corporation_id` varchar(45) NOT NULL,
  `state` int(1) DEFAULT NULL,
  `phone` varchar(20) NOT NULL,
  `login_name` varchar(20) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `roles` varchar(40) NOT NULL,
  `token` varchar(450) DEFAULT NULL,
  `token_time` datetime DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('121','èµµä¼Ÿ','FOG2ALH9V59HQzuI6NhSkQ==','',1,'11','zw','1','0','1','2017-11-14 15:49:53',NULL),('1515570349126','下料_张三','FOG2ALH9V59HQzuI6NhSkQ==','1509885871184',1,'12355','123','下料','4',NULL,NULL,NULL),('1515570392717','赵老大_单套','FOG2ALH9V59HQzuI6NhSkQ==','1509885871184',1,'单套','单套','单套','4',NULL,NULL,NULL),('1515570409321','王五_雕刻','FOG2ALH9V59HQzuI6NhSkQ==','1509885871184',1,'雕刻','雕刻','雕刻','4',NULL,NULL,NULL),('1515570427216','小米_抓架子','FOG2ALH9V59HQzuI6NhSkQ==','1509885871184',1,'抓架子','抓架子','抓架子','4',NULL,NULL,NULL),('1515570441526','小王_压机','FOG2ALH9V59HQzuI6NhSkQ==','1509885871184',1,'压机','压机','压机','4',NULL,NULL,NULL),('1515571650195','经销商1','FOG2ALH9V59HQzuI6NhSkQ==','1509885871184',1,'12','323','2','3',NULL,NULL,NULL),('1517909490135','王君','FOG2ALH9V59HQzuI6NhSkQ==','1509885871184',1,'2343','wangjun','0','2',NULL,NULL,'34'),('cfmy','川峰超级管理员','FOG2ALH9V59HQzuI6NhSkQ==','1509885871184',1,'23','cfmy','1','1',NULL,NULL,NULL),('cfmy1','赵静','FOG2ALH9V59HQzuI6NhSkQ==','1509885871184',1,'1','zhaojing','1','2',NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-06 21:13:50

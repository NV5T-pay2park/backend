-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: localhost    Database: NV5T_parking_lot
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `end_users`
--

DROP TABLE IF EXISTS `end_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `end_users` (
  `end_user_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `gender` tinyint NOT NULL,
  `phone` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `zalopay_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`end_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `end_users`
--

LOCK TABLES `end_users` WRITE;
/*!40000 ALTER TABLE `end_users` DISABLE KEYS */;
INSERT INTO `end_users` VALUES (1,'Lee4an','whodahman',1,'0416177645','whodahman@gmail.com',NULL),(2,'Partypooper009','throwaway217217',0,'0790529870','throwaway217217@gmail.com',NULL),(3,'Jenna1021','neccernpogrlinzi15',1,'0289754850','neccernpogrlinzi15@gmail.com',NULL),(4,'ALMEHZA_02','Rammyjosh11',0,'0198549128','Rammyjosh11@gmail.com',NULL),(5,'Fakehashish','ultrastructure',0,'0534088327','ultrastructure@gmail.com',NULL),(6,'TheeeHman','Smifter',1,'0479004829','Smifter@gmail.com',NULL),(7,'dontlookatme20','joea7xfan',0,'0429083537','joea7xfan@gmail.com',NULL),(8,'dogerlove','Ohamingju',0,'0529586269','Ohamingju@gmail.com',NULL),(9,'theblacktaco','landep',1,'0949256098','landep@gmail.com',NULL),(10,'idkwhattodoy','thatoneguy1000123',1,'0372648751','thatoneguy1000123@gmail.com',NULL),(11,'hahahahhahelpme','aDucknamedFoieGras',1,'0814416522','aDucknamedFoieGras@gmail.com',NULL),(12,'The_real_Schnitzel','BnanVu',1,'0535932106','BnanVu@gmail.com',NULL),(13,'vicsloan','chestercham',1,'0613232956','chestercham@gmail.com',NULL),(14,'katajin31309','Goldcap',0,'0448229267','Goldcap@gmail.com',NULL),(15,'Xsxcx','Jjs18871975i',0,'0839757762','Jjs18871975i@gmail.com',NULL),(16,'porchcoors50','conce008',0,'0699432639','conce008@gmail.com',NULL),(17,'idiociest','husolmoMage',0,'0619835669','husolmoMage@gmail.com',NULL),(18,'BizzarGhostGaming','peterjeckub',1,'0960366271','peterjeckub@gmail.com',NULL),(19,'AmazingDieudo','julianbremann',1,'0027948327','julianbremann@gmail.com',NULL),(20,'RayShmurda6','rohan23',0,'0517129255','rohan23@gmail.com',NULL),(21,'Lost-n-Confused28','UKWIZZZARD',0,'0959832005','UKWIZZZARD@gmail.com',NULL),(22,'GrimmMarshal','mzcameron',1,'0401205001','mzcameron@gmail.com',NULL),(23,'inception73','I_PLOT_YOUR_REVENGE',0,'0544985803','I_PLOT_YOUR_REVENGE@gmail.com',NULL),(24,'Rahulkumar18','marriedinmay',1,'0015797327','marriedinmay@gmail.com',NULL),(25,'MBSUPERSPAZZ','Prodigy_Throwaway',0,'0225392283','Prodigy_Throwaway@gmail.com',NULL),(26,'eriktheredhead','ThrowawayMyOlives',1,'0466991116','ThrowawayMyOlives@gmail.com',NULL),(27,'randomstuff063','Bug337',1,'0931727434','Bug337@gmail.com',NULL),(28,'llIlIllilIlllI','Alasiaanne',0,'0108915387','Alasiaanne@gmail.com',NULL),(29,'pego_tinn','87786768768',0,'0059968514','87786768768@gmail.com',NULL),(30,'whoisthatgirl1','windom__earle',0,'0201778799','windom__earle@gmail.com',NULL),(31,'NaN','NaN',1,'NaN','NaN','93jfkd092f2fs4'),(32,'NaN','NaN',1,'NaN','NaN','aptx4869'),(33,'NaN','NaN',1,'NaN','NaN','s3oJTIPfZK9ieMR1NPteATWX4R6LnuICgcCHUKpNZq4'),(34,'NaN','NaN',1,'NaN','NaN','VOkrn0IzBV9h-CNuDFswbqSzPdpGI9ESJT7tFj8E9_E'),(35,'NaN','NaN',1,'NaN','NaN','DicBRxUCu86qoxntyDR_VTIeTpdXF0hfRUI1q-QPVyg');
/*!40000 ALTER TABLE `end_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_employees`
--

DROP TABLE IF EXISTS `merchant_employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_employees` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `first_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `last_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `gender` tinyint NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `avatar` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `permission_id` tinyint NOT NULL,
  `status` tinyint NOT NULL,
  `parking_lot_id` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `merchant_employee_parking_lot_fk` (`parking_lot_id`),
  KEY `merchant_employee_permission_fk` (`permission_id`),
  CONSTRAINT `merchant_employee_parking_lot_fk` FOREIGN KEY (`parking_lot_id`) REFERENCES `parking_lots` (`parking_lot_id`),
  CONSTRAINT `merchant_employee_permission_fk` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_employees`
--

LOCK TABLES `merchant_employees` WRITE;
/*!40000 ALTER TABLE `merchant_employees` DISABLE KEYS */;
INSERT INTO `merchant_employees` VALUES (1,'tienthanh','Thanh','Tien',0,'123','tienthanh@gmail.com','0987654321',':3',1,0,1);
/*!40000 ALTER TABLE `merchant_employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchants`
--

DROP TABLE IF EXISTS `merchants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchants` (
  `merchant_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `represent` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`merchant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchants`
--

LOCK TABLES `merchants` WRITE;
/*!40000 ALTER TABLE `merchants` DISABLE KEYS */;
INSERT INTO `merchants` VALUES (1,'Thành phố Thủ Đức','Lee4an','Lee4an@gmail.com','0906094163'),(2,'Quận 1','Partypooper009','Partypooper009@gmail.com','0522503744'),(3,'Quận 3','Jenna1021','Jenna1021@gmail.com','0243360920'),(4,'Quận 7','ALMEHZA_02','ALMEHZA_02@gmail.com','0887315211'),(5,'Quận 12','Fakehashish','Fakehashish@gmail.com','0848857628'),(6,'Quận Bình Tân','TheeeHman','TheeeHman@gmail.com','0447385416'),(7,'Quận Tân Phú','dontlookatme20','dontlookatme20@gmail.com','0895290467');
/*!40000 ALTER TABLE `merchants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking_lot_images`
--

DROP TABLE IF EXISTS `parking_lot_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parking_lot_images` (
  `image_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `parking_lot_id` int NOT NULL,
  `url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`image_id`),
  KEY `parking_lot_images_parking_lot_fk` (`parking_lot_id`),
  CONSTRAINT `parking_lot_images_parking_lot_fk` FOREIGN KEY (`parking_lot_id`) REFERENCES `parking_lots` (`parking_lot_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking_lot_images`
--

LOCK TABLES `parking_lot_images` WRITE;
/*!40000 ALTER TABLE `parking_lot_images` DISABLE KEYS */;
INSERT INTO `parking_lot_images` VALUES ('fvmgcgtyjsclxuubx6y9',6,'http://res.cloudinary.com/pay2park-cdn/image/upload/v1658982415/fvmgcgtyjsclxuubx6y9.jpg'),('xexbyqb99dmhjeihxazt',4,'http://res.cloudinary.com/pay2park-cdn/image/upload/v1658982370/xexbyqb99dmhjeihxazt.jpg');
/*!40000 ALTER TABLE `parking_lot_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking_lots`
--

DROP TABLE IF EXISTS `parking_lots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parking_lots` (
  `parking_lot_id` int NOT NULL AUTO_INCREMENT,
  `parking_lot_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `number_slot` int NOT NULL,
  `number_slot_remaining` int NOT NULL,
  `status` tinyint NOT NULL,
  `merchant_id` int NOT NULL,
  `lat` float(20,15) NOT NULL,
  `lng` float(20,15) NOT NULL,
  `time_open` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `time_close` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone_number` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `city` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `district` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `street` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ward` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`parking_lot_id`),
  KEY `parking_lot_merchants_fk` (`merchant_id`),
  FULLTEXT KEY `parking_lot_name` (`parking_lot_name`),
  CONSTRAINT `parking_lot_merchants_fk` FOREIGN KEY (`merchant_id`) REFERENCES `merchants` (`merchant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking_lots`
--

LOCK TABLES `parking_lots` WRITE;
/*!40000 ALTER TABLE `parking_lots` DISABLE KEYS */;
INSERT INTO `parking_lots` VALUES (1,'Hùng Vương',184,182,0,1,10.783888816833496,106.734718322753900,'05:00:00','22:00:00','982347126','TPHCM','Thành phố Thủ Đức','Tố Hữu','An Khánh',''),(2,'Hai Bà Trưng',80,80,0,1,10.846667289733887,106.777778625488280,'05:00:00','22:00:00','982347126','TPHCM','Quận Bình Tân','Kinh Dương Vương','An Lạc',''),(3,'Lý Nam Đế',153,151,0,1,10.856389045715332,106.762496948242190,'05:00:00','22:00:00','982347126','TPHCM','Quận 12','An Phú Đông 3','An Phú Đông',''),(4,'Ngô Quyền',71,70,0,1,10.863888740539550,106.782775878906250,'05:00:00','22:00:00','982347126','TPHCM','Quận 1','Đồng Khởi','Bến Nghé',''),(5,'Đinh Bộ Lĩnh',101,99,0,1,10.882222175598145,106.768890380859380,'05:00:00','22:00:00','982347126','TPHCM','Quận 1','Lê Lợi','Bến Thành',''),(6,'Lê Hoàn',101,100,0,1,10.884166717529297,106.730278015136720,'05:00:00','22:00:00','982347126','TPHCM','Thành phố Thủ Đức','Ngô Chí Quốc','Bình Chiểu',''),(7,'Lý Công Uẩn',163,162,0,1,10.843610763549805,106.791389465332030,'05:00:00','22:00:00','982347126','TPHCM','Quận Bình Tân','Lê Trọng Tấn','Bình Hưng Hòa',''),(8,'Lý Thường Kiệt',119,119,0,1,10.810000419616700,106.733329772949220,'05:00:00','22:00:00','982347126','TPHCM','Quận 1','Nguyễn Đình Chiểu','Đa Kao',''),(9,'Trần Nhân Tông',187,186,0,1,10.771944046020508,106.714996337890620,'05:00:00','22:00:00','982347126','TPHCM','Thành phố Thủ Đức','Man Thiện','Hiệp Phú',''),(10,'Trần Hưng Đạo',75,71,0,1,10.833056449890137,106.754997253417970,'05:00:00','22:00:00','982347126','TPHCM','Quận Tân Phú','Hòa Bình','Hiệp Tân',''),(11,'Lê Lợi',130,130,0,2,10.782221794128418,106.702781677246100,'05:00:00','22:00:00','982347126','TPHCM','Quận 12','Nguyễn Ánh Thủ','Hiệp Thành',''),(12,'Nguyễn Trãi',81,78,0,2,10.772521018981934,106.698020935058600,'05:00:00','22:00:00','982347126','TPHCM','Quận Tân Phú','Thoại Ngọc Hầu','Hoà Thạnh',''),(13,'Nguyễn Huệ',103,101,0,2,10.789167404174805,106.696945190429690,'05:00:00','22:00:00','982347126','TPHCM','Thành phố Thủ Đức','Tô Vĩnh Diện','Linh Chiểu',''),(14,'Hồ Chí Minh',146,145,0,3,10.783408164978027,106.690773010253900,'05:00:00','22:00:00','982347126','TPHCM','Thành phố Thủ Đức','Lê Văn Chí','Linh Trung',''),(15,'Võ Nguyên Giáp',124,124,0,4,10.758333206176758,106.735000610351560,'05:00:00','22:00:00','982347126','TPHCM','Thành phố Thủ Đức','Bà Giang','Linh Xuân',''),(16,'Nguyễn Chí Thanh',175,175,0,4,10.751667022705078,106.720558166503900,'05:00:00','22:00:00','982347126','TPHCM','Quận 3','Võ Thị Sáu','Phường Võ Thị Sáu',''),(17,'Phạm Xuân Ẩn',148,145,0,5,10.851667404174805,106.697219848632810,'05:00:00','22:00:00','982347126','TPHCM','Quận 7','Tân Thuận','Tân Thuận Đông',''),(18,'Lê Trọng Tấn',54,54,0,5,10.881111145019531,106.635276794433600,'05:00:00','22:00:00','982347126','TPHCM','Quận 7','Trần Xuân Soạn','Tân Thuận Tây',''),(19,'Văn Tiến Dũng',63,63,0,6,10.722222328186035,106.611114501953120,'05:00:00','22:00:00','982347126','TPHCM','Thành phố Thủ Đức','Lê Văn Việt','Tăng Nhơn Phú A',''),(20,'Hoàng Văn Thái',89,89,0,6,10.802499771118164,106.599998474121100,'05:00:00','22:00:00','982347126','TPHCM','Thành phố Thủ Đức','Quốc Hương','Thảo Điền',''),(21,'Lê Đức Anh',161,160,0,7,10.768889427185059,106.626663208007810,'05:00:00','22:00:00','982347126','TPHCM','Thành phố Thủ Đức','Mai Chí Thọ','Thủ Thiêm',''),(22,'Chu Huy Mân',145,144,0,7,10.779167175292969,106.634719848632810,'05:00:00','22:00:00','982347126','TPHCM','Thành phố Thủ Đức','Đặng Văn Bi','Trường Thọ','');
/*!40000 ALTER TABLE `parking_lots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_url`
--

DROP TABLE IF EXISTS `payment_url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_url` (
  `app_tran_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `order_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `zp_trans_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`app_tran_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_url`
--

LOCK TABLES `payment_url` WRITE;
/*!40000 ALTER TABLE `payment_url` DISABLE KEYS */;
INSERT INTO `payment_url` VALUES ('220726_134222','https://sbgateway.zalopay.vn/openinapp?order=eyJ6cHRyYW5zdG9rZW4iOiIyMjA3MjYwMDAwMDA0MDNXMVZVOVdaIiwiYXBwaWQiOjk5OTg4OH0',NULL),('220727_2220727215925102','https://qcgateway.zalopay.vn/openinapp?order=eyJ6cHRyYW5zdG9rZW4iOiIyMjA3MjcwMDAwMTIzOTZyNjhYMHIwIiwiYXBwaWQiOjgwNX0','220727000012396r68X0r0'),('220727_2220727220209112','https://qcgateway.zalopay.vn/openinapp?order=eyJ6cHRyYW5zdG9rZW4iOiIyMjA3MjcwMDAwMTI1MzhXVlJ2eHgxIiwiYXBwaWQiOjgwNX0','220727000012538WVRvxx1'),('220727_229','https://qcgateway.zalopay.vn/openinapp?order=eyJ6cHRyYW5zdG9rZW4iOiIyMjA3MjcwMDAwMDM2Mzg0d0s5MzZJIiwiYXBwaWQiOjgwNX0','2207270000036384wK936I'),('220727_230','https://qcgateway.zalopay.vn/openinapp?order=eyJ6cHRyYW5zdG9rZW4iOiIyMjA3MjcwMDAwMDI0NTRVdWhvMlZ0IiwiYXBwaWQiOjgwNX0','220727000002454Uuho2Vt'),('220727_332','https://qcgateway.zalopay.vn/openinapp?order=eyJ6cHRyYW5zdG9rZW4iOiIyMjA3MjcwMDAwMDI0NDF5eTEyejQ0IiwiYXBwaWQiOjgwNX0','220727000002441yy12z44'),('220727_923','https://qcgateway.zalopay.vn/openinapp?order=eyJ6cHRyYW5zdG9rZW4iOiIyMjA3MjcwMDAwMDQxNzcxWEdwdDdaIiwiYXBwaWQiOjgwNX0','2207270000041771XGpt7Z'),('220728_2220728105306112','https://qcgateway.zalopay.vn/openinapp?order=eyJ6cHRyYW5zdG9rZW4iOiIyMjA3MjgwMDAwMDUyODFZNnIwclc1IiwiYXBwaWQiOjgwNX0','220728000005281Y6r0rW5'),('220730_33220729094641133','https://sbgateway.zalopay.vn/openinapp?order=eyJ6cHRyYW5zdG9rZW4iOiIyMjA3MzAwMDAyMDAzMDRqeW1TM1d6IiwiYXBwaWQiOjk5OTg4OH0','220730000200304jymS3Wz'),('220730_332207290949341133','https://sbgateway.zalopay.vn/openinapp?order=eyJ6cHRyYW5zdG9rZW4iOiIyMjA3MzAwMDAyMDAyOTJPMjFXWVpyIiwiYXBwaWQiOjk5OTg4OH0','220730000200292O21WYZr'),('220731_33220729015709333','https://sbgateway.zalopay.vn/openinapp?order=eyJ6cHRyYW5zdG9rZW4iOiIyMjA3MzEwMDAwMDAwMTRKMmk2MjhzIiwiYXBwaWQiOjk5OTg4OH0','220731000000014J2i628s'),('220731_33220729091921533','https://sbgateway.zalopay.vn/openinapp?order=eyJ6cHRyYW5zdG9rZW4iOiIyMjA3MzEwMDAwMDAwMDMzVlUyMlU5IiwiYXBwaWQiOjk5OTg4OH0','2207310000000033VU22U9');
/*!40000 ALTER TABLE `payment_url` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissions` (
  `permission_id` tinyint NOT NULL,
  `permission_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `allow_add` tinyint NOT NULL,
  `allow_edit` tinyint NOT NULL,
  `allow_delete` tinyint NOT NULL,
  `allow_export` tinyint NOT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
INSERT INTO `permissions` VALUES (1,'admin','role admin',1,1,1,1);
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_tickets`
--

DROP TABLE IF EXISTS `price_tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `price_tickets` (
  `parking_lot_id` int NOT NULL,
  `vehicle_type_id` tinyint NOT NULL,
  `period_time` int NOT NULL,
  `price` int NOT NULL,
  `unit` tinyint NOT NULL,
  PRIMARY KEY (`parking_lot_id`,`vehicle_type_id`,`period_time`),
  KEY `price_tickets_vehicle_type_fk` (`vehicle_type_id`),
  CONSTRAINT `price_tickets_parking_lot_fk` FOREIGN KEY (`parking_lot_id`) REFERENCES `parking_lots` (`parking_lot_id`),
  CONSTRAINT `price_tickets_vehicle_type_fk` FOREIGN KEY (`vehicle_type_id`) REFERENCES `vehicle_types` (`vehicle_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_tickets`
--

LOCK TABLES `price_tickets` WRITE;
/*!40000 ALTER TABLE `price_tickets` DISABLE KEYS */;
INSERT INTO `price_tickets` VALUES (1,0,0,3000,4),(1,0,4,2000,4),(1,0,8,1000,4),(1,1,0,5000,4),(1,1,4,3000,4),(1,1,8,2000,4),(1,2,0,20000,4),(1,2,4,10000,4),(1,2,8,5000,4),(1,3,0,50000,4),(1,3,4,25000,4),(1,3,8,10000,4),(2,0,0,3000,4),(2,0,4,2000,4),(2,0,8,1000,4),(2,1,0,5000,4),(2,1,4,3000,4),(2,1,8,2000,4),(2,2,0,20000,4),(2,2,4,10000,4),(2,2,8,5000,4),(2,3,0,50000,4),(2,3,4,25000,4),(2,3,8,10000,4),(3,0,0,3000,4),(3,0,4,2000,4),(3,0,8,1000,4),(3,1,0,5000,4),(3,1,4,3000,4),(3,1,8,2000,4),(3,2,0,20000,4),(3,2,4,10000,4),(3,2,8,5000,4),(3,3,0,50000,4),(3,3,4,25000,4),(3,3,8,10000,4),(4,0,0,3000,4),(4,0,4,2000,4),(4,0,8,1000,4),(4,1,0,5000,4),(4,1,4,3000,4),(4,1,8,2000,4),(4,2,0,20000,4),(4,2,4,10000,4),(4,2,8,5000,4),(4,3,0,50000,4),(4,3,4,25000,4),(4,3,8,10000,4),(5,1,0,5000,4),(5,1,4,3000,4),(5,1,8,2000,4),(6,1,0,5000,4),(6,1,4,3000,4),(6,1,8,2000,4),(7,1,0,5000,4),(7,1,4,3000,4),(7,1,8,2000,4),(8,1,0,5000,4),(8,1,4,3000,4),(8,1,8,2000,4),(9,1,0,5000,4),(9,1,4,3000,4),(9,1,8,2000,4),(10,0,0,3000,4),(10,0,4,2000,4),(10,0,8,1000,4),(10,1,0,5000,4),(10,1,4,3000,4),(10,1,8,2000,4),(10,2,0,20000,4),(10,2,4,10000,4),(10,2,8,5000,4),(11,0,0,3000,4),(11,0,4,2000,4),(11,0,8,1000,4),(11,1,0,5000,4),(11,1,4,3000,4),(11,1,8,2000,4),(11,2,0,20000,4),(11,2,4,10000,4),(11,2,8,5000,4),(12,0,0,3000,4),(12,0,4,2000,4),(12,0,8,1000,4),(12,1,0,5000,4),(12,1,4,3000,4),(12,1,8,2000,4),(12,2,0,20000,4),(12,2,4,10000,4),(12,2,8,5000,4),(13,0,0,3000,4),(13,0,4,2000,4),(13,0,8,1000,4),(13,1,0,5000,4),(13,1,4,3000,4),(13,1,8,2000,4),(13,2,0,20000,4),(13,2,4,10000,4),(13,2,8,5000,4),(14,0,0,3000,4),(14,0,4,2000,4),(14,0,8,1000,4),(14,1,0,5000,4),(14,1,4,3000,4),(14,1,8,2000,4),(14,2,0,20000,4),(14,2,4,10000,4),(14,2,8,5000,4),(15,0,0,3000,4),(15,0,4,2000,4),(15,0,8,1000,4),(15,1,0,5000,4),(15,1,4,3000,4),(15,1,8,2000,4),(15,2,0,20000,4),(15,2,4,10000,4),(15,2,8,5000,4),(16,0,0,3000,4),(16,0,4,2000,4),(16,0,8,1000,4),(16,1,0,5000,4),(16,1,4,3000,4),(16,1,8,2000,4),(16,2,0,20000,4),(16,2,4,10000,4),(16,2,8,5000,4),(17,0,0,3000,4),(17,0,4,2000,4),(17,0,8,1000,4),(17,1,0,5000,4),(17,1,4,3000,4),(17,1,8,2000,4),(17,2,0,20000,4),(17,2,4,10000,4),(17,2,8,5000,4),(18,0,0,3000,4),(18,0,4,2000,4),(18,0,8,1000,4),(18,1,0,5000,4),(18,1,4,3000,4),(18,1,8,2000,4),(19,0,0,3000,4),(19,0,4,2000,4),(19,0,8,1000,4),(19,1,0,5000,4),(19,1,4,3000,4),(19,1,8,2000,4),(20,0,0,3000,4),(20,0,4,2000,4),(20,0,8,1000,4),(20,1,0,5000,4),(20,1,4,3000,4),(20,1,8,2000,4),(21,0,0,3000,4),(21,0,4,2000,4),(21,0,8,1000,4),(21,1,0,5000,4),(21,1,4,3000,4),(21,1,8,2000,4),(22,0,0,3000,4),(22,0,4,2000,4),(22,0,8,1000,4),(22,1,0,5000,4),(22,1,4,3000,4),(22,1,8,2000,4);
/*!40000 ALTER TABLE `price_tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `ticket_id` bigint NOT NULL AUTO_INCREMENT,
  `check_in_time` datetime NOT NULL,
  `check_out_time` datetime DEFAULT NULL,
  `license_plates` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `vehicle_type_id` tinyint NOT NULL,
  `end_user_id` int NOT NULL,
  `parking_lot_id` int NOT NULL,
  `amount` int DEFAULT NULL,
  PRIMARY KEY (`ticket_id`),
  KEY `ticket_end_user_fk` (`end_user_id`),
  KEY `ticket_parking_lot` (`parking_lot_id`),
  KEY `ticket_vehicle_type_fk` (`vehicle_type_id`),
  CONSTRAINT `ticket_end_user_fk` FOREIGN KEY (`end_user_id`) REFERENCES `end_users` (`end_user_id`),
  CONSTRAINT `ticket_parking_lot` FOREIGN KEY (`parking_lot_id`) REFERENCES `parking_lots` (`parking_lot_id`),
  CONSTRAINT `ticket_vehicle_type_fk` FOREIGN KEY (`vehicle_type_id`) REFERENCES `vehicle_types` (`vehicle_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2207291418121735 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (1,'2022-07-18 14:26:34',NULL,'77C1-6180',1,5,5,NULL),(6,'2022-07-18 14:27:44',NULL,'77C1-85085',1,5,8,NULL),(7,'2022-07-18 14:27:45',NULL,'77C1-99794',1,3,5,NULL),(8,'2022-07-18 14:27:46',NULL,'77C1-86249',1,6,5,NULL),(9,'2022-07-18 14:27:46',NULL,'77C1-5505',1,5,3,NULL),(10,'2022-07-18 14:27:47',NULL,'77C1-11641',1,6,7,NULL),(11,'2022-07-18 14:27:47',NULL,'77C1-82649',1,9,1,NULL),(12,'2022-07-18 14:27:47',NULL,'77C1-97648',1,4,2,NULL),(13,'2022-07-18 14:27:48',NULL,'77C1-80268',1,4,9,NULL),(14,'2022-07-18 14:27:48',NULL,'77C1-84935',1,1,1,NULL),(15,'2022-07-18 14:27:48',NULL,'77C1-27549',1,6,4,NULL),(16,'2022-07-18 14:27:48',NULL,'77C1-10662',1,3,2,NULL),(18,'2022-07-18 14:27:48',NULL,'77C1-44094',1,2,6,NULL),(21,'2022-07-18 14:27:49',NULL,'77C1-37895',1,9,9,NULL),(22,'2022-07-18 14:27:50',NULL,'77C1-79353',1,1,11,NULL),(23,'2022-07-18 14:27:50',NULL,'77C1-25074',1,9,8,NULL),(24,'2022-07-18 14:27:50',NULL,'77C1-63352',1,5,9,NULL),(25,'2022-07-25 23:51:29',NULL,'77C1-67567',1,2,4,NULL),(26,'2022-07-26 00:24:02',NULL,'77C1-67567',1,3,4,NULL),(27,'2022-07-26 00:24:44',NULL,'77C1-67567',1,1,4,NULL),(28,'2022-07-26 00:25:16',NULL,'77C1-67567',1,1,3,NULL),(29,'2022-07-27 10:49:18',NULL,'77C1-67567',1,2,12,NULL),(30,'2022-07-27 10:51:17',NULL,'77C1-67567',1,2,13,NULL),(31,'2022-07-27 10:52:19',NULL,'77C1-67567',1,2,14,NULL),(32,'2022-07-27 11:04:31',NULL,'77C1-67567',1,3,14,NULL),(22072720484452,'2022-07-27 20:48:44',NULL,'77C1-6756799',1,2,5,NULL),(22072721544662,'2022-07-27 21:54:46',NULL,'77C1-6756799',1,2,6,NULL),(22072809580812,'2022-07-28 09:58:08',NULL,'77C1-6756799',1,2,1,NULL),(22072816072134,'2022-07-28 16:07:21',NULL,'77C1-6756799',1,4,3,NULL),(22072901353742,'2022-07-29 01:35:37',NULL,'74C1-69124',1,2,4,NULL),(220727143017143,'2022-07-27 14:30:17',NULL,'77C1-6756799',1,3,14,NULL),(220727143243222,'2022-07-27 14:32:43',NULL,'77C1-6756799',1,2,22,NULL),(220727215925102,'2022-07-27 21:59:25',NULL,'77C1-6756799',1,2,10,NULL),(220727220209112,'2022-07-27 22:02:09',NULL,'77C1-6756799',1,2,11,NULL),(220728114724212,'2022-07-28 11:47:24',NULL,'77C1-6756799',1,2,21,NULL),(220728160703124,'2022-07-28 16:07:03',NULL,'77C1-6756799',1,4,12,NULL),(220729015709333,'2022-07-29 01:57:09','2022-07-31 00:23:13','49C1-81212',1,33,3,NULL),(220729015945334,'2022-07-29 01:59:45',NULL,'98C1-55685',1,34,3,NULL),(220729032200733,'2022-07-29 03:22:00',NULL,'65C1-21654',1,33,7,NULL),(220729091921533,'2022-07-29 09:19:21','2022-07-31 00:04:59','35C1-13622',1,33,5,NULL),(220729094522133,'2022-07-29 09:45:22',NULL,'20C1-26824',1,33,1,NULL),(220729094641133,'2022-07-29 09:46:41','2022-07-30 23:35:12','40C1-53770',1,33,1,NULL),(220729102444535,'2022-07-29 10:24:44',NULL,'90C1-38243',1,35,5,NULL),(220729102526935,'2022-07-29 10:25:26',NULL,'89C1-70068',1,35,9,NULL),(220729142929131,'2022-07-29 14:29:29',NULL,'84C1-24939',1,1,13,NULL),(2207290143261032,'2022-07-29 01:43:26',NULL,'79C1-60749',1,32,10,NULL),(2207290149341033,'2022-07-29 01:49:34',NULL,'75C1-36537',1,33,10,NULL),(2207290159051034,'2022-07-29 01:59:05',NULL,'16C1-48516',1,34,10,NULL),(2207290159501734,'2022-07-29 01:59:50',NULL,'86C1-77880',1,34,17,NULL),(2207290304251332,'2022-07-29 03:04:25',NULL,'54C1-93855',1,32,13,NULL),(2207290914521235,'2022-07-29 09:14:52',NULL,'81C1-57133',1,35,12,NULL),(2207290925001233,'2022-07-29 09:25:00',NULL,'86C1-36665',1,33,12,NULL),(2207290949341133,'2022-07-29 09:49:34','2022-07-30 23:21:59','53C1-12350',1,33,11,NULL),(2207291359421734,'2022-07-29 13:59:42',NULL,'34C1-35597',1,34,17,NULL),(2207291418121734,'2022-07-29 14:18:12',NULL,'32C1-96886',1,34,17,NULL);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `transaction_id` bigint NOT NULL,
  `transaction_type` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  `ticket_id` bigint NOT NULL,
  `transaction_date` datetime NOT NULL,
  `transaction_log` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `transaction_ticket_fk` (`ticket_id`),
  CONSTRAINT `transaction_ticket_fk` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_types`
--

DROP TABLE IF EXISTS `vehicle_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle_types` (
  `vehicle_type_id` tinyint NOT NULL,
  `vehicle_type_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`vehicle_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_types`
--

LOCK TABLES `vehicle_types` WRITE;
/*!40000 ALTER TABLE `vehicle_types` DISABLE KEYS */;
INSERT INTO `vehicle_types` VALUES (0,'Xe đạp'),(1,'Xe máy'),(2,'Xe hơi 4 hoặc 7 chỗ'),(3,'Xe hơi 16 chỗ');
/*!40000 ALTER TABLE `vehicle_types` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-30 17:24:33
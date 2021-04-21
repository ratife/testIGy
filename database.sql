-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.31


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema testigy
--

CREATE DATABASE IF NOT EXISTS testigy;
USE testigy;

--
-- Definition of table `car`
--

DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `im` varchar(45) NOT NULL,
  `mark` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` (`id`,`im`,`mark`) VALUES 
 (1,'6565TAB','NISSAN'),
 (2,'6585CVA','TOYOTA');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;


--
-- Definition of table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `car_id` int(10) unsigned NOT NULL,
  `comment` text NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_comments_1` (`user_id`),
  KEY `FK_comments_2` (`car_id`),
  CONSTRAINT `FK_comments_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_comments_2` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comment`
--

/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`id`,`user_id`,`car_id`,`comment`,`date`) VALUES 
 (1,1,1,'belle voiture','2021-04-20 23:13:49'),
 (23,1,2,'Mon commentaire','2021-04-21 11:36:24'),
 (24,3,2,'De aôna daholo','2021-04-21 11:37:07'),
 (25,3,2,'Bonjour','2021-04-21 11:37:16'),
 (26,2,2,'J\'adore le TOYOTA','2021-04-21 11:38:38'),
 (27,2,1,'J\'aime pas le NISSAN','2021-04-21 11:38:50'),
 (28,1,1,'6585','2021-04-21 12:29:19'),
 (29,1,2,'6556','2021-04-21 12:29:23'),
 (30,1,1,'lllmlm','2021-04-21 12:29:31');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`name`,`email`,`password`,`role`) VALUES 
 (1,'Eric','eric@gmail.com','202cb962ac59075b964b07152d234b70','USER'),
 (2,'Jean','jean@gmail.com','202cb962ac59075b964b07152d234b70','USER'),
 (3,'Marc','marc@gmail.com','202cb962ac59075b964b07152d234b70','USER');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

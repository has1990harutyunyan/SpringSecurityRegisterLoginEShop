/*
SQLyog Ultimate v11.5 (32 bit)
MySQL - 5.7.18-log : Database - eshop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`eshop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `eshop`;

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `brand` */

insert  into `brand`(`id`,`name`) values (1,'ACNE'),(2,'GRUNE ERDE'),(3,'ALBIRO'),(4,'RONHILL'),(5,'ODDMOLLY'),(6,'BOUDESTIJN'),(7,'ROSCH CREATIVE CULTURE');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`name`) values (1,'SPORTSWEAR'),(2,'MENS'),(3,'WOMENS'),(4,'KIDS'),(5,'FASHION'),(6,'HOUSEHOLDS'),(7,'INTERIORS'),(8,'CLOTHING'),(9,'BAGS'),(10,'SHOES');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `category_id` int(11) unsigned NOT NULL,
  `brand_id` int(11) unsigned NOT NULL,
  `sleeve_type` varchar(255) NOT NULL,
  `colour` varchar(255) NOT NULL,
  `clothing_type` varchar(255) NOT NULL,
  `currency` varchar(255) NOT NULL,
  `cost` double NOT NULL,
  `quantity` int(11) NOT NULL,
  `availability` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `main_pic` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `brand_id` (`brand_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`category_id`,`brand_id`,`sleeve_type`,`colour`,`clothing_type`,`currency`,`cost`,`quantity`,`availability`,`state`,`main_pic`) values (4,2,4,'Sleeveless','Blue','T-Shirt','$',58,8,'In Stock','New','1501083178272_product2.jpg'),(5,3,1,'Sleeveless','Black','Dress','$',65,1,'In Stock','New','1501083223917_product4.jpg'),(6,3,4,'Sleeved','Blue','Japmer','$',78,3,'Out of Stock','New','1501083312848_product1.jpg'),(7,3,4,'Sleeveless','White','Shirt','$',12,5,'In Stock','New','1501083410324_product6.jpg'),(8,8,6,'Sleeveless','Black','Dress','$',100,2,'In Stock','New','1501083498951_product3.jpg'),(9,8,4,'Sleeved','Light blue','Sweater','$',36,10,'In Stock','New','1501083576148_product5.jpg');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('ADMIN','USER') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`email`,`password`,`role`) values (3,'User','user@mail.ru','$2a$10$jfaYOCAcZNaz0dKqrUoLP.XjGu11YYw7ZIk3vP69gkkC2js.EmXuq','USER'),(4,'Admin','admin@mail.ru','$2a$10$9./fmhNRP/m3KpWSR2ycU.d5SkHXNG8H84PbIpzaJ19Z1abhlTuhG','ADMIN');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

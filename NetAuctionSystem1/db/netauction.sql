/*
SQLyog - Free MySQL GUI v5.13
Host - 5.0.22-community-nt : Database - netauction
*********************************************************************
Server version : 5.0.22-community-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `netauction`;

USE `netauction`;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `admintable` */

DROP TABLE IF EXISTS `admintable`;

CREATE TABLE `admintable` (
  `username` varchar(50) default NULL,
  `password` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admintable` */

insert into `admintable` (`username`,`password`) values ('admin','admin');

/*Table structure for table `bidding_info` */

DROP TABLE IF EXISTS `bidding_info`;

CREATE TABLE `bidding_info` (
  `bidderid` varchar(50) default NULL,
  `bamt` varchar(20) default NULL,
  `itemid` varchar(20) default NULL,
  `biddate` varchar(30) default NULL,
  `status` varchar(30) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bidding_info` */

insert into `bidding_info` (`bidderid`,`bamt`,`itemid`,`biddate`,`status`) values ('selva','530','4','2013-03-29','1');
insert into `bidding_info` (`bidderid`,`bamt`,`itemid`,`biddate`,`status`) values ('user','9200','5','2013-03-29','1');
insert into `bidding_info` (`bidderid`,`bamt`,`itemid`,`biddate`,`status`) values ('user','15800','6','2013-03-29','1');
insert into `bidding_info` (`bidderid`,`bamt`,`itemid`,`biddate`,`status`) values ('user','1400','7','2019-03-16','1');
insert into `bidding_info` (`bidderid`,`bamt`,`itemid`,`biddate`,`status`) values ('aaa','1500','9','2019-03-18','1');

/*Table structure for table `category_master` */

DROP TABLE IF EXISTS `category_master`;

CREATE TABLE `category_master` (
  `catid` varchar(10) NOT NULL,
  `cat_name` varchar(100) default NULL,
  PRIMARY KEY  (`catid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `category_master` */

insert into `category_master` (`catid`,`cat_name`) values ('1','Electronics');
insert into `category_master` (`catid`,`cat_name`) values ('2','Computers');
insert into `category_master` (`catid`,`cat_name`) values ('3','Mobiles');
insert into `category_master` (`catid`,`cat_name`) values ('4','Jewellery');
insert into `category_master` (`catid`,`cat_name`) values ('5','Arts and Collections');
insert into `category_master` (`catid`,`cat_name`) values ('6','Home and Life');
insert into `category_master` (`catid`,`cat_name`) values ('7','Travel');

/*Table structure for table `item_master` */

DROP TABLE IF EXISTS `item_master`;

CREATE TABLE `item_master` (
  `itemid` int(8) NOT NULL auto_increment,
  `catid` varchar(50) default NULL,
  `itemname` varchar(50) default NULL,
  `descr` varchar(50) default NULL,
  `summary` varchar(50) default NULL,
  `startprice` varchar(50) default NULL,
  `incrprice` varchar(50) default NULL,
  `stdate` varchar(50) default NULL,
  `enddate` varchar(50) default NULL,
  `seller` varchar(50) default NULL,
  `bidcnt` varchar(50) default NULL,
  PRIMARY KEY  (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `item_master` */

insert into `item_master` (`itemid`,`catid`,`itemname`,`descr`,`summary`,`startprice`,`incrprice`,`stdate`,`enddate`,`seller`,`bidcnt`) values (4,'1','gms','jjjjjj','gsm','500','10','2013-03-29','2013-03-29','user','7');
insert into `item_master` (`itemid`,`catid`,`itemname`,`descr`,`summary`,`startprice`,`incrprice`,`stdate`,`enddate`,`seller`,`bidcnt`) values (5,'3','samsung mobile','ntkio','mobile','9000','100','2013-03-29','2013-04-29','selva','8');
insert into `item_master` (`itemid`,`catid`,`itemname`,`descr`,`summary`,`startprice`,`incrprice`,`stdate`,`enddate`,`seller`,`bidcnt`) values (6,'2','laptop','laptop computers','laptop','15000','200','2013-03-29','2013-04-29','vicky','1');
insert into `item_master` (`itemid`,`catid`,`itemname`,`descr`,`summary`,`startprice`,`incrprice`,`stdate`,`enddate`,`seller`,`bidcnt`) values (7,'1','mobile','sfefbe','camera mov=bile','1200','100','2019-03-16','2019-03-17','selva','2');
insert into `item_master` (`itemid`,`catid`,`itemname`,`descr`,`summary`,`startprice`,`incrprice`,`stdate`,`enddate`,`seller`,`bidcnt`) values (8,'1','mobile','ceb fredaa','camera movbile s','1200','100','2019-03-16','2019-03-17','selva','1');
insert into `item_master` (`itemid`,`catid`,`itemname`,`descr`,`summary`,`startprice`,`incrprice`,`stdate`,`enddate`,`seller`,`bidcnt`) values (9,'1','laptop','good one for graphics','lap with high configuration','1200','100','2019-03-18','2019-03-20','selva','2');

/*Table structure for table `rateitem` */

DROP TABLE IF EXISTS `rateitem`;

CREATE TABLE `rateitem` (
  `itemrate` varchar(50) default NULL,
  `itemid` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rateitem` */

/*Table structure for table `uinfo_master` */

DROP TABLE IF EXISTS `uinfo_master`;

CREATE TABLE `uinfo_master` (
  `uname` varchar(50) NOT NULL,
  `pwd` varchar(50) default NULL,
  `fname` varchar(50) default NULL,
  `lname` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  `phno` varchar(50) default NULL,
  `address` varchar(200) default NULL,
  `city` varchar(50) default NULL,
  `state` varchar(50) default NULL,
  `pin` varchar(50) default NULL,
  `country` varchar(50) default NULL,
  PRIMARY KEY  (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `uinfo_master` */

insert into `uinfo_master` (`uname`,`pwd`,`fname`,`lname`,`email`,`phno`,`address`,`city`,`state`,`pin`,`country`) values ('aaa','aaa','Selva','Kumar','dselvait@gmail.com','9003570191','89North Street','Tirunelveli','T.M','627115','India');
insert into `uinfo_master` (`uname`,`pwd`,`fname`,`lname`,`email`,`phno`,`address`,`city`,`state`,`pin`,`country`) values ('kumar','kumar','selva','kumar','dselvait@gmail.com','9003570191','north street','tirunelveli','tn','627115','india');
insert into `uinfo_master` (`uname`,`pwd`,`fname`,`lname`,`email`,`phno`,`address`,`city`,`state`,`pin`,`country`) values ('logesh','logesh','dfg','df','fdgf','554354','33','fdg','TN','85','India');
insert into `uinfo_master` (`uname`,`pwd`,`fname`,`lname`,`email`,`phno`,`address`,`city`,`state`,`pin`,`country`) values ('selva','javas','Selva','Kumar','dselvait@gmail.com','9003570191','89North Street','Tirunelveli','T.M','627115','India');
insert into `uinfo_master` (`uname`,`pwd`,`fname`,`lname`,`email`,`phno`,`address`,`city`,`state`,`pin`,`country`) values ('user','user','user','user','user@gmail.com','9003570191','89adambakkam','chennai','TN','600088','India');
insert into `uinfo_master` (`uname`,`pwd`,`fname`,`lname`,`email`,`phno`,`address`,`city`,`state`,`pin`,`country`) values ('vicky','vicky','vicky','d','vicky@gmail.com','7502483536','89North Street','Tirunelveli','TN','627115','India');

/*Table structure for table `wallet` */

DROP TABLE IF EXISTS `wallet`;

CREATE TABLE `wallet` (
  `username` varchar(50) default NULL,
  `amount` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `wallet` */

insert into `wallet` (`username`,`amount`) values ('selva','1000');
insert into `wallet` (`username`,`amount`) values ('aaa','5000');

SET SQL_MODE=@OLD_SQL_MODE;
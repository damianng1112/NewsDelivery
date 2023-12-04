CREATE DATABASE newsagentdb;
USE newsagentdb;

DROP TABLE IF EXISTS customerdetails;
CREATE TABLE customerdetails (
    `cus_id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `address` VARCHAR(60) NOT NULL,
    `phoneNo` VARCHAR(15) NOT NULL,
    `town` VARCHAR(15) NOT NULL,
    `publication` VARCHAR(15) NOT NULL
)AUTO_INCREMENT=1;


DROP TABLE IF EXISTS delivery_person;
CREATE TABLE delivery_person (
  `DP_id` INT AUTO_INCREMENT PRIMARY KEY,
  `Name` varchar(20) NOT NULL,
  `Delivery_address` varchar(40) NOT NULL,
  `Contact_num` varchar(15) NOT NULL,
  `town` varchar(20) NOT NULL
 )AUTO_INCREMENT=1;


DROP TABLE IF EXISTS delivery_docket;
CREATE TABLE delivery_docket (
  `Cname` int NOT NULL,
  `publication` varchar(40) NOT NULL,
  `Dname`  varchar(40) NOT NULL,
  `town` varchar(40) NOT NULL
) AUTO_INCREMENT=1;

DROP TABLE IF EXISTS publication;
CREATE TABLE publication (
  `pub_id` INT AUTO_INCREMENT PRIMARY KEY,
  `pub_name` varchar(15) NOT NULL,
  `price` double NOT NULL   
)AUTO_INCREMENT=1;


DROP TABLE IF EXISTS newsagent;
CREATE TABLE newsagent (
  `Nagent_id` INT AUTO_INCREMENT PRIMARY KEY,
  `cus_name` varchar(15) NOT NULL,
  `cus_address` varchar(15) NOT NULL,
  `cus_number` varchar(15) NOT NULL,
  `cus_publication` varchar(15) NOT NULL
)AUTO_INCREMENT=1;


DROP TABLE IF EXISTS admin;
CREATE TABLE admin (
  `admin_id` INT AUTO_INCREMENT PRIMARY KEY,
  `Nagent_name` varchar(15) NOT NULL,
  `Nagent_address` varchar(15) NOT NULL,  
  `Nagent_number` varchar(15) NOT NULL
)AUTO_INCREMENT=1;


DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `ord_id` INT AUTO_INCREMENT PRIMARY KEY,
  `cus_id` INT AUTO_INCREMENT PRIMARY KEY,
  `cus_name` varchar(15) NOT NULL,
  `cus_address` varchar(15) NOT NULL,  
  `cus_number` varchar(15) NOT NULL,
  `publication` varchar(15) NOT NULL
)AUTO_INCREMENT=1;


DROP TABLE IF EXISTS invoice;
CREATE TABLE invoice (
   `inv_id` INT AUTO_INCREMENT PRIMARY KEY,
  `cus_name` varchar(15) NOT NULL,
  `cus_address` varchar(15) NOT NULL,
  `cus_number` varchar(15) NOT NULL,
  `publication` varchar(15) NOT NULL,  
  `price` varchar(15) NOT NULL
)AUTO_INCREMENT=1;


DROP TABLE IF EXISTS users;
CREATE TABLE users (
    `user_id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(60) NOT NULL,
    `position` VARCHAR(15) NOT NULL
)AUTO_INCREMENT=1;

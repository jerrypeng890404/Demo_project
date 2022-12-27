--CREATE TABLE IF NOT EXISTS `register1` (
--  `account` VARCHAR(20) NOT NULL,
--  `pwd` VARCHAR(45) NOT NULL,
--  `name` VARCHAR(20) NULL,
--  `age` INT NULL,
--  `city` VARCHAR(10) NULL,
--  `reg_time` DATETIME NULL,
--  `active` TINYINT NULL,
--  `role` VARCHAR(45) NULL,
--  PRIMARY KEY (`account`));

--  ·s¼WSQL
--  CREATE TABLE IF NOT EXISTS `student course1` (
--  `id` varchar(20) NOT NULL,
--  `student id` varchar(20) DEFAULT NULL,
--  `student name` varchar(20) DEFAULT NULL,
--  `course code` varchar(20) DEFAULT NULL,
--  `course name` varchar(20) DEFAULT NULL,
--  `course day` varchar(20) DEFAULT NULL,
--  `course start` time DEFAULT NULL,
--  `coursse end` time DEFAULT NULL,
--  `credit` int DEFAULT NULL,
--  PRIMARY KEY (`id`));
--  
--  CREATE TABLE `course1` (
--  `coursecode` varchar(20) NOT NULL,
--  `coursename` varchar(20) DEFAULT NULL,
--  `courseday` varchar(20) DEFAULT NULL,
--  `coursestart` time DEFAULT NULL,
--  `courseend` time DEFAULT NULL,
--  `credit` int DEFAULT NULL,
--  PRIMARY KEY (`coursecode`));

CREATE TABLE IF NOT EXISTS `student course` (
  `id` varchar(20) NOT NULL,
  `student id` varchar(20) DEFAULT NULL,
  `student name` varchar(20) DEFAULT NULL,
  `course code` varchar(20) DEFAULT NULL,
  `course name` varchar(20) DEFAULT NULL,
  `course day` varchar(20) DEFAULT NULL,
  `course start` time DEFAULT NULL,
  `course end` time DEFAULT NULL,
  `credit` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS`course` (
  `course code` varchar(20) NOT NULL,
  `course name` varchar(20) DEFAULT NULL,
  `course day` varchar(20) DEFAULT NULL,
  `course start` time DEFAULT NULL,
  `course end` time DEFAULT NULL,
  `credit` int DEFAULT NULL,
  PRIMARY KEY (`course code`)
);
--  
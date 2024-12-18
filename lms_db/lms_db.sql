CREATE DATABASE  IF NOT EXISTS `lms_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lms_db`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lms_db
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books_table`
--

DROP TABLE IF EXISTS `books_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(250) DEFAULT NULL,
  `TITLE` varchar(250) DEFAULT NULL,
  `AUTHOR` varchar(250) DEFAULT NULL,
  `IS_BORROWED` tinyint DEFAULT NULL,
  `BOOK_IMAGE` longblob,
  `DateCreated` datetime DEFAULT CURRENT_TIMESTAMP,
  `DateUpdated` datetime DEFAULT NULL,
  `DateDeleted` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idbooks_table_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_table`
--

LOCK TABLES `books_table` WRITE;
/*!40000 ALTER TABLE `books_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `books_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrowed_books_table`
--

DROP TABLE IF EXISTS `borrowed_books_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrowed_books_table` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `MEMBER_ID` int DEFAULT NULL,
  `MEMBERNAME` varchar(250) DEFAULT NULL,
  `BOOKTITLE` varchar(250) DEFAULT NULL,
  `BOOK_ISBN` varchar(250) DEFAULT NULL,
  `NUMBER_OF_BOOKS` int DEFAULT '1',
  `DateCreated` datetime DEFAULT CURRENT_TIMESTAMP,
  `DateUpdated` datetime DEFAULT NULL,
  `DateDeleted` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowed_books_table`
--

LOCK TABLES `borrowed_books_table` WRITE;
/*!40000 ALTER TABLE `borrowed_books_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrowed_books_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members_table`
--

DROP TABLE IF EXISTS `members_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `members_table` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `MEMBER_ID` int DEFAULT NULL,
  `NAME` varchar(250) DEFAULT NULL,
  `LASTNAME` varchar(250) DEFAULT NULL,
  `BORROWEDLIMIT` int DEFAULT '0',
  `DateCreated` datetime DEFAULT CURRENT_TIMESTAMP,
  `DateUpdated` datetime DEFAULT NULL,
  `DateDeleted` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `idmembers_table_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members_table`
--

LOCK TABLES `members_table` WRITE;
/*!40000 ALTER TABLE `members_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `members_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-18 11:22:51

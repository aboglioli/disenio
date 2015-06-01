CREATE DATABASE  IF NOT EXISTS `disenio_tp03` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `disenio_tp03`;
-- MySQL dump 10.13  Distrib 5.5.43, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: disenio_tp03
-- ------------------------------------------------------
-- Server version	5.5.43-0ubuntu0.14.04.1

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
-- Table structure for table `Articulo`
--

DROP TABLE IF EXISTS `Articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Articulo` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  `cantidadPallet` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Articulo`
--

LOCK TABLES `Articulo` WRITE;
/*!40000 ALTER TABLE `Articulo` DISABLE KEYS */;
INSERT INTO `Articulo` VALUES (1,'pantuflas',345);
/*!40000 ALTER TABLE `Articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EstadoReposicion`
--

DROP TABLE IF EXISTS `EstadoReposicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EstadoReposicion` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EstadoReposicion`
--

LOCK TABLES `EstadoReposicion` WRITE;
/*!40000 ALTER TABLE `EstadoReposicion` DISABLE KEYS */;
INSERT INTO `EstadoReposicion` VALUES (1,'Pendiente'),(2,'En Curso');
/*!40000 ALTER TABLE `EstadoReposicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reposicion`
--

DROP TABLE IF EXISTS `Reposicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Reposicion` (
  `numero` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `estadoReposicion_codigo` int(11) NOT NULL,
  PRIMARY KEY (`numero`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reposicion`
--

LOCK TABLES `Reposicion` WRITE;
/*!40000 ALTER TABLE `Reposicion` DISABLE KEYS */;
INSERT INTO `Reposicion` VALUES (1,'2015-05-19',2),(2,'2015-05-01',1);
/*!40000 ALTER TABLE `Reposicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ReposicionArticulo`
--

DROP TABLE IF EXISTS `ReposicionArticulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ReposicionArticulo` (
  `cantidad_reposicion` int(11) DEFAULT NULL,
  `promedio_venta` float DEFAULT NULL,
  `total_pedido_pendiente` int(11) DEFAULT NULL,
  `stock_disponible` int(11) DEFAULT NULL,
  `seleccionado` tinyint(1) DEFAULT NULL,
  `Articulo_codigo` int(11) NOT NULL,
  `Reposicion_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ReposicionArticulo`
--

LOCK TABLES `ReposicionArticulo` WRITE;
/*!40000 ALTER TABLE `ReposicionArticulo` DISABLE KEYS */;
INSERT INTO `ReposicionArticulo` VALUES (13,5,3,5,1,1,1);
/*!40000 ALTER TABLE `ReposicionArticulo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-01  2:59:29

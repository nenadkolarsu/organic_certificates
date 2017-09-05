-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.6.12-log

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
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (2,'Jose Eduardo','Gonzalez Chavira','8486470201','eduardo.gch@gmail.com','2016-07-24 19:19:55'),(3,'Lidia','Romero','527222105285','lidianrol@gmail.com','2016-07-24 19:19:55'),(4,'Guillermo','Wolf','7221324324','gjgw@mialcancia.com.mx','2016-07-24 19:19:55'),(5,'Gloria','Cahvira','722243424','gloria.chavira@gmail.com','2016-07-24 19:19:55');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kupac`
--

DROP TABLE IF EXISTS `kupac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kupac` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL,
  `maticni_broj` varchar(50) NOT NULL,
  `pib` varchar(50) NOT NULL,
  `pdv_potvrda` varchar(50) NOT NULL,
  `adresa` varchar(50) NOT NULL,
  `mesto` varchar(50) NOT NULL,
  `racun` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kupac`
--

LOCK TABLES `kupac` WRITE;
/*!40000 ALTER TABLE `kupac` DISABLE KEYS */;
INSERT INTO `kupac` VALUES (1,'Zadrugarka','122','222','332','Marsala Tita','22','112-11122'),(2,'dva','22','23','24','25','26','27'),(4,'cetvrdi kupac','cetvrti ','cetvrti ','cetvrti ','cetvrti ','cetvrti ','cetvrti '),(243,'243','saf','asdf','asdf','asfd','asdf','asdf');
/*!40000 ALTER TABLE `kupac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `narudzba`
--

DROP TABLE IF EXISTS `narudzba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `narudzba` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `kupac` varchar(45) DEFAULT NULL,
  `roba` varchar(45) DEFAULT NULL,
  `kolicina` double DEFAULT NULL,
  `cena` double DEFAULT NULL,
  `iznos` double DEFAULT NULL,
  `aktivan` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `narudzba`
--

LOCK TABLES `narudzba` WRITE;
/*!40000 ALTER TABLE `narudzba` DISABLE KEYS */;
INSERT INTO `narudzba` VALUES (12,'2015-05-12','1','1',10,10,10,1),(13,'2015-05-16','4','1',11,12,122,1);
/*!40000 ALTER TABLE `narudzba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `First_Name` varchar(50) DEFAULT NULL,
  `Last_Name` varchar(25) DEFAULT NULL,
  `City` varchar(25) DEFAULT NULL,
  `Zip` varchar(25) DEFAULT NULL,
  `State` varchar(25) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (NULL,NULL,NULL,NULL,NULL,1,'pera','holandija');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proizvodjaci`
--

DROP TABLE IF EXISTS `proizvodjaci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proizvodjaci` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sifra` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `naziv` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `adresa` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `mesto` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `pak` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `napomena` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `napomena1` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `napomena2` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `datum_mesto` datetime ,
  `aktivan` tinyint(1) DEFAULT NULL,
  `new_tablecol` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sifra_UNIQUE` (`sifra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proizvodjaci`
--

LOCK TABLES `proizvodjaci` WRITE;
/*!40000 ALTER TABLE `proizvodjaci` DISABLE KEYS */;
/*!40000 ALTER TABLE `proizvodjaci` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roba`
--

DROP TABLE IF EXISTS `roba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roba` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `klasifikacija` varchar(45) DEFAULT NULL,
  `jm` varchar(45) DEFAULT NULL,
  `porez` double DEFAULT NULL,
  `ulaz` double DEFAULT NULL,
  `izlaz` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roba`
--

LOCK TABLES `roba` WRITE;
/*!40000 ALTER TABLE `roba` DISABLE KEYS */;
INSERT INTO `roba` VALUES (1,'prvi proizvod','voce','kg',20,9,0),(2,'drugi proizvod','povrce','kg',0,160,0);
/*!40000 ALTER TABLE `roba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sertifikati`
--

DROP TABLE IF EXISTS `sertifikati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sertifikati` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `broj_sertifikata` varchar(45) DEFAULT NULL,
  `proizvodjac_id` int(11) DEFAULT NULL,
  `proizvodjac_sifra` varchar(45) DEFAULT NULL,
  `proizvodjac` varchar(100) DEFAULT NULL,
  `proizvodjac_skraceno` varchar(45) DEFAULT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  `ptt_broj` varchar(45) DEFAULT NULL,
  `mesto` varchar(45) DEFAULT NULL,
  `zemlja_sifra` varchar(45) DEFAULT NULL,
  `zemlja` varchar(45) DEFAULT NULL,
  `sifra_vrsta_proizvodnje` varchar(45) DEFAULT NULL,
  `naziv_vrsta_proizvodnje` varchar(100) DEFAULT NULL,
  `datum_kontrole` date DEFAULT NULL,
  `mesto_izdavanja` varchar(45) DEFAULT NULL,
  `datum_izdavanja` date DEFAULT NULL,
  `vazi_do` date DEFAULT NULL,
  `asortiman` varchar(100) DEFAULT NULL,
  `asortiman_sifra` varchar(45) DEFAULT NULL,
  `tip_sertifikata` varchar(100) DEFAULT NULL,
  `tip_sertifikata_sifra` varchar(45) DEFAULT NULL,
  `rezerva1` varchar(100) DEFAULT NULL,
  `rezerva2` varchar(100) DEFAULT NULL,
  `rezerva3` varchar(45) DEFAULT NULL,
  `aktivan` tinyint(1) DEFAULT '1',
  `datum_vreme` datetime ,
  `sertifikaticol` varchar(45) DEFAULT NULL,
  `id_vrsta_proizvodnje` int(11) DEFAULT NULL,
  `sertifikaticol1` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `broj_sertifikata_UNIQUE` (`broj_sertifikata`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sertifikati`
--

LOCK TABLES `sertifikati` WRITE;
/*!40000 ALTER TABLE `sertifikati` DISABLE KEYS */;
INSERT INTO `sertifikati` VALUES (1,'1',1,'1','Lula','lula','Bez broja','24000','Subotica','1','Srbija','1','Kupina divlja','2001-05-20','Subotica izdavanje','2003-03-20','2005-05-20',NULL,NULL,'asd',NULL,'a','b',NULL,NULL,'2016-07-23 13:35:05',NULL,NULL,NULL),(2,'2',2,'2','Maranda PP','MARANDA','KOSTE TRIFKOVIĆA','11000','Beograd','2','BIH','2','Začinsko bilje','2003-07-20','Subotica izdav','2014-02-20','2016-01-20',NULL,NULL,'asdfasd',NULL,'c','d',NULL,NULL,'2016-07-23 13:35:05',NULL,NULL,NULL);
/*!40000 ALTER TABLE `sertifikati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'aaa',1),(2,'ccc',3);
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `User_email` varchar(50) DEFAULT NULL,
  `User_password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('a@a.com','a'),('b@b.com','b'),('c@c.com','c');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zaposleni`
--

DROP TABLE IF EXISTS `zaposleni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zaposleni` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `adresa` varchar(45) NOT NULL,
  `starost` int(11) NOT NULL,
  `zarada` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zaposleni`
--

LOCK TABLES `zaposleni` WRITE;
/*!40000 ALTER TABLE `zaposleni` DISABLE KEYS */;
INSERT INTO `zaposleni` VALUES (1,'peraasdf','amt asdf',51,24000),(2,'qwer','ew',654,9879);
/*!40000 ALTER TABLE `zaposleni` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-03 22:11:24


create database dbclinica;

use dbclinica;



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
-- Table structure for table `agendamento`
--

DROP TABLE IF EXISTS `agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agendamento` (
  `agendamento_cod` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `agendamento_turno` varchar(10) DEFAULT NULL,
  `agendamento_data` date DEFAULT NULL,
  `agendamento_motivo` varchar(50) DEFAULT NULL,
  `agendamento_status` varchar(15) DEFAULT NULL,
  `agendamento_codpac` int(11) DEFAULT NULL,
  `agendamento_codmedico` int(11) DEFAULT NULL,
  PRIMARY KEY (`agendamento_cod`),
  UNIQUE KEY `agendamento_cod` (`agendamento_cod`),
  KEY `paci_codigo_idx` (`agendamento_codpac`),
  KEY `codigo_idx` (`agendamento_codmedico`),
  CONSTRAINT `paci_codigo` FOREIGN KEY (`agendamento_codpac`) REFERENCES `pacientes` (`paci_codigo`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `codigo` FOREIGN KEY (`agendamento_codmedico`) REFERENCES `medicos` (`codigo`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento`
--

LOCK TABLES `agendamento` WRITE;
/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
INSERT INTO `agendamento` VALUES (8,'Vespertino','2016-11-10','preguiça','aberto',24,19),(9,'Matutino','2016-11-30','unha encravada','aberto',26,17),(10,'Noturno','2017-01-25','dor de cabeça','aberto',26,19),(11,'Noturno','2016-12-31','suspeita de infarto','aberto',24,18);
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bairros`
--

DROP TABLE IF EXISTS `bairros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bairros` (
  `idbairro` int(11) NOT NULL AUTO_INCREMENT,
  `nomebairro` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idbairro`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bairros`
--

LOCK TABLES `bairros` WRITE;
/*!40000 ALTER TABLE `bairros` DISABLE KEYS */;
INSERT INTO `bairros` VALUES (1,'pinheiro'),(2,'pacaembu'),(3,'maracana'),(4,'vale do sol'),(5,'Jardim das Rosas'),(6,'Aeroporto'),(7,'Central Park'),(8,'Vila Brasil'),(9,'Vila Angélica'),(10,'Residencial Parque dos Girassó'),(11,'Parque Residencial Damha III'),(12,'Parque Residencial Damha IIi'),(13,'Parque Residencial Damha'),(14,'Parque Residencial Carandá'),(15,'Jardim Leonor');
/*!40000 ALTER TABLE `bairros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidades`
--


/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidades` (
  `idEspecializacoes` int(11) NOT NULL AUTO_INCREMENT,
  `especializacoes` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idEspecializacoes`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidades`
--

LOCK TABLES `especialidades` WRITE;
/*!40000 ALTER TABLE `especialidades` DISABLE KEYS */;
INSERT INTO `especialidades` VALUES (1,'Pediatra'),(2,'Clinico Geral'),(3,'Cirurgião Dentista'),(4,'Obstetrícia'),(5,'Anestesiologia'),(6,'Ginecologia'),(7,'Ortopedia'),(8,'Cardiologia');
/*!40000 ALTER TABLE `especialidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicos`
--

DROP TABLE IF EXISTS `medicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicos` (
  `nome` varchar(50) DEFAULT NULL,
  `CRM` int(11) DEFAULT NULL,
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `especialidade` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicos`
--

LOCK TABLES `medicos` WRITE;
/*!40000 ALTER TABLE `medicos` DISABLE KEYS */;
INSERT INTO `medicos` VALUES ('marlon',96698,14,'Cardiologia'),('ana',9874,17,'Ortopedia'),('filisbino',963852,18,'Cardiologia'),('pereira neves soares',123546445,19,'Pediatra'),('Corinthians',45325,20,'Ginecologia');
/*!40000 ALTER TABLE `medicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pacientes` (
  `paci_codigo` int(11) NOT NULL AUTO_INCREMENT,
  `paci_nome` varchar(30) DEFAULT NULL,
  `paci_rg` int(11) DEFAULT NULL,
  `paci_telefone` int(11) DEFAULT NULL,
  `paci_rua` varchar(30) DEFAULT NULL,
  `paci_cep` int(11) DEFAULT NULL,
  `paci_complemento` varchar(50) DEFAULT NULL,
  `paci_nasc` int(11) DEFAULT NULL,
  `paci_bairro` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`paci_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacientes`
--

LOCK TABLES `pacientes` WRITE;
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
INSERT INTO `pacientes` VALUES (24,'maria de fatima',5666,99995,'alfredo marcondes 241',19160000,'vai que vc chega',10051997,'Central Park'),(25,'chicao',5000,993993,'manoel goulart 16',19160235,'so vai',20122016,'Vila Angélica'),(26,'ju',4000,9968855,'alfredo marcondes',4536885,'ao lado do mercado',10051997,'Parque Residencial Damha'),(27,'ze das couves',500,455485,'Brazil',19658000,'ao lado do cristo rei',1234,'Vila Brasil');
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-04 11:33:20

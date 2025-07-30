CREATE DATABASE  IF NOT EXISTS `cine` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cine`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: cine
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `asientos`
--

DROP TABLE IF EXISTS `asientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asientos` (
  `id_asiento` int NOT NULL,
  `numero` varchar(10) NOT NULL,
  `fila` varchar(10) NOT NULL,
  `tipo_asiento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_asiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asientos`
--

LOCK TABLES `asientos` WRITE;
/*!40000 ALTER TABLE `asientos` DISABLE KEYS */;
INSERT INTO `asientos` VALUES (101,'A1','A','VIP'),(102,'A2','A','VIP'),(201,'B1','B','Normal'),(202,'B2','B','Normal');
/*!40000 ALTER TABLE `asientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletos`
--

DROP TABLE IF EXISTS `boletos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boletos` (
  `id_boleto` int NOT NULL,
  `tipo_boleto` varchar(50) NOT NULL,
  `precio_base` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_boleto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletos`
--

LOCK TABLES `boletos` WRITE;
/*!40000 ALTER TABLE `boletos` DISABLE KEYS */;
INSERT INTO `boletos` VALUES (1,'General',120.00),(2,'Estudiante',80.00),(3,'VIP',200.00);
/*!40000 ALTER TABLE `boletos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `dni_cliente` varchar(20) NOT NULL,
  `primer_nombre` varchar(50) NOT NULL,
  `segundo_nombre` varchar(50) DEFAULT NULL,
  `primer_apellido` varchar(50) NOT NULL,
  `segundo_apellido` varchar(50) DEFAULT NULL,
  `genero` varchar(20) DEFAULT NULL,
  `correo_cliente` varchar(100) DEFAULT NULL,
  `telefono_cliente` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dni_cliente`),
  KEY `idx_clientes_correo` (`correo_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('0801199700033','Sofía','María','Martínez',NULL,'Femenino','sofia.martinez@example.com','94560003'),('0801199800022','Carlos',NULL,'Mejía','González','Masculino','carlos.mejia@example.com','98760002'),('0801199900011','Ana','Lucía','Ramírez','Flores','Femenino','ana.ramirez@example.com','97850001');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalles_venta`
--

DROP TABLE IF EXISTS `detalles_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalles_venta` (
  `id_detalle_venta` int NOT NULL AUTO_INCREMENT,
  `id_venta` int DEFAULT NULL,
  `id_boleto` int DEFAULT NULL,
  `cantidad` int DEFAULT '1',
  `id_asiento` int DEFAULT NULL,
  PRIMARY KEY (`id_detalle_venta`),
  KEY `id_venta` (`id_venta`),
  KEY `id_boleto` (`id_boleto`),
  KEY `id_asiento` (`id_asiento`),
  CONSTRAINT `detalles_venta_ibfk_1` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id_venta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detalles_venta_ibfk_2` FOREIGN KEY (`id_boleto`) REFERENCES `boletos` (`id_boleto`),
  CONSTRAINT `detalles_venta_ibfk_3` FOREIGN KEY (`id_asiento`) REFERENCES `asientos` (`id_asiento`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalles_venta`
--

LOCK TABLES `detalles_venta` WRITE;
/*!40000 ALTER TABLE `detalles_venta` DISABLE KEYS */;
INSERT INTO `detalles_venta` VALUES (1,1,3,1,101),(2,2,2,2,201),(3,3,1,1,202),(4,5,1,1,101),(5,6,1,1,101),(6,7,1,20,101);
/*!40000 ALTER TABLE `detalles_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `dni_empleado` varchar(20) NOT NULL,
  `primer_nombre` varchar(50) NOT NULL,
  `segundo_nombre` varchar(50) DEFAULT NULL,
  `primer_apellido` varchar(50) NOT NULL,
  `segundo_apellido` varchar(50) DEFAULT NULL,
  `genero` varchar(20) DEFAULT NULL,
  `telefono_empleado` varchar(20) DEFAULT NULL,
  `contrasena` varchar(255) NOT NULL DEFAULT '1234',
  `estado` varchar(10) DEFAULT 'ACTIVO',
  PRIMARY KEY (`dni_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES ('0801199915440','dfg','dfg','dfgfg','dfgdg','Masculino','12345678','$2a$12$fNR3nglZuZbjs/CvPfmPsOVbcqmECn3C1jOXr6cvz11XeS/crWACm','ACTIVO'),('0901199300022','Patricia','Elena','Torres','López','Femenino','98440005','clave456','INACTIVO'),('0901199500011','Luis',NULL,'Castillo','Hernández','Masculino','98330004','admin123','ACTIVO');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funciones`
--

DROP TABLE IF EXISTS `funciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funciones` (
  `id_funcion` int NOT NULL AUTO_INCREMENT,
  `id_pelicula` int NOT NULL,
  `fecha_funcion` datetime NOT NULL,
  `hora_inicio` time NOT NULL,
  `tipo_proyeccion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_funcion`),
  KEY `idx_funciones_id_pelicula` (`id_pelicula`),
  CONSTRAINT `funciones_ibfk_1` FOREIGN KEY (`id_pelicula`) REFERENCES `peliculas` (`id_pelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funciones`
--

LOCK TABLES `funciones` WRITE;
/*!40000 ALTER TABLE `funciones` DISABLE KEYS */;
INSERT INTO `funciones` VALUES (1,1,'2025-08-01 18:00:00','18:00:00','3D'),(2,2,'2025-08-01 20:00:00','20:00:00','2D'),(3,3,'2025-08-02 17:00:00','17:00:00','IMAX'),(4,1,'2025-07-30 20:57:37','10:28:45','2D'),(5,1,'2025-07-11 21:13:21','10:36:36','IMAX');
/*!40000 ALTER TABLE `funciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generos`
--

DROP TABLE IF EXISTS `generos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generos` (
  `id_genero` int NOT NULL AUTO_INCREMENT,
  `nombre_genero` varchar(100) NOT NULL,
  PRIMARY KEY (`id_genero`),
  UNIQUE KEY `nombre_genero` (`nombre_genero`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generos`
--

LOCK TABLES `generos` WRITE;
/*!40000 ALTER TABLE `generos` DISABLE KEYS */;
INSERT INTO `generos` VALUES (1,'Acción'),(2,'Comedia'),(3,'Drama'),(4,'Fantasía'),(5,'Terror');
/*!40000 ALTER TABLE `generos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peliculas`
--

DROP TABLE IF EXISTS `peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peliculas` (
  `id_pelicula` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `director` varchar(100) DEFAULT NULL,
  `duracion` int DEFAULT NULL,
  `sinopsis` text,
  `restriccion_edad` varchar(50) DEFAULT NULL,
  `fecha_estreno` date DEFAULT NULL,
  PRIMARY KEY (`id_pelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peliculas`
--

LOCK TABLES `peliculas` WRITE;
/*!40000 ALTER TABLE `peliculas` DISABLE KEYS */;
INSERT INTO `peliculas` VALUES (1,'Guardianes del Multiverso','James Gunn',145,'Un equipo de héroes lucha para salvar múltiples realidades.','PG-13','2023-07-15'),(2,'Risas a Domicilio','Greta Gerwig',98,'Una comedia que sigue a una familia disfuncional durante la cuarentena.','PG','2022-12-20'),(3,'Almas Errantes','Makoto Shinkai',120,'Un romance sobrenatural en medio del apocalipsis.','R','2023-03-10'),(4,'New Horizon','mac miller',NULL,'fiosfoosiufisufisdufisui','15+','2025-07-09');
/*!40000 ALTER TABLE `peliculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peliculas_genero`
--

DROP TABLE IF EXISTS `peliculas_genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peliculas_genero` (
  `id_pelicula` int NOT NULL,
  `id_genero` int NOT NULL,
  PRIMARY KEY (`id_pelicula`,`id_genero`),
  KEY `id_genero` (`id_genero`),
  CONSTRAINT `peliculas_genero_ibfk_1` FOREIGN KEY (`id_pelicula`) REFERENCES `peliculas` (`id_pelicula`),
  CONSTRAINT `peliculas_genero_ibfk_2` FOREIGN KEY (`id_genero`) REFERENCES `generos` (`id_genero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peliculas_genero`
--

LOCK TABLES `peliculas_genero` WRITE;
/*!40000 ALTER TABLE `peliculas_genero` DISABLE KEYS */;
INSERT INTO `peliculas_genero` VALUES (1,1),(4,1),(2,2),(4,2),(3,3),(4,3),(1,4),(3,4);
/*!40000 ALTER TABLE `peliculas_genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `id_venta` int NOT NULL AUTO_INCREMENT,
  `dni_cliente` varchar(20) DEFAULT NULL,
  `dni_empleado` varchar(20) DEFAULT NULL,
  `id_funcion` int DEFAULT NULL,
  `fecha_venta` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_venta`),
  KEY `dni_cliente` (`dni_cliente`),
  KEY `dni_empleado` (`dni_empleado`),
  KEY `id_funcion` (`id_funcion`),
  CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`dni_cliente`) REFERENCES `clientes` (`dni_cliente`),
  CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`dni_empleado`) REFERENCES `empleados` (`dni_empleado`),
  CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`id_funcion`) REFERENCES `funciones` (`id_funcion`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,'0801199900011','0901199500011',1,'2025-07-30 15:53:39'),(2,'0801199800022','0901199300022',2,'2025-07-30 15:53:39'),(3,'0801199700033','0901199500011',3,'2025-07-30 15:53:39'),(5,'0801199700033','0901199500011',5,'2025-07-17 17:49:56'),(6,'0801199700033','0901199500011',5,'2025-07-11 17:50:38'),(7,'0801199700033','0901199500011',5,'2025-07-30 17:51:00');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'cine'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-30 15:42:54

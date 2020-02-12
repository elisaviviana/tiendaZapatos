-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 12-02-2020 a las 16:32:13
-- Versión del servidor: 5.6.26
-- Versión de PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `TiendaZapatos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `id` bigint(20) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `categoria` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `cod_producto` varchar(50) COLLATE latin1_spanish_ci DEFAULT NULL,
  `descripcion` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `genero` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `marca` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `modelo` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `activo` int(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `cantidad`, `categoria`, `cod_producto`, `descripcion`, `genero`, `marca`, `modelo`, `precio`, `activo`) VALUES
(7, NULL, 'sarasa2', 'codprod', 'carnaval', 'hombre', 'pod33385', NULL, 25871, 1),
(9, NULL, 'una categoriaNueva', 'codprod1', 'feliz comienzo', 'hombre', 'ID9', NULL, 25871, 1),
(10, NULL, 'zueco', 'codprod2', 'un zapato con zueco', 'hombre', 'marca1', NULL, 345346546, 1),
(11, NULL, 'sarasa', 'codprod3', 'un zapato con zueco', 'hombre', 'marca3', NULL, 56456, 1),
(12, NULL, 'alto', 'codprod4', 'zapato alto', 'mujer', 'adidas', NULL, 6775, 1),
(13, NULL, 'sarasa', 'codprod5', 'un zapato con zueco', 'hombre', 'marca3', NULL, 25871, 1),
(14, NULL, 'deportiva', 'codprod6', 'puente', 'hombre', 'adidas', NULL, 540567, 1),
(15, NULL, 'deportiva', 'codprod7', 'zapatilla deportiva', 'hombre', 'topper', NULL, 81378, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

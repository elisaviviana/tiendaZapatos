-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 18-02-2020 a las 16:12:32
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
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `id` bigint(20) NOT NULL,
  `activo` int(11) DEFAULT '1',
  `nombre` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `activo`, `nombre`) VALUES
(1, 1, 'Deportivo'),
(2, 1, 'Zuecos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE IF NOT EXISTS `genero` (
  `id` bigint(20) NOT NULL,
  `activo` int(11) DEFAULT NULL,
  `nombre` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

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
(20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE IF NOT EXISTS `marca` (
  `id` bigint(20) NOT NULL,
  `activo` int(11) DEFAULT NULL,
  `nombre` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`id`, `activo`, `nombre`) VALUES
(19, 1, 'adidas');

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
  `activo` int(1) DEFAULT '1',
  `img` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `id_categoria` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `cantidad`, `categoria`, `cod_producto`, `descripcion`, `genero`, `marca`, `modelo`, `precio`, `activo`, `img`, `id_categoria`) VALUES
(7, NULL, 'sarasa2', 'codprod7', 'carnaval', 'mujer', 'pod33385', NULL, 77777777, 1, NULL, 1),
(9, NULL, 'una categoriaNueva', 'codprod63', 'Zapatilla Roja', 'hombre', 'ID9', NULL, 25871, 1, 'img/productos/adidas1.jpg', 0),
(10, NULL, 'zueco', 'codprod2', 'Zapatilla W', 'hombre', 'marca1', NULL, 345346546, 1, 'img/productos/zapatillaW.jpeg', 0),
(11, NULL, 'sarasa', 'codprod3', 'Cross niña', 'hombre', 'marca3', NULL, 56456, 1, 'img/productos/cross.jpeg', 0),
(12, NULL, 'alto', 'codprod4', 'Zapatilla Gris', 'mujer', 'adidas', NULL, 6775, 1, 'img/productos/zapatilla1.jpeg', 0),
(13, NULL, 'sarasa', 'codprod5', 'Sandalia', 'hombre', 'marca3', NULL, 25871, 1, 'img/productos/sandalianiña.jpeg', 0),
(14, NULL, 'deportiva', 'codprod6', 'puente', 'hombre', 'adidas', NULL, 540567, 1, '', 1),
(15, NULL, 'deportiva', 'codprod17', 'zapatilla ', 'hombre', 'topper', NULL, 81378, 1, NULL, 1),
(17, NULL, 'sarasa2', 'codprod1', 'carnaval', 'hombre', 'pod33385', NULL, 3333, 1, 'img/productos/tacoAlto.jpeg', 0),
(18, NULL, 'deportiva', 'codprod6', 'puente', 'hombre', 'adidas', NULL, 66666, 1, 'img/productos/zapaniño.jpeg', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` bigint(20) NOT NULL,
  `activo` int(11) DEFAULT NULL,
  `apellido` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `contrasenia` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `direccion` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `dni` int(11) NOT NULL,
  `email` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE latin1_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `activo`, `apellido`, `contrasenia`, `direccion`, `dni`, `email`, `nombre`) VALUES
(16, 1, 'Staiti', NULL, 'Coronel Diaz 229', 0, 'elisa@gmail.com', 'Elisa');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_categoria` (`id_categoria`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

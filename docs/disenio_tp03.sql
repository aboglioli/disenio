-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 30-05-2015 a las 23:37:14
-- Versión del servidor: 10.0.18-MariaDB-log
-- Versión de PHP: 5.6.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `disenio_tp03`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Articulo`
--

CREATE TABLE IF NOT EXISTS `Articulo` (
`codigo` int(11) NOT NULL,
  `nombre` varchar(250) DEFAULT NULL,
  `cantidad_pallet` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Articulo`
--

INSERT INTO `Articulo` (`codigo`, `nombre`, `cantidad_pallet`) VALUES
(1, 'pantuflas', 345);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `EstadoReposicion`
--

CREATE TABLE IF NOT EXISTS `EstadoReposicion` (
`codigo` int(11) NOT NULL,
  `nombre` varchar(250) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `EstadoReposicion`
--

INSERT INTO `EstadoReposicion` (`codigo`, `nombre`) VALUES
(1, 'Pendiente'),
(2, 'En Curso');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Reposicion`
--

CREATE TABLE IF NOT EXISTS `Reposicion` (
`numero` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `estadoReposicion_codigo` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Reposicion`
--

INSERT INTO `Reposicion` (`numero`, `fecha`, `estadoReposicion_codigo`) VALUES
(1, '2015-05-19', 2),
(2, '2015-05-01', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Reposicion_Articulo`
--

CREATE TABLE IF NOT EXISTS `Reposicion_Articulo` (
  `cantidad_reposicion` int(11) DEFAULT NULL,
  `promedio_venta` float DEFAULT NULL,
  `total_pedido_pendiente` int(11) DEFAULT NULL,
  `stock_disponible` int(11) DEFAULT NULL,
  `seleccionado` tinyint(1) DEFAULT NULL,
  `Articulo_codigo` int(11) NOT NULL,
  `Reposicion_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Articulo`
--
ALTER TABLE `Articulo`
 ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `EstadoReposicion`
--
ALTER TABLE `EstadoReposicion`
 ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `Reposicion`
--
ALTER TABLE `Reposicion`
 ADD PRIMARY KEY (`numero`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Articulo`
--
ALTER TABLE `Articulo`
MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `EstadoReposicion`
--
ALTER TABLE `EstadoReposicion`
MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `Reposicion`
--
ALTER TABLE `Reposicion`
MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

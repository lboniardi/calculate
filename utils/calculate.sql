-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2021 at 01:58 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `calculate`
--

-- --------------------------------------------------------

--
-- Table structure for table `gastos`
--

CREATE TABLE `gastos` (
  `idgasto` int(11) NOT NULL,
  `dia` date NOT NULL,
  `valor` double DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_nombre_rubro` int(11) DEFAULT NULL,
  `id_nombre_gasto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ingresos`
--

CREATE TABLE `ingresos` (
  `id` int(11) NOT NULL,
  `monto` double NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `usuario_ingreso` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nombregasto`
--

CREATE TABLE `nombregasto` (
  `id` int(11) NOT NULL,
  `nombre_gasto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rubros`
--

CREATE TABLE `rubros` (
  `idrubro` int(11) NOT NULL,
  `nombrerubro` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `apellido` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `usuario` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contraseña` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`idusuario`, `nombre`, `apellido`, `usuario`, `contraseña`) VALUES
(2, 'leonor', 'pere', 'leoperez', '1234'),
(8, 'Julieta', 'Perez', 'juliet', '12345'),
(9, 'Nicolas', 'Petrecca', 'NicoP', '12345'),
(10, 'lolol', 'lalala', 'lalalal|', '2345'),
(11, 'leonor', 'lopez', 'leolopez', '1234'),
(12, 'juan ', 'perez', 'juanperez', '1234'),
(14, 'leonzia', 'perez', 'leonzia8', '12345'),
(15, 'diego', 'maradona', 'diez', '1234'),
(16, 'juan', 'perez', 'juperez', '1234'),
(18, 'conde', 'dracula', 'vampire', '1234'),
(21, 'laura', 'lopez', 'arluapoze', '1234'),
(22, 'oli', 'perez', 'oliver1', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gastos`
--
ALTER TABLE `gastos`
  ADD PRIMARY KEY (`idgasto`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_nombre_rubro` (`id_nombre_rubro`,`id_nombre_gasto`),
  ADD KEY `id_nombre_gasto` (`id_nombre_gasto`);

--
-- Indexes for table `ingresos`
--
ALTER TABLE `ingresos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_ingreso` (`usuario_ingreso`);

--
-- Indexes for table `nombregasto`
--
ALTER TABLE `nombregasto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nombre_gasto` (`nombre_gasto`);

--
-- Indexes for table `rubros`
--
ALTER TABLE `rubros`
  ADD PRIMARY KEY (`idrubro`),
  ADD KEY `nombrerubro` (`nombrerubro`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idusuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gastos`
--
ALTER TABLE `gastos`
  MODIFY `idgasto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ingresos`
--
ALTER TABLE `ingresos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nombregasto`
--
ALTER TABLE `nombregasto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rubros`
--
ALTER TABLE `rubros`
  MODIFY `idrubro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gastos`
--
ALTER TABLE `gastos`
  ADD CONSTRAINT `gastos_ibfk_1` FOREIGN KEY (`id_nombre_gasto`) REFERENCES `nombregasto` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `gastos_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `ingresos`
--
ALTER TABLE `ingresos`
  ADD CONSTRAINT `ingresos_ibfk_1` FOREIGN KEY (`usuario_ingreso`) REFERENCES `usuarios` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `rubros`
--
ALTER TABLE `rubros`
  ADD CONSTRAINT `rubros_ibfk_1` FOREIGN KEY (`idrubro`) REFERENCES `gastos` (`id_nombre_rubro`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

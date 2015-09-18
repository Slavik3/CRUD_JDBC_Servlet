-- phpMyAdmin SQL Dump
-- version 3.2.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 16, 2015 at 09:17 AM
-- Server version: 5.1.40
-- PHP Version: 5.2.12

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `vyacheslav_kozlov_akvelon`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `birthday` date NOT NULL,
  `amount_of_money` int(11) NOT NULL,
  `address` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=cp1251 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `surname`, `email`, `birthday`, `amount_of_money`, `address`) VALUES
(1, 'James', 'Smith', 'James@gmail.com', '1995-09-19', 150000, ' 1234 Main Street  Anytown, USA'),
(2, 'David', 'Brown', 'Dbrown@gmail.com', '1998-09-07', 1000000, '421 Fallsway Baltimore, MD 21202'),
(3, 'Alexia', 'Butler', 'butler@gmail.com', '1999-09-14', 150000, '110 S Vine St Maryville, MO 64468'),
(4, 'David', 'Reid', 'reid1@gmail.com', '1998-09-18', 1000000, '610 S Main St Maryville, MO 64468'),
(5, 'Alick', 'Clarke', 'clarke12@gmail.com', '2000-09-19', 1000000, 'S Smith St Albany, MO 64402'),
(6, 'Alvis', 'Hudson', 'hudson@gmail.om', '1997-09-23', 1000000, '115 W Clay St Albany, MO 64402');

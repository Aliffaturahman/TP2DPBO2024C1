-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 13, 2024 at 03:38 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_mahasiswa`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int(11) NOT NULL,
  `nim` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(255) NOT NULL,
  `hobby` varchar(255) NOT NULL,
  `mbti` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nim`, `nama`, `jenis_kelamin`, `hobby`, `mbti`) VALUES
(1, '2203999', 'Amelia Zalfa Julianti', 'Perempuan', 'Berdandan', 'INTJ'),
(2, '2202292', 'Muhammad Iqbal Fadhilah', 'Laki-laki', 'Bernyanyi', 'INTP'),
(3, '2202346', 'Muhammad Rifky Afandi', 'Laki-laki', 'Memancing', 'ENTJ'),
(4, '2210239', 'Muhammad Hanif Abdillah', 'Laki-laki', 'Berenang', 'ENTP'),
(5, '2202046', 'Nurainun', 'Perempuan', 'Memasak', 'INFJ'),
(6, '2205101', 'Kelvin Julian Putra', 'Laki-laki', 'Ngoding', 'INFP'),
(7, '2200163', 'Rifanny Lysara Annastasya', 'Perempuan', 'Berkebun', 'ENFJ'),
(8, '2202869', 'Revana Faliha Salma', 'Perempuan', 'Membaca Buku', 'ENFP'),
(9, '2209489', 'Rakha Dhifiargo Hariadi', 'Laki-laki', 'Belajar', 'ISTJ'),
(10, '2203142', 'Roshan Syalwan Nurilham', 'Laki-laki', 'Bermain Bola', 'ISFJ'),
(11, '2200311', 'Raden Rahman Ismail', 'Laki-laki', 'Tidur', 'ESTJ'),
(12, '2200978', 'Ratu Syahirah Khairunnisa', 'Perempuan', 'Membuat Vlog', 'ESFJ'),
(13, '2204509', 'Muhammad Fahreza Fauzan', 'Laki-laki', 'Bermain Gitar', 'ISTP'),
(14, '2205027', 'Muhammad Rizki Revandi', 'Laki-laki', 'Sunmori', 'ESFP'),
(15, '2203484', 'Arya Aydin Margono', 'Laki-laki', 'Mendaki', 'ESTP'),
(16, '2200481', 'Marvel Ravindra Dioputra', 'Laki-laki', 'Membuat Video', 'ESFP'),
(17, '2209889', 'Muhammad Fadlul Hafiizh', 'Laki-laki', 'Jajan', 'INTJ'),
(18, '2206697', 'Rifa Sania', 'Perempuan', 'Belanja', 'INTP'),
(19, '2207260', 'Imam Chalish Rafidhul Haque', 'Laki-laki', 'Foto-foto', 'ENTJ'),
(20, '2204343', 'Meiva Labibah Putri', 'Perempuan', 'Jalan-jalan', 'ENTP');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

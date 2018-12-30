-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 08, 2018 at 03:55 AM
-- Server version: 10.0.34-MariaDB-0ubuntu0.16.04.1
-- PHP Version: 7.0.28-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `app_wisata-batam`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `username` varchar(8) NOT NULL,
  `password` varchar(8) NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`username`, `password`, `nama`) VALUES
('admin', 'admin', 'Administrator');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_event`
--

CREATE TABLE `tbl_event` (
  `id_event` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `event` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_event`
--

INSERT INTO `tbl_event` (`id_event`, `tanggal`, `event`) VALUES
(1, '2018-03-01', 'Pameran Batam PPI'),
(4, '2018-07-26', 'Pameran PPUN'),
(5, '2018-09-27', 'Batam Invite 2018');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_profil`
--

CREATE TABLE `tbl_profil` (
  `id_profil` int(11) NOT NULL,
  `nama` text NOT NULL,
  `konten` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_profil`
--

INSERT INTO `tbl_profil` (`id_profil`, `nama`, `konten`) VALUES
(1, 'Visi', '“ TERWUJUDNYA BATAM SEBAGAI KAWASAN PENGEMBANGAN BUDAYA BANGSA DAN MENJADI PINTU GERBANG PARIWISATA BAGIAN BARAT “'),
(2, 'Misi', '1. Melestarikan Nilai serta Mengembangkan Keragaman dan Kekayaan budaya Bangsa dengan tetap menjadikan Budaya Melayu sebagai Payung Negeri;\r\n2. Meningkatkan kualitas Sumber Daya Manusia serta Pengelolaan Sarana dan Prasarana Kepariwisataan;\r\n3. Mengembangkan Industri Pariwisata yang berdaya saing, Destinasi yang unggul serta Pemasaran dan Promosi Pariwisata yang berkelanjutan.'),
(3, 'Webiste', 'https://disbudpar.batam.go.id/'),
(4, 'Kontak', 'Telp. 0778470530');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_wisata`
--

CREATE TABLE `tbl_wisata` (
  `id_wisata` int(10) NOT NULL,
  `nama_objek` text NOT NULL,
  `foto_cover` text NOT NULL,
  `lokasi` text NOT NULL,
  `deskripsi` text NOT NULL,
  `latitude` text NOT NULL,
  `longitude` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_wisata`
--

INSERT INTO `tbl_wisata` (`id_wisata`, `nama_objek`, `foto_cover`, `lokasi`, `deskripsi`, `latitude`, `longitude`) VALUES
(1, 'Pantai Tanjung Memban', 'p_tj_memban.png', 'Kel. Batu Besar, Kec. Nongsa', 'Pantai Tanjung Bemban terletak di Kecamatan Nongsa tepatnya di kawasan Batu Besar. Pantai Tanjung Bemban merupakan salah satu obyek wisata pantai yang yang patut anda kunjungi di Pulau Batam ini. Sebagai salah satu obyek wisata pantai yang populer di Pulau Batam, Pantai Tanjung Bemban sangat ramai dikunjungi oleh wisatawan. Dari Pantai ini anda dapat melihat kapal-kapal berlayar menuju Singapura dan Malaysia dari Pelabuhan di Kota Tanjungpinang, Pulau Bintan.', '1.172550', '104.134934'),
(4, 'Pantai Kampung Melayu', 'p_kmpung_melayu.png', 'Kel. Batu Besar, Kec. Nongsa', 'Pantai Kampung Melayu ini berlokasi di Nongsa, Batam. Tempat ini menawarkan pemandangan pantai dengan kampung masyarakat melayu.\r\n\r\nPantai ini dapat menjadi alternatif mengisi waktu bersama pasangan, teman-teman maupun bersama keluarga.', '1.146076', '104.142581'),
(53, 'Pantai Nongsa', 'p_nongsa.png', 'Kel. Sambau, Kec. Nongsa', '', '1.196034', '104.086744'),
(54, 'Pantai Teluk Mata Ikan', 'p_tl_mt_ikn.png', 'Kel. Sambau, Kec. Nongsa', '', '1.194491', '104.103687'),
(63, 'Pantai Batu Besar', 'pantai batu besar.png', 'Kel. Batu Besar, Kec. Nongsa', '', '1.145947', '104.142597'),
(64, 'Pantai Melayu', 'Pantai Melayu.png', 'Kel. Rempangcate, Kec. Galang', '', '0.856761', '104.146036'),
(65, 'Pantai Melur', 'Pantai Melur.png', 'Kel. Sijantung, Kec. Galang', '', '0.755952', '104.186061'),
(66, 'Pulau Abang', 'Pulau Abang.png', 'Kel. Pulau Abang, Kec. Galang', '', '0.718699', '104.211629'),
(67, 'Pulau Hantu', 'Pulau Hantu.png', 'Kel. Pulau Abang, Kec. Galang', '', '0.718206', '104.210899'),
(68, 'Pulau Rano', 'Pulau Rano.png', 'Kel. Pulau Abang, Kec. Galang', '', '0.718430', '104.211498'),
(69, 'Pulau Karas', 'Pulau Karas.png', 'Kel. Karas, Kec. Galang', '', '0.718889', '104.212956'),
(70, 'Pantai Permata Subangmas', 'Pantai Permata Subangmas.png', 'Kel. Subangmas, Kec. Galang', '', '0.976583', '104.051169'),
(71, 'Pantai Mirota', 'Pantai Mirota.png', 'Kec. Galang', '', '0.774634', '104.173807'),
(72, 'Pantai Setokok', 'Pantai Setokok.png', 'Kel. Setokok, Kec. Bulang', '', '0.923340', '104.061391'),
(73, 'Pantai Melawa', 'Pantai Melawa.png', 'Kel. Sekanak Raya, Kec. Belakang Padang', '', '1.124457', '103.927612'),
(74, 'Pantai Tanjung Pinggir', 'Pantai Tanjung Pinggir.png', 'Kel. Tanjung Pinggir, Kec. Sekupang', '', '1.142893', '103.923472'),
(75, 'Pantai Tanjung Datuk', 'images (3).jpeg', 'Kel. Tanjung Pinggir, Kec. Sekupang', '', '1.142829', '103.922112'),
(76, 'Pantai Tanjung Buntung', 'Pantai Tanjung Buntung.png', 'Kel. Bengkong Laut, Kec. Bengkong', '', '1.162069', '104.042578'),
(77, 'Pantai Pasir Putih', 'Pantai Pasir Putih.png', 'Kel. Tanjung Piayu, Kec. Sei Beduk', '', '1.027385', '104.097272'),
(78, 'Mega Wisata Ocarina', 'Mega Wisata Ocarina.png', 'Kel. Belian, Kec. Batam Kota', '', '1.152473', '104.056817'),
(79, 'Pantai Sekilak', 'Pantai Sekilak.png', 'Kel. Batu Besar, Kec. Nongsa', '', '1.142457', '104.148356'),
(80, 'Pantai Marina', 'Pantai Marina.png', 'Kel. Tanjung Riau Kec. Sekupang', '', '1.082712', '103.932720'),
(81, 'Pantai Elang - Elang Laut', 'Pantai Elang-Elang Laut.png', 'Kel. Tanjung Sari, Kec. Belakang Padang', '', '1.124457', '103.927612'),
(82, 'Pantai Golden Beach', 'Pantai Golden Beach.png', 'Kel. Bengkong Laut, Kec. Bengkong', '', '1.161930', '104.042505'),
(89, 'Welcome To Batam', 'images (4).jpeg', 'Kel. Teluk Tering, Kec. Batam Kota', '', '1.124399', '104.053674'),
(90, 'Jembatan Barelang', 'images (5).jpeg', 'Kec. Galang', '', '0.982044', '104.041547'),
(92, 'Alun-alun Engku Putri', 'images (6).jpeg', 'Kel. Teluk Tering, Kec. Batam Kota', '', '1.128857', '104.054415'),
(93, 'Masjid Agung Batam', 'images (7).jpeg', 'Kel. Teluk Tering, Kec. Batam Kota', '', '1.126662', '104.05302'),
(94, 'Masjid Muhammad Cheng Hoo ', 'images (8).jpeg', 'Kel. Tanjung Buntung, Kec, Bengkong', '', '1.166221', '104.038938'),
(95, 'Hutan Wisata Mata Kucing', 'images (2).jpeg', 'Kel. Kibing, Kec Batu Aji', '', '1.085011', '103.971555'),
(96, 'Kampung Vietnam', 'images (1).jpeg', 'Kec Galang', '', '0.767876', '104.189439'),
(97, 'Water Park Top 100 Tembesi', 'Waterpark Top 100 Tembesi.png', 'Kel. Tembesi, Kec Sagulung', '', '1.039531', '104.004315'),
(114, 'Stt ibnusina', 'IMG_20180512_134638.jpg', 'Nagoya', '', '1.1454', '104.01614'),
(115, 'Rujak wisata', 'IMG_20180512_155657.jpg', 'Kampung seraya', 'Rujak enak batam', '1.14541', '104.01581');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tbl_event`
--
ALTER TABLE `tbl_event`
  ADD PRIMARY KEY (`id_event`);

--
-- Indexes for table `tbl_profil`
--
ALTER TABLE `tbl_profil`
  ADD PRIMARY KEY (`id_profil`);

--
-- Indexes for table `tbl_wisata`
--
ALTER TABLE `tbl_wisata`
  ADD PRIMARY KEY (`id_wisata`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_event`
--
ALTER TABLE `tbl_event`
  MODIFY `id_event` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `tbl_profil`
--
ALTER TABLE `tbl_profil`
  MODIFY `id_profil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tbl_wisata`
--
ALTER TABLE `tbl_wisata`
  MODIFY `id_wisata` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2025 at 10:23 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestion_stock`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

CREATE TABLE `categorie` (
  `idCategorie` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`idCategorie`, `nom`) VALUES
(1, 'Moteurs'),
(2, 'Câbles'),
(3, 'Boutons et Panneaux'),
(4, 'Rails de Guidage'),
(5, 'Portes'),
(6, 'Capteurs et Sécurité'),
(7, 'Armoires de Contrôle'),
(8, 'Systèmes Hydrauliques'),
(9, 'Freins'),
(10, 'Éclairage');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `téléphone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`idClient`, `nom`, `adresse`, `téléphone`, `email`) VALUES
(5, 'anas', 'kenitra', '06292962', 'anas@gmail.com'),
(6, 'simo', 'rabat', '0633875912', 'moad@gmail.com'),
(7, 'hichame', 'kenitra', '06292962', 'anas@gmail.com'),
(11, 'zakaria', 'el harhorie', '0623255896', 'zakariia@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

CREATE TABLE `commande` (
  `idCommande` int(11) NOT NULL,
  `dateCommande` date NOT NULL,
  `idFournisseur` int(11) DEFAULT NULL,
  `idClient` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `commande`
--

INSERT INTO `commande` (`idCommande`, `dateCommande`, `idFournisseur`, `idClient`) VALUES
(6, '2025-03-26', NULL, 5),
(7, '2025-03-28', NULL, 7),
(8, '2025-03-28', NULL, 5),
(9, '2025-03-28', 4, NULL),
(10, '2025-03-28', 6, NULL),
(11, '2025-03-28', 7, NULL),
(13, '2025-04-10', NULL, 5),
(16, '2025-04-10', 4, NULL),
(19, '2025-04-10', NULL, 5),
(21, '2025-04-10', NULL, 5),
(23, '2025-04-10', NULL, 5),
(24, '2025-04-10', 4, NULL),
(27, '2025-04-10', NULL, 5),
(28, '2025-04-10', 4, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `idFournisseur` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fournisseur`
--

INSERT INTO `fournisseur` (`idFournisseur`, `nom`, `contact`, `adresse`) VALUES
(4, 'messi', '0625251212', 'miami'),
(6, 'yassine', '0629292929', 'kenitra'),
(7, 'Rachide', '0425282930', 'Tanger');

-- --------------------------------------------------------

--
-- Table structure for table `lignecommande`
--

CREATE TABLE `lignecommande` (
  `idCommande` int(11) NOT NULL,
  `idProduit` int(11) NOT NULL,
  `quantite` int(11) NOT NULL CHECK (`quantite` > 0),
  `prix` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lignecommande`
--

INSERT INTO `lignecommande` (`idCommande`, `idProduit`, `quantite`, `prix`) VALUES
(6, 2, 20, 600),
(7, 5, 3, 150),
(8, 2, 5, 12500),
(9, 6, 10, 5000),
(10, 10, 2, 800),
(11, 4, 8, 2400),
(13, 2, 2, 21),
(16, 2, 3, 31.5),
(19, 2, 2, 21),
(21, 2, 2, 21),
(23, 2, 2, 21),
(24, 2, 3, 31.5),
(27, 2, 2, 21),
(28, 2, 3, 31.5);

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE `produit` (
  `idProduit` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `prix` decimal(10,2) NOT NULL,
  `quantiteEnStock` int(11) NOT NULL DEFAULT 0,
  `idCategorie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`idProduit`, `nom`, `description`, `prix`, `quantiteEnStock`, `idCategorie`) VALUES
(2, 'Produit Modifié', 'Nouvelle description', 150.00, 5, 2),
(3, 'Câble en acier 8mm', 'Câble de traction en acier de 8mm', 200.00, 50, 2),
(4, 'Câble en acier 10mm', 'Câble de traction en acier de 10mm', 300.00, 40, 2),
(5, 'Bouton d’appel standard', 'Bouton d’appel avec éclairage LED', 50.00, 100, 3),
(6, 'Panneau de commande digital', 'Panneau tactile pour ascenseur', 500.00, 15, 3),
(7, 'Rail de guidage 2m', 'Rail en acier de 2 mètres', 120.00, 30, 4),
(8, 'Rail de guidage 3m', 'Rail en acier de 3 mètres', 180.00, 20, 4),
(9, 'Porte automatique', 'Porte coulissante automatique', 800.00, 8, 5),
(10, 'Porte manuelle', 'Porte battante manuelle', 400.00, 12, 5),
(11, 'Capteur de niveau', 'Capteur de précision pour arrêt d’étage', 150.00, 25, 6),
(12, 'Frein de sécurité', 'Système de freinage d’urgence', 600.00, 10, 7),
(22, 'moteur ', 'moteur décoré à la main', 300.00, 10, 1),
(23, 'cable', 'cable traditionnelle', 450.00, 15, 2),
(24, 'capteur', 'capteur traditionnelle', 450.00, 15, 4),
(25, 'Produit à supprimer', 'Test', 50.00, 5, 1),
(26, 'Nouveau Produit', 'Description test', 100.00, 10, 1),
(27, 'Produit à supprimer', 'Test', 50.00, 5, 1),
(28, 'Nouveau Produit', 'Description test', 100.00, 10, 1),
(29, 'Produit à supprimer', 'Test', 50.00, 5, 1),
(30, 'Nouveau Produit', 'Description test', 100.00, 10, 1),
(31, 'Produit à supprimer', 'Test', 50.00, 5, 1),
(32, 'Nouveau Produit', 'Description test', 100.00, 10, 1);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idUtilisateur` int(11) NOT NULL,
  `nomUtilisateur` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `motDePasse` varchar(255) NOT NULL,
  `role` enum('admin') NOT NULL DEFAULT 'admin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `nomUtilisateur`, `email`, `motDePasse`, `role`) VALUES
(1, 'anas', 'admin@gmail.com', '12345678', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`idCategorie`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`);

--
-- Indexes for table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`idCommande`),
  ADD KEY `idFournisseur` (`idFournisseur`),
  ADD KEY `fk_commande_client` (`idClient`);

--
-- Indexes for table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`idFournisseur`);

--
-- Indexes for table `lignecommande`
--
ALTER TABLE `lignecommande`
  ADD PRIMARY KEY (`idCommande`,`idProduit`),
  ADD KEY `idProduit` (`idProduit`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`idProduit`),
  ADD KEY `idCategorie` (`idCategorie`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idUtilisateur`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `commande`
--
ALTER TABLE `commande`
  MODIFY `idCommande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `idFournisseur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
  MODIFY `idProduit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`idFournisseur`) REFERENCES `fournisseur` (`idFournisseur`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_commande_client` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON UPDATE CASCADE;

--
-- Constraints for table `lignecommande`
--
ALTER TABLE `lignecommande`
  ADD CONSTRAINT `lignecommande_ibfk_1` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`idCommande`) ON DELETE CASCADE,
  ADD CONSTRAINT `lignecommande_ibfk_2` FOREIGN KEY (`idProduit`) REFERENCES `produit` (`idProduit`) ON DELETE CASCADE;

--
-- Constraints for table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `produit_ibfk_1` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCategorie`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

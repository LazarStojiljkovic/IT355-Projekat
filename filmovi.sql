-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 11, 2024 at 07:58 PM
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
-- Database: `filmovi`
--

-- --------------------------------------------------------

--
-- Table structure for table `direktor`
--

CREATE TABLE `direktor` (
  `direktor_id` int(11) NOT NULL,
  `ime` text NOT NULL,
  `prezime` text NOT NULL,
  `biografija` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `direktor`
--

INSERT INTO `direktor` (`direktor_id`, `ime`, `prezime`, `biografija`) VALUES
(1, 'Steven', 'Spielberg', 'Steven Spielberg is an American director, producer, and screenwriter. He is considered one of the founding pioneers of the New Hollywood era and one of the most popular directors and producers in film history.'),
(4, 'James', 'Cameron', 'Biografija Jamesa Camerona.'),
(5, 'Robert', 'Zemeckis', 'Biografija Roberta Zemeckisa.'),
(6, 'Frank', 'Darabont', 'Biografija Franka Darabonta.'),
(7, 'Christopher', 'Nolan', 'Biografija Christophera Nolana.'),
(8, 'Francis', 'Ford Coppola', 'Biografija Francisa Forda Coppole.'),
(10, 'Denis', 'Villeneuve', 'Denis Villeneuve je kanadski filmski reditelj i scenarista rođen 3. oktobra 1967. godine u Trois-Rivieresu, Quebec, Kanada. Villeneuve je stekao svetsku slavu svojim izuzetnim rediteljskim talentom, vizionarskim pristupom filmu i sposobnošću da istražuje složene teme kroz svoje radove.');

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `film_id` int(11) NOT NULL,
  `ime` text NOT NULL,
  `zanar` enum('DRAMA','HOROR','KOMEDIJA','AKCIJA','NAUCNA FANTASTIKA','AVANTURA','TRILER') NOT NULL,
  `godina_objavljivanja` year(4) NOT NULL,
  `trajanje` int(11) NOT NULL,
  `slika` text NOT NULL,
  `direktor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`film_id`, `ime`, `zanar`, `godina_objavljivanja`, `trajanje`, `slika`, `direktor_id`) VALUES
(9, 'Titanic', 'DRAMA', '1997', 195, 'https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_.jpg', 4),
(10, 'Forest Gump', 'DRAMA', '1994', 142, 'https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg', 5),
(11, 'The Shawshank Redemption', 'DRAMA', '1994', 142, 'https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg', 6),
(12, 'Inception', 'AVANTURA', '2010', 148, 'https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg', 7),
(13, 'The Godfather', 'DRAMA', '1972', 175, 'https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg', 8),
(14, 'The Dark Knight', 'AKCIJA', '2008', 152, 'https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg', 7),
(15, 'Interstellar', 'DRAMA', '2014', 169, 'https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg', 7),
(16, 'Dune: Part Two', 'AVANTURA', '2024', 166, 'https://m.media-amazon.com/images/M/MV5BN2QyZGU4ZDctOWMzMy00NTc5LThlOGQtODhmNDI1NmY5YzAwXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_FMjpg_UX1000_.jpg', 10);

-- --------------------------------------------------------

--
-- Table structure for table `glumac`
--

CREATE TABLE `glumac` (
  `glumac_id` int(11) NOT NULL,
  `ime` text NOT NULL,
  `prezime` text NOT NULL,
  `biografija` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `glumac`
--

INSERT INTO `glumac` (`glumac_id`, `ime`, `prezime`, `biografija`) VALUES
(4, 'Leonardo', 'DiCaprio', 'Leonardo Vilhelm DiKaprio je američki glumac, filmski producent i aktivista za zaštitu životne sredine. Rođen je 11. novembra 1974. godine u Los Anđelesu, Kalifornija. Počeo je svoju karijeru kao dečji glumac, a kasnije je postao jedan od najcenjenijih i najpoznatijih glumaca svog vremena. Osvojio je brojne nagrade, uključujući Oskara za najboljeg glumca za ulogu u filmu \"The Revenant\" iz 2015. godine. Pored svoje glumačke karijere, DiKaprio je poznat po svom aktivizmu za očuvanje životne sredine.'),
(5, 'Kate', 'Winslet', 'Kejt Elizabet Vinslet je engleska glumica, rođena 5. oktobra 1975. godine u Reading, Berkshire, Engleska. Postala je poznata po svojoj izuzetnoj glumačkoj sposobnosti i raznolikim ulogama u filmovima. Njen najpoznatiji film je \"Titanik\" iz 1997. godine, u kojem je igrala ulogu Rose DeWitt Bukater. Winslet je osvojila brojne nagrade, uključujući Oskara za najbolju glumicu za ulogu u filmu \"The Reader\" iz 2008. godine.'),
(6, 'Tom', 'Hanks', 'Tom Hanks je američki glumac i producent, rođen 9. jula 1956. godine u Concordu, Kalifornija. Počeo je svoju karijeru kao komičar, a kasnije je postao jedan od najcenjenijih glumaca Holivuda. Osvojio je dva Oskara za najboljeg glumca za svoje uloge u filmovima \"Philadelphia\" iz 1993. i \"Forrest Gump\" iz 1994. godine. Hanks je poznat po svom šarmu, talentu i raznovrsnim ulogama u filmovima.'),
(7, 'Robin', 'Wright', 'Robin Gejl Rajt je američka glumica i režiserka, rođena 8. aprila 1966. godine u Dalasu, Teksas. Postala je poznata po svojim izuzetnim glumačkim sposobnostima i raznolikim ulogama u filmovima i televizijskim serijama. Najpoznatija je po ulozi Claire Underwood u popularnoj televizijskoj seriji \"House of Cards\". Wright je takođe aktivna u humanitarnom radu i bavi se brojnim humanitarnim projektima širom sveta.'),
(8, 'Tim', 'Robbins', 'Timoti Frensis Robins je američki glumac, filmski stvaralac i muzičar. Rođen je 16. oktobra 1958. godine u Vest Konektikatu. Postao je poznat po svojim brojnim ulogama u filmovima kao što su \"The Shawshank Redemption\", \"Mystic River\" i \"Bull Durham\". Robins je osvojio Oskara za najboljeg sporednog glumca za svoju ulogu u filmu \"Mystic River\" iz 2003. godine.'),
(9, 'Morgan', 'Freeman', 'Morgan Friman je američki glumac, režiser i narator, rođen 1. juna 1937. godine u Memfisu, Tenesi. Postao je poznat po svojim izuzetnim glumačkim sposobnostima i impresivnoj karijeri koja traje više decenija. Osvojio je brojne nagrade, uključujući Oskara za najboljeg sporednog glumca za ulogu u filmu \"Million Dollar Baby\" iz 2004. godine.'),
(10, 'Marlon', 'Brando', 'Marlon Brando Jr. bio je američki glumac i filmski reditelj, rođen 3. aprila 1924. godine u Omaha, Nebraska. Smatran je jednim od najvećih glumaca svih vremena i bio je pionir metode glume. Osvojio je Oskara za najboljeg glumca za svoje uloge u filmovima \"On the Waterfront\" iz 1954. godine i \"The Godfather\" iz 1972. godine.'),
(11, 'Al', 'Pacino', 'Alfredo Džejms Pacino je američki glumac i režiser, rođen 25. aprila 1940. godine u Njujorku. Počeo je svoju karijeru na pozorišnim daskama, a kasnije je postao poznat po svojim ulogama u filmskim klasikama kao što su \"The Godfather\", \"Scarface\" i \"Scent of a Woman\". Osvojio je brojne nagrade, uključujući Oskara za najboljeg glumca.'),
(12, 'Christian', 'Bale', 'Kristijan Čarls Filips Bejl je britansko-australijski glumac, rođen 30. januara 1974. godine u Haverfordwestu, Velika Britanija. Postao je poznat po svojim transformacijskim ulogama u filmovima kao što su \"American Psycho\", \"The Machinist\" i \"The Dark Knight Trilogy\". Osvojio je Oskara za najboljeg sporednog glumca za ulogu u filmu \"The Fighter\" iz 2010. godine.'),
(13, 'Heath', 'Ledger', 'Hit Kler Edvard Ledžer bio je australijski glumac i reditelj, rođen 4. aprila 1979. godine u Pertu, Zapadna Australija. Postao je poznat po svojim izuzetnim glumačkim sposobnostima i svojim nezaboravnim ulogama u filmovima kao što su \"Brokeback Mountain\", \"The Dark Knight\" i \"Monster\'s Ball\". Ledger je posthumno osvojio Oskara za najboljeg sporednog glumca za svoju ulogu u filmu \"The Dark Knight\".'),
(14, 'Joseph', 'Gordon-Levitt', 'Džozef Leonard Gordon-Levit je američki glumac, filmski producent, reditelj i pevač, rođen 17. februara 1981. godine u Los Anđelesu, Kalifornija. Postao je poznat po svojim raznovrsnim ulogama u filmovima kao što su \"Inception\", \"500 Days of Summer\" i \"The Dark Knight Rises\". Gordon-Levit je takođe poznat po svom radu kao producent i'),
(15, 'Matthew', 'McConaughey', 'Matthew McConaughey je američki glumac i producent rođen 4. novembra 1969. godine u Uvaldeu, Teksas, SAD. McConaughey je postao poznat po svojim izuzetnim glumačkim veštinama, šarmu i raznolikosti uloga koje je odigrao tokom svoje karijere.'),
(16, 'Timothée', 'Chalamet', 'Timothée Chalamet je američki glumac rođen 27. decembra 1995. godine u New Yorku, SAD. Postao je jedan od najistaknutijih mladih glumaca svoje generacije zahvaljujući svom izvanrednom talentu, harizmi i svestranosti.'),
(17, 'Zendaya', 'Maree', 'Zendaya Maree Stoermer Coleman, poznatija pod umetničkim imenom Zendaya, američka je glumica, pevačica i model rođena 1. septembra 1996. godine u Oaklandu, Kalifornija, SAD. Odrasla je u umetnički nadahnutom okruženju, što je podstaklo njen rani interes za scenske umetnosti.');

-- --------------------------------------------------------

--
-- Table structure for table `glumac_film`
--

CREATE TABLE `glumac_film` (
  `glumac_film_id` int(11) NOT NULL,
  `glumac_id` int(11) NOT NULL,
  `film_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `glumac_film`
--

INSERT INTO `glumac_film` (`glumac_film_id`, `glumac_id`, `film_id`) VALUES
(10, 4, 9),
(11, 5, 9),
(12, 6, 10),
(13, 7, 10),
(14, 8, 11),
(15, 9, 11),
(16, 4, 12),
(17, 14, 12),
(18, 11, 13),
(19, 10, 13),
(20, 12, 14),
(21, 13, 14),
(22, 15, 15),
(23, 16, 16),
(24, 17, 16);

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `korisnik_id` int(11) NOT NULL,
  `ime` text NOT NULL,
  `email` text NOT NULL,
  `sifra` text NOT NULL,
  `admin` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`korisnik_id`, `ime`, `email`, `sifra`, `admin`) VALUES
(1, 'Marko ', 'marko.markovic@example.com', 'sifra123', 0),
(4, 'Admin', 'admin@gmail.com', 'admin', 1),
(5, 'Djordje', 'Djordje@gmail.com', 'djole123', 0);

-- --------------------------------------------------------

--
-- Table structure for table `lista_gledanja`
--

CREATE TABLE `lista_gledanja` (
  `lista_gledanja_id` int(11) NOT NULL,
  `korisnik_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lista_gledanja`
--

INSERT INTO `lista_gledanja` (`lista_gledanja_id`, `korisnik_id`) VALUES
(1, 1),
(2, 4),
(3, 5);

-- --------------------------------------------------------

--
-- Table structure for table `lista_gledanja_film`
--

CREATE TABLE `lista_gledanja_film` (
  `lista_gledanja_film_id` int(11) NOT NULL,
  `lista_gledanja_id` int(11) NOT NULL,
  `film_id` int(11) NOT NULL,
  `datum_dodavanja` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `recenzija`
--

CREATE TABLE `recenzija` (
  `recenzija_id` int(11) NOT NULL,
  `film_id` int(11) NOT NULL,
  `korisnik_id` int(11) NOT NULL,
  `tekst` text NOT NULL,
  `ocena` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `recenzija`
--

INSERT INTO `recenzija` (`recenzija_id`, `film_id`, `korisnik_id`, `tekst`, `ocena`) VALUES
(16, 9, 1, 'sdadasd', 8),
(20, 11, 4, 'asdas', 5),
(21, 16, 1, 'sadasdas', 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `direktor`
--
ALTER TABLE `direktor`
  ADD PRIMARY KEY (`direktor_id`);

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`film_id`),
  ADD KEY `direktor_id` (`direktor_id`);

--
-- Indexes for table `glumac`
--
ALTER TABLE `glumac`
  ADD PRIMARY KEY (`glumac_id`);

--
-- Indexes for table `glumac_film`
--
ALTER TABLE `glumac_film`
  ADD PRIMARY KEY (`glumac_film_id`),
  ADD KEY `glumac_id` (`glumac_id`),
  ADD KEY `film_id` (`film_id`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`korisnik_id`);

--
-- Indexes for table `lista_gledanja`
--
ALTER TABLE `lista_gledanja`
  ADD PRIMARY KEY (`lista_gledanja_id`),
  ADD KEY `korisnik_id` (`korisnik_id`);

--
-- Indexes for table `lista_gledanja_film`
--
ALTER TABLE `lista_gledanja_film`
  ADD PRIMARY KEY (`lista_gledanja_film_id`),
  ADD UNIQUE KEY `lista_gledanja_duplikati` (`lista_gledanja_id`,`film_id`),
  ADD KEY `lista_gledanja_id` (`lista_gledanja_id`),
  ADD KEY `film_id` (`film_id`);

--
-- Indexes for table `recenzija`
--
ALTER TABLE `recenzija`
  ADD PRIMARY KEY (`recenzija_id`),
  ADD UNIQUE KEY `recenzije_duplikat` (`film_id`,`korisnik_id`),
  ADD KEY `film_id` (`film_id`),
  ADD KEY `korisnik_id` (`korisnik_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `direktor`
--
ALTER TABLE `direktor`
  MODIFY `direktor_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `film_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `glumac`
--
ALTER TABLE `glumac`
  MODIFY `glumac_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `glumac_film`
--
ALTER TABLE `glumac_film`
  MODIFY `glumac_film_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `korisnik_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `lista_gledanja`
--
ALTER TABLE `lista_gledanja`
  MODIFY `lista_gledanja_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `lista_gledanja_film`
--
ALTER TABLE `lista_gledanja_film`
  MODIFY `lista_gledanja_film_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `recenzija`
--
ALTER TABLE `recenzija`
  MODIFY `recenzija_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `film_ibfk_1` FOREIGN KEY (`direktor_id`) REFERENCES `direktor` (`direktor_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `glumac_film`
--
ALTER TABLE `glumac_film`
  ADD CONSTRAINT `glumac_film_ibfk_1` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `glumac_film_ibfk_2` FOREIGN KEY (`glumac_id`) REFERENCES `glumac` (`glumac_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `lista_gledanja`
--
ALTER TABLE `lista_gledanja`
  ADD CONSTRAINT `lista_gledanja_ibfk_1` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`korisnik_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `lista_gledanja_film`
--
ALTER TABLE `lista_gledanja_film`
  ADD CONSTRAINT `lista_gledanja_film_ibfk_1` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `lista_gledanja_film_ibfk_2` FOREIGN KEY (`lista_gledanja_id`) REFERENCES `lista_gledanja` (`lista_gledanja_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `recenzija`
--
ALTER TABLE `recenzija`
  ADD CONSTRAINT `recenzija_ibfk_1` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `recenzija_ibfk_2` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`korisnik_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

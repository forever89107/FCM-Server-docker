-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- 主機： localhost:8889
-- 產生時間： 2022 年 02 月 17 日 12:25
-- 伺服器版本： 5.7.34
-- PHP 版本： 7.4.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫: `demo`
--

-- --------------------------------------------------------

--
-- 資料表結構 `player`
--
ce
DROP TABLE IF EXISTS `player`;
CREATE TABLE IF NOT EXISTS `player` (
  `id` varchar(20) NOT NULL,
  `player_name` varchar(10) NOT NULL COMMENT '玩家暱稱',
  `job` varchar(10) NOT NULL DEFAULT '初心者' COMMENT '職業',
  `level` int(3) NOT NULL DEFAULT '1' COMMENT '等級',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 資料表新增資料前，先清除舊資料 `player`
--

TRUNCATE TABLE `player`;
--
-- 傾印資料表的資料 `player`
--

INSERT INTO `player` (`id`, `player_name`, `job`, `level`) VALUES
('A0001', '鎚鎚大師', '初心者', 10),
('A0002', '微米刺客', '刺客', 52),
('A0003', '甜蜜貓咪咪', '祭司', 27),
('A0004', '軟綿綿啾啾', '聖騎士', 35),
('A0005', '一品帶刀Lovely', '狂戰士', 73);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

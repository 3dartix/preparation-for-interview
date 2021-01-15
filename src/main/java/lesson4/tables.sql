CREATE TABLE `film_table` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `timing` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `seance_table` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `cost` int unsigned NOT NULL,
--  number_seats - количество мест в зале
  `number_seats` int unsigned NOT NULL,
  `film_id` int unsigned NOT NULL,
  `time_start` time NOT NULL,
  PRIMARY KEY (`id`,`date`,`film_id`,`time_start`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `show_date_UNIQUE` (`date`,`film_id`,`time_start`),
  KEY `fk_seance_filmID_idx` (`film_id`),
  CONSTRAINT `fk_seance_filmID` FOREIGN KEY (`film_id`) REFERENCES `film_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `ticket_table` (
  `number` int unsigned NOT NULL,
--   unique_user_id - условный уникальный номер пользователь (qr код например)
  `unique_user_id` varchar(45) NOT NULL,
  `seance_id` int unsigned NOT NULL,
  PRIMARY KEY (`unique_user_id`),
  UNIQUE KEY `unique_user_id_UNIQUE` (`unique_user_id`),
  UNIQUE KEY `seance_id_UNIQUE` (`seance_id`,`number`),
  CONSTRAINT `fk_ticket_seance` FOREIGN KEY (`seance_id`) REFERENCES `seance_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

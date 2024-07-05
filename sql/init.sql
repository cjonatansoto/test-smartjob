DROP DATABASE IF EXISTS `tests`;
CREATE DATABASE IF NOT EXISTS `tests`;
USE `tests`;

CREATE TABLE IF NOT EXISTS `users` (
                                       `id` binary(16) NOT NULL,
    `created` datetime(6) DEFAULT NULL,
    `email` varchar(255) NOT NULL,
    `is_active` tinyint(1) DEFAULT '1',
    `last_login` datetime(6) DEFAULT NULL,
    `modified` datetime(6) DEFAULT NULL,
    `name` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `phones` (
                                        `id` binary(16) NOT NULL,
    `city_code` int DEFAULT NULL,
    `contry_code` int DEFAULT NULL,
    `number` int DEFAULT NULL,
    `user_id` binary(16) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKmg6d77tgqfen7n1g763nvsqe3` (`user_id`),
    CONSTRAINT `FKmg6d77tgqfen7n1g763nvsqe3` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
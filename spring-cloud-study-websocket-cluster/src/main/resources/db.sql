CREATE TABLE `ws_message` (
  `id` varchar(100) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'UUID()',
  `from_user_id` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `to_user_id` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `message` text COLLATE utf8mb4_general_ci,
  `status` tinyint(1) DEFAULT '0',
  `site_id` varchar(50) COLLATE utf8mb4_general_ci DEFAULT '0',
  `read_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `ws_site` (
  `site_id` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`site_id`,`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
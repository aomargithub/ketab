CREATE TABLE `confidentiality_degree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(200) NOT NULL,
  `description` varchar(200) NOT NULL,
  `create_by` varchar(200) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`),
  UNIQUE KEY `description_UNIQUE` (`description`)
)  ;
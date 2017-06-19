CREATE TABLE `confidentiality_degree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(200) NOT NULL,
  `description` varchar(200) NOT NULL,
  `create_by` varchar(200) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL,
  `precedence` int(11) NOT NULL,
  `orm_version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `confidentiality_degree_code_UNIQUE` (`code`),
  UNIQUE KEY `confidentiality_degree_description_UNIQUE` (`description`)
) ;


CREATE TABLE `notification_channel` (
  `id` tinyint(1) NOT NULL AUTO_INCREMENT,
  `code` varchar(200) NOT NULL,
  `description` varchar(200) NOT NULL,
  `create_by` varchar(200) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL,
  `orm_version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `notification_channel_code_UNIQUE` (`code`)
);


CREATE TABLE `theme` (
  `id` smallint(3) NOT NULL AUTO_INCREMENT,
  `code` varchar(200) NOT NULL,
  `create_by` varchar(200) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_by` varchar(45) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL,
  `description` varchar(200) NOT NULL,
  `orm_version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `theme_code_UNIQUE` (`code`)
)  ;
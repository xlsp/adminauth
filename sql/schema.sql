-- admin_auth.`role` definition

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Role ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_un` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- admin_auth.`user` definition

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Admin ID',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'User name',
  `password` varchar(100) NOT NULL COMMENT 'Password encrypted by bcrypt',
  `enabled` int(11) NOT NULL DEFAULT '0' COMMENT 'Is user enabled',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT 'Is user deleted',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- admin_auth.url_resource definition

CREATE TABLE `url_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `regex` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- admin_auth.user_role definition

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL COMMENT 'admin user id',
  `role_id` int(11) NOT NULL COMMENT 'role id',
  KEY `user_role_FK` (`user_id`),
  KEY `user_role_FK_1` (`role_id`),
  CONSTRAINT `user_role_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `user_role_FK_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- admin_auth.role_url_resource definition

CREATE TABLE `role_url_resource` (
  `role_id` int(11) NOT NULL,
  `url_resource_id` int(11) NOT NULL,
  KEY `role_url_resource_FK` (`role_id`),
  KEY `role_url_resource_FK_1` (`url_resource_id`),
  CONSTRAINT `role_url_resource_FK` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `role_url_resource_FK_1` FOREIGN KEY (`url_resource_id`) REFERENCES `url_resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
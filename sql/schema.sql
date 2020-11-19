-- admin_auth.`role` definition

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Role ID',
  `role_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- admin_auth.`user` definition

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Admin ID',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'User name',
  `password` varchar(100) NOT NULL COMMENT 'Password encrypted by bcrypt',
  `enabled` int(11) NOT NULL DEFAULT '0' COMMENT 'Is user enabled',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT 'Is user deleted',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- admin_auth.user_role definition

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL COMMENT 'admin user id',
  `role_ie` int(11) NOT NULL COMMENT 'role id',
  KEY `user_role_FK` (`user_id`),
  KEY `user_role_FK_1` (`role_ie`),
  CONSTRAINT `user_role_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `user_role_FK_1` FOREIGN KEY (`role_ie`) REFERENCES `role` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
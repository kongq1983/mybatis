CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `location` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '地标 100,200',
  PRIMARY KEY (`id`)
);


CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `address` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;


INSERT INTO `account` VALUES ('1', 'admin', '18', 'king', '100,200');
INSERT INTO `account` VALUES ('2', 'user', '18', 'user', '201,500');
INSERT INTO `account` VALUES ('3', 'guest', '18', 'guest', null);
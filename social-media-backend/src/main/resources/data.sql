SET FOREIGN_KEY_CHECKS=OFF;
DELETE FROM `roles`;
INSERT INTO `roles` (`id`, `name`) VALUES ('1', 'ROLE_USER');

CREATE TABLE IF NOT EXISTS locations (id int, location varchar(255));
DELETE FROM `locations`;
INSERT INTO `locations` (`id`, `location`) VALUES ('1', 'Sylhet');
INSERT INTO `locations` (`id`, `location`) VALUES ('2', 'Bandarban');
INSERT INTO `locations` (`id`, `location`) VALUES ('3', 'Khulna');


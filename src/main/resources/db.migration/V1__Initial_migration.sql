-- Create tables

CREATE TABLE IF NOT EXISTS `map` (
  `id`   bigint(20)  NOT NULL AUTO_INCREMENT,
  `name` varchar(63) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `floor` (
  `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
  `map_id`      bigint(20)   NOT NULL,
  `number`      bigint(11)   NOT NULL,
  `picture_url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`map_id`) REFERENCES map (id)
);

CREATE TABLE IF NOT EXISTS `map_object` (
  `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
  `map_id`      bigint(20)   NOT NULL,
  `floor_id`    bigint(20)   NOT NULL,
  `x`           bigint(20)   NOT NULL,
  `y`           bigint(20)   NOT NULL,
  `type`        varchar(15)  NOT NULL,
  `name`        varchar(63)  NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`map_id`) REFERENCES map (id),
  FOREIGN KEY (`floor_id`) REFERENCES floor (id)
);

CREATE TABLE IF NOT EXISTS `comment` (
  `id`       bigint(20)    NOT NULL AUTO_INCREMENT,
  `map_id`   bigint(20)    NOT NULL,
  `floor_id` bigint(20)    NOT NULL,
  `x`        bigint(20)    NOT NULL,
  `y`        bigint(20)    NOT NULL,
  `created`  datetime      NOT NULL,
  `type`     varchar(15)   NOT NULL,
  `name`     varchar(63)   NOT NULL,
  `text`     varchar(1023) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`map_id`) REFERENCES map (id),
  FOREIGN KEY (`floor_id`) REFERENCES floor (id)
);
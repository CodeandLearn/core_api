-- -----------------------------------------------------
-- Code and Learn MySQL script by Teddy Fontaine (Sheol)
-- -----------------------------------------------------
SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `code_and_learn`
  DEFAULT CHARACTER SET utf8;
USE `code_and_learn`;

DROP TABLE IF EXISTS `code_and_learn`.`groups`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`groups` (
  `id`        INT         NOT NULL AUTO_INCREMENT,
  `name`      VARCHAR(45) NULL,
  `parent_id` INT         NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`avatars`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`avatars` (
  `id`   INT          NOT NULL AUTO_INCREMENT,
  `path` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`accounts`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`accounts` (
  `id`                     INT          NOT NULL AUTO_INCREMENT,
  `username`               VARCHAR(45)  NULL,
  `password`               VARCHAR(255) NULL,
  `email`                  VARCHAR(100) NULL,
  `group_id`               INT          NULL,
  `avatar_id`              INT          NULL,
  `create_timestamp`       LONG         NULL,
  `last_connect_timestamp` LONG         NULL,
  `nb_courses_done`        INT          NULL     DEFAULT 0,
  `nb_exercices_done`      INT          NULL     DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `group_id_idx` (`group_id` ASC),
  INDEX `avatar_id_idx` (`avatar_id` ASC),
  CONSTRAINT `group_id`
  FOREIGN KEY (`group_id`)
  REFERENCES `code_and_learn`.`groups` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `avatar_id`
  FOREIGN KEY (`avatar_id`)
  REFERENCES `code_and_learn`.`avatars` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`locales`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`locales` (
  `id`   INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45)  NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`languages`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`languages` (
  `id`   INT         NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`courses`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`courses` (
  `id`               INT         NOT NULL AUTO_INCREMENT,
  `account_id`       INT         NULL,
  `locales_id`       INT         NULL,
  `language_id`      INT         NULL,
  `title`            VARCHAR(45) NULL,
  `content`          TEXT        NULL,
  `create_timestamp` LONG        NULL,
  `modify_timestamp` LONG        NULL,
  PRIMARY KEY (`id`),
  INDEX `account_id_idx` (`account_id` ASC),
  INDEX `locales_id_idx` (`locales_id` ASC),
  INDEX `language_id_idx` (`language_id` ASC),
  CONSTRAINT `account_id`
  FOREIGN KEY (`account_id`)
  REFERENCES `code_and_learn`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `locales_id`
  FOREIGN KEY (`locales_id`)
  REFERENCES `code_and_learn`.`locales` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `language_id`
  FOREIGN KEY (`language_id`)
  REFERENCES `code_and_learn`.`languages` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`exercices`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`exercices` (
  `id`          INT          NOT NULL AUTO_INCREMENT,
  `account_id`  INT          NOT NULL,
  `course_id`   INT          NOT NULL,
  `title`       VARCHAR(250) NULL,
  `instruction` TEXT         NULL,
  `grade_max`   INT          NULL,
  PRIMARY KEY (`id`),
  INDEX `account_id_idx` (`account_id` ASC),
  INDEX `course_id_idx` (`course_id` ASC),
  CONSTRAINT `account_id`
  FOREIGN KEY (`account_id`)
  REFERENCES `code_and_learn`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `course_id`
  FOREIGN KEY (`course_id`)
  REFERENCES `code_and_learn`.`courses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`user_exercises`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`user_exercises` (
  `id`          INT NOT NULL AUTO_INCREMENT,
  `account_id`  INT NULL,
  `exercice_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `account_id_idx` (`account_id` ASC),
  INDEX `exercice_id_idx` (`exercice_id` ASC),
  CONSTRAINT `account_id`
  FOREIGN KEY (`account_id`)
  REFERENCES `code_and_learn`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `exercice_id`
  FOREIGN KEY (`exercice_id`)
  REFERENCES `code_and_learn`.`exercices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`grades`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`grades` (
  `id`               INT  NOT NULL AUTO_INCREMENT,
  `user_exercice_id` INT  NOT NULL,
  `value`            INT  NULL,
  `LONG`             LONG NULL,
  PRIMARY KEY (`id`),
  INDEX `user_exercice_id_idx` (`user_exercice_id` ASC),
  CONSTRAINT `user_exercice_id`
  FOREIGN KEY (`user_exercice_id`)
  REFERENCES `code_and_learn`.`user_exercises` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`exercices_comments`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`exercices_comments` (
  `id`               INT  NOT NULL AUTO_INCREMENT,
  `exercice_id`      INT  NOT NULL,
  `account_id`       INT  NOT NULL,
  `content`          TEXT NULL,
  `create_timestamp` LONG NULL,
  `modify_timestamp` LONG NULL,
  PRIMARY KEY (`id`),
  INDEX `exercice_id_idx` (`exercice_id` ASC),
  INDEX `account_id_idx` (`account_id` ASC),
  CONSTRAINT `exercice_id`
  FOREIGN KEY (`exercice_id`)
  REFERENCES `code_and_learn`.`exercices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `account_id`
  FOREIGN KEY (`account_id`)
  REFERENCES `code_and_learn`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`logs`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`logs` (
  `id`               INT  NOT NULL AUTO_INCREMENT,
  `user_exercice_id` INT  NOT NULL,
  `content`          TEXT NULL,
  `LONG`             LONG NULL,
  PRIMARY KEY (`id`),
  INDEX `user_exercice_id_idx` (`user_exercice_id` ASC),
  CONSTRAINT `user_exercice_id`
  FOREIGN KEY (`user_exercice_id`)
  REFERENCES `code_and_learn`.`user_exercises` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`scripts`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`scripts` (
  `id`               INT  NOT NULL AUTO_INCREMENT,
  `exercice_id`      INT  NOT NULL,
  `content`          TEXT NULL,
  `create_timestamp` LONG NULL,
  `modify_timestamp` LONG NULL,
  PRIMARY KEY (`id`),
  INDEX `exercice_id_idx` (`exercice_id` ASC),
  CONSTRAINT `exercice_id`
  FOREIGN KEY (`exercice_id`)
  REFERENCES `code_and_learn`.`exercices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`codes`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`codes` (
  `id`               INT         NOT NULL AUTO_INCREMENT,
  `user_exercice_id` INT         NOT NULL,
  `name`             VARCHAR(75) NULL,
  `content`          TEXT        NULL,
  `create_timestamp` LONG        NULL,
  `modify_timestamp` LONG        NULL,
  PRIMARY KEY (`id`),
  INDEX `user_exercice_id_idx` (`user_exercice_id` ASC),
  CONSTRAINT `user_exercice_id`
  FOREIGN KEY (`user_exercice_id`)
  REFERENCES `code_and_learn`.`user_exercises` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`exercices_corrections`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`exercices_corrections` (
  `id`          INT  NOT NULL AUTO_INCREMENT,
  `exercice_id` INT  NOT NULL,
  `content`     TEXT NULL,
  `LONG`        LONG NULL,
  PRIMARY KEY (`id`),
  INDEX `exercice_id_idx` (`exercice_id` ASC),
  CONSTRAINT `exercice_id`
  FOREIGN KEY (`exercice_id`)
  REFERENCES `code_and_learn`.`exercices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`courses_comments`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`courses_comments` (
  `id`               INT  NOT NULL AUTO_INCREMENT,
  `course_id`        INT  NULL,
  `account_id`       INT  NULL,
  `content`          TEXT NULL,
  `create_timestamp` LONG NULL,
  `modify_timestamp` LONG NULL,
  PRIMARY KEY (`id`),
  INDEX `course_id_idx` (`course_id` ASC),
  INDEX `account_id_idx` (`account_id` ASC),
  CONSTRAINT `course_id`
  FOREIGN KEY (`course_id`)
  REFERENCES `code_and_learn`.`courses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `account_id`
  FOREIGN KEY (`account_id`)
  REFERENCES `code_and_learn`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`blog_posts_category`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`blog_posts_category` (
  `id`   INT         NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`blog_posts`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`blog_posts` (
  `id`               INT         NOT NULL AUTO_INCREMENT,
  `account_id`       INT         NULL,
  `locales_id`       INT         NULL,
  `blog_category_id` INT         NULL,
  `title`            VARCHAR(45) NULL,
  `content`          TEXT        NULL,
  `create_timestamp` LONG        NULL,
  `modify_timestamp` LONG        NULL,
  PRIMARY KEY (`id`),
  INDEX `account_d_idx` (`account_id` ASC),
  INDEX `locales_id_idx` (`locales_id` ASC),
  INDEX `blog_category_id_idx` (`blog_category_id` ASC),
  CONSTRAINT `account_id`
  FOREIGN KEY (`account_id`)
  REFERENCES `code_and_learn`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `locales_id`
  FOREIGN KEY (`locales_id`)
  REFERENCES `code_and_learn`.`locales` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `blog_category_id`
  FOREIGN KEY (`blog_category_id`)
  REFERENCES `code_and_learn`.`blog_posts_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`blog_posts_comments`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`blog_posts_comments` (
  `id`               INT  NOT NULL AUTO_INCREMENT,
  `account_id`       INT  NULL,
  `blog_post_id`     INT  NULL,
  `content`          TEXT NULL,
  `create_timestamp` LONG NULL,
  `modify_timestamp` LONG NULL,
  PRIMARY KEY (`id`),
  INDEX `account_id_idx` (`account_id` ASC),
  INDEX `blog_post_id_idx` (`blog_post_id` ASC),
  CONSTRAINT `account_id`
  FOREIGN KEY (`account_id`)
  REFERENCES `code_and_learn`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `blog_post_id`
  FOREIGN KEY (`blog_post_id`)
  REFERENCES `code_and_learn`.`blog_posts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`forum_category`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`forum_category` (
  `id`   INT         NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`forum_forums`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`forum_forums` (
  `id`                 INT         NOT NULL AUTO_INCREMENT,
  `forums_category_id` INT         NULL,
  `name`               VARCHAR(45) NULL,
  `description`        TEXT        NULL,
  PRIMARY KEY (`id`),
  INDEX `forums_category_id_idx` (`forums_category_id` ASC),
  CONSTRAINT `forums_category_id`
  FOREIGN KEY (`forums_category_id`)
  REFERENCES `code_and_learn`.`forum_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`forum_subjects`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`forum_subjects` (
  `id`              INT  NOT NULL AUTO_INCREMENT,
  `forums_forum_id` INT  NULL,
  `locales_id`      INT  NULL,
  `account_id`      INT  NULL,
  `LONG`            LONG NULL,
  `replies`         INT  NULL,
  `views`           INT  NULL,
  PRIMARY KEY (`id`),
  INDEX `forums_forum_id_idx` (`forums_forum_id` ASC),
  INDEX `locales_id_idx` (`locales_id` ASC),
  INDEX `account_id_idx` (`account_id` ASC),
  CONSTRAINT `forums_forum_id`
  FOREIGN KEY (`forums_forum_id`)
  REFERENCES `code_and_learn`.`forum_forums` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `locales_id`
  FOREIGN KEY (`locales_id`)
  REFERENCES `code_and_learn`.`locales` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `account_id`
  FOREIGN KEY (`account_id`)
  REFERENCES `code_and_learn`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`forum_posts`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`forum_posts` (
  `id`                INT  NOT NULL AUTO_INCREMENT,
  `forums_subject_id` INT  NULL,
  `account_id`        INT  NULL,
  `create_timestamp`  LONG NULL,
  `modify_timestamp`  LONG NULL,
  `content`           TEXT NULL,
  `likes`             INT  NULL,
  PRIMARY KEY (`id`),
  INDEX `forums_subject_id_idx` (`forums_subject_id` ASC),
  INDEX `account_id_idx` (`account_id` ASC),
  CONSTRAINT `forums_subject_id`
  FOREIGN KEY (`forums_subject_id`)
  REFERENCES `code_and_learn`.`forum_subjects` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `account_id`
  FOREIGN KEY (`account_id`)
  REFERENCES `code_and_learn`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`tokens`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`tokens` (
  `account_id` INT          NOT NULL,
  `token`      VARCHAR(255) NULL,
  `ttl`        INT          NULL,
  PRIMARY KEY (`account_id`),
  CONSTRAINT `account_id`
  FOREIGN KEY (`account_id`)
  REFERENCES `code_and_learn`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`badges`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`badges` (
  `id`                INT          NOT NULL AUTO_INCREMENT,
  `name`              VARCHAR(45)  NULL,
  `path_img`          VARCHAR(255) NULL,
  `nb_courses_done`   INT          NULL,
  `nb_exercices_done` INT          NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`users_badges`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`users_badges` (
  `account_id` INT  NOT NULL,
  `badge_id`   INT  NULL,
  `LONG`       LONG NULL,
  PRIMARY KEY (`account_id`),
  INDEX `badge_id_idx` (`badge_id` ASC),
  CONSTRAINT `account_id`
  FOREIGN KEY (`account_id`)
  REFERENCES `code_and_learn`.`accounts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `badge_id`
  FOREIGN KEY (`badge_id`)
  REFERENCES `code_and_learn`.`badges` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`moderation_validate`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`moderation_validate` (
  `id`   INT         NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`exercices_moderation`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`exercices_moderation` (
  `exercice_id`            INT  NOT NULL,
  `moderation_validate_id` INT  NULL,
  `commentary`             TEXT NULL,
  PRIMARY KEY (`exercice_id`),
  INDEX `moderation_validate_id_idx` (`moderation_validate_id` ASC),
  CONSTRAINT `exercice_id`
  FOREIGN KEY (`exercice_id`)
  REFERENCES `code_and_learn`.`exercices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `moderation_validate_id`
  FOREIGN KEY (`moderation_validate_id`)
  REFERENCES `code_and_learn`.`moderation_validate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

DROP TABLE IF EXISTS `code_and_learn`.`course_moderation`;

CREATE TABLE IF NOT EXISTS `code_and_learn`.`course_moderation` (
  `course_id`              INT  NOT NULL,
  `moderation_validate_id` INT  NULL,
  `commentary`             TEXT NULL,
  PRIMARY KEY (`course_id`),
  INDEX `moderation_validate_id_idx` (`moderation_validate_id` ASC),
  CONSTRAINT `course_id`
  FOREIGN KEY (`course_id`)
  REFERENCES `code_and_learn`.`courses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `moderation_validate_id`
  FOREIGN KEY (`moderation_validate_id`)
  REFERENCES `code_and_learn`.`moderation_validate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Set base record
-- -----------------------------------------------------
INSERT INTO avatars (path)
VALUES ("http%3A%2F%2Fwww.freakingnews.com%2Fpictures%2F97500%2FKorean-Elephant-Rocket--97543.jpg");
INSERT INTO groups (name, parent_id) VALUES ("member", 10);
INSERT INTO groups (name, parent_id) VALUES ("administrator", 50);
INSERT INTO groups (name, parent_id) VALUES ("moderator", 30);
INSERT INTO locales (name) VALUES ("FR");
INSERT INTO locales (name) VALUES ("EN");

-- -----------------------------------------------------
-- Set default values
-- -----------------------------------------------------
INSERT INTO accounts (username, password, email, group_id, avatar_id, create_timestamp, last_connect_timestamp, nb_courses_done, nb_exercices_done)
VALUES
  ("Admin", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", "admin%40codeandlear.com", 2, 1, 1464262190085, 1464262190085,
   0, 0);
INSERT INTO blog_posts_category (name) VALUES ("Default");
INSERT INTO languages (name) VALUES ("C%2B%2B");
INSERT INTO languages (name) VALUES ("JAVA");
INSERT INTO languages (name) VALUES ("C");
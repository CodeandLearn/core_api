-- -----------------------------------------------------
-- Code and Learn MySQL script by Teddy Fontaine (Sheol)
-- -----------------------------------------------------
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Table `exercises`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exercises` ;

CREATE TABLE IF NOT EXISTS `exercises` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  `title` VARCHAR(250) NULL,
  `instruction` TEXT NULL,
  `grade_max` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `grades` ;

CREATE TABLE IF NOT EXISTS `grades` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_exercise_id` INT NOT NULL,
  `value` INT NULL,
  `timestamp` LONG NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exercises_comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exercises_comments` ;

CREATE TABLE IF NOT EXISTS `exercises_comments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `exercise_id` INT NOT NULL,
  `account_id` INT NOT NULL,
  `content` TEXT NULL,
  `create_timestamp` LONG NULL,
  `modify_timestamp` LONG NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `logs` ;

CREATE TABLE IF NOT EXISTS `logs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_exercise_id` INT NOT NULL,
  `content` TEXT NULL,
  `timestamp` LONG NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `scripts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `scripts` ;

CREATE TABLE IF NOT EXISTS `scripts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `exercise_id` INT NOT NULL,
  `content` TEXT NULL,
  `create_timestamp` LONG NULL,
  `modify_timestamp` LONG NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `codes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `codes` ;

CREATE TABLE IF NOT EXISTS `codes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_exercise_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `create_timestamp` LONG NULL,
  `modify_timestamp` LONG NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_exercises`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_exercises` ;

CREATE TABLE IF NOT EXISTS `user_exercises` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NULL,
  `exercise_id` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exercises_corrections`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exercises_corrections` ;

CREATE TABLE IF NOT EXISTS `exercises_corrections` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `exercise_id` INT NOT NULL,
  `content` TEXT NULL,
  `timestamp` LONG NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `accounts` ;

CREATE TABLE IF NOT EXISTS `accounts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(255) NULL,
  `email` VARCHAR(100) NULL,
  `group_id` INT NULL,
  `avatar_id` INT NULL,
  `create_timestamp` LONG NULL,
  `last_connect_timestamp` LONG NULL,
  `nb_courses_done` INT NULL DEFAULT 0,
  `nb_exercises_done` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `groups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `groups` ;

CREATE TABLE IF NOT EXISTS `groups` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `parent_id` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `courses` ;

CREATE TABLE IF NOT EXISTS `courses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NULL,
  `locales_id` INT NULL,
  `language_id` INT NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `create_timestamp` LONG NULL,
  `modify_timestamp` LONG NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `languages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `languages` ;

CREATE TABLE IF NOT EXISTS `languages` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `locales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `locales` ;

CREATE TABLE IF NOT EXISTS `locales` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `courses_comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `courses_comments` ;

CREATE TABLE IF NOT EXISTS `courses_comments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `course_id` INT NULL,
  `account_id` INT NULL,
  `content` TEXT NULL,
  `create_timestamp` LONG NULL,
  `modify_timestamp` LONG NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_posts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_posts` ;

CREATE TABLE IF NOT EXISTS `blog_posts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NULL,
  `locales_id` INT NULL,
  `blog_category_id` INT NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `create_timestamp` LONG NULL,
  `modify_timestamp` LONG NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_posts_comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_posts_comments` ;

CREATE TABLE IF NOT EXISTS `blog_posts_comments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NULL,
  `blog_post_id` INT NULL,
  `content` TEXT NULL,
  `create_timestamp` LONG NULL,
  `modify_timestamp` LONG NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_posts_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_posts_category` ;

CREATE TABLE IF NOT EXISTS `blog_posts_category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `forum_subjects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `forum_subjects` ;

CREATE TABLE IF NOT EXISTS `forum_subjects` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NULL,
  `account_id` INT NULL,
  `create_at` LONG NULL,
  `last_updated` LONG NULL,
  `last_account_id` INT NULL,
  `forum_subcategory_id` INT NULL,
  `likes` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `forum_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `forum_category` ;

CREATE TABLE IF NOT EXISTS `forum_category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(250) NULL,
  `last_updated` LONG NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `forum_subcategories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `forum_subcategories` ;

CREATE TABLE IF NOT EXISTS `forum_subcategories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `forum_category_id` INT NULL,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(250) NULL,
  `last_updated` LONG NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `forum_posts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `forum_posts` ;

CREATE TABLE IF NOT EXISTS `forum_posts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NULL,
  `forum_subject_id` INT NULL,
  `content` TEXT NULL,
  `created_at` LONG NULL,
  `last_updated` LONG NULL,
  `likes` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `avatars`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `avatars` ;

CREATE TABLE IF NOT EXISTS `avatars` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `path` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `users_badges`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users_badges` ;

CREATE TABLE IF NOT EXISTS `users_badges` (
  `account_id` INT NOT NULL,
  `badge_id` INT NULL,
  `timestamp` LONG NULL,
  PRIMARY KEY (`account_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `badges`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `badges` ;

CREATE TABLE IF NOT EXISTS `badges` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `path_img` VARCHAR(255) NULL,
  `nb_courses_done` INT NULL,
  `nb_exercises_done` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exercises_moderation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exercises_moderation` ;

CREATE TABLE IF NOT EXISTS `exercises_moderation` (
  `exercise_id` INT NOT NULL,
  `validate` INT NULL,
  `commentary` TEXT NULL,
  PRIMARY KEY (`exercise_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `course_moderation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `course_moderation` ;

CREATE TABLE IF NOT EXISTS `course_moderation` (
  `course_id` INT NOT NULL,
  `validate` INT NULL,
  `commentary` TEXT NULL,
  PRIMARY KEY (`course_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `code_templates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `code_templates` ;

CREATE TABLE IF NOT EXISTS `code_templates` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `exercise_id` INT NOT NULL,
  `file_name` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

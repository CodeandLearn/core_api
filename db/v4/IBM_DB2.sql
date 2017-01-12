-- -----------------------------------------------------
-- Code and Learn MySQL script by Teddy Fontaine (Sheol)
-- -----------------------------------------------------
/* SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0; */
/* SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0; */
/* SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES'; */

-- -----------------------------------------------------
-- Table `exercises`
-- -----------------------------------------------------
DROP TABLE IF EXISTS exercises ;

CREATE TABLE IF NOT EXISTS exercises (
  id INT NOT NULL AUTO_INCREMENT,
  account_id INT NOT NULL,
  course_id INT NOT NULL,
  title VARCHAR(250) NULL,
  instruction CLOB NULL,
  grade_max INT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `grades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS grades ;

CREATE TABLE IF NOT EXISTS grades (
  id INT NOT NULL AUTO_INCREMENT,
  user_exercise_id INT NOT NULL,
  value INT NULL,
  timestamp LONG NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `exercises_comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS exercises_comments ;

CREATE TABLE IF NOT EXISTS exercises_comments (
  id INT NOT NULL AUTO_INCREMENT,
  exercise_id INT NOT NULL,
  account_id INT NOT NULL,
  content CLOB NULL,
  create_timestamp LONG NULL,
  modify_timestamp LONG NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS logs ;

CREATE TABLE IF NOT EXISTS logs (
  id INT NOT NULL AUTO_INCREMENT,
  user_exercise_id INT NOT NULL,
  content CLOB NULL,
  timestamp LONG NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `scripts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS scripts ;

CREATE TABLE IF NOT EXISTS scripts (
  id INT NOT NULL AUTO_INCREMENT,
  exercise_id INT NOT NULL,
  content CLOB NULL,
  create_timestamp LONG NULL,
  modify_timestamp LONG NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `codes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS codes ;

CREATE TABLE IF NOT EXISTS codes (
  id INT NOT NULL AUTO_INCREMENT,
  user_exercise_id INT NOT NULL,
  name VARCHAR(45) NULL,
  content CLOB NULL,
  create_timestamp LONG NULL,
  modify_timestamp LONG NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `user_exercises`
-- -----------------------------------------------------
DROP TABLE IF EXISTS user_exercises ;

CREATE TABLE IF NOT EXISTS user_exercises (
  id INT NOT NULL AUTO_INCREMENT,
  account_id INT NULL,
  exercise_id INT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `exercises_corrections`
-- -----------------------------------------------------
DROP TABLE IF EXISTS exercises_corrections ;

CREATE TABLE IF NOT EXISTS exercises_corrections (
  id INT NOT NULL AUTO_INCREMENT,
  exercise_id INT NOT NULL,
  content CLOB NULL,
  timestamp LONG NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS accounts ;

CREATE TABLE IF NOT EXISTS accounts (
  id INT NOT NULL AUTO_INCREMENT,
  access_key_id INT NOT NULL,
  username VARCHAR(45) NULL,
  password VARCHAR(255) NULL,
  email VARCHAR(100) NULL,
  group_id INT NULL,
  avatar_id INT NULL,
  create_timestamp LONG NULL,
  last_connect_timestamp LONG NULL,
  nb_courses_done INT NULL DEFAULT 0,
  nb_exercises_done INT NULL DEFAULT 0,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `access_keys`
-- -----------------------------------------------------
DROP TABLE IF EXISTS access_keys ;

CREATE TABLE IF NOT EXISTS access_keys (
  id INT NOT NULL AUTO_INCREMENT,
  account_id INT NULL,
  key_value VARCHAR(45) NOT NULL,
  type INT NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS history ;

CREATE TABLE IF NOT EXISTS history (
  id INT NOT NULL AUTO_INCREMENT,
  account_id INT NOT NULL,
  category VARCHAR(255) NULL,
  action CLOB NULL,
  type INT NOT NULL,
  timestamp LONG NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `groups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS groups ;

CREATE TABLE IF NOT EXISTS groups (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  parent_id INT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS courses ;

CREATE TABLE IF NOT EXISTS courses (
  id INT NOT NULL AUTO_INCREMENT,
  account_id INT NULL,
  locales_id INT NULL,
  language_id INT NULL,
  title VARCHAR(45) NULL,
  content CLOB NULL,
  create_timestamp LONG NULL,
  modify_timestamp LONG NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `languages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS languages ;

CREATE TABLE IF NOT EXISTS languages (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `locales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS locales ;

CREATE TABLE IF NOT EXISTS locales (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `courses_comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS courses_comments ;

CREATE TABLE IF NOT EXISTS courses_comments (
  id INT NOT NULL AUTO_INCREMENT,
  course_id INT NULL,
  account_id INT NULL,
  content CLOB NULL,
  create_timestamp LONG NULL,
  modify_timestamp LONG NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `blog_posts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS blog_posts ;

CREATE TABLE IF NOT EXISTS blog_posts (
  id INT NOT NULL AUTO_INCREMENT,
  account_id INT NULL,
  locales_id INT NULL,
  blog_category_id INT NULL,
  title VARCHAR(45) NULL,
  content CLOB NULL,
  create_timestamp LONG NULL,
  modify_timestamp LONG NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `blog_posts_comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS blog_posts_comments ;

CREATE TABLE IF NOT EXISTS blog_posts_comments (
  id INT NOT NULL AUTO_INCREMENT,
  account_id INT NULL,
  blog_post_id INT NULL,
  content CLOB NULL,
  create_timestamp LONG NULL,
  modify_timestamp LONG NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `blog_posts_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS blog_posts_category ;

CREATE TABLE IF NOT EXISTS blog_posts_category (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `forum_categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS forum_categories ;

CREATE TABLE IF NOT EXISTS forum_categories (
  id INT NOT NULL AUTO_INCREMENT,
  forum_icon_id INT NULL,
  title VARCHAR(45) NULL,
  position INT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `forum_forums`
-- -----------------------------------------------------
DROP TABLE IF EXISTS forum_forums ;

CREATE TABLE IF NOT EXISTS forum_forums (
  id INT NOT NULL AUTO_INCREMENT,
  forum_category_id INT NULL,
  forum_icon_id INT NULL,
  title VARCHAR(45) NULL,
  description VARCHAR(250) NULL,
  position INT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `forum_subjects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS forum_subjects ;

CREATE TABLE IF NOT EXISTS forum_subjects (
  id INT NOT NULL AUTO_INCREMENT,
  account_id INT NULL,
  forum_forum_id INT NULL,
  title VARCHAR(100) NULL,
  pin BOOLEAN NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `forum_posts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS forum_posts ;

CREATE TABLE IF NOT EXISTS forum_posts (
  id INT NOT NULL AUTO_INCREMENT,
  account_id INT NULL,
  forum_subject_id INT NULL,
  content CLOB NULL,
  create_timestamp LONG NULL,
  modify_timestamp LONG NULL,
  likes INT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `forum_users_subjects_view`
-- -----------------------------------------------------
DROP TABLE IF EXISTS forum_users_subjects_view ;

CREATE TABLE IF NOT EXISTS forum_users_subjects_view (
  account_id INT NOT NULL,
  forum_subject_id INT NOT NULL,
  nb_subject_last_view INT NOT NULL)
;


-- -----------------------------------------------------
-- Table `forum_icons`
-- -----------------------------------------------------
DROP TABLE IF EXISTS forum_icons ;

CREATE TABLE IF NOT EXISTS forum_icons (
  id INT NOT NULL AUTO_INCREMENT,
  path VARCHAR(255),
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `feedback_categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS feedback_categories ;

CREATE TABLE IF NOT EXISTS feedback_categories (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  description CLOB NULL,
  position INT NULL,
  feedback_icon_id INT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `feedback_labels`
-- -----------------------------------------------------
DROP TABLE IF EXISTS feedback_labels ;

CREATE TABLE IF NOT EXISTS feedback_labels (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  power INT NULL,
  position INT NULL,
  color VARCHAR(7),
  PRIMARY KEY (id))
 ;


-- -----------------------------------------------------
-- Table `feedback_issues`
-- -----------------------------------------------------
DROP TABLE IF EXISTS feedback_issues ;

CREATE TABLE IF NOT EXISTS feedback_issues (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NULL,
  content CLOB NULL,
  account_id INT NULL,
  feedback_label_id INT NULL,
  feedback_category_id INT NULL,
  timestamp LONG NULL,
  is_closed BOOLEAN NULL,
  PRIMARY KEY (id))
 ;


-- -----------------------------------------------------
-- Table `feedback_issues_reply`
-- -----------------------------------------------------
DROP TABLE IF EXISTS feedback_issues_reply ;

CREATE TABLE IF NOT EXISTS feedback_issues_reply (
  id INT NOT NULL AUTO_INCREMENT,
  content CLOB NULL,
  account_id INT NULL,
  feedback_issue_id INT NULL,
  timestamp LONG NULL,
  likes INT NULL,
  PRIMARY KEY (id))
 ;


-- -----------------------------------------------------
-- Table `feedback_icons`
-- -----------------------------------------------------
DROP TABLE IF EXISTS feedback_icons ;

CREATE TABLE IF NOT EXISTS feedback_icons (
  id INT NOT NULL AUTO_INCREMENT,
  path VARCHAR(255) NULL,
  PRIMARY KEY (id))
 ;


-- -----------------------------------------------------
-- Table `avatars`
-- -----------------------------------------------------
DROP TABLE IF EXISTS avatars ;

CREATE TABLE IF NOT EXISTS avatars (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  path VARCHAR(255) NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `users_badges`
-- -----------------------------------------------------
DROP TABLE IF EXISTS users_badges ;

CREATE TABLE IF NOT EXISTS users_badges (
  account_id INT NOT NULL,
  badge_id INT NULL,
  timestamp LONG NULL)
;


-- -----------------------------------------------------
-- Table `badges`
-- -----------------------------------------------------
DROP TABLE IF EXISTS badges ;

CREATE TABLE IF NOT EXISTS badges (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  path_img VARCHAR(255) NULL,
  description CLOB NULL,
  conditions CLOB NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `exercises_moderation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS exercises_moderation ;

CREATE TABLE IF NOT EXISTS exercises_moderation (
  exercise_id INT NOT NULL,
  validate INT NULL,
  commentary CLOB NULL,
  PRIMARY KEY (exercise_id))
;


-- -----------------------------------------------------
-- Table `course_moderation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS course_moderation ;

CREATE TABLE IF NOT EXISTS course_moderation (
  course_id INT NOT NULL,
  validate INT NULL,
  commentary CLOB NULL,
  PRIMARY KEY (course_id))
;


-- -----------------------------------------------------
-- Table `code_templates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS code_templates ;

CREATE TABLE IF NOT EXISTS code_templates (
  id INT NOT NULL AUTO_INCREMENT,
  exercise_id INT NOT NULL,
  file_name VARCHAR(45) NOT NULL,
  content CLOB NOT NULL,
  PRIMARY KEY (id))
;


/* SET SQL_MODE=@OLD_SQL_MODE; */
/* SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS; */
/* SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS; */

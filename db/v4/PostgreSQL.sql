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

CREATE SEQUENCE exercises_seq;

CREATE TABLE IF NOT EXISTS exercises (
  id INT NOT NULL DEFAULT NEXTVAL ('exercises_seq'),
  account_id INT NOT NULL,
  course_id INT NOT NULL,
  title VARCHAR(250) NULL,
  instruction TEXT NULL,
  grade_max INT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `grades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS grades ;

CREATE SEQUENCE grades_seq;

CREATE TABLE IF NOT EXISTS grades (
  id INT NOT NULL DEFAULT NEXTVAL ('grades_seq'),
  user_exercise_id INT NOT NULL,
  value INT NULL,
  timestamp TEXT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `exercises_comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS exercises_comments ;

CREATE SEQUENCE exercises_comments_seq;

CREATE TABLE IF NOT EXISTS exercises_comments (
  id INT NOT NULL DEFAULT NEXTVAL ('exercises_comments_seq'),
  exercise_id INT NOT NULL,
  account_id INT NOT NULL,
  content TEXT NULL,
  create_timestamp TEXT NULL,
  modify_timestamp TEXT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS logs ;

CREATE SEQUENCE logs_seq;

CREATE TABLE IF NOT EXISTS logs (
  id INT NOT NULL DEFAULT NEXTVAL ('logs_seq'),
  user_exercise_id INT NOT NULL,
  content TEXT NULL,
  timestamp TEXT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `scripts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS scripts ;

CREATE SEQUENCE scripts_seq;

CREATE TABLE IF NOT EXISTS scripts (
  id INT NOT NULL DEFAULT NEXTVAL ('scripts_seq'),
  exercise_id INT NOT NULL,
  content TEXT NULL,
  create_timestamp TEXT NULL,
  modify_timestamp TEXT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `codes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS codes ;

CREATE SEQUENCE codes_seq;

CREATE TABLE IF NOT EXISTS codes (
  id INT NOT NULL DEFAULT NEXTVAL ('codes_seq'),
  user_exercise_id INT NOT NULL,
  name VARCHAR(45) NULL,
  content TEXT NULL,
  create_timestamp TEXT NULL,
  modify_timestamp TEXT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `user_exercises`
-- -----------------------------------------------------
DROP TABLE IF EXISTS user_exercises ;

CREATE SEQUENCE user_exercises_seq;

CREATE TABLE IF NOT EXISTS user_exercises (
  id INT NOT NULL DEFAULT NEXTVAL ('user_exercises_seq'),
  account_id INT NULL,
  exercise_id INT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `exercises_corrections`
-- -----------------------------------------------------
DROP TABLE IF EXISTS exercises_corrections ;

CREATE SEQUENCE exercises_corrections_seq;

CREATE TABLE IF NOT EXISTS exercises_corrections (
  id INT NOT NULL DEFAULT NEXTVAL ('exercises_corrections_seq'),
  exercise_id INT NOT NULL,
  content TEXT NULL,
  timestamp TEXT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS accounts ;

CREATE SEQUENCE accounts_seq;

CREATE TABLE IF NOT EXISTS accounts (
  id INT NOT NULL DEFAULT NEXTVAL ('accounts_seq'),
  access_key_id INT NOT NULL,
  username VARCHAR(45) NULL,
  password VARCHAR(255) NULL,
  email VARCHAR(100) NULL,
  group_id INT NULL,
  avatar_id INT NULL,
  create_timestamp TEXT NULL,
  last_connect_timestamp TEXT NULL,
  nb_courses_done INT NULL DEFAULT 0,
  nb_exercises_done INT NULL DEFAULT 0,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `access_keys`
-- -----------------------------------------------------
DROP TABLE IF EXISTS access_keys ;

CREATE SEQUENCE access_keys_seq;

CREATE TABLE IF NOT EXISTS access_keys (
  id INT NOT NULL DEFAULT NEXTVAL ('access_keys_seq'),
  account_id INT NULL,
  key_value VARCHAR(45) NOT NULL,
  type INT NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS history ;

CREATE SEQUENCE history_seq;

CREATE TABLE IF NOT EXISTS history (
  id INT NOT NULL DEFAULT NEXTVAL ('history_seq'),
  account_id INT NOT NULL,
  category VARCHAR(255) NULL,
  action TEXT NULL,
  type INT NOT NULL,
  timestamp TEXT NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `groups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS groups ;

CREATE SEQUENCE groups_seq;

CREATE TABLE IF NOT EXISTS groups (
  id INT NOT NULL DEFAULT NEXTVAL ('groups_seq'),
  name VARCHAR(45) NULL,
  parent_id INT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS courses ;

CREATE SEQUENCE courses_seq;

CREATE TABLE IF NOT EXISTS courses (
  id INT NOT NULL DEFAULT NEXTVAL ('courses_seq'),
  account_id INT NULL,
  locales_id INT NULL,
  language_id INT NULL,
  title VARCHAR(45) NULL,
  content TEXT NULL,
  create_timestamp TEXT NULL,
  modify_timestamp TEXT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `languages`
-- -----------------------------------------------------
DROP TABLE IF EXISTS languages ;

CREATE SEQUENCE languages_seq;

CREATE TABLE IF NOT EXISTS languages (
  id INT NOT NULL DEFAULT NEXTVAL ('languages_seq'),
  name VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `locales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS locales ;

CREATE SEQUENCE locales_seq;

CREATE TABLE IF NOT EXISTS locales (
  id INT NOT NULL DEFAULT NEXTVAL ('locales_seq'),
  name VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `courses_comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS courses_comments ;

CREATE SEQUENCE courses_comments_seq;

CREATE TABLE IF NOT EXISTS courses_comments (
  id INT NOT NULL DEFAULT NEXTVAL ('courses_comments_seq'),
  course_id INT NULL,
  account_id INT NULL,
  content TEXT NULL,
  create_timestamp TEXT NULL,
  modify_timestamp TEXT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `blog_posts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS blog_posts ;

CREATE SEQUENCE blog_posts_seq;

CREATE TABLE IF NOT EXISTS blog_posts (
  id INT NOT NULL DEFAULT NEXTVAL ('blog_posts_seq'),
  account_id INT NULL,
  locales_id INT NULL,
  blog_category_id INT NULL,
  title VARCHAR(45) NULL,
  content TEXT NULL,
  create_timestamp TEXT NULL,
  modify_timestamp TEXT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `blog_posts_comments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS blog_posts_comments ;

CREATE SEQUENCE blog_posts_comments_seq;

CREATE TABLE IF NOT EXISTS blog_posts_comments (
  id INT NOT NULL DEFAULT NEXTVAL ('blog_posts_comments_seq'),
  account_id INT NULL,
  blog_post_id INT NULL,
  content TEXT NULL,
  create_timestamp TEXT NULL,
  modify_timestamp TEXT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `blog_posts_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS blog_posts_category ;

CREATE SEQUENCE blog_posts_category_seq;

CREATE TABLE IF NOT EXISTS blog_posts_category (
  id INT NOT NULL DEFAULT NEXTVAL ('blog_posts_category_seq'),
  name VARCHAR(45) NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `forum_categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS forum_categories ;

CREATE SEQUENCE forum_categories_seq;

CREATE TABLE IF NOT EXISTS forum_categories (
  id INT NOT NULL DEFAULT NEXTVAL ('forum_categories_seq'),
  forum_icon_id INT NULL,
  title VARCHAR(45) NULL,
  position INT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `forum_forums`
-- -----------------------------------------------------
DROP TABLE IF EXISTS forum_forums ;

CREATE SEQUENCE forum_forums_seq;

CREATE TABLE IF NOT EXISTS forum_forums (
  id INT NOT NULL DEFAULT NEXTVAL ('forum_forums_seq'),
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

CREATE SEQUENCE forum_subjects_seq;

CREATE TABLE IF NOT EXISTS forum_subjects (
  id INT NOT NULL DEFAULT NEXTVAL ('forum_subjects_seq'),
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

CREATE SEQUENCE forum_posts_seq;

CREATE TABLE IF NOT EXISTS forum_posts (
  id INT NOT NULL DEFAULT NEXTVAL ('forum_posts_seq'),
  account_id INT NULL,
  forum_subject_id INT NULL,
  content TEXT NULL,
  create_timestamp TEXT NULL,
  modify_timestamp TEXT NULL,
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

CREATE SEQUENCE forum_icons_seq;

CREATE TABLE IF NOT EXISTS forum_icons (
  id INT NOT NULL DEFAULT NEXTVAL ('forum_icons_seq'),
  path VARCHAR(255),
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `feedback_categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS feedback_categories ;

CREATE SEQUENCE feedback_categories_seq;

CREATE TABLE IF NOT EXISTS feedback_categories (
  id INT NOT NULL DEFAULT NEXTVAL ('feedback_categories_seq'),
  name VARCHAR(45) NULL,
  description TEXT NULL,
  position INT NULL,
  feedback_icon_id INT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `feedback_labels`
-- -----------------------------------------------------
DROP TABLE IF EXISTS feedback_labels ;

CREATE SEQUENCE feedback_labels_seq;

CREATE TABLE IF NOT EXISTS feedback_labels (
  id INT NOT NULL DEFAULT NEXTVAL ('feedback_labels_seq'),
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

CREATE SEQUENCE feedback_issues_seq;

CREATE TABLE IF NOT EXISTS feedback_issues (
  id INT NOT NULL DEFAULT NEXTVAL ('feedback_issues_seq'),
  title VARCHAR(45) NULL,
  content TEXT NULL,
  account_id INT NULL,
  feedback_label_id INT NULL,
  feedback_category_id INT NULL,
  timestamp TEXT NULL,
  is_closed BOOLEAN NULL,
  PRIMARY KEY (id))
 ;


-- -----------------------------------------------------
-- Table `feedback_issues_reply`
-- -----------------------------------------------------
DROP TABLE IF EXISTS feedback_issues_reply ;

CREATE SEQUENCE feedback_issues_reply_seq;

CREATE TABLE IF NOT EXISTS feedback_issues_reply (
  id INT NOT NULL DEFAULT NEXTVAL ('feedback_issues_reply_seq'),
  content TEXT NULL,
  account_id INT NULL,
  feedback_issue_id INT NULL,
  timestamp TEXT NULL,
  likes INT NULL,
  PRIMARY KEY (id))
 ;


-- -----------------------------------------------------
-- Table `feedback_icons`
-- -----------------------------------------------------
DROP TABLE IF EXISTS feedback_icons ;

CREATE SEQUENCE feedback_icons_seq;

CREATE TABLE IF NOT EXISTS feedback_icons (
  id INT NOT NULL DEFAULT NEXTVAL ('feedback_icons_seq'),
  path VARCHAR(255) NULL,
  PRIMARY KEY (id))
 ;


-- -----------------------------------------------------
-- Table `avatars`
-- -----------------------------------------------------
DROP TABLE IF EXISTS avatars ;

CREATE SEQUENCE avatars_seq;

CREATE TABLE IF NOT EXISTS avatars (
  id INT NOT NULL DEFAULT NEXTVAL ('avatars_seq'),
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
  timestamp TEXT NULL)
;


-- -----------------------------------------------------
-- Table `badges`
-- -----------------------------------------------------
DROP TABLE IF EXISTS badges ;

CREATE SEQUENCE badges_seq;

CREATE TABLE IF NOT EXISTS badges (
  id INT NOT NULL DEFAULT NEXTVAL ('badges_seq'),
  name VARCHAR(45) NULL,
  path_img VARCHAR(255) NULL,
  description TEXT NULL,
  conditions TEXT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table `exercises_moderation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS exercises_moderation ;

CREATE TABLE IF NOT EXISTS exercises_moderation (
  exercise_id INT NOT NULL,
  validate INT NULL,
  commentary TEXT NULL,
  PRIMARY KEY (exercise_id))
;


-- -----------------------------------------------------
-- Table `course_moderation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS course_moderation ;

CREATE TABLE IF NOT EXISTS course_moderation (
  course_id INT NOT NULL,
  validate INT NULL,
  commentary TEXT NULL,
  PRIMARY KEY (course_id))
;


-- -----------------------------------------------------
-- Table `code_templates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS code_templates ;

CREATE SEQUENCE code_templates_seq;

CREATE TABLE IF NOT EXISTS code_templates (
  id INT NOT NULL DEFAULT NEXTVAL ('code_templates_seq'),
  exercise_id INT NOT NULL,
  file_name VARCHAR(45) NOT NULL,
  content TEXT NOT NULL,
  PRIMARY KEY (id))
;


/* SET SQL_MODE=@OLD_SQL_MODE; */
/* SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS; */
/* SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS; */

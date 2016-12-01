-- -----------------------------------------------------
-- Code and Learn SQLite script by Teddy Fontaine (Sheol)
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `exercises`
-- -----------------------------------------------------
CREATE TABLE `exercises` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `account_id` INTEGER NOT NULL,
  `course_id` INTEGER NOT NULL,
  `title` VARCHAR(250) NULL,
  `instruction` TEXT NULL,
  `grade_max` INTEGER NULL);


-- -----------------------------------------------------
-- Table `grades`
-- -----------------------------------------------------
CREATE TABLE `grades` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `user_exercise_id` INTEGER NOT NULL,
  `value` INTEGER NULL,
  `timestamp` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `exercises_comments`
-- -----------------------------------------------------
CREATE TABLE `exercises_comments` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `exercise_id` INTEGER NOT NULL,
  `account_id` INTEGER NOT NULL,
  `content` TEXT NULL,
  `create_timestamp` TIMESTAMP NULL,
  `modify_timestamp` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `logs`
-- -----------------------------------------------------
CREATE TABLE `logs` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `user_exercise_id` INTEGER NOT NULL,
  `content` TEXT NULL,
  `timestamp` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `scripts`
-- -----------------------------------------------------
CREATE TABLE `scripts` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `exercise_id` INTEGER NOT NULL,
  `content` TEXT NULL,
  `create_timestamp` TIMESTAMP NULL,
  `modify_timestamp` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `codes`
-- -----------------------------------------------------
CREATE TABLE `codes` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `user_exercise_id` INTEGER NOT NULL,
  `name` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `create_timestamp` TIMESTAMP NULL,
  `modify_timestamp` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `user_exercises`
-- -----------------------------------------------------
CREATE TABLE `user_exercises` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `account_id` INTEGER NULL,
  `exercise_id` INTEGER NULL);


-- -----------------------------------------------------
-- Table `exercises_corrections`
-- -----------------------------------------------------
CREATE TABLE `exercises_corrections` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `exercise_id` INTEGER NOT NULL,
  `content` TEXT NULL,
  `timestamp` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `accounts`
-- -----------------------------------------------------
CREATE TABLE `accounts` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `access_key_id` INTEGER NOT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(255) NULL,
  `email` VARCHAR(100) NULL,
  `group_id` INTEGER NULL,
  `avatar_id` INTEGER NULL,
  `create_timestamp` TIMESTAMP NULL,
  `last_connect_timestamp` TIMESTAMP NULL,
  `nb_courses_done` INTEGER NULL DEFAULT 0,
  `nb_exercises_done` INTEGER NULL DEFAULT 0);


-- -----------------------------------------------------
-- Table `access_keys`
-- -----------------------------------------------------
CREATE TABLE `access_keys` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `account_id` INTEGER NULL,
  `key_value` VARCHAR(45) NOT NULL,
  `type` INTEGER NOT NULL);


-- -----------------------------------------------------
-- Table `history`
-- -----------------------------------------------------
CREATE TABLE `history` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `account_id` INTEGER NOT NULL,
  `category` VARCHAR(255) NULL,
  `action` TEXT NULL,
  `type` INTEGER NULL,
  `timestamp` LONG NOT NULL);


-- -----------------------------------------------------
-- Table `groups`
-- -----------------------------------------------------
CREATE TABLE `groups` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `name` VARCHAR(45) NULL,
  `parent_id` INTEGER NULL);


-- -----------------------------------------------------
-- Table `courses`
-- -----------------------------------------------------
CREATE TABLE `courses` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `account_id` INTEGER NULL,
  `locales_id` INTEGER NULL,
  `language_id` INTEGER NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `create_timestamp` TIMESTAMP NULL,
  `modify_timestamp` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `languages`
-- -----------------------------------------------------
CREATE TABLE `languages` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `name` VARCHAR(45) NULL);


-- -----------------------------------------------------
-- Table `locales`
-- -----------------------------------------------------
CREATE TABLE `locales` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `name` VARCHAR(45) NULL);


-- -----------------------------------------------------
-- Table `courses_comments`
-- -----------------------------------------------------
CREATE TABLE `courses_comments` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `course_id` INTEGER NULL,
  `account_id` INTEGER NULL,
  `content` TEXT NULL,
  `create_timestamp` TIMESTAMP NULL,
  `modify_timestamp` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `blog_posts`
-- -----------------------------------------------------
CREATE TABLE `blog_posts` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `account_id` INTEGER NULL,
  `locales_id` INTEGER NULL,
  `blog_category_id` INTEGER NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `create_timestamp` TIMESTAMP NULL,
  `modify_timestamp` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `blog_posts_comments`
-- -----------------------------------------------------
CREATE TABLE `blog_posts_comments` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `account_id` INTEGER NULL,
  `blog_post_id` INTEGER NULL,
  `content` TEXT NULL,
  `create_timestamp` TIMESTAMP NULL,
  `modify_timestamp` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `blog_posts_category`
-- -----------------------------------------------------
CREATE TABLE `blog_posts_category` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `name` VARCHAR(45) NULL);


-- -----------------------------------------------------
-- Table `forum_categories`
-- -----------------------------------------------------
CREATE TABLE `forum_categories` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `forum_icon_id` INTEGER NULL,
  `title` VARCHAR(45) NULL,
  `position` INTEGER NULL);

-- -----------------------------------------------------
-- Table `forum_forums`
-- -----------------------------------------------------
CREATE TABLE `forum_forums` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `forum_category_id` INTEGER NULL,
  `forum_icon_id` INTEGER NULL,
  `title` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `position` INTEGER NULL);

-- -----------------------------------------------------
-- Table `forum_subjects`
-- -----------------------------------------------------
CREATE TABLE `forum_subjects` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `account_id` INTEGER NULL,
  `forum_forum_id` INTEGER NULL,
  `title` VARCHAR(45) NULL,
  `pin` BOOLEAN NULL);

-- -----------------------------------------------------
-- Table `forum_posts`
-- -----------------------------------------------------
CREATE TABLE `forum_posts` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `account_id` INTEGER NULL,
  `forum_subject_id` INTEGER NULL,
  `content` TEXT NULL,
  `create_timestamp` TIMESTAMP NULL,
  `modify_timestamp` TIMESTAMP NULL,
  `likes` INTEGER NULL);


-- -----------------------------------------------------
-- Table `forum_users_subjects_view`
-- -----------------------------------------------------
CREATE TABLE `forum_users_subjects_view` (
  `account_id` INTEGER NOT NULL,
  `forum_subject_id` INTEGER NULL,
  `nb_subject_last_view` INTEGER NULL);


-- -----------------------------------------------------
-- Table `forum_icons`
-- -----------------------------------------------------
CREATE TABLE `forum_icons` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `path` VARCHAR(255) NULL);


-- -----------------------------------------------------
-- Table `feedback_categories`
-- -----------------------------------------------------
CREATE TABLE `feedback_categories` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `position` INTEGER NULL,
  `feedback_icon_id` INTEGER NULL);


-- -----------------------------------------------------
-- Table `feedback_labels`
-- -----------------------------------------------------
CREATE TABLE `feedback_labels` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `name` VARCHAR(45) NULL,
  `power` INTEGER NULL,
  `position` INTEGER NULL,
  `color` VARCHAR(7) NULL);


-- -----------------------------------------------------
-- Table `feedback_issues`
-- -----------------------------------------------------
CREATE TABLE `feedback_issues` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `title` VARCHAR(45) NULL,
  `content` TEXT NULL,
  `account_id` INTEGER NULL,
  `feedback_label_id` INTEGER NULL,
  `feedback_category_id` INTEGER NULL,
  `timestamp` TIMESTAMP NULL,
  `is_closed` BOOL NULL);


-- -----------------------------------------------------
-- Table `feedback_issues_reply`
-- -----------------------------------------------------
CREATE TABLE `feedback_issues_reply` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `content` TEXT NULL,
  `account_id` INTEGER NULL,
  `feedback_issue_id` INTEGER NULL,
  `timestamp` TIMESTAMP NULL,
  `likes` INTEGER NULL);


-- -----------------------------------------------------
-- Table `feedback_icons`
-- -----------------------------------------------------
CREATE TABLE `feedback_icons` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `path` VARCHAR(255) NULL);


-- -----------------------------------------------------
-- Table `avatars`
-- -----------------------------------------------------
CREATE TABLE `avatars` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `path` VARCHAR(255) NOT NULL);


-- -----------------------------------------------------
-- Table `users_badges`
-- -----------------------------------------------------
CREATE TABLE `users_badges` (
  `account_id` INTEGER NOT NULL,
  `badge_id` INTEGER NULL,
  `timestamp` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `badges`
-- -----------------------------------------------------
CREATE TABLE `badges` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `name` VARCHAR(45) NULL,
  `path_img` VARCHAR(255) NULL,
  `description` TEXT NULL,
  `conditions` TEXT NULL);


-- -----------------------------------------------------
-- Table `exercises_moderation`
-- -----------------------------------------------------
CREATE TABLE `exercises_moderation` (
  `exercise_id` INTEGER NOT NULL,
  `validate` INTEGER NULL,
  `commentary` TEXT NULL,
  PRIMARY KEY (`exercise_id`));


-- -----------------------------------------------------
-- Table `course_moderation`
-- -----------------------------------------------------
CREATE TABLE `course_moderation` (
  `course_id` INTEGER NOT NULL,
  `validate` INTEGER NULL,
  `commentary` TEXT NULL,
  PRIMARY KEY (`course_id`));


-- -----------------------------------------------------
-- Table `code_templates`
-- -----------------------------------------------------
CREATE TABLE `code_templates` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  `exercise_id` INTEGER NOT NULL,
  `file_name` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL);


-- -----------------------------------------------------
-- Set base record
-- -----------------------------------------------------
INSERT INTO avatars (name, path) VALUES ("Default", "default.png");
INSERT INTO groups (name, parent_id) VALUES ("member", 10);
INSERT INTO groups (name, parent_id) VALUES ("moderator", 30);
INSERT INTO groups (name, parent_id) VALUES ("administrator", 50);
INSERT INTO locales (name) VALUES ("FR");
INSERT INTO locales (name) VALUES ("EN");
INSERT INTO access_keys (account_id, key_value, type) VALUES (0, "XXXXXX-XXXXXX-XXXXXX-XXXXXX", 0);


-- -----------------------------------------------------
-- Set default values
-- -----------------------------------------------------
INSERT INTO accounts (access_key_id, username, password, email, group_id, avatar_id, create_timestamp, last_connect_timestamp, nb_courses_done, nb_exercises_done)
  VALUES (1, "Admin", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", "admin%40codeandlearn.com", 3, 1, 1464262190085, 1464262190085, 0, 0);
INSERT INTO blog_posts_category (name) VALUES ("Default");
INSERT INTO languages (name) VALUES ("C%23");
INSERT INTO languages (name) VALUES ("JAVA");
INSERT INTO languages (name) VALUES ("C");
INSERT INTO avatars (name, path) VALUES ("Zynga", "zynga.png");
INSERT INTO avatars (name, path) VALUES ("Readernaut", "readernaut.png");
INSERT INTO avatars (name, path) VALUES ("Girl1", "female.png");
INSERT INTO avatars (name, path) VALUES ("Girl2", "maturewoman.png");
INSERT INTO avatars (name, path) VALUES ("Boy1", "male.png");
INSERT INTO avatars (name, path) VALUES ("Boy2", "malecostume.png");
INSERT INTO avatars (name, path) VALUES ("Boy3", "matureman2.png");
INSERT INTO badges (id, name, path_img, description, conditions) VALUES (1,"Testeur","testeur.png","S%E2%80%99inscrire+avec+l%E2%80%99une+des+100+premi%C3%A8res+cl%C3%A9s+b%C3%AAta.","%7B%7D");
INSERT INTO badges (id, name, path_img, description, conditions) VALUES (2,"Make%205%20courses","make_courses_5.png","Terminer+5+cours+%2B+les+5+exercices+de+validations+de+cours+sachant+que+tous+les+cours+n%E2%80%99ont+pas+d%E2%80%99exercice+de+validation.","%7B%7D");
INSERT INTO badges (id, name, path_img, description, conditions) VALUES (3,"Make%2010%20courses","make_courses_10.png","Terminer+10+cours+%2B+les+10+exercices+de+validations+de+cours+sachant+que+tous+les+cours+n%E2%80%99ont+pas+d%E2%80%99exercice+de+validation.","%7B%7D");
INSERT INTO badges (id, name, path_img, description, conditions) VALUES (4,"Make%2030%20courses","make_courses_30.png","Terminer+30+cours+%2B+les+30+exercices+de+validations+de+cours+sachant+que+tous+les+cours+n%E2%80%99ont+pas+d%E2%80%99exercice+de+validation.","%7B%7D");
INSERT INTO badges (id, name, path_img, description, conditions) VALUES (5,"Make%2050%20courses","make_courses_50.png","Terminer+50+cours+%2B+les+50+exercices+de+validations+de+cours+sachant+que+tous+les+cours+n%E2%80%99ont+pas+d%E2%80%99exercice+de+validation.","%7B%7D");
INSERT INTO badges (id, name, path_img, description, conditions) VALUES (6,"Publish%205%20courses","publish_courses_5.png","Publier+5+cours+%2B+obtenir+5+validations+des+mod%C3%A9rateurs.","%7B%7D");
INSERT INTO badges (id, name, path_img, description, conditions) VALUES (7,"Publish%2010%20courses","publish_courses_10.png","Publier+10+cours+%2B+obtenir+10+validations+des+mod%C3%A9rateurs.","%7B%7D");
INSERT INTO badges (id, name, path_img, description, conditions) VALUES (8,"Publish%2030%20courses","publish_courses_30.png","Publier+30+cours+%2B+obtenir+30+validations+des+mod%C3%A9rateurs.","%7B%7D");
INSERT INTO badges (id, name, path_img, description, conditions) VALUES (9,"Publish%2050%20courses","publish_courses_50.png","Publier+50+cours+%2B+obtenir+50+validations+des+mod%C3%A9rateurs.","%7B%7D");
INSERT INTO badges (id, name, path_img, description, conditions) VALUES (10,"Epitech%20Experience%202016","epitech_experience_2016.png","Badge+c%C3%A9l%C3%A9brant+la+pr%C3%A9sence+de+Code+and+Learn+au+forum+d%E2%80%99Epitech+Experience+entre+le+24+et+le+26+novembre+2016+%C3%A0+Paris.","%7B%7D");

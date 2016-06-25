-- -----------------------------------------------------
-- Code and Learn PostgreSQL script by Teddy Fontaine (Sheol)
-- -----------------------------------------------------

DROP TABLE IF EXISTS groups CASCADE;

CREATE SEQUENCE IF NOT EXISTS groups_seq;
ALTER SEQUENCE IF EXISTS groups_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS groups (
  id        INT         NOT NULL DEFAULT NEXTVAL('groups_seq'),
  name      VARCHAR(45) NULL,
  parent_id INT         NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS avatars CASCADE;

CREATE SEQUENCE IF NOT EXISTS avatars_seq;
ALTER SEQUENCE IF EXISTS avatars_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS avatars (
  id   INT          NOT NULL DEFAULT NEXTVAL('avatars_seq'),
  path VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS accounts CASCADE;

CREATE SEQUENCE IF NOT EXISTS accounts_seq;
ALTER SEQUENCE IF EXISTS accounts_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS accounts (
  id                     INT          NOT NULL DEFAULT NEXTVAL('accounts_seq'),
  username               VARCHAR(45)  NULL,
  password               VARCHAR(255) NULL,
  email                  VARCHAR(100) NULL,
  group_id               INT          NULL,
  avatar_id              INT          NULL,
  create_timestamp       BIGINT       NULL,
  last_connect_timestamp BIGINT       NULL,
  nb_courses_done        INT          NULL     DEFAULT 0,
  nb_exercices_done      INT          NULL     DEFAULT 0,
  PRIMARY KEY (id)
  ,
  CONSTRAINT group_id
  FOREIGN KEY (group_id)
  REFERENCES groups (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT avatar_id
  FOREIGN KEY (avatar_id)
  REFERENCES avatars (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX group_id_idx_accounts ON accounts (group_id ASC);
CREATE INDEX avatar_id_idx_accounts ON accounts (avatar_id ASC);

DROP TABLE IF EXISTS locales CASCADE;

CREATE SEQUENCE IF NOT EXISTS locales_seq;
ALTER SEQUENCE IF EXISTS locales_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS locales (
  id   INT         NOT NULL DEFAULT NEXTVAL('locales_seq'),
  name VARCHAR(45) NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS languages CASCADE;

CREATE SEQUENCE IF NOT EXISTS languages_seq;
ALTER SEQUENCE IF EXISTS languages_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS languages (
  id   INT         NOT NULL DEFAULT NEXTVAL('languages_seq'),
  name VARCHAR(45) NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS courses CASCADE;

CREATE SEQUENCE IF NOT EXISTS courses_seq;
ALTER SEQUENCE IF EXISTS courses_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS courses (
  id               INT         NOT NULL DEFAULT NEXTVAL('courses_seq'),
  account_id       INT         NULL,
  locales_id       INT         NULL,
  language_id      INT         NULL,
  title            VARCHAR(45) NULL,
  content          TEXT        NULL,
  create_timestamp BIGINT      NULL,
  modify_timestamp BIGINT      NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT account_id
  FOREIGN KEY (account_id)
  REFERENCES accounts (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT locales_id
  FOREIGN KEY (locales_id)
  REFERENCES locales (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT language_id
  FOREIGN KEY (language_id)
  REFERENCES languages (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX account_id_idx_courses ON courses (account_id ASC);
CREATE INDEX locales_id_idx_courses ON courses (locales_id ASC);
CREATE INDEX language_id_idx_courses ON courses (language_id ASC);

DROP TABLE IF EXISTS exercices CASCADE;

CREATE SEQUENCE IF NOT EXISTS exercices_seq;
ALTER SEQUENCE IF EXISTS exercices_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS exercices (
  id          INT          NOT NULL DEFAULT NEXTVAL('exercices_seq'),
  account_id  INT          NOT NULL,
  course_id   INT          NOT NULL,
  title       VARCHAR(250) NULL,
  instruction TEXT         NULL,
  grade_max   INT          NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT account_id
  FOREIGN KEY (account_id)
  REFERENCES accounts (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT course_id
  FOREIGN KEY (course_id)
  REFERENCES courses (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX account_id_idx_exercices ON exercices (account_id ASC);
CREATE INDEX course_id_idx_exercices ON exercices (course_id ASC);

DROP TABLE IF EXISTS user_exercises CASCADE;

CREATE SEQUENCE IF NOT EXISTS user_exercises_seq;
ALTER SEQUENCE IF EXISTS user_exercises_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS user_exercises (
  id          INT NOT NULL DEFAULT NEXTVAL('user_exercises_seq'),
  account_id  INT NULL,
  exercice_id INT NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT account_id
  FOREIGN KEY (account_id)
  REFERENCES accounts (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT exercice_id
  FOREIGN KEY (exercice_id)
  REFERENCES exercices (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX account_id_idx_user_exercises ON user_exercises (account_id ASC);
CREATE INDEX exercice_id_idx_user_exercises ON user_exercises (exercice_id ASC);

DROP TABLE IF EXISTS grades CASCADE;

CREATE SEQUENCE IF NOT EXISTS grades_seq;
ALTER SEQUENCE IF EXISTS grades_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS grades (
  id               INT    NOT NULL DEFAULT NEXTVAL('grades_seq'),
  user_exercice_id INT    NOT NULL,
  value            INT    NULL,
  BIGINT           BIGINT NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT user_exercice_id
  FOREIGN KEY (user_exercice_id)
  REFERENCES user_exercises (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX user_exercice_id_idx_grades ON grades (user_exercice_id ASC);

DROP TABLE IF EXISTS exercices_comments CASCADE;

CREATE SEQUENCE IF NOT EXISTS exercices_comments_seq;
ALTER SEQUENCE IF EXISTS exercices_comments_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS exercices_comments (
  id               INT    NOT NULL DEFAULT NEXTVAL('exercices_comments_seq'),
  exercice_id      INT    NOT NULL,
  account_id       INT    NOT NULL,
  content          TEXT   NULL,
  create_timestamp BIGINT NULL,
  modify_timestamp BIGINT NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT exercice_id
  FOREIGN KEY (exercice_id)
  REFERENCES exercices (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT account_id
  FOREIGN KEY (account_id)
  REFERENCES accounts (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX exercice_id_idx_exercices_comments ON exercices_comments (exercice_id ASC);
CREATE INDEX account_id_idx_exercices_comments ON exercices_comments (account_id ASC);

DROP TABLE IF EXISTS logs CASCADE;

CREATE SEQUENCE IF NOT EXISTS logs_seq;
ALTER SEQUENCE IF EXISTS logs_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS logs (
  id               INT    NOT NULL DEFAULT NEXTVAL('logs_seq'),
  user_exercice_id INT    NOT NULL,
  content          TEXT   NULL,
  BIGINT           BIGINT NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT user_exercice_id
  FOREIGN KEY (user_exercice_id)
  REFERENCES user_exercises (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX user_exercice_id_idx_logs ON logs (user_exercice_id ASC);

DROP TABLE IF EXISTS scripts CASCADE;

CREATE SEQUENCE IF NOT EXISTS scripts_seq;
ALTER SEQUENCE IF EXISTS scripts_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS scripts (
  id               INT    NOT NULL DEFAULT NEXTVAL('scripts_seq'),
  exercice_id      INT    NOT NULL,
  content          TEXT   NULL,
  create_timestamp BIGINT NULL,
  modify_timestamp BIGINT NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT exercice_id
  FOREIGN KEY (exercice_id)
  REFERENCES exercices (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX exercice_id_idx_scripts ON scripts (exercice_id ASC);

DROP TABLE IF EXISTS codes CASCADE;

CREATE SEQUENCE IF NOT EXISTS codes_seq;
ALTER SEQUENCE IF EXISTS codes_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS codes (
  id               INT           NOT NULL DEFAULT NEXTVAL('codes_seq'),
  user_exercice_id INT           NOT NULL,
  name             VARCHAR(75)   NULL,
  content          TEXT          NULL,
  create_timestamp BIGINT        NULL,
  modify_timestamp BIGINT        NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT user_exercice_id
  FOREIGN KEY (user_exercice_id)
  REFERENCES user_exercises (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX user_exercice_id_idx_codes ON codes (user_exercice_id ASC);

DROP TABLE IF EXISTS exercices_corrections CASCADE;

CREATE SEQUENCE IF NOT EXISTS exercices_corrections_seq;
ALTER SEQUENCE IF EXISTS exercices_corrections_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS exercices_corrections (
  id          INT    NOT NULL DEFAULT NEXTVAL('exercices_corrections_seq'),
  exercice_id INT    NOT NULL,
  content     TEXT   NULL,
  BIGINT      BIGINT NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT exercice_id
  FOREIGN KEY (exercice_id)
  REFERENCES exercices (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX exercice_id_idx_exercices_corrections ON exercices_corrections (exercice_id ASC);

DROP TABLE IF EXISTS courses_comments CASCADE;

CREATE SEQUENCE IF NOT EXISTS courses_comments_seq;
ALTER SEQUENCE IF EXISTS courses_comments_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS courses_comments (
  id               INT    NOT NULL DEFAULT NEXTVAL('courses_comments_seq'),
  course_id        INT    NULL,
  account_id       INT    NULL,
  content          TEXT   NULL,
  create_timestamp BIGINT NULL,
  modify_timestamp BIGINT NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT course_id
  FOREIGN KEY (course_id)
  REFERENCES courses (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT account_id
  FOREIGN KEY (account_id)
  REFERENCES accounts (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX course_id_idx_courses_comments ON courses_comments (course_id ASC);
CREATE INDEX account_id_idx_courses_comments ON courses_comments (account_id ASC);

DROP TABLE IF EXISTS blog_posts_category CASCADE;

CREATE SEQUENCE IF NOT EXISTS blog_posts_category_seq;
ALTER SEQUENCE IF EXISTS blog_posts_category_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS blog_posts_category (
  id   INT         NOT NULL DEFAULT NEXTVAL('blog_posts_category_seq'),
  name VARCHAR(45) NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS blog_posts CASCADE;

CREATE SEQUENCE IF NOT EXISTS blog_posts_seq;
ALTER SEQUENCE IF EXISTS blog_posts_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS blog_posts (
  id               INT         NOT NULL DEFAULT NEXTVAL('blog_posts_seq'),
  account_id       INT         NULL,
  locales_id       INT         NULL,
  blog_category_id INT         NULL,
  title            VARCHAR(45) NULL,
  content          TEXT        NULL,
  create_timestamp BIGINT      NULL,
  modify_timestamp BIGINT      NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT account_id
  FOREIGN KEY (account_id)
  REFERENCES accounts (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT locales_id
  FOREIGN KEY (locales_id)
  REFERENCES locales (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT blog_category_id
  FOREIGN KEY (blog_category_id)
  REFERENCES blog_posts_category (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX account_d_idx_blog_posts ON blog_posts (account_id ASC);
CREATE INDEX locales_id_idx_blog_posts ON blog_posts (locales_id ASC);
CREATE INDEX blog_category_id_idx_blog_posts ON blog_posts (blog_category_id ASC);

DROP TABLE IF EXISTS blog_posts_comments CASCADE;

CREATE SEQUENCE IF NOT EXISTS blog_posts_comments_seq;
ALTER SEQUENCE IF EXISTS blog_posts_comments_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS blog_posts_comments (
  id               INT    NOT NULL DEFAULT NEXTVAL('blog_posts_comments_seq'),
  account_id       INT    NULL,
  blog_post_id     INT    NULL,
  content          TEXT   NULL,
  create_timestamp BIGINT NULL,
  modify_timestamp BIGINT NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT account_id
  FOREIGN KEY (account_id)
  REFERENCES accounts (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT blog_post_id
  FOREIGN KEY (blog_post_id)
  REFERENCES blog_posts (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX account_id_idx_blog_posts_comments ON blog_posts_comments (account_id ASC);
CREATE INDEX blog_post_id_idx_blog_posts_comments ON blog_posts_comments (blog_post_id ASC);

DROP TABLE IF EXISTS forum_category CASCADE;

CREATE SEQUENCE IF NOT EXISTS forum_category_seq;
ALTER SEQUENCE IF EXISTS forum_category_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS forum_category (
  id   INT         NOT NULL DEFAULT NEXTVAL('forum_category_seq'),
  name VARCHAR(45) NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS forum_forums CASCADE;

CREATE SEQUENCE IF NOT EXISTS forum_forums_seq;
ALTER SEQUENCE IF EXISTS forum_forums_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS forum_forums (
  id                 INT         NOT NULL DEFAULT NEXTVAL('forum_forums_seq'),
  forums_category_id INT         NULL,
  name               VARCHAR(45) NULL,
  description        TEXT        NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT forums_category_id
  FOREIGN KEY (forums_category_id)
  REFERENCES forum_category (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX forums_category_id_idx_forum_forums ON forum_forums (forums_category_id ASC);

DROP TABLE IF EXISTS forum_subjects CASCADE;

CREATE SEQUENCE IF NOT EXISTS forum_subjects_seq;
ALTER SEQUENCE IF EXISTS forum_subjects_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS forum_subjects (
  id              INT    NOT NULL DEFAULT NEXTVAL('forum_subjects_seq'),
  forums_forum_id INT    NULL,
  locales_id      INT    NULL,
  account_id      INT    NULL,
  BIGINT          BIGINT NULL,
  replies         INT    NULL,
  views           INT    NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT forums_forum_id
  FOREIGN KEY (forums_forum_id)
  REFERENCES forum_forums (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT locales_id
  FOREIGN KEY (locales_id)
  REFERENCES locales (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT account_id
  FOREIGN KEY (account_id)
  REFERENCES accounts (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX forums_forum_id_idx_forum_subjects ON forum_subjects (forums_forum_id ASC);
CREATE INDEX locales_id_idx_forum_subjects ON forum_subjects (locales_id ASC);
CREATE INDEX account_id_idx_forum_subjects ON forum_subjects (account_id ASC);

DROP TABLE IF EXISTS forum_posts CASCADE;

CREATE SEQUENCE IF NOT EXISTS forum_posts_seq;
ALTER SEQUENCE IF EXISTS forum_posts_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS forum_posts (
  id                INT    NOT NULL DEFAULT NEXTVAL('forum_posts_seq'),
  forums_subject_id INT    NULL,
  account_id        INT    NULL,
  create_timestamp  BIGINT NULL,
  modify_timestamp  BIGINT NULL,
  content           TEXT   NULL,
  likes             INT    NULL,
  PRIMARY KEY (id)
  ,
  CONSTRAINT forums_subject_id
  FOREIGN KEY (forums_subject_id)
  REFERENCES forum_subjects (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT account_id
  FOREIGN KEY (account_id)
  REFERENCES accounts (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX forums_subject_id_idx_forum_posts ON forum_posts (forums_subject_id ASC);
CREATE INDEX account_id_idx_forum_posts ON forum_posts (account_id ASC);

DROP TABLE IF EXISTS tokens CASCADE;

CREATE TABLE IF NOT EXISTS tokens (
  account_id INT          NOT NULL,
  token      VARCHAR(255) NULL,
  ttl        INT          NULL,
  PRIMARY KEY (account_id),
  CONSTRAINT account_id
  FOREIGN KEY (account_id)
  REFERENCES accounts (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS badges CASCADE;

CREATE SEQUENCE IF NOT EXISTS badges_seq;
ALTER SEQUENCE IF EXISTS badges_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS badges (
  id                INT          NOT NULL DEFAULT NEXTVAL('badges_seq'),
  name              VARCHAR(45)  NULL,
  path_img          VARCHAR(255) NULL,
  nb_courses_done   INT          NULL,
  nb_exercices_done INT          NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS users_badges CASCADE;

CREATE TABLE IF NOT EXISTS users_badges (
  account_id INT    NOT NULL,
  badge_id   INT    NULL,
  BIGINT     BIGINT NULL,
  PRIMARY KEY (account_id)
  ,
  CONSTRAINT account_id
  FOREIGN KEY (account_id)
  REFERENCES accounts (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT badge_id
  FOREIGN KEY (badge_id)
  REFERENCES badges (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX badge_id_idx_users_badges ON users_badges (badge_id ASC);

DROP TABLE IF EXISTS moderation_validate CASCADE;

CREATE SEQUENCE IF NOT EXISTS moderation_validate_seq;
ALTER SEQUENCE IF EXISTS moderation_validate_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS moderation_validate (
  id   INT         NOT NULL DEFAULT NEXTVAL('moderation_validate_seq'),
  name VARCHAR(45) NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS exercices_moderation CASCADE;

CREATE TABLE IF NOT EXISTS exercices_moderation (
  exercice_id            INT  NOT NULL,
  moderation_validate_id INT  NULL,
  commentary             TEXT NULL,
  PRIMARY KEY (exercice_id)
  ,
  CONSTRAINT exercice_id
  FOREIGN KEY (exercice_id)
  REFERENCES exercices (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT moderation_validate_id
  FOREIGN KEY (moderation_validate_id)
  REFERENCES moderation_validate (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX moderation_validate_id_idx_exercices_moderation ON exercices_moderation (moderation_validate_id ASC);

DROP TABLE IF EXISTS course_moderation CASCADE;

CREATE TABLE IF NOT EXISTS course_moderation (
  course_id              INT  NOT NULL,
  moderation_validate_id INT  NULL,
  commentary             TEXT NULL,
  PRIMARY KEY (course_id)
  ,
  CONSTRAINT course_id
  FOREIGN KEY (course_id)
  REFERENCES courses (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT moderation_validate_id
  FOREIGN KEY (moderation_validate_id)
  REFERENCES moderation_validate (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

CREATE INDEX moderation_validate_id_idx_course_moderation ON course_moderation (moderation_validate_id ASC);

-- -----------------------------------------------------
-- Set base record
-- -----------------------------------------------------
INSERT INTO avatars (path)
VALUES ('http%3A%2F%2Fwww.freakingnews.com%2Fpictures%2F97500%2FKorean-Elephant-Rocket--97543.jpg');
INSERT INTO groups (name, parent_id) VALUES ('member', 10);
INSERT INTO groups (name, parent_id) VALUES ('administrator', 50);
INSERT INTO groups (name, parent_id) VALUES ('moderator', 30);
INSERT INTO locales (name) VALUES ('FR');
INSERT INTO locales (name) VALUES ('EN');

-- -----------------------------------------------------
-- Set default values
-- -----------------------------------------------------
INSERT INTO accounts (username, password, email, group_id, avatar_id, create_timestamp, last_connect_timestamp, nb_courses_done, nb_exercices_done)
VALUES
  ('Admin', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', 'admin%40codeandlear.com', 2, 1, 1464262190085, 1464262190085,
   0, 0);
INSERT INTO blog_posts_category (name) VALUES ('Default');
INSERT INTO languages (name) VALUES ('C%2B%2B');
INSERT INTO languages (name) VALUES ('JAVA');
INSERT INTO languages (name) VALUES ('C');
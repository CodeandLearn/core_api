-- Creator:       MySQL Workbench 6.3.4/ExportSQLite Plugin 0.1.0
-- Author:        Fabien
-- Caption:       New Model
-- Project:       Name of the project
-- Changed:       2016-02-01 14:36
-- Created:       2015-12-04 17:37
PRAGMA foreign_keys = OFF;

-- Schema: code_and_learn
ATTACH "code_and_learn.sdb" AS "code_and_learn";
BEGIN;
CREATE TABLE "badges"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "name" VARCHAR(45),
  "path_img" VARCHAR(255),
  "nb_courses_done" INTEGER,
  "nb_exercices_done" INTEGER
);
CREATE TABLE "forum_category"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "name" VARCHAR(45)
);
CREATE TABLE "exercices_corrections"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "content" TEXT,
  "timestamp" TIMESTAMP
);
CREATE TABLE "languages"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "name" VARCHAR(45)
);
CREATE TABLE "blog_posts_category"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "name" VARCHAR(45)
);
CREATE TABLE "forum_forums"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "forums_category_id" INTEGER,
  "name" VARCHAR(45),
  "description" TEXT,
  CONSTRAINT "forums_category_id"
    FOREIGN KEY("forums_category_id")
    REFERENCES "forum_category"("id")
);
CREATE INDEX "forum_forums.forums_category_id_idx" ON "forum_forums" ("forums_category_id");
CREATE TABLE "groups"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "name" VARCHAR(45),
  "parent_id" INTEGER
);
CREATE TABLE "scripts"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "content" TEXT,
  "create_timestamp" TIMESTAMP,
  "modify_timestamp" TIMESTAMP
);
CREATE TABLE "locales"(
  "id" INTEGER PRIMARY KEY NOT NULL,
  "name" VARCHAR(45)
);
CREATE TABLE "moderation_validate"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "name" VARCHAR(45)
);
CREATE TABLE "avatars"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "path" VARCHAR(255) NOT NULL
);
CREATE TABLE "logs"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "content" TEXT,
  "script_id" INTEGER,
  "timestamp" TIMESTAMP,
  CONSTRAINT "script_id"
    FOREIGN KEY("script_id")
    REFERENCES "scripts"("id")
);
CREATE INDEX "logs.script_id_idx" ON "logs" ("script_id");
CREATE TABLE "accounts"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "username" VARCHAR(45),
  "password" VARCHAR(255),
  "email" VARCHAR(100),
  "group_id" INTEGER,
  "avatar_id" INTEGER,
  "create_timestamp" TIMESTAMP,
  "last_connect_timestamp" TIMESTAMP,
  "nb_courses_done" INTEGER DEFAULT 0,
  "nb_exercices_done" INTEGER DEFAULT 0,
  CONSTRAINT "group_id"
    FOREIGN KEY("group_id")
    REFERENCES "groups"("id"),
  CONSTRAINT "avatar_id"
    FOREIGN KEY("avatar_id")
    REFERENCES "avatars"("id")
);
CREATE INDEX "accounts.group_id_idx" ON "accounts" ("group_id");
CREATE INDEX "accounts.avatar_id_idx" ON "accounts" ("avatar_id");
CREATE TABLE "blog_posts"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "account_id" INTEGER,
  "locales_id" INTEGER,
  "blog_category_id" INTEGER,
  "title" VARCHAR(45),
  "content" TEXT,
  "create_timestamp" TIMESTAMP,
  "modify_timestamp" TIMESTAMP,
  CONSTRAINT "account_id"
    FOREIGN KEY("account_id")
    REFERENCES "accounts"("id"),
  CONSTRAINT "locales_id"
    FOREIGN KEY("locales_id")
    REFERENCES "locales"("id"),
  CONSTRAINT "blog_category_id"
    FOREIGN KEY("blog_category_id")
    REFERENCES "blog_posts_category"("id")
);
CREATE INDEX "blog_posts.account_d_idx" ON "blog_posts" ("account_id");
CREATE INDEX "blog_posts.locales_id_idx" ON "blog_posts" ("locales_id");
CREATE INDEX "blog_posts.blog_category_id_idx" ON "blog_posts" ("blog_category_id");
CREATE TABLE "forum_subjects"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "forums_forum_id" INTEGER,
  "locales_id" INTEGER,
  "account_id" INTEGER,
  "timestamp" TIMESTAMP,
  "replies" INTEGER,
  "views" INTEGER,
  CONSTRAINT "forums_forum_id"
    FOREIGN KEY("forums_forum_id")
    REFERENCES "forum_forums"("id"),
  CONSTRAINT "locales_id"
    FOREIGN KEY("locales_id")
    REFERENCES "locales"("id"),
  CONSTRAINT "account_id"
    FOREIGN KEY("account_id")
    REFERENCES "accounts"("id")
);
CREATE INDEX "forum_subjects.forums_forum_id_idx" ON "forum_subjects" ("forums_forum_id");
CREATE INDEX "forum_subjects.locales_id_idx" ON "forum_subjects" ("locales_id");
CREATE INDEX "forum_subjects.account_id_idx" ON "forum_subjects" ("account_id");
CREATE TABLE "forum_posts"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "forums_subject_id" INTEGER,
  "account_id" INTEGER,
  "create_timestamp" TIMESTAMP,
  "modify_timestamp" TIMESTAMP,
  "content" TEXT,
  "likes" INTEGER,
  CONSTRAINT "forums_subject_id"
    FOREIGN KEY("forums_subject_id")
    REFERENCES "forum_subjects"("id"),
  CONSTRAINT "account_id"
    FOREIGN KEY("account_id")
    REFERENCES "accounts"("id")
);
CREATE INDEX "forum_posts.forums_subject_id_idx" ON "forum_posts" ("forums_subject_id");
CREATE INDEX "forum_posts.account_id_idx" ON "forum_posts" ("account_id");
CREATE TABLE "blog_posts_comments"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "account_id" INTEGER,
  "blog_post_id" INTEGER,
  "content" TEXT,
  "create_timestamp" TIMESTAMP,
  "modify_timestamp" TIMESTAMP,
  CONSTRAINT "account_id"
    FOREIGN KEY("account_id")
    REFERENCES "accounts"("id"),
  CONSTRAINT "blog_post_id"
    FOREIGN KEY("blog_post_id")
    REFERENCES "blog_posts"("id")
);
CREATE INDEX "blog_posts_comments.account_id_idx" ON "blog_posts_comments" ("account_id");
CREATE INDEX "blog_posts_comments.blog_post_id_idx" ON "blog_posts_comments" ("blog_post_id");
CREATE TABLE "tokens"(
  "account_id" INTEGER PRIMARY KEY NOT NULL,
  "token" VARCHAR(255),
  "ttl" INTEGER,
  CONSTRAINT "account_id"
    FOREIGN KEY("account_id")
    REFERENCES "accounts"("id")
);
CREATE TABLE "courses"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "account_id" INTEGER,
  "locales_id" INTEGER,
  "language_id" INTEGER,
  "title" VARCHAR(45),
  "content" TEXT,
  "create_timestamp" TIMESTAMP,
  "modify_timestamp" TIMESTAMP,
  CONSTRAINT "account_id"
    FOREIGN KEY("account_id")
    REFERENCES "accounts"("id"),
  CONSTRAINT "locales_id"
    FOREIGN KEY("locales_id")
    REFERENCES "locales"("id"),
  CONSTRAINT "language_id"
    FOREIGN KEY("language_id")
    REFERENCES "languages"("id")
);
CREATE INDEX "courses.account_id_idx" ON "courses" ("account_id");
CREATE INDEX "courses.locales_id_idx" ON "courses" ("locales_id");
CREATE INDEX "courses.language_id_idx" ON "courses" ("language_id");
CREATE TABLE "users_badges"(
  "account_id" INTEGER PRIMARY KEY NOT NULL,
  "badge_id" INTEGER,
  "timestamp" TIMESTAMP,
  CONSTRAINT "account_id"
    FOREIGN KEY("account_id")
    REFERENCES "accounts"("id"),
  CONSTRAINT "badge_id"
    FOREIGN KEY("badge_id")
    REFERENCES "badges"("id")
);
CREATE INDEX "users_badges.badge_id_idx" ON "users_badges" ("badge_id");
CREATE TABLE "user_exercises"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "account_id" INTEGER,
  "exercice_id" INTEGER,
  "grade_id" INTEGER,
  CONSTRAINT "account_id"
    FOREIGN KEY("account_id")
    REFERENCES "accounts"("id"),
  CONSTRAINT "exercice_id"
    FOREIGN KEY("exercice_id")
    REFERENCES "exercices"("id"),
  CONSTRAINT "grade_id"
    FOREIGN KEY("grade_id")
    REFERENCES "grades"("id")
);
CREATE INDEX "user_exercises.account_id_idx" ON "user_exercises" ("account_id");
CREATE INDEX "user_exercises.exercice_id_idx" ON "user_exercises" ("exercice_id");
CREATE INDEX "user_exercises.grade_id_idx" ON "user_exercises" ("grade_id");
CREATE TABLE "course_moderation"(
  "course_id" INTEGER PRIMARY KEY NOT NULL,
  "moderation_validate_id" INTEGER,
  "commentary" TEXT,
  CONSTRAINT "course_id"
    FOREIGN KEY("course_id")
    REFERENCES "courses"("id"),
  CONSTRAINT "moderation_validate_id"
    FOREIGN KEY("moderation_validate_id")
    REFERENCES "moderation_validate"("id")
);
CREATE INDEX "course_moderation.moderation_validate_id_idx" ON "course_moderation" ("moderation_validate_id");
CREATE TABLE "grades"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "account_id" INTEGER,
  "exercice_id" INTEGER,
  "value" INTEGER,
  "log_id" INTEGER,
  "timestamp" TIMESTAMP,
  CONSTRAINT "account_id"
    FOREIGN KEY("account_id")
    REFERENCES "accounts"("id"),
  CONSTRAINT "exercice_id"
    FOREIGN KEY("exercice_id")
    REFERENCES "exercices"("id"),
  CONSTRAINT "log_id"
    FOREIGN KEY("log_id")
    REFERENCES "logs"("id")
);
CREATE INDEX "grades.exercice_id_idx" ON "grades" ("exercice_id");
CREATE INDEX "grades.account_id_idx" ON "grades" ("account_id");
CREATE INDEX "grades.log_id_idx" ON "grades" ("log_id");
CREATE TABLE "codes"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "user_exercice_id" INTEGER,
  "content" TEXT,
  "create_timestamp" TIMESTAMP,
  "modify_timestamp" TIMESTAMP,
  CONSTRAINT "user_exercice_id"
    FOREIGN KEY("user_exercice_id")
    REFERENCES "user_exercises"("id")
);
CREATE INDEX "codes.user_exercice_id_idx" ON "codes" ("user_exercice_id");
CREATE TABLE "exercices"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "account_id" INTEGER,
  "course_id" INTEGER,
  "title" VARCHAR(250),
  "instruction" TEXT,
  "script_id" INTEGER,
  "grade_max" INTEGER,
  "correction_id" INTEGER,
  CONSTRAINT "account_id"
    FOREIGN KEY("account_id")
    REFERENCES "accounts"("id"),
  CONSTRAINT "script_id"
    FOREIGN KEY("script_id")
    REFERENCES "scripts"("id"),
  CONSTRAINT "correction_id"
    FOREIGN KEY("correction_id")
    REFERENCES "exercices_corrections"("id"),
  CONSTRAINT "course_id"
    FOREIGN KEY("course_id")
    REFERENCES "courses"("id")
);
CREATE INDEX "exercices.account_id_idx" ON "exercices" ("account_id");
CREATE INDEX "exercices.script_id_idx" ON "exercices" ("script_id");
CREATE INDEX "exercices.correction_id_idx" ON "exercices" ("correction_id");
CREATE INDEX "exercices.course_id_idx" ON "exercices" ("course_id");
CREATE TABLE "courses_comments"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "course_id" INTEGER,
  "account_id" INTEGER,
  "content" TEXT,
  "create_timestamp" TIMESTAMP,
  "modify_timestamp" TIMESTAMP,
  CONSTRAINT "course_id"
    FOREIGN KEY("course_id")
    REFERENCES "courses"("id"),
  CONSTRAINT "account_id"
    FOREIGN KEY("account_id")
    REFERENCES "accounts"("id")
);
CREATE INDEX "courses_comments.course_id_idx" ON "courses_comments" ("course_id");
CREATE INDEX "courses_comments.account_id_idx" ON "courses_comments" ("account_id");
CREATE TABLE "exercices_moderation"(
  "exercice_id" INTEGER PRIMARY KEY NOT NULL,
  "moderation_validate_id" INTEGER,
  "commentary" TEXT,
  CONSTRAINT "exercice_id"
    FOREIGN KEY("exercice_id")
    REFERENCES "exercices"("id"),
  CONSTRAINT "moderation_validate_id"
    FOREIGN KEY("moderation_validate_id")
    REFERENCES "moderation_validate"("id")
);
CREATE INDEX "exercices_moderation.moderation_validate_id_idx" ON "exercices_moderation" ("moderation_validate_id");
CREATE TABLE "exercices_comments"(
  "id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  "exercice_id" INTEGER,
  "account_id" INTEGER,
  "content" TEXT,
  "create_timestamp" TIMESTAMP,
  "modify_timestamp" TIMESTAMP,
  CONSTRAINT "exercice_id"
    FOREIGN KEY("exercice_id")
    REFERENCES "exercices"("id"),
  CONSTRAINT "account_id"
    FOREIGN KEY("account_id")
    REFERENCES "accounts"("id")
);
CREATE INDEX "exercices_comments.exercice_id_idx" ON "exercices_comments" ("exercice_id");
CREATE INDEX "exercices_comments.account_id_idx" ON "exercices_comments" ("account_id");
COMMIT;

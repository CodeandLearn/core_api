package Plugin.Course.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Http.Map;
import Core.Model;
import Core.Singleton.ConfigSingleton;
import Plugin.Course.Obj.CourseCommentObj;
import Plugin.Course.Obj.CourseObj;

public class GetCourse extends Model {
    @Override
    protected Object setData(Map result) {
        return null;
    }

    protected void setGet(String request) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (Map result : sql.getResultSet()) {
            CourseObj courseObj = new CourseObj();
            courseObj.course.id = result.getInt("courses.id");
            courseObj.course.account_id = result.getInt("courses.account_id");
            courseObj.course.content = result.getString("courses.content");
            courseObj.course.create_timestamp = result.getLong("courses.create_timestamp");
            courseObj.course.language_id = result.getInt("courses.language_id");
            courseObj.course.language.id = result.getInt("languages.id");
            courseObj.course.language.name = result.getString("languages.name");
            courseObj.course.locales_id = result.getInt("courses.locales_id");
            courseObj.course.local.id = result.getInt("locales.id");
            courseObj.course.local.name = result.getString("locales.name");
            courseObj.course.modify_timestamp = result.getLong("courses.modify_timestamp");
            courseObj.course.title = result.getString("courses.title");
            courseObj.course.moderation.course_id = result.getInt("course_moderation.course_id");
            courseObj.course.moderation.validate = result.getInt("course_moderation.validate");
            courseObj.course.moderation.commentary = result.getString("course_moderation.commentary");
            courseObj.course.account.id = result.getInt("accounts.id");
            courseObj.course.account.username = result.getString("accounts.username");
            courseObj.course.account.group.id = result.getInt("groups.id");
            courseObj.course.account.group.name = result.getString("groups.name");
            courseObj.course.account.group.parent_id = result.getInt("groups.parent_id");
            courseObj.course.account.avatar.id = result.getInt("avatars.id");
            courseObj.course.account.avatar.path = ConfigSingleton.getInstance().getString("url_assets_protocol") + "://" + ConfigSingleton.getInstance().getString("url_assets") + "/assets/images/avatar/" + result.getString("avatars.path");
            SQLRequest commentSql = new SQLRequest("SELECT * FROM courses_comments, accounts, groups, avatars\n" +
                    "WHERE courses_comments.account_id=accounts.id\n" +
                    "AND groups.id=accounts.group_id\n" +
                    "AND avatars.id=accounts.avatar_id AND courses_comments.course_id=" + result.get("courses.id"));
            commentSql.select();
            for (Map comment : commentSql.getResultSet()) {
                CourseCommentObj courseCommentObj = new CourseCommentObj();
                courseCommentObj.account_id = comment.getInt("courses_comments.account_id");
                courseCommentObj.content = comment.getString("courses_comments.content");
                courseCommentObj.course_id = comment.getInt("courses_comments.course_id");
                courseCommentObj.create_timestamp = comment.getLong("courses_comments.create_timestamp");
                courseCommentObj.id = comment.getInt("courses_comments.id");
                courseCommentObj.modify_timestamp = comment.getLong("courses_comments.modify_timestamp");
                courseCommentObj.user.id = comment.getInt("accounts.id");
                courseCommentObj.user.username = comment.getString("accounts.username");
                courseCommentObj.user.group.id = comment.getInt("groups.id");
                courseCommentObj.user.group.name = comment.getString("groups.name");
                courseCommentObj.user.group.parent_id = comment.getInt("groups.parent_id");
                courseCommentObj.user.avatar.id = comment.getInt("avatars.id");
                courseCommentObj.user.avatar.path = ConfigSingleton.getInstance().getString("url_assets_protocol") + "://" + ConfigSingleton.getInstance().getString("url_assets") + "/assets/images/avatar/" + result.getString("avatars.path");
                courseObj.comments.add(courseCommentObj);
            }
            data.add(courseObj);
        }
    }

    public GetCourse getCourse() {
        setGet("SELECT * FROM courses, accounts, avatars, groups, languages, locales, course_moderation\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.locales_id=locales.id\n" +
                "AND courses.language_id=languages.id\n" +
                "AND course_moderation.course_id=courses.id\n" +
                "AND course_moderation.validate>0\n" +
                "ORDER BY courses.id DESC");
        return this;
    }

    public GetCourse getCourseModeration() {
        setGet("SELECT * FROM courses, accounts, avatars, groups, languages, locales, course_moderation\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.locales_id=locales.id\n" +
                "AND courses.language_id=languages.id\n" +
                "AND course_moderation.course_id=courses.id\n" +
                "AND course_moderation.validate=0\n" +
                "ORDER BY courses.id DESC");
        return this;
    }

    public GetCourse getCourseModerationId(int course_id) {
        make.add(course_id);
        setGet(SQL.make("SELECT * FROM courses, accounts, avatars, groups, languages, locales, course_moderation\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.locales_id=locales.id\n" +
                "AND courses.language_id=languages.id\n" +
                "AND course_moderation.course_id=courses.id\n" +
                "AND courses.id=? ORDER BY courses.id DESC", make.toArray()));
        return this;
    }

    public GetCourse getAccountCourseId(int author_id, int course_id) {
        make.add(author_id);
        make.add(course_id);
        setGet(SQL.make("SELECT * FROM courses, accounts, avatars, groups, languages, locales, course_moderation\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.locales_id=locales.id\n" +
                "AND courses.language_id=languages.id\n" +
                "AND course_moderation.course_id=courses.id\n" +
                "AND accounts.id=?\n" +
                "AND courses.id=? ORDER BY courses.id DESC", make.toArray()));
        return this;
    }

    public GetCourse getCourseWithId(int course_id) {
        make.add(course_id);
        setGet(SQL.make("SELECT * FROM courses, accounts, avatars, groups, languages, locales, course_moderation\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.locales_id=locales.id\n" +
                "AND courses.language_id=languages.id\n" +
                "AND course_moderation.course_id=courses.id\n" +
                "AND course_moderation.validate>0\n" +
                "AND courses.id=? ORDER BY courses.id DESC", make.toArray()));
        return this;
    }

    public GetCourse getCourseWithLimit(int limit) {
        make.add(limit);
        setGet(SQL.make("SELECT * FROM courses, accounts, avatars, groups, languages, locales, course_moderation\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.locales_id=locales.id\n" +
                "AND courses.language_id=languages.id\n" +
                "AND course_moderation.course_id=courses.id\n" +
                "AND course_moderation.validate>0\n" +
                "ORDER BY courses.id DESC LIMIT ?", make.toArray()));
        return this;
    }

    public GetCourse getAccountCourses(int author_id) {
        make.add(author_id);
        setGet(SQL.make("SELECT * FROM courses, accounts, avatars, groups, languages, locales, course_moderation\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.locales_id=locales.id\n" +
                "AND courses.language_id=languages.id\n" +
                "AND course_moderation.course_id=courses.id\n" +
                "AND courses.account_id=? ORDER BY courses.id DESC", make.toArray()));
        return this;
    }

    public GetCourse getCourseByAuthorId(int author_id) {
        make.add(author_id);
        setGet(SQL.make("SELECT * FROM courses, accounts, avatars, groups, languages, locales, course_moderation\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.locales_id=locales.id\n" +
                "AND courses.language_id=languages.id\n" +
                "AND course_moderation.course_id=courses.id\n" +
                "AND course_moderation.validate>0\n" +
                "AND courses.account_id=? ORDER BY courses.id DESC", make.toArray()));
        return this;
    }

    public GetCourse getCourseByLanguageId(int language_id) {
        make.add(language_id);
        setGet(SQL.make("SELECT * FROM courses, accounts, avatars, groups, languages, locales, course_moderation\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.locales_id=locales.id\n" +
                "AND courses.language_id=languages.id\n" +
                "AND course_moderation.course_id=courses.id\n" +
                "AND course_moderation.validate>0\n" +
                "AND courses.language_id=? ORDER BY courses.id DESC", make.toArray()));
        return this;
    }

    public GetCourse getCourseByLocalesId(int locales_id) {
        make.add(locales_id);
        setGet(SQL.make("SELECT * FROM courses, accounts, avatars, groups, languages, locales, course_moderation\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.locales_id=locales.id\n" +
                "AND courses.language_id=languages.id\n" +
                "AND course_moderation.course_id=courses.id\n" +
                "AND course_moderation.validate>0\n" +
                "AND courses.locales_id=? ORDER BY courses.id DESC", make.toArray()));
        return this;
    }

    public GetCourse getCourseByTitle(String title) {
        make.add(title);
        setGet(SQL.make("SELECT * FROM courses, accounts, avatars, groups, languages, locales, course_moderation\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.locales_id=locales.id\n" +
                "AND courses.language_id=languages.id\n" +
                "AND course_moderation.course_id=courses.id\n" +
                "AND course_moderation.validate>0\n" +
                "AND courses.title=? ORDER BY courses.id DESC", make.toArray()));
        return this;
    }
}

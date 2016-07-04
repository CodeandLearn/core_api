package Plugin.Course.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Model;
import Plugin.Course.Obj.CourseCommentObj;
import Plugin.Course.Obj.CourseObj;

import java.util.HashMap;

public class GetCourse extends Model {
    protected void setGet(String request) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (HashMap<String, Object> result : sql.getResultSet()) {
            CourseObj courseObj = new CourseObj();
            courseObj.course.id = (Integer) result.get("courses.id");
            courseObj.course.account_id = (Integer) result.get("courses.account_id");
            courseObj.course.content = (String) result.get("courses.content");
            courseObj.course.create_timestamp = (Long) result.get("courses.create_timestamp");
            courseObj.course.language_id = (Integer) result.get("courses.language_id");
            courseObj.course.locales_id = (Integer) result.get("courses.locales_id");
            courseObj.course.modify_timestamp = (Long) result.get("courses.modify_timestamp");
            courseObj.course.title = (String) result.get("courses.title");
            courseObj.course.account.id = (Integer) result.get("accounts.id");
            courseObj.course.account.username = (String) result.get("accounts.username");
            courseObj.course.account.group.id = (Integer) result.get("groups.id");
            courseObj.course.account.group.name = (String) result.get("groups.name");
            courseObj.course.account.group.parent_id = (Integer) result.get("groups.parent_id");
            courseObj.course.account.avatar.id = (Integer) result.get("avatars.id");
            courseObj.course.account.avatar.path = (String) result.get("avatars.path");
            SQLRequest commentSql = new SQLRequest("SELECT courses_comments.id\"courses_comments.id\",\n" +
                    "courses_comments.course_id\"courses_comments.course_id\",\n" +
                    "courses_comments.account_id\"courses_comments.account_id\",\n" +
                    "courses_comments.content\"courses_comments.content\",\n" +
                    "courses_comments.create_timestamp\"courses_comments.create_timestamp\",\n" +
                    "courses_comments.modify_timestamp\"courses_comments.modify_timestamp\",\n" +
                    "accounts.username\"accounts.username\",\n" +
                    "accounts.id\"accounts.id\",\n" +
                    "accounts.group_id\"accounts.group_id\",\n" +
                    "accounts.avatar_id\"accounts.avatar_id\",\n" +
                    "accounts.last_connect_timestamp\"accounts.last_connect_timestamp\",\n" +
                    "accounts.create_timestamp\"accounts.create_timestamp\",\n" +
                    "accounts.nb_exercices_done\"accounts.nb_exercices_done\",\n" +
                    "accounts.nb_courses_done\"accounts.nb_courses_done\",\n" +
                    "groups.id\"groups.id\",\n" +
                    "groups.name\"groups.name\",\n" +
                    "groups.parent_id\"groups.parent_id\",\n" +
                    "avatars.id\"avatars.id\",\n" +
                    "avatars.path\"avatars.path\"\n" +
                    "FROM courses_comments, accounts, groups, avatars\n" +
                    "WHERE courses_comments.account_id=accounts.id\n" +
                    "AND groups.id=accounts.group_id\n" +
                    "AND avatars.id=accounts.avatar_id AND courses_comments.course_id=" + result.get("courses.id"));
            commentSql.select();
            for (HashMap<String, Object> comment : commentSql.getResultSet()) {
                CourseCommentObj courseCommentObj = new CourseCommentObj();
                courseCommentObj.account_id = (Integer) comment.get("courses_comments.account_id");
                courseCommentObj.content = (String) comment.get("courses_comments.content");
                courseCommentObj.course_id = (Integer) comment.get("courses_comments.course_id");
                courseCommentObj.create_timestamp = (Long) comment.get("courses_comments.create_timestamp");
                courseCommentObj.id = (Integer) comment.get("courses_comments.id");
                courseCommentObj.modify_timestamp = (Long) comment.get("courses_comments.modify_timestamp");
                courseCommentObj.user.id = (Integer) comment.get("accounts.id");
                courseCommentObj.user.username = (String) comment.get("accounts.username");
                courseCommentObj.user.group.id = (Integer) comment.get("groups.id");
                courseCommentObj.user.group.name = (String) comment.get("groups.name");
                courseCommentObj.user.group.parent_id = (Integer) comment.get("groups.parent_id");
                courseCommentObj.user.avatar.id = (Integer) comment.get("avatars.id");
                courseCommentObj.user.avatar.path = (String) comment.get("avatars.path");
                courseObj.comments.add(courseCommentObj);
            }
            data.add(courseObj);
        }
    }

    public GetCourse getCourse(String socket) {
        setGet("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM courses, accounts, avatars, groups\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "ORDER BY courses.id ASC");
        return this;
    }

    public GetCourse getCourseWithId(String socket, int id) {
        make.add(id);
        setGet(SQL.make("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM courses, accounts, avatars, groups\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.id=? ORDER BY courses.id ASC", make.toArray()));
        return this;
    }

    public GetCourse getCourseWithLimit(String socket, int limit) {
        make.add(limit);
        setGet(SQL.make("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM courses, accounts, avatars, groups\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "ORDER BY courses.id ASC LIMIT ?", make.toArray()));
        return this;
    }

    public GetCourse getCourseByAuthorId(String socket, int author_id) {
        make.add(author_id);
        setGet(SQL.make("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM courses, accounts, avatars, groups\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.account_id=? ORDER BY courses.id ASC", make.toArray()));
        return this;
    }

    public GetCourse getCourseByLanguageId(String socket, int language_id) {
        make.add(language_id);
        setGet(SQL.make("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM courses, accounts, avatars, groups\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.language_id=? ORDER BY courses.id ASC", make.toArray()));
        return this;
    }

    public GetCourse getCourseByLocalesId(String socket, int locales_id) {
        make.add(locales_id);
        setGet(SQL.make("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM courses, accounts, avatars, groups\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.locales_id=? ORDER BY courses.id ASC", make.toArray()));
        return this;
    }

    public GetCourse getCourseByTitle(String socket, String title) {
        make.add(title);
        setGet(SQL.make("SELECT courses.id\"courses.id\",\n" +
                "courses.account_id\"courses.account_id\",\n" +
                "courses.locales_id\"courses.locales_id\",\n" +
                "courses.language_id\"courses.language_id\",\n" +
                "courses.title\"courses.title\",\n" +
                "courses.content\"courses.content\",\n" +
                "courses.create_timestamp\"courses.create_timestamp\",\n" +
                "courses.modify_timestamp\"courses.modify_timestamp\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM courses, accounts, avatars, groups\n" +
                "WHERE accounts.id=courses.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND courses.title=? ORDER BY courses.id ASC", make.toArray()));
        return this;
    }
}

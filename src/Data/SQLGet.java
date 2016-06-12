package Data;

/**
 * Created by teddy on 03/04/2016.
 */
public class SQLGet {
    public static String COURSE = "SELECT courses.id'courses.id',\n" +
            "courses.account_id'courses.account_id',\n" +
            "courses.locales_id'courses.locales_id',\n" +
            "courses.language_id'courses.language_id',\n" +
            "courses.title'courses.title',\n" +
            "courses.content'courses.content',\n" +
            "courses.create_timestamp'courses.create_timestamp',\n" +
            "courses.modify_timestamp'courses.modify_timestamp'\n" +
            "FROM courses";
    public static String COURSE_COMMENT = "SELECT courses_comments.id'courses_comments.id',\n" +
            "courses_comments.course_id'courses_comments.course_id',\n" +
            "courses_comments.account_id'courses_comments.account_id',\n" +
            "courses_comments.content'courses_comments.content',\n" +
            "courses_comments.create_timestamp'courses_comments.create_timestamp',\n" +
            "courses_comments.modify_timestamp'courses_comments.modify_timestamp'\n" +
            "FROM courses_comments WHERE courses_comments.id = courses_comments.id";
    public static String LANGUAGE = "SELECT languages.id'languages.id',\n" +
            "languages.name'languages.name'\n" +
            "FROM languages";
}

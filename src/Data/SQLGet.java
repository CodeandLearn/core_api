package Data;

/**
 * Created by teddy on 03/04/2016.
 */
public class SQLGet {
    public static String BLOG = "SELECT blog_posts.account_id'blog_posts.account_id',\n" +
            "blog_posts.blog_category_id'blog_posts.blog_category_id',\n" +
            "blog_posts.content'blog_posts.content',\n" +
            "blog_posts.create_timestamp'blog_posts.create_timestamp',\n" +
            "blog_posts.id'blog_posts.id',\n" +
            "blog_posts.locales_id'blog_posts.locales_id',\n" +
            "blog_posts.create_timestamp'blog_posts.create_timestamp',\n" +
            "blog_posts.modify_timestamp'blog_posts.modify_timestamp',\n" +
            "blog_posts.title'blog_posts.title',\n" +
            "blog_posts_category.id'blog_posts_category.id',\n" +
            "blog_posts_category.name'blog_posts_category.name',\n" +
            "locales.id'locales.id',\n" +
            "locales.name'locales.name',\n" +
            "accounts.id'accounts.id',\n" +
            "accounts.username'accounts.username',\n" +
            "avatars.id'avatars.id',\n" +
            "avatars.path'avatars.path',\n" +
            "groups.id'groups.id',\n" +
            "groups.name'groups.name',\n" +
            "groups.parent_id'groups.parent_id'\n" +
            "FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
            "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
            "AND locales.id=blog_posts.locales_id\n" +
            "AND accounts.id=blog_posts.account_id\n" +
            "AND avatars.id=accounts.avatar_id\n" +
            "AND groups.id=accounts.group_id";
    public static String BLOG_POST = "SELECT blog_posts.account_id'blog_posts.account_id',\n" +
            "blog_posts.blog_category_id'blog_posts.blog_category_id',\n" +
            "blog_posts.content'blog_posts.content',\n" +
            "blog_posts.create_timestamp'blog_posts.create_timestamp',\n" +
            "blog_posts.id'blog_posts.id',\n" +
            "blog_posts.locales_id'blog_posts.locales_id',\n" +
            "blog_posts.modify_timestamp'blog_posts.modify_timestamp',\n" +
            "blog_posts.title'blog_posts.title',\n" +
            "locales.id'locales.id',\n" +
            "locales.name'locales.name',\n" +
            "blog_posts_category.id'blog_posts_category.id',\n" +
            "blog_posts_category.name'blog_posts_category.name'\n" +
            "FROM blog_posts, locales, blog_posts_category\n" +
            "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
            "AND blog_posts.locales_id=locales.id";
    public static String BLOG_CATEGORY = "SELECT blog_posts_category.id'blog_posts_category.id',\n" +
            "blog_posts_category.name'blog_posts_category.name'\n" +
            "FROM blog_posts_category";
    public static String BLOG_COMMENT = "SELECT blog_posts_comments.content'blog_posts_comments.content',\n" +
            "blog_posts_comments.id'blog_posts_comments.id',\n" +
            "blog_posts_comments.create_timestamp'blog_posts_comments.create_timestamp',\n" +
            "blog_posts_comments.modify_timestamp'blog_posts_comments.modify_timestamp',\n" +
            "blog_posts_comments.account_id'blog_posts_comments.account_id',\n" +
            "blog_posts_comments.blog_post_id'blog_posts_comments.blog_post_id',\n" +
            "accounts.username'accounts.username',\n" +
            "accounts.id'accounts.id',\n" +
            "accounts.group_id'accounts.group_id',\n" +
            "accounts.avatar_id'accounts.avatar_id',\n" +
            "accounts.last_connect_timestamp'accounts.last_connect_timestamp',\n" +
            "accounts.create_timestamp'accounts.create_timestamp',\n" +
            "accounts.nb_exercices_done'accounts.nb_exercices_done',\n" +
            "accounts.nb_courses_done'accounts.nb_courses_done',\n" +
            "groups.id'groups.id',\n" +
            "groups.name'groups.name',\n" +
            "groups.parent_id'groups.parent_id',\n" +
            "avatars.id'avatars.id',\n" +
            "avatars.path'avatars.path'\n" +
            "FROM blog_posts_comments, accounts, groups, avatars\n" +
            "WHERE blog_posts_comments.account_id=accounts.id\n" +
            "AND groups.id=accounts.id\n" +
            "AND avatars.id=accounts.avatar_id";
    public static String ACCOUNT = "SELECT accounts.username'accounts.username',\n" +
            "accounts.id'accounts.id',\n" +
            "accounts.email'accounts.email',\n" +
            "accounts.avatar_id'accounts.avatar_id',\n" +
            "accounts.group_id'accounts.group_id',\n" +
            "accounts.create_timestamp'accounts.create_timestamp',\n" +
            "accounts.last_connect_timestamp'accounts.last_connect_timestamp',\n" +
            "accounts.nb_courses_done'accounts.nb_courses_done',\n" +
            "accounts.nb_exercices_done'accounts.nb_exercices_done',\n" +
            "groups.id'groups.id',\n" +
            "groups.name'groups.name',\n" +
            "groups.parent_id'groups.parent_id',\n" +
            "avatars.id'avatars.id',\n" +
            "avatars.path'avatars.path'\n" +
            "FROM accounts, groups, avatars\n" +
            "WHERE accounts.avatar_id=avatars.id\n" +
            "AND accounts.group_id=groups.id";
    public static String ACCOUNT_LOGIN = "SELECT accounts.id'accounts.id',\n" +
            "accounts.username'accounts.username',\n" +
            "accounts.password'accounts.password',\n" +
            "accounts.email'accounts.email',\n" +
            "accounts.group_id'accounts.group_id'\n" +
            "FROM accounts";
    public static String ACCOUNT_GROUP = "SELECT groups.id'groups.id',\n" +
            "groups.name'groups.name',\n" +
            "groups.parent_id'groups.parent_id'\n" +
            "FROM groups";
    public static String ACCOUNT_AVATAR = "SELECT avatars.id'avatars.id',\n" +
            "avatars.path'avatars.path'\n" +
            "FROM avatars";
    public static String LOCALE = "SELECT locales.id'locales.id',\n" +
            "locales.name'locales.name'\n" +
            "FROM locales";
    public static String COURSE = "SELECT courses.id'courses.id',\n" +
            "courses.account_id'courses.account_id',\n" +
            "courses.locales_id'courses.locales_id',\n" +
            "courses.language_id'courses.language_id',\n" +
            "courses.title'courses.title',\n" +
            "courses.content'courses.content',\n" +
            "courses.create_timestamp'courses.create_timestamp',\n" +
            "courses.modify_timestamp'courses.modify_timestamp',\n" +
            "FROM courses WHERE courses.id = courses.id";
    public static String COURSE_COMMENT = "SELECT courses_comments.id'courses_comments.id',\n" +
            "courses_comments.course_id'courses_comments.course_id',\n" +
            "courses_comments.account_id'courses_comments.account_id',\n" +
            "courses_comments.content'courses_comments.content',\n" +
            "courses_comments.create_timestamp'courses_comments.create_timestamp',\n" +
            "courses_comments.modify_timestamp'courses_comments.modify_timestamp',\n" +
            "FROM courses_comments WHERE courses_comments.id = courses_comments.id";
    public static String LANGUAGE = "SELECT languages.id'languages.id,\n" +
            "languages.name'languages.name',\n" +
            "FROM languages WHERE languages.id = languages.id";
}

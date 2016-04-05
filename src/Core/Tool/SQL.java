package Core.Tool;

/**
 * Created by teddy on 03/04/2016.
 */
public class SQL {
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
            "AND groups.id=accounts.group_id\n" +
            "ORDER BY blog_posts.id DESC";
    public static String COMMENT = "SELECT blog_posts_comments.content'blog_posts_comments.content',\n" +
            "blog_posts_comments.id'blog_posts_comments.id',\n" +
            "blog_posts_comments.create_timestamp'blog_posts_comments.create_timestamp',\n" +
            "blog_posts_comments.modify_timestamp'blog_posts_comments.modify_timestamp',\n" +
            "accounts.username'accounts.username',\n" +
            "accounts.id'accounts.id',\n" +
            "groups.id'groups.id',\n" +
            "groups.name'groups.name',\n" +
            "groups.parent_id'groups.parent_id',\n" +
            "avatars.id'avatars.id',\n" +
            "avatars.path'avatars.path'\n" +
            "FROM blog_posts_comments, accounts, groups, avatars\n" +
            "WHERE blog_posts_comments.account_id=accounts.id\n" +
            "AND groups.id=accounts.id\n" +
            "AND avatars.id=accounts.avatar_id\n" +
            "AND blog_posts_comments.blog_post_id=";
    public static String USER = "SELECT accounts.username'accounts.username',\n" +
            "accounts.id'accounts.id',\n" +
            "accounts.email'accounts.email',\n" +
            "groups.id'groups.id',\n" +
            "groups.name'groups.name',\n" +
            "groups.parent_id'groups.parent_id',\n" +
            "avatars.id'avatars.id',\n" +
            "avatars.path'avatars.path'\n" +
            "FROM accounts, groups, avatars\n" +
            "WHERE accounts.id=";
}

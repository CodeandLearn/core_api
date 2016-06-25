package Plugin.Blog.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Model;
import Plugin.Blog.Obj.BlogCommentObj;
import Plugin.Blog.Obj.BlogObj;

import java.util.HashMap;

/**
 * Created by teddy on 03/04/2016.
 */
public class GetPosts extends Model {
    protected void setGet(String request) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (HashMap<String, Object> result : sql.getResultSet()) {
            BlogObj blogObj = new BlogObj();
            blogObj.article.account_id = (Integer) result.get("blog_posts.account_id");
            blogObj.article.blog_category_id = (Integer) result.get("blog_posts.blog_category_id");
            blogObj.article.content = (String) result.get("blog_posts.content");
            blogObj.article.create_timestamp = (Long) result.get("blog_posts.create_timestamp");
            blogObj.article.id = (Integer) result.get("blog_posts.id");
            blogObj.article.locales_id = (Integer) result.get("blog_posts.locales_id");
            blogObj.article.modify_timestamp = (Long) result.get("blog_posts.modify_timestamp");
            blogObj.article.title = (String) result.get("blog_posts.title");
            blogObj.article.category.id = (Integer) result.get("blog_posts_category.id");
            blogObj.article.category.name = (String) result.get("blog_posts_category.name");
            blogObj.article.locale.id = (Integer) result.get("locales.id");
            blogObj.article.locale.name = (String) result.get("locales.name");
            blogObj.article.account.id = (Integer) result.get("accounts.id");
            blogObj.article.account.username = (String) result.get("accounts.username");
            blogObj.article.account.group.id = (Integer) result.get("groups.id");
            blogObj.article.account.group.name = (String) result.get("groups.name");
            blogObj.article.account.group.parent_id = (Integer) result.get("groups.parent_id");
            blogObj.article.account.avatar.id = (Integer) result.get("avatars.id");
            blogObj.article.account.avatar.path = (String) result.get("avatars.path");
            SQLRequest commentSql = new SQLRequest("SELECT blog_posts_comments.content\"blog_posts_comments.content\",\n" +
                    "blog_posts_comments.id\"blog_posts_comments.id\",\n" +
                    "blog_posts_comments.create_timestamp\"blog_posts_comments.create_timestamp\",\n" +
                    "blog_posts_comments.modify_timestamp\"blog_posts_comments.modify_timestamp\",\n" +
                    "blog_posts_comments.account_id\"blog_posts_comments.account_id\",\n" +
                    "blog_posts_comments.blog_post_id\"blog_posts_comments.blog_post_id\",\n" +
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
                    "FROM blog_posts_comments, accounts, groups, avatars\n" +
                    "WHERE blog_posts_comments.account_id=accounts.id\n" +
                    "AND groups.id=accounts.group_id\n" +
                    "AND avatars.id=accounts.avatar_id AND blog_posts_comments.blog_post_id=" + result.get("blog_posts.id"));
            commentSql.select();
            for (HashMap<String, Object> comment : commentSql.getResultSet()) {
                BlogCommentObj blogCommentObj = new BlogCommentObj();
                blogCommentObj.content = (String) comment.get("blog_posts_comments.content");
                blogCommentObj.create_timestamp = (Long) comment.get("blog_posts_comments.create_timestamp");
                blogCommentObj.id = (Integer) comment.get("blog_posts_comments.id");
                blogCommentObj.modify_timestamp = (Long) comment.get("blog_posts_comments.modify_timestamp");
                blogCommentObj.user.id = (Integer) comment.get("accounts.id");
                blogCommentObj.user.username = (String) comment.get("accounts.username");
                blogCommentObj.user.group.id = (Integer) comment.get("groups.id");
                blogCommentObj.user.group.name = (String) comment.get("groups.name");
                blogCommentObj.user.group.parent_id = (Integer) comment.get("groups.parent_id");
                blogCommentObj.user.avatar.id = (Integer) comment.get("avatars.id");
                blogCommentObj.user.avatar.path = (String) comment.get("avatars.path");
                blogObj.comments.add(blogCommentObj);
            }
            data.add(blogObj);
        }
    }

    public GetPosts getBlog(String socket) {
        setGet("SELECT blog_posts.account_id\"blog_posts.account_id\",\n" +
                "blog_posts.blog_category_id\"blog_posts.blog_category_id\",\n" +
                "blog_posts.content\"blog_posts.content\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.id\"blog_posts.id\",\n" +
                "blog_posts.locales_id\"blog_posts.locales_id\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.modify_timestamp\"blog_posts.modify_timestamp\",\n" +
                "blog_posts.title\"blog_posts.title\",\n" +
                "blog_posts_category.id\"blog_posts_category.id\",\n" +
                "blog_posts_category.name\"blog_posts_category.name\",\n" +
                "locales.id\"locales.id\",\n" +
                "locales.name\"locales.name\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id");
        return this;
    }

    public GetPosts getBlogWithLimit(String socket, int limit) {
        make.add(limit);
        setGet(SQL.make("SELECT blog_posts.account_id\"blog_posts.account_id\",\n" +
                "blog_posts.blog_category_id\"blog_posts.blog_category_id\",\n" +
                "blog_posts.content\"blog_posts.content\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.id\"blog_posts.id\",\n" +
                "blog_posts.locales_id\"blog_posts.locales_id\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.modify_timestamp\"blog_posts.modify_timestamp\",\n" +
                "blog_posts.title\"blog_posts.title\",\n" +
                "blog_posts_category.id\"blog_posts_category.id\",\n" +
                "blog_posts_category.name\"blog_posts_category.name\",\n" +
                "locales.id\"locales.id\",\n" +
                "locales.name\"locales.name\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id LIMIT ?", make.toArray()));
        return this;
    }

    public GetPosts getBlogByAuthoName(String socket, String author) {
        make.add(author);
        setGet(SQL.make("SELECT blog_posts.account_id\"blog_posts.account_id\",\n" +
                "blog_posts.blog_category_id\"blog_posts.blog_category_id\",\n" +
                "blog_posts.content\"blog_posts.content\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.id\"blog_posts.id\",\n" +
                "blog_posts.locales_id\"blog_posts.locales_id\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.modify_timestamp\"blog_posts.modify_timestamp\",\n" +
                "blog_posts.title\"blog_posts.title\",\n" +
                "blog_posts_category.id\"blog_posts_category.id\",\n" +
                "blog_posts_category.name\"blog_posts_category.name\",\n" +
                "locales.id\"locales.id\",\n" +
                "locales.name\"locales.name\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id AND accounts.username=?", make.toArray()));
        return this;
    }

    public GetPosts getBlogByAuthorId(String socket, int id) {
        make.add(id);
        setGet(SQL.make("SELECT blog_posts.account_id\"blog_posts.account_id\",\n" +
                "blog_posts.blog_category_id\"blog_posts.blog_category_id\",\n" +
                "blog_posts.content\"blog_posts.content\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.id\"blog_posts.id\",\n" +
                "blog_posts.locales_id\"blog_posts.locales_id\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.modify_timestamp\"blog_posts.modify_timestamp\",\n" +
                "blog_posts.title\"blog_posts.title\",\n" +
                "blog_posts_category.id\"blog_posts_category.id\",\n" +
                "blog_posts_category.name\"blog_posts_category.name\",\n" +
                "locales.id\"locales.id\",\n" +
                "locales.name\"locales.name\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id AND accounts.id=?", make.toArray()));
        return this;
    }

    public GetPosts getBlogByCategory(String socket, String category) {
        make.add(category);
        setGet(SQL.make("SELECT blog_posts.account_id\"blog_posts.account_id\",\n" +
                "blog_posts.blog_category_id\"blog_posts.blog_category_id\",\n" +
                "blog_posts.content\"blog_posts.content\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.id\"blog_posts.id\",\n" +
                "blog_posts.locales_id\"blog_posts.locales_id\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.modify_timestamp\"blog_posts.modify_timestamp\",\n" +
                "blog_posts.title\"blog_posts.title\",\n" +
                "blog_posts_category.id\"blog_posts_category.id\",\n" +
                "blog_posts_category.name\"blog_posts_category.name\",\n" +
                "locales.id\"locales.id\",\n" +
                "locales.name\"locales.name\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id AND blog_posts_category.name=?", make.toArray()));
        return this;
    }

    public GetPosts getBlogByCategoryId(String socket, int id) {
        make.add(id);
        setGet(SQL.make("SELECT blog_posts.account_id\"blog_posts.account_id\",\n" +
                "blog_posts.blog_category_id\"blog_posts.blog_category_id\",\n" +
                "blog_posts.content\"blog_posts.content\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.id\"blog_posts.id\",\n" +
                "blog_posts.locales_id\"blog_posts.locales_id\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.modify_timestamp\"blog_posts.modify_timestamp\",\n" +
                "blog_posts.title\"blog_posts.title\",\n" +
                "blog_posts_category.id\"blog_posts_category.id\",\n" +
                "blog_posts_category.name\"blog_posts_category.name\",\n" +
                "locales.id\"locales.id\",\n" +
                "locales.name\"locales.name\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id AND blog_posts_category.id=?", make.toArray()));
        return this;
    }

    public GetPosts getBlogById(String socket, int id) {
        make.add(id);
        setGet(SQL.make("SELECT blog_posts.account_id\"blog_posts.account_id\",\n" +
                "blog_posts.blog_category_id\"blog_posts.blog_category_id\",\n" +
                "blog_posts.content\"blog_posts.content\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.id\"blog_posts.id\",\n" +
                "blog_posts.locales_id\"blog_posts.locales_id\",\n" +
                "blog_posts.create_timestamp\"blog_posts.create_timestamp\",\n" +
                "blog_posts.modify_timestamp\"blog_posts.modify_timestamp\",\n" +
                "blog_posts.title\"blog_posts.title\",\n" +
                "blog_posts_category.id\"blog_posts_category.id\",\n" +
                "blog_posts_category.name\"blog_posts_category.name\",\n" +
                "locales.id\"locales.id\",\n" +
                "locales.name\"locales.name\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.username\"accounts.username\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\"\n" +
                "FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id AND blog_posts.id=?", make.toArray()));
        return this;
    }
}

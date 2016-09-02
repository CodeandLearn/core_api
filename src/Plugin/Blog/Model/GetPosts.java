package Plugin.Blog.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Http.Map;
import Core.Model;
import Plugin.Blog.Obj.BlogCommentObj;
import Plugin.Blog.Obj.BlogObj;

/**
 * Created by teddy on 03/04/2016.
 */
public class GetPosts extends Model {
    @Override
    protected Object setData(Map result) {
        return null;
    }

    protected void setGet(String request) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (Map result : sql.getResultSet()) {
            BlogObj blogObj = new BlogObj();
            blogObj.article.account_id = result.getInt("blog_posts.account_id");
            blogObj.article.blog_category_id = result.getInt("blog_posts.blog_category_id");
            blogObj.article.content = result.getString("blog_posts.content");
            blogObj.article.content_prev = result.getString("blog_posts.content.prev");
            blogObj.article.create_timestamp = result.getLong("blog_posts.create_timestamp");
            blogObj.article.id = result.getInt("blog_posts.id");
            blogObj.article.locales_id = result.getInt("blog_posts.locales_id");
            blogObj.article.modify_timestamp = result.getLong("blog_posts.modify_timestamp");
            blogObj.article.title = result.getString("blog_posts.title");
            blogObj.article.category.id = result.getInt("blog_posts_category.id");
            blogObj.article.category.name = result.getString("blog_posts_category.name");
            blogObj.article.locale.id = result.getInt("locales.id");
            blogObj.article.locale.name = result.getString("locales.name");
            blogObj.article.account.id = result.getInt("accounts.id");
            blogObj.article.account.username = result.getString("accounts.username");
            blogObj.article.account.group.id = result.getInt("groups.id");
            blogObj.article.account.group.name = result.getString("groups.name");
            blogObj.article.account.group.parent_id = result.getInt("groups.parent_id");
            blogObj.article.account.avatar.id = result.getInt("avatars.id");
            blogObj.article.account.avatar.path = result.getString("avatars.path");
            SQLRequest commentSql = new SQLRequest("SELECT * FROM blog_posts_comments, accounts, groups, avatars\n" +
                    "WHERE blog_posts_comments.account_id=accounts.id\n" +
                    "AND groups.id=accounts.group_id\n" +
                    "AND avatars.id=accounts.avatar_id AND blog_posts_comments.blog_post_id=" + result.get("blog_posts.id"));
            commentSql.select();
            for (Map comment : commentSql.getResultSet()) {
                BlogCommentObj blogCommentObj = new BlogCommentObj();
                blogCommentObj.content = comment.getString("blog_posts_comments.content");
                blogCommentObj.create_timestamp = comment.getLong("blog_posts_comments.create_timestamp");
                blogCommentObj.id = comment.getInt("blog_posts_comments.id");
                blogCommentObj.modify_timestamp = comment.getLong("blog_posts_comments.modify_timestamp");
                blogCommentObj.user.id = comment.getInt("accounts.id");
                blogCommentObj.user.username = comment.getString("accounts.username");
                blogCommentObj.user.group.id = comment.getInt("groups.id");
                blogCommentObj.user.group.name = comment.getString("groups.name");
                blogCommentObj.user.group.parent_id = comment.getInt("groups.parent_id");
                blogCommentObj.user.avatar.id = comment.getInt("avatars.id");
                blogCommentObj.user.avatar.path = comment.getString("avatars.path");
                blogObj.comments.add(blogCommentObj);
            }
            data.add(blogObj);
        }
    }

    public GetPosts getBlog() {
        setGet("SELECT * FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id");
        return this;
    }

    public GetPosts getBlogWithLimit(int limit) {
        make.add(limit);
        setGet(SQL.make("SELECT * FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id LIMIT ?", make.toArray()));
        return this;
    }

    public GetPosts getBlogByAuthoName(String author) {
        make.add(author);
        setGet(SQL.make("SELECT * FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id AND accounts.username=?", make.toArray()));
        return this;
    }

    public GetPosts getBlogByAuthorId(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id AND accounts.id=?", make.toArray()));
        return this;
    }

    public GetPosts getBlogByCategory(String category) {
        make.add(category);
        setGet(SQL.make("SELECT * FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id AND blog_posts_category.name=?", make.toArray()));
        return this;
    }

    public GetPosts getBlogByCategoryId(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id AND blog_posts_category.id=?", make.toArray()));
        return this;
    }

    public GetPosts getBlogById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM blog_posts, blog_posts_category, locales, accounts, avatars, groups\n" +
                "WHERE blog_posts.blog_category_id=blog_posts_category.id\n" +
                "AND locales.id=blog_posts.locales_id\n" +
                "AND accounts.id=blog_posts.account_id\n" +
                "AND avatars.id=accounts.avatar_id\n" +
                "AND groups.id=accounts.group_id AND blog_posts.id=?", make.toArray()));
        return this;
    }
}

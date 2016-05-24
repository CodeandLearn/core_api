package Plugin.Blog;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLGet;
import Obj.BlogCommentObj;

/**
 * Created by teddy on 03/04/2016.
 */
public class GetBlog extends Model {
    public GetBlog(String socket) {
        setData(socket, "", "");
    }

    public GetBlog(String socket, String extra) {
        setData(socket, "AND " + extra, "");
    }

    public GetBlog(String socket, String extra, int limit) {
        if (!extra.equals("")) {
            setData(socket, "AND " + extra, "LIMIT " + limit);
        } else {
            setData(socket, "", "LIMIT " + limit);
        }
    }

    private void setData(String socket, String extra, String limit) {
        SQLite sql = new SQLite(SQLGet.BLOG + " " + extra + " ORDER BY blog_posts.id DESC " + limit);
        sql.select();
        if (sql.getResultSet().size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (int i = 0; i < sql.getResultSet().size(); i++) {
                // DEBUG
                System.out.println(i + " - " + sql.getResultSet().get(i));
                // DEBUG
                BlogObj blogObj = new BlogObj();
                blogObj.article.account_id = (int) sql.getResultSet().get(i).get("blog_posts.account_id");
                blogObj.article.blog_category_id = (int) sql.getResultSet().get(i).get("blog_posts.blog_category_id");
                blogObj.article.content = (String) sql.getResultSet().get(i).get("blog_posts.content");
                blogObj.article.create_timestamp = (long) sql.getResultSet().get(i).get("blog_posts.create_timestamp");
                blogObj.article.id = (int) sql.getResultSet().get(i).get("blog_posts.id");
                blogObj.article.locales_id = (int) sql.getResultSet().get(i).get("blog_posts.locales_id");
                blogObj.article.modify_timestamp = (long) sql.getResultSet().get(i).get("blog_posts.modify_timestamp");
                blogObj.article.title = (String) sql.getResultSet().get(i).get("blog_posts.title");
                blogObj.article.category.id = (int) sql.getResultSet().get(i).get("blog_posts_category.id");
                blogObj.article.category.name = (String) sql.getResultSet().get(i).get("blog_posts_category.name");
                blogObj.article.locale.id = (int) sql.getResultSet().get(i).get("locales.id");
                blogObj.article.locale.name = (String) sql.getResultSet().get(i).get("locales.name");
                blogObj.article.account.id = (int) sql.getResultSet().get(i).get("accounts.id");
                blogObj.article.account.username = (String) sql.getResultSet().get(i).get("accounts.username");
                blogObj.article.account.group.id = (int) sql.getResultSet().get(i).get("groups.id");
                blogObj.article.account.group.name = (String) sql.getResultSet().get(i).get("groups.name");
                blogObj.article.account.group.parent_id = (int) sql.getResultSet().get(i).get("groups.parent_id");
                blogObj.article.account.avatar.id = (int) sql.getResultSet().get(i).get("avatars.id");
                blogObj.article.account.avatar.path = (String) sql.getResultSet().get(i).get("avatars.path");
                SQLite commentSql = new SQLite(SQLGet.BLOG_COMMENT + " AND blog_posts_comments.blog_post_id=" + sql.getResultSet().get(i).get("blog_posts.id"));
                commentSql.select();
                for (int x = 0; x < commentSql.getResultSet().size(); x++) {
                    // DEBUG
                    System.out.println(x + " - " + commentSql.getResultSet().get(x));
                    // DEBUG
                    BlogCommentObj blogCommentObj = new BlogCommentObj();
                    blogCommentObj.content = (String) commentSql.getResultSet().get(x).get("blog_posts_comments.content");
                    blogCommentObj.create_timestamp = (long) commentSql.getResultSet().get(x).get("blog_posts_comments.create_timestamp");
                    blogCommentObj.id = (int) commentSql.getResultSet().get(x).get("blog_posts_comments.id");
                    blogCommentObj.modify_timestamp = (long) commentSql.getResultSet().get(x).get("blog_posts_comments.modify_timestamp");
                    blogCommentObj.user.id = (int) commentSql.getResultSet().get(x).get("accounts.id");
                    blogCommentObj.user.username = (String) commentSql.getResultSet().get(x).get("accounts.username");
                    blogCommentObj.user.group.id = (int) commentSql.getResultSet().get(x).get("groups.id");
                    blogCommentObj.user.group.name = (String) commentSql.getResultSet().get(x).get("groups.name");
                    blogCommentObj.user.group.parent_id = (int) commentSql.getResultSet().get(x).get("groups.parent_id");
                    blogCommentObj.user.avatar.id = (int) commentSql.getResultSet().get(x).get("avatars.id");
                    blogCommentObj.user.avatar.path = (String) commentSql.getResultSet().get(x).get("avatars.path");
                    blogObj.comments.add(blogCommentObj);
                }
                data.add(blogObj);
            }
        }
    }
}

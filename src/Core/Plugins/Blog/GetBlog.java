package Core.Plugins.Blog;

import Core.Objs.BlogCommentObj;
import Core.Plugins.Default.Default;
import Core.Datas.SQLGet;
import Core.Tools.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by teddy on 03/04/2016.
 */
public class GetBlog extends Default {
    private ArrayList<BlogObj> data = new ArrayList<>();

    public GetBlog(HttpServletRequest request, HttpServletResponse reply) {
        super(request, reply);
        setData("", "");
    }

    public GetBlog(HttpServletRequest request, HttpServletResponse reply, String extra) {
        super(request, reply);
        setData("AND " + extra, "");
    }

    public GetBlog(HttpServletRequest request, HttpServletResponse reply, String extra, int limit) {
        super(request, reply);
        if (!extra.equals("")) {
            setData("AND " + extra, "LIMIT " + limit);
        } else {
            setData("", "LIMIT " + limit);
        }
    }

    private void setData(String extra, String limit) {
        SQLite sql = new SQLite(SQLGet.BLOG + " " + extra + " ORDER BY blog_posts.id DESC " + limit);
        sql.select();
        for (int i = 0; i < sql.getResultSet().size(); i++) {
            // DEBUG
            System.out.println(i + " - " + sql.getResultSet().get(i));
            // DEBUG
            BlogObj blogObj = new BlogObj();
            blogObj.article.account_id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts.account_id"));
            blogObj.article.blog_category_id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts.blog_category_id"));
            blogObj.article.content = sql.getResultSet().get(i).get("blog_posts.content");
            blogObj.article.create_timestamp = Long.parseLong(sql.getResultSet().get(i).get("blog_posts.create_timestamp"));
            blogObj.article.id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts.id"));
            blogObj.article.locales_id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts.locales_id"));
            blogObj.article.modify_timestamp = Long.parseLong(sql.getResultSet().get(i).get("blog_posts.modify_timestamp"));
            blogObj.article.title = sql.getResultSet().get(i).get("blog_posts.title");
            blogObj.article.category.id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts_category.id"));
            blogObj.article.category.name = sql.getResultSet().get(i).get("blog_posts_category.name");
            blogObj.article.locale.id = Integer.parseInt(sql.getResultSet().get(i).get("locales.id"));
            blogObj.article.locale.name = sql.getResultSet().get(i).get("locales.name");
            blogObj.article.account.id = Integer.parseInt(sql.getResultSet().get(i).get("accounts.id"));
            blogObj.article.account.username = sql.getResultSet().get(i).get("accounts.username");
            blogObj.article.account.group.id = Integer.parseInt(sql.getResultSet().get(i).get("groups.id"));
            blogObj.article.account.group.name = sql.getResultSet().get(i).get("groups.name");
            blogObj.article.account.group.parent_id = Integer.parseInt(sql.getResultSet().get(i).get("groups.parent_id"));
            blogObj.article.account.avatar.id = Integer.parseInt(sql.getResultSet().get(i).get("avatars.id"));
            blogObj.article.account.avatar.path = sql.getResultSet().get(i).get("avatars.path");
            SQLite commentSql = new SQLite(SQLGet.BLOG_COMMENT + " AND blog_posts_comments.blog_post_id=" + Integer.parseInt(sql.getResultSet().get(i).get("blog_posts.id")));
            commentSql.select();
            for (int x = 0; x < commentSql.getResultSet().size(); x++) {
                // DEBUG
                System.out.println(x + " - " + commentSql.getResultSet().get(x));
                // DEBUG
                BlogCommentObj blogCommentObj = new BlogCommentObj();
                blogCommentObj.content = commentSql.getResultSet().get(x).get("blog_posts_comments.content");
                blogCommentObj.create_timestamp = Long.parseLong(commentSql.getResultSet().get(x).get("blog_posts_comments.create_timestamp"));
                blogCommentObj.id = Integer.parseInt(commentSql.getResultSet().get(x).get("blog_posts_comments.id"));
                blogCommentObj.modify_timestamp = Long.parseLong(commentSql.getResultSet().get(x).get("blog_posts_comments.modify_timestamp"));
                blogCommentObj.user.id = Integer.parseInt(commentSql.getResultSet().get(x).get("accounts.id"));
                blogCommentObj.user.username = commentSql.getResultSet().get(x).get("accounts.username");
                blogCommentObj.user.group.id = Integer.parseInt(commentSql.getResultSet().get(x).get("groups.id"));
                blogCommentObj.user.group.name = commentSql.getResultSet().get(x).get("groups.name");
                blogCommentObj.user.group.parent_id = Integer.parseInt(commentSql.getResultSet().get(x).get("groups.parent_id"));
                blogCommentObj.user.avatar.id = Integer.parseInt(commentSql.getResultSet().get(x).get("avatars.id"));
                blogCommentObj.user.avatar.path = commentSql.getResultSet().get(x).get("avatars.path");
                blogObj.comments.add(blogCommentObj);
            }
            data.add(blogObj);
        }
    }

    public ArrayList<BlogObj> getData() {
        return data;
    }
}

package Core.Plugin.Blog;

import Core.Plugin.Blog.Obj.CommentObj;
import Core.Plugin.Default.Default;
import Core.Tool.SQL;
import Core.Tool.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by teddy on 03/04/2016.
 */
public class Get extends Default {
    private ArrayList<BlogObj> data = new ArrayList<>();

    public Get(HttpServletRequest request, HttpServletResponse reply) throws SQLException {
        super(request, reply);
        SQLite sql = new SQLite(SQL.BLOG);
        sql.select();
        int i = 0;
        while (i < sql.getResultSet().size()) {
            System.out.println(i + " - " + sql.getResultSet().get(i));
            BlogObj blogObj = new BlogObj();
            blogObj.article.account_id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts.account_id"));
            blogObj.article.blog_category_id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts.blog_category_id"));
            blogObj.article.content = sql.getResultSet().get(i).get("blog_posts.content");
            blogObj.article.create_timestamp = Long.parseLong(sql.getResultSet().get(i).get("blog_posts.create_timestamp"));
            blogObj.article.id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts.id"));
            blogObj.article.locales_id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts.locales_id"));
            blogObj.article.modify_timestamp = Long.parseLong(sql.getResultSet().get(i).get("blog_posts.modify_timestamp"));
            blogObj.article.title = sql.getResultSet().get(i).get("blog_posts.title");
            blogObj.category.id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts_category.id"));
            blogObj.category.name = sql.getResultSet().get(i).get("blog_posts_category.name");
            blogObj.local.id = Integer.parseInt(sql.getResultSet().get(i).get("locales.id"));
            blogObj.local.name = sql.getResultSet().get(i).get("locales.name");
            blogObj.user.id = Integer.parseInt(sql.getResultSet().get(i).get("accounts.id"));
            blogObj.user.username = sql.getResultSet().get(i).get("accounts.username");
            SQLite commentSql = new SQLite(SQL.COMMENT + Integer.parseInt(sql.getResultSet().get(i).get("blog_posts.id")));
            commentSql.select();
            int x = 0;
            while (x < commentSql.getResultSet().size()) {
                System.out.println(x + " - " + commentSql.getResultSet().get(x));
                CommentObj commentObj = new CommentObj();
                commentObj.content = commentSql.getResultSet().get(x).get("blog_posts_comments.content");
                commentObj.create_timestamp = Long.parseLong(commentSql.getResultSet().get(x).get("blog_posts_comments.create_timestamp"));
                commentObj.id = Integer.parseInt(commentSql.getResultSet().get(x).get("blog_posts_comments.id"));
                commentObj.modify_timestamp = Long.parseLong(commentSql.getResultSet().get(x).get("blog_posts_comments.modify_timestamp"));
                commentObj.user.id = Integer.parseInt(commentSql.getResultSet().get(x).get("accounts.id"));
                commentObj.user.username = commentSql.getResultSet().get(x).get("accounts.username");
                blogObj.comments.add(commentObj);
                x++;
            }
            data.add(blogObj);
            i++;
        }
    }

    public ArrayList<BlogObj> getData() {
        return data;
    }
}

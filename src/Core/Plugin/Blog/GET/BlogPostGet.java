package Core.Plugin.Blog.GET;

import Core.Plugin.Blog.Obj.BlogPostObj;
import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogPostGet extends Default {
    private int limit;
    private BlogPostObj[] obj;

    public BlogPostGet(HttpServletRequest request, HttpServletResponse reply, int limit) {
        super(request, reply);
        this.limit = limit;
        sqlBlogPost();
    }

    public BlogPostObj[] getObj() {
        return obj;
    }

    public void sqlBlogPost() {
        int i = 0;
        ResultSet result;
        SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
        try {
            if (limit != 0) {
                result = sql.selectDB(
                        "SELECT (SELECT COUNT(id) FROM blog_posts)'nb', * FROM blog_posts ORDER BY id DESC LIMIT "
                                + limit);
                obj = new BlogPostObj[(result.getInt("nb") > limit) ? limit : result.getInt("nb")];
            } else {
                result = sql
                        .selectDB("SELECT (SELECT COUNT(id) FROM blog_posts)'nb', * FROM blog_posts ORDER BY id DESC");
                obj = new BlogPostObj[result.getInt("nb")];
            }
            while (result.next()) {
                obj[i] = new BlogPostObj();
                obj[i].id = result.getInt("id");
                obj[i].account_id = result.getInt("account_id");
                obj[i].locales_id = result.getInt("locales_id");
                obj[i].blog_category_id = result.getInt("blog_category_id");
                obj[i].title = result.getString("title");
                obj[i].content = result.getString("content");
                obj[i].create_timestamp = result.getTimestamp("create_timestamp");
                obj[i].modify_timestamp = result.getTimestamp("modify_timestamp");
                ++i;
            }
            if (i == 0) {
                reply.sendError(404, "Posts not found !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sql.closeDB();
    }
}

package Core.Plugin.Blog.POST;

import Core.Plugin.Blog.Obj.BlogCategoryObj;
import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogPostCategoryCreate extends Default {
    public BlogPostCategoryCreate(HttpServletRequest request, HttpServletResponse reply,
                                  BlogCategoryObj blogCategoryObj) {
        super(request, reply);
        try {
            sqlBlogPostCategoryCreate(blogCategoryObj);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sqlBlogPostCategoryCreate(BlogCategoryObj blogCategoryObj) throws SQLException, IOException {
        SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
        ResultSet result = sql
                .selectDB("SELECT name FROM blog_posts_category WHERE name = \"" + blogCategoryObj.name + "\"");
        if (result.next()) {
            reply.sendError(600, "Already exists");
        } else {
            sql.insertDB("INSERT INTO blog_posts_category (name) VALUES (\"" + blogCategoryObj.name + "\")");
        }
        sql.closeDB();
    }
}

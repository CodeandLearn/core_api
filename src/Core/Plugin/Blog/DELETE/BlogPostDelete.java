package Core.Plugin.Blog.DELETE;

import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlogPostDelete extends Default {
    public BlogPostDelete(HttpServletRequest request, HttpServletResponse reply, int id) {
        super(request, reply);
        sqlBlogPostDelete(id);
    }

    private void sqlBlogPostDelete(int id) {
        SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
        sql.deleteDB("DELETE FROM blog_posts WHERE id=" + id);
        sql.deleteDB("DELETE FROM blog_posts_comments WHERE blog_post_id=" + id);
        sql.closeDB();
    }
}

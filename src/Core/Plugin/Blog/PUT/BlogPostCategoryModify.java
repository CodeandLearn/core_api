package Core.Plugin.Blog.PUT;

import Core.Plugin.Blog.Obj.BlogCategoryObj;
import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlogPostCategoryModify extends Default {
    public BlogPostCategoryModify(HttpServletRequest request, HttpServletResponse reply, int id,
                                  BlogCategoryObj blogCategoryObj) {
        super(request, reply);
        sqlBlogPostCategoryModify(id, blogCategoryObj);
    }

    private void sqlBlogPostCategoryModify(int id, BlogCategoryObj blogCategoryObj) {
        SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
        sql.updateDB("UPDATE blog_posts_category SET name=\"" + blogCategoryObj.name + "\" WHERE id=" + id);
        sql.closeDB();
    }
}

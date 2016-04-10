package Core.Plugins.Blog;

import Core.Datas.SQLPost;
import Core.Objs.BlogCategoryObj;
import Core.Plugins.Default.Default;
import Core.Tools.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by teddy on 08/04/2016.
 */
public class PostBlogCategory extends Default {
    public PostBlogCategory(HttpServletRequest request, HttpServletResponse reply, BlogCategoryObj blogCategoryObj) {
        super(request, reply);
        insertData(blogCategoryObj);
    }

    private void insertData(BlogCategoryObj blogCategoryObj) {
        SQLite sql = new SQLite(SQLPost.BLOG_CATEGORY + "(name) VALUES ('" + blogCategoryObj.name.replace("\"", "\\\"") + "'");
        sql.insert();
    }
}

package Core.Plugins.Blog;

import Core.Datas.SQLPut;
import Core.Objs.BlogCategoryObj;
import Core.Plugins.Default.Default;
import Core.Tools.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by teddy on 09/04/2016.
 */
public class PutBlogCategory extends Default {
    public PutBlogCategory(HttpServletRequest request, HttpServletResponse reply, int id, BlogCategoryObj blogCategoryObj) {
        super(request, reply);
        updateData(id, blogCategoryObj);
    }

    private void updateData(int id, BlogCategoryObj blogCategoryObj) {
        SQLite sql = new SQLite(SQLPut.BLOG_CATEGORY
                + "name=\"" + blogCategoryObj.name.replace("\"", "\\\"") + "\""
                + " WHERE id=" + id);
        sql.update();
    }
}

package Core.Plugins.Blog;

import Core.Datas.SQLDelete;
import Core.Plugins.Default.Default;
import Core.Tools.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by teddy on 09/04/2016.
 */
public class DeleteBlogCategory extends Default {
    public DeleteBlogCategory(HttpServletRequest request, HttpServletResponse reply, int id) {
        super(request, reply);
        deleteData(id);
    }

    private void deleteData(int id) {
        SQLite sql = new SQLite(SQLDelete.BLOG_CATEGORY + "id=" + id);
        sql.delete();
    }
}

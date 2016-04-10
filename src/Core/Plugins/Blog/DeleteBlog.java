package Core.Plugins.Blog;

import Core.Datas.SQLDelete;
import Core.Plugins.Default.Default;
import Core.Tools.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by teddy on 09/04/2016.
 */
public class DeleteBlog extends Default {
    public DeleteBlog(HttpServletRequest request, HttpServletResponse reply, int id) {
        super(request, reply);
        deleteData(id);
    }

    private void deleteData(int id) {
        SQLite sql_com = new SQLite(SQLDelete.BLOG_COMMENT + "blog_post_id=" + id);
        SQLite sql_post = new SQLite(SQLDelete.BLOG_POST + "id=" + id);
        sql_com.delete();
        sql_post.delete();
    }
}

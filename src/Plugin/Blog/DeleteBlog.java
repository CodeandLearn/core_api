package Plugin.Blog;

import Core.Database.SQLite;
import Core.Model;
import Data.SQLDelete;

/**
 * Created by teddy on 09/04/2016.
 */
public class DeleteBlog extends Model {
    public DeleteBlog(String socket, int id) {
        SQLite sql_com = new SQLite(SQLDelete.BLOG_COMMENT + "blog_post_id=" + id);
        SQLite sql_post = new SQLite(SQLDelete.BLOG_POST + "id=" + id);
        sql_com.delete();
        sql_post.delete();
    }
}

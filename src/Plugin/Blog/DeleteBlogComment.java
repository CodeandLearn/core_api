package Plugin.Blog;

import Core.Database.SQLite;
import Core.Model;
import Data.SQLDelete;

/**
 * Created by teddy on 09/04/2016.
 */
public class DeleteBlogComment extends Model {
    public DeleteBlogComment(String socket, int id) {
        SQLite sql = new SQLite(SQLDelete.BLOG_COMMENT + "id=" + id);
        sql.delete();
    }
}

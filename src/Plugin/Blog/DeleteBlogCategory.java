package Plugin.Blog;

import Core.Database.SQLite;
import Core.Model;
import Data.SQLDelete;

/**
 * Created by teddy on 09/04/2016.
 */
public class DeleteBlogCategory extends Model {
    public DeleteBlogCategory(String socket, int id) {
        SQLite sql = new SQLite(SQLDelete.BLOG_CATEGORY + "id=" + id);
        sql.delete();
    }
}

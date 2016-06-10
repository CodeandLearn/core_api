package Plugin.Blog;

import Core.Database.SQLite;
import Core.Model;
import Data.SQLPut;
import org.json.JSONObject;

/**
 * Created by teddy on 09/04/2016.
 */
public class PutBlog extends Model {
    public PutBlog(String socket, int id, JSONObject jsonObject) {
        long timestamp = System.currentTimeMillis();
        SQLite sql = new SQLite(SQLPut.BLOG_POST
                + ", locales_id=" + jsonObject.getInt("locales_id")
                + ", blog_category_id=" + jsonObject.getInt("blog_category_id")
                + ", title=\"" + jsonObject.getString("title").replace("\"", "\\\"") + "\""
                + ", content=\"" + jsonObject.getString("content").replace("\"", "\\\"") + "\""
                + ", modify_timestamp=" + timestamp
                + " WHERE id=" + id);
        sql.update();
    }
}

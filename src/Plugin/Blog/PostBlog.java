package Plugin.Blog;

import Core.Database.SQLite;
import Core.Model;
import Data.SQLPost;
import org.json.JSONObject;

/**
 * Created by teddy on 08/04/2016.
 */
public class PostBlog extends Model {
    public PostBlog(String socket, JSONObject jsonObject, int account_id) {
        long timestamp = System.currentTimeMillis();
        SQLite sql = new SQLite(SQLPost.BLOG_POST + "(account_id, locales_id, blog_category_id, title, content, create_timestamp, modify_timestamp) VALUES ("
                + account_id + ", "
                + jsonObject.getInt("locales_id") + ", "
                + jsonObject.getInt("blog_category_id") + ", "
                + "\"" + jsonObject.getString("title").replace("\"", "\\\"") + "\", "
                + "\"" + jsonObject.getString("content").replace("\"", "\\\"") + "\", "
                + timestamp + ", "
                + timestamp + ")");
        sql.insert();
    }
}

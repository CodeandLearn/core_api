package Plugin.Blog;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLPost;
import org.json.JSONObject;

/**
 * Created by teddy on 08/04/2016.
 */
public class PostBlogComment extends Model {
    public PostBlogComment(String socket, JSONObject jsonObject, int account_id) {
        long timestamp = System.currentTimeMillis();
        SQLite sql = new SQLite(SQLPost.BLOG_COMMENT + "(account_id, blog_post_id, content, create_timestamp, modify_timestamp) VALUES ("
                + account_id + ", "
                + jsonObject.getInt("blog_post_id") + ", "
                + "\"" + jsonObject.getString("content").replace("\"", "\\\"") + "\", "
                + timestamp + ", "
                + timestamp + ")");
        sql.insert();
    }
}

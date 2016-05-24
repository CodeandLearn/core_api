package Plugin.Blog;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLPut;
import org.json.JSONObject;

/**
 * Created by teddy on 09/04/2016.
 */
public class PutBlogComment extends Model {
    public PutBlogComment(String socket, int id, JSONObject jsonObject) {
        long timestamp = System.currentTimeMillis();
        SQLite sql = new SQLite(SQLPut.BLOG_COMMENT
                + "blog_post_id=" + jsonObject.getInt("blog_post_id")
                + "content=\"" + jsonObject.getString("content").replace("\"", "\\\"") + "\""
                + "modify_timestamp=" + timestamp
                + " WHERE id=" + id);
        sql.update();
        setCode(socket, Code.OK);
    }
}

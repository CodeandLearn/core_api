package Plugin.Blog;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLPost;
import org.json.JSONObject;

/**
 * Created by teddy on 08/04/2016.
 */
public class PostBlogCategory extends Model {
    public PostBlogCategory(String socket, JSONObject jsonObject) {
        SQLite sql = new SQLite(SQLPost.BLOG_CATEGORY + "(name) VALUES ('" + jsonObject.getString("name").replace("\"", "\\\"") + "'");
        sql.insert();
    }
}

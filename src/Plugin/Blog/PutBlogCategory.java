package Plugin.Blog;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLPut;
import org.json.JSONObject;

/**
 * Created by teddy on 09/04/2016.
 */
public class PutBlogCategory extends Model {
    public PutBlogCategory(String socket, int id, JSONObject jsonObject) {
        SQLite sql = new SQLite(SQLPut.BLOG_CATEGORY
                + "name=\"" + jsonObject.getString("name").replace("\"", "\\\"") + "\""
                + " WHERE id=" + id);
        sql.update();
        setCode(socket, Code.OK);
    }
}

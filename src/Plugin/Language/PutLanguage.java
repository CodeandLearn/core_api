package Plugin.Language;

import Core.Database.SQLite;
import Core.Model;
import Data.SQLPut;
import org.json.JSONObject;

/**
 * Created by Fabien on 06/05/2016.
 */
public class PutLanguage extends Model {
    public PutLanguage(String socket, int id, JSONObject jsonObject) {
        SQLite sql = new SQLite(SQLPut.LANGUAGE
                + ", name=\"" + jsonObject.getString("name").replace("\"", "\\\"") + "\""
                + " WHERE id=" + id);
        sql.update();
        setNoReturnValue(socket);
    }
}

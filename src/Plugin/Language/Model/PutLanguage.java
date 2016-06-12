package Plugin.Language.Model;

import Core.Database.SQL;
import Core.Model;
import org.json.JSONObject;

/**
 * Created by Fabien on 06/05/2016.
 */
public class PutLanguage extends Model {
    public PutLanguage putLanguage(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("name"));
        make.add(id);
        setPut(socket, SQL.make("UPDATE languages SET name=? WHERE id=?", make.toArray()));
        return this;
    }
}

package Plugin.Language.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import org.json.JSONObject;

/**
 * Created by Fabien on 06/05/2016.
 */
public class PostLanguage extends Model {
    public PostLanguage postLanguage(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getString("name"));
        setPost(SQL.make("INSERT INTO languages (name) VALUES (?)", make.toArray()));
        return this;
    }

    @Override
    protected Object setData(Map result) {
        return null;
    }
}

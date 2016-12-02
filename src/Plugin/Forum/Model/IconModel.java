package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumIconObj;
import org.json.JSONObject;

/**
 * Created by Sheol on 30/11/2016.
 */
public class IconModel extends Model {
    @Override
    protected Object setData(Map result) {
        ForumIconObj forumIconObj = new ForumIconObj();
        forumIconObj.path = result.getString("forum_icons.path");
        forumIconObj.id = result.getInt("forum_icons.id");
        return forumIconObj;
    }

    public IconModel getIcons() {
        setGet("SELECT * FROM forum_icons");
        return this;
    }

    public IconModel getIconById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM forum_icons WHERE id=?", make.toArray()));
        return this;
    }

    public IconModel postIcon(JSONObject jsonObject) {
        make.add(jsonObject.getString("path"));
        setPost(SQL.make("INSERT INTO forum_icons (path) VALUES (?)", make.toArray()));
        return this;
    }

    public IconModel putIcon(int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("path"));
        make.add(id);
        setPost(SQL.make("UPDATE forum_icons SET path=? WHERE id=?", make.toArray()));
        return this;
    }

    public IconModel deleteIcon(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM forum_icons WHERE id=?", make.toArray()));
        return this;
    }
}

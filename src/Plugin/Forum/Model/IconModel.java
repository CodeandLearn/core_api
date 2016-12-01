package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumIconObj;

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
}

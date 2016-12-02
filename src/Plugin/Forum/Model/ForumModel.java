package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumForumsObj;
import org.json.JSONObject;

/**
 * Created by Sheol on 30/11/2016.
 */
public class ForumModel extends Model {
    @Override
    protected Object setData(Map result) {
        ForumForumsObj forumForumsObj = new ForumForumsObj();
        forumForumsObj.description = result.getString("forum_forums.description");
        forumForumsObj.forum_category_id = result.getInt("forum_forums.forum_category_id");
        forumForumsObj.id = result.getInt("forum_forums.id");
        forumForumsObj.icon_id = result.getInt("forum_forums.forum_icon_id");
        forumForumsObj.position = result.getInt("forum_forums.position");
        forumForumsObj.title = result.getString("forum_forums.title");
        forumForumsObj.icon.path = result.getString("forum_icons.path");
        forumForumsObj.icon.id = result.getInt("forum_icons.id");
        return forumForumsObj;
    }

    public ForumModel getForums() {
        setGet("SELECT * FROM forum_forums, forum_icons WHERE forum_forums.forum_icon_id=forum_icons.id");
        return this;
    }

    public ForumModel getForumsOrderByPosition() {
        setGet("SELECT * FROM forum_forums, forum_icons WHERE forum_forums.forum_icon_id=forum_icons.id ORDER BY forum_forums.position");
        return this;
    }

    public ForumModel getForumById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM forum_forums, forum_icons WHERE forum_forums.forum_icon_id=forum_icons.id AND forum_forums.id=?", make.toArray()));
        return this;
    }

    public ForumModel getForumByCategoryId(int category_id) {
        make.add(category_id);
        setGet(SQL.make("SELECT * FROM forum_forums, forum_icons WHERE forum_forums.forum_icon_id=forum_icons.id AND forum_forums.forum_category_id=?", make.toArray()));
        return this;
    }

    public ForumModel postForum(JSONObject jsonObject) {
        make.add(jsonObject.getInt("forum_category_id"));
        make.add(jsonObject.getInt("forum_icon_id"));
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("description"));
        make.add(jsonObject.getInt("position"));
        setPost(SQL.make("INSERT INTO forum_forums (forum_category_id, forum_icon_id, title, description, position) VALUES (?, ?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public ForumModel putForum(int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("forum_category_id"));
        make.add(jsonObject.getInt("forum_icon_id"));
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("description"));
        make.add(jsonObject.getInt("position"));
        make.add(id);
        setPut(SQL.make("UPDATE forum_forums SET forum_category_id=?, forum_icon_id=?, title=?, description=?, position=? WHERE id=?", make.toArray()));
        return this;
    }

    public ForumModel deleteForum(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM forum_forums WHERE id=?", make.toArray()));
        return this;
    }
}

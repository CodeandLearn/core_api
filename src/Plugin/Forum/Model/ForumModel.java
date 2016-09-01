package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumObj;
import org.json.JSONObject;

/**
 * Created by moran on 9/1/2016.
 */
public class ForumModel extends Model {
    @Override
    protected Object setData(Map result) {
        ForumObj fObj = new ForumObj();
        fObj.id = result.getInt("id");
        fObj.forums_category_id = result.getInt("forums_category_id");
        fObj.name = result.getString("name");
        fObj.description = result.getString("description");
        return fObj;
    }

    public ForumModel getForums(String socket, int forum_category_id) {
        make.add(forum_category_id);
        setGet(SQL.make("SELECT * FROM forum_forums WHERE forums_category_id = ?", make.toArray()));
        return this;
    }

    public ForumModel insert(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getInt("forums_category_id"));
        make.add(jsonObject.getString("name"));
        make.add(jsonObject.getString("description"));
        setPost(SQL.make("INSERT INTO forum_forum (forums_category_id, name, description) VALUES (?, ?, ?)", make.toArray()));
        return this;
    }

    public ForumModel update(String socket, int id, JSONObject jsonObject){
        make.add(jsonObject.getInt("forums_category_id"));
        make.add(jsonObject.getString("name"));
        make.add(jsonObject.getString("description"));
        make.add(id);
        setPut(SQL.make("UPDATE forum_forums SET forums_category_id=?, name=?, description=? WHERE id=?", make.toArray()));
        return this;
    }

    public ForumModel delete(String socket, int id){
        make.add(id);
        setDelete(SQL.make("DELETE FROM forum_forums WHERE id=?", make.toArray()));
        return this;
    }

    public ForumModel deleteAll(String socket, int category_id){

        make.add(category_id);
        setDelete(SQL.make("DELETE FROM forum_forums WHERE forum_category_id=?", make.toArray()));
        return this;
    }
}

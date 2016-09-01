package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumPostObj;
import org.json.JSONObject;

/**
 * Created by moran on 9/1/2016.
 */
public class ForumPostModel extends Model {
    @Override
    protected Object setData(Map result) {
        ForumPostObj fpObj = new ForumPostObj();
        fpObj.id = result.getInt("id");
        fpObj.forums_subject_id = result.getInt("forum_subject_id");
        fpObj.account_id = result.getInt("account_id");
        fpObj.create_timestamp = result.getLong("create_timestamp");
        fpObj.modify_timestamp = result.getLong("modify_timestamp");
        fpObj.content = result.getString("content");
        fpObj.likes = result.getInt("likes");
        return fpObj;
    }

    public ForumPostModel getPosts(String socket, int forum_subject_id) {
        make.add(forum_subject_id);
        setGet(SQL.make("SELECT * FROM forum_posts WHERE forum_subject_id = ?", make.toArray()));
        return this;
    }

    public ForumPostModel insert(String socket, JSONObject jsonObject){
        make.add(jsonObject.getInt("forums_subject_id"));
        make.add(jsonObject.getInt("account_id"));
        long t = getTimestamp();
        make.add(t);
        make.add(t);
        make.add(jsonObject.getString("content"));
        setPost(SQL.make("INSERT INTO forum_posts (forums_subject_id, account_id, create_timestamp, modify_timestamp, content) VALUES (?,?,?,?,?)", make.toArray()));
        return this;
    }

    public ForumPostModel update(String socket, int id, JSONObject jsonObject) {
        make.add(getTimestamp());
        make.add(jsonObject.getString("content"));
        make.add(jsonObject.getInt("likes"));
        make.add(id);
        setPut(SQL.make("UPDATE forum_posts SET modify_timestamp=?, content=?, likes=? WHERE id=?", make.toArray()));
        return this;
    }

    public ForumPostModel delete(String socket, int id){
        make.add(id);
        setDelete(SQL.make("DELETE FROM forum_posts WHERE id=?", make.toArray()));
        return this;
    }

    public ForumPostModel deleteAll(String socket, int forum_subject_id){
        make.add(forum_subject_id);
        setDelete(SQL.make("DELETE FROM forum_posts WHERE forum_subject_id=?", make.toArray()));
        return this;
    }

}

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
        fpObj.id = result.getInt("forum_posts.id");
        fpObj.account_id = result.getInt("forum_posts.account_id");
        fpObj.forum_subject_id= result.getInt("forum_posts.subject_id");
        fpObj.content = result.getString("forum_posts.content");
        fpObj.created_at = result.getLong("forum_posts.created_at");
        fpObj.last_updated = result.getLong("forum_posts.last_updated");
        fpObj.likes = result.getInt("forum_posts.likes");
        return fpObj;
    }

    public ForumPostModel getPosts(int forum_subject_id) {
        make.add(forum_subject_id);
        setGet(SQL.make("SELECT * FROM forum_posts WHERE forum_subject_id=? ORDER BY created_at ASC", make.toArray()));
        return this;
    }

    public ForumPostModel insert(JSONObject jsonObject)
    {
        make.add(jsonObject.getInt("account_id"));
        make.add(jsonObject.getInt("subject_id"));
        make.add(jsonObject.getInt("content"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        make.add(0);
        setPost(SQL.make("INSERT INTO forum_posts (account_id, subject_id, content, created_at, last_updated, likes) VALUES (?,?,?,?,?,?)", make.toArray()));
        return this;
    }

    public ForumPostModel insertWithid(JSONObject jsonObject, int id)
    {
        make.add(jsonObject.getInt("account_id"));
        make.add(id);
        make.add(jsonObject.getInt("content"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        make.add(0);
        setPost(SQL.make("INSERT INTO forum_posts (account_id, subject_id, content, created_at, last_updated, likes) VALUES (?,?,?,?,?,?)", make.toArray()));
        return this;
    }
    public ForumPostModel update(int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("content"));
        make.add(getTimestamp());
        make.add(jsonObject.getInt("likes"));
        make.add(id);
        setPost(SQL.make("INSERT INTO forum_posts SET content=?, last_updated=?, likes=? WHERE id=?", make.toArray()));
        return this;
    }

    public ForumPostModel delete(int id){
        make.add(id);
        setDelete(SQL.make("DELETE FROM forum_posts WHERE id=?", make.toArray()));
        return this;
    }

    public ForumPostModel deleteAll(int forum_subject_id){
        make.add(forum_subject_id);
        setDelete(SQL.make("DELETE FROM forum_posts WHERE forum_subject_id=?", make.toArray()));
        return this;
    }

}

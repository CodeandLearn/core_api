package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumSubjectObj;
import org.json.JSONObject;

/**
 * Created by moran on 9/1/2016.
 */
public class ForumSubjectModel extends Model {
    @Override
    protected Object setData(Map result) {
        ForumSubjectObj fsObj = new ForumSubjectObj();
        fsObj.id = result.getInt("forum_subjects.id");
        fsObj.forums_forum_id = result.getInt("forum_subjects.forums_forum_id");
        fsObj.locales_id = result.getInt("forum_subjects.locales_id");
        fsObj.account_id = result.getInt("forum_subjects.account_id");
        fsObj.timestamp =  result.getLong("forum_subjects.timestamp");
        fsObj.replies =  result.getInt("forum_subjects.replies");
        fsObj.views = result.getInt("forum_subjects.views");
        fsObj.subject = result.getString("forum_subjects.subject");
        return fsObj;
    }

    public ForumSubjectModel getSubjects(int forums_forum_id){
        make.add(forums_forum_id);
        setGet(SQL.make("SELECT * FROM forum_subjects WHERE forums_forum_id = ?", make.toArray()));
        return this;
    }

    public ForumSubjectModel insert(JSONObject jsonObject) {
        make.add(jsonObject.getInt("forums_forum_id"));
        make.add(jsonObject.getInt("locales_id"));
        make.add(jsonObject.getInt("account_id"));
        make.add(jsonObject.getString("subject"));
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO forum_subjects (forums_forum_id, locales_id, locales_id, subject, timestamp) VALUES (?,?,?,?,?)", make.toArray()));
        return this;
    }

    public ForumSubjectModel update(int id, JSONObject jsonObject) {
        make.add(getTimestamp());
        make.add(jsonObject.getInt("replies"));
        make.add(jsonObject.getInt("views"));
        make.add(jsonObject.getString("subject"));
        make.add(id);
        setPut(SQL.make("UPDATE forum_subjects SET timestamp=?, replies=?, views=?, subject=? WHERE id =?", make.toArray()));
        return this;
    }

    public ForumSubjectModel delete(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM forum_subjects WHERE id=?", make.toArray()));
        return this;
    }

    public ForumSubjectModel deleteAll(int forums_forum_id) {
        make.add(forums_forum_id);
        setDelete(SQL.make("DELETE FROM forum_subjects WHERE forums_forum_id=?", make.toArray()));
        return this;
    }
}

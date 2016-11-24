package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Http.Map;
import Core.Model;
import Plugin.Account.Model.GetAccount;
import Plugin.Account.Obj.AccountObj;
import Plugin.Forum.Obj.ForumSubjectObj;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by moran on 9/1/2016.
 */
public class ForumSubjectModel extends Model {
    @Override
    protected Object setData(Map result) {
        ForumSubjectObj fsObj = new ForumSubjectObj();
        fsObj.id = result.getInt("forum_subjects.id");
        fsObj.title = result.getString("forum_subjects.title");
        fsObj.account_id = result.getInt("forum_subjects.account_id");
        fsObj.created_at =  result.getLong("forum_subjects.create_at");
        fsObj.last_updated =  result.getLong("forum_subjects.last_updated");
        fsObj.last_account_id = result.getInt("forum_subjects.last_account_id");
        fsObj.forum_subcategory_id = result.getInt("forum_subjects.forum_subcategory_id");
        fsObj.likes = result.getInt("forum_subjects.likes");
        return fsObj;
    }

    @Override
    protected void setGet(String request) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (Map result : sql.getResultSet()) {
            Object ret = setData(result);
            if (ret != null) {
                ForumSubjectObj r = (ForumSubjectObj) ret;
                r.o_poster = (AccountObj) new GetAccount().getAccount(r.account_id).getData().get(0);
                r.l_poster = (AccountObj) new GetAccount().getAccount(r.last_account_id).getData().get(0);
                data.add(r);
            }
        }
    }

    public ForumSubjectModel getSubjects(int forum_subcategory_id){
        make.add(forum_subcategory_id);
        setGet(SQL.make("SELECT * FROM forum_subjects WHERE forum_subcategory_id = ? ORDER BY last_updated DESC", make.toArray()));
        return this;
    }

    public ForumSubjectModel insert(JSONObject jsonObject) {
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getInt("account_id"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        make.add(jsonObject.getInt("last_account_id"));
        make.add(jsonObject.getInt("forum_subcategory_id"));
        make.add(0);
        new ForumPostModel().insertWithid(jsonObject.getJSONObject("post"), this.id);
        setPost(SQL.make("INSERT INTO forum_subjects (title, account_id, create_at, last_updated, last_account_id, forum_subcategory_id, likes) VALUES (?,?,?,?,?,?,?)", make.toArray()));
        return this;
    }

    public ForumSubjectModel update(int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("title"));
        make.add(getTimestamp());
        make.add(jsonObject.getInt("last_account_id"));
        make.add(jsonObject.getInt("forum_subcategory_id"));
        make.add(jsonObject.getInt("likes"));
        make.add(id);
        setPut(SQL.make("UPDATE forum_subjects SET title=?, last_updated=?, last_account_id=?, forum_subcategory_id=?, likes=? WHERE id =?", make.toArray()));
        return this;
    }

    public ForumSubjectModel delete(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM forum_subjects WHERE id=?", make.toArray()));
        new ForumPostModel().deleteAll(id);
        return this;
    }

    public ForumSubjectModel deleteAll(int forum_subcategory_id, ArrayList<Map> resultset) {
        // get all subjects
        // delete all posts with subjects.ids
        for (Map r : resultset) {
            new ForumPostModel().deleteAll(r.getInt("forum_subjects.id"));
        }

        make.add(forum_subcategory_id);
        setDelete(SQL.make("DELETE FROM forum_subjects WHERE forum_subcategory_id=?", make.toArray()));
        return this;
    }
}

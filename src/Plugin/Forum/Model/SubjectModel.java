package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumSubjectObj;
import org.json.JSONObject;

/**
 * Created by Sheol on 30/11/2016.
 */
public class SubjectModel extends Model {
    @Override
    protected Object setData(Map result) {
        ForumSubjectObj forumSubjectObj = new ForumSubjectObj();
        forumSubjectObj.title = result.getString("forum_subjects.title");
        forumSubjectObj.id = result.getInt("forum_subjects.id");
        forumSubjectObj.account_id = result.getInt("forum_subjects.account_id");
        forumSubjectObj.forum_forum_id = result.getInt("forum_subjects.forum_forum_id");
        forumSubjectObj.pin = result.getBoolean("forum_subjects.pin");
        forumSubjectObj.account.username = result.getString("accounts.username");
        forumSubjectObj.account.avatar.path = result.getString("avatars.path");
        forumSubjectObj.forum.title = result.getString("forum_forums.title");
        return forumSubjectObj;
    }

    public SubjectModel getSubjects() {
        setGet("SELECT * FROM forum_subjects, forum_forums, accounts, avatars " +
                "WHERE forum_subjects.forum_forum_id=forum_forums.id " +
                "AND forum_subjects.account_id=accounts.id " +
                "AND accounts.avatar_id=avatars.id");
        return this;
    }

    public SubjectModel getSubjectById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM forum_subjects, forum_forums, accounts, avatars " +
                "WHERE forum_subjects.forum_forum_id=forum_forums.id " +
                "AND forum_subjects.account_id=accounts.id " +
                "AND accounts.avatar_id=avatars.id " +
                "AND forum_subjects.id=?", make.toArray()));
        return this;
    }

    public SubjectModel getSubjectByForumId(int forum_id) {
        make.add(forum_id);
        setGet(SQL.make("SELECT * FROM forum_subjects, forum_forums, accounts, avatars " +
                "WHERE forum_subjects.forum_forum_id=forum_forums.id " +
                "AND forum_subjects.account_id=accounts.id " +
                "AND accounts.avatar_id=avatars.id " +
                "AND forum_subjects.forum_forum_id=?", make.toArray()));
        return this;
    }

    public SubjectModel postSubject(int account_id, JSONObject jsonObject) {
        if (jsonObject.has("post")) {
            make.add(account_id);
            make.add(jsonObject.getInt("forum_forum_id"));
            make.add(jsonObject.getString("title"));
            make.add(0);
            setPost(SQL.make("INSERT INTO forum_subjects (account_id, forum_forum_id, title, pin) VALUES (?, ?, ?, ?)", make.toArray()));
            JSONObject post = jsonObject.getJSONObject("post");
            post.put("forum_subject_id", id);
            new PostModel().postPost(account_id, post);
        }
        return this;
    }

    public SubjectModel putSubject(int account_id, int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("title"));
        make.add(id);
        make.add(account_id);
        setPut(SQL.make("UPDATE forum_subjects SET title=? WHERE id=? AND account_id=?", make.toArray()));
        return this;
    }

    public SubjectModel putAdminSubject(int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("title"));
        make.add(id);
        setPut(SQL.make("UPDATE forum_subjects SET title=? WHERE id=?", make.toArray()));
        return this;
    }

    public SubjectModel pinSubject(int id) {
        make.add(true);
        make.add(id);
        setPut(SQL.make("UPDATE forum_subjects SET pin=? WHERE id=?", make.toArray()));
        return this;
    }

    public SubjectModel unpinSubject(int id) {
        make.add(false);
        make.add(id);
        setPut(SQL.make("UPDATE forum_subjects SET pin=? WHERE id=?", make.toArray()));
        return this;
    }

    public SubjectModel deleteSubject(int account_id, int id) {
        make.add(id);
        make.add(account_id);
        setDelete(SQL.make("DELETE FROM forum_subjects WHERE id=? AND account_id=?", make.toArray()));
        return this;
    }

    public SubjectModel deleteAdminSubject(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM forum_subjects WHERE id=?", make.toArray()));
        return this;
    }
}

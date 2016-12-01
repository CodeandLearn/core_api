package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumSubjectObj;

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
        setGet("SELECT * FROM forum_subjects, forum_forums, accounts, avatars WHERE forum_subjects.forum_forum_id=forum_forums.id AND forum_subjects.account_id=accounts.id AND accounts.avatar_id=avatars.id");
        return this;
    }

    public SubjectModel getSubjectById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM forum_subjects, forum_forums, accounts, avatars WHERE forum_subjects.forum_forum_id=forum_forums.id AND forum_subjects.account_id=accounts.id AND accounts.avatar_id=avatars.id AND forum_subjects.id=?", make.toArray()));
        return this;
    }
}

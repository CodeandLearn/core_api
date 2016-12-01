package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumPostObj;

import java.util.ArrayList;

/**
 * Created by Sheol on 30/11/2016.
 */
public class PostModel extends Model {
    @Override
    protected Object setData(Map result) {
        ForumPostObj forumPostObj = new ForumPostObj();
        forumPostObj.account_id = result.getInt("");
        forumPostObj.content = result.getString("");
        forumPostObj.create_timestamp = result.getLong("");
        forumPostObj.forum_subject_id = result.getInt("");
        forumPostObj.id = result.getInt("");
        forumPostObj.likes = result.getInt("");
        forumPostObj.modify_timestamp = result.getLong("");
        forumPostObj.account.id = result.getInt("");
        forumPostObj.account.username = result.getString("");
        forumPostObj.account.avatar.path = result.getString("");
        forumPostObj.subject.id = result.getInt("");
        forumPostObj.subject.title = result.getString("");
        return forumPostObj;
    }

    public PostModel getPost() {
        setGet("SELECT * FROM forum_posts, forum_subjects, accounts, avatars WHERE forum_posts.forum_subject_id=forum_subjects.id AND forum_posts.accounts_id=accounts.id AND accounts.avatar_id=avatars.id");
        return this;
    }

    public PostModel getPostById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM forum_posts, forum_subjects, accounts, avatars WHERE forum_posts.forum_subject_id=forum_subjects.id AND forum_posts.accounts_id=accounts.id AND accounts.avatar_id=avatars.id AND forum_posts.id=?", make.toArray()));
        return this;
    }

    public PostModel getPostBySubjectId(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM forum_posts, forum_subjects, accounts, avatars WHERE forum_posts.forum_subject_id=forum_subjects.id AND forum_posts.accounts_id=accounts.id AND accounts.avatar_id=avatars.id AND forum_subjects.id=?", make.toArray()));
        return this;
    }

    public PostModel getTopPost(int limit) {
        setGet("SELECT * FROM forum_posts, forum_subjects, accounts, avatars WHERE forum_posts.forum_subject_id=forum_subjects.id AND forum_posts.accounts_id=accounts.id AND accounts.avatar_id=avatars.id");
        data = new ArrayList<>(data.subList(0, limit));
        return this;
    }

    public PostModel getTopPostBySubjectId(int id, int limit) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM forum_posts, forum_subjects, accounts, avatars WHERE forum_posts.forum_subject_id=forum_subjects.id AND forum_posts.accounts_id=accounts.id AND accounts.avatar_id=avatars.id AND forum_subjects.id=? ORDER BY forum_forums.likes DESC", make.toArray()));
        data = new ArrayList<>(data.subList(0, limit));
        return this;
    }
}

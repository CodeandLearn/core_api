package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumPostObj;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Sheol on 30/11/2016.
 */
public class PostModel extends Model {
    @Override
    protected Object setData(Map result) {
        ForumPostObj forumPostObj = new ForumPostObj();
        forumPostObj.account_id = result.getInt("forum_posts.account_id");
        forumPostObj.content = result.getString("forum_posts.content");
        forumPostObj.create_timestamp = result.getLong("forum_posts.create_timestamp");
        forumPostObj.forum_subject_id = result.getInt("forum_posts.forum_subject_id");
        forumPostObj.id = result.getInt("forum_posts.id");
        forumPostObj.likes = result.getInt("forum_posts.likes");
        forumPostObj.modify_timestamp = result.getLong("forum_posts.modify_timestamp");
        forumPostObj.account.id = result.getInt("accounts.id");
        forumPostObj.account.username = result.getString("accounts.username");
        forumPostObj.account.avatar.path = result.getString("avatars.path");
        forumPostObj.subject.id = result.getInt("forum_subjects.id");
        forumPostObj.subject.title = result.getString("forum_subjects.title");
        forumPostObj.subject.pin = result.getBoolean("forum_subjects.pin");
        return forumPostObj;
    }

    public PostModel getPost() {
        setGet("SELECT * FROM forum_posts, forum_subjects, accounts, avatars " +
                "WHERE forum_posts.forum_subject_id=forum_subjects.id " +
                "AND forum_posts.account_id=accounts.id " +
                "AND accounts.avatar_id=avatars.id");
        return this;
    }

    public PostModel getPostById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM forum_posts, forum_subjects, accounts, avatars " +
                "WHERE forum_posts.forum_subject_id=forum_subjects.id " +
                "AND forum_posts.account_id=accounts.id " +
                "AND accounts.avatar_id=avatars.id " +
                "AND forum_posts.id=?", make.toArray()));
        return this;
    }

    public PostModel getPostBySubjectId(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM forum_posts, forum_subjects, accounts, avatars " +
                "WHERE forum_posts.forum_subject_id=forum_subjects.id " +
                "AND forum_posts.account_id=accounts.id " +
                "AND accounts.avatar_id=avatars.id " +
                "AND forum_subjects.id=?", make.toArray()));
        return this;
    }

    public PostModel getTopPost(int limit) {
        setGet("SELECT * FROM forum_posts, forum_subjects, accounts, avatars " +
                "WHERE forum_posts.forum_subject_id=forum_subjects.id " +
                "AND forum_posts.account_id=accounts.id " +
                "AND accounts.avatar_id=avatars.id");
        data = new ArrayList<>(data.subList(0, limit));
        return this;
    }

    public PostModel getTopPostBySubjectId(int id, int limit) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM forum_posts, forum_subjects, accounts, avatars " +
                "WHERE forum_posts.forum_subject_id=forum_subjects.id " +
                "AND forum_posts.account_id=accounts.id " +
                "AND accounts.avatar_id=avatars.id " +
                "AND forum_subjects.id=? " +
                "ORDER BY forum_forums.likes DESC", make.toArray()));
        data = new ArrayList<>(data.subList(0, limit));
        return this;
    }

    public PostModel postPost(int account_id, JSONObject jsonObject) {
        make.add(account_id);
        make.add(jsonObject.getInt("forum_subject_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        make.add(0);
        setPost(SQL.make("INSERT INTO forum_posts (account_id, forum_subject_id, content, create_timestamp, modify_timestamp, likes) VALUES (?, ?, ?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public PostModel likePost(int id) {
        getPostById(id);
        make.clear();
        make.add(((ForumPostObj) data.get(0)).likes + 1);
        make.add(id);
        data.clear();
        setPut(SQL.make("UPDATE forum_posts SET likes=? WHERE id=?", make.toArray()));
        return this;
    }

    public PostModel dislikePost(int id) {
        getPostById(id);
        make.clear();
        make.add(((ForumPostObj) data.get(0)).likes - 1);
        make.add(id);
        data.clear();
        setPut(SQL.make("UPDATE forum_posts SET likes=? WHERE id=?", make.toArray()));
        return this;
    }

    public PostModel putPost(int account_id, int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        make.add(account_id);
        setPut(SQL.make("UPDATE forum_posts SET content=?, modify_timestamp=? WHERE id=? AND account_id=?", make.toArray()));
        return this;
    }

    public PostModel putAdminPost(int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(SQL.make("UPDATE forum_posts SET content=?, modify_timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public PostModel deletePost(int account_id, int id) {
        make.add(id);
        make.add(account_id);
        setDelete(SQL.make("DELETE FROM forum_posts WHERE id=? AND account_id=?", make.toArray()));
        return this;
    }

    public PostModel deleteAdminPost(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM forum_posts WHERE id=?", make.toArray()));
        return this;
    }
}

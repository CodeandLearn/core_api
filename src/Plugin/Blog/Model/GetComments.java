package Plugin.Blog.Model;

import Core.Database.SQL;
import Core.Database.SQLite;
import Core.Model;
import Plugin.Blog.Obj.BlogCommentObj;

import java.util.HashMap;

/**
 * Created by teddy on 06/04/2016.
 */
public class GetComments extends Model {
    protected void setGet(String request) {
        SQLite sql = new SQLite(request);
        sql.select();
        for (HashMap<String, Object> result : sql.getResultSet()) {
            BlogCommentObj blogCommentObj = new BlogCommentObj();
            blogCommentObj.account_id = (Integer) result.get("blog_posts_comments.account_id");
            blogCommentObj.blog_post_id = (Integer) result.get("blog_posts_comments.blog_post_id");
            blogCommentObj.content = (String) result.get("blog_posts_comments.content");
            blogCommentObj.create_timestamp = (Long) result.get("blog_posts_comments.create_timestamp");
            blogCommentObj.modify_timestamp = (Long) result.get("blog_posts_comments.modify_timestamp");
            blogCommentObj.id = (Integer) result.get("blog_posts_comments.id");
            blogCommentObj.user.id = (Integer) result.get("accounts.id");
            blogCommentObj.user.username = (String) result.get("accounts.username");
            blogCommentObj.user.email = (String) result.get("accounts.email");
            blogCommentObj.user.group_id = (Integer) result.get("accounts.group_id");
            blogCommentObj.user.avatar_id = (Integer) result.get("accounts.avatar_id");
            blogCommentObj.user.last_connect_timestamp = (Long) result.get("accounts.last_connect_timestamp");
            blogCommentObj.user.create_timestamp = (Long) result.get("accounts.create_timestamp");
            blogCommentObj.user.nb_exercices_done = (Integer) result.get("accounts.nb_exercices_done");
            blogCommentObj.user.nb_courses_done = (Integer) result.get("accounts.nb_courses_done");
            blogCommentObj.user.group.id = (Integer) result.get("groups.id");
            blogCommentObj.user.group.name = (String) result.get("groups.name");
            blogCommentObj.user.group.parent_id = (Integer) result.get("groups.parent_id");
            blogCommentObj.user.avatar.id = (Integer) result.get("avatars.id");
            blogCommentObj.user.avatar.path = (String) result.get("avatars.path");
            data.add(blogCommentObj);
        }
    }

    public GetComments getBlogComments(String socket) {
        setGet("SELECT blog_posts_comments.content'blog_posts_comments.content',\n" +
                "blog_posts_comments.id'blog_posts_comments.id',\n" +
                "blog_posts_comments.create_timestamp'blog_posts_comments.create_timestamp',\n" +
                "blog_posts_comments.modify_timestamp'blog_posts_comments.modify_timestamp',\n" +
                "blog_posts_comments.account_id'blog_posts_comments.account_id',\n" +
                "blog_posts_comments.blog_post_id'blog_posts_comments.blog_post_id',\n" +
                "accounts.username'accounts.username',\n" +
                "accounts.id'accounts.id',\n" +
                "accounts.group_id'accounts.group_id',\n" +
                "accounts.avatar_id'accounts.avatar_id',\n" +
                "accounts.last_connect_timestamp'accounts.last_connect_timestamp',\n" +
                "accounts.create_timestamp'accounts.create_timestamp',\n" +
                "accounts.nb_exercices_done'accounts.nb_exercices_done',\n" +
                "accounts.nb_courses_done'accounts.nb_courses_done',\n" +
                "groups.id'groups.id',\n" +
                "groups.name'groups.name',\n" +
                "groups.parent_id'groups.parent_id',\n" +
                "avatars.id'avatars.id',\n" +
                "avatars.path'avatars.path'\n" +
                "FROM blog_posts_comments, accounts, groups, avatars\n" +
                "WHERE blog_posts_comments.account_id=accounts.id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND avatars.id=accounts.avatar_id ORDER BY blog_posts_comments.id DESC");
        return this;
    }

    public GetComments getBlogCommentsWithLimit(String socket, int limit) {
        make.add(limit);
        setGet(SQL.make("SELECT blog_posts_comments.content'blog_posts_comments.content',\n" +
                "blog_posts_comments.id'blog_posts_comments.id',\n" +
                "blog_posts_comments.create_timestamp'blog_posts_comments.create_timestamp',\n" +
                "blog_posts_comments.modify_timestamp'blog_posts_comments.modify_timestamp',\n" +
                "blog_posts_comments.account_id'blog_posts_comments.account_id',\n" +
                "blog_posts_comments.blog_post_id'blog_posts_comments.blog_post_id',\n" +
                "accounts.username'accounts.username',\n" +
                "accounts.id'accounts.id',\n" +
                "accounts.group_id'accounts.group_id',\n" +
                "accounts.avatar_id'accounts.avatar_id',\n" +
                "accounts.last_connect_timestamp'accounts.last_connect_timestamp',\n" +
                "accounts.create_timestamp'accounts.create_timestamp',\n" +
                "accounts.nb_exercices_done'accounts.nb_exercices_done',\n" +
                "accounts.nb_courses_done'accounts.nb_courses_done',\n" +
                "groups.id'groups.id',\n" +
                "groups.name'groups.name',\n" +
                "groups.parent_id'groups.parent_id',\n" +
                "avatars.id'avatars.id',\n" +
                "avatars.path'avatars.path'\n" +
                "FROM blog_posts_comments, accounts, groups, avatars\n" +
                "WHERE blog_posts_comments.account_id=accounts.id\n" +
                "AND groups.id=accounts.group_idd\n" +
                "AND avatars.id=accounts.avatar_id ORDER BY blog_posts_comments.id DESC LIMIT ?", make.toArray()));
        return this;
    }

    public GetComments getBlogComment(String socket, int id) {
        make.add(id);
        setGet(SQL.make("SELECT blog_posts_comments.content'blog_posts_comments.content',\n" +
                "blog_posts_comments.id'blog_posts_comments.id',\n" +
                "blog_posts_comments.create_timestamp'blog_posts_comments.create_timestamp',\n" +
                "blog_posts_comments.modify_timestamp'blog_posts_comments.modify_timestamp',\n" +
                "blog_posts_comments.account_id'blog_posts_comments.account_id',\n" +
                "blog_posts_comments.blog_post_id'blog_posts_comments.blog_post_id',\n" +
                "accounts.username'accounts.username',\n" +
                "accounts.id'accounts.id',\n" +
                "accounts.group_id'accounts.group_id',\n" +
                "accounts.avatar_id'accounts.avatar_id',\n" +
                "accounts.last_connect_timestamp'accounts.last_connect_timestamp',\n" +
                "accounts.create_timestamp'accounts.create_timestamp',\n" +
                "accounts.nb_exercices_done'accounts.nb_exercices_done',\n" +
                "accounts.nb_courses_done'accounts.nb_courses_done',\n" +
                "groups.id'groups.id',\n" +
                "groups.name'groups.name',\n" +
                "groups.parent_id'groups.parent_id',\n" +
                "avatars.id'avatars.id',\n" +
                "avatars.path'avatars.path'\n" +
                "FROM blog_posts_comments, accounts, groups, avatars\n" +
                "WHERE blog_posts_comments.account_id=accounts.id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND avatars.id=accounts.avatar_id AND blog_posts_comments.id=?", make.toArray()));
        return this;
    }

    public GetComments getBlogCommentByPostId(String socket, int postId) {
        make.add(postId);
        setGet(SQL.make("SELECT blog_posts_comments.content'blog_posts_comments.content',\n" +
                "blog_posts_comments.id'blog_posts_comments.id',\n" +
                "blog_posts_comments.create_timestamp'blog_posts_comments.create_timestamp',\n" +
                "blog_posts_comments.modify_timestamp'blog_posts_comments.modify_timestamp',\n" +
                "blog_posts_comments.account_id'blog_posts_comments.account_id',\n" +
                "blog_posts_comments.blog_post_id'blog_posts_comments.blog_post_id',\n" +
                "accounts.username'accounts.username',\n" +
                "accounts.id'accounts.id',\n" +
                "accounts.group_id'accounts.group_id',\n" +
                "accounts.avatar_id'accounts.avatar_id',\n" +
                "accounts.last_connect_timestamp'accounts.last_connect_timestamp',\n" +
                "accounts.create_timestamp'accounts.create_timestamp',\n" +
                "accounts.nb_exercices_done'accounts.nb_exercices_done',\n" +
                "accounts.nb_courses_done'accounts.nb_courses_done',\n" +
                "groups.id'groups.id',\n" +
                "groups.name'groups.name',\n" +
                "groups.parent_id'groups.parent_id',\n" +
                "avatars.id'avatars.id',\n" +
                "avatars.path'avatars.path'\n" +
                "FROM blog_posts_comments, accounts, groups, avatars\n" +
                "WHERE blog_posts_comments.account_id=accounts.id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND avatars.id=accounts.avatar_id AND blog_posts_comments.blog_post_id=? ORDER BY blog_posts_comments.id DESC", make.toArray()));
        return this;
    }

    public GetComments getBlogCommentByAuthorName(String socket, String author) {
        make.add(author);
        setGet(SQL.make("SELECT blog_posts_comments.content'blog_posts_comments.content',\n" +
                "blog_posts_comments.id'blog_posts_comments.id',\n" +
                "blog_posts_comments.create_timestamp'blog_posts_comments.create_timestamp',\n" +
                "blog_posts_comments.modify_timestamp'blog_posts_comments.modify_timestamp',\n" +
                "blog_posts_comments.account_id'blog_posts_comments.account_id',\n" +
                "blog_posts_comments.blog_post_id'blog_posts_comments.blog_post_id',\n" +
                "accounts.username'accounts.username',\n" +
                "accounts.id'accounts.id',\n" +
                "accounts.group_id'accounts.group_id',\n" +
                "accounts.avatar_id'accounts.avatar_id',\n" +
                "accounts.last_connect_timestamp'accounts.last_connect_timestamp',\n" +
                "accounts.create_timestamp'accounts.create_timestamp',\n" +
                "accounts.nb_exercices_done'accounts.nb_exercices_done',\n" +
                "accounts.nb_courses_done'accounts.nb_courses_done',\n" +
                "groups.id'groups.id',\n" +
                "groups.name'groups.name',\n" +
                "groups.parent_id'groups.parent_id',\n" +
                "avatars.id'avatars.id',\n" +
                "avatars.path'avatars.path'\n" +
                "FROM blog_posts_comments, accounts, groups, avatars\n" +
                "WHERE blog_posts_comments.account_id=accounts.id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND avatars.id=accounts.avatar_id AND accounts.username=? ORDER BY blog_posts_comments.id DESC", make.toArray()));
        return this;
    }

    public GetComments getBlogCommentByAuthorId(String socket, int authorId) {
        make.add(authorId);
        setGet(SQL.make("SELECT blog_posts_comments.content'blog_posts_comments.content',\n" +
                "blog_posts_comments.id'blog_posts_comments.id',\n" +
                "blog_posts_comments.create_timestamp'blog_posts_comments.create_timestamp',\n" +
                "blog_posts_comments.modify_timestamp'blog_posts_comments.modify_timestamp',\n" +
                "blog_posts_comments.account_id'blog_posts_comments.account_id',\n" +
                "blog_posts_comments.blog_post_id'blog_posts_comments.blog_post_id',\n" +
                "accounts.username'accounts.username',\n" +
                "accounts.id'accounts.id',\n" +
                "accounts.group_id'accounts.group_id',\n" +
                "accounts.avatar_id'accounts.avatar_id',\n" +
                "accounts.last_connect_timestamp'accounts.last_connect_timestamp',\n" +
                "accounts.create_timestamp'accounts.create_timestamp',\n" +
                "accounts.nb_exercices_done'accounts.nb_exercices_done',\n" +
                "accounts.nb_courses_done'accounts.nb_courses_done',\n" +
                "groups.id'groups.id',\n" +
                "groups.name'groups.name',\n" +
                "groups.parent_id'groups.parent_id',\n" +
                "avatars.id'avatars.id',\n" +
                "avatars.path'avatars.path'\n" +
                "FROM blog_posts_comments, accounts, groups, avatars\n" +
                "WHERE blog_posts_comments.account_id=accounts.id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND avatars.id=accounts.avatar_id AND accounts.id=? ORDER BY blog_posts_comments.id DESC", make.toArray()));
        return this;
    }
}

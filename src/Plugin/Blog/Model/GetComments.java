package Plugin.Blog.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Blog.Obj.BlogCommentObj;

/**
 * Created by teddy on 06/04/2016.
 */
public class GetComments extends Model {
    @Override
    protected Object setData(Map result) {
        BlogCommentObj blogCommentObj = new BlogCommentObj();
        blogCommentObj.account_id = result.getInt("blog_posts_comments.account_id");
        blogCommentObj.blog_post_id = result.getInt("blog_posts_comments.blog_post_id");
        blogCommentObj.content = result.getString("blog_posts_comments.content");
        blogCommentObj.create_timestamp = result.getLong("blog_posts_comments.create_timestamp");
        blogCommentObj.modify_timestamp = result.getLong("blog_posts_comments.modify_timestamp");
        blogCommentObj.id = result.getInt("blog_posts_comments.id");
        blogCommentObj.user.id = result.getInt("accounts.id");
        blogCommentObj.user.username = result.getString("accounts.username");
        blogCommentObj.user.email = result.getString("accounts.email");
        blogCommentObj.user.group_id = result.getInt("accounts.group_id");
        blogCommentObj.user.avatar_id = result.getInt("accounts.avatar_id");
        blogCommentObj.user.last_connect_timestamp = result.getLong("accounts.last_connect_timestamp");
        blogCommentObj.user.create_timestamp = result.getLong("accounts.create_timestamp");
        blogCommentObj.user.nb_exercices_done = result.getInt("accounts.nb_exercices_done");
        blogCommentObj.user.nb_courses_done = result.getInt("accounts.nb_courses_done");
        blogCommentObj.user.group.id = result.getInt("groups.id");
        blogCommentObj.user.group.name = result.getString("groups.name");
        blogCommentObj.user.group.parent_id = result.getInt("groups.parent_id");
        blogCommentObj.user.avatar.id = result.getInt("avatars.id");
        blogCommentObj.user.avatar.path = result.getString("avatars.path");
        return blogCommentObj;
    }

    public GetComments getBlogComments(String socket) {
        setGet("SELECT * FROM blog_posts_comments, accounts, groups, avatars\n" +
                "WHERE blog_posts_comments.account_id=accounts.id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND avatars.id=accounts.avatar_id ORDER BY blog_posts_comments.id DESC");
        return this;
    }

    public GetComments getBlogCommentsWithLimit(String socket, int limit) {
        make.add(limit);
        setGet(SQL.make("SELECT * FROM blog_posts_comments, accounts, groups, avatars\n" +
                "WHERE blog_posts_comments.account_id=accounts.id\n" +
                "AND groups.id=accounts.group_idd\n" +
                "AND avatars.id=accounts.avatar_id ORDER BY blog_posts_comments.id DESC LIMIT ?", make.toArray()));
        return this;
    }

    public GetComments getBlogComment(String socket, int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM blog_posts_comments, accounts, groups, avatars\n" +
                "WHERE blog_posts_comments.account_id=accounts.id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND avatars.id=accounts.avatar_id AND blog_posts_comments.id=?", make.toArray()));
        return this;
    }

    public GetComments getBlogCommentByPostId(String socket, int postId) {
        make.add(postId);
        setGet(SQL.make("SELECT * FROM blog_posts_comments, accounts, groups, avatars\n" +
                "WHERE blog_posts_comments.account_id=accounts.id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND avatars.id=accounts.avatar_id AND blog_posts_comments.blog_post_id=? ORDER BY blog_posts_comments.id DESC", make.toArray()));
        return this;
    }

    public GetComments getBlogCommentByAuthorName(String socket, String author) {
        make.add(author);
        setGet(SQL.make("SELECT * FROM blog_posts_comments, accounts, groups, avatars\n" +
                "WHERE blog_posts_comments.account_id=accounts.id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND avatars.id=accounts.avatar_id AND accounts.username=? ORDER BY blog_posts_comments.id DESC", make.toArray()));
        return this;
    }

    public GetComments getBlogCommentByAuthorId(String socket, int authorId) {
        make.add(authorId);
        setGet(SQL.make("SELECT * FROM blog_posts_comments, accounts, groups, avatars\n" +
                "WHERE blog_posts_comments.account_id=accounts.id\n" +
                "AND groups.id=accounts.group_id\n" +
                "AND avatars.id=accounts.avatar_id AND accounts.id=? ORDER BY blog_posts_comments.id DESC", make.toArray()));
        return this;
    }
}

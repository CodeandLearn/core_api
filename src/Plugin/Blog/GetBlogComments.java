package Plugin.Blog;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLGet;
import Obj.BlogCommentObj;

/**
 * Created by teddy on 06/04/2016.
 */
public class GetBlogComments extends Model {
    public GetBlogComments(String socket) {
        setData(socket, "", "");
    }

    public GetBlogComments(String socket, String extra) {
        setData(socket, "AND " + extra, "");
    }

    public GetBlogComments(String socket, String extra, int limit) {
        if (!extra.equals("")) {
            setData(socket, "AND " + extra, "LIMIT " + limit);
        } else {
            setData(socket, "", "LIMIT " + limit);
        }
    }

    private void setData(String socket, String extra, String limit) {
        SQLite sql = new SQLite(SQLGet.BLOG_COMMENT + " " + extra + " ORDER BY blog_posts_comments.id DESC " + limit);
        sql.select();
        if (sql.getResultSet().size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (int i = 0; i < sql.getResultSet().size(); i++) {
                // DEBUG
                System.out.println(i + " - " + sql.getResultSet().get(i));
                // DEBUG
                BlogCommentObj blogCommentObj = new BlogCommentObj();
                blogCommentObj.account_id = (int) sql.getResultSet().get(i).get("blog_posts_comments.account_id");
                blogCommentObj.blog_post_id = (int) sql.getResultSet().get(i).get("blog_posts_comments.blog_post_id");
                blogCommentObj.content = (String) sql.getResultSet().get(i).get("blog_posts_comments.content");
                blogCommentObj.create_timestamp = (long) sql.getResultSet().get(i).get("blog_posts_comments.create_timestamp");
                blogCommentObj.modify_timestamp = (long) sql.getResultSet().get(i).get("blog_posts_comments.modify_timestamp");
                blogCommentObj.id = (int) sql.getResultSet().get(i).get("blog_posts_comments.id");
                blogCommentObj.user.id = (int) sql.getResultSet().get(i).get("accounts.id");
                blogCommentObj.user.username = (String) sql.getResultSet().get(i).get("accounts.username");
                blogCommentObj.user.email = (String) sql.getResultSet().get(i).get("accounts.email");
                blogCommentObj.user.group_id = (int) sql.getResultSet().get(i).get("accounts.group_id");
                blogCommentObj.user.avatar_id = (int) sql.getResultSet().get(i).get("accounts.avatar_id");
                blogCommentObj.user.last_connect_timestamp = (long) sql.getResultSet().get(i).get("accounts.last_connect_timestamp");
                blogCommentObj.user.create_timestamp = (long) sql.getResultSet().get(i).get("accounts.create_timestamp");
                blogCommentObj.user.nb_exercices_done = (int) sql.getResultSet().get(i).get("accounts.nb_exercices_done");
                blogCommentObj.user.nb_courses_done = (int) sql.getResultSet().get(i).get("accounts.nb_courses_done");
                blogCommentObj.user.group.id = (int) sql.getResultSet().get(i).get("groups.id");
                blogCommentObj.user.group.name = (String) sql.getResultSet().get(i).get("groups.name");
                blogCommentObj.user.group.parent_id = (int) sql.getResultSet().get(i).get("groups.parent_id");
                blogCommentObj.user.avatar.id = (int) sql.getResultSet().get(i).get("avatars.id");
                blogCommentObj.user.avatar.path = (String) sql.getResultSet().get(i).get("avatars.path");
                data.add(blogCommentObj);
            }
        }
    }
}

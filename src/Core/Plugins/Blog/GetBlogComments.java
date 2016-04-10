package Core.Plugins.Blog;

import Core.Datas.SQLGet;
import Core.Objs.BlogCategoryObj;
import Core.Objs.BlogCommentObj;
import Core.Plugins.Default.Default;
import Core.Tools.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by teddy on 06/04/2016.
 */
public class GetBlogComments extends Default {
    private ArrayList<BlogCommentObj> data = new ArrayList<>();

    public GetBlogComments(HttpServletRequest request, HttpServletResponse reply) {
        super(request, reply);
        setData("", "");
    }

    public GetBlogComments(HttpServletRequest request, HttpServletResponse reply, String extra) {
        super(request, reply);
        setData("AND " + extra, "");
    }

    public GetBlogComments(HttpServletRequest request, HttpServletResponse reply, String extra, int limit) {
        super(request, reply);
        if (!extra.equals("")) {
            setData("AND " + extra, "LIMIT " + limit);
        } else {
            setData("", "LIMIT " + limit);
        }
    }

    private void setData(String extra, String limit) {
        SQLite sql = new SQLite(SQLGet.BLOG_COMMENT + " " + extra + " ORDER BY blog_posts_comments.id DESC " + limit);
        sql.select();
        for (int i = 0; i < sql.getResultSet().size(); i++) {
            // DEBUG
            System.out.println(i + " - " + sql.getResultSet().get(i));
            // DEBUG
            BlogCommentObj blogCommentObj = new BlogCommentObj();
            blogCommentObj.account_id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts_comments.account_id"));
            blogCommentObj.blog_post_id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts_comments.blog_post_id"));
            blogCommentObj.content = sql.getResultSet().get(i).get("blog_posts_comments.content");
            blogCommentObj.create_timestamp = Long.parseLong(sql.getResultSet().get(i).get("blog_posts_comments.create_timestamp"));
            blogCommentObj.modify_timestamp = Long.parseLong(sql.getResultSet().get(i).get("blog_posts_comments.modify_timestamp"));
            blogCommentObj.id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts_comments.id"));
            blogCommentObj.user.id = Integer.parseInt(sql.getResultSet().get(i).get("accounts.id"));
            blogCommentObj.user.username = sql.getResultSet().get(i).get("accounts.username");
            blogCommentObj.user.email = sql.getResultSet().get(i).get("accounts.email");
            blogCommentObj.user.group_id = Integer.parseInt(sql.getResultSet().get(i).get("accounts.group_id"));
            blogCommentObj.user.avatar_id = Integer.parseInt(sql.getResultSet().get(i).get("accounts.avatar_id"));
            blogCommentObj.user.last_connect_timestamp = Long.parseLong(sql.getResultSet().get(i).get("accounts.last_connect_timestamp"));
            blogCommentObj.user.create_timestamp = Long.parseLong(sql.getResultSet().get(i).get("accounts.create_timestamp"));
            blogCommentObj.user.nb_exercices_done = Integer.parseInt(sql.getResultSet().get(i).get("accounts.nb_exercices_done"));
            blogCommentObj.user.nb_courses_done = Integer.parseInt(sql.getResultSet().get(i).get("accounts.nb_courses_done"));
            blogCommentObj.user.group.id = Integer.parseInt(sql.getResultSet().get(i).get("groups.id"));
            blogCommentObj.user.group.name = sql.getResultSet().get(i).get("groups.name");
            blogCommentObj.user.group.parent_id = Integer.parseInt(sql.getResultSet().get(i).get("groups.parent_id"));
            blogCommentObj.user.avatar.id = Integer.parseInt(sql.getResultSet().get(i).get("avatars.id"));
            blogCommentObj.user.avatar.path = sql.getResultSet().get(i).get("avatars.path");
            data.add(blogCommentObj);
        }
    }

    public ArrayList<BlogCommentObj> getData() {
        return data;
    }
}

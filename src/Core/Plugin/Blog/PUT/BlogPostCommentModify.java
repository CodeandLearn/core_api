package Core.Plugin.Blog.PUT;

import Core.Plugin.Blog.Obj.BlogCommentObj;
import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BlogPostCommentModify extends Default {
    public BlogPostCommentModify(HttpServletRequest request, HttpServletResponse reply, int id,
                                 BlogCommentObj blogCommentObj) {
        super(request, reply);
        sqlBlogPostCommentModify(id, blogCommentObj);
    }

    private void sqlBlogPostCommentModify(int id, BlogCommentObj blogCommentObj) {
        SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
        long timestamp = System.currentTimeMillis();
        sql.insertDB("UPDATE blog_posts_comments SET account_id=" + blogCommentObj.account_id + ", blog_post_id="
                + blogCommentObj.blog_post_id + ", content=\"" + blogCommentObj.content + "\", modify_timestamp="
                + timestamp + " WHERE id = " + id);
        sql.closeDB();
    }
}

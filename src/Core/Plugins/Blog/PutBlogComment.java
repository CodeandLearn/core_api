package Core.Plugins.Blog;

import Core.Datas.SQLPut;
import Core.Objs.BlogCommentObj;
import Core.Plugins.Default.Default;
import Core.Tools.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by teddy on 09/04/2016.
 */
public class PutBlogComment extends Default {
    public PutBlogComment(HttpServletRequest request, HttpServletResponse reply, int id, BlogCommentObj blogCommentObj) {
        super(request, reply);
        updateData(id, blogCommentObj);
    }

    private void updateData(int id, BlogCommentObj blogCommentObj) {
        long timestamp = System.currentTimeMillis();
        SQLite sql = new SQLite(SQLPut.BLOG_COMMENT
                + "account_id=" + blogCommentObj.account_id
                + "blog_post_id=" + blogCommentObj.blog_post_id
                + "content=\"" + blogCommentObj.content.replace("\"", "\\\"") + "\""
                + "modify_timestamp=" + timestamp
                + " WHERE id=" + id);
        sql.update();
    }
}

package Core.Plugins.Blog;

import Core.Datas.SQLPost;
import Core.Objs.BlogCommentObj;
import Core.Plugins.Default.Default;
import Core.Tools.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by teddy on 08/04/2016.
 */
public class PostBlogComment extends Default {
    public PostBlogComment(HttpServletRequest request, HttpServletResponse reply, BlogCommentObj blogCommentObj) {
        super(request, reply);
        insertData(blogCommentObj);
    }

    private void insertData(BlogCommentObj blogCommentObj) {
        long timestamp = System.currentTimeMillis();
        SQLite sql = new SQLite(SQLPost.BLOG_COMMENT + "(account_id, blog_post_id, content, create_timestamp, modify_timestamp) VALUES ("
                + blogCommentObj.account_id + ", "
                + blogCommentObj.blog_post_id + ", "
                + "\"" + blogCommentObj.content.replace("\"", "\\\"") + "\", "
                + timestamp + ", "
                + timestamp + ")");
        sql.insert();
    }
}

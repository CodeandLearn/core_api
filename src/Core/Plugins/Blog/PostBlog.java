package Core.Plugins.Blog;

import Core.Datas.SQLPost;
import Core.Objs.BlogPostObj;
import Core.Plugins.Default.Default;
import Core.Tools.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by teddy on 08/04/2016.
 */
public class PostBlog extends Default {
    public PostBlog(HttpServletRequest request, HttpServletResponse reply, BlogPostObj blogPostObj) {
        super(request, reply);
        insertData(blogPostObj);
    }

    private void insertData(BlogPostObj blogPostObj) {
        long timestamp = System.currentTimeMillis();
        SQLite sql = new SQLite(SQLPost.BLOG_POST + "(account_id, locales_id, blog_category_id, title, content, create_timestamp, modify_timestamp) VALUES ("
                + blogPostObj.account_id + ", "
                + blogPostObj.locales_id + ", "
                + blogPostObj.blog_category_id + ", "
                + "\"" + blogPostObj.title.replace("\"", "\\\"") + "\", "
                + "\"" + blogPostObj.content.replace("\"", "\\\"") + "\", "
                + timestamp + ", "
                + timestamp + ")");
        sql.insert();
    }
}

package Core.Plugins.Blog;

import Core.Datas.SQLPut;
import Core.Objs.BlogPostObj;
import Core.Plugins.Default.Default;
import Core.Tools.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by teddy on 09/04/2016.
 */
public class PutBlog extends Default {
    public PutBlog(HttpServletRequest request, HttpServletResponse reply, int id, BlogPostObj blogPostObj) {
        super(request, reply);
        updateData(id, blogPostObj);
    }

    private void updateData(int id, BlogPostObj blogPostObj) {
        long timestamp = System.currentTimeMillis();
        SQLite sql = new SQLite(SQLPut.BLOG_POST
                + "account_id=" + blogPostObj.account_id
                + ", locales_id=" + blogPostObj.locales_id
                + ", blog_category_id=" + blogPostObj.blog_category_id
                + ", title=\"" + blogPostObj.title.replace("\"", "\\\"") + "\""
                + ", content=\"" + blogPostObj.content.replace("\"", "\\\"") + "\""
                + ", modify_timestamp=" + timestamp
                + " WHERE id=" + id);
        sql.update();
    }
}

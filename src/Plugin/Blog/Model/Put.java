package Plugin.Blog.Model;

import Core.Database.SQL;
import Core.Model;
import org.json.JSONObject;

/**
 * Created by teddy on 09/04/2016.
 */
public class Put extends Model {
    public Put putBlog(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("locales_id"));
        make.add(jsonObject.getInt("blog_category_id"));
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(socket, SQL.make("UPDATE blog_posts SET locales_id=?, blog_category_id=?, title=?, content=?, modify_timestamp=? WHERE id=?", make.toArray()));
        return this;
    }

    public Put putBlogCategory(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("name"));
        make.add(id);
        setPut(socket, SQL.make("UPDATE blog_posts_category SET name=? WHERE id=?", make.toArray()));
        return this;
    }

    public Put putBlogComment(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getInt("blog_post_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(id);
        setPut(socket, SQL.make("UPDATE blog_posts_comments SET blog_post_id=?, content=?, modify_timestamp=? WHERE id=?", make.toArray()));
        return this;
    }
}

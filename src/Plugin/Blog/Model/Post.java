package Plugin.Blog.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import org.json.JSONObject;

/**
 * Created by teddy on 08/04/2016.
 */
public class Post extends Model {
    public Post postBlogCategory(String socket, JSONObject jsonObject) {
        make.add(jsonObject.getString("name"));
        setPost(SQL.make("INSERT INTO blog_posts_category (name) VALUES (?)", make.toArray()));
        return this;
    }

    public Post postBlog(String socket, int accountId, JSONObject jsonObject) {
        make.add(accountId);
        make.add(jsonObject.getInt("locales_id"));
        make.add(jsonObject.getInt("blog_category_id"));
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO blog_posts (account_id, locales_id, blog_category_id, title, content, create_timestamp, modify_timestamp) VALUES (?, ?, ?, ?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public Post postBlogComment(String socket, int account_id, JSONObject jsonObject) {
        make.add(account_id);
        make.add(jsonObject.getInt("blog_post_id"));
        make.add(jsonObject.getString("content"));
        make.add(getTimestamp());
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO blog_posts_comments (account_id, blog_post_id, content, create_timestamp, modify_timestamp) VALUES (?, ?, ?, ?, ?)", make.toArray()));
        return this;
    }

    @Override
    protected Object setData(Map result) {
        return null;
    }
}

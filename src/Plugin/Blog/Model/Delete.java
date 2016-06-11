package Plugin.Blog.Model;

import Core.Database.SQL;
import Core.Model;

/**
 * Created by teddy on 09/04/2016.
 */
public class Delete extends Model {
    public Delete deleteBlog(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM blog_posts_comments WHERE blog_post_id=?", make.toArray()));
        setDelete(socket, SQL.make("DELETE FROM blog_posts WHERE id=?", make.toArray()));
        return this;
    }

    public Delete deleteBlogCategory(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM blog_posts_category WHERE id=?", make.toArray()));
        return this;
    }

    public Delete deleteBlogComment(String socket, int id) {
        make.add(id);
        setDelete(socket, SQL.make("DELETE FROM blog_posts_comments WHERE id=?", make.toArray()));
        return this;
    }
}

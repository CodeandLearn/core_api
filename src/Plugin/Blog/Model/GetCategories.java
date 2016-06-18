package Plugin.Blog.Model;

import Core.Database.SQLRequest;
import Core.Model;
import Plugin.Blog.Obj.BlogCategoryObj;

import java.util.HashMap;

/**
 * Created by teddy on 06/04/2016.
 */
public class GetCategories extends Model {
    protected void setGet(String request) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (HashMap<String, Object> result : sql.getResultSet()) {
            BlogCategoryObj blogCategoryObj = new BlogCategoryObj();
            blogCategoryObj.id = (Integer) result.get("blog_posts_category.id");
            blogCategoryObj.name = (String) result.get("blog_posts_category.name");
            data.add(blogCategoryObj);
        }
    }

    public GetCategories getBlogCategories(String socket) {
        setGet("SELECT blog_posts_category.id'blog_posts_category.id',\n" +
                "blog_posts_category.name'blog_posts_category.name'\n" +
                "FROM blog_posts_category ORDER BY blog_posts_category.id DESC");
        return this;
    }
}

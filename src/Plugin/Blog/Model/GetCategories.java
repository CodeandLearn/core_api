package Plugin.Blog.Model;

import Core.Http.Map;
import Core.Model;
import Plugin.Blog.Obj.BlogCategoryObj;

/**
 * Created by teddy on 06/04/2016.
 */
public class GetCategories extends Model {
    @Override
    protected Object setData(Map result) {
        BlogCategoryObj blogCategoryObj = new BlogCategoryObj();
        blogCategoryObj.id = result.getInt("blog_posts_category.id");
        blogCategoryObj.name = result.getString("blog_posts_category.name");
        return blogCategoryObj;
    }

    public GetCategories getBlogCategories() {
        setGet("SELECT * FROM blog_posts_category ORDER BY blog_posts_category.id DESC");
        return this;
    }
}

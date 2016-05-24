package Plugin.Blog;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLGet;
import Obj.BlogCategoryObj;

/**
 * Created by teddy on 06/04/2016.
 */
public class GetBlogCategories extends Model {
    public GetBlogCategories(String socket) {
        setData(socket);
    }

    private void setData(String socket) {
        SQLite sql = new SQLite(SQLGet.BLOG_CATEGORY + " ORDER BY blog_posts_category.id DESC");
        sql.select();
        if (sql.getResultSet().size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (int i = 0; i < sql.getResultSet().size(); i++) {
                // DEBUG
                System.out.println(i + " - " + sql.getResultSet().get(i));
                // DEBUG
                BlogCategoryObj blogCategoryObj = new BlogCategoryObj();
                blogCategoryObj.id = (int) sql.getResultSet().get(i).get("blog_posts_category.id");
                blogCategoryObj.name = (String) sql.getResultSet().get(i).get("blog_posts_category.name");
                data.add(blogCategoryObj);
            }
        }
    }
}

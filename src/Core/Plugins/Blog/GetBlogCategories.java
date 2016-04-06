package Core.Plugins.Blog;

import Core.Datas.SQLGet;
import Core.Objs.BlogCategoryObj;
import Core.Plugins.Default.Default;
import Core.Tools.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by teddy on 06/04/2016.
 */
public class GetBlogCategories extends Default {
    private ArrayList<BlogCategoryObj> data = new ArrayList<>();

    public GetBlogCategories(HttpServletRequest request, HttpServletResponse reply) {
        super(request, reply);
        setData();
    }

    private void setData() {
        SQLite sql = new SQLite(SQLGet.BLOG_CATEGORY + " ORDER BY blog_posts_category.id DESC");
        sql.select();
        for (int i = 0; i < sql.getResultSet().size(); i++) {
            // DEBUG
            System.out.println(i + " - " + sql.getResultSet().get(i));
            // DEBUG
            BlogCategoryObj blogCategoryObj = new BlogCategoryObj();
            blogCategoryObj.id = Integer.parseInt(sql.getResultSet().get(i).get("blog_posts_category.id"));
            blogCategoryObj.name = sql.getResultSet().get(i).get("blog_posts_category.name");
            data.add(blogCategoryObj);
        }
    }

    public ArrayList<BlogCategoryObj> getData() {
        return data;
    }
}

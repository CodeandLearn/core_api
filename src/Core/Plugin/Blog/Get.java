package Core.Plugin.Blog;

import Core.Plugin.Blog.Obj.BlogObj;
import Core.Plugin.Default.Default;
import Core.Tool.SQL;
import Core.Tool.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by teddy on 03/04/2016.
 */
public class Get extends Default {
    private ArrayList<BlogObj> blogObj = new ArrayList<>();

    public Get(HttpServletRequest request, HttpServletResponse reply) throws SQLException {
        super(request, reply);
        SQLite sql = new SQLite(SQL.BLOG);
        sql.select();
        int i = 0;
        while (i < sql.getResultSet().size()) {
            System.out.println(i + " - " + sql.getResultSet().get(i));
            BlogObj obj = new BlogObj();
            obj.articles.account_id = Integer.parseInt(sql.getResultSet().get(i).get("account_id"));
            obj.articles.blog_category_id = Integer.parseInt(sql.getResultSet().get(i).get("blog_category_id"));
            obj.articles.content = sql.getResultSet().get(i).get("content");
            obj.articles.create_timestamp = Long.parseLong(sql.getResultSet().get(i).get("create_timestamp"));
            obj.articles.id = Integer.parseInt(sql.getResultSet().get(i).get("id"));
            obj.articles.locales_id = Integer.parseInt(sql.getResultSet().get(i).get("locales_id"));
            //obj.articles.modify_timestamp = Long.parseLong(sql.getResultSet().get(i).get("modify_timestamp"));
            obj.articles.title = sql.getResultSet().get(i).get("title");
            blogObj.add(obj);
            i++;
        }
    }

    public ArrayList<BlogObj> getBlogObj() {
        return blogObj;
    }
}

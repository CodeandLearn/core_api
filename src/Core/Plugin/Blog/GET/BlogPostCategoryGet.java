package Core.Plugin.Blog.GET;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Core.Plugin.Blog.GET.Obj.BlogCategoryGetObj;
import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

public class BlogPostCategoryGet extends Default {
	private BlogCategoryGetObj[] obj;

	public BlogPostCategoryGet(HttpServletRequest request, HttpServletResponse reply) {
		super(request, reply);
		try {
			sqlBlogPostCategoryGet();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				reply.sendError(404, "Category not found !");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public BlogCategoryGetObj[] getObj() {
		return obj;
	}

	private void sqlBlogPostCategoryGet() throws IOException, SQLException {
		int i = 0;
		SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
		ResultSet result = sql.selectDB(
				"SELECT (SELECT COUNT(id) FROM blog_posts_category)'nb', * FROM blog_posts_category ORDER BY name");
		obj = new BlogCategoryGetObj[result.getInt("nb")];
		while (result.next()) {
			obj[i] = new BlogCategoryGetObj();
			obj[i].id = result.getInt("id");
			obj[i].name = result.getString("name");
		}
		sql.closeDB();
	}
}

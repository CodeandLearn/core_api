package Core.Plugin.Blog.GET;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

public class BlogPostCategoryIdGet extends Default {
	private Integer id;
	private String name;

	public BlogPostCategoryIdGet(HttpServletRequest request, HttpServletResponse reply, Integer id) {
		super(request, reply);
		this.id = id;
		sqlBlogPostCategoryIdGet();
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	private void sqlBlogPostCategoryIdGet() {
		SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
		ResultSet result = sql.selectDB("SELECT * FROM blog_posts_category WHERE id=" + id);
		try {
			if (result.next()) {
				id = result.getInt("id");
				name = result.getString("name");
			} else {
				reply.sendError(404, "Category not found !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sql.closeDB();
	}
}

package Core.Plugin.Blog.POST;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Core.Plugin.Blog.Obj.BlogPostObj;
import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

public class BlogPostCreate extends Default {

	public BlogPostCreate(HttpServletRequest request, HttpServletResponse reply, BlogPostObj blogPostObj) {
		super(request, reply);
		try {
			sqlBlogPostCreate(blogPostObj);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private void sqlBlogPostCreate(BlogPostObj blogPostObj) throws SQLException, IOException {
		SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
		long timestamp = System.currentTimeMillis();
		sql.insertDB(
				"INSERT INTO blog_posts (account_id, locales_id, blog_category_id, title, content, create_timestamp, modify_timestamp) VALUES ("
						+ blogPostObj.account_id + ", " + blogPostObj.locales_id + ", " + blogPostObj.blog_category_id
						+ ", \"" + blogPostObj.title + "\", \"" + blogPostObj.content + "\", " + timestamp + ", "
						+ timestamp + ")");
		sql.closeDB();
	}
}

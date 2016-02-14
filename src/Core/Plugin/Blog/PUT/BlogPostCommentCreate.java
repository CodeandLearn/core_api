package Core.Plugin.Blog.PUT;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Core.Plugin.Blog.Obj.BlogCommentObj;
import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

public class BlogPostCommentCreate extends Default {

	public BlogPostCommentCreate(HttpServletRequest request, HttpServletResponse reply, BlogCommentObj bloCommentObj) {
		super(request, reply);
		try {
			sqlBlogPostCommentCreate(bloCommentObj);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	private void sqlBlogPostCommentCreate(BlogCommentObj blogCommentObj) throws SQLException, IOException {
		SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
		long timestamp = System.currentTimeMillis();
		sql.insertDB(
				"INSERT INTO blog_posts_comments (account_id, blog_post_id, content, create_timestamp, modify_timestamp) VALUES ("
						+ blogCommentObj.account_id + ", " + blogCommentObj.blog_post_id + ", \""
						+ blogCommentObj.content + "\", " + timestamp + ", " + timestamp + ")");
		sql.closeDB();
	}
}

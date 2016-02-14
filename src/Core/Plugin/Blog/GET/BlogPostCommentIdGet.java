package Core.Plugin.Blog.GET;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

public class BlogPostCommentIdGet extends Default {
	private int id;
	private int account_id;
	private int blog_post_id;
	private String content;
	private Timestamp create_timestamp;
	private Timestamp modify_timestamp;

	public BlogPostCommentIdGet(HttpServletRequest request, HttpServletResponse reply, int id) {
		super(request, reply);
		this.id = id;
		sqlBlogPostCommentIdGet();
	}

	public int getId() {
		return id;
	}

	public int getAccountId() {
		return account_id;
	}

	public int getBlogPostId() {
		return blog_post_id;
	}

	public String getContent() {
		return content;
	}

	public Timestamp getCreateTimestamp() {
		return create_timestamp;
	}

	public Timestamp getModifyTimestamp() {
		return modify_timestamp;
	}

	private void sqlBlogPostCommentIdGet() {
		SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
		ResultSet result = sql.selectDB(
				"SELECT (SELECT COUNT(id) FROM blog_posts_comments)'nb', * FROM blog_posts_comments WHERE id = " + id);
		try {
			if (result.next()) {
				id = result.getInt("id");
				account_id = result.getInt("account_id");
				blog_post_id = result.getInt("blog_post_id");
				content = result.getString("content");
				create_timestamp = result.getTimestamp("create_timestamp");
				modify_timestamp = result.getTimestamp("modify_timestamp");
			} else {
				reply.sendError(404, "Blog post not found !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sql.closeDB();
	}
}

package Core.Plugin.Blog.GET;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

public class BlogPostIdGet extends Default {
	private int id;
	private int account_id;
	private int locales_id;
	private int blog_category_id;
	private String title;
	private String content;
	private Timestamp create_timestamp;
	private Timestamp modify_timestamp;

	public BlogPostIdGet(HttpServletRequest request, HttpServletResponse reply, int id) {
		super(request, reply);
		this.id = id;
		sqlBlogPostId();
	}

	public int getId() {
		return id;
	}

	public int getAccountId() {
		return account_id;
	}

	public int getLocalesId() {
		return locales_id;
	}

	public int getBlogCategoryId() {
		return blog_category_id;
	}

	public String getTitle() {
		return title;
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

	public void sqlBlogPostId() {
		SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite"); // INSERT INTO blog_posts
														// (blog_posts.account_id,
														// blog_posts.locales_id,
														// blog_posts.blog_category_id,
														// blog_posts.title,
														// blog_posts.content,
														// blog_posts.create_timestamp,
														// blog_posts.modify_timestamp)VALUES
														// ();
		ResultSet result = sql.selectDB("SELECT * FROM blog_posts WHERE id=" + id);
		try {
			if (result.next()) {
				id = result.getInt("id");
				account_id = result.getInt("account_id");
				locales_id = result.getInt("locales_id");
				blog_category_id = result.getInt("blog_category_id");
				title = result.getString("title");
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

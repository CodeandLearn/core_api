package Core.Plugin.Blog.GET;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Core.Plugin.Blog.GET.Obj.BlogCommentGetObj;
import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

public class BlogPostCommentGet extends Default {
	private int blog_post_id;
	private BlogCommentGetObj[] obj;

	public BlogPostCommentGet(HttpServletRequest request, HttpServletResponse reply, int blog_post_id) {
		super(request, reply);
		this.blog_post_id = blog_post_id;
		sqlBlogPostCommentGet();
	}

	public BlogCommentGetObj[] getObj() {
		return obj;
	}

	private void sqlBlogPostCommentGet() {
		int i = 0;
		SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
		ResultSet result = sql.selectDB(
				"SELECT (SELECT COUNT(id) FROM blog_posts_comments)'nb', * FROM blog_posts_comments WHERE blog_post_id = "
						+ blog_post_id + " ORDER BY id DESC");
		try {
			obj = new BlogCommentGetObj[result.getInt("nb")];
			if (result.next()) {
				obj[i] = new BlogCommentGetObj();
				obj[i].id = result.getInt("id");
				obj[i].account_id = result.getInt("account_id");
				obj[i].blog_post_id = result.getInt("blog_post_id");
				obj[i].content = result.getString("content");
				obj[i].create_timestamp = result.getTimestamp("create_timestamp");
				obj[i].modify_timestamp = result.getTimestamp("modify_timestamp");
			}
		} catch (SQLException e) {
			try {
				reply.sendError(404, "Category not found !");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		sql.closeDB();
	}
}

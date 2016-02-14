package Core.Plugin.Blog.DELETE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

public class BlogPostCommentDelete extends Default {

	public BlogPostCommentDelete(HttpServletRequest request, HttpServletResponse reply, int id) {
		super(request, reply);
		sqlBlogPostCommentDelete(id);
	}

	private void sqlBlogPostCommentDelete(int id) {
		SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
		sql.deleteDB("DELETE FROM blog_posts_comments WHERE id=" + id);
		sql.closeDB();
	}
}

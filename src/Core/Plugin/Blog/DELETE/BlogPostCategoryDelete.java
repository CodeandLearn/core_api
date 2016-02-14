package Core.Plugin.Blog.DELETE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

public class BlogPostCategoryDelete extends Default {

	public BlogPostCategoryDelete(HttpServletRequest request, HttpServletResponse reply, int id) {
		super(request, reply);
		sqlBlogPostCategoryDelete(id);
	}

	private void sqlBlogPostCategoryDelete(int id) {
		SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
		sql.deleteDB("DELETE FROM blog_posts_category WHERE id=" + id);
		sql.closeDB();
	}
}

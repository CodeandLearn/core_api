package Core.Plugin.Blog.PUT;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Core.Plugin.Blog.Obj.BlogPostObj;
import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

public class BlogPostModify extends Default {
	public BlogPostModify(HttpServletRequest request, HttpServletResponse reply, int id, BlogPostObj blogPostObj) {
		super(request, reply);
		sqlBlogPostModify(id, blogPostObj);
	}

	private void sqlBlogPostModify(int id, BlogPostObj blogPostObj) {
		SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
		long timestamp = System.currentTimeMillis();
		sql.insertDB("UPDATE blog_posts SET account_id=" + blogPostObj.account_id + ", locales_id="
				+ blogPostObj.locales_id + ", blog_category_id=" + blogPostObj.blog_category_id + ", title=\""
				+ blogPostObj.title + "\", content=\"" + blogPostObj.content + "\", modify_timestamp=" + timestamp
				+ " WHERE id = " + id);
		sql.closeDB();
	}
}

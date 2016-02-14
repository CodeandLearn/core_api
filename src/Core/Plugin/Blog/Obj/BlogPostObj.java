package Core.Plugin.Blog.Obj;

import java.sql.Timestamp;

public class BlogPostObj {
	public int id;
	public int account_id;
	public int locales_id;
	public int blog_category_id;
	public String title;
	public String content;
	public Timestamp create_timestamp;
	public Timestamp modify_timestamp;
}

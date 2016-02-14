package Core.Plugin.Blog.GET.Obj;

import java.sql.Timestamp;

public class BlogPostGetObj {
	public int id;
	public int account_id;
	public int locales_id;
	public int blog_category_id;
	public String title;
	public String content;
	public Timestamp create_timestamp;
	public Timestamp modify_timestamp;
}

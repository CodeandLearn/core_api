package Core.Plugin.Blog.GET.Obj;

import java.sql.Timestamp;

public class BlogCommentGetObj {
	public int id;
	public int account_id;
	public int blog_post_id;
	public String content;
	public Timestamp create_timestamp;
	public Timestamp modify_timestamp;
}

package Core.Plugin.Blog.GET.Obj;

import java.sql.Timestamp;

public class BlogCommentGetObj {
	public Integer id;
	public Integer account_id;
	public Integer blog_post_id;
	public String content;
	public Timestamp create_timestamp;
	public Timestamp modify_timestamp;
}

package Core.Plugin.Blog.Obj;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BlogPostObj {
	public int id;
	@NotNull
	public int account_id;
	@NotNull
	public int locales_id;
	@NotNull
	public int blog_category_id;
	@NotEmpty
	public String title;
	@NotEmpty
	public String content;
	public Timestamp create_timestamp;
	public Timestamp modify_timestamp;
}

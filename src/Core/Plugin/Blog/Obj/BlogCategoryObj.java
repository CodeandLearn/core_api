package Core.Plugin.Blog.Obj;

import org.hibernate.validator.constraints.NotEmpty;

public class BlogCategoryObj {
	public int id;
	@NotEmpty
	public String name;
}

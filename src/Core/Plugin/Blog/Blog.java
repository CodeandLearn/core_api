package Core.Plugin.Blog;

import javax.servlet.http.HttpServletRequest;

import Core.Plugin.Default.Default;

public class Blog extends Default {
	private Integer id;

	public Blog(HttpServletRequest request, Integer test) {
		super(request);
		this.id = test;
	}

	public Integer getId() {
		return id;
	}
}

package Core.Plugin.BlogPost;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Default.Default;

@RestController
public class BlogPostController {
	@RequestMapping(value = "/blog_post/list", method = RequestMethod.GET)
	public Default blogPostList() {
		return new Default("BlogPostList");
	}

	@RequestMapping(value = "/blog_post/categories", method = RequestMethod.GET)
	public Default blogPostCategories() {
		return new Default("BlogPostCategories");
	}

	@RequestMapping(value = "/blog_post/comment/", method = RequestMethod.GET)
	public Default blogPostComment(@RequestParam(value = "id") Integer id) {
		return new Default(String.valueOf(id));
	}
}

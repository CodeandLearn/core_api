package Core.Plugin.Blog;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Default.Default;

@RestController
public class BlogController {
	/*
	 * GET
	 */
	@RequestMapping(value = "/blog/post/{id}", method = RequestMethod.GET)
	public Blog blogPostId(@PathVariable int id, HttpServletRequest request) {
		return new Blog(request, id);
	}

	@RequestMapping(value = "/blog/post", method = RequestMethod.GET)
	public Default blogPost(HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/blog/post/category/{id}", method = RequestMethod.GET)
	public Default blogPostCategory(HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/blog/post/comment/{id}", method = RequestMethod.GET)
	public Default blogPostCommentId(HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/blog/post/comment", method = RequestMethod.GET)
	public Default blogPostComment(HttpServletRequest request) {
		return new Default(request);
	}

	/*
	 * DELETE
	 */
	@RequestMapping(value = "/blog/post/delete/{id}", method = RequestMethod.DELETE)
	public Default blogPostDelete(HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/blog/post/category/delete/{id}", method = RequestMethod.DELETE)
	public Default blogPostCategoryDelete(HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/blog/post/comment/delete/{id}", method = RequestMethod.DELETE)
	public Default blogPostCommentDelete(HttpServletRequest request) {
		return new Default(request);
	}

	/*
	 * PUT
	 */
	@RequestMapping(value = "/blog/post/create", method = RequestMethod.PUT)
	public Default blogPostCreate(HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/blog/post/category/create", method = RequestMethod.PUT)
	public Default blogPostCategoryCreate(HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/blog/post/comment/create", method = RequestMethod.PUT)
	public Default blogPostCommentCreate(HttpServletRequest request) {
		return new Default(request);
	}

	/*
	 * POST
	 */
	@RequestMapping(value = "/blog/post/modify", method = RequestMethod.POST)
	public Default blogPostModify(HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/blog/post/category/modify", method = RequestMethod.POST)
	public Default blogPostCategoryModify(HttpServletRequest request) {
		return new Default(request);
	}

	@RequestMapping(value = "/blog/post/comment/modify", method = RequestMethod.POST)
	public Default blogPostCommentModify(HttpServletRequest request) {
		return new Default(request);
	}
}

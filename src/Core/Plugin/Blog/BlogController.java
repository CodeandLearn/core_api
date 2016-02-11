package Core.Plugin.Blog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Blog.GET.BlogPostCategoryGet;
import Core.Plugin.Blog.GET.BlogPostCategoryIdGet;
import Core.Plugin.Blog.GET.BlogPostCommentGet;
import Core.Plugin.Blog.GET.BlogPostCommentIdGet;
import Core.Plugin.Blog.GET.BlogPostGet;
import Core.Plugin.Blog.GET.BlogPostIdGet;
import Core.Plugin.Default.Default;

@RestController
public class BlogController {
	/*
	 * GET
	 */
	@RequestMapping(value = "/blog/post/{id}", method = RequestMethod.GET)
	public BlogPostIdGet blogPostIdGet(@PathVariable int id, HttpServletRequest request, HttpServletResponse reply) {
		return new BlogPostIdGet(request, reply, id);
	}

	@RequestMapping(value = "/blog/post", method = RequestMethod.GET)
	public BlogPostGet blogPostGet(HttpServletRequest request, HttpServletResponse reply) {
		return new BlogPostGet(request, reply, 0);
	}
	
	@RequestMapping(value = "/blog/post/limit/{limit}", method = RequestMethod.GET)
	public BlogPostGet blogPostLimitGet(@PathVariable int limit, HttpServletRequest request, HttpServletResponse reply) {
		return new BlogPostGet(request, reply, limit);
	}

	@RequestMapping(value = "/blog/post/category/{id}", method = RequestMethod.GET)
	public Default blogPostCategoryIdGet(@PathVariable int id, HttpServletRequest request, HttpServletResponse reply) {
		return new BlogPostCategoryIdGet(request, reply, id);
	}
	
	@RequestMapping(value = "/blog/post/category", method = RequestMethod.GET)
	public Default blogPostCategoryGet(HttpServletRequest request, HttpServletResponse reply) {
		return new BlogPostCategoryGet(request, reply);
	}

	@RequestMapping(value = "/blog/post/comment/one/{id}", method = RequestMethod.GET)
	public Default blogPostCommentIdGet(@PathVariable int id, HttpServletRequest request, HttpServletResponse reply) {
		return new BlogPostCommentIdGet(request, reply, id);
	}

	@RequestMapping(value = "/blog/post/comment/{blog_post_id}", method = RequestMethod.GET)
	public Default blogPostCommentGet(@PathVariable int blog_post_id, HttpServletRequest request, HttpServletResponse reply) {
		return new BlogPostCommentGet(request, reply, blog_post_id);
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

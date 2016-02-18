package Core.Plugin.Blog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Core.Plugin.Blog.DELETE.BlogPostCategoryDelete;
import Core.Plugin.Blog.DELETE.BlogPostCommentDelete;
import Core.Plugin.Blog.DELETE.BlogPostDelete;
import Core.Plugin.Blog.GET.BlogPostCategoryGet;
import Core.Plugin.Blog.GET.BlogPostCategoryIdGet;
import Core.Plugin.Blog.GET.BlogPostCommentGet;
import Core.Plugin.Blog.GET.BlogPostCommentIdGet;
import Core.Plugin.Blog.GET.BlogPostGet;
import Core.Plugin.Blog.GET.BlogPostIdGet;
import Core.Plugin.Blog.Obj.BlogCategoryObj;
import Core.Plugin.Blog.Obj.BlogCommentObj;
import Core.Plugin.Blog.Obj.BlogPostObj;
import Core.Plugin.Blog.POST.BlogPostCategoryModify;
import Core.Plugin.Blog.POST.BlogPostCommentModify;
import Core.Plugin.Blog.POST.BlogPostModify;
import Core.Plugin.Blog.PUT.BlogPostCategoryCreate;
import Core.Plugin.Blog.PUT.BlogPostCommentCreate;
import Core.Plugin.Blog.PUT.BlogPostCreate;

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
	public BlogPostGet blogPostLimitGet(@PathVariable int limit, HttpServletRequest request,
			HttpServletResponse reply) {
		return new BlogPostGet(request, reply, limit);
	}

	@RequestMapping(value = "/blog/post/category/{id}", method = RequestMethod.GET)
	public BlogPostCategoryIdGet blogPostCategoryIdGet(@PathVariable int id, HttpServletRequest request,
			HttpServletResponse reply) {
		return new BlogPostCategoryIdGet(request, reply, id);
	}

	@RequestMapping(value = "/blog/post/category", method = RequestMethod.GET)
	public BlogPostCategoryGet blogPostCategoryGet(HttpServletRequest request, HttpServletResponse reply) {
		return new BlogPostCategoryGet(request, reply);
	}

	@RequestMapping(value = "/blog/post/comment/one/{id}", method = RequestMethod.GET)
	public BlogPostCommentIdGet blogPostCommentIdGet(@PathVariable int id, HttpServletRequest request,
			HttpServletResponse reply) {
		return new BlogPostCommentIdGet(request, reply, id);
	}

	@RequestMapping(value = "/blog/post/comment/{blog_post_id}", method = RequestMethod.GET)
	public BlogPostCommentGet blogPostCommentGet(@PathVariable int blog_post_id, HttpServletRequest request,
			HttpServletResponse reply) {
		return new BlogPostCommentGet(request, reply, blog_post_id);
	}

	/*
	 * DELETE
	 */
	@RequestMapping(value = "/blog/post/delete/{id}", method = RequestMethod.DELETE)
	public BlogPostDelete blogPostDelete(@PathVariable int id, HttpServletRequest request, HttpServletResponse reply) {
		return new BlogPostDelete(request, reply, id);
	}

	@RequestMapping(value = "/blog/post/category/delete/{id}", method = RequestMethod.DELETE)
	public BlogPostCategoryDelete blogPostCategoryDelete(@PathVariable int id, HttpServletRequest request,
			HttpServletResponse reply) {
		return new BlogPostCategoryDelete(request, reply, id);
	}

	@RequestMapping(value = "/blog/post/comment/delete/{id}", method = RequestMethod.DELETE)
	public BlogPostCommentDelete blogPostCommentDelete(@PathVariable int id, HttpServletRequest request,
			HttpServletResponse reply) {
		return new BlogPostCommentDelete(request, reply, id);
	}

	/*
	 * PUT
	 */
	@RequestMapping(value = "/blog/post/create", method = RequestMethod.PUT)
	public BlogPostCreate blogPostCreate(@Valid @RequestBody BlogPostObj blogPostObj, HttpServletRequest request,
			HttpServletResponse reply) {
		return new BlogPostCreate(request, reply, blogPostObj);
	}

	@RequestMapping(value = "/blog/post/category/create", method = RequestMethod.PUT)
	public BlogPostCategoryCreate blogPostCategoryCreate(@Valid @RequestBody BlogCategoryObj blogCategoryObj,
			HttpServletRequest request, HttpServletResponse reply) {
		return new BlogPostCategoryCreate(request, reply, blogCategoryObj);
	}

	@RequestMapping(value = "/blog/post/comment/create", method = RequestMethod.PUT)
	public BlogPostCommentCreate blogPostCommentCreate(@Valid @RequestBody BlogCommentObj blogCommentObj,
			HttpServletRequest request, HttpServletResponse reply) {
		return new BlogPostCommentCreate(request, reply, blogCommentObj);
	}

	/*
	 * POST
	 */
	@RequestMapping(value = "/blog/post/modify/{id}", method = RequestMethod.POST)
	public BlogPostModify blogPostModify(@PathVariable int id, @Valid @RequestBody BlogPostObj blogPostObj,
			HttpServletRequest request, HttpServletResponse reply) {
		return new BlogPostModify(request, reply, id, blogPostObj);
	}

	@RequestMapping(value = "/blog/post/category/modify/{id}", method = RequestMethod.POST)
	public BlogPostCategoryModify blogPostCategoryModify(@PathVariable int id,
			@Valid @RequestBody BlogCategoryObj blogCategoryObj, HttpServletRequest request,
			HttpServletResponse reply) {
		return new BlogPostCategoryModify(request, reply, id, blogCategoryObj);
	}

	@RequestMapping(value = "/blog/post/comment/modify/{id}", method = RequestMethod.POST)
	public BlogPostCommentModify blogPostCommentModify(@PathVariable int id,
			@Valid @RequestBody BlogCommentObj blogCommentObj, HttpServletRequest request, HttpServletResponse reply) {
		return new BlogPostCommentModify(request, reply, id, blogCommentObj);
	}
}

package Core.Plugins.Blog;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@RestController
public class BlogController {
    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public GetBlog getBlog(HttpServletRequest request, HttpServletResponse reply) throws SQLException {
        return new GetBlog(request, reply);
    }

    @RequestMapping(value = "/blog/limit/{limit}", method = RequestMethod.GET)
    public GetBlog getBlogWithLimit(HttpServletRequest request, HttpServletResponse reply, @PathVariable int limit) throws SQLException {
        return new GetBlog(request, reply, "", limit);
    }

    @RequestMapping(value = "/blog/author/{author_name}", method = RequestMethod.GET)
    public GetBlog getBlogByAuthor(HttpServletRequest request, HttpServletResponse reply, @PathVariable String author_name) throws SQLException {
        return new GetBlog(request, reply, "accounts.username='" + author_name + "'");
    }

    @RequestMapping(value = "/blog/author/id/{author_id}", method = RequestMethod.GET)
    public GetBlog getBlogByAuthorId(HttpServletRequest request, HttpServletResponse reply, @PathVariable int author_id) throws SQLException {
        return new GetBlog(request, reply, "accounts.id=" + author_id);
    }

    @RequestMapping(value = "/blog/category/{category_name}", method = RequestMethod.GET)
    public GetBlog getBlogByCategory(HttpServletRequest request, HttpServletResponse reply, @PathVariable String category_name) throws SQLException {
        return new GetBlog(request, reply, "blog_posts_category.name='" + category_name + "'");
    }

    @RequestMapping(value = "/blog/category/id/{category_id}", method = RequestMethod.GET)
    public GetBlog getBlogByCategoryId(HttpServletRequest request, HttpServletResponse reply, @PathVariable int category_id) throws SQLException {
        return new GetBlog(request, reply, "blog_posts_category.id=" + category_id);
    }

    @RequestMapping(value = "/blog/{post_id}", method = RequestMethod.GET)
    public GetBlog getBlogById(HttpServletRequest request, HttpServletResponse reply, @PathVariable int post_id) throws SQLException {
        return new GetBlog(request, reply, "blog_posts.id=" + post_id);
    }

    @RequestMapping(value = "/blog/categories", method = RequestMethod.GET)
    public GetBlogCategories getBlogCategories(HttpServletRequest request, HttpServletResponse reply) throws SQLException {
        return new GetBlogCategories(request, reply);
    }

    @RequestMapping(value = "/blog/comments", method = RequestMethod.GET)
    public GetBlogComments getBlogComments(HttpServletRequest request, HttpServletResponse reply) throws SQLException {
        return new GetBlogComments(request, reply);
    }

    @RequestMapping(value = "/blog/comments/limit/{limit}", method = RequestMethod.GET)
    public GetBlogComments getBlogCommentsWithLimit(HttpServletRequest request, HttpServletResponse reply, @PathVariable int limit) throws SQLException {
        return new GetBlogComments(request, reply, "", limit);
    }

    @RequestMapping(value = "/blog/comment/{id}", method = RequestMethod.GET)
    public GetBlogComments getBlogComment(HttpServletRequest request, HttpServletResponse reply, @PathVariable int id) throws SQLException {
        return new GetBlogComments(request, reply, "blog_posts_comments.id=" + id);
    }

    @RequestMapping(value = "/blog/comment/post/{post_id}", method = RequestMethod.GET)
    public GetBlogComments getBlogCommentByPostId(HttpServletRequest request, HttpServletResponse reply, @PathVariable int post_id) throws SQLException {
        return new GetBlogComments(request, reply, "blog_posts_comments.blog_post_id=" + post_id);
    }

    @RequestMapping(value = "/blog/comment/author/{author_name}", method = RequestMethod.GET)
    public GetBlogComments getBlogComment(HttpServletRequest request, HttpServletResponse reply, @PathVariable String author_name) throws SQLException {
        return new GetBlogComments(request, reply, "accounts.username='" + author_name + "'");
    }

    @RequestMapping(value = "/blog/comment/author/id/{author_id}", method = RequestMethod.GET)
    public GetBlogComments getBlogComments(HttpServletRequest request, HttpServletResponse reply, @PathVariable int author_id) throws SQLException {
        return new GetBlogComments(request, reply, "accounts.id=" + author_id);
    }
}

package Plugin.Blog;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Blog.Model.*;
import org.json.JSONObject;

/**
 * Created by teddy on 10/06/2016.
 */
@Controller
public class BlogController {
    @Methode("GET")
    @Route("/blog")
    public GetPosts getBlog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlog(socket);
    }

    @Methode("GET")
    @Route("/blog/limit/{limit}")
    public GetPosts getBlogWithLimit(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlogWithLimit(socket, args.getInt("limit"));
    }

    @Methode("GET")
    @Route("/blog/author/{author_name}")
    public GetPosts getBlogByAuthor(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlogByAuthoName(socket, args.getString("author_name"));
    }

    @Methode("GET")
    @Route("/blog/author/id/{author_id}")
    public GetPosts getBlogByAuthorId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlogByAuthorId(socket, args.getInt("author_id"));
    }

    @Methode("GET")
    @Route("/blog/category/{category_name}")
    public GetPosts getBlogByCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlogByCategory(socket, args.getString("category_name"));
    }

    @Methode("GET")
    @Route("/blog/category/id/{category_id}")
    public GetPosts getBlogByCategoryId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlogByCategoryId(socket, args.getInt("category_id"));
    }

    @Methode("GET")
    @Route("/blog/{post_id}")
    public GetPosts getBlogById(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlogById(socket, args.getInt("post_id"));
    }

    @Methode("GET")
    @Route("/blog/categories")
    public GetCategories getBlogCategories(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetCategories().getBlogCategories(socket);
    }

    @Methode("GET")
    @Route("/blog/comments")
    public GetComments getBlogComments(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetComments().getBlogComments(socket);
    }

    @Methode("GET")
    @Route("/blog/comments/limit/{limit}")
    public GetComments getBlogCommentsWithLimit(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetComments().getBlogCommentsWithLimit(socket, args.getInt("limit"));
    }

    @Methode("GET")
    @Route("/blog/comment/{id}")
    public GetComments getBlogComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetComments().getBlogComment(socket, args.getInt("id"));
    }

    @Methode("GET")
    @Route("/blog/comment/post/{post_id}")
    public GetComments getBlogCommentByPostId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetComments().getBlogCommentByPostId(socket, args.getInt("post_id"));
    }

    @Methode("GET")
    @Route("/blog/comment/author/{author_name}")
    public GetComments getBlogCommentByAuthorName(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetComments().getBlogCommentByAuthorName(socket, args.getString("author_name"));
    }

    @Methode("GET")
    @Route("/blog/comment/author/id/{author_id}")
    public GetComments getBlogCommentByAuthorId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetComments().getBlogCommentByAuthorId(socket, args.getInt("author_id"));
    }

    @Methode("POST")
    @Route("/blog")
    public Post postBlog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Post().postBlog(socket, UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("POST")
    @Route("/blog/category")
    public Post postBlogCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Post().postBlogCategory(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/blog/comment")
    public Post postBlogComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Post().postBlogComment(socket, UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("PUT")
    @Route("/blog/{id}")
    public Put putBlog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Put().putBlog(socket, args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/blog/category/{id}")
    public Put putBlogCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Put().putBlogCategory(socket, args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/blog/comment/{id}")
    public Put putBlogComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Put().putBlogComment(socket, args.getInt("id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/blog/{id}")
    public Delete deleteBlog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Delete().deleteBlog(socket, args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/blog/category/{id}")
    public Delete deleteBlogCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Delete().deleteBlogCategory(socket, args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/blog/comment/{id}")
    public Delete deleteBlogComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Delete().deleteBlogComment(socket, args.getInt("id"));
    }

    // TODO: 25/05/2016 Ajouter une route pour qu'un utilisateur puisse supprimer un de ses commentaire !
}

package Plugin.Blog;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Blog.Model.*;
import Plugin.History.Model.HistoryModel;
import org.json.JSONObject;

/**
 * Created by teddy on 10/06/2016.
 */
@Controller
public class BlogController {
    @Methode("GET")
    @Route("/locales")
    public Local getLocales(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Local().getLocales();
    }

    @Methode("GET")
    @Route("/blog")
    public GetPosts getBlog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlog();
    }

    @Methode("GET")
    @Route("/blog/limit/{limit}")
    public GetPosts getBlogWithLimit(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlogWithLimit(args.getInt("limit"));
    }

    @Methode("GET")
    @Route("/blog/author/{author_name}")
    public GetPosts getBlogByAuthor(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlogByAuthoName(args.getString("author_name"));
    }

    @Methode("GET")
    @Route("/blog/author/id/{author_id}")
    public GetPosts getBlogByAuthorId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlogByAuthorId(args.getInt("author_id"));
    }

    @Methode("GET")
    @Route("/blog/category/{category_name}")
    public GetPosts getBlogByCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlogByCategory(args.getString("category_name"));
    }

    @Methode("GET")
    @Route("/blog/category/id/{category_id}")
    public GetPosts getBlogByCategoryId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlogByCategoryId(args.getInt("category_id"));
    }

    @Methode("GET")
    @Route("/blog/{post_id}")
    public GetPosts getBlogById(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetPosts().getBlogById(args.getInt("post_id"));
    }

    @Methode("GET")
    @Route("/blog/categories")
    public GetCategories getBlogCategories(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetCategories().getBlogCategories();
    }

    @Methode("GET")
    @Route("/blog/comments")
    public GetComments getBlogComments(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetComments().getBlogComments();
    }

    @Methode("GET")
    @Route("/blog/comments/limit/{limit}")
    public GetComments getBlogCommentsWithLimit(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetComments().getBlogCommentsWithLimit(args.getInt("limit"));
    }

    @Methode("GET")
    @Route("/blog/comment/{id}")
    public GetComments getBlogComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetComments().getBlogComment(args.getInt("id"));
    }

    @Methode("GET")
    @Route("/blog/comment/post/{post_id}")
    public GetComments getBlogCommentByPostId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetComments().getBlogCommentByPostId(args.getInt("post_id"));
    }

    @Methode("GET")
    @Route("/blog/comment/author/{author_name}")
    public GetComments getBlogCommentByAuthorName(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetComments().getBlogCommentByAuthorName(args.getString("author_name"));
    }

    @Methode("GET")
    @Route("/blog/comment/author/id/{author_id}")
    public GetComments getBlogCommentByAuthorId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetComments().getBlogCommentByAuthorId(args.getInt("author_id"));
    }

    @Methode("POST")
    @Route("/blog")
    public Post postBlog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        new HistoryModel().postHistory(UserSecuritySingleton.getInstance().getUserId(socket), "blog", "ajouté un nouveau post.", 0);
        return new Post().postBlog(UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("POST")
    @Route("/blog/category")
    public Post postBlogCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Post().postBlogCategory(jsonObject);
    }

    @Methode("POST")
    @Route("/blog/comment")
    public Post postBlogComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        new HistoryModel().postHistory(UserSecuritySingleton.getInstance().getUserId(socket), "blog", "posté un nouveau commentaire.", 0);
        return new Post().postBlogComment(UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("PUT")
    @Route("/blog/{id}")
    public Put putBlog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        new HistoryModel().postHistory(UserSecuritySingleton.getInstance().getUserId(socket), "blog", "modifié un post.", 0);
        return new Put().putBlog(args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/blog/category/{id}")
    public Put putBlogCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Put().putBlogCategory(args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/blog/comment/{id}")
    public Put putBlogComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        new HistoryModel().postHistory(UserSecuritySingleton.getInstance().getUserId(socket), "blog", "modifié un commentaire.", 0);
        return new Put().putBlogComment(args.getInt("id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/blog/{id}")
    public Delete deleteBlog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        new HistoryModel().postHistory(UserSecuritySingleton.getInstance().getUserId(socket), "blog", "supprimé un post.", 0);
        return new Delete().deleteBlog(args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/blog/category/{id}")
    public Delete deleteBlogCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Delete().deleteBlogCategory(args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/blog/comment/{id}")
    public Delete deleteBlogComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        new HistoryModel().postHistory(UserSecuritySingleton.getInstance().getUserId(socket), "blog", "à supprimé un commentaire.", 0);
        return new Delete().deleteBlogComment(args.getInt("id"));
    }

    // TODO: 25/05/2016 Ajouter une route pour qu'un utilisateur puisse supprimer un de ses commentaire !
}

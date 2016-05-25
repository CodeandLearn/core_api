package Plugin;

import Core.Controller;
import Core.Http.Oauth2;
import Core.Http.Oauth2Model;
import Core.Methode;
import Core.Model;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Account.DeleteAccount;
import Plugin.Account.GetAccount;
import Plugin.Account.PostAccount;
import Plugin.Account.PutAccount;
import Plugin.Blog.*;
import Plugin.Course.*;
import Plugin.Language.DeleteLanguage;
import Plugin.Language.GetLanguage;
import Plugin.Language.PostLanguage;
import Plugin.Language.PutLanguage;
import Plugin.Server.Model.Server;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by teddy on 04/05/2016.
 */
@Controller
public class Path {
    @Methode("POST")
    @Route("/oauth")
    public Oauth2Model getToken(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Oauth2Model(socket, oauth2);
    }

    @Methode("DELETE")
    @Route("/revoke")
    public Model revokeToken(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        UserSecuritySingleton.getInstance().revokUserToken(socket);
        return new Model();
    }

    @Methode("GET")
    @Route("/server")
    public Server getServer(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Server(socket);
    }

    /* ACCOUNT */
    @Methode("GET")
    @Route("/accounts")
    public GetAccount getAccounts(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetAccount(socket);
    }

    @Methode("GET")
    @Route("/accounts/limit/{limit}")
    public GetAccount getAccountWithLimit(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetAccount(socket, "", (int) args.get("limit"));
    }

    @Methode("GET")
    @Route("/account")
    public GetAccount getAccount(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetAccount(socket, "accounts.id=" + UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("GET")
    @Route("/account/{id}")
    public GetAccount getAccountById(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetAccount(socket, "accounts.id=" + (int) args.get("id"));
    }

    @Methode("POST")
    @Route("/register")
    public PostAccount register(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PostAccount(socket, jsonObject);
    }

    @Methode("PUT")
    @Route("/account")
    public PutAccount putAccount(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutAccount(socket, (int) UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("PUT")
    @Route("/account/{id}")
    public PutAccount putAccountById(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutAccount(socket, (int) args.get("id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/account")
    public DeleteAccount deleteAccount(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteAccount(socket, (int) UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("DELETE")
    @Route("/account/{id}")
    public DeleteAccount deleteAccountById(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteAccount(socket, (int) args.get("id"));
    }

    /* BLOG */
    @Methode("GET")
    @Route("/blog")
    public GetBlog getBlog(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlog(socket);
    }

    @Methode("GET")
    @Route("/blog/limit/{limit}")
    public GetBlog getBlogWithLimit(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlog(socket, "", (int) args.get("limit"));
    }

    @Methode("GET")
    @Route("/blog/author/{author_name}")
    public GetBlog getBlogByAuthor(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlog(socket, "accounts.username='" + args.get("author_name") + "'");
    }

    @Methode("GET")
    @Route("/blog/author/id/{author_id}")
    public GetBlog getBlogByAuthorId(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlog(socket, "accounts.id=" + args.get("author_id"));
    }

    @Methode("GET")
    @Route("/blog/category/{category_name}")
    public GetBlog getBlogByCategory(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlog(socket, "blog_posts_category.name='" + args.get("category_name") + "'");
    }

    @Methode("GET")
    @Route("/blog/category/id/{category_id}")
    public GetBlog getBlogByCategoryId(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlog(socket, "blog_posts_category.id=" + args.get("category_id"));
    }

    @Methode("GET")
    @Route("/blog/{post_id}")
    public GetBlog getBlogById(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlog(socket, "blog_posts.id=" + args.get("post_id"));
    }

    @Methode("GET")
    @Route("/blog/categories")
    public GetBlogCategories getBlogCategories(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlogCategories(socket);
    }

    @Methode("GET")
    @Route("/blog/comments")
    public GetBlogComments getBlogComments(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlogComments(socket);
    }

    @Methode("GET")
    @Route("/blog/comments/limit/{limit}")
    public GetBlogComments getBlogCommentsWithLimit(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlogComments(socket, "", (int) args.get("limit"));
    }

    @Methode("GET")
    @Route("/blog/comment/{id}")
    public GetBlogComments getBlogComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlogComments(socket, "blog_posts_comments.id=" + args.get("id"));
    }

    @Methode("GET")
    @Route("/blog/comment/post/{post_id}")
    public GetBlogComments getBlogCommentByPostId(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlogComments(socket, "blog_posts_comments.blog_post_id=" + args.get("post_id"));
    }

    @Methode("GET")
    @Route("/blog/comment/author/{author_name}")
    public GetBlogComments getBlogCommentByAuthorName(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlogComments(socket, "accounts.username='" + args.get("author_name") + "'");
    }

    @Methode("GET")
    @Route("/blog/comment/author/id/{author_id}")
    public GetBlogComments getBlogCommentByAuthorId(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetBlogComments(socket, "accounts.id=" + args.get("author_id"));
    }

    @Methode("POST")
    @Route("/blog")
    public PostBlog postBlog(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PostBlog(socket, jsonObject, (int) UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("POST")
    @Route("/blog/category")
    public PostBlogCategory postBlogCategory(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PostBlogCategory(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/blog/comment")
    public PostBlogComment postBlogComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PostBlogComment(socket, jsonObject, (int) UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("PUT")
    @Route("/blog/{id}")
    public PutBlog putBlog(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutBlog(socket, (int) args.get("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/blog/category/{id}")
    public PutBlogCategory putBlogCategory(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutBlogCategory(socket, (int) args.get("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/blog/comment/{id}")
    public PutBlogComment putBlogComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutBlogComment(socket, (int) args.get("id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/blog/{id}")
    public DeleteBlog deleteBlog(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteBlog(socket, (int) args.get("id"));
    }

    @Methode("DELETE")
    @Route("/blog/category/{id}")
    public DeleteBlogCategory deleteBlogCategory(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteBlogCategory(socket, (int) args.get("id"));
    }

    @Methode("DELETE")
    @Route("/blog/comment/{id}")
    public DeleteBlogComment deleteBlogComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteBlogComment(socket, (int) args.get("id"));
    }

    // TODO: 25/05/2016 Ajouter une route pour qu'un utilisateur puisse supprimer un de ses commentaire !

    /* Cours */
    @Methode("GET")
    @Route("/course")
    public GetCourse getCourse(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetCourse(socket);
    }

    @Methode("GET")
    @Route("/course/limit/{limit}")
    public GetCourse getCourseWithLimit(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetCourse(socket, "", (int) args.get("limit"));
    }

    @Methode("GET")
    @Route("/course/author/id/{author_id}")
    public GetCourse getCourseByAuthorId(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetCourse(socket, "courses.account_id=" + args.get("author_id"));
    }

    @Methode("GET")
    @Route("/course/language/id/{language_id}")
    public GetCourse getCourseByLanguageId(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetCourse(socket, "courses.language_id=" + args.get("language_id"));
    }

    @Methode("GET")
    @Route("/course/locales/id/{locales_id}")
    public GetCourse getCourseByLocalesId(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetCourse(socket, "courses.locales_id=" + args.get("locales_id"));
    }

    @Methode("GET")
    @Route("/course/title/{title}")
    public GetCourse getCourseByTitle(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetCourse(socket, "courses.title=" + args.get("title"));
    }

    @Methode("POST")
    @Route("/course")
    public PostCourse postCourse(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PostCourse(socket, jsonObject, (int) UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("POST")
    @Route("/course/comment")
    public PostCourseComment postCourseComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PostCourseComment(socket, jsonObject, (int) UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("PUT")
    @Route("/course/{id}")
    public PutCourse putCourse(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutCourse(socket, (int) args.get("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/course/comment/{id}")
    public PutCourseComment putCourseComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutCourseComment(socket, (int) args.get("id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/course/{id}")
    public DeleteCourse deleteCourse(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteCourse(socket, (int) args.get("id"));
    }

    @Methode("DELETE")
    @Route("/course/comment/{id}")
    public DeleteCourseComment deleteCourseComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteCourseComment(socket, (int) args.get("id"));
    }

    /* Language */
    @Methode("GET")
    @Route("/languages")
    public GetLanguage getLanguage(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetLanguage(socket);
    }

    @Methode("GET")
    @Route("/language/limit/{limit}")
    public GetLanguage getLanguageWithLimit(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetLanguage(socket, "", (int) args.get("limit"));
    }

    @Methode("GET")
    @Route("/language/{id}")
    public GetLanguage getLanguageById(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetLanguage(socket, "languages.id=" + args.get("id"));
    }

    @Methode("DELETE")
    @Route("/language/{id}")
    public DeleteLanguage deleteLanguage(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteLanguage(socket, (int) args.get("id"));
    }

    @Methode("POST")
    @Route("/language")
    public PostLanguage postLanguage(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PostLanguage(socket, jsonObject);
    }

    @Methode("PUT")
    @Route("/language/{id}")
    public PutLanguage putLanguage(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutLanguage(socket, (int) args.get("id"), jsonObject);
    }
}
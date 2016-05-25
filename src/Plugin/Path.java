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
import Plugin.Exercice.dao.ExerciseDAO;
import Plugin.Language.DeleteLanguage;
import Plugin.Language.GetLanguage;
import Plugin.Language.PostLanguage;
import Plugin.Language.PutLanguage;
import Plugin.Server.Model.Server;
import org.json.JSONObject;

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
        return new GetAccount(socket, "", Integer.parseInt(args.get("limit").toString()));
    }

    @Methode("GET")
    @Route("/account")
    public GetAccount getAccount(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetAccount(socket, "accounts.id=" + UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("GET")
    @Route("/account/{id}")
    public GetAccount getAccountById(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetAccount(socket, "accounts.id=" + args.get("id").toString());
    }

    @Methode("POST")
    @Route("/register")
    public PostAccount register(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PostAccount(socket, jsonObject);
    }

    @Methode("PUT")
    @Route("/account")
    public PutAccount putAccount(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutAccount(socket, UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("PUT")
    @Route("/account/{id}")
    public PutAccount putAccountById(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutAccount(socket, Integer.parseInt(args.get("id").toString()), jsonObject);
    }

    @Methode("DELETE")
    @Route("/account")
    public DeleteAccount deleteAccount(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteAccount(socket, UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("DELETE")
    @Route("/account/{id}")
    public DeleteAccount deleteAccountById(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteAccount(socket, Integer.parseInt(args.get("id").toString()));
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
        return new GetBlog(socket, "", Integer.parseInt(args.get("limit").toString()));
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
        return new GetBlogComments(socket, "", Integer.parseInt(args.get("limit").toString()));
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
        return new PostBlog(socket, jsonObject, UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("POST")
    @Route("/blog/category")
    public PostBlogCategory postBlogCategory(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PostBlogCategory(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/blog/comment")
    public PostBlogComment postBlogComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PostBlogComment(socket, jsonObject, UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("PUT")
    @Route("/blog/{id}")
    public PutBlog putBlog(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutBlog(socket, Integer.parseInt(args.get("id").toString()), jsonObject);
    }

    @Methode("PUT")
    @Route("/blog/category/{id}")
    public PutBlogCategory putBlogCategory(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutBlogCategory(socket, Integer.parseInt(args.get("id").toString()), jsonObject);
    }

    @Methode("PUT")
    @Route("/blog/comment/{id}")
    public PutBlogComment putBlogComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutBlogComment(socket, Integer.parseInt(args.get("id").toString()), jsonObject);
    }

    @Methode("DELETE")
    @Route("/blog/{id}")
    public DeleteBlog deleteBlog(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteBlog(socket, Integer.parseInt(args.get("id").toString()));
    }

    @Methode("DELETE")
    @Route("/blog/category/{id}")
    public DeleteBlogCategory deleteBlogCategory(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteBlogCategory(socket, Integer.parseInt(args.get("id").toString()));
    }

    @Methode("DELETE")
    @Route("/blog/comment/{id}")
    public DeleteBlogComment deleteBlogComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteBlogComment(socket, Integer.parseInt(args.get("id").toString()));
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
        return new GetCourse(socket, "", Integer.parseInt(args.get("limit").toString()));
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
        return new PostCourse(socket, jsonObject, UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("POST")
    @Route("/course/comment")
    public PostCourseComment postCourseComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PostCourseComment(socket, jsonObject, UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("PUT")
    @Route("/course/{id}")
    public PutCourse putCourse(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutCourse(socket, Integer.parseInt(args.get("id").toString()), jsonObject);
    }

    @Methode("PUT")
    @Route("/course/comment/{id}")
    public PutCourseComment putCourseComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutCourseComment(socket, Integer.parseInt(args.get("id").toString()), jsonObject);
    }

    @Methode("DELETE")
    @Route("/course/{id}")
    public DeleteCourse deleteCourse(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteCourse(socket, Integer.parseInt(args.get("id").toString()));
    }

    @Methode("DELETE")
    @Route("/course/comment/{id}")
    public DeleteCourseComment deleteCourseComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteCourseComment(socket, Integer.parseInt(args.get("id").toString()));
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
        return new GetLanguage(socket, "", Integer.parseInt(args.get("limit").toString()));
    }

    @Methode("GET")
    @Route("/language/{id}")
    public GetLanguage getLanguageById(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetLanguage(socket, "languages.id=" + args.get("id"));
    }

    @Methode("DELETE")
    @Route("/language/{id}")
    public DeleteLanguage deleteLanguage(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteLanguage(socket, Integer.parseInt(args.get("id").toString()));
    }

    @Methode("POST")
    @Route("/language")
    public PostLanguage postLanguage(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PostLanguage(socket, jsonObject);
    }

    @Methode("PUT")
    @Route("/language/{id}")
    public PutLanguage putLanguage(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutLanguage(socket, Integer.parseInt(args.get("id").toString()), jsonObject);
    }

    /* Exercises */
    @Methode("GET")
    @Route("/exercises")
    public ExerciseDAO getExercises(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new ExerciseDAO().getExercises(socket);
    }

    @Methode("GET")
    @Route("/exercise/{id}")
    public ExerciseDAO getExerciseById(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new ExerciseDAO().getExerciseById(socket, Integer.parseInt(args.get("id").toString()));
    }

    @Methode("GET")
    @Route("/exercise/course/{course_id}")
    public ExerciseDAO getExercisesByCourseId(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new ExerciseDAO().getCourseExercise(socket, Integer.parseInt(args.get("course_id").toString()));
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/script")
    public Model getExerciseScript(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/correction")
    public Model getExerciseCorrection(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/comments")
    public Model getExerciseComments(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/moderation")
    public Model getExerciseModeration(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("POST")
    @Route("/exercise")
    public ExerciseDAO postExercise(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new ExerciseDAO().post(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/exercise/script")
    public Model postExerciseScript(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("POST")
    @Route("/exercise/correction")
    public Model postExerciseCorrection(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("POST")
    @Route("/exercise/comment")
    public Model postExerciseComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("POST")
    @Route("/exercise/moderation")
    public Model postExerciseModeration(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("PUT")
    @Route("/exercise/{id}")
    public ExerciseDAO putExercise(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new ExerciseDAO().update(socket, Integer.parseInt(args.get("id").toString()), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/script/{script_id}")
    public Model putExerciseScript(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("PUT")
    @Route("/exercise/correction/{correction_id}")
    public Model putExerciseCorrection(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("PUT")
    @Route("/exercise/comment/{comment_id}")
    public Model putExerciseComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("PUT")
    @Route("/exercise/moderation/{moderation_id}")
    public Model putExerciseModeration(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("DELETE")
    @Route("/exercise/{id}")
    public ExerciseDAO deleteExercise(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new ExerciseDAO().delete(socket, Integer.parseInt(args.get("id").toString()));
    }

    @Methode("DELETE")
    @Route("/exercise/script/{script_id}")
    public Model deleteExerciseScript(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("DELETE")
    @Route("/exercise/correction/{correction_id}")
    public Model deleteExerciseCorrection(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("DELETE")
    @Route("/exercise/comments/{comment_id}")
    public Model deleteExerciseComment(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }

    @Methode("DELETE")
    @Route("/exercise/moderation/{moderation_id}")
    public Model deleteExerciseModeration(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Model();
    }
}
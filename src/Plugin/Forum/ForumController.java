package Plugin.Forum;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Forum.Model.*;
import org.json.JSONObject;

/**
 * Created by teddy on 27/11/2016.
 */
@Controller
public class ForumController {
    @Methode("GET")
    @Route("/forum")
    public GeneralForumModel getForum(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GeneralForumModel().getForum();
    }

    @Methode("GET")
    @Route("/forum/{id_forum}")
    public SubjectModel getSubjectByForumId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new SubjectModel().getSubjectByForumId(args.getInt("id_forum"));
    }

    @Methode("GET")
    @Route("/forum/subject/{id_subject}")
    public PostModel getPostBySubjectId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PostModel().getPostBySubjectId(args.getInt("id_subject"));
    }

    @Methode("GET")
    @Route("/forum/categories")
    public CategoryModel getCategories(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CategoryModel().getCategories();
    }

    @Methode("GET")
    @Route("/forum/categories/order/position")
    public CategoryModel getCategoriesByPosition(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CategoryModel().getCategoriesOrderByPosition();
    }

    @Methode("GET")
    @Route("/forum/category/{id_category}")
    public CategoryModel getCategoryById(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CategoryModel().getCategoryById(args.getInt("id_category"));
    }

    @Methode("GET")
    @Route("/forum/icons")
    public IconModel getIcons(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new IconModel().getIcons();
    }

    @Methode("GET")
    @Route("/forum/icon/{id_icon}")
    public IconModel getIconById(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new IconModel().getIconById(args.getInt("id_icon"));
    }

    @Methode("POST")
    @Route("/forum/category")
    public CategoryModel postCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CategoryModel().postCategory(jsonObject);
    }

    @Methode("POST")
    @Route("/forum/forum")
    public ForumModel postForum(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumModel().postForum(jsonObject);
    }

    @Methode("POST")
    @Route("/forum/subject")
    public SubjectModel postSubject(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new SubjectModel().postSubject(UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("POST")
    @Route("/forum/subject/post")
    public PostModel postPost(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PostModel().postPost(UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("POST")
    @Route("/forum/icon")
    public IconModel postIcon(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new IconModel().postIcon(jsonObject);
    }

    @Methode("PUT")
    @Route("/forum/category/{id_category}")
    public CategoryModel putCategoryId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CategoryModel().putCategory(args.getInt("id_category"), jsonObject);
    }

    @Methode("PUT")
    @Route("/forum/forum/{id_forum}")
    public ForumModel putForumId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumModel().putForum(args.getInt("id_forum"), jsonObject);
    }

    @Methode("PUT")
    @Route("/forum/icon/{id_icon}")
    public IconModel putIconId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new IconModel().putIcon(args.getInt("id_icon"), jsonObject);
    }

    @Methode("PUT")
    @Route("/forum/post/{id_post}")
    public PostModel putPostId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PostModel().putPost(UserSecuritySingleton.getInstance().getUserId(socket), args.getInt("id_post"), jsonObject);
    }

    @Methode("PUT")
    @Route("/forum/admin/post/{id_post}")
    public PostModel putAdminPostId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PostModel().putAdminPost(args.getInt("id_post"), jsonObject);
    }

    @Methode("PUT")
    @Route("/forum/post/{id_post}/like")
    public PostModel putPostLike(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PostModel().likePost(args.getInt("id_post"));
    }

    @Methode("PUT")
    @Route("/forum/post/{id_post}/dislike")
    public PostModel putPostDislike(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PostModel().dislikePost(args.getInt("id_post"));
    }

    @Methode("PUT")
    @Route("/forum/subject/{id_subject}")
    public SubjectModel putSubject(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new SubjectModel().putSubject(UserSecuritySingleton.getInstance().getUserId(socket), args.getInt("id_subject"), jsonObject);
    }

    @Methode("PUT")
    @Route("/forum/admin/subject/{id_subject}")
    public SubjectModel putAdminSubject(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new SubjectModel().putAdminSubject(args.getInt("id_subject"), jsonObject);
    }

    @Methode("PUT")
    @Route("/forum/admin/subject/{id_subject}/pin")
    public SubjectModel putAdminSubjectPin(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new SubjectModel().pinSubject(args.getInt("id_subject"));
    }

    @Methode("PUT")
    @Route("/forum/admin/subject/{id_subject}/unpin")
    public SubjectModel putAdminSubjectUnpin(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new SubjectModel().unpinSubject(args.getInt("id_subject"));
    }

    @Methode("DELETE")
    @Route("/forum/category/{id_category}")
    public CategoryModel deleteCategoryId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CategoryModel().deleteCategory(args.getInt("id_category"));
    }

    @Methode("DELETE")
    @Route("/forum/forum/{id_forum}")
    public ForumModel deleteForumId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumModel().deleteForum(args.getInt("id_forum"));
    }

    @Methode("DELETE")
    @Route("/forum/icon/{id_icon}")
    public IconModel deleteIconId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new IconModel().deleteIcon(args.getInt("id_icon"));
    }

    @Methode("DELETE")
    @Route("/forum/post/{id_post}")
    public PostModel deletePostId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PostModel().deletePost(UserSecuritySingleton.getInstance().getUserId(socket), args.getInt("id_post"));
    }

    @Methode("DELETE")
    @Route("/forum/admin/post/{id_post}")
    public PostModel deleteAdminPostId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PostModel().deleteAdminPost(args.getInt("id_post"));
    }

    @Methode("DELETE")
    @Route("/forum/subject/{id_subject}")
    public SubjectModel deleteSubjectId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new SubjectModel().deleteSubject(UserSecuritySingleton.getInstance().getUserId(socket), args.getInt("id_subject"));
    }

    @Methode("DELETE")
    @Route("/forum/admin/subject/{id_subject}")
    public SubjectModel deleteAdminSubjectId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new SubjectModel().deleteAdminSubject(args.getInt("id_subject"));
    }
}
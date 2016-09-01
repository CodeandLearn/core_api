package Plugin.Forum;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Plugin.Forum.Model.ForumCategoryModel;
import Plugin.Forum.Model.ForumModel;
import Plugin.Forum.Model.ForumPostModel;
import Plugin.Forum.Model.ForumSubjectModel;
import org.json.JSONObject;

/**
 * Created by moran on 9/1/2016.
 */
@Controller
public class ForumController {

    @Methode("GET")
    @Route("/forum_categories")
    public ForumCategoryModel getForumCategories(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumCategoryModel().getForumCategories(socket);
    }

    @Methode("GET")
    @Route("/forums/{category_id}")
    public ForumModel getForumsInCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumModel().getForums(socket, args.getInt("category_id"));
    }
    @Methode("GET")
    @Route("/forum_subjects/{forum_id}")
    public ForumSubjectModel getSubjectsInForum(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumSubjectModel().getSubjects(socket, args.getInt("forum_id"));
    }

    @Methode("GET")
    @Route("/forum_posts/{subject_id}")
    public ForumPostModel getPostInSubject(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumPostModel().getPosts(socket, args.getInt("subject_id"));
    }

    @Methode("POST")
    @Route("/forum_category")
    public ForumCategoryModel addForumCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumCategoryModel().addCategory(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/forum")
    public ForumModel addForum(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumModel().insert(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/forum_subject")
    public ForumSubjectModel addSubject(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumSubjectModel().insert(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/forum_post")
    public ForumPostModel addPost(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumPostModel().insert(socket, jsonObject);
    }

    @Methode("PUT")
    @Route("/forum_category/{id}")
    public ForumCategoryModel updateCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumCategoryModel().modifyCategory(socket, args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/forum/{id}")
    public ForumModel updateForum(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumModel().update(socket, args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/forum_subject/{id}")
    public ForumSubjectModel updateSubject(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumSubjectModel().update(socket, args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/forum_post/{id}")
    public ForumPostModel updatePost(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumPostModel().update(socket, args.getInt("id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/forum_category/{id}")
    public ForumCategoryModel deleteCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumCategoryModel().deleteCategory(socket, args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/forum/{id}")
    public ForumModel deleteForum(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumModel().delete(socket, args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/forum_category/{id}")
    public ForumSubjectModel deleteSubject(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumSubjectModel().delete(socket, args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/forum_category/{id}")
    public ForumPostModel deletePost(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumPostModel().delete(socket, args.getInt("id"));
    }

}

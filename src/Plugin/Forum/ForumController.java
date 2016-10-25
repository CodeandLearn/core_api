package Plugin.Forum;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Plugin.Forum.Model.ForumCategoryModel;
import Plugin.Forum.Model.ForumSubCategoryModel;
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
        return new ForumCategoryModel().getForumCategories();
    }

    @Methode("GET")
    @Route("/forum_subcategories/{category_id}")
    public ForumSubCategoryModel getForumsInCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumSubCategoryModel().getForums(args.getInt("category_id"));
    }
    @Methode("GET")
    @Route("/forum_subjects/{forum_id}")
    public ForumSubjectModel getSubjectsInForum(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumSubjectModel().getSubjects(args.getInt("forum_id"));
    }

    @Methode("GET")
    @Route("/forum_posts/{subject_id}")
    public ForumPostModel getPostInSubject(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumPostModel().getPosts(args.getInt("subject_id"));
    }

    @Methode("POST")
    @Route("/forum_category")
    public ForumCategoryModel addForumCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumCategoryModel().addCategory(jsonObject);
    }

    @Methode("POST")
    @Route("/forum_subcategory")
    public ForumSubCategoryModel addForum(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumSubCategoryModel().insert(jsonObject);
    }

    @Methode("POST")
    @Route("/forum_subject")
    public ForumSubjectModel addSubject(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumSubjectModel().insert(jsonObject);
    }

    @Methode("POST")
    @Route("/forum_post")
    public ForumPostModel addPost(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumPostModel().insert(jsonObject);
    }

    @Methode("PUT")
    @Route("/forum_category/{id}")
    public ForumCategoryModel updateCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumCategoryModel().modifyCategory(args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/forum_subcategory/{id}")
    public ForumSubCategoryModel updateForum(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumSubCategoryModel().update(args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/forum_subject/{id}")
    public ForumSubjectModel updateSubject(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumSubjectModel().update(args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/forum_post/{id}")
    public ForumPostModel updatePost(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumPostModel().update(args.getInt("id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/forum_category/{id}")
    public ForumCategoryModel deleteCategory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumCategoryModel().deleteCategory(args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/forum_subcategory/{id}")
    public ForumSubCategoryModel deleteForum(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumSubCategoryModel().delete(args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/forum_subject/{id}")
    public ForumSubjectModel deleteSubject(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumSubjectModel().delete(args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/forum_post/{id}")
    public ForumPostModel deletePost(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ForumPostModel().delete(args.getInt("id"));
    }

}

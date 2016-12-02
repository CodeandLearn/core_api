package Plugin.Forum;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
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
    public SubjectModel getForumById(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new SubjectModel().getSubjectByForumId(args.getInt("id_forum"));
    }

    @Methode("GET")
    @Route("/forum/subject/{id_subject}")
    public PostModel getSubjectById(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PostModel().getPostBySubjectId(args.getInt("id_subject"));
    }
}

/*
    User
        GET
            categories + forum /forums                  (nb post + nb vue)
            forums /forums/{category_id}                (nb reply)
            posts /posts/{forum_id}

        POST
            /posts/new                                  (subject + post)
            /posts/new/{forum_id}                       (only post)

        PUT
            /posts/edit/subject/{subject_id}            (if owner or modo or admin)
            /posts/edit/{id_post}                       (if owner or modo or admin)

        DELETE
            /post/del/subject/{subject_id}              (if owner or modo or admin)
            /post/del/{post_id}                         (if owner or modo or admin)

    Admin
        GET
            same as user's routes

        POST
            /category/new
            /icon/new

        PUT
            /category/edit/{category_id}
            /icon/edit/{icon_id}
            /subject/pin/{subject_id}/{true|false}      (special route for pin a subject no JSON needed!)

 */
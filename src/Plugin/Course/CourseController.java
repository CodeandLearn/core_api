package Plugin.Course;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Course.Model.*;
import org.json.JSONObject;

/**
 * Created by teddy on 12/06/2016.
 */
@Controller
public class CourseController {
    @Methode("GET")
    @Route("/course")
    public GetCourse getCourse(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetCourse().getCourse(socket);
    }

    @Methode("GET")
    @Route("/course/id/{id}")
    public GetCourse getCourseWithId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetCourse().getCourseWithId(socket, args.getInt("id"));
    }

    @Methode("GET")
    @Route("/course/limit/{limit}")
    public GetCourse getCourseWithLimit(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetCourse().getCourseWithLimit(socket, args.getInt("limit"));
    }

    @Methode("GET")
    @Route("/course/author/id/{author_id}")
    public GetCourse getCourseByAuthorId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetCourse().getCourseByAuthorId(socket, args.getInt("author_id"));
    }

    @Methode("GET")
    @Route("/course/language/id/{language_id}")
    public GetCourse getCourseByLanguageId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetCourse().getCourseByLanguageId(socket, args.getInt("language_id"));
    }

    @Methode("GET")
    @Route("/course/locales/id/{locales_id}")
    public GetCourse getCourseByLocalesId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetCourse().getCourseByLocalesId(socket, args.getInt("locales_id"));
    }

    @Methode("GET")
    @Route("/course/title/{title}")
    public GetCourse getCourseByTitle(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetCourse().getCourseByTitle(socket, args.getString("title"));
    }

    @Methode("GET")
    @Route("/course/comment/{id_course}")
    public GetCourseComments getCommentByCourseId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetCourseComments().getCourseComments(socket, args.getInt("id_course"));
    }

    @Methode("POST")
    @Route("/course")
    public PostCourse postCourse(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PostCourse().postCourse(socket, UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("POST")
    @Route("/course/comment")
    public PostCourse postCourseComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PostCourse().postCourseComment(socket, UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("PUT")
    @Route("/course/{id}")
    public PutCourse putCourse(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PutCourse().putCourse(socket, args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/course/comment/{id}")
    public PutCourse putCourseComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PutCourse().putCourseComment(socket, args.getInt("id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/course/{id}")
    public DeleteCourse deleteCourse(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new DeleteCourse().deleteCourse(socket, args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/course/comment/{id}")
    public DeleteCourse deleteCourseComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new DeleteCourse().deleteCourseComment(socket, args.getInt("id"));
    }
}

package Plugin.Exercise;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Exercise.Model.CodeDAO;
import Plugin.Exercise.Model.GradeDAO;
import Plugin.Exercise.Model.LogDAO;
import Plugin.Exercise.Model.UserExerciceDAO;
import org.json.JSONObject;

/**
 * Created by teddy on 12/06/2016.
 */
@Controller
public class UserExerciseController {
    @Methode("GET")
    @Route("/user_exercises")
    public UserExerciceDAO getUserExercises(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserExerciceDAO().getUserExercices(socket, UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("GET")
    @Route("/user_exercise/{id}")
    public UserExerciceDAO getUserExerciseEntry(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserExerciceDAO().getUserExercice(socket, UserSecuritySingleton.getInstance().getUserId(socket), args.getInt("id"));
    }

    @Methode("GET")
    @Route("/user_exercise/{user_exercise_id}/grade")
    public GradeDAO getUserExerciceGrade(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GradeDAO().getGrade(socket, args.getInt("user_exercise_id"));
    }

    @Methode("GET")
    @Route("/user_exercise/{user_exercise_id}/log")
    public LogDAO getUserExerciceLog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new LogDAO().getLog(socket, args.getInt("user_exercise_id"));
    }

    @Methode("GET")
    @Route("/user_exercise/{user_exercise_id}/codes")
    public CodeDAO getUserExerciceCodes(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeDAO().getCodes(socket, args.getInt("user_exercise_id"));
    }

    @Methode("POST")
    @Route("/user_exercise")
    public UserExerciceDAO postUserExercice(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserExerciceDAO().post(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/user_exercise/grade")
    public GradeDAO postUserExerciceGrade(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GradeDAO().post(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/user_exercise/code")
    public CodeDAO postUserExerciceCode(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeDAO().post(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/user_exercise/log")
    public LogDAO postUserExerciceLog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new LogDAO().post(socket, jsonObject);
    }

    @Methode("PUT")
    @Route("/user_exercise/{id}")
    public UserExerciceDAO putUserExercice(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserExerciceDAO().update(socket, args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/user_exercise/grade/{id}")
    public GradeDAO putUserExerciceGrade(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GradeDAO().update(socket, args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/user_exercise/code/{id}")
    public CodeDAO putUserExerciceCode(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeDAO().update(socket, args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/user_exercise/log/{id}")
    public LogDAO putUserExerciceLog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new LogDAO().update(socket, args.getInt("id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/user_exercise/{id}")
    public UserExerciceDAO deleteUserExercice(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserExerciceDAO().delete(socket, args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/user_exercise/grade/{id}")
    public GradeDAO deleteUserExerciceGrade(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GradeDAO().delete(socket, args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/user_exercise/code/{id}")
    public CodeDAO deleteUserExerciceCode(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeDAO().delete(socket, args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/user_exercise/log/{id}")
    public LogDAO deleteUserExerciceLog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new LogDAO().delete(socket, args.getInt("id"));
    }
}

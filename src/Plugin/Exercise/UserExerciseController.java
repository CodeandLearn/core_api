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
import Plugin.Exercise.Model.UserExerciseDAO;
import org.json.JSONObject;

/**
 * Created by teddy on 12/06/2016.
 */
@Controller
public class UserExerciseController {
    @Methode("GET")
    @Route("/user_exercises")
    public UserExerciseDAO getUserExercises(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserExerciseDAO().getUserExercises(UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("GET")
    @Route("/user_exercise/{id}")
    public UserExerciseDAO getUserExerciseEntry(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserExerciseDAO().getUserExercise(UserSecuritySingleton.getInstance().getUserId(socket), args.getInt("id"));
    }

    @Methode("GET")
    @Route("/user_exercise/{user_exercise_id}/grade")
    public GradeDAO getUserExerciseGrade(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GradeDAO().getGrade(args.getInt("user_exercise_id"));
    }

    @Methode("GET")
    @Route("/user_exercise/{user_exercise_id}/log")
    public LogDAO getUserExerciseLog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new LogDAO().getLog(args.getInt("user_exercise_id"));
    }

    @Methode("GET")
    @Route("/user_exercise/{user_exercise_id}/codes")
    public CodeDAO getUserExerciseCodes(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeDAO().getCodes(args.getInt("user_exercise_id"));
    }

    @Methode("POST")
    @Route("/user_exercise")
    public UserExerciseDAO postUserExercise(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserExerciseDAO().post(UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("POST")
    @Route("/user_exercise/grade")
    public GradeDAO postUserExerciseGrade(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GradeDAO().post(jsonObject);
    }

    @Methode("POST")
    @Route("/user_exercise/code")
    public CodeDAO postUserExerciseCode(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeDAO().post(jsonObject);
    }

    @Methode("POST")
    @Route("/user_exercise/log")
    public LogDAO postUserExerciseLog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new LogDAO().post(jsonObject);
    }

    @Methode("PUT")
    @Route("/user_exercise/{id}")
    public UserExerciseDAO putUserExercise(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserExerciseDAO().update(args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/user_exercise/grade/{id}")
    public GradeDAO putUserExerciseGrade(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GradeDAO().update(args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/user_exercise/code/{id_exercise}")
    public CodeDAO putUserExerciseCode(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeDAO().update(args.getInt("id_exercise"), jsonObject);
    }

    @Methode("PUT")
    @Route("/user_exercise/log/{id}")
    public LogDAO putUserExerciseLog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new LogDAO().update(args.getInt("id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/user_exercise/{id}")
    public UserExerciseDAO deleteUserExercise(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserExerciseDAO().delete(args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/user_exercise/grade/{id}")
    public GradeDAO deleteUserExerciseGrade(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GradeDAO().delete(args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/user_exercise/code/{id}")
    public CodeDAO deleteUserExerciseCode(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeDAO().delete(args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/user_exercise/log/{id}")
    public LogDAO deleteUserExerciseLog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new LogDAO().delete(args.getInt("id"));
    }
}

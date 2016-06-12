package Plugin;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Course.Model.*;
import Plugin.Exercice.*;
import Plugin.Language.Model.DeleteLanguage;
import Plugin.Language.Model.GetLanguage;
import Plugin.Language.Model.PostLanguage;
import Plugin.Language.Model.PutLanguage;
import org.json.JSONObject;

/**
 * Created by teddy on 04/05/2016.
 */
@Controller
public class Path {
    /* Exercises */
    @Methode("GET")
    @Route("/exercises")
    public ExerciseDAO getExercises(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().getExercises(socket);
    }

    @Methode("GET")
    @Route("/exercise/{id}")
    public ExerciseDAO getExerciseById(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().getExerciseById(socket, Integer.parseInt(args.get("id").toString()));
    }

    @Methode("GET")
    @Route("/exercise/course/{course_id}")
    public ExerciseDAO getExercisesByCourseId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().getCourseExercise(socket, Integer.parseInt(args.get("course_id").toString()));
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/script")
    public ScriptDAO getExerciseScript(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ScriptDAO().getExerciceScript(socket, Integer.parseInt(args.get("exercise_id").toString()));
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/correction")
    public ExerciceCorrectionDAO getExerciseCorrection(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCorrectionDAO().getExerciceCorrection(socket, Integer.parseInt(args.get("exercise_id").toString()));
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/comments")
    public ExerciceCommentDAO getExerciseComments(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCommentDAO().getExerciceComments(socket, Integer.parseInt(args.get("exercise_id").toString()));
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/moderation")
    public ExerciceModerationDAO getExerciseModeration(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceModerationDAO().getExerciceModeration(socket, Integer.parseInt(args.get("exercise_id").toString()));
    }

    @Methode("POST")
    @Route("/exercise")
    public ExerciseDAO postExercise(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().post(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/exercise/script")
    public ScriptDAO postExerciseScript(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ScriptDAO().post(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/exercise/correction")
    public ExerciceCorrectionDAO postExerciseCorrection(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCorrectionDAO().post(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/exercise/comment")
    public ExerciceCommentDAO postExerciseComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCommentDAO().post(socket, jsonObject);
    }

    @Methode("POST")
    @Route("/exercise/moderation")
    public ExerciceModerationDAO postExerciseModeration(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceModerationDAO().post(socket, jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/{id}")
    public ExerciseDAO putExercise(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().update(socket, Integer.parseInt(args.get("id").toString()), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/script/{script_id}")
    public ScriptDAO putExerciseScript(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ScriptDAO().update(socket, Integer.parseInt(args.get("script_id").toString()), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/correction/{correction_id}")
    public ExerciceCorrectionDAO putExerciseCorrection(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCorrectionDAO().update(socket, Integer.parseInt(args.get("correction_id").toString()), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/comment/{comment_id}")
    public ExerciceCommentDAO putExerciseComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCommentDAO().update(socket, Integer.parseInt(args.get("comment_id").toString()), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/moderation/{moderation_id}")
    public ExerciceModerationDAO putExerciseModeration(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceModerationDAO().update(socket, Integer.parseInt(args.get("moderation_id").toString()), jsonObject);
    }

    @Methode("DELETE")
    @Route("/exercise/{id}")
    public ExerciseDAO deleteExercise(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().delete(socket, Integer.parseInt(args.get("id").toString()));
    }

    @Methode("DELETE")
    @Route("/exercise/script/{script_id}")
    public ScriptDAO deleteExerciseScript(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ScriptDAO().delete(socket, Integer.parseInt(args.get("script_id").toString()));
    }

    @Methode("DELETE")
    @Route("/exercise/correction/{correction_id}")
    public ExerciceCorrectionDAO deleteExerciseCorrection(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCorrectionDAO().delete(socket, Integer.parseInt(args.get("correction_id").toString()));
    }

    @Methode("DELETE")
    @Route("/exercise/comments/{comment_id}")
    public ExerciceCommentDAO deleteExerciseComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCommentDAO().delete(socket, Integer.parseInt(args.get("comment_id").toString()));
    }

    @Methode("DELETE")
    @Route("/exercise/moderation/{moderation_id}")
    public ExerciceModerationDAO deleteExerciseModeration(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceModerationDAO().delete(socket, Integer.parseInt(args.get("moderation_id").toString()));
    }

    @Methode("GET")
    @Route("/user_exercises")
    public UserExerciceDAO getUserExercises(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserExerciceDAO().getUserExercices(socket, UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("GET")
    @Route("/user_exercise/{id}")
    public UserExerciceDAO getUserExerciseEntry(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserExerciceDAO().getUserExercice(socket, UserSecuritySingleton.getInstance().getUserId(socket), Integer.parseInt(args.get("id").toString()));
    }

    @Methode("GET")
    @Route("/user_exercise/{user_exercise_id}/grade")
    public GradeDAO getUserExerciceGrade(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GradeDAO().getGrade(socket, Integer.parseInt(args.get("user_exercise_id").toString()));
    }

    @Methode("GET")
    @Route("/user_exercise/{user_exercise_id}/log")
    public LogDAO getUserExerciceLog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new LogDAO().getLog(socket, Integer.parseInt(args.get("user_exercise_id").toString()));
    }

    @Methode("GET")
    @Route("/user_exercise/{user_exercise_id}/codes")
    public CodeDAO getUserExerciceCodes(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeDAO().getCodes(socket, Integer.parseInt(args.get("user_exercise_id").toString()));
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
        return new UserExerciceDAO().update(socket, Integer.parseInt(args.get("id").toString()), jsonObject);
    }

    @Methode("PUT")
    @Route("/user_exercise/grade/{id}")
    public GradeDAO putUserExerciceGrade(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GradeDAO().update(socket, Integer.parseInt(args.get("id").toString()), jsonObject);
    }

    @Methode("PUT")
    @Route("/user_exercise/code/{id}")
    public CodeDAO putUserExerciceCode(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeDAO().update(socket, Integer.parseInt(args.get("id").toString()), jsonObject);
    }

    @Methode("PUT")
    @Route("/user_exercise/log/{id}")
    public LogDAO putUserExerciceLog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new LogDAO().update(socket, Integer.parseInt(args.get("id").toString()), jsonObject);
    }

    @Methode("DELETE")
    @Route("/user_exercise/{id}")
    public UserExerciceDAO deleteUserExercice(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserExerciceDAO().delete(socket, Integer.parseInt(args.get("id").toString()));
    }

    @Methode("DELETE")
    @Route("/user_exercise/grade/{id}")
    public GradeDAO deleteUserExerciceGrade(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GradeDAO().delete(socket, Integer.parseInt(args.get("id").toString()));
    }

    @Methode("DELETE")
    @Route("/user_exercise/code/{id}")
    public CodeDAO deleteUserExerciceCode(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeDAO().delete(socket, Integer.parseInt(args.get("id").toString()));
    }

    @Methode("DELETE")
    @Route("/user_exercise/log/{id}")
    public LogDAO deleteUserExerciceLog(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new LogDAO().delete(socket, Integer.parseInt(args.get("id").toString()));
    }
}
package Plugin.Exercise;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Exercise.Model.*;
import org.json.JSONObject;

/**
 * Created by teddy on 12/06/2016.
 */
@Controller
public class ExerciseController {
    @Methode("GET")
    @Route("/exercises")
    public ExerciseDAO getExercises(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().getExercises(socket);
    }

    @Methode("GET")
    @Route("/exercise/{id}")
    public ExerciseDAO getExerciseById(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().getExerciseById(socket, args.getInt("id"));
    }

    @Methode("GET")
    @Route("/exercise/course/{course_id}")
    public ExerciseDAO getExercisesByCourseId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().getCourseExercise(socket, args.getInt("course_id"));
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/script")
    public ScriptDAO getExerciseScript(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ScriptDAO().getExerciceScript(socket, args.getInt("exercise_id"));
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/correction")
    public ExerciceCorrectionDAO getExerciseCorrection(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCorrectionDAO().getExerciceCorrection(socket, args.getInt("exercise_id"));
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/comments")
    public ExerciceCommentDAO getExerciseComments(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCommentDAO().getExerciceComments(socket, args.getInt("exercise_id"));
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/moderation")
    public ExerciceModerationDAO getExerciseModeration(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceModerationDAO().getExerciceModeration(socket, args.getInt("exercise_id"));
    }

    @Methode("POST")
    @Route("/exercise")
    public ExerciseDAO postExercise(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().post(socket, UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
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
        return new ExerciceCommentDAO().post(socket, UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("POST")
    @Route("/exercise/moderation")
    public ExerciceModerationDAO postExerciseModeration(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceModerationDAO().post(socket, jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/{id}")
    public ExerciseDAO putExercise(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().update(socket, args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/script/{script_id}")
    public ScriptDAO putExerciseScript(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ScriptDAO().update(socket, args.getInt("script_id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/correction/{correction_id}")
    public ExerciceCorrectionDAO putExerciseCorrection(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCorrectionDAO().update(socket, args.getInt("correction_id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/comment/{comment_id}")
    public ExerciceCommentDAO putExerciseComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCommentDAO().update(socket, args.getInt("comment_id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/moderation/{moderation_id}")
    public ExerciceModerationDAO putExerciseModeration(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceModerationDAO().update(socket, args.getInt("moderation_id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/exercise/{id}")
    public ExerciseDAO deleteExercise(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().delete(socket, args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/exercise/script/{script_id}")
    public ScriptDAO deleteExerciseScript(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ScriptDAO().delete(socket, args.getInt("script_id"));
    }

    @Methode("DELETE")
    @Route("/exercise/correction/{correction_id}")
    public ExerciceCorrectionDAO deleteExerciseCorrection(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCorrectionDAO().delete(socket, args.getInt("correction_id"));
    }

    @Methode("DELETE")
    @Route("/exercise/comments/{comment_id}")
    public ExerciceCommentDAO deleteExerciseComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceCommentDAO().delete(socket, args.getInt("comment_id"));
    }

    @Methode("DELETE")
    @Route("/exercise/moderation/{moderation_id}")
    public ExerciceModerationDAO deleteExerciseModeration(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciceModerationDAO().delete(socket, args.getInt("moderation_id"));
    }
}

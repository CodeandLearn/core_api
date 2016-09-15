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
        return new ExerciseDAO().getExerciseById(args.getInt("id"));
    }

    @Methode("GET")
    @Route("/exercises/course/{course_id}")
    public ExerciseDAO getExercisesByCourseId(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().getCourseExercise(args.getInt("course_id"));
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/code_templates")
    public CodeTemplateDAO getTemplatesByExercise(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeTemplateDAO().getTemplates(args.getInt("exercise_id"));
    }

    /*
    @Methode("GET")
    @Route("/exercise/{exercise_id}/script")
    public ScriptDAO getExerciseScript(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ScriptDAO().getExerciseScript(args.getInt("exercise_id"));
    }
    */

    @Methode("GET")
    @Route("/exercise/{exercise_id}/correction")
    public ExerciseCorrectionDAO getExerciseCorrection(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseCorrectionDAO().getExerciseCorrection(args.getInt("exercise_id"));
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/comments")
    public ExerciseCommentDAO getExerciseComments(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseCommentDAO().getExerciseComments(args.getInt("exercise_id"));
    }

    @Methode("GET")
    @Route("/exercise/{exercise_id}/moderation")
    public ExerciseModerationDAO getExerciseModeration(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseModerationDAO().getExerciseModeration(args.getInt("exercise_id"));
    }

    @Methode("POST")
    @Route("/exercise")
    public ExerciseDAO postExercise(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().post(UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("POST")
    @Route("/exercise/code_template")
    public CodeTemplateDAO postTemplate(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args){
        return new CodeTemplateDAO().post(jsonObject);
    }

    @Methode("POST")
    @Route("/exercise/script")
    public ScriptDAO postExerciseScript(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ScriptDAO().post(jsonObject);
    }

    @Methode("POST")
    @Route("/exercise/correction")
    public ExerciseCorrectionDAO postExerciseCorrection(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseCorrectionDAO().post(jsonObject);
    }

    @Methode("POST")
    @Route("/exercise/comment")
    public ExerciseCommentDAO postExerciseComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseCommentDAO().post(UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    /*
    @Methode("POST")
    @Route("/exercise/moderation")
    public ExerciseModerationDAO postExerciseModeration(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseModerationDAO().post(jsonObject);
    }
    */

    @Methode("PUT")
    @Route("/exercise/{id}")
    public ExerciseDAO putExercise(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().update(args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/code_template/{id}")
    public CodeTemplateDAO putTemplate(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeTemplateDAO().update(args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/script/{script_id}")
    public ScriptDAO putExerciseScript(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ScriptDAO().update(args.getInt("script_id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/correction/{correction_id}")
    public ExerciseCorrectionDAO putExerciseCorrection(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseCorrectionDAO().update(args.getInt("correction_id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/comment/{comment_id}")
    public ExerciseCommentDAO putExerciseComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseCommentDAO().update(args.getInt("comment_id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/exercise/moderation/{moderation_id}")
    public ExerciseModerationDAO putExerciseModeration(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseModerationDAO().update(args.getInt("moderation_id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/exercise/{id}")
    public ExerciseDAO deleteExercise(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseDAO().delete(args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/exercise/code_template/{id}")
    public CodeTemplateDAO deleteTemplate(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeTemplateDAO().delete(args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/exercise/{exercise_id}/code_templates")
    public CodeTemplateDAO deleteTemplates(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new CodeTemplateDAO().deleteAll(args.getInt("exercise_id"));
    }


    @Methode("DELETE")
    @Route("/exercise/script/{script_id}")
    public ScriptDAO deleteExerciseScript(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ScriptDAO().delete(args.getInt("script_id"));
    }

    @Methode("DELETE")
    @Route("/exercise/correction/{correction_id}")
    public ExerciseCorrectionDAO deleteExerciseCorrection(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseCorrectionDAO().delete(args.getInt("correction_id"));
    }

    @Methode("DELETE")
    @Route("/exercise/comments/{comment_id}")
    public ExerciseCommentDAO deleteExerciseComment(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseCommentDAO().delete(args.getInt("comment_id"));
    }

    @Methode("DELETE")
    @Route("/exercise/moderation/{moderation_id}")
    public ExerciseModerationDAO deleteExerciseModeration(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ExerciseModerationDAO().delete(args.getInt("moderation_id"));
    }

}

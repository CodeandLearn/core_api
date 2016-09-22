package Plugin.Exercise.Obj;

import Plugin.Course.Obj.CoursePostObj;

/**
 * Created by HallElouia on 04/25/2016.
 */
public class UserExerciseObj {
    public int id;
    public int account_id;
    public int exercise_id;
    public ExerciseObj exercise = new ExerciseObj();
    public CoursePostObj course = new CoursePostObj();
}

package Plugin.FeedBack.Obj;

/**
 * Created by Sheol on 01/12/2016.
 */
public class FeedbackCategoryObj {
    public int id;
    public String name;
    public String description;
    public int position;
    public int feedback_icon_id;
    public FeedbackIconObj feedback_icon = new FeedbackIconObj();
}

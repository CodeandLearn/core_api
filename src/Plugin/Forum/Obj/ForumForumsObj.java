package Plugin.Forum.Obj;

/**
 * Created by moran on 9/1/2016.
 */
public class ForumForumsObj {
    public int id;
    public int forum_category_id;
    public String title;
    public String description;
    public int position;
    public int icon_id;

    public ForumCategoryObj category = new ForumCategoryObj();
    public ForumIconObj icon = new ForumIconObj();
}

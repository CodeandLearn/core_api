package Plugin.Forum.Obj;

import Plugin.Forum.Model.ForumSubCategoryModel;

/**
 * Created by moran on 9/1/2016.
 */
public class ForumSubjectObj {
    public int id;
    public String title;
    public int account_id;
    public long created_at;
    public long last_updated;
    public int last_account_id;
    public int forum_subcategory_id;
    public int likes;
    public ForumSubCategoryObj fscObj = new ForumSubCategoryObj();
}

package Plugin.Forum.Obj;

/**
 * Created by moran on 9/1/2016.
 */
public class ForumPostObj {
    public int id;
    public int account_id;
    public int forum_subject_id;
    public String content;
    public long created_at;
    public long last_updated;
    public int likes;
    public ForumSubjectObj fsObj = new ForumSubjectObj();
}

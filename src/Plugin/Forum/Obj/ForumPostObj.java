package Plugin.Forum.Obj;

import Plugin.Account.Obj.AccountObj;

/**
 * Created by moran on 9/1/2016.
 */
public class ForumPostObj {
    public int id;
    public int account_id;
    public int forum_subject_id;
    public String content;
    public long create_timestamp;
    public long modify_timestamp;
    public int likes;

    public ForumSubjectObj subject = new ForumSubjectObj();
    public AccountObj account = new AccountObj();
}

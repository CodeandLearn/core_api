package Plugin.Forum.Obj;

import Plugin.Account.Obj.AccountObj;

/**
 * Created by moran on 9/1/2016.
 */
public class ForumSubjectObj {
    public int id;
    public String title;
    public boolean pin;
    public int account_id;
    public int forum_forum_id;

    public ForumForumsObj forum = new ForumForumsObj();
    public AccountObj account = new AccountObj();
}

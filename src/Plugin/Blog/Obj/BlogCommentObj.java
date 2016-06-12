package Plugin.Blog.Obj;

import Plugin.Account.Obj.AccountObj;

/**
 * Created by teddy on 06/04/2016.
 */
public class BlogCommentObj {
    public int id;
    public int account_id;
    public int blog_post_id;
    public String content;
    public long create_timestamp;
    public long modify_timestamp;
    public AccountObj user = new AccountObj();
}

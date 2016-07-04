package Plugin.Course.Obj;

import Plugin.Account.Obj.AccountObj;

public class CourseCommentObj {
    public int id;
    public int course_id;
    public int account_id;
    public String content;
    public long create_timestamp;
    public long modify_timestamp;
    public AccountObj user = new AccountObj();
}

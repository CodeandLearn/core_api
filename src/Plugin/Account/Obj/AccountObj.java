package Plugin.Account.Obj;

import Plugin.Group.Obj.GroupObj;

/**
 * Created by teddy on 03/04/2016.
 */
public class AccountObj {
    public int id;
    public String username;
    public String password;
    public String email;
    public String email_md5;
    public int group_id;
    public int avatar_id;
    public long create_timestamp;
    public long last_connect_timestamp;
    public int nb_courses_done;
    public int nb_exercises_done;
    public GroupObj group = new GroupObj();
    public AvatarObj avatar = new AvatarObj();
}

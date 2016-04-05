package Core.Plugin.Blog.Obj;

/**
 * Created by teddy on 03/04/2016.
 */
public class UserObj {
    public int id;
    public String username;
    public GroupObj group = new GroupObj();
    public AvatarObj avatar = new AvatarObj();
}

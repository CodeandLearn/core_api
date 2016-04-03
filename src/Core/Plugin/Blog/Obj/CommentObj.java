package Core.Plugin.Blog.Obj;

public class CommentObj {
    public int id;
    public String content;
    public long create_timestamp;
    public long modify_timestamp;
    public UserObj user = new UserObj();
}

package Core.Plugin.Blog;

import Core.Plugin.Blog.Obj.*;

import java.util.ArrayList;

/**
 * Created by teddy on 23/03/2016.
 */
public class BlogObj {
    public PostObj article = new PostObj();
    public CategoryObj category = new CategoryObj();
    public LocalObj local = new LocalObj();
    public UserObj user = new UserObj();
    public ArrayList<CommentObj> comments = new ArrayList<>();
}

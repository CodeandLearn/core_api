package Plugin.Blog;

import Obj.BlogCommentObj;
import Obj.BlogPostObj;

import java.util.ArrayList;

/**
 * Created by teddy on 23/03/2016.
 */
public class BlogObj {
    public BlogPostObj article = new BlogPostObj();
    public ArrayList<BlogCommentObj> comments = new ArrayList<>();
}

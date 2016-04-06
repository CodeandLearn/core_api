package Core.Plugins.Blog;

import Core.Objs.*;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

/**
 * Created by teddy on 23/03/2016.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BlogObj {
    public BlogPostObj article = new BlogPostObj();
    public ArrayList<BlogCommentObj> comments = new ArrayList<>();
}

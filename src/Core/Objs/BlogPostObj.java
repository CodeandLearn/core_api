package Core.Objs;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by teddy on 06/04/2016.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BlogPostObj {
    public int id;
    public int account_id;
    public int locales_id;
    public int blog_category_id;
    public String title;
    public String content;
    public long create_timestamp;
    public long modify_timestamp;
    public AccountObj account = new AccountObj();
    public LocalObj locale = new LocalObj();
    public BlogCategoryObj category = new BlogCategoryObj();
}

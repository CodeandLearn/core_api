package Core.Objs;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by teddy on 06/04/2016.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BlogCommentObj {
    public int id;
    public int account_id;
    public int blog_post_id;
    public String content;
    public long create_timestamp;
    public long modify_timestamp;
    public AccountObj user = new AccountObj();
}

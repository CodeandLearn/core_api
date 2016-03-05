package Core.Plugin.Blog.Obj;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class BlogCommentObj {
    public int id;
    @NotNull
    public int account_id;
    @NotNull
    public int blog_post_id;
    @NotEmpty
    public String content;
    public Timestamp create_timestamp;
    public Timestamp modify_timestamp;
}

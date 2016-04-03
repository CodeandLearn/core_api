package Core.Plugin.Blog.Obj;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.internal.util.logging.Log;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class BlogPostObj {
    public int id;
    @NotNull
    public int account_id;
    @NotNull
    public int locales_id;
    @NotNull
    public int blog_category_id;
    @NotEmpty
    public String title;
    @NotEmpty
    public String content;
    public long create_timestamp;
    public long modify_timestamp;
}

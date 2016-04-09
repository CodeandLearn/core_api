package Core.Objs;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

/**
 * Created by teddy on 06/04/2016.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BlogCommentObj {
    @NumberFormat
    public int id;
    @NotNull
    @NumberFormat
    public int account_id;
    @NotNull
    @NumberFormat
    public int blog_post_id;
    @NotEmpty
    public String content;
    public long create_timestamp;
    public long modify_timestamp;
    public AccountObj user = new AccountObj();
}

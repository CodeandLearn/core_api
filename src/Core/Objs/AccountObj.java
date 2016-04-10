package Core.Objs;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;

/**
 * Created by teddy on 03/04/2016.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AccountObj {
    @NumberFormat
    public int id;
    @NotEmpty
    public String username;
    @NotEmpty
    public String password;
    @NotEmpty
    @Email
    public String email;
    @NotNull
    @NumberFormat
    public int group_id;
    @NotNull
    @NumberFormat
    public int avatar_id;
    public long create_timestamp;
    public long last_connect_timestamp;
    @NumberFormat
    public int nb_courses_done;
    @NumberFormat
    public int nb_exercices_done;
    public GroupObj group = new GroupObj();
    public AvatarObj avatar = new AvatarObj();
}

package Core.Objs;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by teddy on 03/04/2016.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AccountObj {
    public int id;
    public String username;
    public String password;
    public String email;
    public int group_id;
    public int avatar_id;
    public long create_timestamp;
    public long last_connect_timestamp;
    public int nb_courses_done;
    public int nb_exercices_done;
    public GroupObj group = new GroupObj();
    public AvatarObj avatar = new AvatarObj();
}

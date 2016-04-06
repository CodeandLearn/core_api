package Core.Objs;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by teddy on 05/04/2016.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AvatarObj {
    public int id;
    public String path;
}

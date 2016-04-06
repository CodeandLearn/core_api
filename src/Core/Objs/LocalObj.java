package Core.Objs;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by teddy on 03/04/2016.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LocalObj {
    public int id;
    public String name;
}

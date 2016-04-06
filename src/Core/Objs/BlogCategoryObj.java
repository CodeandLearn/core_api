package Core.Objs;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by teddy on 06/04/2016.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BlogCategoryObj {
    public int id;
    public String name;
}

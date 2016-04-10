package Core.Objs;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

/**
 * Created by teddy on 05/04/2016.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AvatarObj {
    @NumberFormat
    public int id;
    @NotEmpty
    public String path;
}

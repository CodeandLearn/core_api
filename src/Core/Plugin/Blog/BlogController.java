package Core.Plugin.Blog;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@RestController
public class BlogController {
    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public Get Get(HttpServletRequest request, HttpServletResponse reply) throws SQLException {
        return new Get(request, reply);
    }
}

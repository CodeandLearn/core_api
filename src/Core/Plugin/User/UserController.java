package Core.Plugin.User;

import Core.Plugin.User.GET.UserGet;
import Core.Plugin.User.GET.UserGetId;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserGet user(HttpServletRequest request, HttpServletResponse reply) {
        return new UserGet(request, reply);
    }
}
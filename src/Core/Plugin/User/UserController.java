package Core.Plugin.User;

import Core.Plugin.Default.Default;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public Default user(@RequestParam(value = "username") String username, HttpServletRequest request) {
        return new Default(request);
    }

    @RequestMapping(value = "/user/id/", method = RequestMethod.GET)
    public Default userId(@RequestParam(value = "id") int id, HttpServletRequest request) {
        return new Default(request);
    }
}
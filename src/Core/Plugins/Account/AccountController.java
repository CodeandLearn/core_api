package Core.Plugins.Account;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public GetAccount getAccount(HttpServletRequest request, HttpServletResponse reply) {
        return new GetAccount(request, reply);
    }

    @RequestMapping(value = "/accounts/limit/{limit}", method = RequestMethod.GET)
    public GetAccount getAccountWithLimit(HttpServletRequest request, HttpServletResponse reply, @PathVariable int limit) {
        return new GetAccount(request, reply, "", limit);
    }

    @RequestMapping(value = "/myaccount", method = RequestMethod.GET)
    public GetAccount getMyAccount(HttpServletRequest request, HttpServletResponse reply) {
        return new GetAccount(request, reply, "accounts.id=1");
    }
}
package Core.Plugins.Account;

import Core.Objs.AccountObj;
import Core.Objs.BlogCategoryObj;
import Core.Plugins.Default.Default;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class AccountController {
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public GetAccount getAccounts(HttpServletRequest request, HttpServletResponse reply) {
        return new GetAccount(request, reply);
    }

    @RequestMapping(value = "/accounts/limit/{limit}", method = RequestMethod.GET)
    public GetAccount getAccountWithLimit(HttpServletRequest request, HttpServletResponse reply, @PathVariable int limit) {
        return new GetAccount(request, reply, "", limit);
    }

    // TODO: 09/04/2016 - Fix Oauth2.0 token sharing with api
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public GetAccount getAccount(HttpServletRequest request, HttpServletResponse reply) {
        return new GetAccount(request, reply, "accounts.id=1");
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public GetAccount getAccountById(HttpServletRequest request, HttpServletResponse reply, @PathVariable int id) {
        return new GetAccount(request, reply, "accounts.id=" + id);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public PostAccount register(HttpServletRequest request, HttpServletResponse reply, @Valid @RequestBody AccountObj accountObj) {
        return new PostAccount(request, reply, accountObj);
    }

    // TODO: 09/04/2016 - Fix Oauth2.0 token sharing with api
    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    public PutAccount putAccount(HttpServletRequest request, HttpServletResponse reply, @Valid @RequestBody AccountObj accountObj) {
        return new PutAccount(request, reply, 1, accountObj);
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.PUT)
    public PutAccount putAccountById(HttpServletRequest request, HttpServletResponse reply, @PathVariable int id, @Valid @RequestBody AccountObj accountObj) {
        return new PutAccount(request, reply, id, accountObj);
    }

    // TODO: 09/04/2016 - Fix Oauth2.0 token sharing with api
    @RequestMapping(value = "/account", method = RequestMethod.DELETE)
    public DeleteAccount deleteAccount(HttpServletRequest request, HttpServletResponse reply) {
        return new DeleteAccount(request, reply, 1);
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.DELETE)
    public DeleteAccount deleteAccountById(HttpServletRequest request, HttpServletResponse reply, @PathVariable int id) {
        return new DeleteAccount(request, reply, id);
    }
}
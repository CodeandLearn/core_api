package Core.Plugins.Account;

import Core.Objs.AccountObj;
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

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public GetAccount getAccount(HttpServletRequest request, HttpServletResponse reply) {
        System.out.println("get id : " + request.getAttribute("accounts.id"));
        return new GetAccount(request, reply, "accounts.id=" + request.getAttribute("accounts.id"));
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public GetAccount getAccountById(HttpServletRequest request, HttpServletResponse reply, @PathVariable int id) {
        return new GetAccount(request, reply, "accounts.id=" + id);
    }

    // TODO: 11/04/2016 - Go fix add account to inMemory data 
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public PostAccount register(HttpServletRequest request, HttpServletResponse reply, @Valid @RequestBody AccountObj accountObj) {
        return new PostAccount(request, reply, accountObj);
    }

    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    public PutAccount putAccount(HttpServletRequest request, HttpServletResponse reply, @Valid @RequestBody AccountObj accountObj) {
        return new PutAccount(request, reply, Integer.parseInt(request.getAttribute("accounts.id").toString()), accountObj);
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.PUT)
    public PutAccount putAccountById(HttpServletRequest request, HttpServletResponse reply, @PathVariable int id, @Valid @RequestBody AccountObj accountObj) {
        return new PutAccount(request, reply, id, accountObj);
    }

    @RequestMapping(value = "/account", method = RequestMethod.DELETE)
    public DeleteAccount deleteAccount(HttpServletRequest request, HttpServletResponse reply) {
        return new DeleteAccount(request, reply, Integer.parseInt(request.getAttribute("accounts.id").toString()));
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.DELETE)
    public DeleteAccount deleteAccountById(HttpServletRequest request, HttpServletResponse reply, @PathVariable int id) {
        return new DeleteAccount(request, reply, id);
    }
}
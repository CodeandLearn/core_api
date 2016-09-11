package Plugin.Account;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Account.Model.DeleteAccount;
import Plugin.Account.Model.GetAccount;
import Plugin.Account.Model.PostAccount;
import Plugin.Account.Model.PutAccount;
import org.json.JSONObject;

/**
 * Created by teddy on 10/06/2016.
 */
@Controller
public class AccountController {
    @Methode("GET")
    @Route("/accounts")
    public GetAccount getAccounts(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetAccount().getAccounts();
    }

    @Methode("GET")
    @Route("/accounts/limit/{limit}")
    public GetAccount getAccountWithLimit(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetAccount().getAccountWithLimit(args.getInt("limit"));
    }

    @Methode("GET")
    @Route("/account")
    public GetAccount getAccount(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetAccount().getAccount(UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("GET")
    @Route("/account/{id}")
    public GetAccount getAccountById(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetAccount().getAccount(args.getInt("id"));
    }

    @Methode("POST")
    @Route("/register")
    public PostAccount register(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PostAccount().register(socket, jsonObject);
    }

    @Methode("PUT")
    @Route("/account")
    public PutAccount putAccount(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PutAccount().putAccount(socket, UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("PUT")
    @Route("/account/{id}")
    public PutAccount putAccountById(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PutAccount().putAccount(socket, args.getInt("id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/account")
    public DeleteAccount deleteAccount(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new DeleteAccount().deleteAccount(socket, UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("DELETE")
    @Route("/account/{id}")
    public DeleteAccount deleteAccountById(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new DeleteAccount().deleteAccount(socket, args.getInt("id"));
    }
}

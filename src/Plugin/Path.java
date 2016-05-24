package Plugin;

import Core.Controller;
import Core.Http.Oauth2;
import Core.Http.Oauth2Model;
import Core.Methode;
import Core.Model;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Account.DeleteAccount;
import Plugin.Account.GetAccount;
import Plugin.Account.PostAccount;
import Plugin.Account.PutAccount;
import Plugin.Server.Model.Server;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by teddy on 04/05/2016.
 */
@Controller
public class Path {
    @Methode("POST")
    @Route("/oauth")
    public Oauth2Model getToken(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Oauth2Model(socket, oauth2);
    }

    @Methode("DELETE")
    @Route("/revoke")
    public Model revokeToken(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        UserSecuritySingleton.getInstance().revokUserToken(socket);
        return new Model();
    }

    @Methode("GET")
    @Route("/server")
    public Server getServer(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new Server(socket);
    }

    /* ACCOUNT */
    @Methode("GET")
    @Route("/accounts")
    public GetAccount getAccounts(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetAccount(socket);
    }

    @Methode("GET")
    @Route("/accounts/limit/{limit}")
    public GetAccount getAccountWithLimit(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetAccount(socket, "", (int) args.get("limit"));
    }

    @Methode("GET")
    @Route("/account")
    public GetAccount getAccount(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetAccount(socket, "accounts.id=" + UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("GET")
    @Route("/account/{id}")
    public GetAccount getAccountById(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new GetAccount(socket, "accounts.id=" + (int) args.get("id"));
    }

    @Methode("POST")
    @Route("/register")
    public PostAccount register(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PostAccount(socket, jsonObject);
    }

    @Methode("PUT")
    @Route("/account")
    public PutAccount putAccount(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutAccount(socket, (int) UserSecuritySingleton.getInstance().getUserId(socket), jsonObject);
    }

    @Methode("PUT")
    @Route("/account/{id}")
    public PutAccount putAccountById(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new PutAccount(socket, (int) args.get("id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/account")
    public DeleteAccount deleteAccount(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteAccount(socket, (int) UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("DELETE")
    @Route("/account/{id}")
    public DeleteAccount deleteAccountById(String socket, Oauth2 oauth2, HashMap<String, String> headerField, JSONObject jsonObject, HashMap<String, Object> args) {
        return new DeleteAccount(socket, (int) args.get("id"));
    }
}

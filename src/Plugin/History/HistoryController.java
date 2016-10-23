package Plugin.History;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.History.Model.HistoryModel;
import org.json.JSONObject;

/**
 * Created by teddy on 22/10/2016.
 */
@Controller
public class HistoryController {
    @Methode("GET")
    @Route("/account/{id_account}/history")
    public HistoryModel getAccountHistoryById(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new HistoryModel().getHistoryAccountById(args.getInt("id_account"));
    }

    @Methode("GET")
    @Route("/account/history")
    public HistoryModel getAccountHistory(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new HistoryModel().getHistoryAccountById(UserSecuritySingleton.getInstance().getUserId(socket));
    }
}

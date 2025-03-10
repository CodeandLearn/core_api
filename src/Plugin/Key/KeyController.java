package Plugin.Key;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.History.Model.HistoryModel;
import Plugin.Key.Model.KeyModel;
import org.json.JSONObject;

/**
 * Created by teddy on 22/10/2016.
 */
@Controller
public class KeyController {
    @Methode("GET")
    @Route("/keys")
    public KeyModel getKeys(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new KeyModel().getKeys();
    }

    @Methode("POST")
    @Route("/key/generate/{nb}")
    public KeyModel generateKey(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        new HistoryModel().postHistory(UserSecuritySingleton.getInstance().getUserId(socket), "panel_keys", "a généré " + args.get("nb") + " clées.", 0);
        return new KeyModel().generateKey(args.getInt("nb"));
    }

    @Methode("PUT")
    @Route("/key/distributed/{id}")
    public KeyModel setDistributed(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new KeyModel().setDistributed(args.getInt("id"));
    }

    @Methode("PUT")
    @Route("/key/distributed/{id_start}/{id_end}")
    public KeyModel setDistributedRandge(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new KeyModel().setRandgeDistributed(args.getInt("id_start"), args.getInt("id_end"));
    }

    @Methode("PUT")
    @Route("/key/reset/{id}")
    public KeyModel reset(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new KeyModel().reset(args.getInt("id"));
    }

    @Methode("PUT")
    @Route("/key/reset/{id_start}/{id_end}")
    public KeyModel resetRandge(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new KeyModel().resetRandge(args.getInt("id_start"), args.getInt("id_end"));
    }

    @Methode("DELETE")
    @Route("/key/{id}")
    public KeyModel deleteKey(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new KeyModel().deleteKey(args.getInt("id"));
    }
}

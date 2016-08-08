package Plugin.Server;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Http.Oauth2Model;
import Core.Methode;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Account.Model.GetAccount;
import Plugin.Server.Model.Oauth2ComboModel;
import org.json.JSONObject;

/**
 * Created by teddy on 10/06/2016.
 */
@Controller
public class Oauth2Controller {
    @Methode("POST")
    @Route("/oauth")
    public Oauth2ComboModel getToken(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        new Oauth2Model().initUser(socket, oauth2);
        return new Oauth2ComboModel().combo(socket, new GetAccount().getAccount(socket, UserSecuritySingleton.getInstance().getUserId(socket)));
    }

    @Methode("DELETE")
    @Route("/revoke")
    public Oauth2Model revokeToken(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Oauth2Model().revokToken(socket);
    }
}

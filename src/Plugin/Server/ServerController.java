package Plugin.Server;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Plugin.Server.Model.Ip;
import Plugin.Server.Model.Pong;
import Plugin.Server.Model.RoutesModel;
import Plugin.Server.Model.Server;
import org.json.JSONObject;

/**
 * Created by teddy on 10/06/2016.
 */
@Controller
public class ServerController {
    @Methode("GET")
    @Route("/server")
    public Server getServer(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Server(socket);
    }

    @Methode("GET")
    @Route("/routes")
    public RoutesModel getRoutes(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new RoutesModel().getRoutes();
    }

    @Methode("GET")
    @Route("/ping")
    public Pong getPong(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Pong();
    }

    @Methode("GET")
    @Route("/ip")
    public Ip getIp(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Ip().getIp();
    }

    @Methode("POST")
    @Route("/ban_ip")
    public Ip banIp(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Ip().banIp(socket, jsonObject.getString("ip"));
    }

    @Methode("POST")
    @Route("/unban_ip")
    public Ip unbanIp(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Ip().unbanIp(socket, jsonObject.getString("ip"));
    }

    @Methode("POST")
    @Route("/white_ip")
    public Ip whiteIp(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new Ip().whiteListIp(socket, jsonObject.getString("ip"));
    }
}

package Plugin.ServerCom;

import Core.Controller;
import Core.Http.Code;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Model;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.ServerCom.Model.ServerComModel;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by teddy on 17/06/2016.
 */
@Controller
public class ServerTestController {
    @Methode("GET")
    @Route("/com/test/{id}")
    public ServerComModel testCom(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        ExerciseIds.getInstance().addId(args.getInt("id"));
        return new ServerComModel().performTest(args.getInt("id"));
    }

    @Methode("GET")
    @Route("/com/token/{token}")
    public ServerComModel getIdByToken(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new ServerComModel().performTest(UserSecuritySingleton.getInstance().getIdByToken(args.getString("token")));
    }
}

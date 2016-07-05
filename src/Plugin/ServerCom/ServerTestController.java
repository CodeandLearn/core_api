package Plugin.ServerCom;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Model;
import Core.Route;
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
    public Model testCom(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        ExerciseIds.getInstance().addId(args.getInt("id"));
        return new Model();
    }
}

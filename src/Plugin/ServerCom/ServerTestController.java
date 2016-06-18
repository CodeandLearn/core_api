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
    @Route("/com/test")
    public Model testCom(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        Client client = new Client();
        client.start();
        Kryo kryo = client.getKryo();
        kryo.register(ServerCom.class);
        try {
            client.connect(5000, "127.0.0.1", 4000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServerCom request = new ServerCom();
        request.text = "Here is the request";
        client.sendTCP(request);
        client.addListener(new Listener() {
            public void received(Connection connection, Object object) {
                if (object instanceof ServerCom) {
                    ServerCom response = (ServerCom) object;
                    System.out.println("Client : " + response.text);
                }
            }
        });
        return new Model();
    }
}

package Plugin.ServerCom.Task;

import Core.Http.Job;
import Core.Singleton.ConfigSingleton;
import Core.Singleton.ServerSingleton;
import Core.Task;
import Plugin.ServerCom.ServerCom;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;

/**
 * Created by teddy on 17/06/2016.
 */
@Task(value = 1500, repeat = false)
public class ServerMain extends Job {
    @Override
    public void task() {
        Server server = new Server();
        server.start();
        try {
            server.bind(Integer.parseInt(ConfigSingleton.getInstance().getPropertie("port_com")));
            ServerSingleton.getInstance().log("[COM] -> opened com server on port " + ConfigSingleton.getInstance().getPropertie("port_com"));
            Kryo kryo = server.getKryo();
            kryo.register(ServerCom.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

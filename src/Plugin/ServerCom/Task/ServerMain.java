package Plugin.ServerCom.Task;

import Core.Http.Job;
import Core.Http.Logger;
import Core.Singleton.ConfigSingleton;
import Core.Singleton.ServerSingleton;
import Core.Task;
import Plugin.ServerCom.AuthPacket;
import Plugin.ServerCom.ExecutePacket;
import Plugin.ServerCom.ExerciseIds;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
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
            kryo.register(AuthPacket.class);
            kryo.register(ExecutePacket.class);
            server.addListener(new Listener() {
                public void received(Connection connection, Object object) {
                    if (object instanceof AuthPacket) {
                        AuthPacket authPacket = (AuthPacket) object;
                        if (authPacket.auth_key.equals(ConfigSingleton.getInstance().getPropertie("auth_key_com"))) {
                            while (true) {
                                try {
                                    int id = ExerciseIds.getInstance().getLastId();
                                    if (id != -1) {
                                        ServerSingleton.getInstance().log("[SERVER] -> execute code for user_exercise_id: " + id);
                                        ExecutePacket executePacket = new ExecutePacket();
                                        executePacket.user_exercise_id = id;
                                        connection.sendTCP(executePacket);
                                    }
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package Plugin.ServerCom.Task;

import Core.Http.Job;
import Core.Singleton.ConfigSingleton;
import Core.Singleton.ServerSingleton;
import Core.Singleton.UserSecuritySingleton;
import Core.Task;
import Plugin.ServerCom.*;
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
        final Server server = new Server();
        server.start();
        try {
            server.bind(Integer.parseInt(ConfigSingleton.getInstance().getPropertie("port_com")));
            ServerSingleton.getInstance().log("[COM] -> opened com server on port " + ConfigSingleton.getInstance().getPropertie("port_com"));
            Kryo kryo = server.getKryo();
            kryo.register(AuthPacket.class);
            kryo.register(ExecutePacket.class);
            kryo.register(AuthenticateClientPacket.class);
            kryo.register(AuthenticatedClientPacket.class);
            server.addListener(new Listener() {
                @Override
                public void received(Connection connection, Object object) {
                    super.received(connection, object);
                    if (object instanceof AuthPacket) {
                        AuthPacket authPacket = (AuthPacket) object;
                        if (authPacket.auth_key.equals(ConfigSingleton.getInstance().getPropertie("auth_key_com"))) {
                            AuthPacket authPacketResp = new AuthPacket();
                            authPacketResp.auth_key = ConfigSingleton.getInstance().getPropertie("auth_key_com");
                            connection.sendTCP(authPacketResp);
                            ExerciseIds.getInstance().setServer(server);
                            ServerSingleton.getInstance().log("[COM] -> credentials is validated");
                        }
                    } else if (object instanceof AuthenticateClientPacket) {
                        AuthenticateClientPacket authenticateClientPacket = (AuthenticateClientPacket) object;
                        ServerSingleton.getInstance().log("[COM] -> request user_id by token");
                        AuthenticatedClientPacket authenticatedClientPacket = new AuthenticatedClientPacket();
                        authenticatedClientPacket.authentication_id = authenticateClientPacket.authentication_id;
                        authenticatedClientPacket.client_id = UserSecuritySingleton.getInstance().getIdByToken(authenticateClientPacket.token);
                        connection.sendTCP(authenticatedClientPacket);
                    }
                }

                @Override
                public void connected(Connection connection) {
                    super.connected(connection);
                    ServerSingleton.getInstance().log("[COM] -> server com connected id: " + connection.getID());
                }

                @Override
                public void disconnected(Connection connection) {
                    super.disconnected(connection);
                    ServerSingleton.getInstance().log("[COM] -> server com disconnected id: " + connection.getID());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

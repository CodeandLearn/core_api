package Plugin.Server.Model;

import Core.Http.Code;
import Core.Http.Map;
import Core.Model;
import Core.Singleton.ConfigSingleton;
import Core.Singleton.NbClientsSingleton;
import Core.Singleton.ServerSingleton;
import Plugin.Server.Obj.ServerObj;

/**
 * Created by teddy on 04/05/2016.
 */
public class Server extends Model {
    public Server(String socket) {
        ServerObj serverObj = new ServerObj();
        serverObj.clients = NbClientsSingleton.getInstance().getNbClients();
        serverObj.ip_host = ServerSingleton.getInstance().getHostIp();
        serverObj.port = ConfigSingleton.getInstance().getPort();
        serverObj.name = ConfigSingleton.getInstance().getName();
        serverObj.version = ConfigSingleton.getInstance().getVersion();
        serverObj.socket_timeout = ConfigSingleton.getInstance().getSocketTimeout();
        data.add(serverObj);
        setCode(socket, Code.OK);
    }

    @Override
    protected Object setData(Map result) {
        return null;
    }
}

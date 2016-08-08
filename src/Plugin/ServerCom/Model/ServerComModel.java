package Plugin.ServerCom.Model;

import Core.Http.Map;
import Core.Model;
import Plugin.ServerCom.Obj.ServerComObj;

/**
 * Created by teddy on 06/07/2016.
 */
public class ServerComModel extends Model {
    public ServerComModel performTest(int id) {
        ServerComObj serverComObj = new ServerComObj();
        serverComObj.id = id;
        data.add(serverComObj);
        return this;
    }

    @Override
    protected Object setData(Map result) {
        return null;
    }
}

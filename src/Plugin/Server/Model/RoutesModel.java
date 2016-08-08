package Plugin.Server.Model;

import Core.Http.Map;
import Core.Model;
import Core.Singleton.PermsSingleton;

import java.util.HashMap;

/**
 * Created by teddy on 13/06/2016.
 */
public class RoutesModel extends Model {
    public RoutesModel getRoutes(String socket) {
        for (HashMap<String, Object> perm : PermsSingleton.getInstance().getPerms()) {
            data.add(perm);
        }
        return this;
    }

    @Override
    protected Object setData(Map result) {
        return null;
    }
}

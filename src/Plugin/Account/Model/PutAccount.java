package Plugin.Account.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Group.Model.GroupModel;
import Plugin.Group.Obj.GroupObj;
import org.json.JSONObject;

/**
 * Created by teddy on 09/04/2016.
 */
public class PutAccount extends Model {
    public PutAccount putAccount(String socket, int id, JSONObject jsonObject) {
        if (jsonObject.isNull("password") || jsonObject.getString("password").equals("")) {
            putAccountWithoutMdp(socket, id, jsonObject);
        } else {
            putAccountWithMdp(socket, id, jsonObject);
        }
        return this;
    }

    private PutAccount putAccountWithMdp(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("username"));
        make.add(UserSecuritySingleton.hashSHA1(jsonObject.getString("password")));
        make.add(jsonObject.getString("email"));
        make.add(jsonObject.getInt("avatar_id"));
        make.add(id);
        setPut(SQL.make("UPDATE accounts SET username=?, password=?, email=?, avatar_id=? WHERE id=?", make.toArray()));
        UserSecuritySingleton.getInstance().updateFullUser(socket, jsonObject.getString("username"),
                UserSecuritySingleton.hashSHA1(jsonObject.getString("password")));
        UserSecuritySingleton.getInstance().revokUserToken(socket);
        return this;
    }

    private PutAccount putAccountWithoutMdp(String socket, int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("username"));
        make.add(jsonObject.getString("email"));
        make.add(jsonObject.getInt("avatar_id"));
        make.add(id);
        setPut(SQL.make("UPDATE accounts SET username=?, email=?, avatar_id=? WHERE id=?", make.toArray()));
        UserSecuritySingleton.getInstance().updateUser(socket, "username", jsonObject.getString("username"));
        return this;
    }

    public PutAccount changeUserGroup(int id, int group_id) {
        make.add(group_id);
        make.add(id);
        setPut(SQL.make("UPDATE accounts SET group_id=? WHERE id=?", make.toArray()));
        int power = ((GroupObj) new GroupModel().getGroupById(group_id).getData().get(0)).parent_id;
        UserSecuritySingleton.getInstance().updateUserById(id, "group", power);
        UserSecuritySingleton.getInstance().revokUserToken(UserSecuritySingleton.getInstance().getSocketById(id));
        return this;
    }

    @Override
    protected Object setData(Map result) {
        return null;
    }
}

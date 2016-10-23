package Plugin.Account.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Http.Code;
import Core.Http.Map;
import Core.Http.Tools;
import Core.Model;
import Core.Singleton.ConfigSingleton;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Badge.Model.BadgeModel;
import Plugin.Badge.Model.UserBadgeModel;
import Plugin.Key.Obj.KeyObj;
import org.json.JSONObject;

/**
 * Created by teddy on 09/04/2016.
 */
public class PostAccount extends Model {
    private boolean isExist(String username, String email) {
        make.add(username);
        make.add(email);
        SQLRequest user = new SQLRequest(SQL.make("SELECT * FROM accounts, groups\n" +
                "WHERE accounts.group_id=groups.id\n" +
                "AND accounts.username=? OR accounts.email=?", make.toArray()));
        user.select();
        make.clear();
        return user.getResultSet().size() > 0;
    }

    public PostAccount register(String socket, JSONObject jsonObject) {
        if (ConfigSingleton.getInstance().getBoolean("register")) {
            if (Tools.isValidEmailAddress(jsonObject.getString("email")) && !isExist(jsonObject.getString("username"), jsonObject.getString("email"))) {
                if (ConfigSingleton.getInstance().getBoolean("beta_key")) {
                    registerBeta(socket, jsonObject);
                } else {
                    registerNormal(socket, jsonObject, 1);
                }
            } else {
                setCode(socket, Code.FORBIDDEN);
                setErrorMsg("User or Email already used by another account or invalid");
            }
        } else {
            setCode(socket, Code.FORBIDDEN);
            setErrorMsg("Register has been disabled");
        }
        return this;
    }

    private void registerNormal(String socket, JSONObject jsonObject, int key_id) {
        make.add(key_id);
        make.add(jsonObject.getString("username"));
        make.add(UserSecuritySingleton.hashSHA1(jsonObject.getString("password")));
        make.add(jsonObject.getString("email"));
        make.add(1);
        make.add(1);
        make.add(getTimestamp());
        make.add(getTimestamp());
        make.add(0);
        make.add(0);
        setPost(SQL.make("INSERT INTO accounts (key_id, username, password, email, group_id, avatar_id, create_timestamp, last_connect_timestamp, nb_courses_done, nb_exercises_done) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", make.toArray()));
        make.clear();
        if (id != -1) {
            UserSecuritySingleton.getInstance().addUser(id, jsonObject.getString("username"), UserSecuritySingleton.hashSHA1(jsonObject.getString("password")), 10);
        } else {
            setCode(socket, Code.INTERNAL_SERVER_ERROR);
        }
    }

    private void registerBeta(String socket, JSONObject jsonObject) {
        if (jsonObject.has("key")) {
            make.add(jsonObject.getString("key"));
            setGet(SQL.make("SELECT * FROM keys WHERE key=? AND account_id=0", make.toArray()));
            make.clear();
            if (data.size() > 0 && ((KeyObj)data.get(0)).id != 1) {
                registerNormal(socket, jsonObject, ((KeyObj)data.get(0)).id);
                if (id != -1) {
                    int account_id = id;
                    make.add(id);
                    make.add(((KeyObj) data.get(0)).id);
                    setPut(SQL.make("UPDATE keys SET account_id=? WHERE id=?", make.toArray()));
                    make.clear();
                    new UserBadgeModel().postAccountBadge(account_id, 1);
                }
            } else {
                setCode(socket, Code.FORBIDDEN);
                setErrorMsg("Please get a beta/access key");
            }
        } else {
            setCode(socket, Code.FORBIDDEN);
            setErrorMsg("Please get a beta/access key");
        }
    }

    @Override
    protected Object setData(Map result) {
        KeyObj keyObj = new KeyObj();
        keyObj.type = result.getInt("keys.type");
        keyObj.account_id = result.getInt("keys.account_id");
        keyObj.id = result.getInt("keys.id");
        keyObj.key = result.getString("keys.key");
        return keyObj;
    }
}

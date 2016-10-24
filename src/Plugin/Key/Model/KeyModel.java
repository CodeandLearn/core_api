package Plugin.Key.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Core.Singleton.ConfigSingleton;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Key.Obj.KeyObj;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

/**
 * Created by teddy on 22/10/2016.
 */
public class KeyModel extends Model {
    @Override
    protected Object setData(Map result) {
        KeyObj keyObj = new KeyObj();
        keyObj.id = result.getInt("access_keys.id");
        keyObj.account_id = result.getInt("access_keys.account_id");
        keyObj.key_value = result.getString("access_keys.key_value");
        keyObj.type = result.getInt("access_keys.type");
        return keyObj;
    }

    public KeyModel getKeys() {
        setGet("SELECT * FROM access_keys ORDER BY id DESC");
        return this;
    }

    public void getKey(String key) {
        make.add(key);
        setGet(SQL.make("SELECT * FROM access_keys WHERE key_value=?", make.toArray()));
        make.clear();
    }

    public KeyModel generateKey(int nb) {
        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < nb; i++) {
            String pre_key = new BigInteger(130, rand).toString(32).toUpperCase();
            int pos = pre_key.length() / 4;
            String final_key = pre_key.substring(0, pos) + "-" + pre_key.substring(pos, pos * 2) + "-" + pre_key.substring(pos * 2, pos * 3) + "-" + pre_key.substring(pos * 3, pre_key.length());
            getKey(final_key);
            if (data.size() == 0) {
                postKey(final_key, 0);
            } else {
                i--;
            }
        }
        return this;
    }

    private void postKey(String key, int type) {
        make.add(0);
        make.add(key);
        make.add(type);
        setPost(SQL.make("INSERT INTO access_keys (account_id, key_value, type) VALUES (?, ?, ?)", make.toArray()));
        make.clear();
    }

    public KeyModel deleteKey(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM access_keys WHERE id=?", make.toArray()));
        return this;
    }
}

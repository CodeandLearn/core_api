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
        keyObj.id = result.getInt("keys.id");
        keyObj.account_id = result.getInt("keys.account_id");
        keyObj.key = result.getString("keys.key");
        keyObj.type = result.getInt("keys.type");
        return keyObj;
    }

    public KeyModel getKeys() {
        setGet("SELECT * FROM `keys` ORDER BY `keys`.id DESC");
        return this;
    }

    public void getKey(String key) {
        make.add(key);
        setGet(SQL.make("SELECT * FROM `keys` WHERE `key`=?", make.toArray()));
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
        setPost(SQL.make("INSERT INTO `keys` (account_id, `key`, type) VALUES (?, ?, ?)", make.toArray()));
        make.clear();
    }

    public KeyModel deleteKey(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM `keys` WHERE id=?", make.toArray()));
        return this;
    }
}

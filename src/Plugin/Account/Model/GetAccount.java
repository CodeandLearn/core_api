package Plugin.Account.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Core.Singleton.ConfigSingleton;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Account.Obj.AccountObj;

/**
 * Created by teddy on 06/04/2016.
 */
public class GetAccount extends Model {
    private boolean showEmail = false;

    @Override
    protected Object setData(Map result) {
        AccountObj accountObj = new AccountObj();
        accountObj.id = result.getInt("accounts.id");
        accountObj.username = result.getString("accounts.username");
        if (showEmail) {
            accountObj.email = result.getString("accounts.email");
        }
        accountObj.email_md5 = UserSecuritySingleton.hashMD5(result.getString("accounts.email"));
        accountObj.avatar_id = result.getInt("accounts.avatar_id");
        accountObj.group_id = result.getInt("accounts.group_id");
        accountObj.create_timestamp = result.getLong("accounts.create_timestamp");
        accountObj.last_connect_timestamp = result.getLong("accounts.last_connect_timestamp");
        accountObj.nb_courses_done = result.getInt("accounts.nb_courses_done");
        accountObj.nb_exercises_done = result.getInt("accounts.nb_exercises_done");
        accountObj.group.id = result.getInt("groups.id");
        accountObj.group.name = result.getString("groups.name");
        accountObj.group.parent_id = result.getInt("groups.parent_id");
        accountObj.avatar.id = result.getInt("avatars.id");
        accountObj.avatar.path = ConfigSingleton.getInstance().getString("url_assets_protocol") + "://" + ConfigSingleton.getInstance().getString("url_assets") + "/assets/images/avatar/" + result.getString("avatars.path");
        return accountObj;
    }

    public GetAccount getAccounts() {
        setGet("SELECT * FROM accounts, groups, avatars\n" +
                "WHERE accounts.avatar_id=avatars.id\n" +
                "AND accounts.group_id=groups.id");
        return this;
    }

    public GetAccount getAccountWithLimit(int limit) {
        make.add(limit);
        setGet(SQL.make("SELECT * FROM accounts, groups, avatars\n" +
                "WHERE accounts.avatar_id=avatars.id\n" +
                "AND accounts.group_id=groups.id LIMIT ?", make.toArray()));
        return this;
    }

    public GetAccount getAccount(int idUser) {
        showEmail = true;
        make.add(idUser);
        if (ConfigSingleton.getInstance().getBoolean("beta_key")) {
            setGet(SQL.make("SELECT * FROM accounts, groups, avatars\n" +
                    "WHERE accounts.avatar_id=avatars.id\n" +
                    "AND accounts.group_id=groups.id AND accounts.id=? AND (accounts.key_id>1 OR accounts.group_id>1)", make.toArray()));
        } else {
            setGet(SQL.make("SELECT * FROM accounts, groups, avatars\n" +
                    "WHERE accounts.avatar_id=avatars.id\n" +
                    "AND accounts.group_id=groups.id AND accounts.id=?", make.toArray()));
        }
        return this;
    }
}

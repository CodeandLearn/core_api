package Plugin.Server.Model;

import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Model;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Account.Model.GetAccount;
import Plugin.Account.Obj.AccountObj;

/**
 * Created by teddy on 08/08/2016.
 */
public class Oauth2ComboModel extends Model {
    public String access_token;
    public Long expires_in;
    public String token_type = Oauth2.BEARER.toLowerCase();
    public String scope = "read/write";
    public Integer group;
    public String email;
    public Integer user_id;
    public String username;

    @Override
    protected Object setData(Map result) {
        return null;
    }

    public Oauth2ComboModel combo(String socket, GetAccount getAccount) {
        Map user = UserSecuritySingleton.getInstance().getUserObj(socket);
        AccountObj accountObj = (AccountObj) getAccount.getData().get(0);
        access_token = user.getString("token");
        expires_in = user.getLong("expires_in");
        group = user.getInt("group");
        email = accountObj.email;
        user_id = accountObj.id;
        username = accountObj.username;
        return this;
    }
}

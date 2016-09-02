package Plugin.Server.Model;

import Core.Http.Code;
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
    public String token_type;
    public String scope;
    public Integer group;
    public String email;
    public Integer user_id;
    public String username;

    @Override
    protected Object setData(Map result) {
        return null;
    }

    public Oauth2ComboModel combo(String socket, GetAccount getAccount) {
        if (getAccount.getData().size() > 0) {
            AccountObj accountObj = (AccountObj) getAccount.getData().get(0);
            Map user = UserSecuritySingleton.getInstance().getUserObj(socket);
            access_token = UserSecuritySingleton.getInstance().getUserToken(socket);
            expires_in = UserSecuritySingleton.getInstance().getTokenExpires(socket);
            group = user.getInt("group");
            scope = "read/write";
            token_type = Oauth2.BEARER.toLowerCase();
            email = accountObj.email;
            user_id = accountObj.id;
            username = accountObj.username;
        } else {
            setCode(socket, Code.UNAUTHORIZED);
            setErrorMsg("username or password is incorrect!");
        }
        return this;
    }
}

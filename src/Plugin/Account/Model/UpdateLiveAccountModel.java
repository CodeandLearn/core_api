package Plugin.Account.Model;

import Core.Http.Map;
import Core.Model;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Account.Obj.AccountObj;

/**
 * Created by Sheol on 04/12/2016.
 */
public class UpdateLiveAccountModel extends Model {
    @Override
    protected Object setData(Map result) {
        AccountObj accountObj = new AccountObj();
        accountObj.id = result.getInt("accounts.id");
        accountObj.username = result.getString("accounts.username").toLowerCase();
        accountObj.username = result.getString("accounts.password");
        accountObj.group.parent_id = result.getInt("groups.parent_id");
        UserSecuritySingleton.getInstance().addUser(id, accountObj.username, accountObj.password, accountObj.group.parent_id);
        return accountObj;
    }

    public UpdateLiveAccountModel updateAccountsInMemory() {
        UserSecuritySingleton.getInstance().cleanUsers();
        setGet("SELECT * FROM accounts, groups " +
                "WHERE accounts.group_id=groups.id");
        return this;
    }
}

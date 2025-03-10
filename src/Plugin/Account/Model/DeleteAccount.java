package Plugin.Account.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Core.Singleton.UserSecuritySingleton;

/**
 * Created by teddy on 09/04/2016.
 */
public class DeleteAccount extends Model {
    public DeleteAccount deleteAccount(String socket, int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM accounts WHERE id=?", make.toArray()));
        UserSecuritySingleton.getInstance().removeUser(socket);
        return this;
    }

    @Override
    protected Object setData(Map result) {
        return null;
    }
}
package Plugin.Account;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Core.Singleton.UserSecuritySingleton;
import Data.SQLDelete;

/**
 * Created by teddy on 09/04/2016.
 */
public class DeleteAccount extends Model {
    public DeleteAccount(String socket, int id) {
        SQLite sql = new SQLite(SQLDelete.ACCOUNT + "id=" + id);
        sql.delete();
        setNoReturnValue(socket);
        UserSecuritySingleton.getInstance().removeUser(socket);
    }
}
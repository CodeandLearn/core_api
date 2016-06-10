package Plugin.Server.Task;

import Core.Database.SQLite;
import Core.Http.Job;
import Core.Singleton.UserSecuritySingleton;
import Core.Task;
import Data.SQLGet;

/**
 * Created by teddy on 10/06/2016.
 */
@Task(repeat = false)
public class AccountTask extends Job {
    @Override
    public void task() {
        SQLite sql = new SQLite(SQLGet.ACCOUNT_LOGIN);
        sql.select();
        for (int i = 0; i < sql.getResultSet().size(); i++) {
            UserSecuritySingleton.getInstance().addUser((int) sql.getResultSet().get(i).get("accounts.id"),
                    (String) sql.getResultSet().get(i).get("accounts.username"),
                    (String) sql.getResultSet().get(i).get("accounts.password"),
                    (int) sql.getResultSet().get(i).get("groups.parent_id"));
        }
        System.out.println("[SYSTEM] -> Nb users loaded: " + UserSecuritySingleton.getInstance().getNbUsers());
    }
}

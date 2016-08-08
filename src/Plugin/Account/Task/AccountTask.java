package Plugin.Account.Task;

import Core.Database.SQLRequest;
import Core.Http.Job;
import Core.Http.Map;
import Core.Singleton.ServerSingleton;
import Core.Singleton.UserSecuritySingleton;
import Core.Task;

/**
 * Created by teddy on 10/06/2016.
 */
@Task(repeat = false)
public class AccountTask extends Job {
    @Override
    public void task() {
        SQLRequest sql = new SQLRequest("SELECT * FROM accounts, groups\n" +
                "WHERE accounts.group_id=groups.id");
        sql.select();
        for (Map result : sql.getResultSet()) {
            UserSecuritySingleton.getInstance().addUser(result.getInt("accounts.id"),
                    result.getString("accounts.username"),
                    result.getString("accounts.password"),
                    result.getInt("groups.parent_id"));
        }
        ServerSingleton.getInstance().log("[SYSTEM] -> Nb users loaded: " + UserSecuritySingleton.getInstance().getNbUsers());
    }
}

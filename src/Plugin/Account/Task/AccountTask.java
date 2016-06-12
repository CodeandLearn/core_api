package Plugin.Account.Task;

import Core.Database.SQLite;
import Core.Http.Job;
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
        SQLite sql = new SQLite("SELECT accounts.id'accounts.id',\n" +
                "accounts.username'accounts.username',\n" +
                "accounts.password'accounts.password',\n" +
                "accounts.email'accounts.email',\n" +
                "accounts.group_id'accounts.group_id',\n" +
                "groups.id'groups.id',\n" +
                "groups.name'groups.name',\n" +
                "groups.parent_id'groups.parent_id'\n" +
                "FROM accounts, groups\n" +
                "WHERE accounts.group_id=groups.id");
        sql.select();
        for (int i = 0; i < sql.getResultSet().size(); i++) {
            UserSecuritySingleton.getInstance().addUser((int) sql.getResultSet().get(i).get("accounts.id"),
                    (String) sql.getResultSet().get(i).get("accounts.username"),
                    (String) sql.getResultSet().get(i).get("accounts.password"),
                    (int) sql.getResultSet().get(i).get("groups.parent_id"));
        }
        ServerSingleton.getInstance().log("[SYSTEM] -> Nb users loaded: " + UserSecuritySingleton.getInstance().getNbUsers());
    }
}

package Plugin.Account.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Model;
import Plugin.Account.Obj.AccountObj;

import java.util.HashMap;

/**
 * Created by teddy on 06/04/2016.
 */
public class GetAccount extends Model {
    protected void setGet(String request) {
        SQLRequest sqLite = new SQLRequest(request);
        sqLite.select();
        for (HashMap<String, Object> result : sqLite.getResultSet()) {
            AccountObj accountObj = new AccountObj();
            accountObj.id = (Integer) result.get("accounts.id");
            accountObj.username = (String) result.get("accounts.username");
            accountObj.email = (String) result.get("accounts.email");
            accountObj.avatar_id = (Integer) result.get("accounts.avatar_id");
            accountObj.group_id = (Integer) result.get("accounts.group_id");
            accountObj.create_timestamp = (Long) result.get("accounts.create_timestamp");
            accountObj.last_connect_timestamp = (Long) result.get("accounts.last_connect_timestamp");
            accountObj.nb_courses_done = (Integer) result.get("accounts.nb_courses_done");
            accountObj.nb_exercices_done = (Integer) result.get("accounts.nb_exercices_done");
            accountObj.group.id = (Integer) result.get("groups.id");
            accountObj.group.name = (String) result.get("groups.name");
            accountObj.group.parent_id = (Integer) result.get("groups.parent_id");
            accountObj.avatar.id = (Integer) result.get("avatars.id");
            accountObj.avatar.path = (String) result.get("avatars.path");
            data.add(accountObj);
        }
    }

    public GetAccount getAccounts(String socket) {
        setGet("SELECT accounts.username\"accounts.username\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.email\"accounts.email\",\n" +
                "accounts.avatar_id\"accounts.avatar_id\",\n" +
                "accounts.group_id\"accounts.group_id\",\n" +
                "accounts.create_timestamp\"accounts.create_timestamp\",\n" +
                "accounts.last_connect_timestamp\"accounts.last_connect_timestamp\",\n" +
                "accounts.nb_courses_done\"accounts.nb_courses_done\",\n" +
                "accounts.nb_exercices_done\"accounts.nb_exercices_done\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\"\n" +
                "FROM accounts, groups, avatars\n" +
                "WHERE accounts.avatar_id=avatars.id\n" +
                "AND accounts.group_id=groups.id");
        return this;
    }

    public GetAccount getAccountWithLimit(String socket, int limit) {
        make.add(limit);
        setGet(SQL.make("SELECT accounts.username\"accounts.username\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.email\"accounts.email\",\n" +
                "accounts.avatar_id\"accounts.avatar_id\",\n" +
                "accounts.group_id\"accounts.group_id\",\n" +
                "accounts.create_timestamp\"accounts.create_timestamp\",\n" +
                "accounts.last_connect_timestamp\"accounts.last_connect_timestamp\",\n" +
                "accounts.nb_courses_done\"accounts.nb_courses_done\",\n" +
                "accounts.nb_exercices_done\"accounts.nb_exercices_done\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\"\n" +
                "FROM accounts, groups, avatars\n" +
                "WHERE accounts.avatar_id=avatars.id\n" +
                "AND accounts.group_id=groups.id LIMIT ?", make.toArray()));
        return this;
    }

    public GetAccount getAccount(String socket, int idUser) {
        make.add(idUser);
        setGet(SQL.make("SELECT accounts.username\"accounts.username\",\n" +
                "accounts.id\"accounts.id\",\n" +
                "accounts.email\"accounts.email\",\n" +
                "accounts.avatar_id\"accounts.avatar_id\",\n" +
                "accounts.group_id\"accounts.group_id\",\n" +
                "accounts.create_timestamp\"accounts.create_timestamp\",\n" +
                "accounts.last_connect_timestamp\"accounts.last_connect_timestamp\",\n" +
                "accounts.nb_courses_done\"accounts.nb_courses_done\",\n" +
                "accounts.nb_exercices_done\"accounts.nb_exercices_done\",\n" +
                "groups.id\"groups.id\",\n" +
                "groups.name\"groups.name\",\n" +
                "groups.parent_id\"groups.parent_id\",\n" +
                "avatars.id\"avatars.id\",\n" +
                "avatars.path\"avatars.path\"\n" +
                "FROM accounts, groups, avatars\n" +
                "WHERE accounts.avatar_id=avatars.id\n" +
                "AND accounts.group_id=groups.id AND accounts.id=?", make.toArray()));
        return this;
    }
}

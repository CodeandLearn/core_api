package Plugin.Account;

import Core.Database.SQLite;
import Core.Model;
import Data.SQLGet;
import Obj.AccountObj;

/**
 * Created by teddy on 06/04/2016.
 */
public class GetAccount extends Model {
    public GetAccount() {
        setData("", "");
    }

    public GetAccount(String extra) {
        setData("AND " + extra, "");
    }

    public GetAccount(String extra, int limit) {
        if (!extra.equals("")) {
            setData("AND " + extra, "LIMIT " + limit);
        } else {
            setData("", "LIMIT " + limit);
        }
    }

    private void setData(String extra, String limit) {
        SQLite sql = new SQLite(SQLGet.ACCOUNT + " " + extra + " ORDER BY accounts.id DESC " + limit);
        sql.select();
        /*if (sql.getResultSet().size() == 0) {
            setCode(404);
            setError("Not Found");
            //setMessage("No data founded !");
        }*/
        for (int i = 0; i < sql.getResultSet().size(); i++) {
            // DEBUG
            System.out.println(i + " - " + sql.getResultSet().get(i));
            // DEBUG
            AccountObj accountObj = new AccountObj();
            accountObj.id = (int) sql.getResultSet().get(i).get("accounts.id");
            accountObj.username = (String) sql.getResultSet().get(i).get("accounts.username");
            accountObj.email = (String) sql.getResultSet().get(i).get("accounts.email");
            accountObj.avatar_id = (int) sql.getResultSet().get(i).get("accounts.avatar_id");
            accountObj.group_id = (int) sql.getResultSet().get(i).get("accounts.group_id");
            accountObj.create_timestamp = Long.parseLong(sql.getResultSet().get(i).get("accounts.create_timestamp").toString());
            accountObj.last_connect_timestamp = Long.parseLong(sql.getResultSet().get(i).get("accounts.last_connect_timestamp").toString());
            accountObj.nb_courses_done = (int) sql.getResultSet().get(i).get("accounts.nb_courses_done");
            accountObj.nb_exercices_done = (int) sql.getResultSet().get(i).get("accounts.nb_exercices_done");
            accountObj.group.id = (int) sql.getResultSet().get(i).get("groups.id");
            accountObj.group.name = (String) sql.getResultSet().get(i).get("groups.name");
            accountObj.group.parent_id = (int) sql.getResultSet().get(i).get("groups.parent_id");
            accountObj.avatar.id = (int) sql.getResultSet().get(i).get("avatars.id");
            accountObj.avatar.path = (String) sql.getResultSet().get(i).get("avatars.path");
            data.add(accountObj);
        }
    }
}

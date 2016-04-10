package Core.Plugins.Account;

import Core.Datas.SQLGet;
import Core.Objs.AccountObj;
import Core.Plugins.Default.Default;
import Core.Tools.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by teddy on 06/04/2016.
 */
public class GetAccount extends Default {
    private ArrayList<AccountObj> data = new ArrayList<>();

    public GetAccount(HttpServletRequest request, HttpServletResponse reply) {
        super(request, reply);
        setData("", "");
    }

    public GetAccount(HttpServletRequest request, HttpServletResponse reply, String extra) {
        super(request, reply);
        setData("AND " + extra, "");
    }

    public GetAccount(HttpServletRequest request, HttpServletResponse reply, String extra, int limit) {
        super(request, reply);
        if (!extra.equals("")) {
            setData("AND " + extra, "LIMIT " + limit);
        } else {
            setData("", "LIMIT " + limit);
        }
    }

    private void setData(String extra, String limit) {
        SQLite sql = new SQLite(SQLGet.ACCOUNT + " " + extra + " ORDER BY accounts.id DESC " + limit);
        sql.select();
        for (int i = 0; i < sql.getResultSet().size(); i++) {
            // DEBUG
            System.out.println(i + " - " + sql.getResultSet().get(i));
            // DEBUG
            AccountObj accountObj = new AccountObj();
            accountObj.id = Integer.parseInt(sql.getResultSet().get(i).get("accounts.id"));
            accountObj.username = sql.getResultSet().get(i).get("accounts.username");
            accountObj.email = sql.getResultSet().get(i).get("accounts.email");
            accountObj.avatar_id = Integer.parseInt(sql.getResultSet().get(i).get("accounts.avatar_id"));
            accountObj.group_id = Integer.parseInt(sql.getResultSet().get(i).get("accounts.group_id"));
            accountObj.create_timestamp = Long.parseLong(sql.getResultSet().get(i).get("accounts.create_timestamp"));
            accountObj.last_connect_timestamp = Long.parseLong(sql.getResultSet().get(i).get("accounts.last_connect_timestamp"));
            accountObj.nb_courses_done = Integer.parseInt(sql.getResultSet().get(i).get("accounts.nb_courses_done"));
            accountObj.nb_exercices_done = Integer.parseInt(sql.getResultSet().get(i).get("accounts.nb_exercices_done"));
            accountObj.group.id = Integer.parseInt(sql.getResultSet().get(i).get("groups.id"));
            accountObj.group.name = sql.getResultSet().get(i).get("groups.name");
            accountObj.group.parent_id = Integer.parseInt(sql.getResultSet().get(i).get("groups.parent_id"));
            accountObj.avatar.id = Integer.parseInt(sql.getResultSet().get(i).get("avatars.id"));
            accountObj.avatar.path = sql.getResultSet().get(i).get("avatars.path");
            data.add(accountObj);
        }
    }

    public ArrayList<AccountObj> getData() {
        return data;
    }
}

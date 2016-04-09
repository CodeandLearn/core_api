package Core.Plugins.Account;

import Core.Datas.SQLPost;
import Core.Objs.AccountObj;
import Core.Plugins.Default.Default;
import Core.Tools.SQLite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by teddy on 09/04/2016.
 */
public class PutAccount extends Default {
    public PutAccount(HttpServletRequest request, HttpServletResponse reply, int id, AccountObj accountObj) {
        super(request, reply);
        updateData(id, accountObj);
    }

    private void updateData(int id, AccountObj accountObj) {
        SQLite sql = new SQLite(SQLPost.ACCOUNT
                + "username=\"" + accountObj.username + "\", "
                + "password=\"" + accountObj.password + "\", "
                + "email=\"" + accountObj.email + "\", "
                + "group_id=" + accountObj.group_id
                + ", avatar_id=" + accountObj.avatar_id
                + " WHERE id=" + id);
        sql.update();
    }
}

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
public class PostAccount extends Default {
    public PostAccount(HttpServletRequest request, HttpServletResponse reply, AccountObj accountObj) {
        super(request, reply);
        insertData(accountObj);
    }

    private void insertData(AccountObj accountObj) {
        long timestamp = System.currentTimeMillis();
        SQLite sql = new SQLite(SQLPost.ACCOUNT + "(username, password, email, group_id, avatar_id, create_timestamp, last_connect_timestamp, nb_courses_done, nb_exercices_done) VALUES ("
                + "\"" + accountObj.username + "\", "
                + "\"" + accountObj.password + "\", "
                + "\"" + accountObj.email + "\", "
                + 1 + ", "
                + 1 + ", "
                + timestamp + ", "
                + timestamp + ", "
                + 0 + ", "
                + 0 + ")");
        sql.insert();
    }
}

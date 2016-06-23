package Plugin.Account.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Http.Code;
import Core.Model;
import Core.Singleton.UserSecuritySingleton;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by teddy on 09/04/2016.
 */
public class PostAccount extends Model {
    private boolean isExist(String username, String email) {
        make.add(username);
        make.add(email);
        SQLRequest user = new SQLRequest(SQL.make("SELECT accounts.id'accounts.id',\n" +
                "accounts.username'accounts.username',\n" +
                "accounts.password'accounts.password',\n" +
                "accounts.email'accounts.email',\n" +
                "accounts.group_id'accounts.group_id',\n" +
                "groups.id'groups.id',\n" +
                "groups.name'groups.name',\n" +
                "groups.parent_id'groups.parent_id'\n" +
                "FROM accounts, groups\n" +
                "WHERE accounts.group_id=groups.id\n" +
                "AND accounts.username=? OR email=?", make.toArray()));
        user.select();
        make.clear();
        return user.getResultSet().size() > 0;
    }

    public PostAccount register(String socket, JSONObject jsonObject) {
        if (!isExist(jsonObject.getString("username"), jsonObject.getString("email"))) {
            make.add(jsonObject.getString("username"));
            make.add(UserSecuritySingleton.hashSHA1(jsonObject.getString("password")));
            make.add(jsonObject.getString("email"));
            make.add(1);
            make.add(1);
            make.add(getTimestamp());
            make.add(getTimestamp());
            make.add(0);
            make.add(0);
            setPost(socket, SQL.make("INSERT INTO accounts (username, password, email, group_id, avatar_id, create_timestamp, last_connect_timestamp, nb_courses_done, nb_exercices_done) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", make.toArray()));
            make.clear();
            if (id != -1) {
                UserSecuritySingleton.getInstance().addUser(id, jsonObject.getString("username"), UserSecuritySingleton.hashSHA1(jsonObject.getString("password")), 10);
            } else {
                setCode(socket, Code.INTERNAL_SERVER_ERROR);
            }
        } else {
            setCode(socket, Code.FORBIDDEN);
            setErrorMsg("User or Email already used by another account");
        }
        return this;
    }
}

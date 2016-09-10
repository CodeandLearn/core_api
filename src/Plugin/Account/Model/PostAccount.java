package Plugin.Account.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Http.Code;
import Core.Http.Map;
import Core.Http.Tools;
import Core.Model;
import Core.Singleton.UserSecuritySingleton;
import org.json.JSONObject;

/**
 * Created by teddy on 09/04/2016.
 */
public class PostAccount extends Model {
    private boolean isExist(String username, String email) {
        make.add(username);
        make.add(email);
        SQLRequest user = new SQLRequest(SQL.make("SELECT * FROM accounts, groups\n" +
                "WHERE accounts.group_id=groups.id\n" +
                "AND accounts.username=? OR accounts.email=?", make.toArray()));
        user.select();
        make.clear();
        return user.getResultSet().size() > 0;
    }

    public PostAccount register(String socket, JSONObject jsonObject) {
        if (Tools.isValidEmailAddress(jsonObject.getString("email")) && !isExist(jsonObject.getString("username"), jsonObject.getString("email"))) {
            make.add(jsonObject.getString("username"));
            make.add(UserSecuritySingleton.hashSHA1(jsonObject.getString("password")));
            make.add(jsonObject.getString("email"));
            make.add(1);
            make.add(1);
            make.add(getTimestamp());
            make.add(getTimestamp());
            make.add(0);
            make.add(0);
            setPost(SQL.make("INSERT INTO accounts (username, password, email, group_id, avatar_id, create_timestamp, last_connect_timestamp, nb_courses_done, nb_exercises_done) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", make.toArray()));
            make.clear();
            if (id != -1) {
                UserSecuritySingleton.getInstance().addUser(id, jsonObject.getString("username"), UserSecuritySingleton.hashSHA1(jsonObject.getString("password")), 10);
            } else {
                setCode(socket, Code.INTERNAL_SERVER_ERROR);
            }
        } else {
            setCode(socket, Code.FORBIDDEN);
            setErrorMsg("User or Email already used by another account or invalid");
        }
        return this;
    }

    @Override
    protected Object setData(Map result) {
        return null;
    }
}

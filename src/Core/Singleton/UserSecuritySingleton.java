package Core.Singleton;

import Core.Database.SQLite;
import Core.Http.Oauth2;
import Data.SQLGet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by teddy on 05/05/2016.
 */
public class UserSecuritySingleton {
    private static UserSecuritySingleton instance = new UserSecuritySingleton();
    private ArrayList<HashMap<String, Object>> users = new ArrayList<>();
    private int nbUsers = 0;

    private UserSecuritySingleton() {
        SQLite sql = new SQLite(SQLGet.ACCOUNT_LOGIN);
        sql.select();
        for (int i = 0; i < sql.getResultSet().size(); i++) {
            addUser((int) sql.getResultSet().get(i).get("accounts.id"),
                    (String) sql.getResultSet().get(i).get("accounts.username"),
                    (String) sql.getResultSet().get(i).get("accounts.password"),
                    (int) sql.getResultSet().get(i).get("groups.parent_id"));
        }
        System.out.println("[SYSTEM] -> Nb users loaded: " + nbUsers);
    }

    public static UserSecuritySingleton getInstance() {
        return instance;
    }

    public static String hashString(String str) {
        String ret = "";
        int hash = ConfigSingleton.getInstance().getSalt();
        for (int i = 0; i < str.length(); i++) {
            hash = hash * 31 + str.charAt(i);
            ret = ret.concat(Integer.toString(hash));
        }
        return ret;
    }

    public void addUser(int id, String username, String password, int group) {
        HashMap<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("password", password);
        user.put("id", id);
        user.put("group", group);
        user.put("socket", "");
        user.put("online", 0);
        user.put("token", "");
        user.put("expires_in", 0);
        nbUsers++;
        users.add(user);
    }

    public void updateUser(String socket, String key, Object value) {
        for (HashMap<String, Object> user : users) {
            if (user.get("socket").equals(socket)) {
                user.replace(key, value);
            }
        }
    }

    public void updateFullUser(String socket, String username, String password) {
        for (HashMap<String, Object> user : users) {
            if (user.get("socket").equals(socket)) {
                user.replace("username", username);
                user.replace("password", password);
            }
        }
    }

    public boolean checkUser(String socket, String username, String password) {
        for (HashMap<String, Object> user : users) {
            if (user.get("username").equals(username) && user.get("password").equals(hashString(password))) {
                user.replace("socket", socket);
                user.replace("online", 1);
                user.replace("token", Oauth2.generateToken());
                user.replace("expires_in", System.currentTimeMillis());
                return true;
            }
        }
        return false;
    }

    public boolean checkToken(String socket, String token) {
        for (HashMap<String, Object> user : users) {
            if (user.get("token").equals(token)) {
                user.replace("socket", socket);
                user.replace("online", 1);
                return true;
            }
        }
        return false;
    }

    public void autoRevokeToken() {
        for (HashMap<String, Object> user : users) {
            if (user.get("token") != "") {
                if (((long) user.get("expires_in") + (ConfigSingleton.getInstance().getTokenExpires() * 1000)) < System.currentTimeMillis()) {
                    System.out.println("[SYSTEM] -> User: " + user.get("username") + " token's revoked");
                    user.replace("token", "");
                    user.replace("expires_in", 0);
                }
            }
        }
    }

    public Object getUserToken(String socket) {
        for (HashMap<String, Object> user : users) {
            if (user.get("socket").equals(socket)) {
                return user.get("token");
            }
        }
        return "";
    }

    public Object getUserGroup(String socket) {
        for (HashMap<String, Object> user : users) {
            if (user.get("socket").equals(socket)) {
                return user.get("group");
            }
        }
        return -1;
    }

    public Object getUserId(String socket) {
        for (HashMap<String, Object> user : users) {
            if (user.get("socket").equals(socket)) {
                return user.get("id");
            }
        }
        return -1;
    }

    public Object getTokenExpires(String socket) {
        for (HashMap<String, Object> user : users) {
            if (user.get("socket").equals(socket)) {
                return user.get("expires_in");
            }
        }
        return -1;
    }

    public void revokUserToken(String socket) {
        for (HashMap<String, Object> user : users) {
            if (user.get("socket").equals(socket)) {
                user.replace("token", "");
                user.replace("expires_in", 0);
            }
        }
    }

    public void setUserOffline(String socket) {
        for (HashMap<String, Object> user : users) {
            if (user.get("socket").equals(socket)) {
                user.replace("online", 0);
            }
        }
    }

    public void removeUser(String socket) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).get("socket").equals(socket)) {
                users.remove(i);
            }
        }
    }
}

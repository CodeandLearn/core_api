package Core.Plugin.User.GET;

import Core.Plugin.Default.Default;
import Core.Tool.SQLiteJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by teddy on 22/03/2016.
 */
public class UserGet extends Default {
    private int id;
    private String username;
    private String email;
    private int group_id;
    private int avatar_id;
    private Timestamp create_timestamp;
    private Timestamp last_connect_timestamp;
    private int nb_courses_done;
    private int nb_exercices_done;

    public UserGet(HttpServletRequest request, HttpServletResponse reply) {
        super(request, reply);
        sqlUser();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getGroupId() {
        return group_id;
    }

    public int getAvatarId() {
        return avatar_id;
    }

    public Timestamp getCreateTimestamp() {
        return create_timestamp;
    }

    public Timestamp getLastConnectTimestamp() {
        return last_connect_timestamp;
    }

    public int getNbCoursesDone() {
        return nb_courses_done;
    }

    public int getNbExercicesDone() {
        return nb_exercices_done;
    }

    public void sqlUser() {
        SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
        ResultSet result = sql.selectDB("SELECT * FROM accounts WHERE id=1");
        try {
            if (result.next()) {
                id = result.getInt("id");
                username = result.getString("username");
                email = result.getString("email");
                group_id = result.getInt("group_id");
                avatar_id = result.getInt("avatar_id");
                create_timestamp = result.getTimestamp("create_timestamp");
                last_connect_timestamp = result.getTimestamp("last_connect_timestamp");
                nb_courses_done = result.getInt("nb_courses_done");
                nb_exercices_done = result.getInt("nb_exercices_done");
            } else {
                reply.sendError(404, "User not found !");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        sql.closeDB();
    }
}

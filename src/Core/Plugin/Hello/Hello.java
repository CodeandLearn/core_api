package Core.Plugin.Hello;

import Core.Tool.SQLiteJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Hello {
    private final long id;
    private final String content;

    public Hello(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void testSQL() {
        SQLiteJDBC sql = new SQLiteJDBC("data");
        ResultSet result = sql.selectDB("SELECT * FROM test");
        int id = -1;
        try {
            if (result.next()) {
                id = result.getInt(1);
            } else {
                System.out.println("Aucun résultat");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(String.valueOf(id));
        sql.closeDB();
    }
}
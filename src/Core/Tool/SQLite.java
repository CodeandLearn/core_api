package Core.Tool;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by teddy on 03/04/2016.
 */
public class SQLite {
    private ArrayList<HashMap<String, String>> entities = new ArrayList<>();
    private String request;

    public SQLite(String request) {
        this.request = request;
    }

    public ArrayList<HashMap<String, String>> getResultSet() {
        return entities;
    }

    public void select() {
        ResultSet result;
        SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
        try {
            result = sql.selectDB(request);
            ResultSetMetaData metaData = result.getMetaData();
            while (result.next()) {
                int i = 1;
                HashMap<String, String> data = new HashMap<>();
                while (i < metaData.getColumnCount()) {
                    data.put(metaData.getColumnName(i), result.getString(i));
                    i++;
                }
                entities.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();
    }
}

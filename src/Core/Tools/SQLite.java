package Core.Tools;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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
                HashMap<String, String> data = new HashMap<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    data.put(metaData.getColumnName(i), result.getString(i));
                }
                entities.add(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();
    }

    public void insert() {
        SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
        System.out.println("DEBUG INSERT " + request);
        sql.insertDB(request);
    }

    public void update() {
        SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
        System.out.println("DEBUG UPDATE " + request);
        sql.updateDB(request);
    }

    public void delete() {
        SQLiteJDBC sql = new SQLiteJDBC("db_SQLlite");
        System.out.println("DEBUG DELETE " + request);
        sql.deleteDB(request);
    }
}

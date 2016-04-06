package Core.Tools;

import java.sql.*;

public class SQLiteJDBC {
    private Connection c = null;
    private Statement stmt = null;

    public SQLiteJDBC(String dbName) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:./db/" + dbName + ".db");
            stmt = c.createStatement();
            c.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDB(String sql) {
        try {
            stmt.executeUpdate(sql);
            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDB(String sql) {
        try {
            stmt.executeUpdate(sql);
            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDB(String sql) {
        try {
            stmt.executeUpdate(sql);
            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectDB(String sql) {
        try {
            ResultSet result = stmt.executeQuery(sql);
            c.commit();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeDB() {
        try {
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
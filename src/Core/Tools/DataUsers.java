package Core.Tools;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by teddy on 11/04/2016.
 */
public class DataUsers {
    public ArrayList<HashMap<String, Object>> users = new ArrayList<>();

    private DataUsers() {
    }

    private static DataUsers instance = new DataUsers();

    public static DataUsers getInstance() {
        return instance;
    }
}

package Plugin.Badge.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import org.json.JSONObject;

/**
 * Created by teddy on 26/11/2016.
 */
public class ConditionBadgeModel extends Model {
    private String request = "";

    @Override
    protected Object setData(Map result) {
        return result;
    }

    private void addCondition(String key, String value) {
        request = request.concat(" AND " + key + "" + value);
    }

    public boolean checkCondition(String table, int account_id, JSONObject current_key_table) {
        make.add(account_id);
        request = "SELECT * FROM " + table + " WHERE " + table.split(",")[0] + ".account_id=?";
        for (Object key_table : current_key_table.keySet()) {
            Object current_condition = current_key_table.get(key_table.toString());
            if (!key_table.toString().equals("count")) {
                addCondition(key_table.toString(), current_condition.toString());
            }
        }
        setGet(SQL.make(request, make.toArray()));
        System.err.println(request + " -> " + data.size());
        if (current_key_table.has("count")) {
            System.err.println(current_key_table.getInt("count"));
            if (data.size() >= current_key_table.getInt("count")) {
                return true;
            }
        }
        return false;
    }
}

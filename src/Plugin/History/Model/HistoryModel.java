package Plugin.History.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Core.Singleton.UserSecuritySingleton;
import Plugin.History.Obj.HistoryObj;

/**
 * Created by teddy on 22/10/2016.
 */
public class HistoryModel extends Model {
    @Override
    protected Object setData(Map result) {
        HistoryObj historyObj = new HistoryObj();
        historyObj.action = result.getString("history.action");
        historyObj.id = result.getInt("history.id");
        historyObj.type = result.getInt("history.type");
        historyObj.category = result.getString("history.category");
        historyObj.timestamp = result.getLong("history.timestamp");
        historyObj.account.username = result.getString("accounts.username");
        return historyObj;
    }

    public HistoryModel getHistoryAccountById(int id_account) {
        make.add(id_account);
        setGet(SQL.make("SELECT * FROM history, accounts WHERE history.account_id=accounts.id AND history.account_id=? ORDER BY history.id DESC LIMIT 30", make.toArray()));
        return this;
    }

    public void postHistory(int account_id, String category, String action, int type) {
        make.add(account_id);
        make.add(category);
        make.add(action);
        make.add(type);
        make.add(getTimestamp());
        setPost(SQL.make("INSERT INTO history (account_id, category, action, type, timestamp) VALUES (?, ?, ?, ?, ?)", make.toArray()));
    }
}

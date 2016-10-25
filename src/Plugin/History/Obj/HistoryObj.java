package Plugin.History.Obj;

import Plugin.Account.Obj.AccountObj;

/**
 * Created by teddy on 22/10/2016.
 */
public class HistoryObj {
    public int id;
    public int account_id;
    public String category;
    public String action;
    public int type;
    public long timestamp;

    public AccountObj account = new AccountObj();
}

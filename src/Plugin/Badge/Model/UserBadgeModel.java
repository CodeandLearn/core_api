package Plugin.Badge.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Core.Singleton.ConfigSingleton;
import Plugin.Badge.Obj.UserBadgeObj;
import Plugin.History.Model.HistoryModel;

/**
 * Created by teddy on 22/10/2016.
 */
public class UserBadgeModel extends Model {
    @Override
    protected Object setData(Map result) {
        UserBadgeObj userBadgeObj = new UserBadgeObj();
        userBadgeObj.account_id = result.getInt("users_badges.account_id");
        userBadgeObj.badge_id = result.getInt("users_badges.badge_id");
        userBadgeObj.timestamp = result.getLong("users_badges.timestamp");
        userBadgeObj.badge.id = result.getInt("badges.id");
        userBadgeObj.badge.path_img = ConfigSingleton.getInstance().getString("url_assets_protocol") + "://" + ConfigSingleton.getInstance().getString("url_assets") + "/assets/images/badge/" + result.getString("badges.path_img");
        userBadgeObj.badge.name = result.getString("badges.name");
        userBadgeObj.badge.description = result.getString("badges.description");
        return userBadgeObj;
    }

    public UserBadgeModel getAccountBadges(int account_id) {
        make.add(account_id);
        setGet(SQL.make("SELECT * FROM users_badges, badges WHERE users_badges.badge_id=badges.id AND users_badges.account_id=? ORDER BY users_badges.badge_id DESC", make.toArray()));
        return this;
    }

    public UserBadgeModel getAccountsBadges() {
        setGet("SELECT * FROM users_badges, badges WHERE users_badges.badge_id=badges.id ORDER BY users_badges.badge_id DESC");
        return this;
    }

    public boolean hasBadge(int account_id, int id_badge) {
        make.add(account_id);
        make.add(id_badge);
        setGet(SQL.make("SELECT * FROM users_badges, badges WHERE users_badges.badge_id=badges.id AND users_badges.account_id=? AND users_badges.badge_id=?", make.toArray()));
        make.clear();
        return data.size() > 0;
    }

    public UserBadgeModel postAccountBadge(int account_id, int id) {
        if (!hasBadge(account_id, id)) {
            make.add(account_id);
            make.add(id);
            make.add(getTimestamp());
            setPost(SQL.make("INSERT INTO users_badges (account_id, badge_id, timestamp) VALUES (?, ?, ?)", make.toArray()));
            new HistoryModel().postHistory(account_id, "badge", "obtenu un nouveau badge.", 0);
        }
        return this;
    }

    public UserBadgeModel putAccountBadge(int id_account, int id) {
        make.add(id_account);
        make.add(id);
        setPut(SQL.make("UPDATE users_badges SET account_id=? WHERE badge_id=?", make.toArray()));
        return this;
    }

    public UserBadgeModel deleteAccountBadge(int id_account, int id) {
        make.add(id_account);
        make.add(id);
        setDelete(SQL.make("DELETE FROM users_badges WHERE id_account=? AND badge_id=?", make.toArray()));
        return this;
    }
}

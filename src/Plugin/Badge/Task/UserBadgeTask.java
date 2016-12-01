package Plugin.Badge.Task;

import Core.Http.Job;
import Core.Http.Map;
import Core.Singleton.UserSecuritySingleton;
import Core.Task;
import Plugin.Badge.Model.BadgeModel;
import Plugin.Badge.Model.ConditionBadgeModel;
import Plugin.Badge.Model.UserBadgeModel;
import Plugin.Badge.Obj.BadgeObj;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by teddy on 22/10/2016.
 */
@Task(value = 60000)
public class UserBadgeTask extends Job {
    @Override
    public void task() {
        ArrayList<Object> badges = new BadgeModel().getBadges().getData();
        CopyOnWriteArrayList<Map> users = UserSecuritySingleton.getInstance().getUsers();
        for (Map user : users) {
            for (Object badge : badges) {
                JSONObject jsonObject = new JSONObject(((BadgeObj) badge).conditions);
                int total_item = 0;
                int valid_item = 0;
                for (Object current_key : jsonObject.keySet()) {
                    JSONObject current_key_table = jsonObject.getJSONObject(current_key.toString());
                    total_item++;
                    if (new ConditionBadgeModel().checkCondition(current_key.toString(), user.getInt("id"), current_key_table)) {
                        valid_item++;
                    }
                }
                if (total_item == valid_item && total_item != 0) {
                    System.err.println("validate");
                    new UserBadgeModel().postAccountBadge(user.getInt("id"), ((BadgeObj) badge).id);
                }
            }
        }
    }
}

package Plugin.Badge.Task;

import Core.Http.Job;
import Core.Http.Map;
import Core.Singleton.UserSecuritySingleton;
import Core.Task;
import Plugin.Badge.Model.UserBadgeModel;
import Plugin.Course.Model.GetCourse;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by teddy on 22/10/2016.
 */
@Task(value = 60000)
public class UserBadgeTask extends Job {
    @Override
    public void task() {
        CopyOnWriteArrayList<Map> users = UserSecuritySingleton.getInstance().getUsers();
        for (Map user : users) {
            int nb = new GetCourse().getAccountCourses(user.getInt("id")).getData().size();
            if (nb >= 5) {
                new UserBadgeModel().postAccountBadge(user.getInt("id"), 2);
            }
            if (nb >= 10) {
                new UserBadgeModel().postAccountBadge(user.getInt("id"), 3);
            }
            if (nb >= 30) {
                new UserBadgeModel().postAccountBadge(user.getInt("id"), 4);
            }
            if (nb >= 50) {
                new UserBadgeModel().postAccountBadge(user.getInt("id"), 5);
            }
        }
    }
}

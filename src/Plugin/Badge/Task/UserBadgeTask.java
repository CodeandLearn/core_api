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
                new UserBadgeModel().postAccountBadge(user.getInt("id"), 6); //publish 5 courses
            }
            if (nb >= 10) {
                new UserBadgeModel().postAccountBadge(user.getInt("id"), 7); //publish 10 courses
            }
            if (nb >= 30) {
                new UserBadgeModel().postAccountBadge(user.getInt("id"), 8); //publish 30 courses
            }
            if (nb >= 50) {
                new UserBadgeModel().postAccountBadge(user.getInt("id"), 9); //publish 50 courses
            }
            if (user.getLong("create_timestamp") > 1479963600000L && user.getLong("create_timestamp") < 1480197600000L) { //Epitech Experience dates in timestamp
                new UserBadgeModel().postAccountBadge(user.getInt("id"), 10);  //Epitech Experience 2016
            }
        }
    }
}

package Plugin.Server.Task;

import Core.Http.Job;
import Core.Singleton.ConfigSingleton;
import Core.Task;

/**
 * Created by teddy on 23/10/2016.
 */
@Task(value = 60000)
public class ConfigTask extends Job {
    @Override
    public void task() {
        //System.err.println("config reload...");
        ConfigSingleton.getInstance().reload();
    }
}

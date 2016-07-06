package Plugin.ServerCom.Task;

import Core.Http.Job;
import Core.Singleton.ServerSingleton;
import Core.Task;
import Plugin.ServerCom.ExecutePacket;
import Plugin.ServerCom.ExerciseIds;

/**
 * Created by teddy on 06/07/2016.
 */
@Task(value = 500)
public class SenderCom extends Job {
    @Override
    public void task() {
        if (ExerciseIds.getInstance().getServer() != null) {
            try {
                int id = ExerciseIds.getInstance().getLastId();
                if (id != -1) {
                    ServerSingleton.getInstance().log("[COM] -> execute code for user_exercise_id: " + id);
                    ExecutePacket executePacket = new ExecutePacket();
                    executePacket.user_exercise_id = id;
                    ExerciseIds.getInstance().getServer().sendToAllTCP(executePacket);
                }
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

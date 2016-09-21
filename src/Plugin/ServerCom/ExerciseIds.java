package Plugin.ServerCom;

import Core.Singleton.ServerSingleton;
import com.esotericsoftware.kryonet.Server;

import java.util.ArrayList;

/**
 * Created by teddy on 05/07/2016.
 */
public class ExerciseIds {
    private ArrayList<Integer> list = new ArrayList<>();
    private Server server;

    private static class SingletonHolder {
        private static ExerciseIds instance = new ExerciseIds();
    }

    public static ExerciseIds getInstance() {
        return SingletonHolder.instance;
    }

    public boolean inQueue(int id) {
        for (int id_ex : list) {
            if (id_ex == id) {
                return true;
            }
        }
        return false;
    }

    public void addId(int id) {
        list.add(id);
        ServerSingleton.getInstance().log("[COM] -> new exercise in queue " + id);
    }

    public int getLastId() {
        if (!list.isEmpty()) {
            int i = list.get(0);
            list.remove(0);
            return i;
        }
        return -1;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Server getServer() {
        return server;
    }
}
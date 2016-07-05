package Plugin.ServerCom;

import java.util.ArrayList;

/**
 * Created by teddy on 05/07/2016.
 */
public class ExerciseIds {
    private ArrayList<Integer> list = new ArrayList<>();

    private static class SingletonHolder {
        private static ExerciseIds instance = new ExerciseIds();
    }

    public static ExerciseIds getInstance() {
        return SingletonHolder.instance;
    }

    public void addId(int id) {
        list.add(id);
    }

    public int getLastId() {
        if (!list.isEmpty()) {
            int i = list.get(0);
            list.remove(0);
            return i;
        }
        return -1;
    }
}
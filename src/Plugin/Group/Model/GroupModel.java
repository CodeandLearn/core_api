package Plugin.Group.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Group.Obj.GroupObj;
import org.json.JSONObject;

/**
 * Created by Sheol on 05/12/2016.
 */
public class GroupModel extends Model {
    @Override
    protected Object setData(Map result) {
        GroupObj groupObj = new GroupObj();
        groupObj.id = result.getInt("groups.id");
        groupObj.name = result.getString("groups.name");
        groupObj.parent_id = result.getInt("groups.parent_id");
        return groupObj;
    }

    public GroupModel getGroups() {
        setGet("SELECT * FROM groups ORDER BY parent_id DESC");
        return this;
    }

    public GroupModel getGroupById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM groups WHERE id=?", make.toArray()));
        return this;
    }

    public GroupModel getGroupByPower(int power) {
        make.add(power);
        setGet(SQL.make("SELECT * FROM groups WHERE parent_id=?", make.toArray()));
        return this;
    }

    public GroupModel postGroup(JSONObject jsonObject) {
        make.add(jsonObject.getString("name"));
        make.add(jsonObject.getInt("parent_id"));
        setPost(SQL.make("INSERT INTO groups (name, parent_id) VALUES (?, ?)", make.toArray()));
        return this;
    }

    public GroupModel putGroup(int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("name"));
        make.add(jsonObject.getInt("parent_id"));
        make.add(id);
        setPut(SQL.make("UPDATE groups SET name=?, parent_id=? WHERE id=?", make.toArray()));
        return this;
    }

    public GroupModel updatePower(int id, int power) {
        make.add(power);
        make.add(id);
        setPut(SQL.make("UPDATE groups SET parent_id=? WHERE id=?", make.toArray()));
        return this;
    }

    public GroupModel deleteGroup(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM groups WHERE id=?", make.toArray()));
        return this;
    }
}

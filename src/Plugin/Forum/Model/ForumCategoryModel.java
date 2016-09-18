package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumCategoryObj;
import org.json.JSONObject;


/**
 * Created by moran on 9/1/2016.
 */
public class ForumCategoryModel extends Model {
    protected Object setData(Map results) {
        ForumCategoryObj fcObj = new ForumCategoryObj();
        fcObj.id = results.getInt("forum_category.id");
        fcObj.name = results.getString("forum_category.name");
        return fcObj;
    }

    public ForumCategoryModel getForumCategories() {
        make.add(1);
        setGet(SQL.make("SELECT * FROM forum_category ORDER BY id", make.toArray()));
        return this;
    }

    public ForumCategoryModel addCategory(JSONObject jsonObject) {
        make.add(jsonObject.getString("name"));
        setPost(SQL.make("INSERT INTO forum_category (name) VALUES (?)", make.toArray()));
        return this;
    }

    public ForumCategoryModel modifyCategory(int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("name"));
        make.add(id);
        setPut(SQL.make("UPDATE forum_category SET name=? WHERE id=?", make.toArray()));
        return this;
    }

    public ForumCategoryModel deleteCategory(int id){
        make.add(id);
        setDelete(SQL.make("DELETE FROM forum_category WHERE id = ?", make.toArray()));
        return this;
    }

}

package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumSubCategoryObj;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by moran on 9/1/2016.
 */
public class ForumSubCategoryModel extends Model {
    @Override
    protected Object setData(Map result) {
        ForumSubCategoryObj fObj = new ForumSubCategoryObj();
        fObj.id = result.getInt("forum_subcategories.id");
        fObj.forum_category_id = result.getInt("forum_subcategories.forum_category.id");
        fObj.title = result.getString("forum_subcategories.title");
        fObj.description = result.getString("forum_subcategories.description");
        return fObj;
    }

    public ForumSubCategoryModel getForums(int forum_category_id) {
        make.add(forum_category_id);
        setGet(SQL.make("SELECT * FROM forum_subcategories WHERE forum_category_id=?", make.toArray()));
        return this;
    }

    public ForumSubCategoryModel insert(JSONObject jsonObject) {
        make.add(jsonObject.getInt("forum_category_id"));
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("description"));
        setPost(SQL.make("INSERT INTO forum_subcategories (forum_category_id, title, description) VALUES (?,?,?)", make.toArray()));
        return this;
    }

    public ForumSubCategoryModel update(int id, JSONObject jsonObject){
        make.add(jsonObject.getInt("forum_category_id"));
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("description"));
        make.add(id);
        setPut(SQL.make("UPDATE forum_subcategories SET forum_category_id=?, title=?, description=? WHERE id=?)", make.toArray()));
        return this;
    }


    public ForumSubCategoryModel delete(int id){
        make.add(id);
        setDelete(SQL.make("DELETE FROM forum_subcategories WHERE id=?", make.toArray()));
        SQLRequest sql = new SQLRequest(SQL.make("SELECT id FROM forum_subjects WHERE forum_subcategory_id = ?", make.toArray()));
        sql.select();
        new ForumSubjectModel().deleteAll(id, sql.getResultSet());
        return this;
    }

    public ForumSubCategoryModel deleteAll(int category_id, ArrayList<Map> resultset){
        for (Map r : resultset) {
            make.add(r.getInt("forum_subcategories.id"));
            SQLRequest sql = new SQLRequest(SQL.make("SELECT id FROM forum_subjects WHERE forum_subcategory_id = ?", make.toArray()));
            sql.select();
            new ForumSubjectModel().deleteAll(r.getInt("forum_subcategories.id"), sql.getResultSet());
            make.clear();
        }

        make.add(category_id);
        setDelete(SQL.make("DELETE FROM forum_subcategories WHERE forum_category_id=?", make.toArray()));

        return this;
    }
}

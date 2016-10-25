package Plugin.Forum.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
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
        fcObj.id = results.getInt("forum_categories.id");
        fcObj.title = results.getString("forum_categories.title");
        fcObj.description = results.getString("forum_categories.description");
        return fcObj;
    }

    public ForumCategoryModel getForumCategories() {
        setGet("SELECT * FROM forum_categories");
        return this;
    }

    public ForumCategoryModel addCategory(JSONObject jsonObject) {
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("description"));
        setPost(SQL.make("INSERT INTO forum_categories (title, description) VALUES (?, ?)", make.toArray()));
        return this;
    }

    public ForumCategoryModel modifyCategory(int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("title"));
        make.add(jsonObject.getString("description"));
        make.add(id);
        setPut(SQL.make("UPDATE forum_categories SET title=? , description=? WHERE id = ?", make.toArray()));
        return this;
    }

    public ForumCategoryModel deleteCategory(int id){
        // delete all subcategories

        // SELECT id from forum_subcategories WHERE forum_category_id = ?
        make.add(id);
        SQLRequest sql = new SQLRequest(SQL.make("SELECT id from forum_subcategories WHERE forum_category_id = ?", make.toArray()));
        sql.select();

        new ForumSubCategoryModel().deleteAll(id, sql.getResultSet());

        setDelete(SQL.make("DELETE FROM forum_categories WHERE id = ?", make.toArray()));
        return this;
    }
}

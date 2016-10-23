package Plugin.Badge.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Core.Singleton.ConfigSingleton;
import Plugin.Badge.Obj.BadgeObj;
import org.json.JSONObject;

/**
 * Created by teddy on 22/10/2016.
 */
public class BadgeModel extends Model {
    @Override
    protected Object setData(Map result) {
        BadgeObj badgeObj = new BadgeObj();
        badgeObj.id = result.getInt("badges.id");
        badgeObj.name = result.getString("badges.name");
        badgeObj.nb_courses_done = result.getInt("badges.nb_courses_done");
        badgeObj.nb_exercises_done = result.getInt("badges.nb_exercises_done");
        badgeObj.type = result.getInt("badges.type");
        badgeObj.path_img = ConfigSingleton.getInstance().getString("url_assets_protocol") + "://" + ConfigSingleton.getInstance().getString("url_assets") + "/assets/images/badge/" + result.getString("badges.path_img");
        return badgeObj;
    }

    public BadgeModel getBadges() {
        setGet("SELECT * FROM badges ORDER BY id DESC");
        return this;
    }

    public BadgeModel postBadge(JSONObject jsonObject) {
        make.add(jsonObject.getString("name"));
        make.add(jsonObject.getInt("nb_courses_done"));
        make.add(jsonObject.getInt("nb_exercises_done"));
        make.add(jsonObject.getString("path_img"));
        make.add(jsonObject.getInt("type"));
        setPost(SQL.make("INSERT INTO badges (name, nb_courses_done, nb_exercises_done, path_img, type) VALUES (?, ?, ?, ?, ?)", make.toArray()));
        return this;
    }

    public BadgeModel putBadge(int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("name"));
        make.add(jsonObject.getInt("nb_courses_done"));
        make.add(jsonObject.getInt("nb_exercises_done"));
        make.add(jsonObject.getString("path_img"));
        make.add(jsonObject.getInt("type"));
        make.add(id);
        setPut(SQL.make("UPDATE badges SET name=?, nb_courses_done=?, nb_exercises_done=?, path_img=?, type=? WHERE id=?", make.toArray()));
        return this;
    }

    public BadgeModel deleteBadge(int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM badges WHERE id=?", make.toArray()));
        return this;
    }
}

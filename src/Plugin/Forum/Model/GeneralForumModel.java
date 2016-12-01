package Plugin.Forum.Model;

import Core.Http.Map;
import Core.Model;
import Plugin.Forum.Obj.ForumObj;

/**
 * Created by teddy on 27/11/2016.
 */
public class GeneralForumModel extends Model {
    @Override
    protected Object setData(Map result) {
        ForumObj forumObj = new ForumObj();
        forumObj.title = result.getString("forum_categories.title");
        forumObj.id = result.getInt("forum_categories.id");
        forumObj.description = result.getString("forum_categories.description");
        forumObj.forums = new ForumModel().getForumByCategoryId(result.getInt("forum_categories.id")).getData();
        return forumObj;
    }

    public GeneralForumModel getForum() {
        setGet("SELECT * FROM forum_categories");
        return this;
    }
}

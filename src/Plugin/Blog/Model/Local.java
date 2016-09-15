package Plugin.Blog.Model;

import Core.Http.Map;
import Core.Model;
import Plugin.Blog.Obj.LocalObj;

/**
 * Created by teddy on 15/09/2016.
 */
public class Local extends Model {
    @Override
    protected Object setData(Map result) {
        LocalObj localObj = new LocalObj();
        localObj.id = result.getInt("locales.id");
        localObj.name = result.getString("locales.name");
        return localObj;
    }

    public Local getLocales() {
        setGet("SELECT * FROM locales");
        return this;
    }
}

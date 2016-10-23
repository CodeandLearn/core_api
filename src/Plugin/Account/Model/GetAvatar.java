package Plugin.Account.Model;

import Core.Http.Map;
import Core.Model;
import Core.Singleton.ConfigSingleton;
import Plugin.Account.Obj.AvatarObj;

/**
 * Created by teddy on 15/09/2016.
 */
public class GetAvatar extends Model {
    @Override
    protected Object setData(Map result) {
        AvatarObj avatarObj = new AvatarObj();
        avatarObj.id = result.getInt("avatars.id");
        avatarObj.name = result.getString("avatars.name");
        avatarObj.path = ConfigSingleton.getInstance().getString("url_assets_protocol") + "://" + ConfigSingleton.getInstance().getString("url_assets") + "/assets/images/avatar/" + result.getString("avatars.path");
        return avatarObj;
    }

    public GetAvatar getAvatars() {
        setGet("SELECT * FROM avatars");
        return this;
    }
}

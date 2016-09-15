package Plugin.Account.Model;

import Core.Http.Map;
import Core.Model;
import Plugin.Account.Obj.AvatarObj;

/**
 * Created by teddy on 15/09/2016.
 */
public class GetAvatar extends Model {
    @Override
    protected Object setData(Map result) {
        AvatarObj avatarObj = new AvatarObj();
        avatarObj.id = result.getInt("avatars.id");
        avatarObj.path = result.getString("avatars.path");
        return avatarObj;
    }

    public GetAvatar getAvatars() {
        setGet("SELECT * FROM avatars");
        return this;
    }
}

package Plugin.Forum;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Plugin.Forum.Model.*;
import org.json.JSONObject;

/**
 * Created by teddy on 27/11/2016.
 */
@Controller
public class ForumController {
    @Methode("GET")
    @Route("/forum")
    public GeneralForumModel getForum(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GeneralForumModel().getForum();
    }
}

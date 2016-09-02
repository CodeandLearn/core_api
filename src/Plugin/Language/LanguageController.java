package Plugin.Language;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Plugin.Language.Model.DeleteLanguage;
import Plugin.Language.Model.GetLanguage;
import Plugin.Language.Model.PostLanguage;
import Plugin.Language.Model.PutLanguage;
import org.json.JSONObject;

/**
 * Created by teddy on 12/06/2016.
 */
@Controller
public class LanguageController {
    @Methode("GET")
    @Route("/languages")
    public GetLanguage getLanguage(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetLanguage().getLanguage();
    }

    @Methode("GET")
    @Route("/language/limit/{limit}")
    public GetLanguage getLanguageWithLimit(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetLanguage().getLanguageWithLimit(args.getInt("limit"));
    }

    @Methode("GET")
    @Route("/language/{id}")
    public GetLanguage getLanguageById(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new GetLanguage().getLanguageById(args.getInt("id"));
    }

    @Methode("POST")
    @Route("/language")
    public PostLanguage postLanguage(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PostLanguage().postLanguage(jsonObject);
    }

    @Methode("PUT")
    @Route("/language/{id}")
    public PutLanguage putLanguage(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new PutLanguage().putLanguage(args.getInt("id"), jsonObject);
    }

    @Methode("DELETE")
    @Route("/language/{id}")
    public DeleteLanguage deleteLanguage(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new DeleteLanguage().deleteLanguage(args.getInt("id"));
    }
}

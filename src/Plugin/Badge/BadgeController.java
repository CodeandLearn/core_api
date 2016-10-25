package Plugin.Badge;

import Core.Controller;
import Core.Http.Header;
import Core.Http.Map;
import Core.Http.Oauth2;
import Core.Methode;
import Core.Route;
import Core.Singleton.UserSecuritySingleton;
import Plugin.Badge.Model.BadgeModel;
import Plugin.Badge.Model.UserBadgeModel;
import org.json.JSONObject;

/**
 * Created by teddy on 22/10/2016.
 */
@Controller
public class BadgeController {
    @Methode("GET")
    @Route("/badges")
    public BadgeModel getBadges(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new BadgeModel().getBadges();
    }

    @Methode("GET")
    @Route("/account/badges/list")
    public UserBadgeModel getAccountBadges(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserBadgeModel().getAccountBadges(UserSecuritySingleton.getInstance().getUserId(socket));
    }

    @Methode("GET")
    @Route("/accounts/badges/list")
    public UserBadgeModel getAccountsBadges(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserBadgeModel().getAccountsBadges();
    }

    @Methode("POST")
    @Route("/badge")
    public BadgeModel postBadge(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new BadgeModel().postBadge(jsonObject);
    }

    @Methode("POST")
    @Route("/account/{id_account}/badge")
    public UserBadgeModel postAccountBadge(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserBadgeModel().postAccountBadge(args.getInt("id_account"), args.getInt("id"));
    }

    @Methode("PUT")
    @Route("/badge/{id}")
    public BadgeModel putBadge(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new BadgeModel().putBadge(args.getInt("id"), jsonObject);
    }

    @Methode("PUT")
    @Route("/account/{id_account}/badge/{id}")
    public UserBadgeModel putAccountBadge(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserBadgeModel().putAccountBadge(args.getInt("id_account"), args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/badge/{id}")
    public BadgeModel deleteBadge(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new BadgeModel().deleteBadge(args.getInt("id"));
    }

    @Methode("DELETE")
    @Route("/account/{id_account}/badge/{id}")
    public UserBadgeModel deleteAccountBadge(String socket, Oauth2 oauth2, Header header, JSONObject jsonObject, Map args) {
        return new UserBadgeModel().deleteAccountBadge(args.getInt("id_account"), args.getInt("id"));
    }
}

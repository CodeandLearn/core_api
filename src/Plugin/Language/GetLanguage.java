package Plugin.Language;

import Core.Database.SQLite;
import Core.Http.Code;
import Core.Model;
import Data.SQLGet;

/**
 * Created by Fabien on 06/05/2016.
 */
public class GetLanguage extends Model {
    public GetLanguage(String socket) {
        setData(socket, "", "");
    }

    public GetLanguage(String socket, String extra) {
        setData(socket, " WHERE " + extra, "");
    }

    public GetLanguage(String socket, String extra, int limit) {
        if (!extra.equals("")) {
            setData(socket, " WHERE " + extra, " LIMIT " + limit);
        } else {
            setData(socket, "", " LIMIT " + limit);
        }
    }

    private void setData(String socket, String extra, String limit) {
        System.out.println(SQLGet.LANGUAGE + " " + extra + " ORDER BY languages.id DESC " + limit);
        SQLite sql = new SQLite(SQLGet.LANGUAGE + " " + extra + " ORDER BY languages.id DESC " + limit);
        sql.select();
        if (sql.getResultSet().size() == 0) {
            setCode(socket, Code.NOT_FOUND);
        } else {
            for (int i = 0; i < sql.getResultSet().size(); i++) {
                // DEBUG
                System.out.println(i + " - " + sql.getResultSet().get(i));
                // DEBUG
                LanguageObj languageObj = new LanguageObj();
                languageObj.language.id = (int) sql.getResultSet().get(i).get("languages.id");
                languageObj.language.name = (String) sql.getResultSet().get(i).get("languages.name");
                data.add(languageObj);
            }
        }
    }
}

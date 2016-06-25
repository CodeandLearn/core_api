package Plugin.Language.Model;

import Core.Database.SQL;
import Core.Database.SQLRequest;
import Core.Model;
import Plugin.Language.Obj.LanguageObj;

import java.util.HashMap;

/**
 * Created by Fabien on 06/05/2016.
 */
public class GetLanguage extends Model {
    protected void setGet(String request) {
        SQLRequest sql = new SQLRequest(request);
        sql.select();
        for (HashMap<String, Object> result : sql.getResultSet()) {
            LanguageObj languageObj = new LanguageObj();
            languageObj.language.id = (Integer) result.get("languages.id");
            languageObj.language.name = (String) result.get("languages.name");
            data.add(languageObj);
        }
    }

    public GetLanguage getLanguage(String socket) {
        setGet("SELECT languages.id\"languages.id\",\n" +
                "languages.name\"languages.name\"\n" +
                "FROM languages ORDER BY languages.name ASC");
        return this;
    }

    public GetLanguage getLanguageWithLimit(String socket, int limit) {
        make.add(limit);
        setGet(SQL.make("SELECT languages.id\"languages.id\",\n" +
                "languages.name\"languages.name\"\n" +
                "FROM languages ORDER BY languages.name ASC limit ?", make.toArray()));
        return this;
    }

    public GetLanguage getLanguageById(String socket, int id) {
        make.add(id);
        setGet(SQL.make("SELECT languages.id\"languages.id\",\n" +
                "languages.name\"languages.name\"\n" +
                "FROM languages WHERE languages.id=? ORDER BY languages.name ASC", make.toArray()));
        return this;
    }


}

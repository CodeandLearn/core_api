package Plugin.Language.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.Language.Obj.LanguageObj;

/**
 * Created by Fabien on 06/05/2016.
 */
public class GetLanguage extends Model {
    @Override
    protected Object setData(Map result) {
        LanguageObj languageObj = new LanguageObj();
        languageObj.language.id = result.getInt("languages.id");
        languageObj.language.name = result.getString("languages.name");
        return languageObj;
    }

    public GetLanguage getLanguage(String socket) {
        setGet("SELECT * FROM languages ORDER BY languages.name ASC");
        return this;
    }

    public GetLanguage getLanguageWithLimit(String socket, int limit) {
        make.add(limit);
        setGet(SQL.make("SELECT * FROM languages ORDER BY languages.name ASC limit ?", make.toArray()));
        return this;
    }

    public GetLanguage getLanguageById(String socket, int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM languages WHERE languages.id=? ORDER BY languages.name ASC", make.toArray()));
        return this;
    }


}

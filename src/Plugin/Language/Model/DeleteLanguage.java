package Plugin.Language.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;

/**
 * Created by Fabien on 06/05/2016.
 */
public class DeleteLanguage extends Model {
    public DeleteLanguage deleteLanguage(String socket, int id) {
        make.add(id);
        setDelete(SQL.make("DELETE FROM languages WHERE id=?", make.toArray()));
        return this;
    }

    @Override
    protected Object setData(Map result) {
        return null;
    }
}

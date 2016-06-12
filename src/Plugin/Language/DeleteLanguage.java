package Plugin.Language;

import Core.Database.SQLite;
import Core.Model;
import Data.SQLDelete;

/**
 * Created by Fabien on 06/05/2016.
 */
public class DeleteLanguage extends Model {
    public DeleteLanguage(String socket, int id) {
        SQLite sql_post = new SQLite(SQLDelete.LANGUAGE + "id=" + id);
        sql_post.delete();
    }
}

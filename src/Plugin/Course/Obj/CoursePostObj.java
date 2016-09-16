package Plugin.Course.Obj;

import Plugin.Account.Obj.AccountObj;
import Plugin.Blog.Obj.LocalObj;
import Plugin.Language.Obj.LanguageObj;
import Plugin.Language.Obj.LanguagePostObj;

public class CoursePostObj {
    public int id;
    public int account_id;
    public int locales_id;
    public int language_id;
    public String title;
    public String content;
    public long create_timestamp;
    public long modify_timestamp;
    public AccountObj account = new AccountObj();
    public LocalObj local = new LocalObj();
    public LanguagePostObj language = new LanguagePostObj();
}

package Plugin.FeedBack.Obj;

import Plugin.Account.Obj.AccountObj;

/**
 * Created by Sheol on 01/12/2016.
 */
public class FeedbackIssueObj {
    public int id;
    public String title;
    public String content;
    public int account_id;
    public int feedback_label_id;
    public int feedback_category_id;
    public long timestamp;
    public boolean is_closed;
    public AccountObj account = new AccountObj();
    public FeedbackLabelObj feedback_label = new FeedbackLabelObj();
    public FeedbackCategoryObj feedback_category = new FeedbackCategoryObj();
}

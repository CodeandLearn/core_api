package Plugin.FeedBack.Obj;

import Plugin.Account.Obj.AccountObj;

/**
 * Created by Sheol on 01/12/2016.
 */
public class FeedbackIssueReplyObj {
    public int id;
    public String content;
    public int account_id;
    public int feedback_issue_id;
    public long timestamp;
    public int likes;
    public AccountObj account = new AccountObj();
    public FeedbackIssueObj feedback_issue = new FeedbackIssueObj();
}

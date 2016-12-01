package Plugin.FeedBack.Model;

import Core.Http.Map;
import Core.Model;
import Plugin.FeedBack.Obj.FeedbackIssueReplyObj;

/**
 * Created by Sheol on 01/12/2016.
 */
public class IssueReplyModel extends Model {
    @Override
    protected Object setData(Map result) {
        FeedbackIssueReplyObj feedbackIssueReplyObj = new FeedbackIssueReplyObj();
        feedbackIssueReplyObj.account_id = result.getInt("feedback_issues_reply.account_id");
        feedbackIssueReplyObj.content = result.getString("feedback_issues_reply.content");
        feedbackIssueReplyObj.feedback_issue_id = result.getInt("feedback_issues_reply.feedback_issue_id");
        feedbackIssueReplyObj.likes = result.getInt("feedback_issues_reply.likes");
        feedbackIssueReplyObj.id = result.getInt("feedback_issues_reply.id");
        feedbackIssueReplyObj.timestamp = result.getLong("feedback_issues_reply.timestamp");
        feedbackIssueReplyObj.account.username = result.getString("accounts.username");
        feedbackIssueReplyObj.feedback_issue.title = result.getString("feedback_issues.title");
        return feedbackIssueReplyObj;
    }

    public IssueReplyModel getReplies() {
        setGet("SELECT * FROM feedback_issues_reply, feedback_issues, accounts " +
                "WHERE feedback_issues_reply.feedback_issue_id=feedback_issues.id" +
                "AND feedback_issues_reply.account_id=accounts.id");
        return this;
    }
}

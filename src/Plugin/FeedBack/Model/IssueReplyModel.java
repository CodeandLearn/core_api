package Plugin.FeedBack.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.FeedBack.Obj.FeedbackIssueReplyObj;
import org.json.JSONObject;

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
                "WHERE feedback_issues_reply.feedback_issue_id=feedback_issues.id " +
                "AND feedback_issues_reply.account_id=accounts.id");
        return this;
    }

    public IssueReplyModel postReply(int account_id, JSONObject jsonObject) {
        make.add(jsonObject.getString("content"));
        make.add(account_id);
        make.add(jsonObject.getInt("feedback_issue_id"));
        make.add(getTimestamp());
        make.add(0);
        setPost(SQL.make("INSERT INTO feedback_issues_reply (content, account_id, feedback_issue_id, timestamp, likes", make.toArray()));
        return this;
    }

    public IssueReplyModel putReply(int account_id, int id, JSONObject jsonObject) {
        make.add(jsonObject.getString("content"));
        make.add(id);
        make.add(account_id);
        setPut(SQL.make("UPDATE feedback_issues_reply SET content=? WHERE id=? AND account_id=?", make.toArray()));
        return this;
    }

    public IssueReplyModel deleteReply(int account_id, int id) {
        make.add(id);
        make.add(account_id);
        setDelete(SQL.make("DELETE FROM feedback_issues_reply WHERE id=? AND account_id=?", make.toArray()));
        return this;
    }
}

package Plugin.FeedBack.Model;

import Core.Database.SQL;
import Core.Http.Map;
import Core.Model;
import Plugin.FeedBack.Obj.FeedbackIssueObj;

/**
 * Created by Sheol on 01/12/2016.
 */
public class IssueModel extends Model {
    @Override
    protected Object setData(Map result) {
        FeedbackIssueObj feedbackIssueObj = new FeedbackIssueObj();
        feedbackIssueObj.account_id = result.getInt("feedback_issues.account_id");
        feedbackIssueObj.content = result.getString("feedback_issues.content");
        feedbackIssueObj.feedback_category_id = result.getInt("feedback_issues.feedback_category_id");
        feedbackIssueObj.feedback_label_id = result.getInt("feedback_issues.feedback_label_id");
        feedbackIssueObj.id = result.getInt("feedback_issues.id");
        feedbackIssueObj.is_closed = result.getBoolean("feedback_issues.is_closed");
        feedbackIssueObj.timestamp = result.getLong("feedback_issues.timestamp");
        feedbackIssueObj.title = result.getString("feedback_issues.title");
        feedbackIssueObj.account.username = result.getString("accounts.username");
        feedbackIssueObj.feedback_label.color = result.getString("feedback_labels.color");
        feedbackIssueObj.feedback_label.id = result.getInt("feedback_labels.id");
        feedbackIssueObj.feedback_label.name = result.getString("feedback_labels.name");
        feedbackIssueObj.feedback_label.position = result.getInt("feedback_labels.position");
        feedbackIssueObj.feedback_label.power = result.getInt("feedback_labels.power");
        feedbackIssueObj.feedback_category.position = result.getInt("feedback_categories.position");
        feedbackIssueObj.feedback_category.name = result.getString("feedback_categories.name");
        feedbackIssueObj.feedback_category.id = result.getInt("feedback_categories.id");
        feedbackIssueObj.feedback_category.description = result.getString("feedback_categories.description");
        feedbackIssueObj.feedback_category.feedback_icon_id = result.getInt("feedback_categories.feedback_icon_id");
        feedbackIssueObj.feedback_category.feedback_icon.id = result.getInt("feedback_icons.id");
        feedbackIssueObj.feedback_category.feedback_icon.path = result.getString("feedback_icons.path");
        return feedbackIssueObj;
    }

    public IssueModel getIssues() {
        setGet("SELECT * FROM feedback_issues, feedback_labels, feedback_categories, feedback_icons, accounts " +
                "WHERE feedback_issues.feedback_category_id=feedback_categories.id" +
                "AND feedback_issues.feedback_label_id=feedback_labels.id" +
                "AND feedback_issues.account_id=accounts.id" +
                "AND feedback_categories.feedback_icon_id=feedback_icons.id");
        return this;
    }

    public IssueModel getIssuesById(int id) {
        make.add(id);
        setGet(SQL.make("SELECT * FROM feedback_issues, feedback_labels, feedback_categories, feedback_icons, accounts " +
                "WHERE feedback_issues.feedback_category_id=feedback_categories.id" +
                "AND feedback_issues.feedback_label_id=feedback_labels.id" +
                "AND feedback_issues.account_id=accounts.id" +
                "AND feedback_categories.feedback_icon_id=feedback_icons.id" +
                "AND feedback_issues.id=?", make.toArray()));
        return this;
    }

    public IssueModel getIssuesByCategoryId(int category_id) {
        make.add(category_id);
        setGet(SQL.make("SELECT * FROM feedback_issues, feedback_labels, feedback_categories, feedback_icons, accounts " +
                "WHERE feedback_issues.feedback_category_id=feedback_categories.id" +
                "AND feedback_issues.feedback_label_id=feedback_labels.id" +
                "AND feedback_issues.account_id=accounts.id" +
                "AND feedback_categories.feedback_icon_id=feedback_icons.id" +
                "AND feedback_categories.id=?", make.toArray()));
        return this;
    }

    public IssueModel getIssuesByLabelId(int label_id) {
        make.add(label_id);
        setGet(SQL.make("SELECT * FROM feedback_issues, feedback_labels, feedback_categories, feedback_icons, accounts " +
                "WHERE feedback_issues.feedback_category_id=feedback_categories.id" +
                "AND feedback_issues.feedback_label_id=feedback_labels.id" +
                "AND feedback_issues.account_id=accounts.id" +
                "AND feedback_categories.feedback_icon_id=feedback_icons.id" +
                "AND feedback_labels.id=?", make.toArray()));
        return this;
    }
}

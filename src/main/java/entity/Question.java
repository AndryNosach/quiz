package entity;

import java.util.List;

public class Question {

    private String issue;
    private List<Answer> listOfAnswers;

    public Question(String issue) {
        this.issue = issue;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "Question{" +
                "issue='" + issue + '\'' +
                '}';
    }
}

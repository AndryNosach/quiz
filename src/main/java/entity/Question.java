package entity;

import java.util.List;

public class Question {

    private String issue;
    private int quizId;
    private List<Answer> listOfAnswers;

    public Question(String issue, int quizId) {
        this.quizId = quizId;
        this.issue = issue;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public int getQuizId() {
        return quizId;
    }

    public void addAnswer(Answer answer){
        listOfAnswers.add(answer);
    }

    public List<Answer> getListOfAnswers() {
        return listOfAnswers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "issue='" + issue + '\'' +
                '}';
    }
}

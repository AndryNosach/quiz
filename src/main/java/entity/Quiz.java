package entity;

import java.util.List;

public class Quiz {

    private Subject subject;
    private String theme;
    private String author;
    private List<Question> listOfQuestions;

    public Quiz(Subject subject, String theme, String author) {
        this.subject = subject;
        this.theme = theme;
        this.author = author;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void addQuestion(Question question){
        listOfQuestions.add(question);
    }

    public List<Question> getListOfQuestions() {
        return listOfQuestions;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "subject=" + subject +
                ", theme='" + theme + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

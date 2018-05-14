package entity;

public class Answer {

    private String answer;
    private boolean correctness;
    private int questionId;

    public Answer(String answer, boolean correctness, int quiestionId) {
        this.answer = answer;
        this.correctness = correctness;
        this.questionId = quiestionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correctness;
    }

    public void setCorrectness(boolean correctness) {
        this.correctness = correctness;
    }

    public int getQuestionId() {
        return questionId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", correctness=" + correctness +
                '}';
    }
}

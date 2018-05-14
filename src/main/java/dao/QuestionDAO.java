package dao;

import entity.Question;

import java.util.List;

public interface QuestionDAO {

    public int addQuestion(Question question);

    public Question getQuestion(int id);

    public List<Question> getQuestionsForQuiz (int quizId);
}

package dao;

import entity.QuizTmp;

import java.util.List;

public interface QuizDAO {

    public int addQuiz(QuizTmp quiz);

    public QuizTmp getQuiz (int id);

    public List<QuizTmp> getAllQuizzies();

}

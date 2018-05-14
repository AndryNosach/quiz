package service;

import dao.QuestionDAO;
import dao.QuestionDAOImpl;
import entity.Question;

import java.util.List;

public class QuestionService {

    public int addQuestion(Question question) {
        QuestionDAO qd = new QuestionDAOImpl();
        return qd.addQuestion(question);
    }

    public Question getQuestion(int id) {
        QuestionDAO qd = new QuestionDAOImpl();
        return  qd.getQuestion(id);
    }

    public List<Question> getQuestionsForQuiz(int quizId) {
        QuestionDAO qd = new QuestionDAOImpl();
        return qd.getQuestionsForQuiz(quizId);
    }
}

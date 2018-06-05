package service;

import dao.QuestionDAO;
import entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionService {

    @Autowired
    @Qualifier("questionHibernateDao")
    QuestionDAO questionDAO;

    public int addQuestion(Question question, int quizId) {
        return questionDAO.addQuestion(question, quizId);
    }

    public Question getQuestion(int id) {
        return  questionDAO.getQuestion(id);
    }

    public List<Question> getQuestionsForQuiz(int quizId) {
        return questionDAO.getQuestionsForQuiz(quizId);
    }
}

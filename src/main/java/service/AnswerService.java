package service;

import dao.AnswerDAO;

import entity.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerService {

    @Autowired
    @Qualifier("answerHibernateDao")
    AnswerDAO answerDAO;

    public int addAnswer(Answer answer, int questId) {
        return answerDAO.addAnswer(answer, questId);
    }

    public Answer getAnswer(int id) {
        return answerDAO.getAnswer(id);
    }

    public List<Answer> getAnswersForQuestion(int questionId){
        return answerDAO.getAnswersForQuestion(questionId);
    }

}

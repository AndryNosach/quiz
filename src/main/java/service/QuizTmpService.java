package service;

import dao.QuizDAO;
import dao.QuizDAOImpl;
import entity.QuizTmp;

import java.util.List;

public class QuizTmpService {

    public int addQuiz(QuizTmp quiz){
        QuizDAO qd = new QuizDAOImpl();
        return qd.addQuiz(quiz);
    }

    public QuizTmp getQuiz (int id){
        QuizDAO qd = new QuizDAOImpl();
        return qd.getQuiz(id);
    }

    public List<QuizTmp> getAllQuizzies(){
        QuizDAO qd = new QuizDAOImpl();
        return qd.getAllQuizzies();
    }

}

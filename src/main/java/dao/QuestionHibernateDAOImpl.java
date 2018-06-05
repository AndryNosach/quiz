package dao;

import entity.Question;
import hibernate.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("questionHibernateDao")
public class QuestionHibernateDAOImpl implements QuestionDAO{

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Logger logger = Logger.getLogger(QuestionHibernateDAOImpl.class);

    //ToDo need to delete @param quizId
    @Override
    public int addQuestion(Question question, int quizId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(question);
        session.flush();
        transaction.commit();
        return question.getId();
    }

    @Override
    public Question getQuestion(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Question question = session.get(Question.class, id);
        session.flush();
        transaction.commit();
        return question;
    }

    @Override
    public List<Question> getQuestionsForQuiz(int quizId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Question");
        List<Question> questionsList = query.list();
        session.flush();
        transaction.commit();
        return questionsList;
    }
}

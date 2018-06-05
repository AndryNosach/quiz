package dao;

import entity.Answer;
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
@Qualifier("answerHibernateDao")
public class AnswerHibernateDAOImpl implements AnswerDAO {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Logger logger = Logger.getLogger(AnswerHibernateDAOImpl.class);

    @Override
    public int addAnswer(Answer answer, int questionId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(answer);
        session.flush();
        transaction.commit();
        return answer.getId();
    }

    @Override
    public Answer getAnswer(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Answer answer = session.get(Answer.class, id);
        session.flush();
        transaction.commit();
        return answer;
    }

    @Override
    public List<Answer> getAnswersForQuestion(int questionId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Answer");
        List<Answer> answersList = query.list();
        session.flush();
        transaction.commit();
        return answersList;
    }
}

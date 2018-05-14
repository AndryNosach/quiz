package dao;

import dao.connector.DBConnector;
import entity.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAOImpl implements QuestionDAO {

    @Override
    public int addQuestion(Question question) {
        Connection con = DBConnector.getConnection();
        try {
            String query = "INSERT into questions (issue, quiz_id) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, question.getIssue());
            ps.setInt(2, question.getQuizId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            return rs.getInt("LAST_INSERT_ID()");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Question getQuestion(int id) {
        Connection  conn = DBConnector.getConnection();

        try {
            String query = "SELECT issue, quiz_id FROM questions WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                return new Question(rs.getString("issue"), rs.getInt("quiz_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Question> getQuestionsForQuiz(int quizId) {

        Connection  conn = DBConnector.getConnection();
        List<Question> listOfQuestions = new ArrayList<>();

        try {
            String query = "SELECT issue FROM questions WHERE quiz_id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, quizId);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                listOfQuestions.add(new Question(rs.getString("issue"), quizId));

                while(rs.next()){
                    listOfQuestions.add(new Question(rs.getString("issue"), quizId));
                }
                return listOfQuestions;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package dao;

import dao.connector.DBConnector;
import entity.Answer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAOImpl implements AnswerDAO {

    @Override
    public int addAnswer(Answer answer) {
        Connection con = DBConnector.getConnection();
        try {
            String query = "INSERT into answers (answer, correct, question_id) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, answer.getAnswer());
            ps.setBoolean(2, answer.isCorrect());
            ps.setInt(3, answer.getQuestionId());


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
    public Answer getAnswer(int id) {
        Connection  conn = DBConnector.getConnection();

        try {
            String query = "SELECT answer, correct, question_id FROM answers WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                return new Answer(rs.getString("answer"),
                                    rs.getBoolean("correct"),
                                    rs.getInt("question_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Answer> getAnswersForQuestion(int questionId) {

        Connection  conn = DBConnector.getConnection();
        List<Answer> listOfAnswers = new ArrayList<>();

        try {
            String query = "SELECT answer, correct FROM questions WHERE question_id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, questionId);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                listOfAnswers.add(new Answer(rs.getString("answer"), rs.getBoolean("correct"), questionId));

                while(rs.next()){
                    listOfAnswers.add(new Answer(rs.getString("answer"), rs.getBoolean("correct"), questionId));
                }
                return listOfAnswers;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

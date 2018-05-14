package dao;

import dao.connector.DBConnector;
import entity.QuizTmp;
import entity.Subject;
import service.SubjectService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizDAOImpl implements QuizDAO {

    @Override
    public int addQuiz(QuizTmp quiz) {
        Connection con = DBConnector.getConnection();

        Subject subj = quiz.getSubject();
        SubjectService ss = new SubjectService();
        int subjId = ss.getIdByName(subj.getSubjectName());

        //Если в таблице subjects нет такой темы, добавляем ее
        if (subjId == -1){
            subjId = ss.addSubject(subj);
        }

        try {
            String query = "INSERT into quizzies (theme, author, subjects_id)  VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, quiz.getTheme());
            ps.setString(2, quiz.getAuthor());
            ps.setInt(3, subjId);

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
    public QuizTmp getQuiz(int id) {
        Connection  conn = DBConnector.getConnection();

        try {
            String query = "SELECT author, theme, subjects_id FROM quizzies WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                SubjectService ss = new SubjectService();
                Subject subj = ss.getSubject(rs.getInt("subjects_id"));

                return new QuizTmp(subj, rs.getString("theme"), rs.getString("author"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<QuizTmp> getAllQuizzies() {
        Connection  conn = DBConnector.getConnection();
        List<QuizTmp> listOfQuizzies = new ArrayList<>();
        SubjectService ss = new SubjectService();

        try {
            String query = "SELECT * FROM quizzies";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                Subject subj = ss.getSubject(rs.getInt("subjects_id"));
                listOfQuizzies.add(new QuizTmp(subj, rs.getString("theme"), rs.getString("author")));

                while (rs.next()){
                    subj = ss.getSubject(rs.getInt("subjects_id"));
                    listOfQuizzies.add(new QuizTmp(subj, rs.getString("theme"), rs.getString("author")));
                }

                return listOfQuizzies;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

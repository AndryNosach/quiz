package dao;

import dao.connector.DBConnector;
import entity.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO{

    @Override
    public int addSubject(Subject subject) {
        Connection con = DBConnector.getConnection();
        try {
            String query = "INSERT into SUBJECTS subject VALUES ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, subject.getSubjectName());

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
    public Subject getSubject(int id) {

        Connection  conn = DBConnector.getConnection();

        try {
            String query = "SELECT subject FROM subjects WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                return new Subject(rs.getString("subject"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getIdByName(String subjectName) {
        Connection  conn = DBConnector.getConnection();

        try {
            String query = "SELECT id FROM subjects WHERE subject= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, subjectName);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return -1;
            }
            else {
                return rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Subject> getAllSubjects() {
        Connection  conn = DBConnector.getConnection();
        List<Subject> listOfSubjects = new ArrayList<>();

        try {
            String query = "SELECT * FROM subjects";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }
            else {
                listOfSubjects.add(new Subject(rs.getString("subject")));

                while (rs.next()){
                    listOfSubjects.add(new Subject(rs.getString("subject")));
                }

                return listOfSubjects;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

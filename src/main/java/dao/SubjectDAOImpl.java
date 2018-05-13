package dao;

import entity.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectDAOImpl implements SubjectDAO{

    @Override
    public void addSubject(Subject subject) {
        Connection con = DBConnector.getConnection();
        try {
            String query = "INSERT into SUBJECTS subject VALUES ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, subject.getSubjectName());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
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
}

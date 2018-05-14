package service;

import dao.SubjectDAO;
import dao.SubjectDAOImpl;
import entity.Subject;

import java.util.List;

public class SubjectService {

    public int addSubject(Subject subject) {
        SubjectDAO sd = new SubjectDAOImpl();
        return sd.addSubject(subject);
    }

    public Subject getSubject(int id) {
        SubjectDAO sd = new SubjectDAOImpl();
        return sd.getSubject(id);
    }

    public int getIdByName(String subjectName) {
        SubjectDAO sd = new SubjectDAOImpl();
        return sd.getIdByName(subjectName);
    }

    public List<Subject> getAllSubjects() {
        SubjectDAO sd = new SubjectDAOImpl();
        return sd.getAllSubjects();
    }
}

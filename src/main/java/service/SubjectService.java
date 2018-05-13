package service;

import dao.SubjectDAO;
import dao.SubjectDAOImpl;
import entity.Subject;

public class SubjectService {

    public void addSubject(Subject subject) {
        SubjectDAO sd = new SubjectDAOImpl();
        sd.addSubject(subject);
    }

    public Subject getSubject(int id) {
        SubjectDAO sd = new SubjectDAOImpl();
        return sd.getSubject(id);
    }
}

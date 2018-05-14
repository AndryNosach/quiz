package dao;

import entity.Subject;

import java.util.List;

public interface SubjectDAO {

    public int addSubject(Subject subject);
    public Subject getSubject(int id);
    public int getIdByName(String subjectName);
    public List<Subject> getAllSubjects();
}

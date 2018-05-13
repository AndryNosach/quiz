package entity;

public class Subject {

    private String subjectName;

    public Subject(String subject_name) {
        this.subjectName = subject_name;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subject_name) {
        this.subjectName = subject_name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject_name='" + subjectName + '\'' +
                '}';
    }
}

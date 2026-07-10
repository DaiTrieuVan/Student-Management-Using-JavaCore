package repository;

import model.*;

import java.util.List;

public interface IStudentManagerRepositorySave {
    void saveAllStudent(List<Student> students);

    void saveAllClazz(List<Clazz> classes);

    void saveAllMajor(List<Major> majors);

    void saveAllSubject(List<Subject> subjects);

    void saveAllGrade(List<Grade> grades);
}

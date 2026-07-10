package repository;

import model.*;

import java.util.List;

public interface IStudentManagerRepositoryFind {

    List<Student> findAllStudent();

    List<Clazz> findAllClazz();

    List<Major> findAllMajor();

    List<Grade> findAllGrade();

    List<Subject> findAllSubject();
}

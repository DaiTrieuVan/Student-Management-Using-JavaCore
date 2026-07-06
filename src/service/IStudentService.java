package service;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void add(Student student);
    void update(Student student);
    void delete(String msv);
    List<Student> findByName(String name);
}

package controller;

import model.Student;
import service.IStudentService;
import service.StudentService;

import java.util.List;

public class StudentController {
    IStudentService studentService = new StudentService();
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }
    public void addStudents(Student student){
        studentService.add(student);
    }
    public void updateStudent (Student student){
        studentService.update(student);
    }
    public void deleteStudent(String msv){
        studentService.delete(msv);
    }
    public List<Student> findStudentsbyName(String name){
        return studentService.findByName(name);
    }
}

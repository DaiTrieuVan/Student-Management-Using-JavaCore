package service;

import model.Student;
import repository.IStudentRepository;
import repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StudentService implements IStudentService{
    private final IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void add(Student student) {
        List<Student> students = studentRepository.findAll();
        for(Student s : students){
            if(s.getMsv().equalsIgnoreCase(student.getMsv())){
                throw new IllegalArgumentException("Ma sinh vien da ton tai !!!");
            }
        }
        students.add(student);
        studentRepository.saveAll(students);
    }

    @Override
    public void update(Student student) {
        List<Student> students = studentRepository.findAll();
        boolean found = false;
        for(int i=0; i < students.size(); i++){
            if(students.get(i).getMsv().equalsIgnoreCase(student.getMsv())){
                students.set(i, student);
                found = true;
                break;
            }
        }
        if(!found){
            throw new IllegalArgumentException("Khong ton tai sinh vien co MSV: " + student.getMsv());
        }
        else studentRepository.saveAll(students);
    }

    @Override
    public void delete(String msv) {
        List<Student> students = studentRepository.findAll();
        boolean removed = students.removeIf(s->s.getMsv().equalsIgnoreCase(msv));
        if(!removed){
            throw new IllegalArgumentException("Khong ton tai sinh vien co MSV: " + msv);
        }
        else studentRepository.saveAll(students);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findAll().stream()
                .filter(s->s.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean existByMSV(String msv) {
        return studentRepository.findAll().stream()
                .anyMatch(s -> s.getMsv().equalsIgnoreCase(msv));
    }
}

package repository;

import model.*;
import utils.ToCSVMapper;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class StudentManagerSaveRepository implements IStudentManagerRepositorySave {
    final static String FILE_PATH_STUDENT = "data/DSSV.csv";
    final static String FILE_PATH_CLAZZ = "data/Clazz.csv";
    final static String FILE_PATH_GRADE = "data/Grade.csv";
    final static String FILE_PATH_MAJOR = "data/Major.csv";
    final static String FILE_PATH_SUBJECT = "data/Subject.csv";
    ToCSVMapper tcm = new ToCSVMapper();

    @Override
    public void saveAllStudent(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH_STUDENT), StandardCharsets.UTF_8))) {
            bw.write("studentId,name,gender,dob,clazzId,email,phone");
            bw.newLine();
            for (Student s : students) {
                bw.write(tcm.toStudentCSV(s));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveAllClazz(List<Clazz> classes) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH_CLAZZ), StandardCharsets.UTF_8))) {
            bw.write("classId,className,majorId");
            bw.newLine();
            for (Clazz c : classes) {
                bw.write(tcm.toClazzCSV(c));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveAllMajor(List<Major> majors) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH_MAJOR), StandardCharsets.UTF_8))) {
            bw.write("majorId,majorName");
            bw.newLine();
            for (Major m : majors) {
                bw.write(tcm.toMajorCSV(m));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveAllGrade(List<Grade> grades) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH_GRADE), StandardCharsets.UTF_8))) {
            bw.write("studentId,subjectId,processGrade,finalGrade");
            bw.newLine();
            for (Grade g : grades) {
                bw.write(tcm.toGradeCSV(g));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveAllSubject(List<Subject> subjects) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH_SUBJECT), StandardCharsets.UTF_8))) {
            bw.write("subjectId,subjectName,credits");
            bw.newLine();
            for (Subject s : subjects) {
                bw.write(tcm.toSubjectCSV(s));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

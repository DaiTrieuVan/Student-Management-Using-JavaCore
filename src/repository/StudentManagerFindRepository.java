package repository;

import model.*;
import utils.FromCSVMapper;
import utils.ToCSVMapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StudentManagerFindRepository implements IStudentManagerRepositoryFind {
    final static String FILE_PATH_STUDENT = "data/DSSV.csv";
    final static String FILE_PATH_CLAZZ = "data/Clazz.csv";
    final static String FILE_PATH_GRADE = "data/Grade.csv";
    final static String FILE_PATH_MAJOR = "data/Major.csv";
    final static String FILE_PATH_SUBJECT = "data/Subject.csv";
    FromCSVMapper fcm = new FromCSVMapper();
    ToCSVMapper tcm = new ToCSVMapper();


    @Override
    public List<Student> findAllStudent() {
        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(FILE_PATH_STUDENT), StandardCharsets.UTF_8))) {
            br.readLine(); // Bo qua dong dau tien
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Student s = fcm.fromStudentCSV(line);
                    if (s != null) {
                        students.add(s);
                    }
                } catch (Exception e) {
                    System.out.println("Loi khi doc dong du lieu CSV: \"" + line + "\". Da bo qua.");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    @Override
    public List<Clazz> findAllClazz() {
        ArrayList<Clazz> clazzes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH_CLAZZ), StandardCharsets.UTF_8))) {
            br.readLine();
            String line;
            while((line = br.readLine())!= null){
                try{
                    Clazz c = fcm.fromClazzCSV(line);
                    if(c != null){
                        clazzes.add(c);
                    }
                } catch (Exception e) {
                    System.out.println("Loi khi doc dong du lieu CSV: \"" + line + "\". Da bo qua.");
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return clazzes;
    }

    @Override
    public List<Major> findAllMajor() {
        ArrayList<Major> majors = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH_MAJOR), StandardCharsets.UTF_8))){
            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                try{
                    Major m = fcm.fromMajorCSV(line);
                    if(m != null){
                        majors.add(m);
                    }
                }catch (Exception e) {
                    System.out.println("Loi khi doc dong du lieu CSV: \"" + line + "\". Da bo qua.");

                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return majors;
    }

    @Override
    public List<Subject> findAllSubject() {
        ArrayList<Subject> subjects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH_SUBJECT), StandardCharsets.UTF_8))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Subject s = fcm.fromSubjectCSV(line);
                    if (s != null) {
                        subjects.add(s);
                    }
                } catch (Exception e) {
                    System.out.println("Loi khi doc dong du lieu CSV: \"" + line + "\". Da bo qua.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return subjects;
    }

        @Override
    public List<Grade> findAllGrade() {
        ArrayList<Grade> grades = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH_GRADE)))){
            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                try{
                    Grade g = fcm.fromGradeCSV(line);
                    if(g != null){
                        grades.add(g);
                    }
                }catch (Exception e) {
                    System.out.println("Loi khi doc dong du lieu CSV: \"" + line + "\". Da bo qua.");
                }

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return grades;
    }
}

package repository;

import model.Student;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    final static String FILE_PATH = "data/DSSV.csv";
    @Override
    public List<Student> findAll() {
        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(FILE_PATH), StandardCharsets.UTF_8))){
            br.readLine(); // Bo qua dong dau tien
            String line;
            while((line = br.readLine()) != null){
                students.add(Student.fromCSV(line));
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void saveAll(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(
                new FileOutputStream(FILE_PATH), StandardCharsets.UTF_8)))){
            bw.write("msv,name,gender,dob,major,gpa,email,phone");
            bw.newLine();
            for(Student s : students){
                bw.write(s.toCSV());
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

package view;

import controller.StudentController;
import model.Student;
import utils.InputHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CancellationException;

public class StudentView {
    StudentController studentController = new StudentController();
    java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("M/d/yyyy");
    InputHelper inputHelper = new InputHelper();

    Scanner sc = new Scanner(System.in);
    public void displayMenu(){
        while(true){
            System.out.println("==========MENU QLSV==========");
            System.out.println("1. Hien thi danh sach sinh vien");
            System.out.println("2. Them sinh vien");
            System.out.println("3. Sua thong tin sinh vien");
            System.out.println("4. Xoa sinh vien");
            System.out.println("5. Tim kiem sinh vien theo ten");
            System.out.println("6. Thoat chuong trinh");
            System.out.println("=============================");
            System.out.print("Moi nhap lua chon: ");
            try{
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice){
                    case 1:
                        displayStudent();
                        break;
                    case 2:
                        addStudent();
                        break;
                    case 3:
                        updateInforStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        findStudentbyName();
                        break;
                    default:
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void displayStudent(){
        List<Student> students = studentController.getAllStudents();
        if(students.isEmpty()){
            System.out.println("Danh sach sinh vien rong !!!");
        }
        else{
            students.forEach(System.out::println); //Method Reference: Nghia la cu moi phan tu goi system.out.print;
        }
    }
    public void addStudent(){
        try{
            List<Student> students = studentController.getAllStudents();
            Student student = new Student();

            //Nhap ma sinh vien
            String msv = inputHelper.nhapMSV();
            if(msv == null){
                return;
            }
            student.setMsv(msv);


            //Nhap ten
            String name = inputHelper.nhapTen();
            if(name == null){
                return;
            }
            student.setName(name);

            //Nhap gioi tinh
            String gender = inputHelper.nhapGioiTinh();
            if(gender == null) return;
            student.setGender(gender);

            //Nhap ngay sinh
            LocalDate dob = inputHelper.nhapDob();
            if(dob == null){
                return;
            }
            student.setDob(dob);

            System.out.print("Nhap chuyen nganh: ");
            student.setMajor(sc.nextLine());


            Double gpa = inputHelper.nhapGPA(); //Nhap GPA
            if(gpa == null){
                return;
            }
            student.setGpa(gpa);

            //Nhap Email
            String email = inputHelper.nhapEmail();
            if(email == null){
                return;
            }
            student.setEmail(email);


            //Nhap Phone
            String phone = inputHelper.nhapPhone();
            if(phone == null){
                return;
            }
            student.setPhone(phone);


            studentController.addStudents(student);
            System.out.println("Them sinh vien thanh cong !!!");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void updateInforStudent(){
        try{
            Student student = new Student();
            System.out.print("Nhap ma sinh vien: ");
            student.setMsv(sc.nextLine());
            System.out.print("Nhap ten sinh vien: ");
            student.setName(sc.nextLine());
            System.out.print("Nhap gioi tinh: ");
            student.setGender(sc.nextLine());
            System.out.print("Nhap thang/nam/sinh: ");
            student.setDob(LocalDate.parse(sc.nextLine(), formatter));
            System.out.print("Nhap chuyen nganh: ");
            student.setMajor(sc.nextLine());
            System.out.print("Nhap gpa: ");
            student.setGpa(Double.parseDouble(sc.nextLine()));
            System.out.print("Nhap email: ");
            student.setEmail(sc.nextLine());
            System.out.print("Nhap so dien thoai: ");
            student.setPhone(sc.nextLine());
            studentController.updateStudent(student);
            System.out.println("Cap nhat thong tin sinh vien thanh cong !!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteStudent(){
        try{
            System.out.print("Nhap ma sinh vien can xoa: ");
            String msv = sc.nextLine();
            studentController.deleteStudent(msv);
            System.out.println("Xoa sinh vien co msv: " + msv + " thanh cong !!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void findStudentbyName(){
        try{
            System.out.print("Nhap ten sinh vien can tim: ");
            String name = sc.nextLine();
            List<Student> students = new ArrayList<>();
            students = studentController.findStudentsbyName(name);
            if(students.isEmpty()){
                System.out.println("Khong ton tai sinh vien co ten: " + name + " !!!");
            }
            students.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package view;

import controller.StudentController;
import model.Student;
import utils.InputHelper;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UpdateStudentView2 {
    public void updateStudent() {
        InputHelper inputHelper = new InputHelper();
        StudentController studentController = new StudentController();
        Scanner sc = new Scanner(System.in);
        String msv;
        boolean check = true;
        Student student = new Student();
        try {
            while (check) {
                System.out.print("Nhap ma sinh vien can sua (q de thoat): ");
                msv = sc.nextLine().trim();
                if (msv.equalsIgnoreCase("q") || msv.isEmpty()) {
                    return;
                }
                try {
                    if (!(studentController.existByMSV(msv))) {
                        throw new IllegalArgumentException("Ma sinh vien khong ton tai !!!");
                    }
                    check = false;
                    List<Student> students = studentController.getAllStudents();
                    for (Student stu : students) {
                        if (stu.getMsv().equalsIgnoreCase(msv)) {
                            student = stu;
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            //Nhap msv
            while (true) {
                try {
                    String msvtemp = student.getMsv();
                    msv = inputHelper.nhapMSV(msvtemp);
                    if (msv == null) return;
                    if (!(msv.isEmpty()) && !msv.equals(msvtemp)) {
                        if ((studentController.existByMSV(msv))) {
                            throw new IllegalArgumentException("Ma sinh vien da ton tai !!!");
                        }
                    }
                    student.setMsv(msv);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            //Nhap ten
            while (true) {
                try {
                    String name = inputHelper.nhapTen(student.getName());
                    if (name == null) return;
                    student.setName(name);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            //Nhap gioi tinh
            String gender = inputHelper.nhapGioiTinh(student.getGender());
            if (gender == null) return;
            student.setGender(gender);
            //Nhap ngay sinh
            LocalDate dob = inputHelper.nhapDob(student.getDob());
            if (dob == null) return;
            student.setDob(dob);
            //Nhap chuyen nganh
            String major = inputHelper.nhapMajor(student.getMajor());
            if (major == null) return;
            student.setMajor(major);
            //Nhap gpa
            Double gpa = inputHelper.nhapGPA(student.getGpa());
            if (gpa == null) return;
            student.setGpa(gpa);
            //Nhap email
            String email = inputHelper.nhapEmail(student.getEmail());
            if (email == null) return;
            student.setEmail(email);
            //Nhap phone
            String phone = inputHelper.nhapPhone(student.getPhone());
            if (phone == null) return;
            student.setPhone(phone);
            studentController.updateStudent(student);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

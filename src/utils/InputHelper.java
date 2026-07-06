package utils;

import controller.StudentController;
import model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class InputHelper {
    final StudentController studentController = new StudentController();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    final Scanner sc = new Scanner(System.in);
    Validator validator = new Validator();

    public String nhapMSV(){
        String msv = "";
        boolean check = true;
        while(check){
            try{
                System.out.print("Nhap ma sinh vien (nhap q de thoat): ");
                msv = sc.nextLine();
                if(Objects.equals(msv, "q")){
                    return null;
                }
                List<Student> students = studentController.getAllStudents();
                for(Student s:students){
                    if((s.getMsv().equalsIgnoreCase(msv))) throw  new IllegalArgumentException("Ma sinh vien da ton tai !!!");
                    if(!(validator.checkMSV(msv))) throw new IllegalArgumentException("Ma sinh vien sai dinh dang, VD: SV001... !!!");
                }
                check = false;


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return msv;
    }

    public String nhapTen(){
        String name = "";
        boolean check = true;
        while (check){
            try{
                System.out.print("Nhap ten (nhap q de thoat): ");
                name = sc.nextLine();
                if(Objects.equals(name, "q")) return null;
                if(validator.checkName(name)){
                    throw new IllegalArgumentException("Ten khong hop le !!!");
                }
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }

    public String nhapGioiTinh(){
        String gender = "";
        boolean check = true;
        while(check){
            try {
                System.out.println("1. Nam");
                System.out.println("2. Nu");
                System.out.println("else: Unk");
                System.out.print("Nhap gioi tinh (nhap q de thoat): ");
                String choice = sc.nextLine();
                if(choice.equals("q")) return null;
                switch (choice){
                    case "1" :gender = "Nam";
                    case "2" :gender = "Nu";
                    default: gender = "Unk";
                }
                check = false;
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }

        }
        return gender;
    }

    public LocalDate nhapDob(){
        Scanner sc = new Scanner(System.in);
        String dob = "";
        LocalDate dob1 = null;
        boolean check = true;
        while(check){
            try{
                System.out.print("Nhap thang/nam/sinh (nhap q de thoat): ");
                dob = sc.nextLine();
                if(Objects.equals(dob, "q")){
                    return null;
                }
                dob1 = LocalDate.parse(dob, formatter);
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return dob1;
    }
    public Double nhapGPA(){
        boolean check = true;
        double gpa = 0.0;
            while(check) {
                try {
                    System.out.print("Nhap GPA (nhap q de thoat): ");
                    gpa = Double.parseDouble(sc.nextLine());
                    if(String.valueOf(gpa).equals("q")){
                        return null;
                    }
                    if (gpa < 0 || gpa > 4) {
                        throw new IllegalArgumentException("GPA khong the nho hon 0 va lon hon 4 !!!");
                    }
                    check = false;
                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
            }
        return gpa;
    }
    public String nhapEmail(){
        boolean check = true;
        String email = "";
        while (check){
            try{
                System.out.print("Nhap email (nhap q de thoat): ");
                email = sc.nextLine();
                if(Objects.equals(email, "q")){
                    return null;
                }
                if(!(validator.checkEmail(email))){
                    throw new IllegalArgumentException("Email khong dung dinh dang !!!");
                }
                check = false;
            } catch (Exception e) {
                System.out.println("Email khong dung dinh dang !!!");
            }

        }
        return email;
    }
    public String nhapPhone(){
        boolean check = true;
        String phone = "";
        while(check) {
            try{
                System.out.print("Nhap so dien thoai (nhap q de thoat): ");
                phone = sc.nextLine();
                if(Objects.equals(phone, "q")){
                    return null;
                }
                if (!(validator.checkPhone(phone))) {
                    throw new IllegalArgumentException("So dien thoai bat dau bang so 0 va co 10 chu so !!!");
                }
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return phone;
    }

}

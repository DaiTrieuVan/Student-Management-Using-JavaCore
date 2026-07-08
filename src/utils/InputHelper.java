package utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class InputHelper {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    final Scanner sc = new Scanner(System.in);
    Validator validator = new Validator();

    public String nhapMSV(String oldMsv) {
        String msv = "";
        boolean check = true;
        if (oldMsv == null || oldMsv.isEmpty()) {
            System.out.print("Nhap ma sinh vien (nhap q de thoat): ");
        } else {
            System.out.print("Nhap ma sinh vien moi (Enter de giu nguyen [" + oldMsv + "], q de thoat: ");
        }
        while (check) {
            try {
                msv = sc.nextLine();
                if (Objects.equals(msv, "q")) {
                    return null;
                } else if (msv.isEmpty()) return oldMsv;
                if (!(validator.checkMSV(msv))) {
                    throw new IllegalArgumentException("Ma sinh vien khong hop le !!!");
                }
                check = false;


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return msv;
    }

    public String nhapTen(String oldName) {
        String name = "";
        boolean check = true;
        while (check) {
            try {
                if (oldName == null || oldName.isEmpty()) {
                    System.out.print("Nhap ten sinh vien (nhap q de thoat): ");
                } else {
                    System.out.print("Nhap ten sinh vien moi (Enter de giu nguyen [" + oldName + "], q de thoat: ");
                }
                name = sc.nextLine();
                if (Objects.equals(name, "q")) return null;
                else if (name.isEmpty()) {
                    return oldName;
                }
                if (!(validator.checkName(name))) {
                    throw new IllegalArgumentException("Ten khong hop le !!!");
                }
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }

    public String nhapGioiTinh(String oldGender) {
        boolean check = true;
        String gender = "";
        while (check) {
            try {
                if (!(oldGender == null || oldGender.isEmpty())) {
                    System.out.println("1. Nam");
                    System.out.println("2. Nu");
                    System.out.println("else: Unk");
                    System.out.print("Nhap gioi tinh moi (Enter de giu nguyen [" + oldGender + "], q de thoat: ");

                } else {
                    System.out.println("1. Nam");
                    System.out.println("2. Nu");
                    System.out.println("else: Unk");
                    System.out.print("Nhap gioi tinh (nhap q de thoat): ");
                }
                String choice = sc.nextLine();
                if (choice.equals("q")) return null;
                else if (choice.isEmpty()) {
                    return oldGender;
                }
                gender = switch (choice) {
                    case "1" -> "Nam";
                    case "2" -> "Nu";
                    default -> "Unk";
                };
                check = false;
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }

        }
        return gender;
    }

    public LocalDate nhapDob(LocalDate oldDob) {
        String dob;
        LocalDate dob1 = null;
        boolean check = true;
        while (check) {
            try {
                if (oldDob == null) {
                    System.out.print("Nhap thang/ngay/nam sinh (nhap q de thoat): ");
                } else {
                    System.out.print("Nhap thang/ngay/nam sinh moi (Enter de giu nguyen [" + oldDob + "], q de thoat: ");
                }
                dob = sc.nextLine();
                if (Objects.equals(dob, "q")) {
                    return null;
                } else if (dob.isEmpty()) {
                    return oldDob;
                }
                dob1 = LocalDate.parse(dob, formatter);
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return dob1;
    }

    public Double nhapGPA(Double oldGpa) {
        boolean check = true;
        double gpa = 0.0;
        String tmp;
        while (check) {
            try {
                if (oldGpa != null) {
                    System.out.print("Nhap gpa moi (Enter de giu nguyen [" + oldGpa + "], q de thoat: ");
                } else {
                    System.out.print("Nhap gpa (nhap q de thoat): ");
                }

                tmp = sc.nextLine();
                if (String.valueOf(tmp).equals("q")) {
                    return null;
                } else if (tmp.isEmpty()) {
                    return oldGpa;
                }
                gpa = Double.parseDouble(tmp);
                if (gpa < 0 || gpa > 4) {
                    throw new IllegalArgumentException("Gpa khong the nho hon 0 va lon hon 4 !!!");
                }
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return gpa;
    }

    public String nhapEmail(String oldEmail) {
        boolean check = true;
        String email = "";
        while (check) {
            try {
                if (!(oldEmail == null || oldEmail.isEmpty())) {
                    System.out.print("Nhap emai moi (Enter de giu nguyen [" + oldEmail + "], q de thoat: ");
                } else {
                    System.out.print("Nhap email (nhap q de thoat): ");
                }
                email = sc.nextLine();
                if (Objects.equals(email, "q")) {
                    return null;
                } else if (email.isEmpty()) {
                    return oldEmail;
                }
                if (!(validator.checkEmail(email))) {
                    throw new IllegalArgumentException("Email khong dung dinh dang !!!");
                }
                check = false;
            } catch (Exception e) {
                System.out.println("Email khong dung dinh dang !!!");
            }

        }
        return email;
    }

    public String nhapPhone(String oldPhone) {
        boolean check = true;
        String phone = "";
        while (check) {
            try {
                if (!(oldPhone == null || oldPhone.isEmpty())) {
                    System.out.print("Nhap so dien thoai moi (Enter de giu nguyen [" + oldPhone + "], q de thoat: ");
                } else {
                    System.out.print("Nhap so dien thoai (nhap q de thoat): ");
                }
                phone = sc.nextLine();
                if (Objects.equals(phone, "q")) {
                    return null;
                } else if (phone.isEmpty()) {
                    return oldPhone;
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

    public String nhapMajor(String oldMajor) {
        boolean check = true;
        String major = "";
        while (check) {
            try {
                if (!(oldMajor == null || oldMajor.isEmpty())) {
                    System.out.print("Nhap chuyen nganh moi (Enter de giu nguyen [" + oldMajor + "], q de thoat: ");
                } else {
                    System.out.print("Nhap chuyen nganh (q de thoat): ");
                }
                major = sc.nextLine();
                if (Objects.equals(major, "q")) {
                    return null;
                } else if (major.isEmpty()) {
                    return oldMajor;
                }
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return major;
    }

}

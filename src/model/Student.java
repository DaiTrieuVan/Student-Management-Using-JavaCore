package model;

import java.time.LocalDate;

public class Student {
    private String msv;
    private String name;
    private String gender;
    private LocalDate dob;
    private String major;
    private Double gpa;
    private String email;
    private String phone;

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "msv='" + msv + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", major='" + major + '\'' +
                ", gpa=" + gpa +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    public static Student fromCSV(String csvLine){
        String[] parts = csvLine.split(",");
        if(parts.length < 8){
            return null;
        }
        Student student = new Student();
        student.setMsv(parts[0].trim());
        student.setName(parts[1].trim());
        student.setGender(parts[2].trim());
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("M/d/yyyy");
        student.setDob(LocalDate.parse(parts[3].trim(), formatter));
        student.setMajor(parts[4].trim());
        student.setGpa(Double.parseDouble(parts[5].trim()));
        student.setEmail(parts[6].trim());
        student.setPhone(parts[7].trim());
        return student;
    }
    public String toCSV(){
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("M/d/yyyy");
        return String.join(",",
                msv != null ? msv : "",
                name != null ? name : "",
                gender != null ? gender : "",
                dob != null ? dob.format(formatter) : "",
                major != null ? major : "",
                gpa != null ? String.valueOf(gpa) : "",
                email != null ? email : "",
                phone != null ? phone : ""
        );

    }
}

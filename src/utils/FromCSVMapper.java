package utils;

import model.*;

import java.time.LocalDate;

public class FromCSVMapper {

    public Student fromStudentCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length < 8) {
            return null;
        }
        Student student = new Student();
        student.setStudentId(parts[0].trim());
        student.setName(parts[1].trim());
        student.setGender(parts[2].trim());
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("M/d/yyyy");
        student.setDob(LocalDate.parse(parts[3].trim(), formatter));
        student.setEmail(parts[6].trim());
        student.setPhone(parts[7].trim());
        return student;
    }

    public Major fromMajorCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length < 2) {
            return null;
        }
        Major major = new Major("", "");
        major.setMajorId(parts[0].trim());
        major.setMajorName(parts[1].trim());
        return major;
    }

    public Clazz fromClazzCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length < 3) {
            return null;
        }
        Clazz clazz = new Clazz("", "", "");
        clazz.setClazzId(parts[0].trim());
        clazz.setClazzName(parts[1].trim());
        clazz.setMajorId(parts[2].trim());
        return clazz;
    }

    public Subject fromSubjectCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length < 3) return null;
        Subject subject = new Subject("", "", 0);
        subject.setSubjectId(parts[0].trim());
        subject.setSubjectName(parts[1].trim());
        subject.setCredits(Integer.parseInt(parts[2].trim()));
        return subject;
    }

    public Grade fromGradeCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length < 4) return null;
        Grade grade = new Grade("", "", 0.0, 0.0);
        grade.setSubjectId(parts[0].trim());
        grade.setStudentId(parts[1].trim());
        grade.setProcessGrade(Double.parseDouble(parts[2].trim()));
        grade.setExamGrade(Double.parseDouble(parts[3].trim()));
        return grade;
    }

}

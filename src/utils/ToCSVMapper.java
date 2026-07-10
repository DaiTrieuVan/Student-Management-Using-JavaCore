package utils;

import model.*;

public class ToCSVMapper {

    java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("M/d/yyyy");


    public String toStudentCSV(Student student) {
        return String.join(",",
                student.getStudentId() != null ? student.getStudentId() : "",
                student.getName() != null ? student.getName() : "",
                student.getGender() != null ? student.getGender() : "",
                student.getDob() != null ? student.getDob().format(formatter) : "",
                student.getEmail() != null ? student.getEmail() : "",
                student.getPhone() != null ? student.getPhone() : ""
        );

    }

    public String toMajorCSV(Major major) {
        return String.join(",",
                major.getMajorId() != null ? major.getMajorId() : "",
                major.getMajorName() != null ? major.getMajorName() : "");
    }

    public String toClazzCSV(Clazz clazz) {
        return String.join(",",
                clazz.getClazzId() != null ? clazz.getClazzId() : "",
                clazz.getClazzName() != null ? clazz.getClazzName() : "",
                clazz.getMajorId() != null ? clazz.getMajorId() : ""
        );
    }

    public String toSubjectCSV(Subject subject) {
        return String.join(",",
                subject.getSubjectId() != null ? subject.getSubjectId() : "",
                subject.getSubjectName() != null ? subject.getSubjectName() : "",
                String.valueOf(subject.getCredits()));
    }

    public String toGradeCSV(Grade grade) {
        return String.join(",",
                grade.getSubjectId() != null ? grade.getSubjectId() : "",
                grade.getStudentId() != null ? grade.getStudentId() : "",
                String.valueOf(grade.getExamGrade()),
                String.valueOf(grade.getProcessGrade())
        );
    }
}

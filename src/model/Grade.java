package model;

public class Grade {
    private String studentId;
    private String subjectId;
    private double processGrade;
    private double examGrade;

    public Grade(String studentId, String subjectId, double processGrade, double examGrade) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.processGrade = processGrade;
        this.examGrade = examGrade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public double getProcessGrade() {
        return processGrade;
    }

    public void setProcessGrade(double processGrade) {
        this.processGrade = processGrade;
    }

    public double getExamGrade() {
        return examGrade;
    }

    public void setExamGrade(double examGrade) {
        this.examGrade = examGrade;
    }
}

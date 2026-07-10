package model;

public class Clazz {
    private String clazzId;
    private String clazzName;
    private String majorId;

    public Clazz(String clazzId, String clazzName, String majorId) {
        this.clazzId = clazzId;
        this.clazzName = clazzName;
        this.majorId = majorId;
    }

    public String getClazzId() {
        return clazzId;
    }

    public void setClazzId(String clazzId) {
        this.clazzId = clazzId;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }
}

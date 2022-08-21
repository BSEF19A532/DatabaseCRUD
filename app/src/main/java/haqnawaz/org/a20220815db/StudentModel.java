package haqnawaz.org.a20220815db;

import java.io.Serializable;

public class StudentModel implements Serializable {
    private String name;
    private int rollNmber;
    private int oldRollNumber;
    private boolean isEnroll;

    @Override
    public String toString() {
        return "StudentModel{" +
                "name='" + name + '\'' +
                ", rollNmber=" + rollNmber +
                ", isEnroll=" + isEnroll +
                '}';
    }

    public StudentModel(String name, int rollNmber, boolean isEnroll) {
        this.name = name;
        this.rollNmber = rollNmber;
        this.isEnroll = isEnroll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNmber;
    }

    public void setRollNmber(int rollNmber) {
        this.rollNmber = rollNmber;
    }

    public boolean isEnroll() {
        return isEnroll;
    }

    public void setEnroll(boolean enroll) {
        isEnroll = enroll;
    }

    public int getOldRollNumber() {
        return oldRollNumber;
    }

    public void setOldRollNumber(int oldRollNumber) {
        this.oldRollNumber = oldRollNumber;
    }
}

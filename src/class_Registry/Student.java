package class_Registry;

import java.util.Calendar;

public class Student extends Person{
    private String course;
    private int startYear;


    public Student(String name, String surname, int dayOfBirth, int monthOfBirth, int yearOfBirth, String course, int startYear) {
        super(name, surname, dayOfBirth, monthOfBirth, yearOfBirth);
        this.course = course;
        this.startYear = startYear;
    }

    public String getCourse() {
        return course;
    }

    public int getSemesterCount() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return ((currentYear - startYear)*2);
    }

    public String getDescription(){
        return (super.getDescription() + ", Studiengang: " + course);
    }

    public void setCourse(String course) {
        this.course = course;
    }
}

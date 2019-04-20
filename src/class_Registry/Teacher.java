package class_Registry;

import java.util.Calendar;

public class Teacher extends Person {
    private int startYear, weeklyHours;


    public Teacher(String name, String surname, int dayOfBirth, int monthOfBirth, int yearOfBirth, int startYear, int weeklyHours) {
        super(name, surname, dayOfBirth,monthOfBirth, yearOfBirth);
        this.startYear = startYear;
        this.weeklyHours = weeklyHours;
    }

    public int getSemesterCount() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return ((currentYear - startYear)*2);
    }

    public String getDescription(){
        return (super.getDescription() + ", Wochenstunden: " + weeklyHours);
    }

    public int getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }
}

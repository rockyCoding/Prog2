package class_Registry;

import java.util.Calendar;

public class Person {
    private String name, surname;
    private int dayOfBirth, monthOfBirth, yearOfBirth;


    public Person(String name, String surname, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return (currentYear - yearOfBirth);
    }

    public String getDateOfBirth() {
        return (dayOfBirth + "." + monthOfBirth + "." + yearOfBirth);
    }

    public String getDescription(){
        return (name + ", " + surname + " (" + getAge() + ")");
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}

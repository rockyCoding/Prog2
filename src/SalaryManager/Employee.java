package SalaryManager;

public class Employee {
    private int id, hoursSet;
    private String name, surname;
    private double baseSalary, weeklyHours;

    public Employee(int id, String name, String surname, double baseSalary, double weeklyHours) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.baseSalary = baseSalary;
        this.weeklyHours = weeklyHours;
        this.hoursSet = 0;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return (name+", "+surname);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getWeeklyHours() {
        return weeklyHours;
    }

    public int getHoursSet() {
        return hoursSet;
    }

    public void setHoursSet(int hoursSet) {
        this.hoursSet = hoursSet;
    }
}

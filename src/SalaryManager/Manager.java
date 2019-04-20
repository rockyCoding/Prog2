package SalaryManager;

public class Manager extends Employee{
    private double totalHours, baseHours, overtime;
    private String status;

    public Manager(int id, String name, String surname, double baseSalary, double weeklyHours) {
        super(id, name, surname, baseSalary, weeklyHours);
        status = "Manager";
    }

    public double getTotalHours() {
        return totalHours;
    }

    public double getBaseHours() {
        return baseHours;
    }

    public double getOvertime() {
        return overtime;
    }

    public double getSalary(){
        if (totalHours > super.getWeeklyHours()) {
            return (super.getBaseSalary() + (overtime / super.getWeeklyHours()) * (super.getBaseSalary() * 0.5));
        }
        else {
            return (super.getBaseSalary() + 50);
        }
    }

    public void setTotalHours(double totalHours) {
        super.setHoursSet(1);
        this.totalHours = totalHours;
        if (totalHours > super.getWeeklyHours()) {
            this.baseHours = super.getWeeklyHours();
            this.overtime = totalHours - baseHours;
        }
        else {
            this.baseHours = totalHours;
            this.overtime = totalHours - baseHours;
        }
    }
}

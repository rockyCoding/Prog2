package SalaryManager;

public class Fixed extends Employee{
    private double totalHours, baseHours, overtime;
    private String status;

    public Fixed(int id, String name, String surname, double baseSalary, double weeklyHours) {
        super(id, name, surname, baseSalary, weeklyHours);
        status = "Fixed";
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
        return super.getBaseSalary();
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

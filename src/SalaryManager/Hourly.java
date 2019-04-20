package SalaryManager;

public class Hourly extends Employee{
    private double totalHours, baseHours, overtime;
    private String status;

    public Hourly(int id, String name, String surname, double baseSalary, double weeklyHours) {
        super(id, name, surname, baseSalary, weeklyHours);
        status = "Hourly";
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
            return (baseHours * super.getBaseSalary() + overtime * 1.5 * super.getBaseSalary());
        }
        else{
            return (totalHours*super.getBaseSalary());
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

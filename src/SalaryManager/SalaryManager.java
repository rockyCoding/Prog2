package SalaryManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalaryManager {
    static List<Employee> employees = new ArrayList<>();

    static double printEmployee(Employee employee){
        if (employee instanceof Hourly) {
            Hourly hourly = (Hourly) employee;
            System.out.println("---------------------------------------------------------------");
            System.out.println("ID: " + hourly.getId() + ", Name: " + hourly.getFullName());
            System.out.println("Geleistete Stunden: " + hourly.getTotalHours() + " von "+ hourly.getWeeklyHours() +"Sollstunden.");
            System.out.println("Überstunden: " + hourly.getOvertime());
            System.out.println("Zu zahlender Lohn: " + hourly.getSalary());
            return hourly.getSalary();
        }
        else if (employee instanceof Fixed){
            Fixed fixed = (Fixed) employee;
            System.out.println("---------------------------------------------------------------");
            System.out.println("ID: " + fixed.getId() + ", Name: " + fixed.getFullName());
            System.out.println("Geleistete Stunden: " + fixed.getTotalHours() + " von "+ fixed.getWeeklyHours() +"Sollstunden.");
            System.out.println("Überstunden: " + fixed.getOvertime());
            System.out.println("Zu zahlender Lohn: " + fixed.getSalary());
            return fixed.getSalary();
        }
        else {
            Manager manager = (Manager) employee;
            System.out.println("---------------------------------------------------------------");
            System.out.println("ID: " + manager.getId() + ", Name: " + manager.getFullName());
            System.out.println("Geleistete Stunden: " + manager.getTotalHours() + " von "+ manager.getWeeklyHours() +"Sollstunden.");
            System.out.println("Überstunden: " + manager.getOvertime());
            System.out.println("Zu zahlender Lohn: " + manager.getSalary());
            return manager.getSalary();
        }
    }

    static void setHours(Employee employee, double totalHours){
        if (employee instanceof Hourly) {
            Hourly hourly = (Hourly) employee;
            hourly.setTotalHours(totalHours);
        }
        else if (employee instanceof Fixed){
            Fixed fixed = (Fixed) employee;
            fixed.setTotalHours(totalHours);
        }
        else {
            Manager manager = (Manager) employee;
            manager.setTotalHours(totalHours);
        }
    }

    public static void main(String[] args) {
        boolean end = false, correct;
        Scanner scanner = new Scanner(System.in);
        String input;
        Double salarySum = (double) 0;

        Manager manager1 = new Manager(1, "Cheffchen", "Hans", 3000, 45);
        Manager manager2 = new Manager(2, "Hand", "Rechte", 2250, 42);
        Fixed fixed1 = new Fixed(3, "Angestellter", "Bester", 2000, 36);
        Fixed fixed2 = new Fixed(4, "Neue", "Der", 1250, 40);
        Hourly hourly1 = new Hourly(5, "Faulenzer", "Profi", 31.25, 32);
        Hourly hourly2 = new Hourly(6, "Arbeitstier", "Das", 35, 40);
        Hourly hourly3 = new Hourly(7, "Nutz", "Nichts", 28, 20);

        employees.add(manager1);
        employees.add(manager2);
        employees.add(fixed1);
        employees.add(fixed2);
        employees.add(hourly1);
        employees.add(hourly2);
        employees.add(hourly3);


        System.out.println("Willkommen in der Lohnverwaltung.");
        System.out.println("Mit \"in\" starten Sie die Eingabe der Wochenstunden");
        System.out.println("Mit \"out\" lassen Sie Sich die einzelnen Löhne und die gesamte Lohnsumme ausgeben");
        System.out.println("Mit \"end\" beenden Sie das Programm");
        do{
            System.out.println("Was wollen Sie tun? Stunden eingeben, Lohnauszug ansehen oder Beenden?");
            input = scanner.nextLine();
            if (input.equals("in")){
                input = null;
                System.out.println("Geben Sie die geleisteten Wochenstunden ein für:");
                for (Employee employee: employees) {
                    correct = false;
                    System.out.println("ID: " + employee.getId() + ", Name: " + employee.getFullName() + " >");
                    while (!correct) {
                        input = scanner.nextLine();
                        try {
                            setHours(employee, Double.parseDouble(input));
                            correct = true;
                        }catch (Exception e){
                            System.out.println("Eingabe konnte nicht gelesen werden, versuchen Sie es erneut.");
                        }
                    }
                }
                System.out.println("Erledigt, vielen Dank.");
            }
            else if (input.equals("out")){
                for (Employee employee: employees) {
                    if (employee.getHoursSet() == 1) {
                        salarySum += printEmployee(employee);
                    }
                    else{
                        System.out.println("Für diesen Mitarbeiter wurde noch keine Arbeitszeit eingegeben: ID "+ employee.getId()+ ", Name: " + employee.getFullName());
                        salarySum = (double) 0;
                        return;
                    }
                }
                if (salarySum > 0) {
                    System.out.println("---------------------------------------------------------------");
                    System.out.println("Totale Lohnsumme der letzten Woche: " + salarySum);
                }
            }
            else if (input.equals("end")){
                end = true;
            }
            else{
                System.out.println("Eingabe konnte nicht gelesen werden, versuchen Sie es erneut.");
            }

        }while (!end);
    }
}

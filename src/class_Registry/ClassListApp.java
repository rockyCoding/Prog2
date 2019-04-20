package class_Registry;

import java.util.ArrayList;
import java.util.List;

public class ClassListApp {
    public static void main(String[] args) {
        Student student1 = new Student("Meier", "Hans", 15, 04, 1995, "LST", 2015);
        Student student2 = new Student("Müller", "Fritz", 01, 12, 1992, "MLS", 2017);
        Teacher teacher = new Teacher("Testenheim", "Testorius", 03, 10, 1968, 2000, 36);

        List<Person> memberList = new ArrayList<>();
        memberList.add(student1);
        memberList.add(student2);
        memberList.add(teacher);

        for (Person person : memberList){
            System.out.println(person.getDescription());

            if (person instanceof Student){
                Student student = (Student) person;
                System.out.println("Semester studiert: " + student.getSemesterCount());

            }
        }
    }
}

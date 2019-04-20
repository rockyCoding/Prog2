import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class recapArrays {

    //reading grades from user input, creating list, ending on 0
    public static  ArrayList<Float> gradeList(){
        ArrayList<Float> grades = new ArrayList<Float>();
        Scanner reader = new Scanner(System.in);
        float input;
        boolean end = false;
        while (!end){
            input = reader.nextFloat();
            if (input != 0){
                grades.add(input);
            }
            else end = true;
        }
        return grades;
    }

    public static void main(String[] args) {
        System.out.println(" Geben Sie nacheinander die Noten ein. Bestätigen Sie mit Enter." +
                "Beenden der Eingabe erfolgt mit der Eingabe einer 0.");
        ArrayList<Float> grades_list = gradeList();
        Collections.sort(grades_list);                                                    // sorts grades_list ascending
        grades_list.remove(0);
        System.out.println("Diese Noten werden für den Schnitt berücksichtigt: " + grades_list);
        float sum = 0;
        for (int i=0; i <= (grades_list.size()-1); i++){
            sum += grades_list.get(i);
        }
        float average = sum / grades_list.size();
        System.out.println("Der Schnitt der eingegebenen Noten ist: " + average);
    }


}


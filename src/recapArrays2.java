import java.util.Arrays;

public class recapArrays2 {

    public static void main(String[] args) {

        double[] grades = {3, 4.5, 6, 5, 3, 2.5, 5,5, 5};
        double sum = 0;

        Arrays.sort(grades);

        for (int i=1; i < grades.length; i++){
            sum += grades[i];
        }

        double average = sum / (grades.length - 1);
        System.out.println("The average is: " + average);
    }
}

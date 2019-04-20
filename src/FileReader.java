import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) {

        File studentFile = new File("students.csv");

        try {

            Scanner fileScanner = new Scanner(studentFile);

            int counter = 0;

            while (fileScanner.hasNext()){
                counter++;
            }

            String[][] data = new String[counter][3];
            counter = 0;

            while (fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                String[] partials = line.split(";");
                for (int i = 0; i < partials.length; i++){
                    data[counter][i] = partials[i];
                }
                counter++;
            }


        } catch (FileNotFoundException e){

            System.out.println("Error: File not found.");

        }





    }
}

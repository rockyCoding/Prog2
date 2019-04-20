/*package personLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SuboptimalPersonLoader {
    public Person loadPerson(String fileName) {

        Scanner testScanner = null;
        try {
            testScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            return null;
        }

        if (fileName.startsWith("c_")) {
            String firstName = testScanner.next();
            String lastName = testScanner.next();
            String birthDate = testScanner.next();

            return new Person(firstName+" "+lastName, birthDate);
        } else if (fileName.startsWith("l_")) {
            String firstName = testScanner.nextLine().split(" ")[1];
            String lastName = testScanner.nextLine().split(" ")[1];
            String year = testScanner.nextLine().split(" ")[1];
            String month = testScanner.nextLine().split(" ")[1];
            String day = testScanner.nextLine().split(" ")[1];

            return new Person(firstName+" "+lastName, month+"/"+day+"/"+year);
        } else {
            return null;
        }

    }
}
*/
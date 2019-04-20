package personLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CompactPersonLoader implements PersonLoader {
    public Person loadPerson(String fileName) {
        Scanner testScanner = null;
        try {
            testScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            return null;
        }

        String firstName = testScanner.next();
        String lastName = testScanner.next();
        String birthDate = testScanner.next();

        return new Person(firstName+" "+lastName, birthDate);
    }
}

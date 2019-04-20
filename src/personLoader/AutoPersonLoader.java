package personLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AutoPersonLoader implements PersonLoader {

    public Person loadPerson(String fileName) {
        PersonLoader loader = null;
        Scanner testScanner = null;
        try {
            testScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            return null;
        }

        if (testScanner.nextLine().startsWith("Vorname")){
            loader = new LongPersonLoader();
            return loader.loadPerson(fileName);
        }
        else {
            loader = new CompactPersonLoader();
            return loader.loadPerson(fileName);
        }
    }
}
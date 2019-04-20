package personLoader;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class LoadTester {

    public static void main(String[] args) {

        // Read file names from the command line, and decide which
        // concrete class to use to load the file depending on the
        // beginning of the file name.
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Path to files: ");
        String path = inputScanner.nextLine();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();


        while (true) {

            System.out.println("---- List of files in directory ----");
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }

            // Read the file name
            System.out.println("\nFile name: ");
            String inputLine = path + "\\" + inputScanner.nextLine();

            // Define a variable that holds the loader.
            // Only the interface type PersonLoader is used here,
            // because we do not want and need to know which concrete
            // implementation is used.
            PersonLoader loader = null;

            // Decide which concrete loader to use.
            if (inputLine.startsWith("c_")) {
                loader = new CompactPersonLoader();
            } else if (inputLine.startsWith("l_")) {
                loader = new LongPersonLoader();
            } else {
                loader = new AutoPersonLoader();
            }

            // From here on, all operations are generic.
            // They only work on the PersonLoader type.
            // We do not need to know the concrete implementing class,
            // since we know that it fulfills the contract of the interface.
            // Therefore we can operate on the interface type instead.
            if (loader != null) {
                Person person = loader.loadPerson(inputLine);

                if (person != null) {
                    System.out.println(person);
                } else {
                    System.out.println("Unable to read person from file.");
                }
            }

        }

    }
}

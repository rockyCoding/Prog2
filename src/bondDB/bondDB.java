package bondDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class bondDB {

    public static HashMap<Integer, bonds> bondDB = new HashMap<>();            //HashMap to save bondDB.bonds-objects


    // Bond parser to translate "|||" into triple etc.
    static String bondParser(String parseMe){
        int counter = 0;

        List<Character> letters = new ArrayList<>();

        for (int i = 0; i < parseMe.length(); i++){
            letters.add(parseMe.charAt(i));
        }

        for (int i = 0; i < letters.size(); i++){
            if (letters.get(i).equals('|')){
                counter++;
            }
        }
        if (counter == 1) return "single bond";
        else if (counter == 2) return "double bond";
        else return "triple bond";
    }

    // command to fill DB(hash map) with data from file
    public static boolean fillDB(){
        File dbInput = new File("C:\\Users\\kuhnr\\Desktop\\Studium\\Semester4\\Programmieren 2\\bondDB.bonds\\bondDB.bonds.txt");
        try {
            Scanner scanner = new Scanner(dbInput);

            int index = 0;
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] partials = line.split(" ");
                bonds bondEntry = new bonds();
                bondEntry.enterBond(partials[0], bondParser(partials[0]), Integer.parseInt(partials[1]), Double.parseDouble(partials[2]));
                bondDB.put(index, bondEntry);
                index++;
            }

        } catch (FileNotFoundException e){
            System.out.println("Error: File \"bondDB.bonds.txt\" not found in directory: \"C:\\Users\\kuhnr\\Desktop\\Studium\\Semester4\\Programmieren 2\\bondDB.bonds\"");
            return false;
        }
        return true;
    }


    // Method to identify keyboard input and search for corresponding Elements
    public static void searchEntry(String input){

        //if entry contains "." it has to be a float/double or wrong entry
        if (input.contains(".")){
            //trying to parse entry as double, catch exception and inform about error if wrong entry was given
            try {
                double searchDouble = Double.parseDouble(input);
                for (int i = 0; i < bondDB.size(); i++){
                    if (bondDB.get(i).getBondLength() == searchDouble){
                        printEntry(i);
                    }
                }
                System.out.println("\nAll matching entries found have been printed. If there is no output no matching bond length was found.");
            }
            catch (NumberFormatException e){
                System.out.println("\nERROR: Entry could not be processed, please try again");
            }

        }
        // if "." not in input, trying to parse as int, or catching exception and searching for equal bond names
        else {
            try {
                int searchInt = Integer.parseInt(input);
                for (int i = 0; i < bondDB.size(); i++) {
                    if (bondDB.get(i).getBondEnergy() == searchInt) {
                        printEntry(i);
                    }
                }
                System.out.println("\nAll matching entries found have been printed. If there is no output no matching bond energy was found.");

            } catch (NumberFormatException e) {

                for (int i = 0; i < bondDB.size(); i++) {

                    if (input.equals(bondDB.get(i).getAtoms())) {
                        printEntry(i);
                    }
                    else if (input.equals(bondDB.get(i).getBondType())){
                        printEntry(i);
                    }
                    else if (bondDB.get(i).getAtoms().contains(input)){
                        printEntry(i);
                    }
                }
                System.out.println("\nAll matching entries found have been printed. If there is no output no matching bond type was found.");
            }
        }
    }

    // constructor for output string, calling object elements from hash map
    public static void printEntry(int number){
        String line = bondDB.get(number).getAtoms() + ", " + bondDB.get(number).getBondType() + ": " + bondDB.get(number).getBondEnergy() +
                " kJ/mol ; " + bondDB.get(number).getBondLength() + " nm";

        System.out.println(line);
    }

    public static void main(String[] args) {

        System.out.println("This program generates a small database from an imported text file.");
        System.out.println("After initialization you can search for information by bond type, bond energy or bond length.");
        System.out.println("If you want to quit the program after the database is initialized, enter \"end\".");
        System.out.println("To initialize import and start program type \"init\" and press enter:");

        Scanner readConsole = new Scanner(System.in);
        boolean endCond = false;
        String consoleInput;

        while (!endCond){
            consoleInput = readConsole.nextLine();
            if (consoleInput.equals("init")){
                endCond = fillDB();
                System.out.println("The database has successfully been initialized. You can now search for entries.");
            }
            else {
                System.out.println("\"" + consoleInput + "\" is an invalid input, please try again.");
            }
        }

        endCond = false;

        while (!endCond){
            consoleInput = readConsole.nextLine();
            if (consoleInput.equals("end")){
                endCond = true;
            }
            else {
                searchEntry(consoleInput);
                System.out.println("\nYou can search further entries or end the program by entering \"end\":");
            }
        }

        System.out.println("Thank you for using this database program. Good bye!");

    }

}

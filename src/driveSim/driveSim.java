package driveSim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class driveSim {

    // updating car's fuel level and returns boolean to show if possible according to given distance
    static boolean drive(double distance, Car carStats){

        // calculating the fuel used over driven distance
        double usage = (distance * carStats.getMilage())/100;

        // updating fuel level if possible, .useFuel(usage) returns true if tank has enough capacity
        if (carStats.useFuel(usage)) return true;
        else return false;

    }

    // printing all stats of given car
    static void statPrinter(Car carStats){
        System.out.println("Ihr Wagen \"" + carStats.getName() + "\" hat aktuell diese Eigenschaften:");
        System.out.println("Tankvolumen: " + carStats.getCapacity());
        System.out.println("Verbrauch (L/100km): " + carStats.getMilage());
        System.out.println("Füllstand Tank: " + carStats.getFuelLevel());
    }

    // refuels car and returns boolean to show if capacity is large enough to take in all the fuel
    static boolean refuel(double addage, Car carStats){

        if (carStats.addFuel(addage)) return true;
        else return false;

    }

    // Simulator that executes user requested operation
    static boolean simulator(Car car, String operation){

        // printing name, capacity of tank, fuel use per 100km and current fuel level of given car via method "statPrinter"
        if (operation.equals("stats")){
            statPrinter(car);
            return true;
        }
        // printing current fuel level of chosen car
        else if (operation.equals("fuel")){
            System.out.println("Der Füllstand ihres Tanks beträgt: " + car.getFuelLevel() + "L");
            return true;
        }
        // handling the "drive" command, user input has to look like "d 15.3" (whole numbers possible)
        else if (operation.startsWith("d")){

            // splitting input string to separate command letter "d" from distance value (command format "d 50" for "drive 50km")
            String[] partials = operation.split(" ");

            // using try/catch to catch possible exceptions if distance value in command can not be parsed as double
            try {

                // using "drive" method to update fuel level in car object, method returns true if enough fuel is available to drive given distance
                // partials[1] is distance given by user input if command was given correctly
                if (drive(Double.parseDouble(partials[1]), car)){
                    System.out.println("Sie sind" + partials[1] + "km gefahren. Der Füllstand ihres Tanks beträgt neu: " + car.getFuelLevel() + "L");
                    return true;
                }
                // else informs user that car has not enough fuel when method "drive" returns false in if-condition above
                else{
                    System.out.println("Nicht genügend Treibstoff. Füllstand abfragen mit \"fuel\" oder \"stats\".");
                    return false;
                }
            }
            // informing user about faulty input if exception is triggered when distance part of command couldn't be parsed as double
            catch (Exception e){
                System.out.println("FEHLER: Fahrdistanz konnte nicht gelesen werden, versuchen Sie es erneut");
                return false;
            }
        }
        // handling the "refuel" command, user input has to look like "r 17.2" (whole numbers possible)
        else if (operation.startsWith("r")){

            // splitting input string to separate command letter "r" from refill volume value (command format "r 20" for "refill 20L")
            String[] partials = operation.split(" ");

            // using try/catch to catch possible exceptions if volume value in command can not be parsed as double
            try {

                // using "refuel" method to update fuel level in car object, method returns true if enough tank capacity is given to fill given amount of fuel
                // partials[1] is volume given by user input if command was given correctly
                if (refuel(Double.parseDouble(partials[1]), car)){
                    System.out.println("Sie haben" + partials[1] + " Liter getankt. Der Füllstand ihres Tanks beträgt neu: " + car.getFuelLevel() + "L");
                    return true;
                }
                // else informs user that car's tank has not enough capacity when method "refuel" returns false in if-condition above
                else{
                    System.out.println("Nicht genügend Tankvolumen. Tankvolumen abfragen mit \"stats\".");
                    return false;
                }
            }
            // informing user about faulty input if exception is triggered when volume part of command couldn't be parsed as double
            catch (Exception e){
                System.out.println("FEHLER: Volumen konnte nicht gelesen werden, versuchen Sie es erneut");
                return false;
            }
        }

        // informing user if given command could not be identified
        else {
            System.out.println("FEHLER: Befehl unbekannt. Versuchen Sie es erneut");
            return false;
        }
    }


    // method to find index of car object in list "cars", input being name of car to look for
    static int carFinder(String input, List<Car> cars){

        // method returns -1 if no car is found to stop simulation and request correct name of car
        int index = -1;

        // iterating over list cars, comparing input and car name at index i to find index of searched car in list cars
        for (int i = 0; i < cars.size(); i++) {

            // checking for match of input and car name, setting index to index of car object in list cars for further use in simulation
            if (input.equals(cars.get(i).getName())) {
                index = i;
            }
        }
        // if car is found index is set to correct index and only index is returned
        if (index != -1) return index;
        // if no car is found user is informed and -1 returned to stop simulation
        else {
            System.out.println("Es wurde kein Wagen mit diesem Namen gefunden.");
            return index;
        }
    }

    // method is used as command to print all valid commands on top level of program
    static void commandPrintout(){
        System.out.println("Dies sind die Befehle die Sie nutzen können:");
        System.out.println("Neuen Wagen registrieren: \"car\"");
        System.out.println("Liste aller Wagen: \"all cars\"");
        System.out.println("Simulation starten: \"sim\"");
        System.out.println("Simulation beenden: \"end sim\"");
        System.out.println("Liste aller Befehle: \"help\"");
        System.out.println("Programm beenden: \"quit\"");
        System.out.println("Neuen Wagen registrieren: \"car\"");
    }

    // method is used as command to print all valid commands within simulation
    static void simCommandPrintout(){
        System.out.println("Dies sind die Befehle mit denen Sie Ihren gewählten Wagen steuern können:");
        System.out.println("Alle Werte des Wagens abfragen: \"stats\"");
        System.out.println("Füllstand des Tanks abfragen: \"fuel\"");
        System.out.println("Fahrt simulieren: \"d Distanz(Zahl)\"");
        System.out.println("Wagen auftanken: \"r Menge(Zahl)\"");
        System.out.println("Liste aller Befehle: \"help\"");
        System.out.println("Simulation verlassen: \"end sim\"");
    }


    public static void main(String[] args) {

        // list to save and access car objects via index
        List<Car> cars = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // input is used to get top level commands, operation for commands within simulation
        String input, operation;

        // variable is used to temporarily store user requested car object for use in simulation
        Car usedCar;

        // boolean variables to control end of top level loop (quit) and end of simulation loop (endSim)
        boolean quit = false, endSim;

        System.out.println("Dies ist ein Fahrtensimulator. Sie können mit einfachen Befehlen ihre Wagen verwalten, Fahrten eingeben und Statusabfragen machen.");
        System.out.println("Zuerst müssen sie Ihre Wagen eingeben, danach können Sie Fahrten simulieren.");
        commandPrintout();

        // top level loop of program, user can access options "register car", "start simulation", "list of all cars", help and quit functions
        do{

            // reading user input to determine user command
            input = scanner.nextLine().toLowerCase();

            // if command "car" is given, starting branch for car registry
            if (input.equals("car")){

                // clearing input variable to prevent multiple use of single input
                input = null;

                // informing user on how to register car with example of expected input
                System.out.println("Um einen Wagen zu registrieren müssen Sie alle Daten wie folgt eingeben:");
                System.out.println("Formatvorlage: \"Name Tankvolumen(Zahl) Verbrauch/100km(Zahl)\"");
                System.out.println("Ein Beispiel: \"MeinWagen 28.75 12.3\"");

                // reading user input, converting to lower case for ease of handling
                input = scanner.nextLine().toLowerCase();

                // splitting user input of format "carName tankCapacity mileage" into separate strings for creation of car object
                String[] partials = input.split(" ");

                // creating new car object using partials from input string
                // carName (partial on index 0) is given to constructor directly,
                // tankCapacity (partial on index 1) is parsed as double
                // mileage (partial on index 2) is parsed as double
                // current fuel level is automatically set to 0 by last input to constructor
                Car car = new Car(partials[0], Double.parseDouble(partials[1]), Double.parseDouble(partials[2]), (double) 0);

                // new car object is added to list cars for further use in simulation
                cars.add(car);

                // clearing input variable to prevent multiple use of single input
                input = null;

                // informing user about successful registry of car object
                System.out.println("Sie haben den Wagen erfolgreich registriert. Vergessen Sie nicht ihn zu betanken bevor sie losfahren");

                // on end of branch loop will start anew and ask for new top level command
            }

            // if command "sim" is given, starting branch for simulation
            else if(input.equals("sim")){

                // clearing input variable to prevent multiple use of single input
                input = null;

                // informing user about options before starting simulation
                System.out.println("Sie befinden sich in der Simulation. Geben Sie den Namen des Wagens ein, den Sie nutzen wollen.");

                // informing user about command to show all valid commands in simulation
                System.out.println("Für eine Übersicht der Simulationsbefehle nutzen Sie: \"help\"");

                // reading user input which should match car.name of a car object in list cars
                input = scanner.nextLine().toLowerCase();

                // checking if user requested all valid commands to be printed
                if (input.equals("help")){

                    // printing all valid commands by using method (for details see method above
                    simCommandPrintout();
                }

                // starting simulation in else branch if help was not requested by user
                else {

                    // setting endSim to "false" to make sure following do/while loop does only break on request (break condition being "!endSim")
                    endSim = false;

                    // starting do/while loop with simulation
                    do {

                        // inputting user input and list cars into method car finder which returns index of sought car object in list cars or -1
                        // checking if valid index (i <= 0) is returned to start simulation with given car
                        if (carFinder(input, cars) != -1) {

                            // storing car object user requested in variable for simple use
                            usedCar = cars.get(carFinder(input, cars));

                            // informing user about chosen car and need to to fill tank if it's first use of car
                            // car objects are by default constructed with fuel level 0 therefore refuel is required before first use
                            System.out.println("Sie haben den Wagen " + usedCar.getName() + " gewählt. Geben Sie nun an, was Sie tun wollen.");
                            System.out.println("Wenn sie den gewählten Wagen zum ersten Mal nutzen, müssen Sie ihn erst betanken.");

                            // printing all valid commands for simulation (current do/while loop)
                            simCommandPrintout();

                            // reading user input as command for following simulation
                            operation = scanner.nextLine();

                            // checking if user requested commands to be printed and printing valid commands via method
                            if (operation.equals("help")) {
                                simCommandPrintout();
                            }

                            // checking if user requested to end simulation, leaving do/while loop by setting endSim to "true" (break condition "!endSim")
                            else if (operation.equals("end sim")) {
                                endSim = true;
                            }

                            // starting simulation if user did not request help or leaving the simulation loop
                            else {

                                // preempting possible exception if unprocessable command is given by user via try/catch
                                try {

                                    // simulating action according to command given by user (stored in operation)
                                    // simulator returns boolean, "true" if value in operation could be processed correctly
                                    if (simulator(usedCar, operation)) {

                                        // informing user about successful simulation
                                        System.out.println("Sie können nun eine weitere Aktion durchführen oder die Simulation mit \"end sim\" verlassen.");

                                        // resetting variable operation to prevent reuse of stored value
                                        operation = null;
                                    }
                                } catch (Exception e) {

                                    // informing user about unprocessable command if exception is triggered in simulator
                                    System.out.println("Versuchen Sie es bitte erneut und achten Sie auf die Rechtschreibung des Befehls.\n"
                                            + "Für eine Liste mit allen Befehlen, geben sie bei der nächsten Eingabeaufforderung \"help\" ein.");
                                }
                            }
                        }

                        // if user input doesn't match any name of car object in list cars this will be triggered
                        else {

                            // informing user that no valid car name was given and that simulation do/while loop will be left following this
                            System.out.println("Simulation wird beendet, da kein güliger Name für einen Wagen eingegeben wurde. Starten Sie die Simulation erneut mir richtigem Namen");

                            // setting endSim to "true" to end do/while loop with simulation in it
                            endSim = true;
                        }
                    }while (!endSim);
                }

                // on end of branch loop will start anew and ask for new top level command
            }

            // if command "all cars" is given, starting branch to print stats of all car object in list "cars"
            else if (input.equals("all cars")){
                if (!cars.isEmpty()) {
                    for (int i = 0; i < cars.size(); i++) {
                        statPrinter(cars.get(i));
                    }
                }
                else {
                    System.out.println("Sie haben noch keinen Wagen registriert.");
                }

                // on end of branch loop will start anew and ask for new top level command
            }

            // if command "help" is given, starting branch to print list of command for top level loop of program
            else if (input.equals("help")){
                commandPrintout();
                // on end of branch loop will start anew and ask for new top level command
            }

            // if command "quit" is given, ending top level loop by setting boolean variable to true which ends loop on check of break condition
            else if (input.equals("quit")){
                quit = true;

                // on end of branch loop will end since break condition will read "false"
            }

            // informing user if no valid command is given
            else{
                System.out.println("Ungültige Eingabe. Versuchen Sie es bitte erneut.");

                // on end of branch loop will start anew and ask for new top level command
            }

        // break condition "not value of boolean quit" which is initially set to "false" (so while reads condition as "true")
        // command quit in top level loop sets variable quit to "true" and loop will read break condition as "false" and end program
        }while(!quit);


    }

}

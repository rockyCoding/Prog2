import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class packinglist {

    public static String stringHandler(String inputString){
        String clearedInput = "";
        clearedInput = inputString.substring(2);
        return clearedInput;
    }

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);
        String breakCondition = "end";
        String input;
        List<String> packingList = new ArrayList<>();

        System.out.println("Dies ist ein Packlisten-Management Programm.\n");
        System.out.println("Um Elemente zur Liste hinzuzufügen, schreiben sie folgenden Befehl: + Mein Element");
        System.out.println("Um Elemente von der Liste zu löschen, schreiben sie folgenden Befehl: - Mein Element");
        System.out.println("Um die Liste zu drucken, schreiben sie folgenden Befehl: p");
        System.out.println("Um die Eingabe zu beenden, schreiben sie folgenden Befehl: end\n");
        System.out.println("Ihre Eingabe: ");

        do{
            input = inputReader.nextLine();
            if (input.startsWith("+")){
                input = stringHandler(input);
                packingList.add(input);
                if (packingList.size() > 1){
                    Collections.sort(packingList);
                }
            }
            else if (input.startsWith("-")){
                input = stringHandler(input);
                packingList.remove(input);
            }
            else if (input.equals("p")){
                for (int i = 0; i < packingList.size(); i++) {
                    String printString =  packingList.get(i);
                    System.out.println(printString);
                }
            }
            else if (input.equals(breakCondition)){
                for (int i = 0; i < packingList.size(); i++) {
                    String printString =  packingList.get(i);
                    System.out.println(printString);
                }
                System.out.println();
                System.out.println("Dies ist die finale Liste.");
            }
            else{
                System.out.println("Fehler! Befehl unbekannt.");
            }
        }while (!breakCondition.equals(input));
    }
}

import java.util.*;

public class textAnalysis {

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);
        List<Character> letters = new ArrayList<>();
        String input;

        System.out.println("Geben Sie beliebigen Text ein. Das Programm wird analysieren, wie oft ein Zeichen in diesem Text vorkommt.");
        System.out.println("Ihre Eingabe: ");

        input = inputReader.nextLine().toLowerCase();
        for (int i = 0; i < input.length(); i++){
            letters.add(input.charAt(i));
        }
        Collections.sort(letters);
        List<Character> characterList = new ArrayList<>(new HashSet<>(letters));
        Collections.sort(characterList);
        for (int i = 0; i < characterList.size(); i++){
            System.out.println("Das Zeichen \"" + characterList.get(i) + "\" kommt " + (letters.lastIndexOf(characterList.get(i)) - letters.indexOf(characterList.get(i)) + 1) + " Mal vor.");
        }
        

    }



}

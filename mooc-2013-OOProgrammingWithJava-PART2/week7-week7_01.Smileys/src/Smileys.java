
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }

    private static void printWithSmileys(String characterString) {
        int stringLength = characterString.length();
        if(stringLength % 2 != 0) {
            characterString += " ";
            stringLength++;
        }
        int numberOfSmileys = stringLength / 2 + 3;
        printRow(numberOfSmileys);
        printMiddleRow(characterString);
        printRow(numberOfSmileys);
        
    }
    
    private static void printRow(int number) {
        for(int i = 0; i < number; i++) {
            System.out.print(":)");
        }
        System.out.println("");
    }
    
    private static void printMiddleRow(String characterString) {
        System.out.println(":) " + characterString + " :)");
    }
}

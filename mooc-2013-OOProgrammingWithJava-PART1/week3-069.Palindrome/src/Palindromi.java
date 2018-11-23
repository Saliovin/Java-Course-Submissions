import java.util.Scanner;

public class Palindromi {
    
    public static String reverse(String text){
        int length = text.length();
        String reversed = "";
        for (int i = length - 1; i >= 0; i--){
            reversed += text.charAt(i);
        }
        return reversed;
    }
    public static boolean palindrome(String text) {
        // write code here
        return text.equals(reverse(text));
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Type a text: ");
        String text = reader.nextLine();    
        if (palindrome(text)) {
            System.out.println("The text is a palindrome!");
        } else {
            System.out.println("The text is not a palindrome!");
        }
    }
}

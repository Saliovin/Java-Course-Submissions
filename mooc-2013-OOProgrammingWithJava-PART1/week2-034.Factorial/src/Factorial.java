import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.print("Type a number: ");
        int limit = Integer.parseInt(reader.nextLine());
        int counter = 1;
        int factorial = 1;
        
        while (counter <= limit){
            factorial *= counter;
            counter ++;
        }
        
        System.out.println("Factorial is " + factorial);
    }
}

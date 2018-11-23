
import java.util.Scanner;


public class TheSumBetweenTwoNumbers {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.print("First: ");
        int counter = Integer.parseInt(reader.nextLine());
        System.out.print("Last: ");
        int limit = Integer.parseInt(reader.nextLine());
        int sum = 0;
        
        while (counter <= limit){
            sum += counter;
            counter++;
        }
        
        System.out.println("The sum is " + sum);
    }
}

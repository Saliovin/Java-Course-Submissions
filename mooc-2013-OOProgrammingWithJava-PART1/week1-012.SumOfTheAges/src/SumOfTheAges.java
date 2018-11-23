
import java.util.Scanner;

public class SumOfTheAges {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.print("Type your name: ");
        String user1Name = reader.nextLine();
        System.out.print("Type your age: ");
        int user1Age = Integer.parseInt(reader.nextLine());
        System.out.println("");
        
        System.out.print("Type your name: ");
        String user2Name = reader.nextLine();
        System.out.print("Type your age: ");
        int user2Age = Integer.parseInt(reader.nextLine());
        System.out.println("");
        int sum = user1Age + user2Age;
        System.out.println(user1Name + " and " + user2Name + " are " + sum + " years old in total.");
        // Implement your program here
    }
}

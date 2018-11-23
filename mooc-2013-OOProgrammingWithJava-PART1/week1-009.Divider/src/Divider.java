
import java.util.Scanner;

public class Divider {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Type a number: ");
        int a = Integer.parseInt(reader.nextLine());
        System.out.print("Type another number: ");
        int b = Integer.parseInt(reader.nextLine());
        double quotient = (double)a / b;
        System.out.println("");
        System.out.println("Division: " + a + " / " + b + " = " + quotient);
        // Implement your program here. Remember to ask the input from user.
    }
}

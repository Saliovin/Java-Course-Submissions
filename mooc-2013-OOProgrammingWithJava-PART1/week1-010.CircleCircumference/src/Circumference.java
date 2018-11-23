
import java.util.Scanner;

public class Circumference {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Type the radius: ");
        int r = Integer.parseInt(reader.nextLine());
        double circ = 2.0*Math.PI*r;
        System.out.println("");
        System.out.println("Circumference of the circle: " + circ);
        // Program your solution here 
    }
}

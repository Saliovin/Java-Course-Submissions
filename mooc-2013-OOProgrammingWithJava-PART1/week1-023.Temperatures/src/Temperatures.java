
import java.util.Scanner;

public class Temperatures {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        // Write your code here. 
        while (true){
            System.out.print("Input temperature: ");
            double temp = Double.parseDouble(reader.nextLine());
            
            if (temp < 41 && temp > -31){
                Graph.addNumber(temp);
                System.out.println("Added temperature.");
            }
            else{
                System.out.println("Invalid temperature.");
            }
        }
    }
}


import java.util.Scanner;

public class LowerLimitAndUpperLimit {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // write your code here
        System.out.print("First: ");
        int counter = Integer.parseInt(reader.nextLine());
        System.out.print("Last: ");
        int limit = Integer.parseInt(reader.nextLine());
        
        while (counter <= limit){
            System.out.println(counter);
            counter++;
        }
    }
}

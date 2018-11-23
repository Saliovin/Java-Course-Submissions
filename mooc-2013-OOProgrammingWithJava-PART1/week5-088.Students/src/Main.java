
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write here the main program
        Scanner reader = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<Student>();
        
        while(true) {
            System.out.print("name: ");
            String inputName = reader.nextLine();
            if(inputName.isEmpty()) {
                break;
            }
            System.out.print("studentnumber: ");
            String inputStudentNumber = reader.nextLine();
            list.add(new Student(inputName, inputStudentNumber));
        }
        
        System.out.println("");
        for(Student current : list) {
            System.out.println(current);
        }
        
        System.out.println("");
        System.out.print("Give search term: ");
        String searchTerm = reader.nextLine();
        System.out.println("Result:");
        for(Student current : list) {
            if(current.getName().contains(searchTerm)) {
                System.out.println(current);
            }
        }
    }
}

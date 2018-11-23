import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // implement your program here
        // do not put all to one method/class but rather design a proper structure to your program
        
        // Your program should use only one Scanner object, i.e., it is allowed to call 
        // new Scanner only once. If you need scanner in multiple places, you can pass it as parameter
        CourseScores class1 = new CourseScores();
        System.out.println("Type exam scores, -1 completes:");
        while(true) {
            int inputScore = Integer.parseInt(lukija.nextLine());
            if(inputScore == -1 ) {
                break;
            }
            if(inputScore >= 0 && inputScore <= 60) {
                class1.addScore(inputScore);
            }
        }
        class1.print();
    }
}

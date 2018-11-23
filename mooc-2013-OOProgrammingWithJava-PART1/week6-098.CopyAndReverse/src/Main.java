
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write testcode here
        int[] original = {1, 2, 3, 4};
        int[] reverse = reverseCopy(original);

        // print both
        System.out.println( "original: " +Arrays.toString(original));
        System.out.println( "reversed: " +Arrays.toString(reverse));
    }
    
    public static int[] copy(int[] array) {
        int[] arrayCopy = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            arrayCopy[i] = array[i];
        }
        return arrayCopy;
    }
    
    public static int[] reverseCopy(int[] array) {
        int arrayLength = array.length;
        int[] arrayCopy = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++) {
            arrayCopy[i] = array[arrayLength - (i + 1)];
        }
        return arrayCopy;
    }
}

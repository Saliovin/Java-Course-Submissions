
public class Greatest {

    public static int greatest(int number1, int number2, int number3) {
        int high = Math.max(number1, number2);
        high = Math.max(high, number3);
        return high;
    }

    public static void main(String[] args) {
        int result = greatest(2, 7, 3);
        System.out.println("Greatest: " + result);
    }
}


import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder string = new StringBuilder();
        string.append("{\n ");
        
        for(int i = 0; i < t.length; i++) {
            string.append(t[i] + ", ");
            
            if((i + 1) % 4 == 0) {
                string.append("\n ");
            }
        }
        
        for(int i = string.length() - 1; i >= 0; i--) {
            if(string.charAt(i) == ',') {
                string.deleteCharAt(i);
                break;
            }
            
            string.deleteCharAt(i);
        }
        
        string.append("\n}");
        
        return string.toString();
    }
}

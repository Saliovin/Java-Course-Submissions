
public class Main {

    public static void main(String[] args) {
        // write test code here
        if(clockTime("23:59:59")) {
            System.out.println("OK");
        }
        
        else {
            System.out.println("NO");
        }
    }
    
    public static boolean isAWeekDay(String string) {
        if(string.matches("mon|tue|wed|thu|fri|sat|sun")) {
            return true;
        }
        
        return false;
    }
    
    public static boolean allVowels(String string) {
        if(string.matches("[aeiouäö]*")) {
            return true;
        }
        
        return false;
    }
    
    public static boolean clockTime(String string) {
        if(string.matches("[0-9][0-9]:[0-9][0-9]:[0-9][0-9]")) {
            String[] stringArray = string.split(":");
            
            if(Integer.parseInt(stringArray[0]) < 24 &&
                    Integer.parseInt(stringArray[1]) < 60 &&
                    Integer.parseInt(stringArray[2]) < 60) {
                return true;
            }
            
            
        }
        
        return false;
    }
}

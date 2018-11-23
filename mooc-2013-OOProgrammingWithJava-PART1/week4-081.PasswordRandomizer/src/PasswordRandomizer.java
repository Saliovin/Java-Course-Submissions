import java.util.Random;

public class PasswordRandomizer {
    // Define the variables
    private int passwordLength;
    private Random random = new Random();
    public PasswordRandomizer(int length) {
        // Initialize the variable
        this.passwordLength = length;
    }

    public String createPassword() {
        // write code that returns a randomized password
        String characters = "abcdefghijklmnopqrstuvwxyz";
        String password = "";
        for(int i = 0; i < this.passwordLength; i++) {
            password += characters.charAt(random.nextInt(characters.length()));
        }
        return password;
    }
}

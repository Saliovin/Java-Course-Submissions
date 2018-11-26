package dictionary;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Test your dictionary here
        MindfulDictionary s = new MindfulDictionary("test/tmp/tmp38823.txt");
        s.add("tietokone", "computer");
        s.save();
    }
}

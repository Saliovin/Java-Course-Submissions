
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public List<String> read(String file) throws FileNotFoundException {
        File textFile = new File(file);
        Scanner reader = new Scanner(textFile);
        List<String> readText = new ArrayList<String>();
        
        while(reader.hasNextLine()) {
            readText.add(reader.nextLine());
        }
        
        return readText;
    }

    public void save(String file, String text) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        File textFile = new File(file);
        FileWriter writer = new FileWriter(textFile);
        for(String i : texts) {
            writer.write(i + "\n");
        }
        writer.close();
    }
}

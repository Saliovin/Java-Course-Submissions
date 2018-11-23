
import java.util.HashMap;
import java.util.Map;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations requested in the assignment here!
        HashMap<String, String> table = new HashMap<String, String>();
        table.put("matti", "mage");
        table.put("mikael", "mixu");
        table.put("arto", "arppa");
        System.out.println(table.get("mikael"));
    }

}

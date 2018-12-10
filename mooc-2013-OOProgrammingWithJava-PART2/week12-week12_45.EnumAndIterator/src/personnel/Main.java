package personnel;

public class Main {

    public static void main(String[] args) {
        Employees t = new Employees(); 
        Person h = new Person("Arto", Education.M); 
        t.add(h); 
        t.print(Education.M);
    }
}
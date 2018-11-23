import java.util.Calendar;

public class Person {
    private String name;
    private MyDate birthday;
    
    public Person(String name, int pp, int kk, int vv) {
        this.name = name;
        this.birthday = new MyDate(pp, kk, vv);
    }
    
    public Person(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    
    public Person(String name) {
        this.name = name;
        this.birthday = this.getCurrentDate();
    }
    
    public int age() {
// calculate the age based on the birthday and the current day
        // you get the current day as follows: 
        return birthday.differenceInYears(this.getCurrentDate());
    }
    
    public boolean olderThan(Person compared) {
        // compare the ages based on birthdays
        if(this.birthday.earlier(compared.birthday)) {
            return true;
        }
        return false;
    }
    
    public String getName() {
        return this.name;
    }
    
    public MyDate getCurrentDate() {
        int currentDay = Calendar.getInstance().get(Calendar.DATE);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        MyDate currentDate = new MyDate(currentDay, currentMonth, currentYear);
        return currentDate;
    }
    public String toString() {
        return this.name + ", born " + this.birthday;
    }
    
    
}

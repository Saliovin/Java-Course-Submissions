public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int montd, int year) {
        this.day = day;
        this.month = montd;
        this.year = year;
    }

    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean earlier(MyDate compared) {
        if (this.year < compared.year) {
            return true;
        }

        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        if (this.year == compared.year && this.month == compared.month
                && this.day < compared.day) {
            return true;
        }

        return false;
    }
    
    public int differenceInYears(MyDate comparedDate) {
        MyDate greater, lower;
        if(comparedDate.earlier(this)) {
            greater = this;
            lower = comparedDate;
        }
        else {
            greater = comparedDate;
            lower = this;
        }
        int diff = greater.year - lower.year;
        int currentYearDiffInDays = ((greater.month - 1) * 30 + greater.day) 
                + (12 - lower.month) * 30 + 30 - lower.day;
        if(currentYearDiffInDays < 360) {
            diff--;
        }
        return diff;
    }
}

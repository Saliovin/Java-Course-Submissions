
public class MyDate {

    private int day;
    private int month;
    private int year;

    public MyDate(int pv, int kk, int vv) {
        this.day = pv;
        this.month = kk;
        this.year = vv;
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

    /*
     * In assignment 92 method differneceInYears was added to MyDate 
     * Copy the method here since it eases this assignment considerably.
     */
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

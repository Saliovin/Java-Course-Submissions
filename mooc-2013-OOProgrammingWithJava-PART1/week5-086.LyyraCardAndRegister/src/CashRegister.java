
public class CashRegister {

    private double cashInRegister;
    private int economicalSold;
    private int gourmetSold;

    public CashRegister() {
        // at start the register has 1000 euros 
        this.cashInRegister = 1000.0;
    }

    public double payEconomical(double cashGiven) {
        // price of the economical lunch is 2.50 euros
        // if the given cash is at least the price of the lunch:
        //    the price of lunch is added to register
        //    the amount of sold lunch is incremented by one
        //    method returns cashGiven - lunch price 
        // if not enough money given, all is returned and nothing else happens 
        if (cashGiven < 2.5) {
            return cashGiven;
        }
        else {
            this.cashInRegister += 2.5;
            this.economicalSold++;
            return cashGiven - 2.5;
        }
    }
    public boolean payEconomical(LyyraCard card) {
        if(card.pay(2.5)) {
            this.economicalSold++;
            return true;
        }
        else {
            return false;
        }
    }

    public double payGourmet(double cashGiven) {
        // price of the gourmet lunch is 4.00 euros
        // if the given cash is at least the price of the lunch:
        //    the price of lunch is added to register
        //    the amount of sold lunch is incremented by one
        //    method returns cashGiven - lunch price 
        // if not enough money given, all is returned and nothing else happens
        if (cashGiven < 4.0) {
            return cashGiven;
        }
        else {
            this.cashInRegister += 4.0;
            this.gourmetSold++;
            return cashGiven - 4.0;
        }
    }
    public boolean payGourmet(LyyraCard card) {
        if(card.pay(4.0)) {
            this.gourmetSold++;
            return true;
        }
        else {
            return false;
        }
    }

    public void loadMoneyToCard(LyyraCard card, double sum) {
        if(sum > 0) {
            this.cashInRegister += sum;
            card.loadMoney(sum);
        }
    }

    public String toString() {
        return "money in register " + cashInRegister + " economical lunches sold: " + economicalSold + " gourmet lunches sold: " + gourmetSold;
    }
}

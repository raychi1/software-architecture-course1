package Lab_1;

class Bill {
    private double limitingAmount;
    private double currentDebt;

    // constructor
    public Bill(double limitingAmount) {
        this.limitingAmount = limitingAmount;
        this.currentDebt = 0.0;
    }

    //check if you can add some amount to customer's current debt without crossing limit
    public boolean check(double amount) {
        return currentDebt + amount <= limitingAmount;
    }

    // adds amount to cliemt's debt if that possible
    public void add(double amount) {
        if (check(amount)) {
            currentDebt += amount;
        } else {
            System.out.println("Bill limit warning! You can't add more.");
        }
    }

    // allows to pay amount from client's debt. IF amount is not negative and IF amount don't cross current debt
    public void pay(double amount) {
        if (amount >= 0 && amount <= currentDebt) {
            currentDebt -= amount;
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void changeTheLimit(double amount) {
        limitingAmount = amount;
    }

    public double getLimitingAmount() {
        return limitingAmount;
    }

    public double getCurrentDebt() {
        return currentDebt;
    }
}

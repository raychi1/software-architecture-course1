package Lab_1;

class Customer {
    private int ID;
    private String name;
    private int age;
    // composition
    private Operator[] operators;
    private Bill bill;

    //Constructor
    public Customer(int ID, String name, int age, Operator[] operators, Bill[] bills, double limitingAmount) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.operators = operators;
        this.bill = new Bill(limitingAmount);// creating a new Bill object for the current customer and initializing it with a specified limitingAmount
    }

    // simulates a customer making a phone call to another customer
    public void talk(int minutes, Customer other) {
        Operator operator = operators[ID % operators.length];// clients are evenly distributed between operators. This helps balance the burden on operators.
        // Each client has its own unique ID from 0 to 9.
        //
        //Client with ID 0:0 % 5 = 0. Therefore, this client will use an operator with index 0.
        //
        //Client with ID 1:1 % 5 = 1. It will use the operator at index 1.
        double talkingCost = operator.calculateTalkingCost(minutes, this); // talking cost for both customers
        if (bill.check(talkingCost)) {
            bill.add(talkingCost);
            other.bill.add(talkingCost); // since we have two customers talking
        } else {
            System.out.println("Talking failed. Bill limit error!.");
        }
    }

    public void message(int quantity, Customer other) {
        Operator operator = operators[ID % operators.length];
        double messageCost = operator.calculateMessageCost(quantity, this, other);
        if (bill.check(messageCost)) {
            bill.add(messageCost);
            other.bill.add(messageCost);
        } else {
            System.out.println("Message sending failed. Bill limit error!.");
        }
    }

    public void connection(double amount) {
        Operator operator = operators[ID % operators.length];
        double networkCost = operator.calculateNetworkCost(amount);
        if (bill.check(networkCost)) {
            bill.add(networkCost);
        } else {
            System.out.println("Connection failed. Bill limit error!.");
        }
    }

    public void pay(double amount) {
        if (amount >= 0) {
            bill.pay(amount);
        } else {
            System.out.println("Invalid payment amount.");
        }
    }

    public void changeOperator(Operator newOperator) {
        operators[ID % operators.length] = newOperator;
    }

    public void changeBillLimit(double newLimit) {
        bill.changeTheLimit(newLimit);
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Operator[] getOperators() {
        return operators;
    }

    public Bill getBill() {
        return bill;
    }
}


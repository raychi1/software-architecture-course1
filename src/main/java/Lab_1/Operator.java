package Lab_1;

import java.util.Arrays;

class Operator {
    private int ID;
    private double talkingCharge;
    private double messageCost;
    private double networkCharge;
    private int discountRate;
    private static final int MAX_CUSTOMER_AGE_LIMIT = 65;
    private static final int MIN_CUSTOMER_AGE_LIMIT = 18;

    public Operator(int ID, double talkingCharge, double messageCost, double networkCharge, int discountRate) {
        this.ID = ID;
        this.talkingCharge = talkingCharge;
        this.messageCost = messageCost;
        this.networkCharge = networkCharge;
        this.discountRate = discountRate;
    }

    public double calculateTalkingCost(int minutes, Customer customer) {
        double charge = talkingCharge * minutes;
        if (customer.getAge() < MIN_CUSTOMER_AGE_LIMIT
                || customer.getAge() > MAX_CUSTOMER_AGE_LIMIT) {
            charge -= charge * (discountRate / 100.0);//multiplying the original charge by the discount rate as a fraction.
            // original charge is $100 and the discount rate is 10%  results  $10.
            // charge - discount
        }
        return charge;
    }

    public double calculateMessageCost(int quantity, Customer customer, Customer other) {
        double cost = messageCost * quantity;
        //checks if both customers are using the same operator.
        if (Arrays.asList(customer.getOperators()).contains(this) &&
                Arrays.asList(other.getOperators()).contains(this)) {
            cost -= cost * (discountRate / 100.0);
        }
        return cost;
    }

    public double calculateNetworkCost(double amount) {
        return networkCharge * amount;
    }

    public int getID() {
        return ID;
    }

    public double getTalkingCharge() {
        return talkingCharge;
    }

    public double getMessageCost() {
        return messageCost;
    }

    public double getNetworkCharge() {
        return networkCharge;
    }

    public int getDiscountRate() {
        return discountRate;
    }
}

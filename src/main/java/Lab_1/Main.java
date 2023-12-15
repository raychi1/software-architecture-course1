package Lab_1;

public class Main {
    public static void main(String[] args) {
        // Number of customers and operators
        int N = 5;
        int M = 3;

        // Arrays to store customers, operators, and bills
        Customer[] customers = new Customer[N];
        Operator[] operators = new Operator[M];
        Bill[] bills = new Bill[N];

        // Operators
        operators[0] = new Operator(0, 0.5, 0.1, 0.2, 10);
        operators[1] = new Operator(1, 0.6, 0.2, 0.15, 5);
        operators[2] = new Operator(2, 0.4, 0.15, 0.25, 8);

        // Customers
        customers[0] = new Customer(0, "Ivan", 30, operators, bills, 200.0);
        customers[1] = new Customer(1, "Petro", 25, operators, bills, 150.0);
        customers[2] = new Customer(2, "Nazar", 18, operators, bills, 100.0);
        customers[3] = new Customer(3, "Oleg", 40, operators, bills, 250.0);
        customers[4] = new Customer(4, "Taras", 60, operators, bills, 300.0);

        customers[0].talk(10, customers[1]);
        customers[1].message(50, customers[2]);
        customers[2].connection(100);
        customers[3].changeOperator(operators[2]); //update the operator for Customer 3
        customers[4].changeBillLimit(400); // update the bill limit for Customer 4

        // Print bill information
        for (Customer customer : customers) {
            System.out.println(customer.getName() + "'s debt is: $" + customer.getBill().getCurrentDebt());
        }
    }
}

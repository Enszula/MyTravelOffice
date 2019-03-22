package tf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravelOffice {
    Customer[] customers = new Customer[2];

    public void addCustomer(Customer customer) {
        int index = this.getCustomerCount();
        if (customers.length <= this.getCustomerCount() ) {
            Customer[] tempCustomerArray = new Customer[customers.length * 2];
            System.arraycopy(customers, 0, tempCustomerArray, 0, customers.length);
            customers = tempCustomerArray;
        }
            customers[index++] = customer;
    }

    @Override
    public String toString() {
        List<Customer> customerList = new ArrayList<>(Arrays.asList(customers));
        String s = "";
        for (Customer c: customers)
            if (c instanceof Customer)
                s += c + "\n";

        return "TravelOffice{" +
                "customers=\n" + s +
                '}';
    }

    public int getCustomerCount() {
        int customerCount = 0;
        for (Customer c : customers)
            if (c instanceof Customer)
                customerCount++;

        return customerCount;
    }

/*
    public static void main(String[] args) {
        TravelOffice travelOffice = new TravelOffice();

        Address address = new Address("Opolska 22", "40-084", "Katowice");
        Customer customer = new Customer("Jan Kowalski");
        customer.setAddress(address);
        Trip trip = new Trip(new MyDate(2019, 03, 18),
                new MyDate(2019, 03, 29),
                "Katowice");
        customer.assignTrip(trip);

        Customer customer1 = new Customer("Marek Nowak");
        customer1.setAddress(new Address("Niedurnego 2a/7", "40-384", "Katowice"));
        Trip trip1 = new Trip(new MyDate(2019, 04, 16),
                              new MyDate(2019, 06, 31),
                    "Katowice");
        customer1.assignTrip(trip1);

        Customer customer2 = new Customer("Miroslaw");
        customer2.setAddress(new Address("Wiejska", "11-111", "Warszawa"));

        travelOffice.addCustomer(customer);
        travelOffice.addCustomer(customer2);
        travelOffice.addCustomer(customer1);


        System.out.println(travelOffice);
        System.out.println(travelOffice.getCustomerCount());
    }
*/
}

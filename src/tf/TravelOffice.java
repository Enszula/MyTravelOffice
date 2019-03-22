package tf;

import java.util.*;

public class TravelOffice {
    Set<Customer> customers = new HashSet<>();
    Map<String, Trip> trips = new HashMap<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public int getCustomerCount() {
        int customerCount = 0;
        for (Customer c : customers)
            if (c instanceof Customer)
                customerCount++;

        return customerCount;
    }

    public void addTrip(String tripName, Trip trip) {
        trips.put(tripName, trip);
    }

    public boolean removeTrip(String tripName) {
        if (trips.containsKey(tripName)) {
            trips.remove(tripName);
            return true;
        }
        else
            System.out.println("Wycieczka o nazwie" + tripName + " nie istnieje!");

        return false;
    }

    public Customer findCustomerByName(String customerName) {
        List<Customer> list = new ArrayList<>(customers);
        for (Customer c: customers) {
            if (c.toString() == customerName)
                return c;
        }

        return null;
    }

    public boolean removeCustomer(Customer customer) {
        if (customer == null)
            return false;

        return customers.remove(customer);
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public Map<String, Trip> getTrips() {
        return trips;
    }

    @Override
    public String toString() {
        String s = "";
        for (Customer c: customers)
            if (c instanceof Customer)
                s += c + "\n";

        return "TravelOffice{" +
                "customers=\n" + s +
                '}';
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

package tf;

public class TravelOffice {
    public static void main(String[] args) {
        Address address = new Address("Opolska 22", "40-084", "Katowice");
        Customer customer = new Customer("Jan Kowalski");
        customer.setAddress(address);
        Trip trip = new Trip(new MyDate(2019, 03, 18),
                             new MyDate(2019, 03, 29),
                             "Katowice");
        customer.assignTrip(trip);

        System.out.println(customer);
    }
}

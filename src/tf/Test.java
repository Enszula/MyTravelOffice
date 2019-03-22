package tf;

public class Test {
    public static void main(String[] args) {
        TravelOffice travelOffice = new TravelOffice();

        Address address = new Address("Opolska 22", "40-084", "Katowice");
        Customer customer = new Customer("Jan Kowalski");
        customer.setAddress(address);
        Trip trip = new DomesticTrip(new MyDate(2019, 03, 18),
                new MyDate(2019, 03, 29),
                "Katowice");
        trip.setPrice(8000.0);
        ((DomesticTrip) trip).setOwnArrivalDiscount(1000.0);
        customer.assignTrip(trip);

        Customer customer1 = new Customer("Marek Nowak");
        customer1.setAddress(new Address("Niedurnego 2a/7", "40-384", "Katowice"));
        Trip trip1 = new AbroadTrip(new MyDate(2019, 04, 16),
                new MyDate(2019, 06, 31),
                "London");
        trip1.setPrice(4000.0);
        ((AbroadTrip) trip1).setInsurance(500.0);
        customer1.assignTrip(trip1);

        Customer customer2 = new Customer("Miroslaw");
        customer2.setAddress(new Address("Wiejska", "11-111", "Warszawa"));

        travelOffice.addCustomer(customer);
        travelOffice.addCustomer(customer2);
        travelOffice.addCustomer(customer1);


        System.out.println(travelOffice);
        System.out.println(travelOffice.getCustomerCount());
    }

}

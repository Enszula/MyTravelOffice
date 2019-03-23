package TravelOffice.tf;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class MainHandler implements UserInterface {
    private static Logger logger = Logger.getLogger("to.TravelOffice");
    private TravelOffice travelOffice;
    private Scanner scanner = null;

    public MainHandler(TravelOffice travelOffice) {
        this.travelOffice = travelOffice;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Customer addCustomer() {
        System.out.println("Imie klienta? ");
        String customerName = scanner.next();

        System.out.print("Ulica? ");
        String street = scanner.next();
        System.out.print("Kod pocztowy? ");
        String zipCode = scanner.next();
        System.out.print("Miasto? ");
        String city = scanner.next();

        Address address = new Address(street, zipCode, city);
        Customer customer = new Customer(customerName);
        customer.setAddress(address);
        travelOffice.addCustomer(customer);
        System.out.println("Utworzono nowego klienta!");

        logger.info("Create new customer");
        return customer;
    }

    @Override
    public Trip addTrip() {
        System.out.print("Nazwa wycieczki? ");
        String tripName = scanner.next();

        System.out.print("Miasto wycieczki ");
        String destination = scanner.next();

        System.out.print("Data rozpoczecia wycieczki (dd-MM-yy) ");
        String start = scanner.next();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(start, dateTimeFormatter);

        System.out.print("Data zakonczenia wycieczki (dd-MM-yy) ");
        String end = scanner.next();
        LocalDate endDate = LocalDate.parse(end, dateTimeFormatter);

        System.out.print("Cena wycieczki? ");
        double price = scanner.nextInt();

        System.out.print("Wycieczka krajowa/zagraniczna? ");
        String tripType = scanner.next();

        Trip trip = null;
        if (tripType.startsWith("z") ) {
            System.out.print("Ubezpieczenie wycieczki? ");
            double insurance = scanner.nextDouble();

            trip = new AbroadTrip(startDate, endDate, destination);
            trip.setPrice(price);
            ((AbroadTrip) trip).setInsurance(insurance);
            travelOffice.addTrip(tripName, trip);
        }
        else {
            System.out.print("Znizka? ");
            double discount = scanner.nextDouble();

            trip = new DomesticTrip(startDate, endDate, destination);
            trip.setPrice(price);
            ((DomesticTrip) trip).setOwnArrivalDiscount(discount);
            travelOffice.addTrip(tripName, trip);
        }

        System.out.println("Dodano nowa wycieczke...\n");
        logger.info("Dodano nowa wycieczke.");
        return trip;
    }

    @Override
    public void assign() {
        System.out.print("Imie klienta? ");
        String name = scanner.next();

        Customer customer = null;
        try {
            customer = travelOffice.findCustomerByName(name);
        } catch (NoSuchCustomerException e) {
            e.printStackTrace();
            logger.warning("NoSuchCustomerException thrown");
        }
//        if (customer == null) {
//            System.out.println("Nie ma klienta o imieniu '" + name + "'\n");
//            return;
//        }

        System.out.print("Nazwa wycieczki? ");
        String tripName = scanner.next();

        Trip trip = travelOffice.getTrips().get(tripName);
        if (trip == null) {
            System.out.println("Nie ma wycieczki o nazwie '" + tripName + "'\n");
            return;
        }
        customer.assignTrip(trip);
    }

    @Override
    public boolean removeCustomer() {
        System.out.print("Imie klienta do usuniecia? ");
        String customerName = scanner.next();

        Customer customer;
        travelOffice.getCustomers().removeIf(customer1 -> customer1.getName().equals(customerName));

        System.out.println("Klient usuniety...\n");
        logger.info("Customer deletion");
        return true;
    }

    @Override
    public boolean removeTrip() {
        System.out.print("Nazwa wycieczki do usuniecia? ");
        String id = scanner.next();
        boolean success = false;
        try {
            success = travelOffice.removeTrip(id);
        } catch (NoSuchTripException e) {
            e.printStackTrace();
            logger.warning("NoSuchTripException thrown");
        }

        System.out.println("Wycieczka zostala usunieta...\n");
        return true;
    }

    @Override
    public void showTrips() {
        System.out.println("Lista wycieczek:");
        travelOffice.getTrips().forEach((s, trip) -> System.out.println(s + " " + trip));

//        for (Map.Entry<String, Trip> entry : travelOffice.getTrips().entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
        System.out.println();
    }

    @Override
    public void showCustomers() {
        System.out.println("Lista klientow:");
        travelOffice.getCustomers().forEach(customer -> System.out.println(customer));
    }

}

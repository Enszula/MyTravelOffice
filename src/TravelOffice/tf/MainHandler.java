package TravelOffice.tf;

import java.util.Map;
import java.util.Scanner;

public class MainHandler implements UserInterface {
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

        return customer;
    }

    @Override
    public Trip addTrip() {
        System.out.print("Nazwa wycieczki? ");
        String tripName = scanner.next();

        System.out.print("Miasto wycieczki ");
        String destination = scanner.next();

        System.out.print("Data rozpoczecia wycieczki (dd-MM-yy)");
        String start = scanner.next();
        MyDate startDate = MyDate.of(start, "-");

        System.out.print("Data zakonczenia wycieczki (dd-MM-yy)");
        String end = scanner.next();
        MyDate endDate = MyDate.of(end, "-");

        System.out.print("Cena wycieczki? ");
        double price = scanner.nextInt();

        System.out.print("Wycieczka krajowa/zagraniczna? ");
        String tripType = scanner.next();

        Trip trip = null;
        if (tripType.equals("zagraniczna") ) {
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
        return trip;
    }

    @Override
    public void assign() {
        System.out.print("Imie klienta? ");
        String name = scanner.next();

        Customer customer = travelOffice.findCustomerByName(name);
        if (customer == null) {
            System.out.println("Nie ma klienta o imieniu '" + name + "'\n");
            return;
        }

        System.out.print("Nazwa wycieczki? ");
        String id = scanner.next();

        Trip trip = travelOffice.getTrips().get(id);
        if (trip == null) {
            System.out.println("Nie ma wycieczki o nazwie '" + id + "'\n");
            return;
        }
        customer.assignTrip(trip);
    }

    @Override
    public boolean removeCustomer() {
        System.out.print("Imie klienta do usuniecia? ");
        String customerName = scanner.next();

        Customer c = travelOffice.findCustomerByName(customerName);
        if (c == null) {
            System.out.println("Nie znaleziono takiego klienta\n");
            return false;
        }
        travelOffice.removeCustomer(c);

        System.out.println("Klient usuniety...\n");
        return true;
    }

    @Override
    public boolean removeTrip() {
        System.out.print("Nazwa wycieczki do usuniecia? ");
        String id = scanner.next();
        boolean success = travelOffice.removeTrip(id);
        if (!success) {
            System.out.println("Nie znaleziono wycieczki\n");
            return false;
        }
        System.out.println("Wycieczka zostala usunieta...\n");
        return true;
    }

    @Override
    public void showTrips() {
        System.out.println("Lista wycieczek:");
        for (Map.Entry<String, Trip> entry : travelOffice.getTrips().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    @Override
    public void showCustomers() {
        System.out.println("Lista klientow:");
        System.out.println(travelOffice);
    }

}

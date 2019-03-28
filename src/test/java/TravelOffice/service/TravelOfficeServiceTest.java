package TravelOffice.service;

import TravelOffice.entity.*;
import TravelOffice.exception.NoSuchCustomerException;
import TravelOffice.exception.NoSuchTripException;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TravelOfficeServiceTest {

    TravelOfficeService travelOfficeService = null;
    private Customer customer = null;
    private Address address = null;
    private Trip trip;

    @org.junit.Before
    public void setUp() throws Exception {
        customer = new Customer("Jan Kowalski");
        address = new Address("Opolska 22", "40-091", "Katowice");
        customer.setAddress(address);

        LocalDate start = LocalDate.of(2019, 03, 18);
        LocalDate end = LocalDate.of(2019, 03, 29);
        trip = new DomesticTrip(start, end, "Katowice");
    }

    @org.junit.Test
    public void addCustomer() throws NoSuchCustomerException {
        travelOfficeService = new TravelOfficeService();
        travelOfficeService.addCustomer(customer);

        assertTrue("Cannot add customer", travelOfficeService.findCustomerByName("Jan Kowalski").equals(customer));
    }

    @org.junit.Test
    public void getCustomerCount() {
        travelOfficeService = new TravelOfficeService();
        travelOfficeService.addCustomer(customer);

        assertTrue("No customers!", travelOfficeService.getCustomerCount() == 1);
    }

    @org.junit.Test
    public void addTrip() {
        travelOfficeService = new TravelOfficeService();
        travelOfficeService.addTrip("Kato", trip);

        assertTrue("Cannot add a trip", travelOfficeService.getTrips().containsValue(trip));

    }

    @org.junit.Test
    public void removeTrip() throws NoSuchTripException {
        travelOfficeService = new TravelOfficeService();
        travelOfficeService.addTrip("Kato", trip);

        assertTrue("Cannot delete a tirp", travelOfficeService.removeTrip("Kato"));
    }

    @org.junit.Test
    public void findCustomerByName() throws NoSuchCustomerException {
        travelOfficeService = new TravelOfficeService();
        travelOfficeService.addCustomer(customer);

        assertTrue("Cannot find a customer", travelOfficeService.findCustomerByName("Jan Kowalski").equals(customer));
    }

    @org.junit.Test
    public void removeCustomer() throws NoSuchCustomerException {
        travelOfficeService = new TravelOfficeService();
        travelOfficeService.addCustomer(customer);

        assertTrue("Cannot delete customer", travelOfficeService.removeCustomer(customer));
    }

    @org.junit.Test
    public void getCustomers() {
        travelOfficeService = new TravelOfficeService();
        travelOfficeService.addCustomer(customer);

        assertTrue("Cannot get customers", travelOfficeService.getCustomers().contains(customer));
    }

    @org.junit.Test
    public void getTrips() {
        travelOfficeService = new TravelOfficeService();
        travelOfficeService.addTrip("Kato", trip);

        assertTrue("Cannot get trip", travelOfficeService.getTrips().containsValue(trip));
    }
}
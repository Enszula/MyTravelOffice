package TravelOffice.tf;

import TravelOffice.entity.Customer;
import TravelOffice.entity.Trip;

public interface UserInterface {
        Customer addCustomer();

        Trip addTrip();

        void assign();

        boolean removeCustomer();

        boolean removeTrip();

        void showTrips();

        void showCustomers();
}

package TravelOffice.tf;

import java.util.Scanner;

public class TestMainHandler {
    public static void main(String[] args) {
        // utworz biuro podrozy
        TravelOffice travelOffice = new TravelOffice();
        MainHandler mainHandler = new MainHandler(travelOffice);

        Scanner scanner = new Scanner(System.in);
        top: while (true) {
            System.out.println("SELECT OPTION:");
            System.out.println("1. Dodaj klienta");
            System.out.println("2. Dodaj wycieczke");
            System.out.println("3. Przypisz wycieczke do klienta");
            System.out.println("4. Usun klienta");
            System.out.println("5. Usun wycieczke");
            System.out.println("6. Pokaz klientow");
            System.out.println("7. Pokaz wycieczki");
            System.out.println("0. Wyjscie");
            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.next(); // przeczytanie blednej danej z bufora
                continue;
            }
            switch (choice) {
                case 1:
                    mainHandler.addCustomer();
                    System.out.println();
                    break;
                case 2:
                    mainHandler.addTrip();
                    System.out.println();
                    break;
                case 3:
                    mainHandler.assign();
                    System.out.println();
                    break;
                case 4:
                    mainHandler.removeCustomer();
                    System.out.println();
                    break;
                case 5:
                    mainHandler.removeTrip();
                    System.out.println();
                    break;
                case 6:
                    mainHandler.showCustomers();
                    System.out.println();
                    break;
                case 7:
                    mainHandler.showTrips();
                    System.out.println();
                    break;
                case 0:
                    break top;
                default:
                    break;
            }
        }
        scanner.close();
    }




}

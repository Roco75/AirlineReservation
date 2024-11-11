package AirlineReservation;

import java.util.Scanner;

class InternationalFlight extends Flight {

    @Override
    protected void initializeFlights() {
        // Initialize flights with 200 seats each
        flightDetails.put("IF201 - New Delhi to London", 200);
        flightDetails.put("IF202 - Mumbai to Tokyo", 200);
        flightDetails.put("IF203 - Agra to Sydney", 200);
    }

    public void manageFlights() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- International Flights Module ---");
            System.out.println("1. View International Flights");
            System.out.println("2. Book International Flight");
            System.out.println("3. Cancel International Flight");
            System.out.println("4. Go Back");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewFlights();
                    break;
                case 2:
                    System.out.print("Enter Flight ID to book: ");
                    String bookFlight = scanner.nextLine();
                    bookFlight(bookFlight);
                    break;
                case 3:
                    System.out.print("Enter Flight ID to cancel: ");
                    String cancelFlight = scanner.nextLine();
                    cancelFlight(cancelFlight);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

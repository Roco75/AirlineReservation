package AirlineReservation;

import java.util.Scanner;

public class AirlineReservationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DomesticFlight domesticFlight = new DomesticFlight();
        InternationalFlight internationalFlight = new InternationalFlight();
        int choice;

        // Admin login
        if (loginAsAdmin()) {
            System.out.println("Admin login successful!");
            // Admin menu
            while (true) {
                System.out.println("\n--- Airline Reservation System ---");
                System.out.println("1. Domestic Flights");
                System.out.println("2. International Flights");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        domesticFlight.manageFlights();
                        break;
                    case 2:
                        internationalFlight.manageFlights();
                        break;
                    case 3:
                        System.out.println("Exiting the system.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Admin login failed! Exiting...");
            scanner.close();
        }
    }

    // Admin login method
    public static boolean loginAsAdmin() {
        Scanner scanner = new Scanner(System.in);
        String adminId = "admin";  // hardcoded admin ID
        String adminPassword = "admin1234";  // hardcoded password
        String enteredId, enteredPassword;

        System.out.println("--- Admin Login ---");
        System.out.print("Enter Admin ID: ");
        enteredId = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        enteredPassword = scanner.nextLine();

        // Check if entered credentials match hardcoded ones
        if (enteredId.equals(adminId) && enteredPassword.equals(adminPassword)) {
            return true;  // Login successful
        } else {
            System.out.println("Invalid Admin ID or Password.");
            return false;  // Login failed
        }
    }
}

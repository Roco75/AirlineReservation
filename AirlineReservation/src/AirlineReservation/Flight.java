package AirlineReservation;

import java.util.HashMap;
import java.util.Map;

abstract class Flight {
    // Map to store flight details: flight ID and available seats
    protected Map<String, Integer> flightDetails = new HashMap<>();

    public Flight() {
        initializeFlights();
    }

    // Initialize flights and available seats (max 200 seats)
    protected abstract void initializeFlights();

    // View available flights with their seat availability
    public void viewFlights() {
        if (flightDetails.isEmpty()) {
            System.out.println("No flights are currently available.");
        } else {
            System.out.println("Available Flights (Max seats: 200):");
            for (Map.Entry<String, Integer> entry : flightDetails.entrySet()) {
                String flightId = entry.getKey();
                int availableSeats = entry.getValue();
                System.out.println(flightId + " - Available Seats: " + availableSeats);
            }
        }
    }

    // Book a flight by flight ID, reducing available seats
    public void bookFlight(String flightId) {
        if (flightDetails.containsKey(flightId)) {
            int availableSeats = flightDetails.get(flightId);
            if (availableSeats > 0) {
                flightDetails.put(flightId, availableSeats - 1);  // Reduce available seats by 1
                System.out.println("Flight " + flightId + " booked successfully!");
            } else {
                System.out.println("No available seats for " + flightId);
            }
        } else {
            System.out.println("Flight " + flightId + " is not available.");
        }
    }

    // Cancel a flight, increasing available seats
    public void cancelFlight(String flightId) {
        if (flightDetails.containsKey(flightId)) {
            int availableSeats = flightDetails.get(flightId);
            if (availableSeats < 200) {
                flightDetails.put(flightId, availableSeats + 1);  // Increase available seats by 1
                System.out.println("Flight " + flightId + " cancellation successful!");
            } else {
                System.out.println("Flight " + flightId + " has all seats available, nothing to cancel.");
            }
        } else {
            System.out.println("Flight " + flightId + " was not booked.");
        }
    }
}

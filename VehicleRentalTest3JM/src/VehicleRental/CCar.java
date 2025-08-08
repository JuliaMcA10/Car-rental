package VehicleRental;

/**
 * Represents a car available for rental.
 * Inherits from the CVehicle base class and adds car-specific attributes such as
 * engine type, number of seats, miles per gallon, and model.
 * 
 * This class is used to calculate rental costs and display car specifications.
 * 
 * @author Julia McAllister
 * @since 04-25-2025
 * @version 1.0
 */
public class CCar extends CVehicle {
    private String engineType;
    private int numSeats;
    private double milesPerGallon;
    private String model;

    /**
     * Constructs a CCar object with specific attributes.
     *
     * @param rentalDays       Number of days the car is rented
     * @param engineType       The engine type of the car (e.g., V6, V8)
     * @param numSeats         Number of seats in the car
     * @param milesPerGallon   Fuel efficiency in miles per gallon
     * @param model            The car model (e.g., Honda Civic)
     */
    public CCar(int rentalDays, String engineType, int numSeats, double milesPerGallon, String model) {
        super(rentalDays);
        this.vehicleType = "Car";
        this.rentalRate = 29.99; // Daily rental rate for cars
        this.engineType = engineType;
        this.numSeats = numSeats;
        this.milesPerGallon = milesPerGallon;
        this.model = model;
    }

    /**
     * Calculates the total rental cost for the car.
     * 
     * @return Total rental fee based on the daily rate and number of rental days
     */
    @Override
    public double calculateRental() {
        return rentalDays * rentalRate;
    }

    /**
     * Displays the car's specifications including model, engine type,
     * seating capacity, and fuel efficiency.
     */
    public void displayCarSpecs() {
        System.out.println("Car Model: " + model);
        System.out.println("Engine Type: " + engineType);
        System.out.println("Number of Seats: " + numSeats);
        System.out.println("Miles per Gallon: " + milesPerGallon);
    }

    /**
     * Returns a string representation of the car's specifications.
     * 
     * @return Formatted string of the car's model, engine, seating, and MPG
     */
    @Override
    public String toString() {
        return String.format("Car Model: %s, Engine Type: %s, Seats: %d, MPG: %.2f", 
                model, engineType, numSeats, milesPerGallon);
    }
}





package VehicleRental;

/**
 * Abstract base class representing a general vehicle in the rental system.
 * Stores common properties such as rental days, rental rate, and vehicle type.
 * 
 * This class should be extended by specific vehicle types such as Car, Motorbike, and Trailer.
 * 
 * @author Julia McAllister
 * @since 04-25-2025
 * @version 1.0 
 */
public abstract class CVehicle {
    protected int rentalDays;
    protected double rentalRate;
    protected String vehicleType;

    /**
     * Constructs a CVehicle with the specified number of rental days.
     *
     * @param rentalDays Number of days the vehicle is rented for
     */
    public CVehicle(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    /**
     * Gets the number of days this vehicle is rented for.
     *
     * @return Number of rental days
     */
    public int getRentalDays() {
        return rentalDays;
    }

    /**
     * Gets the rental rate per day for this vehicle.
     *
     * @return Rental rate per day
     */
    public double getRentalRate() {
        return rentalRate;
    }

    /**
     * Gets the type of vehicle (e.g., "Car", "Motorbike", "Trailer").
     *
     * @return The type of vehicle
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * Calculates the total rental cost.
     * This method must be implemented by subclasses.
     *
     * @return Total rental cost
     */
    public abstract double calculateRental();
}


package VehicleRental;

/**
 * Represents a trailer available for rental.
 * Extends the CVehicle class and adds trailer-specific attributes.
 * 
 * Includes cargo capacity and trailer type (e.g., Utility, Flatbed).
 * 
 * @author Julia McAllister
 * @since 04-25-2025
 * @version 1.0
 */
public class CTrailer extends CVehicle {
    private double cargoCapacity;
    private String trailerType;

    /**
     * Constructs a CTrailer object with the specified rental and specification details.
     *
     * @param rentalDays Number of days the trailer is rented
     * @param cargoCapacity Maximum cargo capacity in pounds
     * @param trailerType Type of trailer (e.g., "Utility", "Flatbed")
     */
    public CTrailer(int rentalDays, double cargoCapacity, String trailerType) {
        super(rentalDays);
        this.vehicleType = "Trailer";
        this.rentalRate = 14.99;
        this.cargoCapacity = cargoCapacity;
        this.trailerType = trailerType;
    }

    /**
     * Calculates the total rental cost for the trailer.
     *
     * @return Total rental cost
     */
    @Override
    public double calculateRental() {
        return rentalDays * rentalRate;
    }

    /**
     * Displays the trailer's specifications to the console.
     */
    public void displayTrailerSpecs() {
        System.out.println("Trailer Type: " + trailerType);
        System.out.println("Cargo Capacity: " + cargoCapacity + " lbs");
    }

    /**
     * Returns a string representation of the trailer.
     *
     * @return A string describing the trailer
     */
    @Override
    public String toString() {
        return String.format("Trailer Type: %s, Cargo Capacity: %.2f lbs",
                trailerType, cargoCapacity);
    }
}



package VehicleRental;

/**
 * Represents a motorbike available for rental.
 * Extends the CVehicle class with motorbike-specific details.
 * 
 * Includes engine type, number of wheels, and model.
 * 
 * @author Julia McAllister
 * @since 04-25-2025
 * @version 1.0
 */
public class CMotorbike extends CVehicle {
    private String engineType;
    private int numWheels;
    private String model;

    /**
     * Constructs a CMotorbike object with specific properties.
     *
     * @param rentalDays Number of days the motorbike is rented
     * @param engineType Type of engine (e.g., "Single Cylinder")
     * @param numWheels Number of wheels (typically 2)
     * @param model Model name of the motorbike
     */
    public CMotorbike(int rentalDays, String engineType, int numWheels, String model) {
        super(rentalDays);
        this.vehicleType = "Motorbike";
        this.rentalRate = 19.99;
        this.engineType = engineType;
        this.numWheels = numWheels;
        this.model = model;
    }

    /**
     * Calculates the total rental cost for the motorbike.
     *
     * @return Total rental cost
     */
    @Override
    public double calculateRental() {
        return rentalDays * rentalRate;
    }

    /**
     * Displays the specifications of the motorbike to the console.
     */
    public void displayMotorbikeSpecs() {
        System.out.println("Motorbike Model: " + model);
        System.out.println("Engine Type: " + engineType);
        System.out.println("Number of Wheels: " + numWheels);
    }

    /**
     * Returns a string representation of the motorbike.
     *
     * @return A string describing the motorbike
     */
    @Override
    public String toString() {
        return String.format("Motorbike Model: %s, Engine Type: %s, Wheels: %d",
                model, engineType, numWheels);
    }
}



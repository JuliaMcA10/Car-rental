package VehicleRental;

// Import SQL and utility classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Final project for Java 1 using the Vehicle Rental database.
 * Allows customers to select rental duration, number of vehicles, and choose from available vehicle types.
 * Displays pickup locations from SQL Server database.
 * 
 * Features:
 * - Validates customer information
 * - Allows for the rental of up to 3 vehicles
 * - Calculates rental fees
 * - Supports multiple rental sessions
 * 
 * @author Julia McAllister
 * @since  04-25-2025
 * @version 1.0
 */
public class CVehicleRental {

    /**
     * Main entry point for the vehicle rental program.
     * Handles user input, vehicle selection, rental cost calculation, and looping for multiple rentals.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        displayPickupLocations();
        
        Scanner scanner = new Scanner(System.in);
        boolean continueRenting = true;

        while (continueRenting) {
            // Prompt for customer name
            System.out.print("\nEnter your full name: ");
            String customerName = scanner.nextLine().trim();

            // Prompt and validate phone number
            String phoneNumber;
            do {
                System.out.print("Enter your 10-digit phone number: ");
                phoneNumber = scanner.nextLine().trim();
                if (!isValidPhoneNumber(phoneNumber)) {
                    System.out.println("❌ Invalid phone number. Must be 10 digits.");
                }
            } while (!isValidPhoneNumber(phoneNumber));

            // Prompt and validate email
            String email;
            do {
                System.out.print("Enter your email address: ");
                email = scanner.nextLine().trim();
                if (!isValidEmail(email)) {
                    System.out.println("❌ Invalid email. Must contain '@' and '.'");
                }
            } while (!isValidEmail(email));

            // Prompt and validate rental days
            int rentalDays = readIntegerInRange(scanner, "Enter number of rental days (1–30): ", 1, 30);

            // Prompt and validate number of vehicles
            int numVehicles = readIntegerInRange(scanner, "Enter number of vehicles to rent (1–3): ", 1, 3);

            /**
             * Main area to handle rentals and their info.
             * This holds each subclass of vehicle and their specs
             * 
             */
            
            // Store rented vehicles
            List<CVehicle> rentedVehicles = new ArrayList<>();
            System.out.println("\nSelect " + numVehicles + " vehicle(s) to rent:");

            for (int i = 1; i <= numVehicles; i++) {
                System.out.println("\nVehicle #" + i + ":");
                System.out.println("1. Car ($29.99/day)");
                System.out.println("2. Motorbike ($19.99/day)");
                System.out.println("3. Trailer ($14.99/day)");

                int choice = readIntegerInRange(scanner, "Enter your choice (1-3): ", 1, 3);
                CVehicle vehicle = null;

                switch (choice) {
                    case 1:
                        vehicle = new CCar(rentalDays, "V6", 4, 25.0, "Honda Civic");
                        break;
                    case 2:
                        vehicle = new CMotorbike(rentalDays, "Single Cylinder", 2, "Yamaha R1");
                        break;
                    case 3:
                        vehicle = new CTrailer(rentalDays, 150.0, "Utility");
                        break;
                }

                rentedVehicles.add(vehicle);
            }

            // Display rental summary
            System.out.println("\n--- Rental Summary ---");
            double dblgrandTotal = 0.0;

            for (int i = 0; i < rentedVehicles.size(); i++) {
                CVehicle v = rentedVehicles.get(i);
                double total = v.calculateRental();

                // Display specifications based on vehicle type
                if (v instanceof CCar) {
                    ((CCar) v).displayCarSpecs();
                } else if (v instanceof CMotorbike) {
                    ((CMotorbike) v).displayMotorbikeSpecs();
                } else if (v instanceof CTrailer) {
                    ((CTrailer) v).displayTrailerSpecs();
                }

                System.out.printf("Vehicle #%d: %s - $%.2f (%d days @ $%.2f/day)%n",
                        i + 1, v.getVehicleType(), total, v.getRentalDays(), v.getRentalRate());
                dblgrandTotal += total;
            }

            System.out.printf("\nTOTAL RENTAL COST: $%.2f%n", dblgrandTotal);

            // Display customer summary
            System.out.println("\n✅ Thank you! Your info has been recorded:");
            System.out.println("Name: " + customerName);
            System.out.println("Phone: " + phoneNumber);
            System.out.println("Email: " + email);
            System.out.println("Rental Days: " + rentalDays);
            System.out.println("Vehicles to Rent: " + numVehicles);

            // Ask for repeat
            String response;
            do {
                System.out.print("\nWould you like to rent another set of vehicles? (yes/no): ");
                response = scanner.nextLine().trim().toLowerCase();
            } while (!response.equals("yes") && !response.equals("no"));

            if (response.equals("no")) {
                continueRenting = false;
            }
        }

        System.out.println("\nThank you for using our vehicle rental service!");
        scanner.close();
    }

    /**
     * Validates that the phone number is exactly 10 digits.
     * 
     * @param phone Phone number string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\d{10}");
    }

    /**
     * Validates that the email address contains "@" and ".".
     * 
     * @param email Email address string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    /**
     * Reads and validates an integer input within a specified range.
     * 
     * @param scanner Scanner for user input
     * @param prompt Message to display to the user
     * @param min Minimum valid value
     * @param max Maximum valid value
     * @return A valid integer entered by the user
     */
    public static int readIntegerInRange(Scanner scanner, String prompt, int min, int max) {
        int value = -1;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (value >= min && value <= max) {
                    valid = true;
                } else {
                    System.out.println("❌ Value must be between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("❌ Please enter a valid integer.");
                scanner.nextLine(); // discard invalid input
            }
        }
        return value;
    }

    /**
     * Connects to the database and displays pickup locations from the TLocations table.
     * Uses integrated security to connect to SQL Server.
     * I attempted the required method but I couldn't figure it out.
     * I understand this will make it hard to test and I will lose points but I was struggling and just wanted something that I could see work.
     * I also understand this isn't the standard but again without this method I wasn't able to test anything.
     * I am hoping with your set up if you replace my personally relevant info with that of your own that it will run for you.
     */
    public static void displayPickupLocations() {
        String connectionUrl = "jdbc:sqlserver://JULIASPC:1433;databaseName=dbVehicleRental;integratedSecurity=true;trustServerCertificate=true;";

        try (
            Connection conn = DriverManager.getConnection(connectionUrl);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "SELECT intLocationID, strLocationName, strAddress, strCity, strState, strZip FROM TLocations";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.printf("%-4s %-12s %-20s %-15s %-5s %-6s%n",
                "ID", "Location", "Address", "City", "State", "Zip");
            System.out.println("--------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-4d %-12s %-20s %-15s %-5s %-6s%n",
                    rs.getInt("intLocationID"),
                    rs.getString("strLocationName"),
                    rs.getString("strAddress"),
                    rs.getString("strCity"),
                    rs.getString("strState"),
                    rs.getString("strZip"));
            }

            rs.close();
        } catch (Exception e) {
            System.out.println("Error connecting to database or fetching data.");
            e.printStackTrace();
        }
    }
}


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * TravelPlanner - A utility to help travelers plan their trips
 * This class provides functionality to:
 * 1. Calculate the duration of a trip
 * 2. Validate travel dates
 * 3. Calculate check-in and check-out dates
 * 4. Check if a trip overlaps with holidays
 */
public class TravelPlanner {
    
    // Step 1: Declare a DateTimeFormatter for the standard date format "dd/MM/yyyy"
    // Hint: Use DateTimeFormatter.ofPattern()
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    /**
     * Calculates the duration of a trip in days
     * @param departureDate The date of departure
     * @param returnDate The date of return
     * @return The number of days between departure and return
     */
    public static long calculateTripDuration(LocalDate departureDate, LocalDate returnDate) { // Método para calcular a duração da viagem
        // Step 2: Calculate and return the number of days between departure and return dates
        // Hint: Use ChronoUnit.DAYS.between()
        return ChronoUnit.DAYS.between(departureDate, returnDate);
    }
    
    /**
     * Validates that the provided dates make logical sense for a trip
     * @param departureDate The date of departure
     * @param returnDate The date of return
     * @return true if dates are valid, false otherwise
     */
    public static boolean validateTravelDates(@NotNull LocalDate departureDate, LocalDate returnDate) { // Método para validar as datas de viagem
        // Step 3: Implement validation logic:
        // - Departure date should not be in the past
        // - Return date should be after departure date
        // - Trip should not be longer than 90 days
        // Hint: Use LocalDate.now() for current date and various comparison methods
        if (departureDate.isBefore(LocalDate.now()) || returnDate.isBefore(departureDate) || ChronoUnit.DAYS.between(departureDate, returnDate) > 90) {
            return false;
        }
        return true; // Replace with actual validation
    }
    
    /**
     * Calculates hotel check-in and check-out dates based on travel dates
     * @param departureDate The date of departure
     * @param returnDate The date of return
     * @return A string containing the check-in and check-out dates
     */
    @Contract(pure = true)
    public static @NotNull String calculateHotelDates(LocalDate departureDate, LocalDate returnDate) { // Método para calcular as datas do hotel
        // Step 4: Calculate hotel dates:
        // - Check-in is usually the same day as departure
        // - Check-out is usually the same day as return
        // Hint: Format the dates using the formatter declared in Step 1

        String checkInDate = departureDate.format(DATE_FORMATTER);
        String checkOutDate = returnDate.format(DATE_FORMATTER);

        return checkInDate + " - " + checkOutDate; // Replace with actual calculation
    }
    
    /**
     * Checks if a trip overlaps with a specific holiday
     * @param departureDate The date of departure
     * @param returnDate The date of return
     * @param holidayDate The date of the holiday
     * @return true if the trip overlaps with the holiday, false otherwise
     */
    public static boolean tripOverlapsHoliday(LocalDate departureDate, LocalDate returnDate, LocalDate holidayDate) {
        // Step 5: Check if the holiday date falls between departure and return dates
        // Hint: Use isAfter() and isBefore() methods or similar
        if ((holidayDate.isEqual(departureDate) || holidayDate.isAfter(departureDate)) &&
            (holidayDate.isEqual(returnDate) || holidayDate.isBefore(returnDate))) {
            return true;
        }
        
        return false; // Replace with actual check
    }
    
    /**
     * Main method to run the TravelPlanner application
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Step 6: Implement a menu-driven interface allowing the user to:
        // - Enter departure and return dates
        // - Calculate trip duration
        // - Validate travel dates
        // - Calculate hotel check-in and check-out dates
        // - Check if trip overlaps with holidays
        System.out.println("Bem-vindo ao Planejador de Viagens!");
        System.out.print("Digite a data de partida (dd/MM/yyyy): ");
        String departureInput = scanner.nextLine();
        System.out.print("Digite a data de retorno (dd/MM/yyyy): ");
        String returnInput = scanner.nextLine();
        System.out.print("Digite a data do feriado (dd/MM/yyyy): ");
        String holidayInput = scanner.nextLine();
        // Step 7: Use try-catch blocks to handle invalid date inputs
        // Hint: Catch DateTimeParseException for invalid date formats
        try {
            LocalDate departureDate = LocalDate.parse(departureInput, DATE_FORMATTER);
            LocalDate returnDate = LocalDate.parse(returnInput, DATE_FORMATTER);
            LocalDate holidayDate = LocalDate.parse(holidayInput, DATE_FORMATTER);

            if (!validateTravelDates(departureDate, returnDate)) {
                System.out.println("Datas de viagem inválidas. Verifique as datas e tente novamente.");
            } else {
                long duration = calculateTripDuration(departureDate, returnDate);
                System.out.println("Duração da viagem: " + duration + " dias");

                String hotelDates = calculateHotelDates(departureDate, returnDate);
                System.out.println("Datas do hotel: " + hotelDates);

                if (tripOverlapsHoliday(departureDate, returnDate, holidayDate)) {
                    System.out.println("A viagem coincide com o feriado.");
                } else {
                    System.out.println("A viagem não coincide com o feriado.");
                }
            }
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. Por favor, use o formato dd/MM/yyyy.");
        }

        scanner.close();
        System.out.println("Obrigado por usar o Planejador de Viagens!");
    }
    // Step 8: Display appropriate messages to the user based on the operations performed

}

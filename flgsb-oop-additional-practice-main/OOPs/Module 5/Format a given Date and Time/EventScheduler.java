// EventScheduler.java

import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class EventScheduler {
    private List<Event> events;
    private Scanner scanner;

    public EventScheduler() {
        // Step 7: Initialize the events list and scanner
        events = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            // Step 8: Display menu options
            System.out.println("\n=== Lista de Eventos ===");
            System.out.println("1. Adicionar Evento");
            System.out.println("2. Mostrar Todos os Eventos");
            System.out.println("3. Mostrar Tempo até o Evento");
            System.out.println("4. Converter Hora do Evento");
            System.out.println("5. Encontrar Eventos Próximos");
            System.out.println("6. Exit");
            System.out.print("Insira a sua escolha: ");

            int choice = Integer.parseInt(scanner.nextLine());

            // Step 9: Implement menu choices using switch-case
            switch (choice) {
                case 1: // Adiciona evento
                    // Call method to add event
                    addEvent();
                    break;
                case 2: // Mostra todos os eventos
                    // Call method to display all events
                    displayAllEvents();
                    break;
                case 3: // Mostra tempo até o evento
                    // Call method to show time until event
                    showTimeUntilEvent();
                    break;
                case 4: // Converte hora do evento
                    // Call method to convert event time
                    convertEventTime();
                    break;
                case 5: // Encontra eventos próximos
                    // Call method to find upcoming events
                    findUpcomingEvents();
                    break;
                case 6: // Sai da lista de eventos
                    running = false;
                    System.out.println("Saindo da Lista de eventos!");
                    scanner.close();
                    break;
                default:
                    System.out.println("Escolha inválida! Tente novamente.");
            }
        }
    }

    private void addEvent() { // Método para adicionar evento
        // Step 10: Implement method to get event details from user and create a new Event
        // Hint: Get name, date, time, duration, and timezone from user
        // Parse the date and time strings into LocalDateTime
        // Get a ZoneId from the timezone string
        // Create a ZonedDateTime from LocalDateTime and ZoneId
        // Create a Duration object from hours and minutes
        // Create a new Event object and add it to the events list
        try {
            System.out.println("Insira o nome do evento:");
            String name = scanner.nextLine();
            System.out.println("Insira a data do evento (dd/MM/yyyy):");
            String dateStr = scanner.nextLine();
            System.out.println("Insira a hora do evento (HH:mm):");
            String timeStr = scanner.nextLine();
            System.out.println("Insira a duração do evento (horas:minutos):");
            int durationMinutes = Integer.parseInt(scanner.nextLine());
            System.out.println("Insira o fuso horário do evento:");
            String timezone = scanner.nextLine();

            LocalDateTime localDateTime = LocalDateTime.parse(dateStr + " " + timeStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(timezone));
            Duration duration = Duration.ofMinutes(durationMinutes);

            Event event = new Event(name, zonedDateTime, duration, timezone);
            events.add(event);

            System.out.println("Evento adicionado com sucesso!");
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data/hora inválido. Tente novamente.");
        } catch (NumberFormatException e) {
            System.out.println("Formato de duração inválido. Tente novamente.");
        }
        catch (Exception e) {
            System.out.println("Erro ao adicionar evento: " + e.getMessage());
        }
    }

    private void displayAllEvents() { // Método para mostrar todos os eventos
        // Step 11: Implement method to display all events
        // Hint: Get format pattern from user
        // Loop through events list and display each event with the specified format
        System.out.println("Insira o formato de data e hora:");
        String pattern = scanner.nextLine();
        for (Event event : events) {
            System.out.println(event.getName() + ": " + event.formatEventDate(pattern));
        }

    }

    private void showTimeUntilEvent() { // Método para mostrar tempo até o evento
        // Step 12: Implement method to calculate and display time until a specific event
        // Hint: Show list of events with numbers
        // Get event selection from user
        // Calculate and display time until the selected event
        if (events.isEmpty()) {
            System.out.println("Nenhum evento disponível.");
            return;
        }

        // Mostrar eventos
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getName());
        }

        try {
            System.out.println("Selecione o evento um evento: ");
            int eventSelection = Integer.parseInt(scanner.nextLine());

            if (eventSelection < 0 || eventSelection >= events.size()) {
                System.out.println("Seleção inválida.");
                return;
            }

            Event selectedEvent = events.get(eventSelection);
            Duration timeUntil = selectedEvent.timeUntilEvent();

            System.out.println("Tempo até o evento: " + formatDuration(timeUntil));

        } catch (NumberFormatException e) {
            System.out.println("Seleção inválida.");
        }
    }

    private @NotNull String formatDuration(Duration duration) {
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;

        if (duration.isNegative()) {
            return "O evento já ocorreu.";
        }

        return String.format("%d dias, %d horas, %d minutos", days, hours, minutes);
    }

    private void convertEventTime() { // Método para converter hora do evento
        // Step 13: Implement method to convert event time to a different timezone
        // Hint: Show list of events with numbers
        // Get event selection from user
        // Get target timezone from user
        // Convert and display event time in the target timezone
        System.out.println("Selecione o evento:");
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getName());
        }
        int eventSelection = Integer.parseInt(scanner.nextLine());
        System.out.println("Insira o fuso horário alvo:");
        String targetTimezone = scanner.nextLine();
        ZonedDateTime convertedTime = events.get(eventSelection - 1).convertToTimezone(targetTimezone);
        System.out.println("Hora do evento no fuso horário alvo: " + convertedTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
    }

    private void findUpcomingEvents() { // Método para encontrar eventos próximos
        // Step 14: Implement method to find events within a specific number of days
        // Hint: Get number of days from user
        // Loop through events and display those within the specified days
        System.out.println("Insira o número de dias para encontrar eventos próximos:");
        int days = Integer.parseInt(scanner.nextLine());
        ZonedDateTime now = ZonedDateTime.now();
        for (Event event : events) {
            Duration durationUntil = Duration.between(now, event.getDateTime());
            if (durationUntil.toDays() <= days && durationUntil.toDays() >= 0) {
                System.out.println(event.getName() + ": " + event.formatEventDate("dd/MM/yyyy HH:mm"));
            }
        }
    }

    public static void main(String[] args) {
        // Step 15: Create an EventScheduler object and call its run method
        EventScheduler scheduler = new EventScheduler();
        scheduler.run();
    }
}

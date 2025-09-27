// ContactReader.java
// This program reads contact information from a file and displays it in a formatted way

// Step 1: Import necessary packages for file I/O operations
// Hint: You'll need classes from java.io or java.nio.file packages
// You'll also need Scanner for user input

import java.io.*; // Importando pacote java.io
import java.util.Scanner;

public class ContactReader {
    public static void main(String[] args) {
        // Step 2: Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Step 3: Prompt the user to enter the file name containing contacts
        // Example: "Enter the name of the contacts file:
        System.out.println("Insira o nome do arquivo de contatos:");

        // Step 4: Read the file name entered by the user
        String fileName = scanner.nextLine();

        int contactCount = 0; // Contador de contatos

        try {
            // Step 5: Create a FileReader or similar object to read the file
            // Hint: You can use FileReader, BufferedReader, or Files class
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            // Step 6: Read the file line by line
            // Hint: Use a loop to process each line
            String line;
            while ((line = reader.readLine()) != null) {
                // Step 7: Parse each line to extract name and phone number
                // Hint: Use String methods like split() to separate by colon
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String phoneNumber = parts[1].trim();
                    // Step 8: Display the contact information in a formatted way
                    // Example: "Contact: John Doe | Phone: +1-555-123-4567
                    System.out.println("Contato: " + name + " | Telefone: " + phoneNumber);
                    contactCount++; // Incrementa o contador de contatos
                } else {
                    System.out.println("Formato de linha inválido: " + line);
                }
            }

            // Step 9: Close the file reader when done
            reader.close();

        }// Step 10: Handle exceptions appropriately
        // Display a user-friendly error message
        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + fileName);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Optional Bonus:
        // Step 11: Add a feature to count and display the total number of contacts read
        System.out.println("\n=== RESUMO ===");
        System.out.println("Total de contatos lidos: " + contactCount);

        scanner.close();
        System.out.println("Leitura de contatos concluída.");
    }
}

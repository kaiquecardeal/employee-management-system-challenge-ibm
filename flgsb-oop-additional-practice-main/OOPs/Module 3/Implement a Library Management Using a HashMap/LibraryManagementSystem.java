import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class LibraryManagementSystem {
    // Book class to represent book information
    static class Book {
        // Step 1: Declare variables for title, author, genre, and publication year
        // Hint: Use appropriate data types (String for text, int for year)
        private String title;
        private String author;
        private String genre;
        private int publicationYear;

        // Step 2: Create a constructor for the Book class
        // Hint: The constructor should take parameters for all book attributes
        public Book(String title, String author, String genre, int publicationYear) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.publicationYear = publicationYear;
        }

        // Step 3: Create getter methods for each attribute
        // Hint: Use the format: public dataType getAttribute()
        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getGenre() {
            return genre;
        }

        public int getPublicationYear() {
            return publicationYear;
        }

        // Step 4: Create a method to display book details
        // Hint: Return a formatted string with all book information
        @Override
        public String toString() { // Método para mostrar os detalhes do livro
            return "Title: " + title + "\nAuthor: " + author + "\nGenre: " + genre + "\nPublication Year: " + publicationYear;
        }
    }

    // Method to validate if the title and author have valid formats
    private static boolean isValidText(String text) { // Método para validar se o texto não está vazio
        // Step 5: Implement validation to ensure text isn't empty
        // Hint: Check if the string is null, empty, or only whitespace
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        return true; // Substitua isso pela sua implementação
    }

    // Method to validate publication year
    private static boolean isValidYear(int year) { // Método para validar o ano de publicação
        // Step 6: Implement validation for publication year
        // Hint: Check if the year is reasonable (e.g., between 1000 and current year)
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        if (year < 1000 || year > currentYear) {
            return false;
        }
        return true; // Replace this with your implementation
    }

    private static void displayMenu() { // Método para exibir o menu
        System.out.println(" Menu: \n" + "1. Adicionar livro\n" + "2. Mostrar todos os livros\n" + "3. Procurar livro pelo título\n" + "4. Fazer check-out de um livro\n" + "5. Devolver um livro\n" + "6. Ordenar livros\n" + "7. Mostrar livros disponíveis\n" + "8. Sair");
        System.out.println("Escolha uma opção: ");
    }

    public static void main(String[] args) {
        // Step 7: Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Step 8: Create a HashMap to store books (with ISBN as the key)
        // Hint: Use HashMap<String, Book>
        HashMap<String, Book> library = new HashMap<>(); // HashMap para armazenar os livros
        HashMap<String, Book> checkedOutBooks = new HashMap<>(); // HashMap para armazenar os livros emprestados

        // Step 9: Implement the main loop with menu options
        // Hint: Options should include adding a book, viewing all books, 
        // searching for books, removing a book, viewing sorted books, and exiting
        while (true) { // Loop principal do menu
            displayMenu();
            // Step 10: Implement the "Add a book" option
            // Hint: Prompt user for book details (ISBN, title, author, genre, year)
            // Validate input and add to the HashMap

            // Step 11: Implement the "View all books" option
            // Hint: Iterate through the HashMap and display all books

            // Step 12: Implement the "Search for a book" option
            // Hint: Allow searching by ISBN, title or author

            // Step 13: Implement the "Remove a book" option
            // Hint: Remove a book from the collection using its ISBN

            // Step 14: Implement the "View sorted books" option
            // Hint: Use TreeMap to sort books by title or author
            int choice = scanner.nextInt();
            scanner.nextLine(); // Lê a escolha do usuário
            switch (choice) { // Tratamento das opções do menu
                case 1: // Adicionar livro
                    System.out.println("Insira o ISBN do livro:");
                    String isbn = scanner.nextLine();
                    if (library.containsKey(isbn)) {
                        System.out.println("Um livro com este ISBN já existe.");
                        break;
                    }
                    System.out.println("Insira o título do livro:");
                    String title = scanner.nextLine();
                    if (!isValidText(title)) {
                        System.out.println("Título inválido.");
                        break;
                    }
                    System.out.println("Insira o autor do livro:");
                    String author = scanner.nextLine();
                    if (!isValidText(author)) {
                        System.out.println("Autor inválido.");
                        break;
                    }
                    System.out.println("Insira o gênero do livro:");
                    String genre = scanner.nextLine();
                    if (!isValidText(genre)) {
                        System.out.println("Gênero inválido.");
                        break;
                    }
                    System.out.println("Insira o ano do livro:");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    if (!isValidYear(year)) {
                        System.out.println("Ano inválido.");
                        break;
                    }
                    if (library.containsKey(isbn)) {
                        System.out.println("Livro já existe na biblioteca.");
                        break;
                    }
                    Book newBook = new Book(title, author, genre, year);
                    library.put(isbn, newBook);
                    System.out.println("Livro adicionado com sucesso.");
                    System.out.println("Total de livros na biblioteca: " + library.size());
                    break;
                case 2: // Mostrar todos os livros
                    if (library.isEmpty() && checkedOutBooks.isEmpty()) {
                        System.out.println("Nenhum livro na biblioteca.");
                    } else {
                        System.out.println("=== Livros disponíveis na biblioteca ===");
                        if (library.isEmpty()) {
                            System.out.println("Nenhum livro disponível.");
                        } else {
                            for (Map.Entry<String, Book> entry : library.entrySet()) {
                                System.out.println("ISBN: " + entry.getKey());
                                System.out.println(entry.getValue());
                                System.out.println("---------------------");
                            }
                        }

                        System.out.println("\n=== Livros emprestados ===");
                        if (checkedOutBooks.isEmpty()) {
                            System.out.println("Nenhum livro emprestado.");
                        } else {
                            for (Map.Entry<String, Book> entry : checkedOutBooks.entrySet()) {
                                System.out.println("ISBN: " + entry.getKey());
                                System.out.println(entry.getValue());
                            }
                        }
                    }
                    break;
                case 3: // Procurar livro
                    System.out.println("Insira o ISBN do livro para procurar:");
                    String searchIsbn = scanner.nextLine();
                    if (library.containsKey(searchIsbn)) {
                        System.out.println("Livro encontrado:");
                        System.out.println(library.get(searchIsbn));
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 4: // Fazer check-out de um livro
                    System.out.println("Insira o ISBN do livro para fazer check-out:");
                    String checkoutIsbn = scanner.nextLine();
                    if (library.containsKey(checkoutIsbn)) {
                        Book book = library.get(checkoutIsbn);
                        checkedOutBooks.put(checkoutIsbn, book);
                        library.remove(checkoutIsbn);
                        System.out.println("Livro check-out realizado com sucesso: " + book.getTitle());
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 5: // Devolver um livro
                    System.out.println("Insira o ISBN do livro para devolver:");
                    String returnIsbn = scanner.nextLine();
                    if (checkedOutBooks.containsKey(returnIsbn)) {
                        Book book = checkedOutBooks.get(returnIsbn);
                        library.put(returnIsbn, book);
                        checkedOutBooks.remove(returnIsbn);
                        System.out.println("Livro devolvido com sucesso: " + book.getTitle());
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 6: // Ordenar livros
                    if (library.isEmpty()) {
                        System.out.println("Nenhum livro na biblioteca para ordenar.");
                    } else {
                        TreeMap<String, Book> sortedLibrary = new TreeMap<>(library);
                        for (Map.Entry<String, Book> entry : sortedLibrary.entrySet()) {
                            System.out.println("ISBN: " + entry.getKey());
                            System.out.println(entry.getValue());
                            System.out.println("---------------------");
                        }
                    }
                    break;
                case 7: // Listar todos os livros
                    if (library.isEmpty()) {
                        System.out.println("Nenhum livro disponível.");
                    } else {
                        System.out.println("=== Livros Disponíveis para emprestimo===");
                        for (Map.Entry<String, Book> entry : library.entrySet()) {
                            System.out.println("ISBN: " + entry.getKey());
                            System.out.println(entry.getValue());
                            System.out.println("---------------------");
                        }
                    }
                    break;
                case 8: // Sair do sistema
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    return;
            }
        }
    }
}

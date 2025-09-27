import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// LibraryManagement class to manage the book collection
public class LibraryManagement {
    //Step 13: Create additional helper methods as needed
    // Examples: findBookByTitle(), findBookByIndex(), etc.
    public static Book findBookByTitle(ArrayList<Book> books, String title) {
        for (Book book : books) {
            if (book.getBookTitle().equalsIgnoreCase(title)) {
                return book; // Retorna o livro se encontrado
            }
        }
        return null; // Retorna null se o livro não for encontrado
    }

    public static Book findBookByIndex(ArrayList<Book> books, int index) {
        if (index >= 0 && index < books.size()) {
            return books.get(index); // Retorna o livro se o índice for válido
        }
        return null; // Retorna null se o índice for inválido
    }

    public static void displayMenu() {
        System.out.println(" Menu: \n" +
                "1. Adicionar livro\n" +
                "2. Mostrar todos os livros\n" +
                "3. Procurar livro pelo título\n" +
                "4. Fazer check-out de um livro\n" +
                "5. Devolver um livro\n" +
                "6. Ordenar livros\n" +
                "7. Mostrar livros disponíveis\n" +
                "8. Sair");
        System.out.println("Escolha uma opção: ");
    }

    public static boolean isValidIndex(ArrayList<Book> books, int index) {
        return index >= 0 && index < books.size();
    }

    public static void main(String[] args) {
        // Step 1: Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Step 2: Create an ArrayList to store Book objects
        // Hint: Use ArrayList<Book>
        ArrayList<Book> books = new ArrayList<>();

        // Step 3: Implement a menu-driven program with the following options:
        // 1. Add a book
        // 2. View all books
        // 3. Search for a book by title
        // 4. Check out a book
        // 5. Return a book
        // 6. Sort books (by title, author, or publication year)
        // 7. View available books only
        // 8. Exit
        // Step 4: Create the main menu loop
        // Hint: Use a while loop with a boolean flag or a while(true) with a break

        // Step 5: Implement case handling for each menu option
        // Hint: Use switch-case or if-else if statements

        // Step 6: Implement the addBook functionality
        // Hint: Prompt the user for title, author, and publication year

        // Step 7: Implement the viewAllBooks functionality
        // Hint: Use a loop or forEach to display all books

        // Step 8: Implement the search functionality
        // Hint: Take user input for search term and check each book

        // Step 9: Implement the checkOut functionality
        // Hint: Find the book by index and use the checkOut() method

        // Step 10: Implement the returnBook functionality
        // Hint: Find the book by index and use the returnBook() method

        // Step 11: Implement the sortBooks functionality
        // Hint: Use Collections.sort() with a Comparator

        // Step 12: Implement the viewAvailableBooks functionality
        // Hint: Use ArrayList's stream() or loop through to filter
        while (true) {
            displayMenu(); // Exibe o menu
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner
            if (choice == 8) {
                break; // Sai do loop se a opção for 8
            }
            switch (choice) {
                case 1: // Adicionar livro
                    if (books.size() >= 100) {
                        System.out.println("Capacidade máxima de livros atingida! Não é possível adicionar mais livros.");
                        break; // Sai do case se a capacidade máxima for atingida
                    }
                    System.out.print("Título: ");
                    String title = scanner.nextLine();
                    System.out.print("Autor: ");
                    String author = scanner.nextLine();
                    System.out.print("Ano de publicação: ");
                    int year = scanner.nextInt();
                    books.add(new Book(title, author, year));
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                case 2: // Mostrar todos os livros
                    if (books.isEmpty()) {
                        System.out.println("Nenhum livro disponível.");
                    } else {
                        System.out.println("Lista de todos os livros:");
                        for (Book book : books) {
                            System.out.println(book); // Usa o método toString() da classe Book
                        }
                    }
                    break;
                case 3: // Procurar livro pelo título
                    System.out.println("Digite o título do livro para procurar: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = findBookByTitle(books, searchTitle); // Usando o método auxiliar
                    if (foundBook != null) {
                        System.out.println("Livro encontrado: " + foundBook);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 4: // Fazer check-out de um livro
                    if (books.isEmpty()) {
                        System.out.println("Nenhum livro disponível para check-out.");
                        break;
                    }
                    System.out.println("Digite o índice do livro para fazer check-out (0 a " + (books.size() - 1) + "): ");
                    int checkoutIndex = scanner.nextInt();

                    if (isValidIndex(books, checkoutIndex)) {
                        Book bookToCheckout = findBookByIndex(books, checkoutIndex); // Usando o método auxiliar
                        if (bookToCheckout.checkOut()) {
                            System.out.println("Check-out realizado com sucesso: " + bookToCheckout);
                        } else {
                            System.out.println("Falha no check-out, o livro não está disponível.");
                        }
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 5: // Devolver um livro
                    if (books.isEmpty()) {
                        System.out.println("Nenhum livro disponível para devolução.");
                        break;
                    }
                    System.out.println("Digite o índice do livro para devolver (0 a " + (books.size() - 1) + "): ");
                    int returnIndex = scanner.nextInt();

                    if (isValidIndex(books, returnIndex)) {
                        Book bookToReturn = findBookByIndex(books, returnIndex); // Usando o método auxiliar
                        if (bookToReturn.returnBook()) {
                            System.out.println("Livro devolvido com sucesso: " + bookToReturn);
                        } else {
                            System.out.println("Falha na devolução, o livro já estava disponível.");
                        }
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 6: // Ordenar livros
                    System.out.println("Ordenar por: \n" +
                            "1. Título\n" +
                            "2. Autor\n" +
                            "3. Ano de publicação");
                    int sortChoice = scanner.nextInt();
                    switch (sortChoice) { // Sub-menu para opções de ordenação
                        case 1: // Ordenar por título
                            Collections.sort(books, Comparator.comparing(Book::getBookTitle));
                            System.out.println("Livros ordenados por título.");
                            break;
                        case 2: // Ordenar por autor
                            Collections.sort(books, Comparator.comparing(Book::getAuthor));
                            System.out.println("Livros ordenados por autor.");
                            break;
                        case 3: // Ordenar por ano de publicação
                            Collections.sort(books, Comparator.comparingInt(Book::getPublicationYear));
                            System.out.println("Livros ordenados por ano de publicação.");
                            break;
                        default:
                            System.out.println("Opção de ordenação inválida!");
                            break;
                    }
                    break;
                case 7: // Mostrar livros disponíveis
                    System.out.println("Livros disponíveis:");
                    boolean anyAvailable = false;
                    for (Book book : books) {
                        if (book.isAvailable()) {
                            System.out.println(book);
                            anyAvailable = true;
                        }
                    }
                    if (!anyAvailable) {
                        System.out.println("Nenhum livro disponível.");
                    }
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
            System.out.println(); // Linha em branco para melhor formatação
        }
    }

}

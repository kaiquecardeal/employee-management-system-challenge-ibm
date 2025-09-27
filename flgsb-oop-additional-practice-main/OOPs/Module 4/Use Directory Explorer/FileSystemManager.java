import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileSystemManager - A command-line file management system
 * <p>
 * This class provides a shell-like interface for managing files and directories
 */
public class FileSystemManager { // Classe principal

    // The current working directory
    private File currentDirectory;

    // Scanner for user input
    private Scanner scanner;

    // Date formatter for file timestamps
    private SimpleDateFormat dateFormat;

    /**
     * Constructor to initialize the file system manager
     */
    public FileSystemManager() { // Construtor
        // TODO: Initialize the current directory to the user's current directory
        // Hint: Use System.getProperty("user.dir") to get the current working directory
        currentDirectory = new File(System.getProperty("user.dir")); // Inicializa o diretório atual

        // TODO: Initialize the scanner for reading user input
        scanner = new Scanner(System.in);

        // TODO: Initialize the date formatter for displaying timestamps
        // Hint: Use "yyyy-MM-dd HH:mm:ss" as the date format pattern
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Formato de data
    }

    /**
     * Start the file system manager
     */
    public void start() { // Inicia o gerenciador de arquivos
        System.out.println("Bem-vindo ao File System Manager!");
        System.out.println("Digite 'help' para ver os comandos disponíveis.");

        boolean running = true;
        while (running) {
            // TODO: Display the current directory path as a prompt
            System.out.print(currentDirectory.getAbsolutePath() + " > ");

            // TODO: Read user command
            String command = scanner.nextLine();

            // TODO: Process the command
            // If command is "exit", set running to false
            // Otherwise, call processCommand() method
            running = processCommand(command);

        }

        // TODO: Close the scanner before exiting
        scanner.close();
        System.out.println("Saindo do File System Manager. Até logo!");
    }

    /**
     * Process a user command
     *
     * @param command The command entered by the user
     * @return true to continue, false to exit
     */

    private boolean processCommand(@NotNull String command) { // Processa o comando do usuário
        // Split the command into parts (command name and arguments)
        String[] parts = command.trim().split("\\s+", 2);
        String commandName = parts[0].toLowerCase();
        String args = (parts.length > 1) ? parts[1] : "";

        switch (commandName) {
            case "help": // Exibe a ajuda
                displayHelp();
                break;
            case "ls": // Lista os arquivos e diretórios
                // TODO: Implement listing files and directories
                listFiles();
                break;
            case "cd": // Altera o diretório atual
                // TODO: Implement changing directories
                // Hint: Handle "cd .." (parent directory) and "cd directoryName"
                changeDirectory(args);
                break;
            case "pwd": // Exibe o diretório atual
                // TODO: Implement displaying current directory path
                System.out.println(currentDirectory.getAbsolutePath());
                break;
            case "mkdir": // Cria um novo diretório
                // TODO: Implement creating a new directory
                createDirectory(args);
                break;
            case "touch": // Cria um novo arquivo
                // TODO: Implement creating a new file
                createFile(args);
                break;
            case "rm": // Remove um arquivo ou diretório
                // TODO: Implement deleting a file or directory
                delete(args);
                break;
            case "rename": // Renomeia um arquivo ou diretório
                // TODO: Implement renaming a file or directory
                // Hint: The args will contain both old and new names
                String[] renameParts = args.split("\\s+", 2);
                if (renameParts.length == 2) {
                    rename(renameParts[0], renameParts[1]);
                } else {
                    System.out.println("Usage: rename <oldName> <newName>");
                }
                break;
            case "find": // Procura arquivos por padrão de nome
                // TODO: Implement searching for files by name pattern
                findFiles(args);
                break;
            case "info": // Exibe informações sobre um arquivo
                // TODO: Implement displaying file information
                displayFileInfo(args);
                break;
            case "exit": // Sai do gerenciador de arquivos
                return false;
            default:
                System.out.println("Comando desconhecido.");
        }

        return true;
    }

    /**
     * Display help information
     */
    private void displayHelp() { // Exibe a ajuda
        System.out.println("Comandos disponíveis:");
        System.out.println("help               - Exibe esta mensagem de ajuda");
        System.out.println("ls                 - Lista arquivos e diretórios");
        System.out.println("cd <dir>          - Muda para o diretório especificado");
        System.out.println("pwd                - Exibe o caminho do diretório atual");
        System.out.println("mkdir <dir>       - Cria um novo diretório");
        System.out.println("touch <file>      - Cria um novo arquivo");
        System.out.println("rm <name>         - Deleta um arquivo ou diretório");
        System.out.println("rename <old> <new> - Renomeia um arquivo ou diretório");
        System.out.println("find <pattern>    - Procura arquivos por padrão de nome");
        System.out.println("info <file>       - Exibe informações detalhadas sobre um arquivo");
        System.out.println("exit              - Sai do gerenciador de arquivos");
    }

    /**
     * List files and directories in the current directory
     */
    private void listFiles() { // Lista arquivos e diretórios
        // TODO: Get the list of files and directories in the current directory
        File[] files = currentDirectory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("O diretório está vazio.");
            return;
        }

        // TODO: Display the list of files and directories
        // For each file, show:
        // - 'd' if it's a directory or '-' if it's a file
        // - The file name
        for (File file : files) { // Percorre os arquivos
            String type = file.isDirectory() ? "d" : "-";
            System.out.printf("%s %s%n", type, file.getName());
        }

    }

    /**
     * Change to a different directory
     *
     * @param dirName The name of the directory to change to
     */
    private void changeDirectory(@NotNull String dirName) { // Muda de diretório
        // TODO: Implement changing to a directory
        // If dirName is "..", go to parent directory
        // Otherwise, change to the specified directory if it exists
        if (dirName.equals("..")) {
            File parent = currentDirectory.getParentFile();
            if (parent != null) {
                currentDirectory = parent;
            } else {
                System.out.println("Já está no diretório raiz.");
            }
        } else {
            File newDir = new File(currentDirectory, dirName);
            if (newDir.exists() && newDir.isDirectory()) {
                currentDirectory = newDir;
            } else {
                System.out.println("Diretório não encontrado: " + dirName);
            }
        }
    }

    /**
     * Create a new directory
     *
     * @param dirName The name of the directory to create
     */
    private void createDirectory(String dirName) { // Cria um novo diretório
        // TODO: Implement creating a new directory
        // Create a new directory with the given name in the current directory
        File newDir = new File(currentDirectory, dirName);
        if (newDir.exists()) {
            System.out.println("O diretório já existe: " + dirName);
        } else {
            if (newDir.mkdir()) {
                System.out.println("Diretório criado: " + dirName);
            } else {
                System.out.println("Falha ao criar o diretório: " + dirName);
            }
        }
    }

    /**
     * Create a new file
     *
     * @param fileName The name of the file to create
     */
    private void createFile(String fileName) {
        // TODO: Implement creating a new file
        // Create a new empty file with the given name in the current directory
        File newFile = new File(currentDirectory, fileName);
        if (newFile.exists()) {
            System.out.println("O arquivo já existe: " + fileName);
        } else {
            try {
                if (newFile.createNewFile()) {
                    System.out.println("Arquivo criado: " + fileName);
                } else {
                    System.out.println("Falha ao criar o arquivo: " + fileName);
                }
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
            }
        }
    }

    /**
     * Delete a file or directory
     *
     * @param name The name of the file or directory to delete
     */
    private void delete(String name) { // Deleta um arquivo ou diretório
        // TODO: Implement deleting a file or directory
        // If it's a directory, provide a warning and confirm deletion
        File target = new File(currentDirectory, name);
        if (!target.exists()) {
            System.out.println("Arquivo ou diretório não encontrado: " + name);
        } else {
            if (target.isDirectory()) {
                System.out.print("Aviso: Você está prestes a deletar um diretório. Tem certeza? (y/n): ");
                String confirmation = scanner.nextLine();
                if (!confirmation.equalsIgnoreCase("y")) {
                    System.out.println("Operação cancelada.");
                    return;
                }
            }
            if (target.delete()) {
                System.out.println("Deletado: " + name);
            } else {
                System.out.println("Falha ao deletar: " + name);
            }
        }
    }

    /**
     * Rename a file or directory
     *
     * @param oldName The current name of the file or directory
     * @param newName The new name for the file or directory
     */
    private void rename(String oldName, String newName) { // Renomeia um arquivo ou diretório
        // TODO: Implement renaming a file or directory
        File oldFile = new File(currentDirectory, oldName);
        File newFile = new File(currentDirectory, newName);
        if (!oldFile.exists()) {
            System.out.println("Arquivo ou diretório não encontrado: " + oldName);
        } else if (newFile.exists()) {
            System.out.println("Já existe um arquivo ou diretório com o nome: " + newName);
        } else {
            if (oldFile.renameTo(newFile)) {
                System.out.println("Renomeado para: " + newName);
            } else {
                System.out.println("Falha ao renomear: " + oldName);
            }
        }
    }

    /**
     * Search for files matching a pattern
     *
     * @param pattern The pattern to search for
     */
    private void findFiles(String pattern) { // Procura arquivos por padrão de nome
        // TODO: Implement searching for files by name pattern
        // Use recursive method to search through directories
        System.out.println("Procurando por arquivos que correspondem ao padrão: " + pattern);
        int[] counter = {0}; // Contador para arquivos encontrados
        searchRecursive(currentDirectory, pattern, counter);
        System.out.println("\nEncontrados " + counter[0] + " items.");
    }

    private void searchRecursive(@NotNull File currentDirectory, String pattern, int[] counter) { // Método recursivo para procurar arquivos
        File[] files = currentDirectory.listFiles();
        if (files == null) return;

        for (File file : files) { // Percorre os arquivos
            if (file.getName().toLowerCase().contains(pattern.toLowerCase())) {
                String type = file.isDirectory() ? "[DIR]" : "[FILE]";
                System.out.println(type + " " + file.getAbsolutePath());
                counter[0]++; // Incrementa o contador
            }
            if (file.isDirectory()) { // Se for diretório, chama recursivamente
                searchRecursive(file, pattern, counter);
            }
        }
    }

    /**
     * Display detailed information about a file
     *
     * @param fileName The name of the file to display information for
     */
    private void displayFileInfo(String fileName) { // Exibe informações detalhadas sobre um arquivo
        // TODO: Implement displaying file information
        // Show file size, last modified date, whether it's a directory, etc.
        File file = new File(currentDirectory, fileName);
        if (!file.exists()) {
            System.out.println("Arquivo não encontrado: " + fileName);
        } else {
            System.out.println("Informações sobre o arquivo: " + fileName);
            System.out.println("Caminho: " + file.getAbsolutePath());
            System.out.println("Tamanho: " + file.length() + " bytes");
            System.out.println("Última modificação: " + dateFormat.format(new Date(file.lastModified())));
            System.out.println("Tipo: " + (file.isDirectory() ? "Diretório" : "Arquivo"));
            System.out.println("Legível: " + file.canRead());
            System.out.println("Gravável: " + file.canWrite());
            System.out.println("Executável: " + file.canExecute());
        }

    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        FileSystemManager manager = new FileSystemManager();
        manager.start();
    }
}

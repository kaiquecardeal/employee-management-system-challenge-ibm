import java.util.Scanner;

// ShapeDemo class to demonstrate polymorphism with Shapes
public class ShapeDemo {
    public static void main(String[] args) {
        // Step 1: Create an array of Shape objects with size 5
        // Hint: Shape[] shapes = new Shape[5];
        Shape[] shapes = new Shape[5]; // Array para armazenar formas

        // Step 2: Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in); // Scanner para entrada do usuário

        // Step 3: Create an interactive menu to add shapes to the array
        // Hint: Use a loop and a counter to keep track of how many shapes are added
        // The menu should allow users to:
        // 1. Add a Circle
        // 2. Add a Rectangle
        // 3. Add a Triangle
        // 4. Display all shapes
        // 5. Exit
        int count = 0; // Contador para o número de formas adicionadas
        while (true) {
            System.out.println("Menu: \n" +
                    "1. Adicionar Círculo\n" +
                    "2. Adicionar Retângulo\n" +
                    "3. Adicionar Triângulo\n" +
                    "4. Exibir todas as formas\n" +
                    "5. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner
            if (choice == 5) {
                break; // Sai do loop se a opção for 5
            }
            if (count >= shapes.length) {
                System.out.println("Array cheio! Não é possível adicionar mais formas.");
                continue; // Continua para a próxima iteração se o array estiver cheio
            }
            // Step 4: For each shape type, prompt the user for the required attributes
            // For Circle: name, color, radius
            // For Rectangle: name, color, length, width
            // For Triangle: name, color, side1, side2, side3
            switch (choice) {
                case 1: // Adicionar Círculo
                    System.out.print("Nome: ");
                    String circleName = scanner.next();
                    System.out.print("Cor: ");
                    String circleColor = scanner.next();
                    System.out.print("Raio: ");
                    double radius = scanner.nextDouble();
                    shapes[count] = new Circle(circleName, circleColor, radius);
                    count++;
                    System.out.println("Círculo adicionado com sucesso!");
                    break;
                case 2: // Adicionar Retângulo
                    System.out.print("Nome: ");
                    String rectName = scanner.next();
                    System.out.print("Cor: ");
                    String rectColor = scanner.next();
                    System.out.print("Comprimento: ");
                    double length = scanner.nextDouble();
                    System.out.print("Largura: ");
                    double width = scanner.nextDouble();
                    shapes[count] = new Rectangle(rectName, rectColor, length, width);
                    count++;
                    System.out.println("Retângulo adicionado com sucesso!");
                    break;
                case 3: // Adicionar Triângulo
                    System.out.print("Nome: ");
                    String triName = scanner.next();
                    System.out.print("Cor: ");
                    String triColor = scanner.next();
                    System.out.print("Lado 1: ");
                    double side1 = scanner.nextDouble();
                    System.out.print("Lado 2: ");
                    double side2 = scanner.nextDouble();
                    System.out.print("Lado 3: ");
                    double side3 = scanner.nextDouble();
                    shapes[count] = new Triangle(triName, triColor, side1, side2, side3);
                    count++;
                    System.out.println("Triângulo adicionado com sucesso!");
                    break;
                // Step 5: After adding a shape, display its details
                // Step 6: When displaying all shapes, loop through the array and call each shape's
                // toString(), area(), and perimeter() methods
                // This will demonstrate polymorphism as each shape type will use its own implementation
                case 4: // Exibir todas as formas
                    if (count == 0) {
                        System.out.println("Nenhuma forma adicionada ainda.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println(shapes[i].toString());
                            System.out.printf("Área: %.2f\n", shapes[i].area());
                            System.out.printf("Perímetro: %.2f\n", shapes[i].perimeter());
                            System.out.println();
                        }
                    }
                    break;
            }
            System.out.println(); // Linha em branco para melhor formatação
        }
        scanner.close(); // Fecha o scanner
    }
}
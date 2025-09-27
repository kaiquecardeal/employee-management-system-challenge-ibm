// Rectangle class - a subclass of Shape
public class Rectangle extends Shape {
    // Step 1: Declare private variables for length and width
    // Hint: Use double for both attributes
    private double length; // Comprimento do retângulo
    private double width;  // Largura do retângulo

    // Step 2: Create a constructor that takes name, color, length, and width as parameters
    // Hint: Use super() to call the parent constructor and then initialize length and width
    public Rectangle(String name, String color, double length, double width) {
        super(name, color); // Chama o construtor da classe pai (Shape)
        this.length = length; // Inicializa o comprimento
        this.width = width;   // Inicializa a largura
    }

    // Step 3: Create getter methods for length and width
    // Hint: public double getLength() and public double getWidth()
    public double getLength() { // Método para obter o comprimento
        return length;
    }

    public double getWidth() {  // Método para obter a largura
        return width;
    }

    // Step 4: Override the area() method to calculate the area of a rectangle
    // Hint: Area of a rectangle = length * width
    @Override
    public double area() { // Método para calcular a área
        return length * width; // Calcula a área do retângulo
    }

    // Step 5: Override the perimeter() method to calculate the perimeter of a rectangle
    // Hint: Perimeter of a rectangle = 2 * (length + width)
    @Override
    public double perimeter() { // Método para calcular o perímetro
        return 2 * (length + width); // Calcula o perímetro do retângulo
    }

    // Step 6: Override toString() method to include rectangle-specific information
    // Hint: Call the parent's toString() method and append rectangle-specific details
    @Override
    public String toString() { // Método para representar o retângulo como uma string
        return super.toString() + ", Rectangle[length=" + length + ", width=" + width + "]"; // Representa o retângulo como uma string
    }
}

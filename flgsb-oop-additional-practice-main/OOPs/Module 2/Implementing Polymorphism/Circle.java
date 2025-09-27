// Circle class - a subclass of Shape
public class Circle extends Shape {
    // Step 1: Declare private variable for radius
    // Hint: Use double for the radius
    private double radius; // Raio do círculo

    // Step 2: Create a constructor that takes name, color, and radius as parameters
    // Hint: Use super() to call the parent constructor and then initialize radius
    public Circle(String name, String color, double radius) {
        super(name, color); // Chama o construtor da classe pai (Shape)
        this.radius = radius; // Inicializa o raio
    }

    // Step 3: Create getter method for radius
    // Hint: public double getRadius()
    public double getRadius() { // Método para obter o raio
        return radius;
    }

    // Step 4: Override the area() method to calculate the area of a circle
    // Hint: Area of a circle = π * radius * radius (use Math.PI)
    @Override
    public double area() { // Método para calcular a área
        return Math.PI * radius * radius; // Calcula a área do círculo
    }

    // Step 5: Override the perimeter() method to calculate the perimeter (circumference) of a circle
    // Hint: Perimeter of a circle = 2 * π * radius (use Math.PI)
    @Override
    public double perimeter() { // Método para calcular o perímetro
        return 2 * Math.PI * radius; // Calcula o perímetro do círculo
    }

    // Step 6: Override toString() method to include circle-specific information
    // Hint: Call the parent's toString() method and append circle-specific details
    @Override
    public String toString() { // Método para representar o círculo como uma string
        return super.toString() + ", Circulo[radius=" + radius + "]"; // Representa o círculo como uma string
    }
}

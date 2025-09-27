// Triangle class - a subclass of Shape
public class Triangle extends Shape {
    // Step 1: Declare private variables for the three sides
    // Hint: Use double for side1, side2, and side3
    private double side1; // Lado 1 do triângulo
    private double side2; // Lado 2 do triângulo
    private double side3; // Lado 3 do triângulo

    // Step 2: Create a constructor that takes name, color, and three sides as parameters
    // Hint: Use super() to call the parent constructor and then initialize the sides
    public Triangle(String name, String color, double side1, double side2, double side3) {
        super(name, color); // Chama o construtor da classe pai (Shape)
        this.side1 = side1; // Inicializa o lado 1
        this.side2 = side2; // Inicializa o lado 2
        this.side3 = side3; // Inicializa o lado 3
    }

    // Step 3: Create getter methods for the three sides
    // Hint: public double getSide1(), getSide2(), and getSide3()
    public double getSide1() { // Método para obter o lado 1
        return side1;
    }

    public double getSide2() { // Método para obter o lado 2
        return side2;
    }

    public double getSide3() { // Método para obter o lado 3
        return side3;
    }

    // Step 4: Override the area() method to calculate the area of a triangle
    // Hint: Use Heron's formula: Area = √(s(s-a)(s-b)(s-c)) where s = (a+b+c)/2
    @Override
    public double area() { // Método para calcular a área
        double s = perimeter() / 2; // Calcula o semiperímetro
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)); // Calcula a área usando a fórmula de Heron
    }

    // Step 5: Override the perimeter() method to calculate the perimeter of a triangle
    // Hint: Perimeter of a triangle = side1 + side2 + side3
    @Override
    public double perimeter() { // Método para calcular o perímetro
        return side1 + side2 + side3; // Calcula o perímetro do triângulo
    }

    // Step 6: Override toString() method to include triangle-specific information
    // Hint: Call the parent's toString() method and append triangle-specific details
    @Override
    public String toString() { // Método para representar o triângulo como uma string
        return super.toString() + ", Triangle[side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + "]"; // Representa o triângulo como uma string
    }

}

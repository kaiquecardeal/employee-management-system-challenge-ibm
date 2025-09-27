// Employee class to demonstrate encapsulation
public class Employee implements Cloneable {
    // Step 1: Declare private variables for name, age, and salary
    // Hint: Use appropriate data types (String, int, double)
    private String name; // Nome do funcionário
    private int age; // Idade do funcionário
    private double salary; // Salário do funcionário

    // Step 2: Create constructors
    // 2.1: Create a default constructor that sets name to "Unknown", age to 18, and salary to 0.0
    // Hint: public Employee()
    public Employee() { // Default constructor
        this.name = "Unknown";
        this.age = 18;
        this.salary = 0.0;
    }

    // 2.2: Create an overloaded constructor that initializes all three variables
    // Hint: public Employee(String name, int age, double salary)
    public Employee(String name, int age, double salary) { // Overloaded constructor
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Step 3: Create public getter methods for each variable
    // Hint: Use the format: public returnType getVariableName()
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    // Step 4: Create public setter methods for each variable
    // Hint: Use the format: public void setVariableName(parameter)
    // Add validation logic in th // - For name: Ensure it is not null or empty
    //    // - For age: Ensure it is between 18 and 65 (inclusive)
    //    // - For salary: Ensure it is greater than or equal to 0e setter methods:
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Nome inválido. O nome não pode ser nulo ou vazio.");
        }
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 65) {
            this.age = age;
        } else {
            System.out.println("Idade inválida. A idade deve estar entre 18 e 65 anos.");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salário inválido. O salário deve ser maior ou igual a 0.");
        }
    }

    // Step 5: Create a public method to calculate annual salary (monthly salary * 12)
    // Hint: public double calculateAnnualSalary()
    public double calculateAnnualSalary() { // Método para calcular o salário anual
        return this.salary * 12;
    }

    // Step 6: Create a public method to give a raise (percentage)
    // This method should increase the salary by the given percentage
    // Hint: public void giveRaise(double percentage)
    public void giveRaise(double percentage) { // Método para dar aumento de salário
        if (percentage > 0) {
            this.salary += this.salary * (percentage / 100);
        } else {
            System.out.println("Porcentagem inválida. A porcentagem deve ser maior que 0.");
        }
    }

    // Step 7: Create a public method to display employee details
    // Hint: Use System.out.println() to print name, age, monthly salary, and annual salary
    public void displayEmployeeDetails() { // Método para exibir detalhes do funcionário
        System.out.println("Nome: " + this.name);
        System.out.println("Idade: " + this.age);
        System.out.println("Salário Mensal: " + this.salary);
        System.out.println("Salário Anual: " + calculateAnnualSalary());
    }

    // Step 8: Override the clone method to make Employee objects cloneable
    // Hint: @Override protected Object clone() throws CloneNotSupportedException
    // Return super.clone() to create a shallow copy of the object
    @Override
    protected Object clone() throws CloneNotSupportedException { // Clonar objeto Employee
        return super.clone();
    }
}

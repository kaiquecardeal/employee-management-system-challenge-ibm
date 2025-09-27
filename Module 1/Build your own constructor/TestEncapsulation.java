// TestEncapsulation class to test the Employee class
public class TestEncapsulation {
    public static void main(String[] args) {
        // Step 1: Create two instances of the Employee class
        // One using the parameterized constructor and one using default constructor with setters
        Employee employee1 = new Employee("Alice", 30, 50000); // Parameterized constructor
        Employee employee2 = new Employee(); // Default constructor
        employee2.setName("Bob");
        employee2.setAge(25);
        employee2.setSalary(45000);

        // Step 2: Print details of both employees
        employee1.displayEmployeeDetails();
        employee2.displayEmployeeDetails();

        // Step 3: Try setting invalid values (null name, age outside range, negative salary)
        employee1.setName(null);
        employee1.setAge(70);
        employee1.setSalary(-5000);

        // Step 4: Give both employees a 10% raise and display their details again
        employee1.giveRaise(10);
        employee2.giveRaise(10);
        employee1.displayEmployeeDetails();
        employee2.displayEmployeeDetails();

        // Step 5: Clone the first employee and display the cloned employee details
        // Hint: Use try-catch block to handle CloneNotSupportedException
        // Employee clonedEmployee = (Employee) employee1.clone();
        try {
            Employee clonedEmployee = (Employee) employee1.clone();
            System.out.println("Clonando os detalhes do funcionário 1:");
            clonedEmployee.displayEmployeeDetails();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clonagem não suportada: " + e.getMessage());
        }

        // Step 6: Modify the original employee and verify that the clone remains unchanged
        // This demonstrates that cloning creates a separate object
        employee1.setName("Alice Updated");
        System.out.println("Detalhes do funcionário 1 após atualização:");
        employee1.displayEmployeeDetails();
        System.out.println("Detalhes do funcionário clonado (deve permanecer inalterado):");
        try {
            Employee clonedEmployee = (Employee) employee1.clone();
            clonedEmployee.displayEmployeeDetails();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clonagem não suportada: " + e.getMessage());
        }

        // Step 7: Create a method that compares the salaries of two employees
        // and returns the name of the employee with the higher salary
        // If salaries are equal, return "Equal salaries"
        String higherSalaryEmployee = compareSalaries(employee1, employee2);
        System.out.println("Funcionário com salário mais alto: " + higherSalaryEmployee);

    }

    public static String compareSalaries(Employee emp1, Employee emp2) {
        if (emp1.getSalary() > emp2.getSalary()) {
            return emp1.getName();
        } else if (emp1.getSalary() < emp2.getSalary()) {
            return emp2.getName();
        } else {
            return "Equal salaries";
        }
    }
}

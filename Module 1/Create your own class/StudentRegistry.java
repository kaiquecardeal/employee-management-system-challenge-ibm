// StudentRegistry class to test the Student class
public class StudentRegistry {
    public static void main(String[] args) {
        // Step 1: Create two instances of the Student class
        Student student1 = new Student(); // Default constructor
        Student student2 = new Student(); // Default constructor

        // Step 2: Use setter methods to set values for all attributes of first student
        // Example values: ID "S001", name "John Doe", grade 85.5, active true
        student1.setStudentId("S001");
        student1.setName("João Dias");
        student1.setGrade(85.5);
        student1.setActive(true);

        // Step 3: Set values for second student
        // Example values: ID "S002", name "Jane Smith", grade 92.0, active true
        student2.setStudentId("S002");
        student2.setName("Jane Silva");
        student2.setGrade(92.0);
        student2.setActive(true);

        // Step 4: Display details of both students
        student1.displayStudentDetails();
        student2.displayStudentDetails();

        // Step 5: Compare the grades of the two students and print who has the higher grade
        // Hint: Create a separate method for this comparison
        Student higherGradeStudent = compareGrades(student1, student2); // Comparar as notas dos alunos

        // Step 6: Test the letter grade method for both students
        System.out.println("Estudante 1 - Nota: " + student1.getLetterGrade()); // Imprimir a nota do estudante 1
        System.out.println("Estudante 2 - Nota: " + student2.getLetterGrade()); // Imprimir a nota do estudante 2


        // Step 7: Test the passing status method for both students
        System.out.println("Estudante 1 - Aprovado: " + student1.isPassing()); // Informa se o estudante 1 está aprovado
        System.out.println("Estudante 2 - Aprovado: " + student2.isPassing()); // Informa se o estudante 2 está aprovado


        // Step 8: Change one student to inactive and display the updated information
        System.out.println("Atualizando status do Estudante 1 para Inativo...");
        student1.setActive(false); // Atualiza o status do estudante 1 para inativo
        student1.displayStudentDetails(); // Exibe os detalhes atualizados do estudante 1
    }

    private static Student compareGrades(Student student1, Student student2) { // Método para comparar as notas dos alunos
        if (student1.getGrade() > student2.getGrade()) {
            return student1;
        } else {
            return student2;
        }
    }

    // Step 9: Create a static method to compare two students' grades and return the student with the higher grade
    // Hint: Take two Student objects as parameters
}

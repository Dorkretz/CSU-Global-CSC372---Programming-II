import java.util.Scanner;

/**
 * The StudentManagementApp class is the main program that allows users to input student data.
 * It validates GPA input, stores students in a linked list, and writes sorted data to a text file.
 */
public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();

        System.out.println("Enter student details. Type 'done' when finished.");

        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            double GPA = 0;
            while (true) {
                System.out.print("Enter GPA (0.0 - 4.0): ");
                try {
                    GPA = Double.parseDouble(scanner.nextLine());
                    if (GPA >= 0.0 && GPA <= 4.0) {
                        break;
                    } else {
                        System.out.println("Invalid GPA. Please enter a value between 0.0 and 4.0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                }
            }

            Student student = new Student(name, address, GPA);
            studentList.addStudent(student);
        }

        scanner.close();

        // Saves to file
        studentList.saveToFile("students.txt");
    }
}

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class serves as the main controller for
 * student data operations.
 */
public class StudentManager {
    private ArrayList<Student> students;
    private ArrayList<Integer> existingRollNumbers;
    private Scanner scanner;
    private static final int TOTAL_STUDENTS = 10;

    public StudentManager() {
        students = new ArrayList<>();
        existingRollNumbers = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Gets a valid integer input from the user for roll number
     * @param prompt The message to display to the user
     * @return A valid integer input
     */
    private int getValidRollNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int rollno = Integer.parseInt(scanner.nextLine().trim());
                if (rollno <= 0) {
                    System.out.println("Error: Roll number must be positive");
                    continue;
                }
                if (existingRollNumbers.contains(rollno)) {
                    System.out.println("Error: Roll number already exists");
                    continue;
                }
                return rollno;
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number");
            }
        }
    }

    /**
     * Gets a valid string input from the user
     * @param prompt The message to display to the user
     * @return A non-empty string input
     */
    private String getValidString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Error: Input cannot be empty");
        }
    }

    /**
     * Collects information for all students from user input
     */
    public void inputStudents() {
        System.out.println("Enter information for " + TOTAL_STUDENTS + " students:");

        for (int i = 1; i <= TOTAL_STUDENTS; i++) {
            System.out.println("\nStudent " + i + ":");
            int rollno = getValidRollNumber("Enter roll number: ");
            existingRollNumbers.add(rollno);

            String name = getValidString("Enter name: ");
            String address = getValidString("Enter address: ");

            students.add(new Student(rollno, name, address));
        }
    }

    /**
     * Sorts the students using custom merge sort
     */
    public void sortStudents() {
        MergeSort.sort(students);
    }

    /**
     * Displays all students in the current order
     * @param message Header message to display before the list
     */
    public void displayStudents(String message) {
        System.out.println("\n" + message);
        students.forEach(System.out::println);
    }

    /**
     * Closes the scanner
     */
    public void closeScanner() {
        scanner.close();
    }
}
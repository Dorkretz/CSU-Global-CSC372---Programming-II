/**
 * This class serves as the entry point for the student management system.
 * It demonstrates the usage of StudentManager class to input, sort, and display
 * student records.
 *
 * @author Custom Implementation
 * @version 1.2
 */
public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.inputStudents();
        manager.displayStudents("Unsorted Students:");

        manager.sortStudents();
        manager.displayStudents("Students Sorted by Roll Number:");

        manager.closeScanner();
    }
}
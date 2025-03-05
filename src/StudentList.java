import java.util.LinkedList;
import java.util.Collections;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The StudentList class manages a linked list of Student objects.
 * It provides methods to add students and save the list to a file.
 */
public class StudentList {
    private LinkedList<Student> students;

    /**
     * Constructor initializes an empty linked list.
     */
    public StudentList() {
        students = new LinkedList<>();
    }

    /**
     * Adds a student to the list.
     * @param student The Student object to add.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Sorts students by name and writes them to a text file.
     * @param filename The name of the output file.
     */
    public void saveToFile(String filename) {
        Collections.sort(students);
        try (FileWriter writer = new FileWriter(filename)) {
            for (Student s : students) {
                writer.write(s.toString() + "\n");
            }
            System.out.println("Student data has been saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

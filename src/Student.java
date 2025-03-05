/**
 * The Student class represents a student with a name, address, and GPA.
 * It includes a constructor, getters, setters, and a toString method.
 */
public class Student implements Comparable<Student> {
    private String name;
    private String address;
    private double GPA;

    /**
     * Constructor for Student object.
     * @param name The student's name.
     * @param address The student's address.
     * @param GPA The student's GPA.
     */
    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", GPA: " + GPA;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}

/**
 * This class represents a student entity with basic information including
 * roll number, name, and address. It provides a simple data structure for
 * storing and accessing student information.
 */
public class Student {
    private int rollno;
    private String name;
    private String address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public int getRollno() { return rollno; }

    @Override
    public String toString() {
        return "Student[" + rollno + ", " + name + ", " + address + "]";
    }
}
import java.util.ArrayList;

/**
 * This class implements a custom merge sort algorithm specifically designed for
 * sorting ArrayList<Student> by roll number.
 */
public class MergeSort {
    /**
     * Sorts an ArrayList of students by their roll numbers using merge sort.
     * @param students The ArrayList of students to be sorted
     */
    public static void sort(ArrayList<Student> students) {
        if (students.size() <= 1) return;

        int mid = students.size() / 2;
        ArrayList<Student> left = new ArrayList<>(students.subList(0, mid));
        ArrayList<Student> right = new ArrayList<>(students.subList(mid, students.size()));

        sort(left);
        sort(right);
        merge(students, left, right);
    }

    private static void merge(ArrayList<Student> result, ArrayList<Student> left,
                              ArrayList<Student> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getRollno() <= right.get(j).getRollno()) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) result.set(k++, left.get(i++));
        while (j < right.size()) result.set(k++, right.get(j++));
    }
}
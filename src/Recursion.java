import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // User inputs 5 numbers
        System.out.println("Enter five numbers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        // Calculates and displays the product
        int product = calculateProduct(numbers, 0);
        System.out.println("The product of the numbers is: " + product);
    }

    // Method that calculates product
    public static int calculateProduct(int[] numbers, int index) {
        if (index == numbers.length) {
            return 1;
        }
        return numbers[index] * calculateProduct(numbers, index + 1);
    }
}

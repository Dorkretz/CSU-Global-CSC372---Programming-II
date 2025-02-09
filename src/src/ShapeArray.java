package src;

public class ShapeArray {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Triangle(3, 4, 5),
                new Circle(5),
                new Rectangle(4, 4)
        };

        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
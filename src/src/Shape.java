package src;

public abstract class Shape {
    public abstract double area();
    public abstract double perimeter();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - Area: " + area() + ", Perimeter: " + perimeter();
    }
}

class Rectangle {
    int length, breadth;

    public Rectangle(int l, int b) {
        this.length = l;
        this.breadth = b;
    }

    public int area() {
        return length * breadth;
    }
}

public class ClassesQ3 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(5, 8);

        System.out.println("Area of Rectangle 1 (4x5): " + r1.area());
        System.out.println("Area of Rectangle 2 (5x8): " + r2.area());
    }
}

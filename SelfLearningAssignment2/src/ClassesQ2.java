class Triangle {
    int side1, side2, side3;

    public Triangle(int s1, int s2, int s3) {
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }

    public double getArea() {
        // Heron's formula
        double s = getPerimeter() / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public int getPerimeter() {
        return side1 + side2 + side3;
    }
}

public class ClassesQ2 {
    public static void main(String[] args) {
        Triangle t = new Triangle(3, 4, 5);
        System.out.println("Area of Triangle: " + t.getArea());
        System.out.println("Perimeter of Triangle: " + t.getPerimeter());
    }
}

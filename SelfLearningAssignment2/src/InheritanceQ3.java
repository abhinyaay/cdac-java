class RectangleShape {
    int length;
    int breadth;

    public RectangleShape(int l, int b) {
        this.length = l;
        this.breadth = b;
    }

    public void printArea() {
        System.out.println("Area: " + (length * breadth));
    }

    public void printPerimeter() {
        System.out.println("Perimeter: " + (2 * (length + breadth)));
    }
}

class SquareShape extends RectangleShape {
    public SquareShape(int s) {
        super(s, s);
    }
}

public class InheritanceQ3 {
    public static void main(String[] args) {
        System.out.println("Rectangle (4x5):");
        RectangleShape r = new RectangleShape(4, 5);
        r.printArea();
        r.printPerimeter();

        System.out.println("\nSquare (5x5):");
        SquareShape sq = new SquareShape(5);
        sq.printArea();
        sq.printPerimeter();
    }
}

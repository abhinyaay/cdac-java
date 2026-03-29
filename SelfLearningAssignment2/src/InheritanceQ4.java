class Shape {
    public void printShape() {
        System.out.println("This is shape");
    }
}

class RectangleClass extends Shape {
    public void printRectangle() {
        System.out.println("This is rectangular shape");
    }
}

class CircleClass extends Shape {
    public void printCircle() {
        System.out.println("This is circular shape");
    }
}

class SquareClass extends RectangleClass {
    public void printSquare() {
        System.out.println("Square is a rectangle");
    }
}

public class InheritanceQ4 {
    public static void main(String[] args) {
        SquareClass sq = new SquareClass();
        
        // Call method of Shape class by object of Square class
        sq.printShape();
        
        // Call method of Rectangle class by object of Square class
        sq.printRectangle();
    }
}

class Parent {
    public void printParent() {
        System.out.println("This is parent class");
    }
}

class Child extends Parent {
    public void printChild() {
        System.out.println("This is child class");
    }
}

public class InheritanceQ1 {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();

        // 1 - method of parent class by object of parent class
        p.printParent();
        
        // 2 - method of child class by object of child class
        c.printChild();
        
        // 3 - method of parent class by object of child class
        c.printParent();
    }
}

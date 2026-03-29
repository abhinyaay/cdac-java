class Employee {
    String name;
    int yearOfJoining;
    double salary;
    String address;

    public Employee(String name, int yearOfJoining, double salary, String address) {
        this.name = name;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
        this.address = address;
    }
}

public class ClassesQ5 {
    public static void main(String[] args) {
        Employee e1 = new Employee("Robert", 1994, 50000, "64C- WallsStreat");
        Employee e2 = new Employee("Sam", 2000, 60000, "68D- WallsStreat");
        Employee e3 = new Employee("John", 1999, 55000, "26B- WallsStreat");

        System.out.printf("%-10s %-20s %-20s\n", "Name", "Year of joining", "Address");
        System.out.printf("%-10s %-20d %-20s\n", e1.name, e1.yearOfJoining, e1.address);
        System.out.printf("%-10s %-20d %-20s\n", e2.name, e2.yearOfJoining, e2.address);
        System.out.printf("%-10s %-20d %-20s\n", e3.name, e3.yearOfJoining, e3.address);
    }
}

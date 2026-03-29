class EmployeeWithSalary {
    double salary;
    int hoursPerDay;

    public void getInfo(double salary, int hoursPerDay) {
        this.salary = salary;
        this.hoursPerDay = hoursPerDay;
    }

    public void addSal() {
        if (salary < 500) {
            salary += 10;
        }
    }

    public void addWork() {
        if (hoursPerDay > 6) {
            salary += 5;
        }
    }

    public void printSalary() {
        System.out.println("Final Salary: $" + salary);
    }
}

public class ClassesQ6 {
    public static void main(String[] args) {
        EmployeeWithSalary emp1 = new EmployeeWithSalary();
        emp1.getInfo(400, 7);
        emp1.addSal();
        emp1.addWork();
        System.out.print("Employee 1 (Started $400, 7 hours): ");
        emp1.printSalary();

        EmployeeWithSalary emp2 = new EmployeeWithSalary();
        emp2.getInfo(600, 5);
        emp2.addSal();
        emp2.addWork();
        System.out.print("Employee 2 (Started $600, 5 hours): ");
        emp2.printSalary();
    }
}

import java.util.Scanner;

class Member {
    private String name;
    private int age;
    private String phoneNumber;
    private String address;
    private double salary;

    // Accessors and Mutators
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public void printSalary() {
        System.out.println("Salary: $" + salary);
    }
}

class PrimeMembers extends Member {
    private int joiningYear;
    private double joiningFees;
    private boolean isActive;

    public int getJoiningYear() { return joiningYear; }
    public void setJoiningYear(int joiningYear) { this.joiningYear = joiningYear; }
    public double getJoiningFees() { return joiningFees; }
    public void setJoiningFees(double joiningFees) { this.joiningFees = joiningFees; }
    public boolean getIsActive() { return isActive; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }

    public void display() {
        System.out.println("\n--- Prime Member Details ---");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
        printSalary();
        System.out.println("Joining Year: " + joiningYear);
        System.out.println("Joining Fees: $" + joiningFees);
        System.out.println("Is Active: " + isActive);
    }
}

public class InheritanceQ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrimeMembers pm = new PrimeMembers();

        System.out.print("Enter Name: ");
        pm.setName(sc.nextLine());
        System.out.print("Enter Age: ");
        try {
            pm.setAge(Integer.parseInt(sc.nextLine()));
        } catch (NumberFormatException e) {
            pm.setAge(0);
        }
        System.out.print("Enter Phone Number: ");
        pm.setPhoneNumber(sc.nextLine());
        System.out.print("Enter Address: ");
        pm.setAddress(sc.nextLine());
        System.out.print("Enter Salary: ");
        try {
            pm.setSalary(Double.parseDouble(sc.nextLine()));
        } catch (NumberFormatException e) {
            pm.setSalary(0.0);
        }
        System.out.print("Enter Joining Year: ");
        try {
            pm.setJoiningYear(Integer.parseInt(sc.nextLine()));
        } catch (NumberFormatException e) {
            pm.setJoiningYear(0);
        }
        System.out.print("Enter Joining Fees: ");
        try {
            pm.setJoiningFees(Double.parseDouble(sc.nextLine()));
        } catch (NumberFormatException e) {
            pm.setJoiningFees(0.0);
        }
        System.out.print("Is Active (true/false): ");
        pm.setIsActive(Boolean.parseBoolean(sc.nextLine()));

        pm.display();
        sc.close();
    }
}

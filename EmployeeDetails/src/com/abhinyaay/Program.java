package com.abhinyaay;

import java.util.Scanner;
import com.abhinyaay.linkedlist.LinkedList;

public class Program {
    static LinkedList list = new LinkedList();
    static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n************* MAIN MENU *************");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display");
            System.out.println("3. Sort");
            System.out.println("4. Save to File");
            System.out.println("5. Load from File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployeeMenu(sc);
                    break;
                case 2:
                    displayMenu(sc);
                    break;
                case 3:
                    sortMenu(sc);
                    break;
                case 4:
                    saveToFile();
                    break;
                case 5:
                    loadFromFile();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    static void addEmployeeMenu(Scanner sc) {
        do {
            System.out.println("\n************* Add Employee *************");
            System.out.println("a. Manager");
            System.out.println("b. Engineer");
            System.out.println("c. Sales Person");
            System.out.println("d. Exit to Main Menu");
            System.out.print("Enter your choice: ");
            String input = sc.next();

            if (input.equalsIgnoreCase("d"))
                break;

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Address: ");
            String address = sc.next();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            System.out.print("Enter Gender (true/false): ");
            boolean gender = sc.nextBoolean();

            System.out.print("Enter Basic Salary: ");
            float basic = sc.nextFloat();

            switch (input.toLowerCase()) {
                case "a":
                    System.out.print("Enter HRA: ");
                    float hra = sc.nextFloat();
                    list.addLast(new Manager(name, address, age, gender, basic, hra));
                    System.out.println("Manager added successfully!");
                    break;

                case "b":
                    System.out.print("Enter OverTime: ");
                    float ot = sc.nextFloat();
                    list.addLast(new Engineer(name, address, age, gender, basic, ot));
                    System.out.println("Engineer added successfully!");
                    break;

                case "c":
                    System.out.print("Enter Commission: ");
                    float comm = sc.nextFloat();
                    list.addLast(new SalesPerson(name, address, age, gender, basic, comm));
                    System.out.println("SalesPerson added successfully!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (true);
    }

    static void displayMenu(Scanner sc) {
        if (list.getCount() == 0) {
            System.out.println("\nNo employees to display!");
            return;
        }

        do {
            System.out.println("\n************* Display Menu *************");
            System.out.println("a. All Employees");
            System.out.println("b. First Employee");
            System.out.println("c. Next Employee");
            System.out.println("d. Previous Employee");
            System.out.println("e. Last Employee");
            System.out.println("f. Exit to Main Menu");
            System.out.print("Enter your choice: ");
            String input = sc.next();

            if (input.equalsIgnoreCase("f"))
                break;

            switch (input.toLowerCase()) {
                case "a": {
                    System.out.println("\n************* All Employees *************");
                    for (int i = 0; i < list.getCount(); i++) {
                        ((Employee) list.getAt(i)).display();
                    }
                    break;
                }

                case "b": {
                    currentIndex = 0;
                    System.out.println("\n************* First Employee *************");
                    ((Employee) list.getFirst()).display();
                    break;
                }

                case "c": {
                    if (currentIndex < list.getCount() - 1) {
                        currentIndex++;
                        System.out.println("\n************* Next Employee *************");
                        ((Employee) list.getAt(currentIndex)).display();
                    } else {
                        System.out.println("No next employee. Already at the last.");
                    }
                    break;
                }

                case "d": {
                    if (currentIndex > 0) {
                        currentIndex--;
                        System.out.println("\n************* Previous Employee *************");
                        ((Employee) list.getAt(currentIndex)).display();
                    } else {
                        System.out.println("No previous employee. Already at the first.");
                    }
                    break;
                }

                case "e": {
                    currentIndex = list.getCount() - 1;
                    System.out.println("\n************* Last Employee *************");
                    ((Employee) list.getLast()).display();
                    break;
                }

                default:
                    System.out.println("Invalid choice!");
            }

        } while (true);
    }

    static void sortMenu(Scanner sc) {
        if (list.getCount() == 0) {
            System.out.println("\nNo employees to sort!");
            return;
        }

        do {
            System.out.println("\n************* Sort Menu *************");
            System.out.println("a. All Managers");
            System.out.println("b. All Engineers");
            System.out.println("c. All Sales Person");
            System.out.println("d. All Employees Alphabetic order ascending");
            System.out.println("e. All Employees Alphabetic order descending");
            System.out.println("f. Exit to Main Menu");
            System.out.print("Enter your choice: ");
            String input = sc.next();

            if (input.equalsIgnoreCase("f"))
                break;

            switch (input.toLowerCase()) {
                case "a": {
                    System.out.println("\n************* All Managers *************");
                    boolean found = false;
                    for (int i = 0; i < list.getCount(); i++) {
                        if (list.getAt(i) instanceof Manager) {
                            ((Employee) list.getAt(i)).display();
                            found = true;
                        }
                    }
                    if (!found)
                        System.out.println("No Managers found.");
                    break;
                }

                case "b": {
                    System.out.println("\n************* All Engineers *************");
                    boolean found = false;
                    for (int i = 0; i < list.getCount(); i++) {
                        if (list.getAt(i) instanceof Engineer) {
                            ((Employee) list.getAt(i)).display();
                            found = true;
                        }
                    }
                    if (!found)
                        System.out.println("No Engineers found.");
                    break;
                }

                case "c": {
                    System.out.println("\n************* All Sales Persons *************");
                    boolean found = false;
                    for (int i = 0; i < list.getCount(); i++) {
                        if (list.getAt(i) instanceof SalesPerson) {
                            ((Employee) list.getAt(i)).display();
                            found = true;
                        }
                    }
                    if (!found)
                        System.out.println("No Sales Persons found.");
                    break;
                }

                case "d": {
                    System.out.println("\n************* Employees (Ascending by Name) *************");
                    for (int i = 0; i < list.getCount(); i++) {
                        for (int j = i + 1; j < list.getCount(); j++) {
                            Employee ei = (Employee) list.getAt(i);
                            Employee ej = (Employee) list.getAt(j);
                            if (ei.getName().compareTo(ej.getName()) > 0) {
                                list.setAt(i, ej);
                                list.setAt(j, ei);
                            }
                        }
                    }
                    for (int i = 0; i < list.getCount(); i++)
                        ((Employee) list.getAt(i)).display();
                    break;
                }

                case "e": {
                    System.out.println("\n************* Employees (Descending by Name) *************");
                    for (int i = 0; i < list.getCount(); i++) {
                        for (int j = i + 1; j < list.getCount(); j++) {
                            Employee ei = (Employee) list.getAt(i);
                            Employee ej = (Employee) list.getAt(j);
                            if (ei.getName().compareTo(ej.getName()) < 0) {
                                list.setAt(i, ej);
                                list.setAt(j, ei);
                            }
                        }
                    }
                    for (int i = 0; i < list.getCount(); i++)
                        ((Employee) list.getAt(i)).display();
                    break;
                }

                default:
                    System.out.println("Invalid choice!");
            }

        } while (true);
    }

    static void saveToFile() {
        System.out.println("Coming Soon!");
    }

    static void loadFromFile() {
        System.out.println("Coming Soon!");
    }
}
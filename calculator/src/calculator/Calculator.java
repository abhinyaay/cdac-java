package calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Program calc = new Program();

        int choice;

        do {
            System.out.println("\n Enter Your choice");
            System.out.println("1. Add (int, int)");
            System.out.println("2. Add (float, float)");
            System.out.println("3. Add (int, float)");
            System.out.println("4. Add (float, int)");
            System.out.println("5. Subtract (int, int)");
            System.out.println("6. Subtract (float, float)");
            System.out.println("7. Multiply (int, int)");
            System.out.println("8. Multiply (float, float)");
            System.out.println("9. Divide (int, int)");
            System.out.println("10. Divide (float, float)");
            System.out.println("11. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // ===== ADD =====
                case 1:
                    System.out.print("Enter two integers: ");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    System.out.println("Result: " + calc.add(a, b));
                    break;

                case 2:
                    System.out.print("Enter two floats: ");
                    float f1 = sc.nextFloat();
                    float f2 = sc.nextFloat();
                    System.out.println("Result: " + calc.add(f1, f2));
                    break;

                case 3:
                    System.out.print("Enter int and float: ");
                    int i1 = sc.nextInt();
                    float f3 = sc.nextFloat();
                    System.out.println("Result: " + calc.add(i1, f3));
                    break;

                case 4:
                    System.out.print("Enter float and int: ");
                    float f4 = sc.nextFloat();
                    int i2 = sc.nextInt();
                    System.out.println("Result: " + calc.add(f4, i2));
                    break;

                // ===== SUBTRACT =====
                case 5:
                    System.out.print("Enter two integers: ");
                    int s1 = sc.nextInt();
                    int s2 = sc.nextInt();
                    System.out.println("Result: " + calc.subtract(s1, s2));
                    break;

                case 6:
                    System.out.print("Enter two floats: ");
                    float sf1 = sc.nextFloat();
                    float sf2 = sc.nextFloat();
                    System.out.println("Result: " + calc.subtract(sf1, sf2));
                    break;

                // ===== MULTIPLY =====
                case 7:
                    System.out.print("Enter two integers: ");
                    int m1 = sc.nextInt();
                    int m2 = sc.nextInt();
                    System.out.println("Result: " + calc.multiply(m1, m2));
                    break;

                case 8:
                    System.out.print("Enter two floats: ");
                    float mf1 = sc.nextFloat();
                    float mf2 = sc.nextFloat();
                    System.out.println("Result: " + calc.multiply(mf1, mf2));
                    break;

                // ===== DIVIDE =====
                case 9:
                    System.out.print("Enter two integers: ");
                    int d1 = sc.nextInt();
                    int d2 = sc.nextInt();

                    if (d2 == 0) {
                        System.out.println("Cannot divide by zero");
                    } else {
                        System.out.println("Result: " + calc.divide(d1, d2));
                    }
                    break;

                case 10:
                    System.out.print("Enter two floats: ");
                    float df1 = sc.nextFloat();
                    float df2 = sc.nextFloat();

                    if (df2 == 0) {
                        System.out.println("Cannot divide by zero");
                    } else {
                        System.out.println("Result: " + calc.divide(df1, df2));
                    }
                    break;

                case 11:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 11);

        sc.close();
    }
}
import java.util.Scanner;

class Complex {
    double real;
    double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public static Complex add(Complex c1, Complex c2) {
        return new Complex(c1.real + c2.real, c1.imag + c2.imag);
    }

    public static Complex subtract(Complex c1, Complex c2) {
        return new Complex(c1.real - c2.real, c1.imag - c2.imag);
    }

    public static Complex multiply(Complex c1, Complex c2) {
        return new Complex(
            c1.real * c2.real - c1.imag * c2.imag, 
            c1.real * c2.imag + c1.imag * c2.real
        );
    }

    public void print() {
        if (imag >= 0) {
            System.out.println(real + " + " + imag + "i");
        } else {
            System.out.println(real + " - " + Math.abs(imag) + "i");
        }
    }
}

public class ClassesQ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter real and imaginary part for First Complex Number:");
        double r1 = sc.hasNextDouble() ? sc.nextDouble() : 0;
        double i1 = sc.hasNextDouble() ? sc.nextDouble() : 0;
        Complex c1 = new Complex(r1, i1);

        System.out.println("Enter real and imaginary part for Second Complex Number:");
        double r2 = sc.hasNextDouble() ? sc.nextDouble() : 0;
        double i2 = sc.hasNextDouble() ? sc.nextDouble() : 0;
        Complex c2 = new Complex(r2, i2);

        Complex sum = Complex.add(c1, c2);
        Complex diff = Complex.subtract(c1, c2);
        Complex prod = Complex.multiply(c1, c2);

        System.out.print("Sum: ");
        sum.print();
        System.out.print("Difference: ");
        diff.print();
        System.out.print("Product: ");
        prod.print();
        
        sc.close();
    }
}

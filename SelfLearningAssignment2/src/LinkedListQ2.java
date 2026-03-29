import java.util.Scanner;
import com.abhinyaay.linkedlist.LinkedList;

public class LinkedListQ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.println("Enter 10 UNIQUE integers:");
        int inputsReceived = 0;
        while (inputsReceived < 10) {
            System.out.print("Input " + (inputsReceived + 1) + ": ");
            if (sc.hasNextInt()) {
                int num = sc.nextInt();
                
                // Check if number already exists
                boolean exists = false;
                for (int i = 0; i < list.getCount(); i++) {
                    if ((Integer) list.getAt(i) == num) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("Number already exists, skipping...");
                } else {
                    list.addLast(num);
                    inputsReceived++;
                }
            } else {
                sc.next(); // Consume invalid input
            }
        }

        System.out.println("\nAll unique numbers in the list:");
        list.displayAll();

        sc.close();
    }
}

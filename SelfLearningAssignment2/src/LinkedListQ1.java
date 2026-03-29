import java.util.Scanner;
import com.abhinyaay.linkedlist.LinkedList;

public class LinkedListQ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.println("Enter 10 integers:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Input " + (i + 1) + ": ");
            int num = 0;
            if (sc.hasNextInt()) {
                num = sc.nextInt();
            } else {
                sc.next(); // consume non-integer
                i--;
                continue;
            }
            list.addLast(num);
        }

        System.out.println("\na. All numbers in the list:");
        list.displayAll();

        if (list.getCount() == 0) {
            sc.close();
            return;
        }

        int highest = (Integer) list.getAt(0);
        int lowest = (Integer) list.getAt(0);
        int sum = 0;

        for (int i = 0; i < list.getCount(); i++) {
            int val = (Integer) list.getAt(i);
            if (val > highest) highest = val;
            if (val < lowest) lowest = val;
            sum += val;
        }

        System.out.println("\nb. Highest Number: " + highest);
        System.out.println("c. Lowest Number: " + lowest);
        System.out.println("d. Total Sum: " + sum);
        System.out.println("e. Average: " + ((double) sum / list.getCount()));

        System.out.print("\nf. Enter a number to find its index position: ");
        int searchNum = sc.nextInt();
        int index = -1;
        for (int i = 0; i < list.getCount(); i++) {
            if ((Integer) list.getAt(i) == searchNum) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("The index position of " + searchNum + " is: " + index);
        } else {
            System.out.println(searchNum + " is not in the list.");
        }

        System.out.print("\ng. Enter a number to find its repetition count: ");
        int countNum = sc.nextInt();
        int repetitions = 0;
        for (int i = 0; i < list.getCount(); i++) {
            if ((Integer) list.getAt(i) == countNum) {
                repetitions++;
            }
        }
        System.out.println(countNum + " is repeated " + repetitions + " times.");

        sc.close();
    }
}

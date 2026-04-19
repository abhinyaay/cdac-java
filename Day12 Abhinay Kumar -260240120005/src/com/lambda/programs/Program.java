//Create the following using Lambda and Collection Framework
//
//Create a class called Transaction that contains the following data members
//1. txId int
//2. txDate LocalDate
//3. txAmount float
//4. txStatus boolean
//5. txArrears boolean
//
//Create 5 objects of the above Transaction object by taking input from the user and store the same in a Collection object.
//
//Create the Lambda expressions for
//1. Getting all the Transactions from the Collection where the txAmount is > 5000
//
//2. Getting all the Transactions where the txStatus is false
//
//3. Write a Lambda Function to generate the amount due. The amount due is calculated as the txAmount + Rs. 500/- + 18% of txAmount if the txArrears is true else if txArrears if false then only the txAmount will be returned
//
//Using existing (pre-defined) Functional Interfaces in Java write,
//
//1. Lambda expression to sort a string array in alphabetical order
//2. Lambda expression to find the largest number in an integer array.
//3. Lambda expression to find the smallest number in an integer array.
//4. Lambda expression to generate a 3 digit random number
//5. Lambda expression that takes an integer array and returns the reverse integer array
//6. Lambda expression to print the current date
//7. Lambda expression to evaluate if a number entered is a Prime number
//8. Lambda expression to accept 2 strings and return the concatenated value of the same

package com.lambda.programs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        List<String> strArr = new ArrayList<>(
                Arrays.asList("Hello", "Welcome", "Morning", "Evening", "AfterNoon", "GoodNight"));
        List<Integer> intArr = new ArrayList<>(Arrays.asList(48, 72, 63, 33, 1, 99, 81, 21));

        System.out.println("=== Transaction Processing using Lambda & Streams ===\n");
        List<Transaction> transactions = createTransactions();

        filterHighAmountTransactions(transactions);

        filterFailedTransactions(transactions);

        calculateAmountDue(transactions);
        
        sortList1(strArr);
        System.out.println("\n=======\n");
        maxInt2(intArr);
        System.out.println("\n=======\n");
        minInt3(intArr);
        System.out.println("\n=======\n");
        randInt4();
        System.out.println("\n=======\n");
        revArr5(intArr);
        System.out.println("\n=======\n");
        currDate6();
        System.out.println("\n=======\n");
        isPrime7();
        System.out.println("\n=======\n");
        concatStr8();
        System.out.println("\n=======\n");

    }

    static class Transaction {
        int txId;
        LocalDate txDate;
        float txAmount;
        boolean txStatus;
        boolean txArrears;

        public Transaction(int txId, LocalDate txDate, float txAmount, boolean txStatus, boolean txArrears) {
            this.txId = txId;
            this.txDate = txDate;
            this.txAmount = txAmount;
            this.txStatus = txStatus;
            this.txArrears = txArrears;
        }

        @Override
        public String toString() {
            return "Transaction [txId=" + txId + ", txDate=" + txDate + ", txAmount=" + txAmount 
                    + ", txStatus=" + txStatus + ", txArrears=" + txArrears + "]";
        }
    }

    public static List<Transaction> createTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for 5 Transactions:");

        for (int i = 1; i <= 5; i++) {
            System.out.println("\n--- Transaction " + i + " ---");
            
            System.out.print("Enter Transaction ID (int): ");
            int txId = scanner.nextInt();

            System.out.print("Enter Transaction Date (YYYY-MM-DD): ");
            LocalDate txDate = LocalDate.parse(scanner.next());

            System.out.print("Enter Transaction Amount (float): ");
            float txAmount = scanner.nextFloat();

            System.out.print("Enter Transaction Status (true/false): ");
            boolean txStatus = scanner.nextBoolean();

            System.out.print("Enter Arrears (true/false): ");
            boolean txArrears = scanner.nextBoolean();

            transactions.add(new Transaction(txId, txDate, txAmount, txStatus, txArrears));
        }
        scanner.close();
        System.out.println("\nAll Transactions Added Successfully!\n");
        return transactions;
    }

    public static void filterHighAmountTransactions(List<Transaction> transactions) {
        System.out.println("1. Transactions with Amount > 5000:");

        Predicate<Transaction> highAmount = t -> t.txAmount > 5000;

        List<Transaction> result = transactions.stream()
                .filter(highAmount)
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No transactions found with amount > 5000.");
        } else {
            result.forEach(System.out::println);
        }
        System.out.println("---------------------------");
    }

    public static void filterFailedTransactions(List<Transaction> transactions) {
        System.out.println("2. Transactions where Status is FALSE (Failed):");

        Predicate<Transaction> failedStatus = t -> !t.txStatus;

        List<Transaction> result = transactions.stream()
                .filter(failedStatus)
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No failed transactions found.");
        } else {
            result.forEach(System.out::println);
        }
        System.out.println("---------------------------");
    }

    public static void calculateAmountDue(List<Transaction> transactions) {
        System.out.println("3. Amount Due Calculation:");

        Function<Transaction, Float> amountDueCalculator = t -> {
            if (t.txArrears) {
                return t.txAmount + 500 + (0.18f * t.txAmount); 
            } else {
                return t.txAmount;
            }
        };

        for (Transaction t : transactions) {
            float due = amountDueCalculator.apply(t);
            System.out.printf("TxID: %d | Amount: %.2f | Arrears: %b | Amount Due: %.2f%n",
                    t.txId, t.txAmount, t.txArrears, due);
        }
        System.out.println("---------------------------");
    }


    public static void concatStr8() {
        System.out.println("Concat 2 Strings :- ");
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str1 = scan.next();

        System.out.print("Enter a string: ");
        String str2 = scan.next();

        BiFunction<String, String, String> concatStr = (s1, s2) -> s1 + s2;
        scan.close();
        System.out.println("After concatenating 2 strings : " + concatStr.apply(str1, str2));
    }

    public static void isPrime7() {
        System.out.println("Enter number to Check Prime:- ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        Predicate<Integer> checkPrime = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
        scan.close();
        System.out.println("Is Prime Number ? : " + checkPrime.test(num));
    }

    public static void currDate6() {
        System.out.println("Current Date:- ");
        System.out.println(java.time.LocalDate.now());
    }

    public static void revArr5(List<Integer> intArr) {
        System.out.println("Reverse Array:- ");
        intArr.stream()
              .sorted(Collections.reverseOrder())
              .forEach(str -> System.out.print(str + "  "));
        System.out.println();
    }

    public static void randInt4() {
        System.out.println("3 digit Random Number:- ");
        StringBuffer randNum = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            randNum.append((int) (Math.random() * 10));  
        }
        System.out.println(randNum);
    }

    public static void minInt3(List<Integer> intArr) {
        System.out.println("Smallest Number:- ");
        System.out.println(intArr.stream().min(Integer::compare).get());
    }

    public static void maxInt2(List<Integer> intArr) {
        System.out.println("Largest Number:- ");
        System.out.println(intArr.stream().max(Integer::compare).get());
    }

    public static void sortList1(List<String> strArr) {
        System.out.println("Sorted List :-");
        strArr.stream().sorted().forEach(str -> System.out.print(str + "  "));
        System.out.println();
    }
}
package com.abhinyaay;

import java.io.IOException;

public class Program {

    public static void main(String[] args) {
        int day = 121;
        String str = "";

        System.out.println("Statement No 1 - Main");
        System.out.println("Statement No 2 - Main");

        try {
            int data = 0 ;
            System.out.println("Data: " + data);
            
            // Database Connection

            System.out.println("Statement No 3 = Outer Try");

            str.length();

            try {
                int val = 0;

                // Query to fetch Students record Student

                System.out.println("Inner Try s 1");

                if (val == 0)
                    throw new IOException("INvalid value of val");

                System.out.println("Inner Tyue s1 a");

                if (day < 1 || day > 31)
                    throw new Exception("Invalid date entered");

                System.out.println("Inner Tye s 2");

            } catch (IOException e) {
                System.out.println("Inner Catch " + e);
                throw new Exception("asdkfjdsakflj", e);
            } finally {
                System.out.println("Innner finally ((((((");
            }

            System.out.println("Statement No 4 = Outer Try");

        } catch (NullPointerException e) {
            System.out.println("Outer Catch Block No 5 - Catch " + e);
            e.printStackTrace();
        } catch (Exception io) {
            System.out.println("Catch No 5a " + io);
        } finally {
            System.out.println("Outer finally");
        }

        System.out.println("Statement No 6 - Main");
    }
}
package com.collections;

import java.util.*;

public class Program {

    public static void main(String[] args) {

        List<String> colorList = new ArrayList<>();
        List<String> colorList2 = new ArrayList<>();

        System.out.println("=== ARRAYLIST OPERATIONS ===");

        Q1(colorList);
        System.out.println("\n=== 1. Original List ===");
        displayList(colorList);

        Q2(colorList);
        System.out.println("\n=== 2. After inserting at first position ===");
        displayList(colorList);

        Q3(colorList);

        Q4(colorList);
        System.out.println("\n=== 4. After updating index 4 ===");
        displayList(colorList);

        Q5(colorList);
        System.out.println("\n=== 5. After removing third element (index 2) ===");
        displayList(colorList);

        Q6(colorList);

        Q7(colorList);
        System.out.println("\n=== 7. After sorting ===");
        displayList(colorList);

        Q8(colorList2, colorList);
        
        Q9(colorList2);
        System.out.println("\n=== 9. After shuffling ===");
        displayList(colorList2);

        Q10(colorList2);
        System.out.println("\n=== 10. After reversing ===");
        displayList(colorList2);

        System.out.println("\n\n=== TREESET OPERATIONS ===");

        TreeSet<String> colors = new TreeSet<>();

        Q11(colors);
        Q12(colors);
        Q13(colors);
        Q14(colors);
        Q15(colors);
    }

    public static void displayList(List<String> list) {
        for (String color : list) {
            System.out.println(color);
        }
    }

    public static void displayTreeSet(TreeSet<String> set) {
        for (String color : set) {
            System.out.println(color);
        }
    }

    public static void Q1(List<String> colorList) {
        colorList.add("Royal Blue");
        colorList.add("Girly Pink");
        colorList.add("Shiny Black");
        colorList.add("Dirty Yellow");
        colorList.add("Golden Yellow");
    }

    public static void Q2(List<String> colorList) {
        colorList.add(0, "Blank Pink");
    }

    public static void Q3(List<String> colorList) {
        System.out.println("\n=== 3. Element at index 1: " + colorList.get(1));
    }

    public static void Q4(List<String> colorList) {
        colorList.set(4, "White");
    }

    public static void Q5(List<String> colorList) {
        colorList.remove(2);
    }

    public static void Q6(List<String> colorList) {
        System.out.println("\n=== 6. Contains 'Royal Blue'? " + colorList.contains("Royal Blue"));
    }

    public static void Q7(List<String> colorList) {
        Collections.sort(colorList);
    }

    public static void Q8(List<String> colorList2, List<String> colorList) {
        colorList2.clear();
        colorList2.addAll(colorList);
        System.out.println("\n=== 8. List 2 after copying ===");
        displayList(colorList2);
    }

    public static void Q9(List<String> colorList2) {
        Collections.shuffle(colorList2);
    }

    public static void Q10(List<String> colorList2) {
        Collections.reverse(colorList2);
    }

    public static void Q11(TreeSet<String> colors) {
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Orange");
        colors.add("Purple");

        System.out.println("\n=== 11. TreeSet of Colors ===");
        displayTreeSet(colors);
    }

    public static void Q12(TreeSet<String> colors) {
        TreeSet<String> newColors = new TreeSet<>();
        newColors.add("Black");
        newColors.add("White");
        newColors.add("Gray");

        colors.addAll(newColors);

        System.out.println("\n=== 12. After adding elements from another TreeSet ===");
        displayTreeSet(colors);
    }

    public static void Q13(TreeSet<String> colors) {
        System.out.println("\n=== 13. Reverse Order View ===");
        NavigableSet<String> reverseSet = colors.descendingSet();
        for (String color : reverseSet) {
            System.out.println(color);
        }
    }

    public static void Q14(TreeSet<String> colors) {
        System.out.println("\n=== 14. First and Last Elements ===");
        System.out.println("First Element  : " + colors.first());
        System.out.println("Last Element   : " + colors.last());
    }

    public static void Q15(TreeSet<String> colors) {
        System.out.println("\n=== 15. Ceiling Examples ===");
        System.out.println("Ceiling of 'Green'     : " + colors.ceiling("Green"));
        System.out.println("Ceiling of 'Pink'      : " + colors.ceiling("Pink"));
        System.out.println("Ceiling of 'White'     : " + colors.ceiling("White"));
        System.out.println("Ceiling of 'Zebra'     : " + colors.ceiling("Zebra"));
    }
}
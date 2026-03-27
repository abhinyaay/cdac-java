package com.abhinyaay;

@FunctionalInterface
public interface Sort {
    public void ascending();
    public default void descending() {
        System.out.println("This is the default implement of Descending");
    }
}
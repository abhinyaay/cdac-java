package com.abhinyaay;

public abstract class Adapter {
    protected int value;

    public void display() {
        System.out.println("Display of Adapter");
    }

    public abstract void show();
}
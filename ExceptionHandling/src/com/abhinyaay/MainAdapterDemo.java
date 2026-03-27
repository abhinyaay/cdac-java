package com.abhinyaay;

public class MainAdapterDemo {

    public static void main(String[] args) {
        Adapter objAdapter = new Adapter() {
            @Override
            public void show() {
                System.out.println("show of adapter");
            }
        };

        objAdapter.display();
        objAdapter.show();
    }
}
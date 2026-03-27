package com.abhinyaay;


class Manager extends Employee
{
    private float hra;

    public Manager(String name, String address, int age, boolean gender, float basicSalary, float hra)
    {
        super(name, address, age, gender, basicSalary);
        this.hra = hra;
    }

    public float getHra()
    {
        return hra;
    }

    @Override
    public void display()
    {
        System.out.println("\nManager:");
        super.display();
        System.out.println("HRA : " + hra);
    }
}
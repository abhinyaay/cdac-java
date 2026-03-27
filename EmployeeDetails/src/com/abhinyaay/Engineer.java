package com.abhinyaay;


class Engineer extends Employee
{
    private float overTime;

    public Engineer(String name, String address, int age, boolean gender, float basicSalary, float overTime)
    {
        super(name, address, age, gender, basicSalary);
        this.overTime = overTime;
    }

    public float getOverTime()
    {
        return overTime;
    }

    @Override
    public void display()
    {
        System.out.println("\nEngineer:");
        super.display();
        System.out.println("OverTime : " + overTime);
    }
}
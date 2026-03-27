package com.abhinyaay;


class SalesPerson extends Employee
{
    private float commission;

    public SalesPerson(String name, String address, int age, boolean gender, float basicSalary, float commission)
    {
        super(name, address, age, gender, basicSalary);
        this.commission = commission;
    }

    public float getCommission()
    {
        return commission;
    }

    @Override
    public void display()
    {
        System.out.println("\nSalesPerson:");
        super.display();
        System.out.println("Commission : " + commission);
    }
}
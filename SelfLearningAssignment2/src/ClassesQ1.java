class Student {
    String name;
    int roll_no;
    String phone_no;
    String address;
}

public class ClassesQ1 {
    public static void main(String[] args) {
        // Part a: Assign the value of roll_no as '2' and that of name as "John"
        Student s1 = new Student();
        s1.name = "John";
        s1.roll_no = 2;
        System.out.println("Part A Student: " + s1.name + ", Roll No: " + s1.roll_no);

        // Part b: Assign and print the roll number, phone number and address of two students 
        // having names "Sam" and "John" respectively 
        Student john = new Student();
        john.name = "John";
        john.roll_no = 12;
        john.phone_no = "123-456-7890";
        john.address = "123 John Street";

        Student sam = new Student();
        sam.name = "Sam";
        sam.roll_no = 13;
        sam.phone_no = "987-654-3210";
        sam.address = "456 Sam Avenue";

        System.out.println("Part B Student: " + john.name + ", Roll No: " + john.roll_no + ", Phone: " + john.phone_no + ", Address: " + john.address);
        System.out.println("Part B Student: " + sam.name + ", Roll No: " + sam.roll_no + ", Phone: " + sam.phone_no + ", Address: " + sam.address);
    }
}

package Employee;

public abstract class Employee {

	protected String name;
	protected String address;
	protected int age;
	protected boolean gender;
	protected float basicSalary;
	
	public Employee(String name, String address, int age, boolean gender, float basicSalary) {
		super();
		setName(name);
		setAddress(address);
		setAge(age);
		setGender(gender);
		setBasicSalary(basicSalary);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name == null || name.length() == 0 || name.equals("")) {
			this.name = "Default Name";
		} else {
			this.name = name;
		}
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address == null || address.length() == 0 || address.equals("")) {
			this.address = "Default address";
		} else {
			this.address = address;
		}
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age >= 18 && age <= 90) {
		this.age = age;
		} else {
			this.age = 18;
		}
	}
	
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		if(basicSalary >= 1000 && basicSalary <= 150000) {
		this.basicSalary = basicSalary;
		} else {
			this.basicSalary = 10000;
		}
	}
	
	public abstract String toCSV();
	
	public String display() {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("Name: ");
		strBuffer.append(name);
		strBuffer.append(" Address: ");
		strBuffer.append(address);
		strBuffer.append(" Age: ");
		strBuffer.append(age);
		strBuffer.append(" Gender: ");
		strBuffer.append(gender ? "M" : "F");
		strBuffer.append(" Basic Salary: ");
		strBuffer.append(basicSalary);
		
		return strBuffer.toString();
	}
	
}


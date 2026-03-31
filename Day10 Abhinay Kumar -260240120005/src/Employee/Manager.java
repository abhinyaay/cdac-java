package Employee;

public class Manager extends Employee {

	protected float hra;

	public Manager(String name, String address, int age, boolean gender, float basicSalary, float hra) {
		super(name, address, age, gender, basicSalary);
		
		setHra(hra);
	}

	public float getHra() {
		return hra;
	}

	public void setHra(float hra) {
		if(hra >= 2000 && hra <= 30000) {
			this.hra = hra;
			} else {
				this.hra = 2000;
			}
	}
	
	@Override
    public String toCSV() {
        return String.format("Name: %s Address: %s Age: %d Gender: %s Basic Salary: %.2f HRA: %.2f",
                name, address, age, gender ? "M" : "F", basicSalary, hra);
    }
	
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
		strBuffer.append(" HRA: ");
		strBuffer.append(hra);
		return strBuffer.toString();
	}
	
	
}

package Employee;

public class Salesman extends Employee {

	protected float commission;

	public Salesman(String name, String address, int age, boolean gender, float basicSalary, float commission) {
		super(name, address, age, gender, basicSalary);
		
		setCommission(commission);
	}

	public float getCommission() {
		return commission;
	}

	public void setCommission(float commission) {
		if(commission >= (float)2.5 && commission <= (float)12.5) {
			this.commission = commission;
			} else {
				this.commission = (float)2.5;
			}
	}
	
	@Override
    public String toCSV() {
        return String.format("Name: %s Address: %s Age: %d Gender: %s Basic Salary: %.2f Commission Percent: %.2f",
                name, address, age, gender ? "M" : "F", basicSalary, commission);
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
		strBuffer.append(" Commission Percent: ");
		strBuffer.append(commission);
		return strBuffer.toString();
	}
	

}
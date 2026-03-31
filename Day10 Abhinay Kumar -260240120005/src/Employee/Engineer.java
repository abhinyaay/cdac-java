package Employee;

public class Engineer extends Employee {

	protected float overTime;

	public Engineer(String name, String address, int age, boolean gender, float basicSalary, float overTime) {
		super(name, address, age, gender, basicSalary);
		
		setOverTime(overTime);
	}
	
	public float getOverTime() {
		return overTime;
	}

	public void setOverTime(float overTime) {
		if(overTime >= 0 && overTime <= 4) {
			this.overTime = overTime;
			} else {
				this.overTime = 0;
			}
	}

	@Override
    public String toCSV() {
        return String.format("Name: %s Address: %s Age: %d Gender: %s Basic Salary: %.2f OverTime: %.2f",
                name, address, age, gender ? "M" : "F", basicSalary, overTime);
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
		strBuffer.append(" Over Time: ");
		strBuffer.append(overTime);
		return strBuffer.toString();
	}
	
}
package Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.huzaifa.utils.LinkedList;
import Day_2.ConsoleInput;

class EmployeeException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmployeeException(String exception) {
		super(exception);
	}
}

public class Program {

	public static void main(String[] args) throws EmployeeException {

		String choice;

		LinkedList<Employee> employeeList = new LinkedList<>();
		
		do {
			try {

				int option;

				final int ADD_EMPLOYEE = 1;
				final int DISPLAY_EMPLOYEE = 2;
				final int SORT_EMPLOYEE = 3;
				final int SAVE_EMPLOYEE = 4;
				final int LOAD_EMPLOYEE = 5;
				final int EXIT = 6;

				System.out.println("=== Employee Menu ===");
				System.out.println("1. Add an Employee");
				System.out.println("2. Display Employees");
				System.out.println("3. Sort Employees");
				System.out.println("4. Save to File");
				System.out.println("5. Load from File");
				System.out.println("6. Exit");

				option = ConsoleInput.getInt();

				if (option > 6 || option < 1) {
					throw new EmployeeException("Wrong Employee Menu Option");
				}
				switch (option) {
				case ADD_EMPLOYEE: {
					String emp_choice;

					do {
						try {
							int emp_option;

							final int ADD_MANAGER = 1;
							final int ADD_SALESMAN = 2;
							final int ADD_ENGINEER = 3;
							final int EXIT_ADD = 4;

							System.out.println("=== Select Employee Type ===");
							System.out.println("1. Add Manager");
							System.out.println("2. Add Salesman");
							System.out.println("3. Add Engineer");
							System.out.println("4. Exit");

							emp_option = ConsoleInput.getInt();
							if (emp_option > 4 || emp_option < 1) {
								throw new EmployeeException("Wrong Employee Type");
							}
							switch (emp_option) {
							case ADD_MANAGER:
								addManager(employeeList);
								break;
							case ADD_SALESMAN:
								addSalesman(employeeList);
								break;
							case ADD_ENGINEER:
								addEngineer(employeeList);
								break;
							case EXIT_ADD: {
								System.out.println("Exiting from Add Menu! ....");
								break;
							}
							default: {
								System.out.println("Invalid Choice! Enter Correct Option From Add Menu");
							}
							}
						} catch (EmployeeException e) {
							System.out.println("Exception Caught: " + e.getMessage());
							e.printStackTrace();
						} finally {
							System.out.println("Press Y to continue to adding employees: ");
							emp_choice = ConsoleInput.getString();
						}

					} while (emp_choice.trim().equalsIgnoreCase("Y"));

				}
					break;
				case DISPLAY_EMPLOYEE: {
					String emp_choice;

					do {

						int emp_option;

						final int ALL_EMP = 1;
						final int FIRST_EMP = 2;
						final int NEXT_EMP = 3;
						final int PREV_EMP = 4;
						final int LAST_EMP = 5;
						final int EXIT_DISPLAY = 6;

						System.out.println("=== Select Display Type ===");
						System.out.println("1. All Employees");
						System.out.println("2. First Employee");
						System.out.println("3. Next Employee");
						System.out.println("4. Previous Employee");
						System.out.println("5. Last Employee");
						System.out.println("6. Exit");

						emp_option = ConsoleInput.getInt();

						switch (emp_option) {
						case ALL_EMP:
							displayAllEmployees(employeeList);
							break;
						case FIRST_EMP:
							displayFirstEmployee(employeeList);
							break;
						case NEXT_EMP:
							displayNextEmployee(employeeList);
							break;
						case PREV_EMP:
							displayPreviousEmployee(employeeList);
							break;
						case LAST_EMP:
							displayLastEmployee(employeeList);
							break;
						case EXIT_DISPLAY: {
							System.out.println("Exiting from Display Menu! ....");
							break;
						}
						default: {
							System.out.println("Invalid Choice! Enter Correct Option From Display Menu");
						}
						}
						System.out.println("Press Y to continue to displaying employees: ");
						emp_choice = ConsoleInput.getString();

					} while (emp_choice.trim().equalsIgnoreCase("Y"));

				}
					break;
				case SORT_EMPLOYEE: {
					String emp_choice;

					do {

						int emp_option;

						LinkedList<Employee> managerList = new LinkedList<>();
						LinkedList<Employee> salesmanList = new LinkedList<>();
						LinkedList<Employee> engineerList = new LinkedList<Employee>();

						Employee employee[] = new Employee[employeeList.getMaxCount()];

						Object data = employeeList.getFirst();

						for (int index = 0; index < employeeList.getMaxCount(); index++) {

							Employee objEmployee = (Employee) data;
							employee[index] = objEmployee;

							if (objEmployee instanceof Manager) {

								Manager manager = (Manager) objEmployee;
								managerList.add(manager);

							} else if (objEmployee instanceof Salesman) {
								Salesman salesman = (Salesman) objEmployee;
								salesmanList.add(salesman);
							} else if (objEmployee instanceof Engineer) {
								Engineer engineer = (Engineer) objEmployee;
								engineerList.add(engineer);
							} else {
								System.out.println("Unknown employee type");
							}
							data = employeeList.getNext();
						}

						Manager manager[] = new Manager[managerList.getMaxCount()];
						Salesman salesman[] = new Salesman[salesmanList.getMaxCount()];
						Engineer engineer[] = new Engineer[engineerList.getMaxCount()];

						final int ALL_MANAGERS = 1;
						final int ALL_SALESMEN = 2;
						final int ALL_ENGINEERS = 3;
						final int ALL_EMP_ASC = 4;
						final int ALL_EMP_DESC = 5;
						final int EXIT_SORT = 6;

						System.out.println("=== Select Sorting Type ===");
						System.out.println("1. All Managers");
						System.out.println("2. All Salesmen");
						System.out.println("3. All Engineers");
						System.out.println("4. All Employees in Ascending Order");
						System.out.println("5. All Employees in Descending Order");
						System.out.println("6. Exit");

						emp_option = ConsoleInput.getInt();

						switch (emp_option) {
						case ALL_MANAGERS: {

							Object mgrData = managerList.getFirst();
							for (int index = 0; index < managerList.getMaxCount(); index++) {

								manager[index] = (Manager) mgrData;
								mgrData = managerList.getNext();
							}

							System.out.println("Please Enter N for sort by name or S for sort by salary");
							String sortChoice = ConsoleInput.getString();
							if (sortChoice.trim().equalsIgnoreCase("N"))
								sortManagerByName(manager);
							else if (sortChoice.trim().equalsIgnoreCase("S"))
								sortManagerBySalary(manager);
							else {
								System.out.println("Wrong choice!");
								break;
							}

						}
							break;
						case ALL_SALESMEN: {

							Object slmData = salesmanList.getFirst();
							for (int index = 0; index < salesmanList.getMaxCount(); index++) {

								salesman[index] = (Salesman) slmData;
								slmData = salesmanList.getNext();
							}

							System.out.println("Please Enter N for sort by name or S for sort by salary");
							String sortChoice = ConsoleInput.getString();
							if (sortChoice.trim().equalsIgnoreCase("N"))
								sortSalesmenByName(salesman);
							else if (sortChoice.trim().equalsIgnoreCase("S"))
								sortSalesmenBySalary(salesman);
							else {
								System.out.println("Wrong choice!");
								break;
							}

						}
							break;
						case ALL_ENGINEERS: {

							Object engData = engineerList.getFirst();
							for (int index = 0; index < engineerList.getMaxCount(); index++) {

								engineer[index] = (Engineer) engData;
								engData = engineerList.getNext();
							}
							System.out.println("Please Enter N for sort by name or S for sort by salary");
							String sortChoice = ConsoleInput.getString();
							if (sortChoice.trim().equalsIgnoreCase("N"))
								sortEngineersByName(engineer);
							else if (sortChoice.trim().equalsIgnoreCase("S"))
								sortEngineersBySalary(engineer);
							else {
								System.out.println("Wrong choice!");
								break;
							}
						}
							break;
						case ALL_EMP_ASC: {

							System.out.println("Please Enter N for sort by name or S for sort by salary");
							String sortChoice = ConsoleInput.getString();
							if (sortChoice.trim().equalsIgnoreCase("N"))
								sortEmployeeByNameAsc(employee);
							else if (sortChoice.trim().equalsIgnoreCase("S"))
								sortEmployeeBySalaryAsc(employee);
							else {
								System.out.println("Wrong choice!");
								break;
							}
						}
							break;
						case ALL_EMP_DESC: {

							System.out.println("Please Enter N for sort by name or S for sort by salary");
							String sortChoice = ConsoleInput.getString();
							if (sortChoice.trim().equalsIgnoreCase("N"))
								sortEmployeeByNameDesc(employee);
							else if (sortChoice.trim().equalsIgnoreCase("S"))
								sortEmployeeBySalaryDesc(employee);
							else {
								System.out.println("Wrong choice!");
								break;
							}
						}
							break;
						case EXIT_SORT: {
							System.out.println("Exiting from Sort Menu! ....");
							break;
						}
						default: {
							System.out.println("Invalid Choice! Enter Correct Option From Sort Menu");
						}
						}
						System.out.println("Press Y to continue to sorting employees: ");
						emp_choice = ConsoleInput.getString();

					} while (emp_choice.trim().equalsIgnoreCase("Y"));

				}
					break;
				case SAVE_EMPLOYEE: saveEmployee(employeeList);
					break;
				case LOAD_EMPLOYEE: loadFile(employeeList);
					break;
				case EXIT: {
					System.out.println("Exiting from Employee Menu! ....");
					break;
				}
				default: {
					System.out.println("Invalid Choice! Enter Correct Option From Employee Menu");
				}
				}

			} catch (EmployeeException e) {
				System.out.println("Exception Caught: " + e.getMessage());
				e.printStackTrace();
			} finally {
				System.out.println("Press Y to continue to Employee Menu: ");
				choice = ConsoleInput.getString();
			}

		} while (choice.trim().equalsIgnoreCase("Y"));

	}

	public static void loadFile(LinkedList<Employee> employeeList) {
	    try (BufferedReader br = new BufferedReader(new FileReader(
	            "C:\\Users\\pgcp-ac\\Documents\\Java\\a_java_demos\\FileHandling\\Employee.txt"))) {

	        String line;
	        Pattern p = Pattern.compile(
	            "Name: (\\S+) Address: (\\S+) Age: (\\d+) Gender: (\\S+) Basic Salary: (\\d+\\.?\\d*) (HRA|Commission Percent|OverTime): (\\d+\\.?\\d*)"
	        );

	        while ((line = br.readLine()) != null) {
	            Matcher m = p.matcher(line);

	            if (m.find()) {
	                String name = m.group(1);
	                String address = m.group(2);
	                int age = Integer.parseInt(m.group(3));
	                boolean gender = m.group(4).trim().equalsIgnoreCase("m");
	                float basicSalary = Float.parseFloat(m.group(5));
	                String type = m.group(6);
	                float value = Float.parseFloat(m.group(7));

	                switch (type) {
	                    case "HRA":
	                        employeeList.add(new Manager(name, address, age, gender, basicSalary, value));
	                        break;
	                    case "Commission Percent":
	                        employeeList.add(new Salesman(name, address, age, gender, basicSalary, value));
	                        break;
	                    case "OverTime":
	                        employeeList.add(new Engineer(name, address, age, gender, basicSalary, value));
	                        break;
	                }
	            }
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.out.println("Loading from file! ....");
	}


	public static void saveEmployee(LinkedList<Employee> employeeList) {
		try (FileOutputStream outFile = new FileOutputStream(
				"C:\\Users\\pgcp-ac\\Documents\\Java\\a_java_demos\\FileHandling\\Employee.txt")) {

			Employee data = employeeList.getFirst();
			while(data != null) {

				outFile.write(data.display().getBytes());
				outFile.write("\n".getBytes());

			data = employeeList.getNext();
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Saving to file! ....");
	}

	public static void sortManagerByName(Manager[] manager) {
		System.out.println("Sorted Managers according to name in Ascending Order");
		for (int outerIndex = 0; outerIndex < manager.length - 1; outerIndex++) {
			for (int innerIndex = 0; innerIndex < manager.length - outerIndex - 1; innerIndex++) {
				String name1 = manager[innerIndex].getName();
				String name2 = manager[innerIndex + 1].getName();
				if (name1.compareTo(name2) > 0) {
					Manager temp = manager[innerIndex];
					manager[innerIndex] = manager[innerIndex + 1];
					manager[innerIndex + 1] = temp;

				}
			}
		}

		for (int index = 0; index < manager.length; index++) {
			System.out.println(manager[index].display());
		}
	}

	public static void sortManagerBySalary(Manager[] manager) {
		System.out.println("Sorted Managers according to salary in Ascending Order");
		for (int outerIndex = 0; outerIndex < manager.length - 1; outerIndex++) {
			for (int innerIndex = 0; innerIndex < manager.length - outerIndex - 1; innerIndex++) {
				float salary1 = manager[innerIndex].getBasicSalary();
				float salary2 = manager[innerIndex + 1].getBasicSalary();
				if (salary1 > salary2) {
					Manager temp = manager[innerIndex];
					manager[innerIndex] = manager[innerIndex + 1];
					manager[innerIndex + 1] = temp;

				}
			}
		}
		for (int index = 0; index < manager.length; index++) {
			System.out.println(manager[index].display());
		}
	}

	public static void sortSalesmenByName(Salesman[] salesman) {
		System.out.println("Sorted Salesmen according to name in Ascending Order");
		for (int outerIndex = 0; outerIndex < salesman.length - 1; outerIndex++) {
			for (int innerIndex = 0; innerIndex < salesman.length - outerIndex - 1; innerIndex++) {
				String name1 = salesman[innerIndex].getName();
				String name2 = salesman[innerIndex + 1].getName();
				if (name1.compareTo(name2) > 0) {
					Salesman temp = salesman[innerIndex];
					salesman[innerIndex] = salesman[innerIndex + 1];
					salesman[innerIndex + 1] = temp;

				}
			}
		}

		for (int index = 0; index < salesman.length; index++) {
			System.out.println(salesman[index].display());
		}
	}

	public static void sortSalesmenBySalary(Salesman[] salesman) {
		System.out.println("Sorted Salesmen according to salary in Ascending Order");
		for (int outerIndex = 0; outerIndex < salesman.length - 1; outerIndex++) {
			for (int innerIndex = 0; innerIndex < salesman.length - outerIndex - 1; innerIndex++) {
				float salary1 = salesman[innerIndex].getBasicSalary();
				float salary2 = salesman[innerIndex + 1].getBasicSalary();
				if (salary1 > salary2) {
					Salesman temp = salesman[innerIndex];
					salesman[innerIndex] = salesman[innerIndex + 1];
					salesman[innerIndex + 1] = temp;

				}
			}
		}

		for (int index = 0; index < salesman.length; index++) {
			System.out.println(salesman[index].display());
		}
	}

	public static void sortEngineersBySalary(Engineer[] engineer) {
		System.out.println("Sorted Engineers according to salary in Ascending Order");
		for (int outerIndex = 0; outerIndex < engineer.length - 1; outerIndex++) {
			for (int innerIndex = 0; innerIndex < engineer.length - outerIndex - 1; innerIndex++) {
				float salary1 = engineer[innerIndex].getBasicSalary();
				float salary2 = engineer[innerIndex + 1].getBasicSalary();
				if (salary1 > salary2) {
					Engineer temp = engineer[innerIndex];
					engineer[innerIndex] = engineer[innerIndex + 1];
					engineer[innerIndex + 1] = temp;

				}
			}
		}

		for (int index = 0; index < engineer.length; index++) {
			System.out.println(engineer[index].display());
		}
	}

	public static void sortEngineersByName(Engineer[] engineer) {
		System.out.println("Sorted Engineers according to name in Ascending Order");
		for (int outerIndex = 0; outerIndex < engineer.length - 1; outerIndex++) {
			for (int innerIndex = 0; innerIndex < engineer.length - outerIndex - 1; innerIndex++) {
				String name1 = engineer[innerIndex].getName();
				String name2 = engineer[innerIndex + 1].getName();
				if (name1.compareTo(name2) > 0) {
					Engineer temp = engineer[innerIndex];
					engineer[innerIndex] = engineer[innerIndex + 1];
					engineer[innerIndex + 1] = temp;

				}
			}
		}

		for (int index = 0; index < engineer.length; index++) {
			System.out.println(engineer[index].display());
		}
	}

	public static void sortEmployeeByNameAsc(Employee[] employee) {
		System.out.println("Sorted Employee according to name in Ascending Order");
		for (int outerIndex = 0; outerIndex < employee.length - 1; outerIndex++) {
			for (int innerIndex = 0; innerIndex < employee.length - outerIndex - 1; innerIndex++) {
				String name1 = employee[innerIndex].getName();
				String name2 = employee[innerIndex + 1].getName();
				if (name1.compareTo(name2) > 0) {
					Employee temp = employee[innerIndex];
					employee[innerIndex] = employee[innerIndex + 1];
					employee[innerIndex + 1] = temp;

				}
			}
		}

		for (int index = 0; index < employee.length; index++) {
			System.out.println(employee[index].display());
		}
	}

	public static void sortEmployeeBySalaryAsc(Employee[] employee) {
		System.out.println("Sorted Employee according to salary in Ascending Order");
		for (int outerIndex = 0; outerIndex < employee.length - 1; outerIndex++) {
			for (int innerIndex = 0; innerIndex < employee.length - outerIndex - 1; innerIndex++) {
				float salary1 = employee[innerIndex].getBasicSalary();
				float salary2 = employee[innerIndex + 1].getBasicSalary();
				if (salary1 > salary2) {
					Employee temp = employee[innerIndex];
					employee[innerIndex] = employee[innerIndex + 1];
					employee[innerIndex + 1] = temp;

				}
			}
		}

		for (int index = 0; index < employee.length; index++) {
			System.out.println(employee[index].display());
		}
	}

	public static void sortEmployeeBySalaryDesc(Employee[] employee) {
		System.out.println("Sorted Employee according to salary in Descending Order");
		for (int outerIndex = 0; outerIndex < employee.length - 1; outerIndex++) {
			for (int innerIndex = 0; innerIndex < employee.length - outerIndex - 1; innerIndex++) {
				float salary1 = employee[innerIndex].getBasicSalary();
				float salary2 = employee[innerIndex + 1].getBasicSalary();
				if (salary1 < salary2) {
					Employee temp = employee[innerIndex];
					employee[innerIndex] = employee[innerIndex + 1];
					employee[innerIndex + 1] = temp;

				}
			}
		}
		for (int index = 0; index < employee.length; index++) {
			System.out.println(employee[index].display());
		}
	}

	public static void sortEmployeeByNameDesc(Employee[] employee) {
		System.out.println("Sorted Employee according to name in Descending Order");
		for (int outerIndex = 0; outerIndex < employee.length - 1; outerIndex++) {
			for (int innerIndex = 0; innerIndex < employee.length - outerIndex - 1; innerIndex++) {
				String name1 = employee[innerIndex].getName();
				String name2 = employee[innerIndex + 1].getName();
				if (name1.compareTo(name2) < 0) {
					Employee temp = employee[innerIndex];
					employee[innerIndex] = employee[innerIndex + 1];
					employee[innerIndex + 1] = temp;

				}
			}
		}

		for (int index = 0; index < employee.length; index++) {
			System.out.println(employee[index].display());
		}
	}

	public static void displayLastEmployee(LinkedList<Employee> employeeList) {
		Employee data = employeeList.getLast();
		Employee objEmployee = (Employee) data;

		if (objEmployee instanceof Manager) {

			Manager manager = (Manager) objEmployee;
			System.out.println(manager.display());
		} else if (objEmployee instanceof Salesman) {
			Salesman salesman = (Salesman) objEmployee;
			System.out.println(salesman.display());
		} else if (objEmployee instanceof Engineer) {
			Engineer engineer = (Engineer) objEmployee;
			System.out.println(engineer.display());
		} else {
			System.out.println("Unknown employee type");
		}
	}

	public static void displayPreviousEmployee(LinkedList<Employee> employeeList) {
		Employee data = employeeList.getPrevious();
		Employee objEmployee = (Employee) data;

		if (objEmployee instanceof Manager) {

			Manager manager = (Manager) objEmployee;
			System.out.println(manager.display());
		} else if (objEmployee instanceof Salesman) {
			Salesman salesman = (Salesman) objEmployee;
			System.out.println(salesman.display());
		} else if (objEmployee instanceof Engineer) {
			Engineer engineer = (Engineer) objEmployee;
			System.out.println(engineer.display());
		} else {
			System.out.println("Unknown employee type");
		}
	}

	public static void displayNextEmployee(LinkedList<Employee> employeeList) {
		Employee data = employeeList.getNext();
		Employee objEmployee = (Employee) data;

		if (objEmployee instanceof Manager) {

			Manager manager = (Manager) objEmployee;
			System.out.println(manager.display());
		} else if (objEmployee instanceof Salesman) {
			Salesman salesman = (Salesman) objEmployee;
			System.out.println(salesman.display());
		} else if (objEmployee instanceof Engineer) {
			Engineer engineer = (Engineer) objEmployee;
			System.out.println(engineer.display());
		} else {
			System.out.println("Unknown employee type");
		}
	}

	public static void displayFirstEmployee(LinkedList<Employee> employeeList) {
		Employee data = employeeList.getFirst();
		Employee objEmployee = (Employee) data;

		if (objEmployee instanceof Manager) {

			Manager manager = (Manager) objEmployee;
			System.out.println(manager.display());
		} else if (objEmployee instanceof Salesman) {
			Salesman salesman = (Salesman) objEmployee;
			System.out.println(salesman.display());
		} else if (objEmployee instanceof Engineer) {
			Engineer engineer = (Engineer) objEmployee;
			System.out.println(engineer.display());
		} else {
			System.out.println("Unknown employee type");
		}
	}

	public static void displayAllEmployees(LinkedList<Employee> employeeList) {
		Employee data = employeeList.getFirst();
		while (data != null) {

			Employee objEmployee = (Employee) data;

			if (objEmployee instanceof Manager) {

				Manager manager = (Manager) objEmployee;
				System.out.println(manager.display());
			} else if (objEmployee instanceof Salesman) {
				Salesman salesman = (Salesman) objEmployee;
				System.out.println(salesman.display());
			} else if (objEmployee instanceof Engineer) {
				Engineer engineer = (Engineer) objEmployee;
				System.out.println(engineer.display());
			} else {
				System.out.println("Unknown employee type");
			}

			data = employeeList.getNext();

			if (data == null) {
				break;
			}
		}
	}

	public static void addEngineer(LinkedList<Employee> employeeList) {
		System.out.println("Enter Name (Should not be Empty): ");
		String name = ConsoleInput.getString();
		System.out.println("Enter Address (Should not be Empty): ");
		String address = ConsoleInput.getString();
		System.out.println("Enter age (Should be from 18 to 90): ");
		int age = ConsoleInput.getInt();
		System.out.println("Enter gender! M for Male / F for Female : ");
		String gen = ConsoleInput.getString();
		boolean gender = true;
		if (gen.trim().equalsIgnoreCase("M")) {
			gender = true;
		} else {
			if (gen.trim().equalsIgnoreCase("F")) {
				gender = false;
			} else {
				System.out.println("Invalid Entry! Please enter M or F");
			}
		}
		System.out.println("Enter Basic Salary (Should be from 1000 to 150000): ");
		float basicSalary = ConsoleInput.getFloat();
		System.out.println("Enter Over Time (Should be from 0 to 4 hours): ");
		float overTime = ConsoleInput.getInt();
		Engineer objEngineer = new Engineer(name, address, age, gender, basicSalary, overTime);
		employeeList.add(objEngineer);
	}

	public static void addSalesman(LinkedList<Employee> employeeList) {
		System.out.println("Enter Name (Should not be Empty): ");
		String name = ConsoleInput.getString();
		System.out.println("Enter Address (Should not be Empty): ");
		String address = ConsoleInput.getString();
		System.out.println("Enter age (Should be from 18 to 90): ");
		int age = ConsoleInput.getInt();
		System.out.println("Enter gender! M for Male / F for Female : ");
		String gen = ConsoleInput.getString();
		boolean gender = true;
		if (gen.trim().equalsIgnoreCase("M")) {
			gender = true;
		} else {
			if (gen.trim().equalsIgnoreCase("F")) {
				gender = false;
			} else {
				System.out.println("Invalid Entry! Please enter M or F");
			}
		}
		System.out.println("Enter Basic Salary (Should be from 1000 to 150000): ");
		float basicSalary = ConsoleInput.getFloat();
		System.out.println("Enter Commision Percentage (Should be between 2.5% to 12.5% ): ");
		float commission = ConsoleInput.getFloat();
		Salesman objSalesman = new Salesman(name, address, age, gender, basicSalary, commission);
		employeeList.add(objSalesman);
	}

	public static void addManager(LinkedList<Employee> employeeList) {
		System.out.println("Enter Name (Should not be Empty): ");
		String name = ConsoleInput.getString();
		System.out.println("Enter Address (Should not be Empty): ");
		String address = ConsoleInput.getString();
		System.out.println("Enter age (Should be from 18 to 90): ");
		int age = ConsoleInput.getInt();
		System.out.println("Enter gender! M for Male / F for Female : ");
		String gen = ConsoleInput.getString();
		boolean gender = true;
		if (gen.trim().equalsIgnoreCase("M")) {
			gender = true;
		} else {
			if (gen.trim().equalsIgnoreCase("F")) {
				gender = false;
			} else {
				System.out.println("Invalid Entry! Please enter M or F");
			}
		}
		System.out.println("Enter Basic Salary (Should be from 1000 to 150000): ");
		float basicSalary = ConsoleInput.getFloat();
		System.out.println("Enter House and Rent Allowance (HRA) (Should be from 2000 to 30000): ");
		float hra = ConsoleInput.getFloat();

		Manager objManager = new Manager(name, address, age, gender, basicSalary, hra);
		employeeList.add(objManager);
	}

}

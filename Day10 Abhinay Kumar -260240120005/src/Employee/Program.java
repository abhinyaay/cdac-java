package Employee;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;

class EmployeeException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmployeeException(String exception) {
		super(exception);
	}
}

public class Program {

	public static void main(String[] args) throws EmployeeException {

		String choice;
		Scanner scan = new Scanner(System.in);
		
		List<Employee> employeeList = new ArrayList<>();

		do {
			try {

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

				int option = 0;
				if (scan.hasNextInt()) {
					scan.nextLine();
					option = scan.nextInt();
					scan.nextLine();
					System.out.println("You chose: " + option);
				} else {
					throw new EmployeeException("Invalid input, please enter a number.");

				}

				if (option > 6 || option < 1) {
					throw new EmployeeException("Wrong Employee Menu Option");
				}
				switch (option) {
				case ADD_EMPLOYEE: {
					String emp_choice;

					do {
						try {
						

							final int ADD_MANAGER = 1;
							final int ADD_SALESMAN = 2;
							final int ADD_ENGINEER = 3;
							final int EXIT_ADD = 4;

							System.out.println("=== Select Employee Type ===");
							System.out.println("1. Add Manager");
							System.out.println("2. Add Salesman");
							System.out.println("3. Add Engineer");
							System.out.println("4. Exit");

							int emp_option = 0;
							if (scan.hasNextInt()) {
								emp_option = scan.nextInt();
								scan.nextLine();
								System.out.println("You chose: " + option);
							} else {
								throw new EmployeeException("Invalid input, please enter a number.");

							}
							
							if (emp_option > 4 || emp_option < 1) {
								throw new EmployeeException("Wrong Employee Type");
							}
							switch (emp_option) {
							case ADD_MANAGER:
								addManager(scan, employeeList);
								break;
							case ADD_SALESMAN:
								addSalesman(scan, employeeList);
								break;
							case ADD_ENGINEER:
								addEngineer(scan, employeeList);
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
							emp_choice = scan.next();
						}

					} while (emp_choice.trim().equalsIgnoreCase("Y"));

				}
					break;
				case DISPLAY_EMPLOYEE: {
					String emp_choice;

					do {

						int emp_option = 0;
						if (scan.hasNextInt()) {
							emp_option = scan.nextInt();
							scan.nextLine();
							System.out.println("You chose: " + option);
						} else {
							throw new EmployeeException("Invalid input, please enter a number.");

						}
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

						ListIterator<Employee> iter = employeeList.listIterator();

						switch (emp_option) {
						case ALL_EMP:
							displayAllEmployees(employeeList.listIterator());
							break;
						case FIRST_EMP:
							displayFirstEmployee(employeeList, iter);
							break;
						case NEXT_EMP:
							displayNextEmployee(employeeList, iter);
							break;
						case PREV_EMP:
							displayPreviousEmployee(employeeList, iter);
							break;
						case LAST_EMP:
							displayLastEmployee(employeeList, iter);
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
						emp_choice = scan.next();

					} while (emp_choice.trim().equalsIgnoreCase("Y"));

				}
					break;
					
				case SORT_EMPLOYEE: {
					
					String emp_choice;

					do {

						int emp_option = 0;
						if (scan.hasNextInt()) {
							emp_option = scan.nextInt();
							scan.nextLine();
							System.out.println("You chose: " + option);
						} else {
							throw new EmployeeException("Invalid input, please enter a number.");

						}
						List<Employee> managerList = new LinkedList<>();
						List<Employee> salesmanList = new LinkedList<>();
						List<Employee> engineerList = new LinkedList<>();

						Employee employee[] = new Employee[employeeList.size()];
						ListIterator<Employee> iter = employeeList.listIterator();
						
						while(iter != null) {

								Employee objEmployee = (Employee) iter;

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

								if(iter.hasNext())
									objEmployee = iter.next();
								else {
									System.out.println("No Data !");
								}

							} 
						
						Manager manager[] = new Manager[managerList.size()];
						Salesman salesman[] = new Salesman[salesmanList.size()];
						Engineer engineer[] = new Engineer[engineerList.size()];

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


						switch (emp_option) {
						case ALL_MANAGERS: {

							Employee mgrData = managerList.get(0);
							for (int index = 0; index < managerList.size(); index++) {

								manager[index] = (Manager) mgrData;
								mgrData = managerList.get(index+1);
							}

							System.out.println("Please Enter N for sort by name or S for sort by salary");
							String sortChoice = scan.next();
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

							Employee slmData = salesmanList.get(0);
							for (int index = 0; index < salesmanList.size(); index++) {

								salesman[index] = (Salesman) slmData;
								slmData = salesmanList.get(index+1);
							}

							System.out.println("Please Enter N for sort by name or S for sort by salary");
							String sortChoice = scan.next();
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

							Employee engData = engineerList.get(0);
							for (int index = 0; index < engineerList.size(); index++) {

								engineer[index] = (Engineer) engData;
								engData = engineerList.get(index+1);
							}
							System.out.println("Please Enter N for sort by name or S for sort by salary");
							String sortChoice = scan.next();
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
							String sortChoice = scan.next();
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
							String sortChoice = scan.next();
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
						emp_choice = scan.next();

					} while (emp_choice.trim().equalsIgnoreCase("Y"));

				}
					break;
				case SAVE_EMPLOYEE:
					saveEmployee(employeeList);
					break;
				case LOAD_EMPLOYEE:
					loadFile(employeeList);
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
			}
			
			
				System.out.println("Press Y to continue to Employee Menu: ");
				choice = scan.next();
			

		} while (choice.trim().equalsIgnoreCase("Y"));
		
		scan.close();

	}

	
	public static void loadFile(List<Employee> employeeList) {
	    employeeList.clear(); // Clear existing data before loading

	    File file = new File("C:\\Users\\pgcp-ac\\Documents\\Java\\a_java_demos\\FileHandling\\Employee.csv");

	    if (!file.exists()) {
	        System.out.println("Employee.csv file not found!");
	        return;
	    }

	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {

	        String line;
	        // Improved regex - more flexible
	        Pattern p = Pattern.compile(
	            "Name:\\s*(\\S+)\\s+Address:\\s*(\\S+)\\s+Age:\\s*(\\d+)\\s+Gender:\\s*([MFmf])\\s+" +
	            "Basic Salary:\\s*(\\d+\\.?\\d*)\\s+(HRA|Commission Percent|OverTime):\\s*(\\d+\\.?\\d*)"
	        );

	        while ((line = br.readLine()) != null) {
	            line = line.trim();
	            if (line.isEmpty()) continue;

	            Matcher m = p.matcher(line);

	            if (m.find()) {
	                try {
	                    String name = m.group(1);
	                    String address = m.group(2);
	                    int age = Integer.parseInt(m.group(3));
	                    boolean gender = m.group(4).trim().equalsIgnoreCase("M");
	                    float basicSalary = Float.parseFloat(m.group(5));
	                    String type = m.group(6);
	                    float value = Float.parseFloat(m.group(7));

	                    switch (type.toLowerCase()) {
	                        case "hra":
	                            employeeList.add(new Manager(name, address, age, gender, basicSalary, value));
	                            break;
	                        case "commission percent":
	                            employeeList.add(new Salesman(name, address, age, gender, basicSalary, value));
	                            break;
	                        case "overtime":
	                            employeeList.add(new Engineer(name, address, age, gender, basicSalary, value));
	                            break;
	                        default:
	                            System.out.println("Unknown employee type: " + type);
	                    }
	                } catch (Exception ex) {
	                    System.out.println("Error parsing line: " + line);
	                    ex.printStackTrace();
	                }
	            } else {
	                System.out.println("Skipping invalid line: " + line);
	            }
	        }

	        System.out.println("Loading from file completed! " + employeeList.size() + " employees loaded.");

	    } catch (IOException e) {
	        System.out.println("Error loading file: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public static void saveEmployee(List<Employee> employeeList) {
	    if (employeeList == null || employeeList.isEmpty()) {
	        System.out.println("No employees to save!");
	        return;
	    }

	    try (PrintWriter writer = new PrintWriter(new FileWriter(
	            "C:\\Users\\pgcp-ac\\Documents\\Java\\a_java_demos\\FileHandling\\Employee.csv"))) {

	        for (Employee emp : employeeList) {
	            writer.println(emp.toCSV());
	        }

	        System.out.println("Saving to file completed! " + employeeList.size() + " employees saved.");

	    } catch (IOException e) {
	        System.out.println("Error saving file: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	
//	public static void loadFile(List<Employee> employeeList) {
//		try (BufferedReader br = new BufferedReader(
//				new FileReader("C:\\Users\\pgcp-ac\\Documents\\Java\\a_java_demos\\FileHandling\\Employee.txt"))) {
//
//			String line;
//			Pattern p = Pattern.compile(
//					"Name: (\\S+) Address: (\\S+) Age: (\\d+) Gender: (\\S+) Basic Salary: (\\d+\\.?\\d*) (HRA|Commission Percent|OverTime): (\\d+\\.?\\d*)");
//
//			while ((line = br.readLine()) != null) {
//				Matcher m = p.matcher(line);
//
//				if (m.find()) {
//					String name = m.group(1);
//					String address = m.group(2);
//					int age = Integer.parseInt(m.group(3));
//					boolean gender = m.group(4).trim().equalsIgnoreCase("m");
//					float basicSalary = Float.parseFloat(m.group(5));
//					String type = m.group(6);
//					float value = Float.parseFloat(m.group(7));
//
//					switch (type) {
//					case "HRA":
//						employeeList.add(new Manager(name, address, age, gender, basicSalary, value));
//						break;
//					case "Commission Percent":
//						employeeList.add(new Salesman(name, address, age, gender, basicSalary, value));
//						break;
//					case "OverTime":
//						employeeList.add(new Engineer(name, address, age, gender, basicSalary, value));
//						break;
//					}
//				}
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Loading from file! ....");
//	}
//
//	public static void saveEmployee(List<Employee> employeeList) {
//		try (FileOutputStream outFile = new FileOutputStream(
//				"C:\\Users\\pgcp-ac\\Documents\\Java\\a_java_demos\\FileHandling\\Employee.txt")) {
//
//			Employee data = employeeList.getFirst();
//			while (data != null) {
//
//				outFile.write(data.display().getBytes());
//				outFile.write("\n".getBytes());
//
//				data = employeeList.getNext();
//			}
//
//		} catch (FileNotFoundException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		System.out.println("Saving to file! ....");
//	}

	public static void sortManagerByName(Manager[] manager) {
		System.out.println("Sorted Managers according to name in Ascending Order");
Collections.sort(Arrays.asList(manager), new Comparator<Manager>() {
			@Override
			public int compare(Manager manager1, Manager manager2) {
				return manager1.getName().compareTo(manager2.getName());
			}
		});


		for (int index = 0; index < manager.length; index++) {
			System.out.println(manager[index].display());
		}
	}

	public static void sortManagerBySalary(Manager[] manager) {
		System.out.println("Sorted Managers according to salary in Ascending Order");
Arrays.sort(manager, new Comparator<Manager>() {
			@Override
			public int compare(Manager manager1, Manager manager2) {
				return Float.compare(manager1.getBasicSalary(), manager2.getBasicSalary());
			}
		});

		for (int index = 0; index < manager.length; index++) {
			System.out.println(manager[index].display());
		}
	}

	public static void sortSalesmenByName(Salesman[] salesman) {
		System.out.println("Sorted Salesmen according to name in Ascending Order");
Collections.sort(Arrays.asList(salesman), new Comparator<Salesman>() {
			@Override
			public int compare(Salesman salesman1, Salesman salesman2) {
				return salesman1.getName().compareTo(salesman2.getName());
			}
		});


		for (int index = 0; index < salesman.length; index++) {
			System.out.println(salesman[index].display());
		}
	}

	public static void sortSalesmenBySalary(Salesman[] salesman) {
		System.out.println("Sorted Salesmen according to salary in Ascending Order");
Arrays.sort(salesman, new Comparator<Salesman>() {
			@Override
			public int compare(Salesman salesman1, Salesman salesman2) {
				return Float.compare(salesman1.getBasicSalary(), salesman2.getBasicSalary());
			}
		});


		for (int index = 0; index < salesman.length; index++) {
			System.out.println(salesman[index].display());
		}
	}

	public static void sortEngineersBySalary(Engineer[] engineer) {
		System.out.println("Sorted Engineers according to salary in Ascending Order");
Arrays.sort(engineer, new Comparator<Engineer>() {
			@Override
			public int compare(Engineer engineer1, Engineer engineer2) {
				return Float.compare(engineer1.getBasicSalary(), engineer2.getBasicSalary());
			}
		});


		for (int index = 0; index < engineer.length; index++) {
			System.out.println(engineer[index].display());
		}
	}

	public static void sortEngineersByName(Engineer[] engineer) {
		System.out.println("Sorted Engineers according to name in Ascending Order");
Collections.sort(Arrays.asList(engineer), new Comparator<Engineer>() {
			@Override
			public int compare(Engineer engineer1, Engineer engineer2) {
				return engineer1.getName().compareTo(engineer2.getName());
			}
		});


		for (int index = 0; index < engineer.length; index++) {
			System.out.println(engineer[index].display());
		}
	}

	public static void sortEmployeeByNameAsc(Employee[] employee) {
		System.out.println("Sorted Employee according to name in Ascending Order");
Collections.sort(Arrays.asList(employee), new Comparator<Employee>() {
			@Override
			public int compare(Employee employee1, Employee employee2) {
				return employee1.getName().compareTo(employee2.getName());
			}
		});


		for (int index = 0; index < employee.length; index++) {
			System.out.println(employee[index].display());
		}
	}

	public static void sortEmployeeBySalaryAsc(Employee[] employee) {
		System.out.println("Sorted Employee according to salary in Ascending Order");
Arrays.sort(employee, new Comparator<Employee>() {
			@Override
			public int compare(Employee employee1, Employee employee2) {
				return Float.compare(employee1.getBasicSalary(), employee2.getBasicSalary());
			}
		});


		for (int index = 0; index < employee.length; index++) {
			System.out.println(employee[index].display());
		}
	}

	public static void sortEmployeeBySalaryDesc(Employee[] employee) {
		System.out.println("Sorted Employee according to salary in Descending Order");
Arrays.sort(employee, new Comparator<Employee>() {
			@Override
			public int compare(Employee employee1, Employee employee2) {
				return Float.compare(employee2.getBasicSalary(), employee1.getBasicSalary());
			}
		});

		for (int index = 0; index < employee.length; index++) {
			System.out.println(employee[index].display());
		}
	}

	public static void sortEmployeeByNameDesc(Employee[] employee) {
		System.out.println("Sorted Employee according to name in Descending Order");
Collections.sort(Arrays.asList(employee), new Comparator<Employee>() {
			@Override
			public int compare(Employee employee1, Employee employee2) {
				return employee2.getName().compareTo(employee1.getName());
			}
		});


		for (int index = 0; index < employee.length; index++) {
			System.out.println(employee[index].display());
		}
	}

	public static void displayLastEmployee(List<Employee> employeeList, ListIterator<Employee> iter) {

		int size = employeeList.size();
		Employee data = employeeList.get(size - 1);

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

	public static void displayPreviousEmployee(List<Employee> employeeList, ListIterator<Employee> iter) {
		Employee data = null;

		if (iter.hasPrevious())
			data = iter.previous();
		else {
			System.out.println("No Data");
			return;
		}
		
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

	public static void displayNextEmployee(List<Employee> employeeList, ListIterator<Employee> iter) {
		Employee data = null;

		if (iter.hasNext())
			data = iter.next();
		else {
			System.out.println("No Data");
			return;
		}
		
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

	public static void displayFirstEmployee(List<Employee> employeeList, ListIterator<Employee> iter) {
		Employee objEmployee = employeeList.get(0);

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

	public static void displayAllEmployees(ListIterator<Employee> iter) {

		while(iter != null) {
				Employee objEmployee = (Employee) iter;

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

				if(iter.hasNext())
					objEmployee = iter.next();
				else {
					System.out.println("No Data !");
				}

			} 
	}

	public static void addEngineer(Scanner scan, List<Employee> employeeList) {
		System.out.println("Enter Name (Should not be Empty): ");
		String name = scan.next();
		System.out.println("Enter Address (Should not be Empty): ");
		String address = scan.next();
		System.out.println("Enter age (Should be from 18 to 90): ");
		int age = scan.nextInt();
		System.out.println("Enter gender! M for Male / F for Female : ");
		String gen = scan.next();
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
		float basicSalary = scan.nextFloat();
		System.out.println("Enter Over Time (Should be from 0 to 4 hours): ");
		float overTime = scan.nextInt();
		Engineer objEngineer = new Engineer(name, address, age, gender, basicSalary, overTime);
		employeeList.add(objEngineer);
	}

	public static void addSalesman(Scanner scan, List<Employee> employeeList) {
		System.out.println("Enter Name (Should not be Empty): ");
		String name = scan.next();
		System.out.println("Enter Address (Should not be Empty): ");
		String address = scan.next();
		System.out.println("Enter age (Should be from 18 to 90): ");
		int age = scan.nextInt();
		System.out.println("Enter gender! M for Male / F for Female : ");
		String gen = scan.next();
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
		float basicSalary = scan.nextFloat();
		System.out.println("Enter Commision Percentage (Should be between 2.5% to 12.5% ): ");
		float commission = scan.nextFloat();
		Salesman objSalesman = new Salesman(name, address, age, gender, basicSalary, commission);
		employeeList.add(objSalesman);
	}

	public static void addManager(Scanner scan, List<Employee> employeeList) {
		System.out.println("Enter Name (Should not be Empty): ");
		String name = scan.next();
		System.out.println("Enter Address (Should not be Empty): ");
		String address = scan.next();
		System.out.println("Enter age (Should be from 18 to 90): ");
		int age = scan.nextInt();
		System.out.println("Enter gender! M for Male / F for Female : ");
		String gen = scan.next();
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
		float basicSalary = scan.nextFloat();
		System.out.println("Enter House and Rent Allowance (HRA) (Should be from 2000 to 30000): ");
		float hra = scan.nextFloat();

		Manager objManager = new Manager(name, address, age, gender, basicSalary, hra);
		employeeList.add(objManager);
	}

}

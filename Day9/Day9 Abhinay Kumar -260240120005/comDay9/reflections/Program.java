package com.reflections;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        String choice;
        String className = null;
        
        List<String> fields = new ArrayList<>();
        List<String> methods = new ArrayList<>();

        do {
            try {
                final int ADD_CLASSNAME = 1;
                final int ADD_FIELDS = 2;
                final int ADD_METHODS = 3;
                final int GENERATE_CLASS = 4;
                final int EXIT = 5;

                System.out.println("=== Reflections Menu ===");
                System.out.println("1. Add Class");
                System.out.println("2. Add Fields");
                System.out.println("3. Add Methods");
                System.out.println("4. Generate Class");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");

                
                int option = 0 ;
                if (scan.hasNextInt()) {
                    option = scan.nextInt();
                    scan.nextLine();
                    System.out.println("You chose: " + option);
                } else {
                    System.out.println("Invalid input, please enter a number.");
                }

                switch (option) {

                    case ADD_CLASSNAME: className = addClassName(scan);
                    break;

                    case ADD_FIELDS: addFields(scan, className, fields);
                    break;

                    case ADD_METHODS: addMethods(scan, className, methods);
                    break;

                    case GENERATE_CLASS: generateClass(className, fields, methods);
                    break;

                    case EXIT: {
                        System.out.println("Exiting program...");
                        scan.close();
                        return;
                    }

                    default: {
                        System.out.println("Wrong Option!");
                    }
                }

            } 
            catch (NumberFormatException nfe) {
                System.out.println("Error: " + nfe.getMessage()); 
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage()); 
            }

            System.out.print("Press Y to continue to Reflection menu: ");
            choice = scan.nextLine().trim();

        } while (choice.equalsIgnoreCase("Y"));
    }

	public static void generateClass(String className, List<String> fields, List<String> methods) throws Exception {
		if (className == null) {
		    throw new Exception("Class Not Set. Set a class name first!");
		}
		try (FileWriter writer = new FileWriter("Test.java")) {
		    writer.write("package com.reflections;\n\n");
		    writer.write("public class " + className + " {\n\n");

		    for (String f : fields) {
		        writer.write("    " + f + "\n");
		    }
		    writer.write("\n");

		    for (String m : methods) {
		        writer.write("    " + m + "\n\n");
		    }

		    writer.write("}\n");
		    System.out.println("Class file Test.java generated successfully!");
		} catch (IOException e) {
		    System.out.println("Error writing file: " + e.getMessage());
		}
	}

	public static void addMethods(Scanner scan, String className, List<String> methods) throws Exception {
		if (className == null) {
		    throw new Exception("Class Not Set. Set a class name first!");
		}
		String methodChoice;
		do {
		    System.out.print("Enter method return type: ");
		    String returnType = scan.nextLine().trim();
		    System.out.print("Enter method name: ");
		    String methodName = scan.nextLine().trim();

		    String methodCode = "public " + returnType + " " + methodName + "() {\n"
		            + "    System.out.println(\"Method Body\");" + "\n}";
		    methods.add(methodCode);
		    System.out.println("Method added: " + methodName);

		    System.out.print("Add more methods? (Y/N): ");
		    methodChoice = scan.nextLine();
		} while (methodChoice.equalsIgnoreCase("Y"));
	}

	public static void addFields(Scanner scan, String className, List<String> fields) throws Exception {
		if (className == null) {
		    throw new Exception("Class Not Set. Set a class name first!");
		                                
		}
		String fieldChoice;
		do {
		    System.out.print("Enter field type (e.g., String, int): ");
		    String type = scan.nextLine().trim();
		    System.out.print("Enter field name: ");
		    String name = scan.nextLine().trim();
		    fields.add("public " + type + " " + name + ";");
		    System.out.println("Field added: " + type + " " + name);

		    System.out.print("Add more fields? (Y/N): ");
		    fieldChoice = scan.nextLine();
		} while (fieldChoice.equalsIgnoreCase("Y"));
	}

	public static String addClassName(Scanner scan) {
		String className;
		System.out.print("Enter a class name: ");
		className = scan.nextLine().trim();
		System.out.println("Class name set to: " + className);
		return className;
	}
}

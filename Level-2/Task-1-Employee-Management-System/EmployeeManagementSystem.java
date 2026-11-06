import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    // Add Employee
    public static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = input.nextInt();
        input.nextLine();

        // Check duplicate ID
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println("Employee ID already exists!");
                return;
            }
        }

        System.out.print("Enter Employee Name: ");
        String name = input.nextLine();

        System.out.print("Enter Department: ");
        String department = input.nextLine();

        System.out.print("Enter Salary: ");
        double salary = input.nextDouble();

        if (salary < 0) {
            System.out.println("Salary cannot be negative!");
            return;
        }

        Employee emp = new Employee(id, name, department, salary);
        employees.add(emp);

        System.out.println("Employee added successfully!");
    }

    // View Employees
    public static void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employee records found.");
            return;
        }

        System.out.println("\n========== EMPLOYEE RECORDS ==========");

        for (Employee emp : employees) {
            System.out.println("ID: " + emp.getId());
            System.out.println("Name: " + emp.getName());
            System.out.println("Department: " + emp.getDepartment());
            System.out.println("Salary: " + emp.getSalary());
            System.out.println("--------------------------------------");
        }
    }

    // Update Employee
    public static void updateEmployee() {

        System.out.print("Enter Employee ID to update: ");
        int id = input.nextInt();
        input.nextLine();

        for (Employee emp : employees) {

            if (emp.getId() == id) {

                System.out.print("Enter New Name: ");
                String name = input.nextLine();

                System.out.print("Enter New Department: ");
                String department = input.nextLine();

                System.out.print("Enter New Salary: ");
                double salary = input.nextDouble();

                if (salary < 0) {
                    System.out.println("Salary cannot be negative!");
                    return;
                }

                emp.setName(name);
                emp.setDepartment(department);
                emp.setSalary(salary);

                System.out.println("Employee updated successfully!");
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    // Delete Employee
    public static void deleteEmployee() {

        System.out.print("Enter Employee ID to delete: ");
        int id = input.nextInt();

        for (Employee emp : employees) {

            if (emp.getId() == id) {
                employees.remove(emp);
                System.out.println("Employee deleted successfully!");
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    // Main Method
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n====================================");
            System.out.println("     EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    updateEmployee();
                    break;

                case 4:
                    deleteEmployee();
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        input.close();
    }
}

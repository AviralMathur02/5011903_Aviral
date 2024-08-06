public class EmployeeManagement {
    private Employee[] employees;
    private int size;

    // Constructor to initialize the employee array
    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Employee array is full. Cannot add more employees.");
        }
    }

    // Method to search for an employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null; // Employee not found
    }

    // Method to traverse and display all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Method to delete an employee by ID
    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                // Shift remaining elements to the left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null; // Nullify the last element
                return true;
            }
        }
        return false; // Employee not found
    }

    public static void main(String[] args) {
        // Initialize EmployeeManagement with a capacity of 10 employees
        EmployeeManagement management = new EmployeeManagement(10);

        // Add employees
        management.addEmployee(new Employee(1, "Alice", "Manager", 75000));
        management.addEmployee(new Employee(2, "Bob", "Developer", 60000));
        management.addEmployee(new Employee(3, "Charlie", "Designer", 50000));

        // Traverse and display all employees
        System.out.println("All Employees:");
        management.traverseEmployees();

        // Search for an employee
        System.out.println("\nSearch for Employee with ID 2:");
        Employee employee = management.searchEmployee(2);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }

        // Delete an employee
        System.out.println("\nDelete Employee with ID 3:");
        boolean deleted = management.deleteEmployee(3);
        if (deleted) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }

        // Traverse and display all employees after deletion
        System.out.println("\nAll Employees after deletion:");
        management.traverseEmployees();
    }
}

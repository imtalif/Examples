// Base Class: Employee
class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }

    double calculateSalary() {
        return 0; // will be overridden
    }
}

// Subclass: FullTimeEmployee
class FullTimeEmployee extends Employee {
    double monthlySalary;

    FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Employee Type: Full-Time");
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

// Subclass: PartTimeEmployee
class PartTimeEmployee extends Employee {
    int hoursWorked;
    double ratePerHour;

    PartTimeEmployee(String name, int id, int hoursWorked, double ratePerHour) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Employee Type: Part-Time");
        System.out.println("Hours Worked: " + hoursWorked);
    }

    @Override
    double calculateSalary() {
        return hoursWorked * ratePerHour;
    }
}

// Subclass: Intern
class Intern extends Employee {
    double stipend;

    Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Employee Type: Intern");
        System.out.println("Stipend: " + stipend);
    }

    @Override
    double calculateSalary() {
        return stipend;
    }
}

// Main Class
public class PayrollSystem {
    public static void main(String[] args) {

        Employee[] employees = new Employee[3];

        employees[0] = new FullTimeEmployee("Alice", 101, 50000);
        employees[1] = new PartTimeEmployee("Bob", 102, 90, 150);
        employees[2] = new Intern("Charlie", 103, 8000);

        for (Employee emp : employees) {
            emp.displayInfo();
            System.out.println("Salary: " + emp.calculateSalary());
            System.out.println();
        }
    }
}


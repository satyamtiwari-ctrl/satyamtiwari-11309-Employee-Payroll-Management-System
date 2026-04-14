import java.util.Scanner;

// Base Class
class Employee {
    String name;
    int id;
    double baseSalary;

    Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    double calculateSalary() {
        return baseSalary;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + calculateSalary());
        System.out.println("---------------------------");
    }
}

// Full-Time Employee
class FullTimeEmployee extends Employee {
    double bonus;

    FullTimeEmployee(String name, int id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return baseSalary + bonus;
    }
}

// Part-Time Employee
class PartTimeEmployee extends Employee {
    int hoursWorked;
    double hourlyRate;

    PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Main Class
public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Type (1 = Full-Time, 2 = Part-Time): ");
            int type = sc.nextInt();

            if (type == 1) {
                System.out.print("Enter Base Salary: ");
                double baseSalary = sc.nextDouble();

                System.out.print("Enter Bonus: ");
                double bonus = sc.nextDouble();

                employees[i] = new FullTimeEmployee(name, id, baseSalary, bonus);

            } else if (type == 2) {
                System.out.print("Enter Hourly Rate: ");
                double rate = sc.nextDouble();

                System.out.print("Enter Hours Worked: ");
                int hours = sc.nextInt();

                employees[i] = new PartTimeEmployee(name, id, rate, hours);
            } else {
                System.out.println("Invalid type! Skipping...");
                i--; // retry same index
                continue;
            }

            sc.nextLine(); // clear buffer
        }

        System.out.println("\n===== Employee Details =====");
        for (Employee e : employees) {
            e.display();
        }

        sc.close();
    }
}
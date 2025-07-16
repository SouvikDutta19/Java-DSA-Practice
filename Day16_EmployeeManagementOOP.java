class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("👨‍💼 Name: " + name);
        System.out.println("🆔 ID: " + id);
        System.out.println("💰 Salary: ₹" + salary);
    }
}

public class Day16_EmployeeManagementOOP {
    public static void main(String[] args) {
        Employee emp = new Employee("Souvik", 101, 75000);
        emp.displayInfo();
    }
}

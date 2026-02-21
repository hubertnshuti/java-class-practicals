package inheritance;

// The Parent Class (Superclass)
class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void work() {
        System.out.println(name + " is doing general company work.");
    }
}

// The Child Class (Subclass)
// Developer inherits name, salary, and work() from Employee
class Developer extends Employee {
    String programmingLanguage;

    public Developer(String name, double salary, String programmingLanguage) {
        // 'super' calls the Parent's constructor so we don't have to rewrite that logic
        super(name, salary); 
        this.programmingLanguage = programmingLanguage;
    }

    // Overriding: Changing how the parent's method works for this specific child
    @Override
    void work() {
        System.out.println(name + " is writing " + programmingLanguage + " code.");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Employee standardEmployee = new Employee("John", 50000);
        Developer devEmployee = new Developer("Sarah", 80000, "Java");

        standardEmployee.work();
        
        // Sarah inherited work(), but uses her overridden version
        devEmployee.work(); 
        
        // Sarah also inherited the name variable
        System.out.println("The dev's name is: " + devEmployee.name); 
    }
}
import java.util.Scanner;

public class BasicsDemo {
    public static void main(String[] args) {
        // 1. Primitive Data Types
        int age = 22;
        double height = 1.75;
        char grade = 'A';
        boolean isStudent = true;
        
        // String is technically an object, but used like a basic type
        String name = "Test User"; 

        // 2. Arithmetic Operators (+, -, *, /, %)
        int a = 15;
        int b = 4;
        int sum = a + b;
        int remainder = a % b; // Modulo gives the remainder of division

        System.out.println("Sum is: " + sum);
        System.out.println("Remainder of 15 / 4 is: " + remainder);

        // 3. Relational and Logical Operators (>, <, ==, !=, &&, ||)
        boolean isAdult = age >= 18;
        boolean canDrive = isAdult && isStudent;
        System.out.println("Can this person drive? " + canDrive);

        // 4. Taking Terminal Input
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a lucky number: ");
        int luckyNum = input.nextInt();
        
        // Post-increment operator (adds 1)
        luckyNum++; 
        
        System.out.println("Your new lucky number is: " + luckyNum);
        
        input.close();
    }
}
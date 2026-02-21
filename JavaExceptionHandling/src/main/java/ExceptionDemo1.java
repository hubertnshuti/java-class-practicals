import java.util.Scanner;

// 1. Creating a custom exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ExceptionDemo1 {

    // 2. 'throws' warns that this method might spit out an InvalidAgeException
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // 3. 'throw' actually triggers the error
            throw new InvalidAgeException("Age " + age + " is too young!");
        } else {
            System.out.println("Age is valid.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = {10, 20, 30};

        try {
            System.out.print("Enter an age: ");
            int age = input.nextInt();
            
            // This might throw our custom exception
            validateAge(age); 

            System.out.print("Enter an array index (0 to 2): ");
            int index = input.nextInt();
            
            // This might throw an ArrayIndexOutOfBoundsException
            System.out.println("Value at index is: " + numbers[index]);

            // This line won't run if an error happens above it
            System.out.println("Try block finished successfully.");

        } catch (InvalidAgeException e) {
            System.out.println("Caught Custom Error: " + e.getMessage());
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught Array Error: You typed a bad index.");
            
        } catch (Exception e) {
            // Catch-all for anything else (like typing a letter instead of an int)
            System.out.println("Caught a general error: " + e);
            
        } finally {
            // 4. finally ALWAYS runs. Good for closing scanners or network sockets
            System.out.println("Finally block executed. Closing scanner.");
            input.close();
        }
        
        System.out.println("Program continues normally down here.");
    }
}
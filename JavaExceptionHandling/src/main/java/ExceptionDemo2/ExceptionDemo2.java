import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Custom exception that can hold a "cause" for chaining
class AppCrashException extends Exception {
    public AppCrashException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class ExceptionDemo2 {

    static void processFile(String filename) throws AppCrashException {
        
        // 1. Try-with-resources: Scanner is created inside the ()
        // It automatically closes the file when the try block ends, even if it crashes.
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            
            String text = fileScanner.nextLine();
            
            // This might throw a NumberFormatException
            int number = Integer.parseInt(text);
            System.out.println("The number in the file is: " + number);
            
        // 2. Multi-catch: catching two completely unrelated exceptions in one line using |
        } catch (FileNotFoundException | NumberFormatException e) {
            
            System.out.println("Inside multi-catch. File is missing or data is bad.");
            
            // 3. Exception Chaining: throwing a brand new custom exception, 
            // but passing 'e' into it so we don't lose the original stack trace.
            throw new AppCrashException("Failed to process the file.", e);
        }
    }

    public static void main(String[] args) {
        // We are passing a filename that doesn't exist to force a FileNotFoundException
        String dummyFile = "missing_file.txt";

        try {
            processFile(dummyFile);
        } catch (AppCrashException e) {
            System.out.println("\n--- Caught the error in main ---");
            System.out.println("High-level message: " + e.getMessage());
            
            // 4. getCause() pulls out the original FileNotFoundException we attached
            System.out.println("Original Root Cause: " + e.getCause());
        }
    }
}
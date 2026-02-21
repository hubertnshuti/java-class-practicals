public class ArrayAndMethodsDemo {

    // 1. A basic method that takes a parameter and returns no value (void)
    static void sayHello(String name) {
        System.out.println("Hello there, " + name);
    }

    // 2. A method that takes parameters and returns an integer
    static int multiplyNumbers(int num1, int num2) {
        return num1 * num2;
    }

    // 3. Method Overloading: Same method name, but different parameter types
    static double multiplyNumbers(double num1, double num2) {
        return num1 * num2;
    }

    // 4. A method that takes an array as a parameter
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // MAIN METHOD - Where the program actually starts
    public static void main(String[] args) {
        
        // Calling our simple methods
        sayHello("Student");
        
        int product1 = multiplyNumbers(5, 4);
        double product2 = multiplyNumbers(2.5, 4.0);
        
        System.out.println("Integer multiplication: " + product1);
        System.out.println("Double multiplication: " + product2);

        // 5. 1D Array Declaration and Initialization
        int[] myNumbers = {10, 20, 30, 40, 50};
        System.out.print("My 1D Array: ");
        printArray(myNumbers); // Passing the array to our method

        // Modifying an array element
        myNumbers[0] = 99;
        System.out.println("Modified first element: " + myNumbers[0]);

        // 6. 2D Array (An array of arrays, like a grid)
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Printing a 2D Array:");
        // Nested loops are required to go through rows and columns
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println(); 
        }
    }
}
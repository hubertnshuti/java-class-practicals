public class ControlFlowDemo {
    public static void main(String[] args) {
        
        // 1. If - Else If - Else
        int score = 85;
        
        if (score >= 90) {
            System.out.println("You got an A");
        } else if (score >= 80) {
            System.out.println("You got a B");
        } else {
            System.out.println("You need to study more");
        }

        // 2. Switch Statement (Good for specific matching values)
        int dayOfWeek = 3;
        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Some other day");
        }

        // 3. For Loop (Best when you know exactly how many times to loop)
        System.out.println("For Loop Counting:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // Skips the rest of the code for i=3, jumps to i=4
            }
            System.out.println("Count: " + i);
        }

        // 4. While Loop (Best when you don't know how many times it will run)
        System.out.println("While Loop:");
        int counter = 10;
        while (counter > 0) {
            System.out.print(counter + " ");
            counter -= 3; // Subtracts 3 each time
        }
        System.out.println(); // Just prints a new line

        // 5. Do-While Loop (Guarantees the code runs AT LEAST once)
        System.out.println("Do-While Loop:");
        int x = 100;
        do {
            System.out.println("This runs even though x is 100!");
            x++;
        } while (x < 10); // Condition is false, so it stops after one run
    }
}
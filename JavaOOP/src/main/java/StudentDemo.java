// 1. The Blueprint (Class)
// Notice it is NOT public, so we can keep it in the same file as our main class.
class Student {
    // Attributes (State)
    String name;
    int age;
    String favoriteLanguage;

    // Methods (Behavior)
    void introduce() {
        System.out.println("Hi, I am " + name + ", I am " + age + " years old.");
    }

    void code() {
        System.out.println(name + " is writing code in " + favoriteLanguage + ".");
    }
}

// 2. The Main Program
public class StudentDemo {
    public static void main(String[] args) {
        
        // Creating the first object (Instance)
        Student student1 = new Student();
        student1.name = "Alice";
        student1.age = 20;
        student1.favoriteLanguage = "Java";

        // Creating the second object
        Student student2 = new Student();
        student2.name = "Bob";
        student2.age = 22;
        student2.favoriteLanguage = "C++";

        // Calling their methods
        student1.introduce();
        student1.code();
        
        System.out.println("---");
        
        student2.introduce();
        student2.code();
    }
}
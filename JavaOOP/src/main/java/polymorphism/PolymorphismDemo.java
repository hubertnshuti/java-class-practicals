package polymorphism;

// Abstract class: A partial blueprint. You cannot say 'new Device()'.
// It only exists to be a parent to other classes.
abstract class Device {
    String brand;
    
    public Device(String brand) {
        this.brand = brand;
    }

    // Abstract method: No body {}. Every child MUST create their own version of this.
    abstract void turnOn(); 
}

class Phone extends Device {
    public Phone(String brand) {
        super(brand);
    }

    @Override
    void turnOn() {
        System.out.println("Holding the side button... " + brand + " phone is booting up.");
    }
}

class Laptop extends Device {
    public Laptop(String brand) {
        super(brand);
    }

    @Override
    void turnOn() {
        System.out.println("Pressing power key... " + brand + " laptop fans are spinning.");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        
        // POLYMORPHISM IN ACTION:
        // We declare an array of type 'Device' (the parent).
        // But we fill it with Phones and Laptops (the children).
        Device[] myDevices = new Device[2];
        myDevices[0] = new Phone("Pixel");
        myDevices[1] = new Laptop("ThinkPad");

        // We can loop through them as generic "Devices", 
        // but Java knows to call the specific turnOn() for each object.
        for (int i = 0; i < myDevices.length; i++) {
            myDevices[i].turnOn();
        }
    }
}
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try {
            // 1. Connect to the server
            Socket s = new Socket("localhost", 6666);
            
            // 2. Setup data streams for two-way communication
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
            Scanner scanner = new Scanner(System.in);

            String clientMessage = "";
            String serverMessage = "";

            // 3. Loop for continuous two-way communication
            while (!clientMessage.equals("stop")) {
                // Client types and sends message first
                System.out.print("Enter message: ");
                clientMessage = scanner.nextLine();
                dout.writeUTF(clientMessage);
                dout.flush();

                // Read server's reply
                serverMessage = (String)dis.readUTF();
                System.out.println("Server says: " + serverMessage);
            }

            // 4. Close connection
            s.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) {
        try {
            // 1. Start the server on port 6666
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server started. Waiting for client...");
            
            // 2. Establish connection
            Socket s = ss.accept(); 
            System.out.println("Client connected!");

            // 3. Setup data streams for two-way communication
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            String clientMessage = "";
            String serverMessage = "";

            // 4. Loop for continuous two-way communication
            while (!clientMessage.equals("stop")) {
                // Read client's message first
                clientMessage = (String)dis.readUTF();
                System.out.println("Client says: " + clientMessage);

                // Server types and sends reply
                System.out.print("Enter reply: ");
                serverMessage = scanner.nextLine();
                dout.writeUTF(serverMessage);
                dout.flush();
            }

            // 5. Close connection
            ss.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
import java.io.*;
import java.net.*;

public class asender {
    public static void main(String[] args) {
        try {
            // Create a server socket that listens on port 6666
            ServerSocket ss = new ServerSocket(6666);

            // Wait for a client to connect and establish a connection
            Socket s = ss.accept(); // establishes connection
            
            // Create DataInputStream to read data from the client
            DataInputStream dis = new DataInputStream(s.getInputStream());
            
            // Read the UTF string sent by the client
            String str = dis.readUTF();
            
            // Print the message received from the client
            System.out.println("Message sent by client = " + str);
            
            // Close the server socket (not necessary in this case)
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

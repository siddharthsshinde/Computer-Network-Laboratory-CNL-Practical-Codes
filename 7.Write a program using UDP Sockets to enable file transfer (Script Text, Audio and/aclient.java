import java.io.*;
import java.net.*;

public class aclient {
    public static void main(String[] args) {
        try {
            // Connect to the server on localhost at port 6666
            Socket s = new Socket("localhost", 6666);
            
            // Create DataOutputStream to send data to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            
            // Write the UTF string "4" to the server
            dout.writeUTF("4");
            
            // Flush the stream to ensure the data is sent
            dout.flush();
            
            // Close the output stream and socket
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


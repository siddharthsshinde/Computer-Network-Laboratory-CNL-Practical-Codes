import java.net.*;

public class Receiver {
    public static void main(String[] args) throws Exception {
        // Create a DatagramSocket for receiving data on port 6666
        DatagramSocket ds = new DatagramSocket(6666);
        
        // Buffer to store received data
        byte[] buf = new byte[1024];
        
        // Create a DatagramPacket to receive data into the buffer
        DatagramPacket dp = new DatagramPacket(buf, 1024);
        
        // Receive the DatagramPacket
        ds.receive(dp);
        
        // Convert the received data to a String
        String str = new String(dp.getData(), 0, dp.getLength());
        
        // Print the received message
        System.out.println(str);
        
        // Close the DatagramSocket
        ds.close();
    }
}

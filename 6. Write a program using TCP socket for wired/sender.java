import java.net.*;

public class sender{
    public static void main(String[] args) throws Exception {
        // Create a DatagramSocket for sending data
        DatagramSocket ds = new DatagramSocket();
        
        // Message to be sent
        String str = "Welcome java";
        
        // Destination IP address (localhost in this case)
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        
        // Create a DatagramPacket with the message, length, destination IP, and port
        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 6666);
        
        // Send the DatagramPacket
        ds.send(dp);
        
        // Close the DatagramSocket
        ds.close();
    }
}

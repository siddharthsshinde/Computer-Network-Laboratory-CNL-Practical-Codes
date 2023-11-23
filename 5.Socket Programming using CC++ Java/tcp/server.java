import java.net.*;
import java.io.*;
import java.util.*;

class TcpDateServer {
    public static void main(String arg[]) {
        ServerSocket ss = null;
        Socket cs;
        PrintStream ps;
        BufferedReader dis;
        String inet;

        try {
            // Create a server socket on port 4444
            ss = new ServerSocket(4444);
            System.out.println("Press Ctrl+C to quit");

            while (true) {
                // Wait for a client to connect
                cs = ss.accept();

                // Create a PrintStream to send data to the client
                ps = new PrintStream(cs.getOutputStream());

                // Get the current date and time
                Date d = new Date();

                // Send the date and time to the client
                ps.println(d);

                // Create a BufferedReader to read data from the client
                dis = new BufferedReader(new InputStreamReader(cs.getInputStream()));

                // Read the client's system/IP address
                inet = dis.readLine();
                System.out.println("Client System/IP address is: " + inet);

                // Close the streams and socket for this client
                ps.close();
                dis.close();
            }
        } catch (IOException e) {
            System.out.println("The exception is: " + e);
        }
    }
}

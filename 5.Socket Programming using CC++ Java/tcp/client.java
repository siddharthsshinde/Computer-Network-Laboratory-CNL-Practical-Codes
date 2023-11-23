import java.net.*;
import java.io.*;

class TcpDateClient {
    public static void main(String args[]) {
        Socket soc;
        BufferedReader dis;
        String sdate;
        PrintStream ps;

        try {
            // Get the local InetAddress
            InetAddress ia = InetAddress.getLocalHost();

            // Check if command line arguments are provided
            if (args.length == 0)
                // Create a socket with the local InetAddress if no command line arguments
                soc = new Socket(InetAddress.getLocalHost(), 4444);
            else
                // Create a socket with the specified InetAddress from command line arguments
                soc = new Socket(InetAddress.getByName(args[0]), 4444);

            // Create a BufferedReader to read data from the server
            dis = new BufferedReader(new InputStreamReader(soc.getInputStream()));

            // Read the date/time from the server
            sdate = dis.readLine();
            System.out.println("The date/time on the server is: " + sdate);

            // Create a PrintStream to send data to the server
            ps = new PrintStream(soc.getOutputStream());

            // Send the client's InetAddress (IP address) to the server
            ps.println(ia);

            // Close the PrintStream
            ps.close();
        } catch (IOException e) {
            System.out.println("The exception is: " + e);
        }
    }
}

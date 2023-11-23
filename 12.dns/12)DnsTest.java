package test;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DnsTest {
    public static void main(String[] args) {
        try {
            // Get the InetAddress object for the local host
            InetAddress inetAddress = InetAddress.getLocalHost();
            
            // Display information about the local host
            displayStuff("local host", inetAddress);
            
            // Separator
            System.out.print("--------------------------");

            // Get the InetAddress object for "www.google.com"
            inetAddress = InetAddress.getByName("www.google.com");
            
            // Display information about "www.google.com"
            displayStuff("www.google.com", inetAddress);
            
            // Separator
            System.out.print("--------------------------");

            // Get an array of InetAddress objects for "www.google.com"
            InetAddress[] inetAddressArray = InetAddress.getAllByName("www.google.com");
            
            // Iterate through the array and display information for each address
            for (int i = 0; i < inetAddressArray.length; i++) {
                displayStuff("www.google.com #" + (i + 1), inetAddressArray[i]);
            }
        } catch (UnknownHostException e) {
            // Print the stack trace if an UnknownHostException occurs
            e.printStackTrace();
        }
    }

    // Method to display information about a host
    public static void displayStuff(String whichHost, InetAddress inetAddress) {
        // Separator
        System.out.println("--------------------------");
        
        // Print the identifier of the host
        System.out.println("Which Host:" + whichHost);
        
        // Print the canonical host name
        System.out.println("Canonical Host Name:" + inetAddress.getCanonicalHostName());
        
        // Print the host name
        System.out.println("Host Name:" + inetAddress.getHostName());
        
        // Print the host address
        System.out.println("Host Address:" + inetAddress.getHostAddress());
    }
}

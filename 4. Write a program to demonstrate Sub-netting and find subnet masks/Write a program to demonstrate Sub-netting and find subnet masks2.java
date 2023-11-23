import java.io.*;

public class Subnet1 {

    public static void main(String[] args) throws IOException {

        System.out.println("ENTER IP:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip = br.readLine();

        // Extract the first three characters to determine the class of the IP address
        String checkclass = ip.substring(0, 3);

        int cc = Integer.parseInt(checkclass);
        String mask = null;

        if (cc > 0) {
            if (cc <= 127) {
                mask = "255.0.0.0"; // Class A subnet mask
                System.out.println("Class A IP Address");
            } else if (cc >= 128 && cc <= 191) {
                mask = "255.255.0.0"; // Class B subnet mask
                System.out.println("Class B IP Address");
            } else if (cc >= 192 && cc <= 223) {
                mask = "255.255.255.0"; // Class C subnet mask
                System.out.println("Class C IP Address");
            } else if (cc >= 224 && cc <= 239) {
                mask = "Not Applicable for Class D"; // Class D IP Address (used for multicasting)
                System.out.println("Class D IP Address Used for multicasting");
            } else if (cc >= 240 && cc <= 255) {
                mask = "Not Applicable for Class E"; // Class E IP Address (Experimental Use)
                System.out.println("Class E IP Address Experimental Use");
            }
            if (cc <= 223) {
                System.out.println("SUBNET MASK:\n" + mask);
            }
        }

        if (cc <= 223) {
            String networkAddr = "";
            String lastAddr = "";
            String[] ipAddrParts = ip.split("\\.");
            String[] maskParts = mask.split("\\.");

            // Calculate the network address and last address of the IP block
            for (int i = 0; i < 4; i++) {
                int x = Integer.parseInt(ipAddrParts[i]);
                int y = Integer.parseInt(maskParts[i]);

                // Calculate the network address using bitwise AND operation
                int z = x & y;
                networkAddr += z + ".";

                // Calculate the last address using bitwise OR operation with complement
                int w = z | (y ^ 255);
                lastAddr += w + ".";
            }

            // Print the calculated network and last addresses
            System.out.println("First IP of block: " + networkAddr);
            System.out.println("Last IP of block: " + lastAddr);
        }
    }
}


/*OUTPUT
iotlab@iotlab-Veriton-M200-B360:~$ javac Subnet1.java
iotlab@iotlab-Veriton-M200-B360:~$ java Subnet1
ENTER IP:
226.35.65.23
Class D IP Address Used for multicasting
First IP of block: 226.0.0.0.
Last IP of block: 226.255.255.255.
iotlab@iotlab-Veriton-M200-B360:~$ java Subnet1
ENTER IP:
192.168.100.5
Class C IP Address
SUBNET MASK:
255.255.255.0
First IP of block: 192.168.100.0.
Last IP of block: 192.168.100.255.
iotlab@iotlab-Veriton-M200-B360:~$
*/



// Explanation:

// User Input: The program prompts the user to enter an IP address.

// Determining IP Class and Subnet Mask: Based on the first three characters of the IP address, the program determines the class of the IP address (A, B, C, D, or E) and sets the subnet mask accordingly.

// Network and Last Address Calculation: The program calculates the network address and last address of the IP block using bitwise AND and OR operations with the subnet mask.

// Print Information: The program prints information about the IP address class, subnet mask, and the calculated network and last addresses.

// Subnetting Explanation: Subnetting is the process of dividing a larger IP network into smaller sub-networks. It helps in efficient utilization of IP addresses and provides better control over network traffic. Subnetting involves creating sub-networks with their own unique network addresses and can enhance network security and performance. In this program, the subnet mask is used to determine the network address, and the last address is calculated to represent the end of the IP block for the given subnet.
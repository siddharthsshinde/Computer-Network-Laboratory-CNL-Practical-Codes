// Write a program to demonstrate Sub-netting and find subnet masks

//Enter the IP address: 100.110.150.10
// IP in binary is 01100100011011101001011000001010
// Enter the number of addresses: 7
// Number of bits required for address = 3
// The subnet mask is = 29
// First address is = 100.110.150.8
// Last address is = 100.110.150.15

package abc;
import java.util.Scanner;

class Subnet {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the IP address: "); // Corrected the prompt message
        String ip = sc.nextLine();
        String split_ip[] = ip.split("\\."); // Split the string after every period.
        String split_bip[] = new String[4]; // Split binary IP

        String bip = "";
        for (int i = 0; i < 4; i++) {
            split_bip[i] = appendZeros(Integer.toBinaryString(Integer.parseInt(split_ip[i])));
            // Append zeros to the binary representation of each part of the IP address.
            bip += split_bip[i];
        }

        System.out.println("IP in binary is " + bip);

        System.out.print("Enter the number of addresses: ");
        int n = sc.nextInt();
        int bits = (int) Math.ceil(Math.log(n) / Math.log(2));
        System.out.println("Number of bits required for address = " + bits);
        int mask = 32 - bits;
        System.out.println("The subnet mask is = " + mask);

        int fbip[] = new int[32];
        for (int i = 0; i < 32; i++) {
            fbip[i] = (int) bip.charAt(i) - 48;
            // Convert character '0' or '1' to integer 0 or 1.
        }

        for (int i = 31; i > 31 - bits; i--) {
            fbip[i] &= 0;
            // Get the first address by ANDing last 'bits' with 0.
        }

        String fip[] = {"", "", "", ""};
        for (int i = 0; i < 32; i++) {
            fip[i / 8] = fip[i / 8] + fbip[i];
        }

        System.out.print("First address is = ");
        for (int i = 0; i < 4; i++) {
            System.out.print(Integer.parseInt(fip[i], 2));
            if (i != 3) System.out.print(".");
        }
        System.out.println();

        int lbip[] = new int[32];
        for (int i = 0; i < 32; i++) {
            lbip[i] = (int) bip.charAt(i) - 48;
        }

        for (int i = 31; i > 31 - bits; i--) {
            lbip[i] |= 1;
            // Get the last address by ORing last 'bits' with 1.
        }

        String lip[] = {"", "", "", ""};
        for (int i = 0; i < 32; i++) {
            lip[i / 8] = lip[i / 8] + lbip[i];
        }

        System.out.print("Last address is = ");
        for (int i = 0; i < 4; i++) {
            System.out.print(Integer.parseInt(lip[i], 2));
            if (i != 3) System.out.print(".");
        }
        System.out.println();
    }

    static String appendZeros(String s) {
        String temp = new String("00000000");
        return temp.substring(s.length()) + s;
        // Append zeros to the binary representation to make it 8 bits long.
    }
}

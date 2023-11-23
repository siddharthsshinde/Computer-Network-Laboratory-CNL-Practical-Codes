import java.io.*;
import java.net.*;

class UdpChatClient {
    public static int clientPort = 8040, serverPort = 8050;

    public static void main(String args[]) throws Exception {
        // Create a BufferedReader for reading user input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Create a DatagramSocket for sending and receiving messages on the serverPort
        DatagramSocket clientSocket = new DatagramSocket(serverPort);

        // InetAddress to store the server's IP address
        InetAddress serverIPAddress;

        // String to store the user's input text
        String userText;

        // If no command line arguments are provided, use the local machine as the server
        if (args.length == 0)
            serverIPAddress = InetAddress.getLocalHost();
        else
            // Otherwise, use the specified IP address from the command line arguments
            serverIPAddress = InetAddress.getByName(args[0]);

        // Byte array to hold data to be sent
        byte[] sendData = new byte[1024];

        System.out.println("Press Enter without text to quit");

        // Message handling loop
        while (true) {
            System.out.print("\nEnter text for server: ");
            
            // Read user input from the console
            userText = br.readLine();

            // Convert the user's input text to bytes
            sendData = userText.getBytes();

            // Create a DatagramPacket for sending data to the server on clientPort
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, clientPort);

            // Send the message to the server
            clientSocket.send(sendPacket);

            // If the user enters an empty message, break out of the loop
            if (userText.trim().length() == 0)
                break;

            // Byte array to hold received data
            byte[] receiveData = new byte[1024];

            // Create a DatagramPacket for receiving data
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Receive a message from the server
            clientSocket.receive(receivePacket);

            // Convert the received data to a String
            String serverResponse = new String(receivePacket.getData());

            // Trim any trailing whitespace from the server response
            serverResponse = serverResponse.trim();

            // Print the received message from the server
            System.out.println("From Server <<< " + serverResponse);
        }

        // Close the DatagramSocket
        clientSocket.close();
    }
}

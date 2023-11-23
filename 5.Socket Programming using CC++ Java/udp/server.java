import java.io.*;
import java.net.*;

class UdpChatServer {
    public static int clientPort = 8040, serverPort = 8050;

    public static void main(String args[]) throws Exception {
        // Create a DatagramSocket for receiving messages on the clientPort
        DatagramSocket serverSocket = new DatagramSocket(clientPort);

        // Byte array to hold received and sent data
        byte[] sendData = new byte[1024];

        // Create a BufferedReader for reading user input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Server Ready");

        while (true) {
            // Byte array to hold received data
            byte[] receiveData = new byte[1024];

            // Create a DatagramPacket for receiving data
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Receive a message from a client
            serverSocket.receive(receivePacket);

            // Convert the received data to a String
            String receivedText = new String(receivePacket.getData());

            // Check if the received message is empty (indicating client quitting)
            if (receivedText.trim().length() == 0)
                break;

            // Print the received message from the client
            System.out.println("\nFrom Client <<< " + receivedText);

            // Prompt the user to enter a message for the client
            System.out.print("Msg to Client: ");
            String serverMessage = br.readLine();

            // Get the IP address of the client
            InetAddress clientIPAddress = receivePacket.getAddress();

            // Convert the server message to bytes
            sendData = serverMessage.getBytes();

            // Create a DatagramPacket for sending data to the client on serverPort
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIPAddress, serverPort);

            // Send the message to the client
            serverSocket.send(sendPacket);
        }

        System.out.println("\nClient Quits\n");

        // Close the DatagramSocket
        serverSocket.close();
    }
}

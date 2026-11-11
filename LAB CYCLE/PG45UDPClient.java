import java.net.*;
import java.util.Scanner;

public class PG45UDPClient {
    public static void main(String[] args) {
        String host = "localhost";
        int    port = 5000;

        try {
            // Create UDP socket (no connection needed)
            DatagramSocket socket   = new DatagramSocket();
            InetAddress    address  = InetAddress.getByName(host);
            Scanner        sc       = new Scanner(System.in);

            System.out.println("UDP Client started.");
            System.out.println("Connected to Server at " + host + ":" + port);
            System.out.println("Type your message (type 'bye' to exit):\n");

            byte[] buffer = new byte[1024];

            while (true) {
                // Send message to server
                System.out.print("Client : ");
                String message  = sc.nextLine();
                byte[] sendData = message.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(
                    sendData, sendData.length, address, port);
                socket.send(sendPacket);

                // Receive reply from server
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);

                String reply = new String(receivePacket.getData(), 0, receivePacket.getLength());

                if (reply.equalsIgnoreCase("bye") || message.equalsIgnoreCase("bye")) {
                    System.out.println("Disconnected from server.");
                    break;
                }

                System.out.println("Server : " + reply);
            }

            socket.close();
            sc.close();
            System.out.println("Client socket closed.");

        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
import java.net.*;

public class PG45UDPServer {
    public static void main(String[] args) {
        int port = 5000;

        try {
            // Create UDP socket
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("UDP Server started on port " + port);
            System.out.println("Waiting for messages...\n");

            byte[] buffer = new byte[1024];

            while (true) {
                // Receive packet from client
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetAddress clientAddress = receivePacket.getAddress();
                int         clientPort    = receivePacket.getPort();

                System.out.println("Client [" + clientAddress + ":" + clientPort + "] : " + message);

                if (message.equalsIgnoreCase("bye")) {
                    System.out.println("Client has disconnected.");
                    // Send bye back to client
                    byte[] replyData = "bye".getBytes();
                    DatagramPacket replyPacket = new DatagramPacket(
                        replyData, replyData.length, clientAddress, clientPort);
                    socket.send(replyPacket);
                    break;
                }

                // Send reply to client
                String reply      = "Server received: " + message;
                byte[] replyData  = reply.getBytes();
                DatagramPacket replyPacket = new DatagramPacket(
                    replyData, replyData.length, clientAddress, clientPort);
                socket.send(replyPacket);
                System.out.println("Server replied  : " + reply);
            }

            socket.close();
            System.out.println("Server socket closed.");

        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
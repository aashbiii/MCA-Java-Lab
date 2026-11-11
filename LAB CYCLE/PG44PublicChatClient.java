import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PG44PublicChatClient {
    public static void main(String[] args) {
        String host = "localhost";
        int    port = 5000;

        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connected to Public Chat Server.");

            BufferedReader input  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter    output = new PrintWriter(socket.getOutputStream(), true);
            Scanner        sc     = new Scanner(System.in);

            // Thread to receive messages from server
            Thread receiveThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = input.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });

            // Thread to send messages to server
            Thread sendThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = sc.nextLine()) != null) {
                        output.println(message);
                        if (message.equalsIgnoreCase("bye")) {
                            System.out.println("You left the chat.");
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error sending message.");
                }
            });

            receiveThread.start();
            sendThread.start();

            receiveThread.join();
            sendThread.join();

            socket.close();
            sc.close();

        } catch (IOException | InterruptedException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
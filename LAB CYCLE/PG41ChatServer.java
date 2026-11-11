import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PG41ChatServer {
    public static void main(String[] args) {
        int port = 5000;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");
            System.out.println("Type your message. Type 'bye' to exit.\n");

            BufferedReader input  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter    output = new PrintWriter(socket.getOutputStream(), true);
            Scanner        sc     = new Scanner(System.in);

            String message;

            while (true) {
                // Server sends first
                System.out.print("Server : ");
                message = sc.nextLine();
                output.println(message);

                if (message.equalsIgnoreCase("bye")) {
                    System.out.println("Server has left the chat.");
                    break;
                }

                // Then waits for client reply
                message = input.readLine();
                if (message == null || message.equalsIgnoreCase("bye")) {
                    System.out.println("Client : bye");
                    System.out.println("Client has left the chat.");
                    break;
                }
                System.out.println("Client : " + message);
            }

            input.close();
            output.close();
            socket.close();
            serverSocket.close();
            sc.close();
            System.out.println("Connection closed.");

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
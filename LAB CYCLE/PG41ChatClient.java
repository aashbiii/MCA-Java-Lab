import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PG41ChatClient {
    public static void main(String[] args) {
        String host = "localhost";
        int    port = 5000;

        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connected to Server!");
            System.out.println("Wait for server message, then reply. Type 'bye' to exit.\n");

            BufferedReader input  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter    output = new PrintWriter(socket.getOutputStream(), true);
            Scanner        sc     = new Scanner(System.in);

            String message;

            while (true) {
                // Client waits for server message first
                message = input.readLine();
                if (message == null || message.equalsIgnoreCase("bye")) {
                    System.out.println("Server : bye");
                    System.out.println("Server has left the chat.");
                    break;
                }
                System.out.println("Server : " + message);

                // Then client replies
                System.out.print("Client : ");
                message = sc.nextLine();
                output.println(message);

                if (message.equalsIgnoreCase("bye")) {
                    System.out.println("Client has left the chat.");
                    break;
                }
            }

            input.close();
            output.close();
            socket.close();
            sc.close();
            System.out.println("Connection closed.");

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}

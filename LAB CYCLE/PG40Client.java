import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PG40Client {
    public static void main(String[] args) {
        String host = "localhost";
        int    port = 5000;

        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connected to Server at " + host + ":" + port);
            System.out.println("Type your message (type 'bye' to exit):");

            BufferedReader input  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter    output = new PrintWriter(socket.getOutputStream(), true);
            Scanner        sc     = new Scanner(System.in);

            String clientMessage, serverMessage;

            while (true) {
                System.out.print("Client : ");
                clientMessage = sc.nextLine();
                output.println(clientMessage);

                if (clientMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Client disconnected.");
                    break;
                }

                serverMessage = input.readLine();

                if (serverMessage == null || serverMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Server disconnected.");
                    break;
                }

                System.out.println("Server : " + serverMessage);
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
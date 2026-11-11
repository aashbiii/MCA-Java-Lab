import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PG40Server {
    public static void main(String[] args) {
        int port = 5000;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started. Listening on port " + port + "...");
            System.out.println("Waiting for client to connect...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            BufferedReader input  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter    output = new PrintWriter(socket.getOutputStream(), true);
            Scanner        sc     = new Scanner(System.in);

            String clientMessage, serverMessage;

            while (true) {
                clientMessage = input.readLine();

                if (clientMessage == null || clientMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Client disconnected.");
                    output.println("bye");
                    break;
                }

                System.out.println("Client : " + clientMessage);

                System.out.print("Server : ");
                serverMessage = sc.nextLine();
                output.println(serverMessage);

                if (serverMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Server disconnected.");
                    break;
                }
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
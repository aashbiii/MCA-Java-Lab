import java.io.*;
import java.net.*;
import java.util.*;

public class PG44PublicChatServer {

    // List to keep track of all connected clients
    static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        int port = 5000;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Public Chat Server started on port " + port);
            System.out.println("Waiting for clients...\n");

            // Keep accepting new clients
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress());

                ClientHandler client = new ClientHandler(socket);
                clients.add(client);
                client.start();
            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    // Broadcast message to all connected clients except the sender
    static void broadcast(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    // Remove client from list when disconnected
    static void removeClient(ClientHandler client) {
        clients.remove(client);
        System.out.println(client.name + " disconnected. Active clients: " + clients.size());
    }
}

// Handles each client in a separate thread
class ClientHandler extends Thread {

    Socket         socket;
    BufferedReader input;
    PrintWriter    output;
    String         name;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            input  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            // First message from client is their name
            output.println("Enter your name: ");
            name = input.readLine();
            System.out.println(name + " has joined the chat.");

            // Notify all other clients
            PG44PublicChatServer.broadcast(name + " has joined the chat!", this);
            output.println("Welcome " + name + "! You are now connected.");
            output.println("Type 'bye' to leave the chat.\n");

            String message;

            // Keep receiving and broadcasting messages
            while ((message = input.readLine()) != null) {
                if (message.equalsIgnoreCase("bye")) {
                    PG44PublicChatServer.broadcast(name + " has left the chat.", this);
                    System.out.println(name + " has left the chat.");
                    break;
                }
                System.out.println("[" + name + "] : " + message);
                PG44PublicChatServer.broadcast("[" + name + "] : " + message, this);
            }

        } catch (IOException e) {
            System.out.println(name + " disconnected unexpectedly.");
        } finally {
            PG44PublicChatServer.removeClient(this);
            try { socket.close(); } catch (IOException e) {}
        }
    }

    // Send a message to this client
    public void sendMessage(String message) {
        output.println(message);
    }
}
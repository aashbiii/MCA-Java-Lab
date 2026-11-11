import java.io.*;
import java.net.*;

public class PG42FileServer {
    public static void main(String[] args) {
        int port = 5000;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("File Server started on port " + port);
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            BufferedReader input  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter    output = new PrintWriter(socket.getOutputStream(), true);

            // Receive filename from client
            String fileName = input.readLine();
            System.out.println("Client requested file: " + fileName);

            // Check if file exists
            File file = new File(fileName);

            if (!file.exists()) {
                output.println("ERROR: File not found on server.");
                System.out.println("File not found: " + fileName);
            } else {
                // Send file content line by line
                output.println("SUCCESS");
                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                String line;
                System.out.println("Sending file content...");
                while ((line = fileReader.readLine()) != null) {
                    output.println(line);
                }
                output.println("EOF");   // End of file marker
                fileReader.close();
                System.out.println("File sent successfully.");
            }

            input.close();
            output.close();
            socket.close();
            serverSocket.close();
            System.out.println("Connection closed.");

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
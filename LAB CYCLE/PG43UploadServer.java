import java.io.*;
import java.net.*;

public class PG43UploadServer {
    public static void main(String[] args) {
        int port = 5000;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Upload Server started on port " + port);
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            BufferedReader input  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter    output = new PrintWriter(socket.getOutputStream(), true);

            // Receive filename from client
            String fileName = input.readLine();
            System.out.println("Client is uploading file: " + fileName);

            // Save uploaded content to a new file on server
            String savedFile = "uploaded_" + fileName;
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(savedFile));

            String line;
            int lineCount = 0;

            // Receive file content line by line until EOF
            while ((line = input.readLine()) != null) {
                if (line.equals("EOF")) break;
                fileWriter.write(line);
                fileWriter.newLine();
                lineCount++;
            }

            fileWriter.close();
            System.out.println("File received successfully.");
            System.out.println("Total lines received : " + lineCount);
            System.out.println("File saved as        : " + savedFile);

            // Send acknowledgement to client
            output.println("SUCCESS: File uploaded. Saved as " + savedFile);

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
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PG42FileClient {
    public static void main(String[] args) {
        String host = "localhost";
        int    port = 5000;

        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connected to File Server.");

            BufferedReader input  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter    output = new PrintWriter(socket.getOutputStream(), true);
            Scanner        sc     = new Scanner(System.in);

            // Send filename to server
            System.out.print("Enter filename to download: ");
            String fileName = sc.nextLine();
            output.println(fileName);

            // Read server response
            String response = input.readLine();

            if (response.startsWith("ERROR")) {
                System.out.println(response);
            } else {
                System.out.println("Downloading file: " + fileName);
                System.out.println("--------- File Content ---------");

                // Receive and display file content
                String line;
                StringBuilder fileContent = new StringBuilder();
                while ((line = input.readLine()) != null) {
                    if (line.equals("EOF")) break;
                    System.out.println(line);
                    fileContent.append(line).append("\n");
                }

                System.out.println("--------------------------------");

                // Save downloaded content to a new file
                String downloadedFile = "downloaded_" + fileName;
                BufferedWriter writer = new BufferedWriter(new FileWriter(downloadedFile));
                writer.write(fileContent.toString());
                writer.close();

                System.out.println("File saved as: " + downloadedFile);
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
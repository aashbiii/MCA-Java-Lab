import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PG43UploadClient {
    public static void main(String[] args) {
        String host = "localhost";
        int    port = 5000;

        try {
            Socket socket = new Socket(host, port);
            System.out.println("Connected to Upload Server.");

            BufferedReader input  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter    output = new PrintWriter(socket.getOutputStream(), true);
            Scanner        sc     = new Scanner(System.in);

            // Ask for filename to upload
            System.out.print("Enter filename to upload: ");
            String fileName = sc.nextLine();

            // Check if file exists on client side
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("ERROR: File not found on client.");
                socket.close();
                sc.close();
                return;
            }

            // Send filename to server
            output.println(fileName);

            // Read and send file content line by line
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String line;
            int lineCount = 0;

            System.out.println("Uploading file: " + fileName);
            System.out.println("--------- File Content ---------");

            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
                output.println(line);
                lineCount++;
            }

            output.println("EOF");   // End of file marker
            fileReader.close();

            System.out.println("--------------------------------");
            System.out.println("Total lines sent : " + lineCount);
            System.out.println("Upload complete.");

            // Receive acknowledgement from server
            String ack = input.readLine();
            System.out.println("Server response  : " + ack);

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
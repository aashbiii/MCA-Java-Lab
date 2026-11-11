import java.io.*;
import java.net.*;

public class PG47URLDownload {

    // Method to download file from URL
    static void downloadFile(String urlString) {
        try {
            URL url = new URL(urlString);

            // Extract filename from URL
            String fileName = urlString.substring(urlString.lastIndexOf("/") + 1);
            if (fileName.isEmpty() || !fileName.contains(".")) {
                fileName = "downloaded_file.html";
            }

            System.out.println("URL      : " + urlString);
            System.out.println("Protocol : " + url.getProtocol());
            System.out.println("Host     : " + url.getHost());
            System.out.println("File     : " + fileName);
            System.out.println("------------------------------------------");
            System.out.println("Starting download...");

            // Open connection to URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {

                // Get file size
                long fileSize = connection.getContentLengthLong();
                System.out.println("File Size     : " +
                    (fileSize == -1 ? "Unknown" : formatSize(fileSize)));
                System.out.println("Content Type  : " + connection.getContentType());
                System.out.println("------------------------------------------");

                // Input stream from URL
                InputStream inputStream  = connection.getInputStream();

                // Output stream to save file
                FileOutputStream  outputStream = new FileOutputStream(fileName);

                byte[] buffer     = new byte[4096];
                int    bytesRead;
                long   totalBytes = 0;

                // Read and write in chunks
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                    totalBytes += bytesRead;
                    System.out.print("\rDownloaded: " + formatSize(totalBytes));
                }

                outputStream.close();
                inputStream.close();
                connection.disconnect();

                System.out.println("\nDownload complete!");
                System.out.println("Saved as      : " + fileName);
                System.out.println("Total Size    : " + formatSize(totalBytes));

            } else {
                System.out.println("Download failed. Server returned: " + responseCode);
            }

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL   : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Download error: " + e.getMessage());
        }
    }

    // Helper method to format file size
    static String formatSize(long bytes) {
        if (bytes < 1024)
            return bytes + " B";
        else if (bytes < 1024 * 1024)
            return String.format("%.2f KB", bytes / 1024.0);
        else if (bytes < 1024 * 1024 * 1024)
            return String.format("%.2f MB", bytes / (1024.0 * 1024));
        else
            return String.format("%.2f GB", bytes / (1024.0 * 1024 * 1024));
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("--- URL File Downloader ---\n");
        System.out.print("Enter URL to download: ");
        String urlString = sc.nextLine().trim();

        System.out.println("------------------------------------------");
        downloadFile(urlString);
        System.out.println("------------------------------------------");

        sc.close();
    }
}
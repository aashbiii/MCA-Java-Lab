import java.io.*;
import java.net.*;

public class PG48WebPageContent {

    // Method to format HTML with proper indentation
    static String formatHTML(String html) {
        StringBuilder result  = new StringBuilder();
        int           indent  = 0;
        String        tab     = "    ";  // 4 spaces

        // Split on every tag
        String[] parts = html.split("(?=<)|(?<=>)");

        for (String part : parts) {
            part = part.trim();
            if (part.isEmpty()) continue;

            // Closing tag — reduce indent before printing
            if (part.startsWith("</")) {
                indent--;
                result.append(getIndent(indent, tab)).append(part).append("\n");
            }
            // Self-closing tag or meta/link/br/hr/input
            else if (part.startsWith("<") && (
                part.contains("/>")       ||
                part.startsWith("<meta")  ||
                part.startsWith("<link")  ||
                part.startsWith("<br")    ||
                part.startsWith("<hr")    ||
                part.startsWith("<input") ||
                part.startsWith("<!") )) {
                result.append(getIndent(indent, tab)).append(part).append("\n");
            }
            // Opening tag — print then increase indent
            else if (part.startsWith("<")) {
                result.append(getIndent(indent, tab)).append(part).append("\n");
                indent++;
            }
            // Text content
            else {
                result.append(getIndent(indent, tab)).append(part).append("\n");
            }
        }

        return result.toString();
    }

    // Helper to build indent string
    static String getIndent(int level, String tab) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) sb.append(tab);
        return sb.toString();
    }

    // Method to fetch and display webpage content
    static void displayContent(String urlString) {
        try {
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            connection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");

            int responseCode = connection.getResponseCode();

            System.out.println("URL           : " + urlString);
            System.out.println("Protocol      : " + url.getProtocol());
            System.out.println("Host          : " + url.getHost());
            System.out.println("Response Code : " + responseCode);
            System.out.println("Content Type  : " + connection.getContentType());
            System.out.println("------------------------------------------");

            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

                // Read entire page into string
                StringBuilder rawContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    rawContent.append(line);
                }
                reader.close();
                connection.disconnect();

                // Format and display
                String formatted = formatHTML(rawContent.toString());

                System.out.println("---------- Webpage Content ----------\n");
                System.out.println(formatted);
                System.out.println("-------------------------------------");

                // Save formatted content to file
                String fileName = "webpage_content.html";
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                writer.write(formatted);
                writer.close();

                System.out.println("Content saved : " + fileName);

            } else if (responseCode == HttpURLConnection.HTTP_MOVED_TEMP ||
                       responseCode == HttpURLConnection.HTTP_MOVED_PERM) {
                System.out.println("Page redirected to: " +
                    connection.getHeaderField("Location"));
            } else {
                System.out.println("Failed to fetch. Response: " + responseCode);
            }

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL   : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("--- Webpage Content Viewer ---\n");
        System.out.print("Enter URL: ");
        String urlString = sc.nextLine().trim();

        System.out.println("------------------------------------------");
        displayContent(urlString);
        System.out.println("------------------------------------------");

        sc.close();
    }
}
import java.net.*;

public class PG46URLInfo {
    public static void main(String[] args) {
        try {
            // Test with multiple URLs
            String[] urls = {
                "https://www.google.com/search?q=java",
                "http://www.example.com:8080/docs/index.html",
                "ftp://ftp.example.com/files/sample.txt"
            };

            for (String urlString : urls) {
                System.out.println("==========================================");
                System.out.println("URL      : " + urlString);
                System.out.println("------------------------------------------");

                URL url = new URL(urlString);

                System.out.println("Protocol : " + url.getProtocol());
                System.out.println("Host     : " + url.getHost());
                System.out.println("Port     : " + (url.getPort() == -1 ? "Default (" + url.getDefaultPort() + ")" : url.getPort()));
                System.out.println("Path     : " + (url.getPath().isEmpty() ? "/" : url.getPath()));
                System.out.println("File     : " + (url.getFile().isEmpty() ? "None" : url.getFile()));
                System.out.println("Query    : " + (url.getQuery() == null ? "None" : url.getQuery()));
                System.out.println("Ref      : " + (url.getRef()   == null ? "None" : url.getRef()));
            }

            System.out.println("==========================================");

            // User input URL
            System.out.println("\n--- Enter your own URL ---");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            System.out.print("Enter URL: ");
            String userURL = sc.nextLine();

            URL url = new URL(userURL);

            System.out.println("\nURL Details:");
            System.out.println("------------------------------------------");
            System.out.println("Protocol : " + url.getProtocol());
            System.out.println("Host     : " + url.getHost());
            System.out.println("Port     : " + (url.getPort() == -1 ? "Default (" + url.getDefaultPort() + ")" : url.getPort()));
            System.out.println("Path     : " + (url.getPath().isEmpty() ? "/" : url.getPath()));
            System.out.println("File     : " + (url.getFile().isEmpty() ? "None" : url.getFile()));
            System.out.println("Query    : " + (url.getQuery() == null ? "None" : url.getQuery()));
            System.out.println("Ref      : " + (url.getRef()   == null ? "None" : url.getRef()));
            System.out.println("------------------------------------------");

            sc.close();

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        }
    }
}
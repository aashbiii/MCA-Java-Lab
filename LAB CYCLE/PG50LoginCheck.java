import java.sql.*;
import java.util.Scanner;

public class PG50LoginCheck {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String uname, upass, sql;

        try {
            // Step 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Step 2: Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@//localhost:1521/freepdb1", "ashbiii", "ashbiii");
            System.out.println("Database connected successfully.");

            // Step 3: Create Statement
            Statement st = con.createStatement();

            // Step 4: Get login credentials from user
            System.out.println("\n---------- Login ----------");
            System.out.print("Enter Username : ");
            uname = sc.nextLine();

            System.out.print("Enter Password : ");
            upass = sc.nextLine();

            // Step 5: Query to check record
            sql = "SELECT * FROM login WHERE Uname='" + uname + "' AND Upass='" + upass + "'";

            ResultSet rs = st.executeQuery(sql);

            // Step 6: Check if record exists
            if (rs.next()) {
                System.out.println("\nLogin Successful! Welcome, " + uname + "!");
            } else {
                System.out.println("\nLogin Failed! Invalid Username or Password.");
            }

            // Step 7: Close resources
            rs.close();
            st.close();
            con.close();
            sc.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL error        : " + e.getMessage());
        }
    }
}

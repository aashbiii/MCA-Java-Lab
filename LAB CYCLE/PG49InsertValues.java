import java.sql.*;
import java.util.Scanner;

public class PG49InsertValues {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String no, name, sal, sql;

        try {
            // Step 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("Driver loaded successfully.");

            // Step 2: Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@//localhost:1521/freepdb1", "ashbiii", "ashbiii");
            System.out.println("Database connected successfully.");

            // Step 3: Create Statement
            Statement st = con.createStatement();

            // Step 4: Get input and insert
            char choice;
            int  count = 0;

            do {
                System.out.println("\nEnter Employee Details:");
                System.out.print("Enter the Emp No   : ");
                no = sc.nextLine();

                System.out.print("Enter the Emp Name : ");
                name = sc.nextLine();

                System.out.print("Enter the Emp Salary: ");
                sal = sc.nextLine();

                sql = "INSERT INTO Emp16 VALUES(" + no + ",'" + name + "'," + sal + ")";

                st.executeUpdate(sql);
                count++;
                System.out.println("Record inserted successfully!");

                System.out.print("\nInsert another record? (y/n): ");
                choice = sc.nextLine().charAt(0);

            } while (choice == 'y' || choice == 'Y');

            System.out.println("\nTotal records inserted: " + count);

            // Step 5: Display all records
            System.out.println("\n---------- Emp16 Table ----------");
            System.out.printf("%-10s %-20s %-10s%n", "Emp No", "Emp Name", "Salary");
            System.out.println("------------------------------------------");

            ResultSet rs = st.executeQuery("SELECT * FROM Emp16");
            while (rs.next()) {
                System.out.printf("%-10s %-20s %-10s%n",
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3));
            }
            System.out.println("------------------------------------------");

            // Step 6: Close resources
            rs.close();
            st.close();
            con.close();
            sc.close();
            System.out.println("Connection closed.");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL error        : " + e.getMessage());
        }
    }
}

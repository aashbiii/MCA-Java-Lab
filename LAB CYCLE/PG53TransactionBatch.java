import java.sql.*;
import java.util.Scanner;

public class PG53TransactionBatch {

    // ── a. TRANSACTION ────────────────────────────────────────────────────
    static void transactionDemo(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n========== TRANSACTION DEMO ==========");

        try {
            // Disable auto commit
            con.setAutoCommit(false);
            System.out.println("Auto commit disabled.");

            Statement st = con.createStatement();

            System.out.print("Enter number of records to insert: ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details for record " + i + ":");
                System.out.print("Enter Emp No   : ");
                String no = sc.nextLine();

                System.out.print("Enter Emp Name : ");
                String name = sc.nextLine();

                System.out.print("Enter Emp Sal  : ");
                String sal = sc.nextLine();

                String sql = "INSERT INTO Emp16 VALUES(" + no + ",'" + name + "'," + sal + ")";
                st.executeUpdate(sql);
                System.out.println("Record " + i + " inserted.");
            }

            // Ask user to commit or rollback
            System.out.print("\nDo you want to COMMIT? (y/n): ");
            char choice = sc.nextLine().charAt(0);

            if (choice == 'y' || choice == 'Y') {
                con.commit();
                System.out.println("Transaction COMMITTED successfully!");
            } else {
                con.rollback();
                System.out.println("Transaction ROLLED BACK. No changes saved.");
            }

            // Display records after transaction
            System.out.println("\n---------- Emp16 Table After Transaction ----------");
            System.out.printf("%-10s %-20s %-10s%n", "Emp No", "Emp Name", "Salary");
            System.out.println("--------------------------------------------------");

            ResultSet rs = st.executeQuery("SELECT * FROM Emp16");
            while (rs.next()) {
                System.out.printf("%-10s %-20s %-10s%n",
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3));
            }
            System.out.println("--------------------------------------------------");

            rs.close();
            st.close();

        } catch (SQLException e) {
            // Rollback on error
            con.rollback();
            System.out.println("Error occurred. Transaction ROLLED BACK.");
            System.out.println("SQL error : " + e.getMessage());
        } finally {
            // Re-enable auto commit
            con.setAutoCommit(true);
            System.out.println("Auto commit re-enabled.");
        }
    }

    // ── b. BATCH PROCESSING ───────────────────────────────────────────────
    static void batchDemo(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n========== BATCH PROCESSING DEMO ==========");

        try {
            con.setAutoCommit(false);
            System.out.println("Auto commit disabled.");

            Statement st = con.createStatement();

            System.out.print("Enter number of records to batch insert: ");
            int n = Integer.parseInt(sc.nextLine());

            for (int i = 1; i <= n; i++) {
                System.out.println("\nEnter details for record " + i + ":");
                System.out.print("Enter Emp No   : ");
                String no = sc.nextLine();

                System.out.print("Enter Emp Name : ");
                String name = sc.nextLine();

                System.out.print("Enter Emp Sal  : ");
                String sal = sc.nextLine();

                String sql = "INSERT INTO Emp16 VALUES(" + no + ",'" + name + "'," + sal + ")";

                // Add to batch instead of executing immediately
                st.addBatch(sql);
                System.out.println("Record " + i + " added to batch.");
            }

            System.out.println("\nExecuting batch...");

            // Execute all batched statements at once
            int[] results = st.executeBatch();

            // Commit after batch
            con.commit();

            System.out.println("Batch executed successfully!");
            System.out.println("Total records inserted: " + results.length);

            for (int i = 0; i < results.length; i++) {
                System.out.println("Record " + (i + 1) + " : " +
                    (results[i] > 0 ? "Inserted" : "Failed"));
            }

            // Display records after batch
            System.out.println("\n---------- Emp16 Table After Batch ----------");
            System.out.printf("%-10s %-20s %-10s%n", "Emp No", "Emp Name", "Salary");
            System.out.println("--------------------------------------------------");

            ResultSet rs = st.executeQuery("SELECT * FROM Emp16");
            while (rs.next()) {
                System.out.printf("%-10s %-20s %-10s%n",
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3));
            }
            System.out.println("--------------------------------------------------");

            rs.close();
            st.close();

        } catch (BatchUpdateException e) {
            con.rollback();
            System.out.println("Batch error. Transaction ROLLED BACK.");
            System.out.println("Batch error : " + e.getMessage());
        } catch (SQLException e) {
            con.rollback();
            System.out.println("Error occurred. Transaction ROLLED BACK.");
            System.out.println("SQL error   : " + e.getMessage());
        } finally {
            con.setAutoCommit(true);
            System.out.println("Auto commit re-enabled.");
        }
    }

    // ── main ──────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        try {
            // Step 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Step 2: Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@//localhost:1521/freepdb1", "ashbiii", "ashbiii");
            System.out.println("Database connected successfully.");

            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- MAIN MENU ---");
                System.out.println("1. Transaction");
                System.out.println("2. Batch Processing");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1: transactionDemo(con); break;
                    case 2: batchDemo(con);       break;
                    case 3: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid choice.");
                }

            } while (choice != 3);

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
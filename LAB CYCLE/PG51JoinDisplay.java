import java.sql.*;

public class PG51JoinDisplay {

    public static void main(String[] args) {

        try {
            // Step 1: Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Step 2: Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@//localhost:1521/freepdb1", "ashbiii", "ashbiii");
            System.out.println("Database connected successfully.");

            // Step 3: Create Statement
            Statement st = con.createStatement();

            // Step 4: JOIN query to fetch data from both tables
            String sql = "SELECT e.eno, e.ename, e.esal, d.dname, d.dloc " +
                         "FROM Emp e, Department d " +
                         "WHERE e.dno = d.dno";

            ResultSet rs = st.executeQuery(sql);

            // Step 5: Display results
            System.out.println("\n---------- Employee - Department Details ----------");
            System.out.printf("%-5s %-15s %-12s %-15s %-15s%n",
                              "ENO", "ENAME", "ESAL", "DNAME", "DLOC");
            System.out.println("---------------------------------------------------");

            int count = 0;
            while (rs.next()) {
                System.out.printf("%-5s %-15s %-12s %-15s %-15s%n",
                    rs.getString("eno"),
                    rs.getString("ename"),
                    rs.getString("esal"),
                    rs.getString("dname"),
                    rs.getString("dloc"));
                count++;
            }

            System.out.println("---------------------------------------------------");
            System.out.println("Total Records : " + count);

            // Step 6: Close resources
            rs.close();
            st.close();
            con.close();
            System.out.println("Connection closed.");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL error        : " + e.getMessage());
        }
    }
}
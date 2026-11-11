/*
CREATE OR REPLACE PROCEDURE get_salary(p_eno IN NUMBER, p_sal OUT NUMBER)
AS BEGIN
  SELECT sal INTO p_sal FROM Emp16 WHERE eno = p_eno;
END;
/

CREATE OR REPLACE PROCEDURE get_count(p_count OUT NUMBER)
AS BEGIN
  SELECT COUNT(*) INTO p_count FROM Emp16;
END;
/

CREATE OR REPLACE PROCEDURE raise_salary(p_eno IN NUMBER, p_percent IN NUMBER, p_newsal OUT NUMBER)
AS BEGIN
  UPDATE Emp16 SET sal = sal + (sal * p_percent / 100) WHERE eno = p_eno;
  SELECT sal INTO p_newsal FROM Emp16 WHERE eno = p_eno;
END;
/
*/


import java.sql.*;
import java.util.Scanner;

public class PG52CallablePrepared {

    // ── a. PREPARED STATEMENT ─────────────────────────────────────────────
    static void preparedStatementDemo(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);
        String  sql;

        System.out.println("\n========== PREPARED STATEMENT ==========");
        System.out.println("1. Insert Employee");
        System.out.println("2. Update Salary");
        System.out.println("3. Delete Employee");
        System.out.println("4. Search Employee");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {

            // INSERT
            case 1:
                sql = "INSERT INTO Emp16 VALUES(?, ?, ?)";
                PreparedStatement pInsert = con.prepareStatement(sql);

                System.out.print("Enter Emp No   : ");
                pInsert.setInt(1, Integer.parseInt(sc.nextLine()));
                System.out.print("Enter Emp Name : ");
                pInsert.setString(2, sc.nextLine());
                System.out.print("Enter Emp Sal  : ");
                pInsert.setFloat(3, Float.parseFloat(sc.nextLine()));

                int ins = pInsert.executeUpdate();
                if (ins > 0)
                    System.out.println("Record inserted successfully!");
                pInsert.close();
                break;

            // UPDATE
            case 2:
                sql = "UPDATE Emp16 SET esal = ? WHERE eno = ?";
                PreparedStatement pUpdate = con.prepareStatement(sql);

                System.out.print("Enter Emp No      : ");
                int updateNo = Integer.parseInt(sc.nextLine());
                System.out.print("Enter New Salary  : ");
                float newSal = Float.parseFloat(sc.nextLine());

                pUpdate.setFloat(1, newSal);
                pUpdate.setInt  (2, updateNo);

                int upd = pUpdate.executeUpdate();
                if (upd > 0)
                    System.out.println("Salary updated successfully!");
                else
                    System.out.println("Employee not found.");
                pUpdate.close();
                break;

            // DELETE
            case 3:
                sql = "DELETE FROM Emp16 WHERE eno = ?";
                PreparedStatement pDelete = con.prepareStatement(sql);

                System.out.print("Enter Emp No to delete: ");
                pDelete.setInt(1, Integer.parseInt(sc.nextLine()));

                int del = pDelete.executeUpdate();
                if (del > 0)
                    System.out.println("Record deleted successfully!");
                else
                    System.out.println("Employee not found.");
                pDelete.close();
                break;

            // SEARCH
            case 4:
                sql = "SELECT * FROM Emp16 WHERE eno = ?";
                PreparedStatement pSearch = con.prepareStatement(sql);

                System.out.print("Enter Emp No to search: ");
                pSearch.setInt(1, Integer.parseInt(sc.nextLine()));

                ResultSet rs = pSearch.executeQuery();
                if (rs.next()) {
                    System.out.println("\nEmployee Found:");
                    System.out.println("Emp No   : " + rs.getInt   ("eno"));
                    System.out.println("Emp Name : " + rs.getString ("ename"));
                    System.out.println("Emp Sal  : " + rs.getFloat  ("esal"));
                } else {
                    System.out.println("Employee not found.");
                }
                rs.close();
                pSearch.close();
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    // ── b. CALLABLE STATEMENT ─────────────────────────────────────────────
    static void callableStatementDemo(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n========== CALLABLE STATEMENT ==========");
        System.out.println("1. Get Employee Salary  (IN parameter)");
        System.out.println("2. Get Employee Count   (OUT parameter)");
        System.out.println("3. Raise Salary         (IN + OUT parameter)");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {

            // IN parameter — pass empno, get salary
            case 1:
                CallableStatement csSal = con.prepareCall("{call get_salary(?, ?)}");

                System.out.print("Enter Emp No: ");
                int eno = Integer.parseInt(sc.nextLine());

                csSal.setInt(1, eno);                          // IN  parameter
                csSal.registerOutParameter(2, Types.FLOAT);    // OUT parameter

                csSal.execute();

                float salary = csSal.getFloat(2);
                System.out.println("Salary of Emp " + eno + " : " + salary);
                csSal.close();
                break;

            // OUT parameter — get total employee count
            case 2:
                CallableStatement cCount = con.prepareCall("{call get_count(?)}");

                cCount.registerOutParameter(1, Types.INTEGER);  // OUT parameter

                cCount.execute();

                int empCount = cCount.getInt(1);
                System.out.println("Total Employees: " + empCount);
                cCount.close();
                break;

            // IN + OUT parameter — raise salary by percentage
            case 3:
                CallableStatement cRaise = con.prepareCall("{call raise_salary(?, ?, ?)}");

                System.out.print("Enter Emp No       : ");
                int raiseEno = Integer.parseInt(sc.nextLine());
                System.out.print("Enter Raise %      : ");
                float percent = Float.parseFloat(sc.nextLine());

                cRaise.setInt  (1, raiseEno);                   // IN  parameter
                cRaise.setFloat(2, percent);                    // IN  parameter
                cRaise.registerOutParameter(3, Types.FLOAT);    // OUT parameter

                cRaise.execute();

                float newSalary = cRaise.getFloat(3);
                System.out.println("New Salary of Emp " + raiseEno + " : " + newSalary);
                cRaise.close();
                break;

            default:
                System.out.println("Invalid choice.");
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
                System.out.println("1. Prepared Statement");
                System.out.println("2. Callable Statement");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1: preparedStatementDemo(con); break;
                    case 2: callableStatementDemo(con); break;
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
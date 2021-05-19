package my.uum;

import java.sql.*;

/**
 * This class is for store data in SQLite
 *
 * @author Mohd Shukur Bin Zainol Abidin
 */

public class Database {

    final String[][] submitStudent;
    final String[][] notSubmit;

    /**
     * This method is for inserting data into database.
     *
     * @param submitStudent This is the list of Submitted Student.
     * @param notSubmit This is the list of Not Submitted Student.
     */
    Database(String[][] submitStudent, String[][] notSubmit) {
        this.submitStudent = submitStudent;
        this.notSubmit = notSubmit;
    }

    /**
     * This method is for insert data into Table ListStudent
     */
    public void insert() {
            Connection conn = null;
            String sql = "INSERT INTO ListStudent(Matric,Name,GitHub_Link, Status) VALUES(?,?,?,?)";

            try {
                // db parameters
                String url = "jdbc:sqlite:./Database/Assignment1DB.sqlite";
                // create a connection to the database
                conn = DriverManager.getConnection(url);

                //Insert Submit Data to Sqlite
                    try (
                         PreparedStatement stmt = conn.prepareStatement(sql)) {

                        for (int x = 0; x < submitStudent.length; x++) {
                            stmt.setString(1, submitStudent[x][0]);
                            stmt.setString(2, submitStudent[x][1]);
                            stmt.setString(3, submitStudent[x][2]);
                            stmt.setString(4, "Yes");
                            stmt.executeUpdate();
                        }
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Data is duplicated");
                }

                //Insert NotSubmit to Data Sqlite
                    try (
                            PreparedStatement stmt = conn.prepareStatement(sql)) {
                        for (int y = 0; y < notSubmit.length; y++) {

                            stmt.setString(1, notSubmit[y][1]);
                            stmt.setString(2, notSubmit[y][2]);
                            stmt.setString(3, "Not Submitted");
                            stmt.setString(4, "No");
                            stmt.executeUpdate();
                        }
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Data is duplicated");
                    }
                System.out.println("Connection to SQLite has been established.");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
}

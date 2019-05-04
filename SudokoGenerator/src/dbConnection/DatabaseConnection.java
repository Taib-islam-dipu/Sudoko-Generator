package dbConnection;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class DatabaseConnection {

    Connection connection = null;

    public static Connection ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sudokodb", "root", "");
            //JOptionPane.showMessageDialog(null, "Database Connected Successfully.");
            System.out.println("ConnectDB() OK !!");
            return connection;

        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}

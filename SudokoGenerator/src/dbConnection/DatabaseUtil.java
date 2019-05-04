/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dhrubo
 */
public class DatabaseUtil {
    
     public static ResultSet select(String sql) throws ClassNotFoundException, SQLException {
        return DatabaseConnection.ConnectDB().createStatement().executeQuery(sql);
    }

    public static boolean DML(String sql) throws ClassNotFoundException, SQLException {
        Statement stm=DatabaseConnection.ConnectDB().createStatement();
        int value = stm.executeUpdate(sql);
        stm.close();
        if (value >= 0) {
            return true;
        } else {
            return false;
        }
    }

}

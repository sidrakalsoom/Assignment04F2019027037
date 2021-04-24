
package Sidra_F2019027037;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Sidra Kalsoom
 */
public class Validate {
   public static boolean checkUser(String email,String pass) 
    {
        boolean st =false;
        try {
                
            Connection conn;
            
            String dbURL = "jdbc:sqlserver://DESKTOP-TMPCHSI\\SQLEXPRESS;databaseName=sidra_ass04";
            String userName = "sa";
            String password = "sidra";
            
            conn = DriverManager.getConnection(dbURL, userName, password);
            
            PreparedStatement ps = conn.prepareStatement("select * from tbl_login where email=? and pass=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
            

        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return st;                 
    }   
}
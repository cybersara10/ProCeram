
package proceram;


import java.sql.*;
import javax.swing.*;


public class ProCeram {

    
    Connection conn = null;
ResultSet rs = null;
PreparedStatement pst = null;


public static Connection ConnectDB(){
    try{
 Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");         
String path= "C:\\Program Files\\ceramics\\Ceramics.accdb";  
String ur = "jdbc:ucanaccess://"+path; 
 Connection conn = DriverManager.getConnection(ur);    
        return conn;

    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        return null;
    }
}
    
    
}

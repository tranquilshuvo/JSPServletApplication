package javaDBUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	Connection conn = null;

    public Connection getConnection() {

    	 try {
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","1234");
             //conn = DriverManager.getConnection(url+dbName, userId, password);
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
         return conn;
     }

     public static void closeConnection( Connection toBeClosed ) {
         if( toBeClosed == null )
             return;
         try {
             toBeClosed.close();
         } catch (Exception e) {
             e.printStackTrace();
         }    
 }
	
	
}

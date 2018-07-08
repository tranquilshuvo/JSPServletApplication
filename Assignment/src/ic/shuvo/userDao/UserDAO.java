package ic.shuvo.userDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;


import ic.shuvo.user.User;
import javaDBUtil.DBUtil;


public class UserDAO {
	
	
	DBUtil db = new DBUtil();
    Connection connection = db.getConnection();
	
    public void addUser( User user ) {
        try {
        	String query = "insert into userinfo (userName, userId , password ) values ('"+user.getUserName()+"','"+user.getUserId()+"','"+user.getPassword()+"');";
        	PreparedStatement preparedStatement = connection.prepareStatement( query );
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update userinfo set userName=?, userId=?, password=? where id=?");
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserId());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteUser(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from userinfo where id=?");
      
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        
        try {
        	
        	Statement statement=connection.createStatement();
        	ResultSet rs=statement.executeQuery("select * from userinfo");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setUserId(rs.getString("userId"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public User getUserById(int id) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from userinfo where id=?");
                    
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setUserId(rs.getString("userId"));
                user.setPassword(rs.getString("password"));
                
            }
            rs.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    public  boolean checkUser(String userId,String password) 
    {
     boolean st =false;
     try{
        //PreparedStatement preparedStatement =connection.prepareStatement("select * from userinfo where userId=? and password=?");
        //preparedStatement.setString(1, userId);
        //preparedStatement.setString(2, password);
    	 String sql = "select * from userinfo where userId='"+userId+"' and password='"+password+"';";
    	 
        ResultSet rs =connection.prepareStatement(sql).executeQuery();
    	 
        st = rs.next();
       
     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return st;                 
 }   
}

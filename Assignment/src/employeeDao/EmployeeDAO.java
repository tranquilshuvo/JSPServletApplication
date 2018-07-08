package employeeDao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import employee.Employee;
import javaDBUtil.DBUtil;

public class EmployeeDAO {

	DBUtil db = new DBUtil();
    Connection connection = db.getConnection();
	
    public void addEmployee( Employee employee ) {
        try {
        	String query = "insert into employeeinfo (name, designation , department, userId ) values ('"+employee.getName()+"','"+employee.getDesignation()+"','"+employee.getDepartment()+"','"+employee.getUserId()+"');";
        	System.out.println(query);
        	PreparedStatement preparedStatement = connection.prepareStatement( query );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update employeeinfo set name=?, designation=?, department=?, userId=? where sl=?");
                   
                            
           
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getDesignation());
            preparedStatement.setString(3, employee.getDepartment());
            preparedStatement.setString(4, employee.getUserId());
            preparedStatement.setInt(5, employee.getSl());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteEmployee(int sl) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from employeeinfo where sl=?");
                    
          
            preparedStatement.setInt(1, sl);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        
        try {
        	Statement statement=connection.createStatement();
        	ResultSet rs=statement.executeQuery("select * from employeeinfo");
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setSl(rs.getInt("sl"));
                employee.setName(rs.getString("name"));
                employee.setDesignation(rs.getString("designation"));
                employee.setDepartment(rs.getString("department"));
                employee.setUserId(rs.getString("userId"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    
    public Employee getEmployeeById(int sl) {
    	Employee employee = new Employee();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employeeinfo where sl=?");
                    
            preparedStatement.setInt(1, sl);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	employee.setSl(rs.getInt("sl"));
            	employee.setName(rs.getString("name"));
            	employee.setDesignation(rs.getString("designation"));
                employee.setDepartment(rs.getString("department"));
                employee.setUserId(rs.getString("userId"));
            	
                
            }
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }
    
    
}

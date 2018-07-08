package ic.shuvo.employee;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.Employee;
import employeeDao.EmployeeDAO;

public class EmployeeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	EmployeeDAO dao= new EmployeeDAO();
	
	private static String INSERT_EMPLOYEE = "/employeeAdd.jsp";
    private static String LIST_EMPLOYEE = "/employeeList.jsp";
    private static String EDIT_EMPLOYEE = "/employeeEdit.jsp";
    
    
    public EmployeeController() {
        //super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward = "";
        String action = request.getParameter("action");
        
        
        if( action.equalsIgnoreCase( "delete" ) ) {
            forward = LIST_EMPLOYEE;
            int sl = Integer.parseInt( request.getParameter("sl") );
            dao.deleteEmployee(sl);
            request.setAttribute("employees", dao.getAllEmployees() );
        }
        else if( action.equalsIgnoreCase( "upd" ) ) {
            forward = EDIT_EMPLOYEE;
            int sl = Integer.parseInt( request.getParameter("sl") );
            Employee employee = dao.getEmployeeById(sl);
            request.setAttribute("employees", employee);
        }
        else if( action.equalsIgnoreCase( "list" ) ) {
        	request.setAttribute("employees", dao.getAllEmployees());
            forward = LIST_EMPLOYEE;
        }
        
        else if( action.equalsIgnoreCase( "add" ) ) {
            forward = INSERT_EMPLOYEE;
        }
        else {
            forward = LIST_EMPLOYEE;
        }
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee employee = new Employee();
		employee.setName(request.getParameter("name"));
		employee.setDesignation(request.getParameter("designation"));
		employee.setDepartment(request.getParameter("department"));
		employee.setUserId(request.getParameter("userId"));
		String sl = request.getParameter("sl");
		
		if( sl == null || sl.isEmpty() ){
            dao.addEmployee(employee);
		}
        else {
        	employee.setSl( Integer.parseInt(sl) );
            dao.updateEmployee(employee);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_EMPLOYEE);   
        request.setAttribute("employees", dao.getAllEmployees());
        view.forward(request, response);
	}

}

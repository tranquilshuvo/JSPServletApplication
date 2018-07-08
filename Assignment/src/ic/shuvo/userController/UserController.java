package ic.shuvo.userController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ic.shuvo.user.User;
import ic.shuvo.userDao.UserDAO;


public class UserController extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
	
	UserDAO dao= new UserDAO();   
	private static String INSERT_USER = "/userAdd.jsp";
    private static String LIST_USER = "/userList.jsp";
    private static String EDIT_USER = "/userEdit.jsp";
   
    
    public UserController() {
        //super();
       
    }
      
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
        String action = request.getParameter("action");
   
        if( action.equalsIgnoreCase( "delete" ) ) {
            forward = LIST_USER;
            int id = Integer.parseInt( request.getParameter("id") );
            dao.deleteUser(id);
            request.setAttribute("users", dao.getAllUsers() );
        }
        else if( action.equalsIgnoreCase( "upd" ) ) {
            forward = EDIT_USER;
            int id = Integer.parseInt( request.getParameter("id") );
            User user = dao.getUserById(id);
            request.setAttribute("users", user);
        }
        else if( action.equalsIgnoreCase( "add" ) ) {
            forward = INSERT_USER;
            
        }else if( action.equalsIgnoreCase( "list" ) ) {
        	 request.setAttribute("users", dao.getAllUsers());
             forward = LIST_USER;
        }
        else {
             forward = LIST_USER;
        }
        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward(request, response);
        
       
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setUserId(request.getParameter("userId"));
		user.setPassword(request.getParameter("password"));
		String id = request.getParameter("id");
		
		if( id == null || id.isEmpty() ){
            dao.addUser(user);
		}
        else {
            user.setId( Integer.parseInt(id) );
            dao.updateUser(user);
        }

    RequestDispatcher view = request.getRequestDispatcher(LIST_USER);   
        request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);
	}

}
	


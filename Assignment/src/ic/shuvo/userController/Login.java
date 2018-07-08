package ic.shuvo.userController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import ic.shuvo.userDao.UserDAO;

public class Login extends HttpServlet {
	 UserDAO dao= new UserDAO(); 
	private static final long serialVersionUID = 1L;
	  
    
    public Login() {
        //super();
         
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		
		 if(dao.checkUser(userId, password)){
			 
			 HttpSession session=request.getSession();
			 session.setAttribute("userId", userId);
			 
			 
	            RequestDispatcher rs = request.getRequestDispatcher("home.jsp");
	            rs.forward(request, response);
	        }
	        else
	        {
	           out.println("Username or Password incorrect");
//	           RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
//	           rs.include(request, response);
	           response.sendRedirect("index.jsp");
	        }
		 

	}

}

package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home_controller
 * @author Keshani.A. Bogahawatte
 * IT17139786
 */

public class Home_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(false);
	    String hiddenToken = request.getParameter("myHiddenField");

	    String csrfToken = Login_controller.csrfTokenStore.get(session.getId());

	    if (csrfToken.equals(hiddenToken)) {
	    	
	      response.getWriter().append("Success!");	// displays a success message if the csrf token and the hidden token is equal	            
	    }
	    else {
	      response.getWriter().append("ERROR!"); // displays an error message if the csrf token and the hidden token is not equal	
	    }
	  }
	
}



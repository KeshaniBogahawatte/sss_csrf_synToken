package Servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.Database;
import POJO_Classes.Lambdas;

/**
 * Servlet implementation class Login_controller
 * @author Keshani.A. Bogahawatte
 * IT17139786
 */

public class Login_controller extends HttpServlet {
	
	public static Map<String, String> csrfTokenStore = new HashMap<String, String>();
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    HttpSession session = request.getSession(true); // creates a new session if a current one does not exist

	    if (Database.isValidUser(username, password)) {
	    	
	      String csrfToken = generateCSRFToken(session.getId());
	      System.out.println(csrfToken);
	      csrfTokenStore.put(session.getId(), csrfToken); // adding to token store
	      response.addCookie(Lambdas.COOKIE_WITH_SESSION_ID.apply(session));

	      session.removeAttribute("invalidCredentials");
	      response.sendRedirect("./Home_page.jsp"); // if the entered credentials were valid forward to the home page
	    }
	    else {
	      session.setAttribute("invalidCredentials", "Not_ok");
	      response.sendRedirect("./Login_page.jsp"); // if the entered credentials were invalid return to the login page
	    }
	}

	  private String generateCSRFToken(String strClearText){
		  
	    return strClearText + "." + getRandomString();
	  }

	  private String getRandomString(){
		  
	    UUID randomUuid = UUID.randomUUID(); //creates a random string
	    return randomUuid.toString();
	  }
	
}

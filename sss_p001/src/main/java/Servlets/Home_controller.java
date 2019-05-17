package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 */
public class Home_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(false);
	    String hiddenToken = request.getParameter("myHiddenField");

	    String csrfToken = Login_controller.csrfTokenStore.get(session.getId());

	    if (csrfToken.equals(hiddenToken))
	    {
	      response.getWriter().append("Success!");
	    }
	    else
	    {
	      response.getWriter().append("ERROR!");
	    }
	  }
	}


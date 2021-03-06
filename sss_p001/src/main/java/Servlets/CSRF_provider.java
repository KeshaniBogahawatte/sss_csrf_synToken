package Servlets;

import java.io.IOException;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Keshani.A. Bogahawatte
 * IT17139786
 */
public class CSRF_provider extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
	    if (session != null)
	    {
	      response.setStatus(200);

	      Map<String, String> returnMap = new HashMap<String, String>();
	      returnMap.put("CSRF_key", Login_controller.csrfTokenStore.get(session.getId()));
	      String json = new Gson().toJson(returnMap);
	      response.setContentType("application/json");
	      response.getWriter().write(json);
	    }
	}	

}

package POJO_Classes;

import java.util.function.Function;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * @author Keshani.A. Bogahawatte
 * IT17139786
 */

public class Lambdas {
	
	public static final Function<HttpSession, Cookie> COOKIE_WITH_SESSION_ID = session -> new Cookie("SessionID", session.getId());

}

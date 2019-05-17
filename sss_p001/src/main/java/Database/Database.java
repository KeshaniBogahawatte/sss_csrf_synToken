package Database;

/**
 * @author Keshani.A. Bogahawatte
 * IT17139786
 *
 */
public class Database {
	
	//the login credentials have been hard coded. username="admin" and password="admin"
	private static final String USERNAME = "admin";

	private static final String PASSWORD = "admin";

	public static boolean isValidUser(String username, String password)
	  {
	    return USERNAME.equalsIgnoreCase(username) && PASSWORD.equalsIgnoreCase(password);
	  }

}

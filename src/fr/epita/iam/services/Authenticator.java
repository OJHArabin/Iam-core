package fr.epita.iam.services;

public class Authenticator {
	
	/**
	 * Checking the authentication
	 * @param userName
	 * @param password
	 * @return
	 * @author rabin
	 */
public static boolean authenticate(String userName, String password)
{
		
		return "ojha".equals(userName) && "ojha".equals(password);
}

}

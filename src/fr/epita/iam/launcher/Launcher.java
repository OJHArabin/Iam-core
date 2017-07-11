/**
 * 
 */
package fr.epita.iam.launcher;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.DaoDeleteException;
import fr.epita.iam.exceptions.DaoSaveException;
import fr.epita.iam.exceptions.DaoSearchException;
import fr.epita.iam.exceptions.DaoUpdateException;
import fr.epita.iam.services.Authenticator;

import fr.epita.iam.services.IdentityDAO;
import fr.epita.iam.services.JDBCIdentityDAO;

import fr.epita.ojha.business.Acitivity;

/**
 * @author rabin
 *
 */
public class Launcher {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 * @throws DaoUpdateException 
	 * @throws DaoDeleteException 
	 * @throws DaoSearchException 
	 */
	public static void main(String[] args) throws FileNotFoundException, DaoUpdateException, DaoDeleteException, DaoSearchException
	{

	    System.out.println("WELCOME");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("User name :");
		String userName = scanner.nextLine();
		System.out.println("Password :");
		String password = scanner.nextLine();
		
		if (!Authenticator.authenticate(userName, password)==true) {

		} else {
			System.out.println("Successfully authenticated");
			// We are authenticated
			
			String answer = "";
			while (!"5".equals(answer)) {
              /**
               * crud menu
               */
				System.out.println("1. Create Identity");
				System.out.println("2. Update Identity");
				System.out.println("3. Delete Identity");
				System.out.println("4. Search Identity");
				System.out.println("5. Quit");
				System.out.println("your choice : ");
				


				answer = scanner.nextLine();

				switch (answer) {
				case "1":
					/**
					 * Calling Insert 
					 */
					Acitivity.insert(scanner);
					break;
				case "2":
					/**
					 * Calling Update 
					 */
					Acitivity.update(scanner);
					break;
				case "3":
					/**
					 *Calling  Delete 
					 */
                   
					Acitivity.delete(scanner);
					break;

				case "4":
					/**
					 *Calling Search
					 */
					Acitivity.search(scanner);
					break;

					
				case "5":
					System.out.println("you decided to quit, bye!");
					break;
					
				default:

					System.out.println("unrecognized option : type 1,2,3 or 5 to quit");
					break;
				}

			}

		}

	}

}

package fr.epita.ojha.business;

import java.util.Scanner;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.DaoDeleteException;
import fr.epita.iam.exceptions.DaoSaveException;
import fr.epita.iam.exceptions.DaoSearchException;
import fr.epita.iam.exceptions.DaoUpdateException;
import fr.epita.iam.services.JDBCIdentityDAO;
/**
 * this class alowed to insert,update,search and delete identity
 * @author rabin
 *
 */
public class Acitivity {
    /**
     * this method allowed insert a identity
     * @param scanner
     */
	
	public static void insert(Scanner scanner) {
		System.out.println("Identity Creation");
		System.out.println("please input the identity display name :");
		String displayName  = scanner.nextLine();
		System.out.println("identity email :");
		String email = scanner.nextLine();
		System.out.println("identity uid");
		String uid = scanner.nextLine();
		Identity identity =new Identity(displayName, email, uid);
		try {
			JDBCIdentityDAO dao = new JDBCIdentityDAO();
			dao.insert(identity);
			System.out.println("the save operation completed successfully");
		} catch (DaoSaveException e) {
			System.out.println("the save operation is not able to complete, details :" + e.getMessage());
		}
	}
	/**
	 * this method update previous identity to new
	 * @param scanner
	 * @throws DaoUpdateException
	 */
	
	public static void update(Scanner scanner) throws DaoUpdateException {
		System.out.println("Identity Update");
		System.out.println("Select an identity id you want to change");
		String idtoupdate = scanner.nextLine();
		System.out.println("Enter the new dispaly name");
		String nametochange = scanner.nextLine();
		System.out.println("enter the new email");
		String emailtochange = scanner.nextLine();
		
		Identity identity1 = new Identity( nametochange,emailtochange,idtoupdate);
		JDBCIdentityDAO updateDAO = new JDBCIdentityDAO();
		updateDAO.update(identity1);
	}
	/**
	 * this method help to search identity
	 * @param scanner
	 * @throws DaoSearchException
	 */
	public static void search(Scanner scanner) throws DaoSearchException {
		System.out.println("Identity Search");
		System.out.println("Enter the identity uid to search");
		String idtosearch = scanner.nextLine();
		Identity identity3 = new Identity(null ,null,idtosearch );
		JDBCIdentityDAO searchDAO = new JDBCIdentityDAO();
		System.out.println(searchDAO.search(identity3));
	}
    /**
     * this method delete previously inserted identity
     * @param scanner
     * @throws DaoDeleteException
     */
	public static void delete(Scanner scanner) throws DaoDeleteException {
		System.out.println("Identity Deletion");
		System.out.println("you have selected identity deletion");
		System.out.println("Enter the idnetity uid to delete");
		String idtodelete = scanner.nextLine();
		Identity identity2 = new Identity(null ,null,idtodelete );
		JDBCIdentityDAO deleteDAO = new JDBCIdentityDAO();
		deleteDAO.delete(identity2);
	}

}

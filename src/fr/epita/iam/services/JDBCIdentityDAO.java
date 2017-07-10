/**
 * This is a class that contains all the database operations for the class
 * Identity
 * @author rabin
 */
package fr.epita.iam.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.exceptions.DaoDeleteException;
import fr.epita.iam.exceptions.DaoSaveException;
import fr.epita.iam.exceptions.DaoSearchException;
import fr.epita.iam.exceptions.DaoUpdateException;


public class JDBCIdentityDAO implements IdentityDAO{
	Connection connection;
	public Connection Concurrent;
	/**
	 * @throws SQLException
	 * 
	 */
	public  Connection getconnection() throws SQLException{
			try{
				this.Concurrent.getSchema();
			}
			catch(Exception e){
				String user="ojha";
				String pass="ojha";
				String connectionString = "jdbc:derby://localhost:1527/mynew;create=true";
				this.Concurrent= DriverManager.getConnection(connectionString, user, pass);
			}
			
			return this.Concurrent;
			
			
		}
	
	 /**
	  * method for search
	  */
    
    public List<Identity> search(Identity criteria) throws DaoSearchException {
		List<Identity> returnedList = new ArrayList<Identity>();
		String qry="SELECT * from rabincore where uid=?";
		try (Connection conn = this.getconnection();
			PreparedStatement pstmt = conn
					.prepareStatement(qry)){
			 
			pstmt.setString(1, criteria.getUid());

			ResultSet results = pstmt.executeQuery();

			while (results.next()) {
				String displayName = results.getString("displayname");
				String email = results.getString("email");
				String uid=results.getString("uid");
				returnedList.add(new Identity(displayName,email, uid));

			}
		} catch (SQLException sqle) {
			DaoSearchException daose = new DaoSearchException();
			daose.initCause(sqle);
			throw daose;
		}

		return returnedList;
	    }
	  
	 /**
	  * method for insert
	  */
	 	  
	public void insert(Identity identity) throws DaoSaveException {
	
		String sql = "INSERT INTO rabincore(displayname,email,uid) VALUES(?,?,?)";
		 
        try (Connection conn = this.getconnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, identity.getDisplayName());
            pstmt.setString(2, identity.getEmail());
            pstmt.setString(3, identity.getUid());
            pstmt.executeUpdate();
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		
	}
	/**
	 * method for update
	 */
	
	public void update(Identity identity) throws DaoUpdateException {
		 String sql = "UPDATE rabincore SET displayname = ?, email = ? WHERE uid = ?" ;
	                
	 
	        try (Connection conn = this.getconnection();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	 
	            // set the corresponding param
	            pstmt.setString(1, identity.getDisplayName());
	            pstmt.setString(2, identity.getEmail());
	            pstmt.setString(3, identity.getUid());
	            // update 
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
		
    /**
     * method for delete
     */
	
	public void delete(Identity identity) throws DaoDeleteException { 
		  String sql = "DELETE FROM rabincore WHERE uid = ?";
			 
	        try (Connection conn = this.getconnection();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	 
	            // set the corresponding param
	            pstmt.setString(1, identity.getUid());
	            // execute the delete statement
	            pstmt.executeUpdate();
	 
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	
	/**
	 * this is releasing the database connection, so you should not use this
	 * instance of DAO anymore
	 */
	public void releaseResources() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			System.out.println("SQLException  :" + e);
		}
	}
		
	}


	


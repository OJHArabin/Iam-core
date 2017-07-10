package fr.epita.iam.datamodel;

import java.util.UUID;
/**
 * 
 * @author rabin
 *
 */

public class Identity {
	
	private String displayName;
	private String uid;
	private String email;
	
	
	/**
	 * @param displayName
	 * @param uid
	 * @param email
	 */
	public Identity(String displayName, String email, String uid) {
		this.displayName = displayName;
		this.email = email;
		this.uid = uid;
	}

    /**
     * @return the displayName
     */
	public String getDisplayName() {
		return displayName;
	}
    /**
     * 
     * @param displayName set displayName
     */

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
     /**
      * 
      * @return the getUid
      */

	public String getUid() {
		return uid;
	}
    /**
     * 
     * @param uid set Uid
     */

	public void setUid(String uid) {
		this.uid = uid;
	}
    /**
     * 
     * @return the email
     */

	public String getEmail() {
		return email;
	}

    /**
     * 
     * @param email set Email
     */
	public void setEmail(String email) {
		this.email = email;
	}

    /**
     * returns a string
     */
	@Override
	public String toString() {
		return "Identity [displayName=" + displayName + ", email=" + email + ", uid=" + uid + "]";
	}
	

}

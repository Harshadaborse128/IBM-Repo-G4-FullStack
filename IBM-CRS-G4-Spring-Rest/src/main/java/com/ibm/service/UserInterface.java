/**
 * 
 */
package com.ibm.service;

/**
 * @author 003OQX744
 *
 */
public interface UserInterface {

	public void newuser();
	public Boolean ChangePassword(int iUserType, String iUserID, String iUserPass, String iNewPass);
	public Boolean IsLoginSuccessful(int iUserType, String iUserID, String iUserPass);

}

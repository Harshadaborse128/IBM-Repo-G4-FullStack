/**
 * 
 */
package com.ibm.service;

import java.util.Scanner;

import com.ibm.dao.UserDaoInterface;
import com.ibm.dao.UserDaoService;
import com.ibm.exception.UserNotFound;

/**
 * @author 003OQX744
 *
 */
public class UserService implements UserInterface{
	
	UserDaoInterface ud = new UserDaoService();
	Scanner s = new Scanner(System.in);
	
    /**Method login used for userlogin
    * Method newuser used for new registration
    * Method changepassword for user can change here password
    * @implNote
    */
		
	public void newuser()
	{
		ud.registrationlogin(0, null, null);
	}
	
	public void login(String username,String password) 
	{
		try 
		{
			System.out.println("user not found");
			throw new UserNotFound();			
		}
		catch(UserNotFound error) {
			error.printStackTrace();
		}
	}
	
	public Boolean ChangePassword(int iUserType, String iUserID, String iUserPass, String iNewPass)
	{		   
		return ud.ChangePassword(iUserType, iUserID, iUserPass, iNewPass);
	}
	
	public Boolean IsLoginSuccessful(int iUserType, String iUserID, String iUserPass)
	{		
		return ud.IsLoginSuccessful(iUserType, iUserID, iUserPass);
	}
	
}

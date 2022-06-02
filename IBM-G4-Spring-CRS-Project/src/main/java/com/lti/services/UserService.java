/**
 * 
 */
package com.lti.services;

import java.util.Scanner;

import com.ibm.exception.UserNotFound;
import com.lit.dao.UserDaoInterface;
import com.lit.dao.UserDaoService;

/**
 * @author 003OQX744
 *
 */
public class UserService implements UserInterface{
	UserDaoInterface ud = new UserDaoService();
	Scanner s = new Scanner(System.in);
	
    /**Method portal used for userlogin
    * Method newuser used for new registration
    * @implNote
    */
	public void portal()
	{
		ud.login();
	}
	
	public void newuser()
	{
		ud.registrationlogin();
	}
	
	public void login(String username,String password) {
		try {
			System.out.println("user not found");
			throw new UserNotFound();
			
		}catch(UserNotFound e) {
			
		}
	}
	
	public Boolean ChangePassword()
	{
		System.out.println("Enter the user type:");
		int iUser_Type = s.nextInt();
		s.nextLine();
		
		System.out.println("Enter the user id:");
		String iUser_id = s.nextLine(); 
		
		System.out.println("Enter the user pass:");
		String iPassword = s.nextLine();
		   
		return ud.ChangePassword( iUser_Type, iUser_id, iPassword);
	}
	
	public Boolean IsLoginSuccessful(int iUserType)
	{
		System.out.println("Please Enter Your UserId:");
		String user_id = s.nextLine();
		
		System.out.println("Please Enter Your Password:");
		String user_pass = s.nextLine();
		
		return ud.IsLoginSuccessful(iUserType, user_id, user_pass);
	}
	
}

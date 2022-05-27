/**
 * 
 */
package cob.crs.ibm.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.crs.ibm.dao.UserDaoInterface;
import com.crs.ibm.dao.UserDaoService;
import com.crs.ibm.exception.UserNotFound;
import com.crs.ibm.utils.DButils;

/**
 * @author 003OQX744
 *
 */
public class UserService implements UserInterface {

	/**
	 * @param args
	 * 
	 */
	UserDaoInterface ud = new UserDaoService();
	Scanner s=new Scanner(System.in);
	
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
}



/**
 * 
 */
package com.ibm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.ibm.constant.SqlQueryConstant;
import com.ibm.exception.PasswordMismatch;
import com.ibm.exception.UserNotFound;
import com.ibm.utile.DButils;

/**
 * @author 003OQX744
 *
 */
@Repository
public class UserDaoService implements  UserDaoInterface {
Scanner s=new Scanner(System.in);
	
	
	/**Method IsLoginSuccessful for verification 
	 * Method login for loging user
	 * @exception UserNotFound
	 * @exception PasswordMismatch
	 */
	
public Boolean IsLoginSuccessful(int iUser_type, String iUser_id,String iPassword)
{
	// you can get id and password here
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet result = null;
	Boolean IsUserFound = false;
	
	try {
		conn = DButils.getConnection();
		LocalDate localdate = LocalDate.now();
		LocalTime localtime = LocalTime.now();
		
		// Execute a query
		System.out.println("\nVerifying user login....");
		stmt = conn.prepareStatement(SqlQueryConstant.GET_NEW_USER);
		
		result = stmt.executeQuery();
		System.out.println("Validating your User Id.... ");
		
		while(result.next())
		{
			String user_id=result.getString("user_id");
			if(iUser_id.compareTo(user_id)==0)
			{
				int user_type = result.getInt("user_type");
				if(iUser_type != user_type)
				{
					System.out.println("User type is not matching.\nUser id belongs to other type " + user_type);
					continue;
				}
				System.out.println("Validating your password....");
				String user_password = result.getString("user_pass");
				if(iPassword.compareTo(user_password)==0){
					System.out.println("\nYour id and password is successfully matching database");
					System.out.println("\n Hello " + user_id + " \tDate:" +localdate +" \tTime:" +localtime);
					IsUserFound=true;
					break;
				}
				else
				{
					System.out.println("your id and password is not matching");
					throw new PasswordMismatch();
				}
			}
		}
		stmt.close();
		conn.close();
		if(!IsUserFound)
			throw new UserNotFound();
		}
	catch(PasswordMismatch error){
		//Handle errors for JDBC
		error.printStackTrace();
	}
	catch(UserNotFound error){
		//Handle errors for JDBC
		error.printStackTrace();
		}
	catch(SQLException se){
		//Handle errors for JDBC
		se.printStackTrace();
		}
	catch(Exception e){
		//Handle errors for Class.forName
		e.printStackTrace();
		}
	finally{
		//finally block used to close resources
		try{
			if(stmt!=null)
				stmt.close();
		}
		
		catch(SQLException se2){
			se2.printStackTrace();
			}// nothing we can do
		try{
			if(conn!=null)
				conn.close();
		}
		catch(SQLException se){
			se.printStackTrace();
		}//end finally try
	}//end try
	
	return IsUserFound;
}

/**Method registrationlogin new user can register
 * @SqlQueryConstant SET_INTO_NEW_USER
 */
	
public void registrationlogin(int user_type, String user_id, String user_pass)
{
	Connection conn = null;
	PreparedStatement stmt = null;
	
	try {
		 conn = DButils.getConnection();
		 System.out.println("Creating New registration...");

		 stmt = conn.prepareStatement(SqlQueryConstant.SET_INTO_NEW_USER);
		 System.out.println("You can create your id and password:");
		 
		 stmt.setInt(1, user_type);
		 stmt.setString(2, user_id);
		 stmt.setString(3, user_pass);
		 stmt.setInt(4, 0);
		 
		 int rows = stmt.executeUpdate();
		 System.out.println("Rows impacted : " + rows );
		 
		 stmt.close();
		 conn.close();	
	}
	catch(SQLException se){
		//Handle errors for JDBC
		se.printStackTrace();
		}catch(Exception e){			
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
		   //finally block used to close resources
		try{
			if(stmt!=null)
			   stmt.close();
			}
			catch(SQLException se2){
			se2.printStackTrace();
			}// nothing we can do
		 try{
			 if(conn!=null)
			   conn.close();
			 }
			catch(SQLException se){
			se.printStackTrace();
		 }//end finally try
	 }//end try
}
			
/**Method ChangePassword user change the password
 * * @SqlQueryConstant GET_NEW_USER
 * * @exception UserNotFound
*/
	
public Boolean ChangePassword(int iUser_Type, String iUser_id, String iPassword, String new_pass)
{			
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet result = null;
	Boolean Result = false;
	try {
		conn = DButils.getConnection();
		stmt = conn.prepareStatement(SqlQueryConstant.GET_NEW_USER);
		result = stmt.executeQuery();
		while(result.next())
		{
			String user_id=result.getString("user_id");	
			if(iUser_id.compareTo(user_id)==0)	
			{
				String user_pass = result.getString("user_pass");
				if(false == iPassword.equals(user_pass)) 
				{
					System.out.println("\nOld Password is not match with " + user_pass);
					continue;
				}
					/*
					 * System.out.println("Enter the new password:"); String new_pass =
					 * s.nextLine(); System.out.println("Re-Enter the new password to confirm:");
					 * String new_pass_confirm = s.nextLine();
					 * if(new_pass_confirm.compareTo(new_pass)==0)
					 */
				{
					stmt.executeUpdate(SqlQueryConstant.SET_UPDATE_USER + "'" + new_pass + "' WHERE user_type='" + iUser_Type + "' AND " + "user_id='" + iUser_id + "'");
					System.out.println("your password changed succesfully");
					Result = true;
					break;
				}
				/*
				 * else{ System.out.
				 * println("your new password is not matching. \n Failed to change password.");
				 * throw new UserNotFound(); }
				 */
				}
			
			   }
		stmt.close();
		conn.close();
	} /*
		 * catch(UserNotFound error){ //Handle errors for JDBC error.printStackTrace();
		 * }
		 */
	    catch(SQLException se){
	    	//Handle errors for JDBC
	    	se.printStackTrace();
	    	}catch(Exception e){
	    	//Handle errors for Class.forName
	    		e.printStackTrace();
	    		}finally
	    	{//finally block used to close resources
	    	try{
	    		if(stmt!=null)
	    		stmt.close();
	    		}
	    	catch(SQLException se2){
	    		se2.printStackTrace();
	    		}// nothing we can do
	    	try{
	    		if(conn!=null)
	    		conn.close();
	    		}
	    	catch(SQLException se){
	    		se.printStackTrace();
	    		}//end finally try	
	    	}//end try
	return Result;
	}

}

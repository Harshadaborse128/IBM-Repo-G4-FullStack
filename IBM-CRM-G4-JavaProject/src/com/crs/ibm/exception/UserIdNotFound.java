/**
 * 
 */
package com.crs.ibm.exception;

/**
 * @author 003OQX744
 *
 */
public class UserIdNotFound extends Exception{
	public UserIdNotFound()
	{
		super("User Id Not Found.....");
	}
		
	public UserIdNotFound(String message) 
	{
		super(message);
	}
}
